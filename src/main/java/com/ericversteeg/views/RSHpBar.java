package com.ericversteeg.views;

import java.awt.*;

public class RSHpBar extends RSView {

    //#118413
    private Color bottomStartColor = Color.decode("#0F7311");
    private Color bottomEndColor = Color.decode("#0F7311");
    private float [] bottomStops = new float [] {0f, 1f};
    private Color [] bottomColors = new Color [] {bottomStartColor, bottomEndColor};

    private Color topColorOuter = Color.decode("#0d8f0f");
    private Color topColorInner = Color.decode("#14d512");
    private float [] topStops = new float [] {0f, 0.5f, 1f};
    private Color [] topColors = new Color [] {topColorOuter, topColorInner, topColorOuter};

    private Color overlayStart = new Color(0, 0, 0, 30);
    private Color  overlayEnd = new Color(255, 255, 255, 30);
    private float [] overlayStops = new float [] {0f, 1f};
    private Color [] overlayColors = new Color [] {overlayStart, overlayEnd};

    public RSHpBar(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void render(Graphics2D graphics, Point origin) {
        super.render(graphics, origin);

        LinearGradientPaint gradientPaint = new LinearGradientPaint(origin.x, h, origin.x + w, h, bottomStops, bottomColors);
        graphics.setPaint(gradientPaint);
        graphics.fillRect(origin.x, (int) (origin.y + h * 0.65), w, (int) (h * 0.35));

        gradientPaint = new LinearGradientPaint(0, origin.y, 0, origin.y + h * 0.65f, topStops, topColors);
        graphics.setPaint(gradientPaint);
        graphics.fillRect(origin.x, origin.y, w, (int) (h * 0.65));

        gradientPaint = new LinearGradientPaint(origin.x, h, origin.x + w, h, overlayStops, overlayColors);
        graphics.setPaint(gradientPaint);
        graphics.fillRect(origin.x, origin.y, w, h);
    }
}
