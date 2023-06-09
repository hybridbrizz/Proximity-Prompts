package com.ericversteeg.views;

import net.runelite.client.ui.overlay.Overlay;

import java.awt.*;

public class RSViewOverlay extends Overlay
{
    private RSViewGroup rootView;

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (rootView == null)
        {
            return new Dimension(0, 0);
        }

        applyFonts(rootView, graphics);

        rootView.layout();

        rootView.render(graphics, new Point(0, 0));

        return new Dimension(rootView.getW(), rootView.getH());
    }

    public void setRootView(RSViewGroup rootView)
    {
        this.rootView = rootView;
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
}
