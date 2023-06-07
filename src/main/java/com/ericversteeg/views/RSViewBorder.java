package com.ericversteeg.views;

import java.awt.*;

public class RSViewBorder implements RSRenderable
{
    private RSView view;
    private int width;
    private Color innerColor;
    private Color outerColor;

    public RSViewBorder(RSView view, int width, Color color)
    {
        this.view = view;
        this.width = width;

        outerColor = color;
    }

    public RSViewBorder(RSView view, int width, Color innerColor, Color outerColor)
    {
        this.view = view;
        this.width = width;

        this.innerColor = innerColor;
        this.outerColor = outerColor;
    }

    @Override
    public void render(Graphics2D graphics, Point origin)
    {
        graphics.setColor(outerColor);
        graphics.drawRect(origin.x + view.getX(), origin.y + view.getY(), width, view.getH());

        graphics.setColor(outerColor);
        graphics.drawRect(origin.x + view.getX() - 1, origin.y + view.getY() - 1, view.getW() + 2, view.getH() + 2);

        if (innerColor != null)
        {
            graphics.setColor(innerColor);
            graphics.drawRect(origin.x + view.getX() + 1, origin.y + view.getY() + 1, view.getW() - 2, view.getH() - 2);
        }
    }
}
