package com.ericversteeg.views;

import net.runelite.client.ui.overlay.components.TextComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RSTextView extends RSView
{
    private TextComponent textComponent = new TextComponent();
    private FontMetrics fontMetrics;
    private Font font;
    private String text = "";
    private Color textColor = Color.WHITE;
    private int numLines = 1;
    private int lineHeight = 0;
    private boolean hasImage = false;
    private BufferedImage image;
    private int imageX = 0;
    private int imageY = 0;
    private int imageW = 0;
    private int imageH = 0;
    private RSViewGroup.Gravity imageGravity;
    private boolean animatesColor = false;
    private long animationCycleMillis = 10000L;

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
        textColor = color;
        textComponent.setColor(color);
    }

    public void setImage(BufferedImage image, int width, int height, RSViewGroup.Gravity gravity)
    {
        this.image = image;
        imageW = width;
        imageH = height;
        imageGravity = gravity;
        hasImage = true;
    }

    private int imageX(int imageW, RSViewGroup.Gravity gravity)
    {
        switch (gravity)
        {
            case TOP_START:
            case START:
            case BOTTOM_START:
                return 0;
            case TOP:
            case CENTER:
            case BOTTOM:
                return (w - paddingStart - paddingEnd - imageW) / 2;
            case TOP_END:
            case END:
            case BOTTOM_END:
                return w - paddingStart - paddingEnd - imageW;
        }
        return 0;
    }

    private int imageY(int imageH, RSViewGroup.Gravity gravity)
    {
        switch (gravity)
        {
            case TOP_START:
            case TOP:
            case TOP_END:
                return 0;
            case START:
            case CENTER:
            case END:
                return (h - paddingTop - paddingBottom - imageH) / 2;
            case BOTTOM_START:
            case BOTTOM:
            case BOTTOM_END:
                return h - paddingTop - paddingBottom - imageH;
        }
        return 0;
    }

    public void setAnimatesColor(boolean animatesColor)
    {
        this.animatesColor = animatesColor;
    }

    public void setAnimationCycleDuration(int duration)
    {
        animationCycleMillis = duration * 1000L;
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
        lineHeight = fontMetrics.getHeight();

        if (hasImage)
        {
            numLines = getNumLinesImage(lineWidth);
        }
        else
        {
            numLines = getNumLines(lineWidth);
        }

        int height = lineHeight * numLines;

        return paddingTop + height + paddingBottom;
    }

    @Override
    public void render(Graphics2D graphics, Point origin)
    {
        super.render(graphics, origin);

        if (hasImage)
        {
            charRenderLinesImage(graphics, lineWidth, new Point(origin.x + x + paddingStart,
                    origin.y + y + paddingTop));

            graphics.setColor(Color.GREEN);

            graphics.drawImage(image, origin.x + x + paddingStart + imageX,
                    origin.y + y + paddingTop + imageY, null);

//            graphics.fillRect(origin.x + x + paddingStart + imageX,
//                    origin.y + y + paddingTop + imageY, imageW, imageH);
        }
        else
        {
            charRenderLines(graphics, lineWidth, new Point(origin.x + x + paddingStart,
                    origin.y + y + paddingTop));
        }
    }

    private void charRenderLines(Graphics2D graphics, int maxWidth, Point start)
    {
        char [] chars = text.replace("\\s+", " ").toCharArray();

        int rx = 0;
        int ry = lineHeight;

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
                    ry += lineHeight;
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

    private void charRenderLinesImage(Graphics2D graphics, int maxWidth, Point start)
    {
        char [] chars = text.replace("\\s+", " ").toCharArray();

        int rx = 0;
        int ry = lineHeight;

        int cIndex = 0;
        int rIndex = 0;

        int spaceWidth = fontMetrics.stringWidth(" ");

        StringBuilder sb = new StringBuilder();

        boolean readColor = false;
        Map<Integer, Color> colorPositions = new HashMap<>();

        RSViewGroup.Gravity horizontalGravity = getHorizontalGravity(imageGravity);

        int imageStart = (maxWidth - imageW) / 2;

        imageX = imageX(imageW, imageGravity);
        imageY = imageY(imageH, imageGravity);

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

                boolean isHeightRange = isImageHeightRange(ry - lineHeight);
                if (isHeightRange)
                {
                    if (horizontalGravity == RSViewGroup.Gravity.START)
                    {
                        if (rx < imageW)
                        {
                            rx = imageW + 3;
                        }
                    }
                    else if (horizontalGravity == RSViewGroup.Gravity.CENTER)
                    {
                        if (rx + sw > imageStart - 3)
                        {
                            rx = imageX + imageW + 3;
                        }
                    }
                    else if (horizontalGravity == RSViewGroup.Gravity.END)
                    {
                        if (rx + sw > maxWidth - imageW - 3)
                        {
                            rx = 0;
                            ry += lineHeight;
                        }
                    }
                }

                if (rx + sw > maxWidth)
                {
                    ry += lineHeight;
                    isHeightRange = isImageHeightRange(ry - lineHeight);

                    rx = 0;
                    if (isHeightRange && horizontalGravity == RSViewGroup.Gravity.START)
                    {
                        rx = imageW + 3;
                    }
                }

                for (char sc: word.toCharArray())
                {
                    Color color = colorPositions.get(rIndex);
                    if (color != null)
                    {
                        if (animatesColor)
                        {
                            float percent = (Instant.now().toEpochMilli() % animationCycleMillis) / ((float) animationCycleMillis);

                            Color [] triadicColors = getTriadicColors(color);
                            Color animatedColor = getInterpolatedColor(getColorPair(triadicColors, percent), triadicColors.length, percent);
                            textComponent.setColor(animatedColor);
                        }
                        else
                        {
                            textComponent.setColor(color);
                        }
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
                    if (animatesColor)
                    {
                        float percent = (Instant.now().toEpochMilli() % animationCycleMillis) / ((float) animationCycleMillis);

                        Color [] triadicColors = getTriadicColors(color);
                        Color animatedColor = getInterpolatedColor(getColorPair(triadicColors, percent), triadicColors.length, percent);
                        textComponent.setColor(animatedColor);
                    }
                    else
                    {
                        textComponent.setColor(color);
                    }
                }

                cIndex += 1;
                rIndex += 1;

                sb = new StringBuilder();
            }
        }
    }

    private boolean isImageHeightRange(int y)
    {
        switch (imageGravity)
        {
            case TOP_START:
            case TOP:
            case TOP_END:
                return y < imageH;
            case START:
            case CENTER:
            case END:
                int imageTop = (h - paddingTop - paddingBottom - imageH) / 2;
                return y >= imageTop && y < imageTop + imageH;
            case BOTTOM_START:
            case BOTTOM:
            case BOTTOM_END:
                return y >= h - paddingTop - paddingBottom - imageH;
        }
        return false;
    }

    private RSViewGroup.Gravity getHorizontalGravity(RSViewGroup.Gravity gravity)
    {
        switch (gravity)
        {
            case TOP_START:
            case START:
            case BOTTOM_START:
                return RSViewGroup.Gravity.START;
            case TOP:
            case CENTER:
            case BOTTOM:
                return RSViewGroup.Gravity.CENTER;
            case TOP_END:
            case END:
            case BOTTOM_END:
                return RSViewGroup.Gravity.END;
        }
        return RSViewGroup.Gravity.START;
    }

    private int getNumLines(int maxWidth)
    {
        String str = Pattern.compile("\\^\\w").matcher(text).replaceAll("");

        char [] chars = str.replace("\\s+", " ").toCharArray();

        int rx = 0;
        int lines = 1;

        int spaceWidth = fontMetrics.stringWidth(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            boolean lastChar = i == chars.length - 1;

            if (c != ' ' && !lastChar)
            {
                sb.append(c);
            }
            else
            {
                if (c != ' ')
                {
                    sb.append(c);
                }

                String word = sb.toString();

                int sw = fontMetrics.stringWidth(word);

                if (rx + sw > maxWidth)
                {
                    lines += 1;

                    rx = 0;
                }

                for (char sc: word.toCharArray())
                {
                    rx += fontMetrics.stringWidth(String.valueOf(sc));
                }
                rx += spaceWidth;

                sb = new StringBuilder();
            }
        }
        return lines;
    }

    private int getNumLinesImage(int maxWidth)
    {
        String str = Pattern.compile("\\^\\w").matcher(text).replaceAll("");

        char [] chars = str.replace("\\s+", " ").toCharArray();

        int rx = 0;
        int ry = lineHeight;

        int spaceWidth = fontMetrics.stringWidth(" ");

        StringBuilder sb = new StringBuilder();

        RSViewGroup.Gravity horizontalGravity = getHorizontalGravity(imageGravity);

        int imageStart = (maxWidth - imageW) / 2;

        imageX = imageX(imageW, imageGravity);
        imageY = imageY(imageH, imageGravity);

        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            boolean lastChar = i == chars.length - 1;

            if (c != ' ' && !lastChar)
            {
                sb.append(c);
            }
            else
            {
                if (c != ' ')
                {
                    sb.append(c);
                }

                String word = sb.toString();

                int sw = fontMetrics.stringWidth(word);

                boolean isHeightRange = isImageHeightRange(ry - lineHeight);
                if (isHeightRange)
                {
                    if (horizontalGravity == RSViewGroup.Gravity.START)
                    {
                        if (rx < imageW)
                        {
                            rx = imageW + 3;
                        }
                    }
                    else if (horizontalGravity == RSViewGroup.Gravity.CENTER)
                    {
                        if (rx + sw > imageStart - 3)
                        {
                            rx = imageX + imageW + 3;
                        }
                    }
                    else if (horizontalGravity == RSViewGroup.Gravity.END)
                    {
                        if (rx + sw > maxWidth - imageW - 3)
                        {
                            rx = 0;
                            ry += lineHeight;
                        }
                    }
                }

                if (rx + sw > maxWidth)
                {
                    ry += lineHeight;
                    isHeightRange = isImageHeightRange(ry - lineHeight);

                    rx = 0;
                    if (isHeightRange && horizontalGravity == RSViewGroup.Gravity.START)
                    {
                        rx = imageW + 3;
                    }
                }

                for (char sc: word.toCharArray())
                {
                    rx += fontMetrics.stringWidth(String.valueOf(sc));
                }
                rx += spaceWidth;

                sb = new StringBuilder();
            }
        }

        return ry / lineHeight;
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
        else if (c == '0')
        {
            return textColor;
        }
        return Color.WHITE;
    }

    private Color [] getTriadicColors(Color color)
    {
        float [] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

        float hue = hsb[0];

        float triHue = (hue + 120f) % 360f;
        float triHue2 = (hue + 240f) % 360f;

        Color triColor = Color.getHSBColor(triHue / 360f, hsb[1], hsb[2]);
        Color triColor2 = Color.getHSBColor(triHue2 / 360f, hsb[1], hsb[2]);

        return new Color [] {color, triColor, triColor2};
    }

    private Color [] getColorPair(Color [] colors, float percent)
    {
        int count = colors.length;

        int index = (int) (percent / (1f / colors.length));
        int index2 = (index + 1) % count;

        return new Color [] {colors[index], colors[index2]};
    }

    private Color getInterpolatedColor(Color [] colorPair, int colorCount, float percent)
    {
        float t = (percent % (1f / colorCount) / (1f / colorCount));

        Color sColor = colorPair[0];
        Color eColor = colorPair[1];

        int r = (int) (sColor.getRed() * (1 - t) + eColor.getRed() * t);
        int g = (int) (sColor.getGreen() * (1 - t) + eColor.getGreen() * t);
        int b = (int) (sColor.getBlue() * (1 - t) + eColor.getBlue() * t);

        return new Color(r, g, b);
    }
}
