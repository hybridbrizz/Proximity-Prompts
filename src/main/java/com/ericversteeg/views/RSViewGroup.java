package com.ericversteeg.views;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class RSViewGroup extends RSView
{
    enum Gravity
    {
        START,
        TOP_START,
        TOP,
        TOP_END,
        END,
        BOTTOM_END,
        BOTTOM,
        BOTTOM_START,
        CENTER
    }

    protected Gravity gravity = Gravity.TOP_START;

    protected List<RSView> subviews = new ArrayList<>();

    protected int paddingStart = 0;
    protected int paddingTop = 0;
    protected int paddingEnd = 0;
    protected int paddingBottom = 0;

    public RSViewGroup(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    public void setGravity(Gravity gravity)
    {
        this.gravity = gravity;
    }

    public void addView(RSView view)
    {
        subviews.add(view);
    }

    @Override
    public void render(Graphics2D graphics, Point origin)
    {
        super.render(graphics, origin);

        for (RSView view: subviews)
        {
            view.render(graphics, origin);
        }
    }

    public Gravity getGravity()
    {
        return gravity;
    }

    public int getPaddingStart()
    {
        return paddingStart;
    }

    public int getPaddingTop()
    {
        return paddingTop;
    }

    public int getPaddingEnd()
    {
        return paddingEnd;
    }

    public int getPaddingBottom()
    {
        return paddingBottom;
    }

    public Dimension layout()
    {
        return applyDimension(new RSLayoutGuide.Builder()
                .maxWidth(w)
                .build()
        );
    }

    abstract protected Dimension layoutSubviews(Map<RSLayoutGuide, Integer> guides);

    @Override
    protected Dimension applyDimension(Map<RSLayoutGuide, Integer> guides) {
        // calculate width and height for all subviews before layout
        for (RSView view: subviews)
        {
            view.applyDimension(
                    subviewMaxDimensionGuides(guides, view)
            );
        }

        // layout subviews (x, y) and return total measured size
        return layoutSubviews(guides);
    }

    @Override
    public int measureWidth(Map<RSLayoutGuide, Integer> guides)
    {
        if (dimensionParams.getW() == MATCH_PARENT)
        {
            return guides.get(RSLayoutGuide.MAX_WIDTH);
        }
        else if (dimensionParams.getW() == WRAP_CONTENT)
        {
            return getMaxSubviewWidth();
        }
        else
        {
            return dimensionParams.getW();
        }
    }

    protected int getMaxSubviewWidth()
    {
        int max = 0;
        for (RSView view: subviews)
        {
            int sw = view.getW() + view.getMarginStart()
                    + view.getMarginEnd() + paddingStart
                    + paddingEnd;
            if (sw > max)
            {
                max = sw;
            }
        }
        return max;
    }

    @Override
    public int measureHeight(Map<RSLayoutGuide, Integer> guides)
    {
        if (dimensionParams.getH() == MATCH_PARENT)
        {
            return guides.get(RSLayoutGuide.MAX_HEIGHT);
        }
        else if (dimensionParams.getH() == WRAP_CONTENT)
        {
            return getMaxSubviewHeight();
        }
        else
        {
            return dimensionParams.getH();
        }
    }

    protected int getMaxSubviewHeight()
    {
        int max = 0;
        for (RSView view: subviews)
        {
            int sw = view.getH() + view.getMarginTop()
                    + view.getMarginBottom() + paddingTop
                    + paddingBottom;
            if (sw > max)
            {
                max = sw;
            }
        }
        return max;
    }

    protected Map<RSLayoutGuide, Integer> subviewMaxDimensionGuides(
            Map<RSLayoutGuide, Integer> guides, RSView view)
    {
        Map<RSLayoutGuide, Integer> subviewGuides = new HashMap<>();

        if (guides.containsKey(RSLayoutGuide.MAX_WIDTH))
        {
            int wGuide = guides.get(RSLayoutGuide.MAX_WIDTH);
            if (dimensionParams.getW() != WRAP_CONTENT)
            {
                subviewGuides.put(RSLayoutGuide.MAX_WIDTH, wGuide
                        - view.getMarginStart() - view.getMarginEnd()
                        - getPaddingStart() - getPaddingEnd());
            }
        }

        if (guides.containsKey(RSLayoutGuide.MAX_HEIGHT))
        {
            int hGuide = guides.get(RSLayoutGuide.MAX_HEIGHT);
            if (dimensionParams.getH() != WRAP_CONTENT)
            {
                subviewGuides.put(RSLayoutGuide.MAX_HEIGHT, hGuide
                        - view.getMarginTop() - view.getMarginBottom()
                        - getPaddingTop() - getPaddingBottom());
            }
        }

        return subviewGuides;
    }

    protected Map<RSLayoutGuide, Integer> guides(int w, int h, int s, int t, int e, int b)
    {
        Map<RSLayoutGuide, Integer> guides = new HashMap<>();

        guides.put(RSLayoutGuide.MAX_WIDTH, w);
        guides.put(RSLayoutGuide.MAX_HEIGHT, h);
        guides.put(RSLayoutGuide.START, s);
        guides.put(RSLayoutGuide.TOP, t);
        guides.put(RSLayoutGuide.END, e);
        guides.put(RSLayoutGuide.BOTTOM, b);

        return guides;
    }
}
