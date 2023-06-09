package com.ericversteeg.views;

import net.runelite.client.ui.overlay.components.TextComponent;

import java.awt.*;
import java.util.Map;

public class RSTextView extends RSView
{
    private TextComponent textComponent = new TextComponent();
    private FontMetrics fontMetrics;
    private Font font;
    private String text = "";

    public RSTextView(int x, int y, int w, int h, Font font) {
        super(x, y, w, h);

        this.font = font;
    }

    public void setFontMetrics(Graphics2D graphics)
    {
        if (font == null) return;

        graphics.setFont(font);
        this.fontMetrics = graphics.getFontMetrics();
    }

    public void setText(String text)
    {
        this.text = text;
        textComponent.setText(text);
    }

    public void setTextColor(Color color)
    {
        textComponent.setColor(color);
    }

    private int lineWidth = 0;

    @Override
    public int measureWidth(Map<RSLayoutGuide, Integer> guides)
    {
        int strWidth = fontMetrics.stringWidth(text);
        Integer guide = guides.get(RSLayoutGuide.MAX_WIDTH);

        if (guide != null)
        {
            int checkWidth = guide - paddingStart - paddingEnd;
            if (strWidth > checkWidth)
            {
                lineWidth = checkWidth;
            }
            return Math.min(guide, strWidth);
        }

        return paddingStart + strWidth + paddingEnd;
    }

    @Override
    public int measureHeight(Map<RSLayoutGuide, Integer> guides)
    {
        int height = fontMetrics.getHeight();
        if (lineWidth > 0)
        {
            height *= getNumLines(lineWidth);
        }

        return paddingTop + height + paddingBottom;
    }

    @Override
    public void render(Graphics2D graphics, Point origin)
    {
        super.render(graphics, origin);

        renderLines(graphics, lineWidth, new Point(origin.x + x + paddingStart,
                origin.y + y + paddingTop));
    }

    private void renderLines(Graphics2D graphics, int maxWidth, Point start)
    {
        StringBuilder sb = new StringBuilder();
        String [] words = text.split("\\s+");

        int line = 1;
        for (String word: words)
        {
            if (fontMetrics.stringWidth(sb + " " + word) > maxWidth)
            {
                textComponent.setPosition(new Point(start.x,
                        start.y + line * fontMetrics.getHeight()));

                textComponent.setText(sb.toString());
                textComponent.render(graphics);

                sb = new StringBuilder();
                line += 1;
            }
            sb.append(word);
            sb.append(" ");
        }

        textComponent.setPosition(new Point(start.x,
                start.y + line * fontMetrics.getHeight()));

        textComponent.setText(sb.toString());
        textComponent.render(graphics);
    }

    private int getNumLines(int maxWidth)
    {
        StringBuilder sb = new StringBuilder();
        String [] words = text.split("\\s+");

        int lines = 1;

        for (String word: words)
        {
            if (fontMetrics.stringWidth(sb + " " + word) > maxWidth)
            {
                lines += 1;
                sb = new StringBuilder();
            }
            sb.append(word);
            sb.append(" ");
        }

        return lines;
    }
}
