package com.ericversteeg;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.Text;

@Setter
@Builder
// from Runelite LineComponent
public class EmptyLineComponent implements LayoutableRenderableEntity
{

    @Override
    public Rectangle getBounds()
    {
        return null;
    }

    @Override
    public void setPreferredLocation(Point position) {

    }

    @Override
    public void setPreferredSize(Dimension dimension) {

    }

    @Override
    public Dimension render(Graphics2D graphics) {
        return null;
    }
}
