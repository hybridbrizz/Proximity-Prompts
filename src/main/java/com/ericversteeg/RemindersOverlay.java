package com.ericversteeg;

import com.ericversteeg.config.AnchorType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.NPC;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.io.InputStream;

class RemindersOverlay extends OverlayPanel {

	private final Client client;
	private final RemindersPlugin plugin;
	private final RemindersConfig config;

	Widget viewportWidget;
	private Font font;
	private int anchorX;
	private int anchorY;

	@Inject
	private RemindersOverlay(
			Client client,
			RemindersPlugin plugin,
			RemindersConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);

		this.client = client;
		this.plugin = plugin;
		this.config = config;

		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			InputStream inRunescapeSmall = FontManager.class.getResourceAsStream("runescape_small.ttf");
			Font smallFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeSmall)
					.deriveFont(Font.PLAIN,  12);
			ge.registerFont(smallFont);
			font = smallFont;
		}
		catch (Exception e)
		{
			font = FontManager.getRunescapeSmallFont();
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		viewportWidget = getViewportWidget();

		int w = 140;
		int h = 70;

		graphics.setFont(FontManager.getRunescapeSmallFont());

		viewportWidget = getViewportWidget();

		AnchorType anchorType = config.anchorType();

		int anchorX = config.anchorX();
		if (anchorType == AnchorType.TOP_RIGHT || anchorType == AnchorType.BOTTOM_RIGHT)
		{
			anchorX = viewportWidget.getCanvasLocation().getX() + viewportWidget.getWidth() + 28 - anchorX - w;
		}

		int anchorY = config.anchorY();
		if (anchorType == AnchorType.BOTTOM_LEFT || anchorType == AnchorType.BOTTOM_RIGHT)
		{
			anchorY = viewportWidget.getCanvasLocation().getY() + viewportWidget.getHeight() + 41 - anchorY - h;
		}

		panelComponent.setPreferredLocation(new Point(anchorX, anchorY));
		panelComponent.setPreferredSize(new Dimension(w, h));

		panelComponent.setPreferredLocation(new Point(anchorX, anchorY));

		if (config.listIds())
		{
			renderIds();
		}

		return super.render(graphics);
	}

	private void renderIds()
	{
		panelComponent.getChildren().add(
				LineComponent.builder()
						.left("Location")
						.leftColor(Color.GREEN)
						.right(String.format("(%d, %d)", plugin.localPos.getX(), plugin.localPos.getY()))
						.build()
		);

		panelComponent.getChildren().add(
				LineComponent.builder()
						.left("Region")
						.leftColor(Color.GREEN)
						.right(String.valueOf(plugin.regionId))
						.build()
		);

		for (NPC npc: plugin.npcs)
		{
			if (npc.getId() == -1) continue;

			panelComponent.getChildren().add(
					LineComponent.builder()
							.left(npc.getName())
							.leftColor(Color.CYAN)
							.right(String.valueOf(npc.getId()))
							.build()
			);
		}

		for (ItemComposition item: plugin.inventoryItems)
		{
			if (item.getId() == -1) continue;

			panelComponent.getChildren().add(
					LineComponent.builder()
							.left(item.getName())
							.leftColor(Color.YELLOW)
							.right(String.valueOf(item.getId()))
							.build()
			);
		}
	}

	private Widget getViewportWidget()
	{
		Widget widget;

		widget = client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_INTERFACE_CONTAINER);
		if (widget != null) return widget;

		widget = client.getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_INTERFACE_CONTAINER);
		if (widget != null) return widget;

		widget = client.getWidget(WidgetInfo.FIXED_VIEWPORT_INTERFACE_CONTAINER);
		if (widget != null) return widget;

		return client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
	}



	private String printItems()
	{
		StringBuilder sb = new StringBuilder();
		for (ItemComposition item: plugin.inventoryItems)
		{
			if (item.getId() < 0) continue;

			sb.append(item.getName());
			sb.append(" ");
			sb.append(item.getId());
			sb.append(", ");
		}

		if (sb.length() > 1)
		{
			return sb.substring(0, sb.length() - 2);
		}
		return "";
	}
}
