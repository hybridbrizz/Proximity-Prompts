package com.ericversteeg.views;

import jdk.nashorn.internal.objects.annotations.Where;
import net.runelite.client.ui.overlay.components.TextComponent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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

        if (dimensionParams.getW() != WRAP_CONTENT)
        {
            if (guide != null && dimensionParams.getW() == MATCH_PARENT)
            {
                lineWidth = guide - paddingStart - paddingEnd;
                return lineWidth;
            }

            lineWidth = dimensionParams.getW() - paddingStart - paddingEnd;
        }
        else
        {
            lineWidth = strWidth;
        }

        return paddingStart + lineWidth + paddingEnd;
    }

    @Override
    public int measureHeight(Map<RSLayoutGuide, Integer> guides)
    {
        int height = fontMetrics.getHeight();
        height *= getNumLines(lineWidth);

        return paddingTop + height + paddingBottom;
    }

    @Override
    public void render(Graphics2D graphics, Point origin)
    {
        super.render(graphics, origin);

        charRenderLines(graphics, lineWidth, new Point(origin.x + x + paddingStart,
                origin.y + y + paddingTop));
    }

    private void charRenderLines(Graphics2D graphics, int maxWidth, Point start)
    {
        char [] chars = text.replace("\\s+", " ").toCharArray();

        int rx = 0;
        int ry = fontMetrics.getHeight();

        int cIndex = 0;
        int rIndex = 0;

        int spaceWidth = fontMetrics.stringWidth(" ");

        StringBuilder sb = new StringBuilder();

        boolean readColor = false;
        Map<Integer, Color> colorPositions = new HashMap<>();

        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            boolean lastChar = i == chars.length - 1;

            if (readColor)
            {
               colorPositions.put(cIndex, getColor(c));
               readColor = false;

               continue;
            }

            if (c != ' ' && !lastChar)
            {
                if (c == '^')
                {
                    readColor = true;

                    continue;
                }

                sb.append(c);
                cIndex += 1;
            }
            else
            {
                if (c != ' ')
                {
                    sb.append(c);
                    cIndex += 1;
                }

                String word = sb.toString();

                int sw = fontMetrics.stringWidth(word);

                if (rx + sw > maxWidth)
                {
                    //System.out.println("Moving " + word + " onto next line because " + rx + " + " + sw + " > " + maxWidth);

                    rx = 0;
                    ry += fontMetrics.getHeight();
                }

                for (char sc: word.toCharArray())
                {
                    Color color = colorPositions.get(rIndex);
                    if (color != null)
                    {
                        textComponent.setColor(color);
                    }

                    textComponent.setPosition(new Point(start.x + rx,start.y + ry));
                    textComponent.setText(String.valueOf(sc));
                    textComponent.render(graphics);

                    rx += fontMetrics.stringWidth(String.valueOf(sc));
                    rIndex += 1;
                }
                rx += spaceWidth;

                Color color = colorPositions.get(rIndex);
                if (color != null)
                {
                    textComponent.setColor(color);
                }

                cIndex += 1;
                rIndex += 1;

                sb = new StringBuilder();
            }
        }
    }

    private int getNumLines(int maxWidth)
    {
        StringBuilder sb = new StringBuilder();
        String str = Pattern.compile("\\^\\w").matcher(text).replaceAll("");
        String [] words = str.split("\\s+");

        int lines = 1;

        for (String word: words)
        {
            String space = " ";
            if (word.equals(words[words.length - 1]))
            {
                space = "";
            }

            if (fontMetrics.stringWidth(sb + space + word) > maxWidth)
            {
                lines += 1;
                sb = new StringBuilder();
            }
            sb.append(word);
            sb.append(" ");
        }

        return lines;
    }

    Color getColor(char c)
    {
        if (c == 'w')
        {
            return Color.WHITE;
        }
        else if (c == 'b')
        {
            return Color.BLACK;
        }
        else if (c == 'g')
        {
            return Color.GREEN;
        }
        else if (c == 'p')
        {
            return Color.PINK;
        }
        else if (c == 'u')
        {
            return Color.BLUE;
        }
        else if (c == 'c')
        {
            return Color.CYAN;
        }
        else if (c == 'm')
        {
            return Color.MAGENTA;
        }
        else if (c == 'y')
        {
            return Color.YELLOW;
        }
        else if (c == 'r')
        {
            return Color.RED;
        }
        else if (c == 'o')
        {
            return Color.ORANGE;
        }
        return Color.WHITE;
    }
}
