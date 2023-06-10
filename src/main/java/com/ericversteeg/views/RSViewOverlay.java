package com.ericversteeg.views;

import com.ericversteeg.RemindersConfig;
import com.ericversteeg.RemindersPlugin;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.awt.*;
import java.time.Instant;

public class RSViewOverlay extends Overlay
{
    private RSViewGroup rootView;

    private RSAnchorType anchorType;
    private Integer anchorX;
    private Integer anchorY;

    private Client client;

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (rootView == null)
        {
            return new Dimension(0, 0);
        }

        //long start = Instant.now().toEpochMilli();

        applyFonts(rootView, graphics);

        rootView.layout();

        if (anchorType != null)
        {
            Widget viewportWidget = getViewportWidget();

            rootView.setX(anchorX);
            rootView.setY(anchorY);

            if (anchorType == RSAnchorType.TOP_RIGHT || anchorType == RSAnchorType.BOTTOM_RIGHT)
            {
                rootView.setX(viewportWidget.getCanvasLocation().getX() + viewportWidget.getWidth() + 28 - anchorX - rootView.getW());
            }

            if (anchorType == RSAnchorType.BOTTOM_LEFT || anchorType == RSAnchorType.BOTTOM_RIGHT)
            {
                rootView.setY(viewportWidget.getCanvasLocation().getY() + viewportWidget.getHeight() + 41 - anchorY - rootView.getH());
            }
        }

        rootView.render(graphics, new Point(0, 0));

        //System.out.println("Render in " + (Instant.now().toEpochMilli() - start) + "ms");

        return new Dimension(rootView.getW(), rootView.getH());
    }

    public void setRootView(RSViewGroup rootView)
    {
        this.rootView = rootView;
    }

    public void setAnchor(Client client, RSAnchorType type, int x, int y)
    {
        this.client = client;

        anchorType = type;

        anchorX = x;
        anchorY = y;
    }

    private void applyFonts(RSView view, Graphics2D graphics)
    {
        if (view instanceof RSViewGroup)
        {
            for (RSView sView: ((RSViewGroup) view).subviews)
            {
                applyFonts(sView, graphics);
            }
        }

        if (view instanceof RSTextView)
        {
            ((RSTextView) view).setFontMetrics(graphics);
        }
    }

    private Widget getViewportWidget()
    {
        Widget widget;

        widget = client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_INTERFACE_CONTAINER);
        if (widget != null) return widget;

        widget = client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INTERFACE_CONTAINER);
        if (widget != null) return widget;

        widget = client.getWidget(WidgetInfo.FIXED_VIEWPORT_INTERFACE_CONTAINER);
        if (widget != null) return widget;

        return client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
    }
}
