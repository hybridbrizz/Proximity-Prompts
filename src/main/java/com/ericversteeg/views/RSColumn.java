package com.ericversteeg.views;

import java.awt.*;
import java.util.Map;

public class RSColumn extends RSViewGroup
{
    public RSColumn(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    @Override
    protected Dimension layoutSubviews(Map<RSLayoutGuide, Integer> guides)
    {
        w = measureWidth(guides);

        int topGuide = paddingTop;
        for (RSView view: subviews)
        {
            topGuide += view.getMarginTop();
            applyPosition(
                    new RSLayoutGuide.Builder()
                            .maxWidth(w)
                            .top(topGuide)
                            .start(paddingStart + view.getMarginStart())
                            .end(paddingEnd + view.getMarginEnd())
                            .build()
            );
            topGuide += view.getMarginBottom();
        }

        h = topGuide + paddingBottom;

        return new Dimension(w, h);
    }
}
