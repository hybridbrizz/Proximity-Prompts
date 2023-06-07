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

        rootView.layout();

        rootView.render(graphics, new Point(rootView.getX(), rootView.getY()));

        return new Dimension(rootView.getW(), rootView.getH());
    }

    public void setRootView(RSViewGroup rootView)
    {
        this.rootView = rootView;
    }
}
