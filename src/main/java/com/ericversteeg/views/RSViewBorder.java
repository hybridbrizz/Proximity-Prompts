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
    public void render(Graphics2D graphics)
    {
        graphics.setColor(outerColor);
        graphics.drawRect(view.getX(), view.getY(), width, view.getH());

        graphics.setColor(outerColor);
        graphics.drawRect(view.getX() - 1, view.getY() - 1, view.getW() + 2, view.getH() + 2);

        if (innerColor != null)
        {
            graphics.setColor(innerColor);
            graphics.drawRect(view.getX() + 1, view.getY() + 1, view.getW() - 2, view.getH() - 2);
        }
    }
}
