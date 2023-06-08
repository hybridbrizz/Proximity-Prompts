package com.ericversteeg;

import com.ericversteeg.config.AnchorType;
import com.ericversteeg.reminder.Reminder;
import com.ericversteeg.views.*;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.NPC;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

import javax.inject.Inject;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class RemindersOverlay extends RSViewOverlay {

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

		viewportWidget = getViewportWidget();

		RSRow column = new RSRow(10, 120, 500, 50);
		column.setBgColor(Color.decode("#45AB76"));
		column.setPadding(5);

		RSColumn column2 = new RSColumn(0, 0, 120, RSView.MATCH_PARENT);
		column2.setBgColor(new Color(0, 255, 0));
		column2.setPadding(5);
		column2.setMarginBottom(5);

		RSView view = new RSView(0, 0, RSView.MATCH_PARENT, 20);
		view.setBgColor(new Color(255, 0, 0));
		view.setMarginEnd(5);
		view.setMarginBottom(5);

		column2.addView(view);

		column.addView(column2);

		RSBox box = new RSBox(0, 0, 140, RSView.MATCH_PARENT);
		box.setBgColor(new Color(255, 255, 0));
		//view.setMarginBottom(5);
		box.setWeight(4f);

		view = new RSView(0, 0, 20, 20);
		view.setBgColor(Color.ORANGE);
		view.setLayoutGravity(RSViewGroup.Gravity.CENTER);

		box.addView(view);

		view = new RSView(0, 0, 20, 20);
		view.setBgColor(Color.ORANGE);
		view.setLayoutGravity(RSViewGroup.Gravity.BOTTOM_END);
		view.setMarginBottom(5);
		view.setMarginEnd(5);

		box.addView(view);

		column.addView(box);

		view = new RSView(0, 0, 140, RSView.MATCH_PARENT);
		view.setBgColor(new Color(0, 0, 255));
		view.setWeight(1f);

		column.addView(view);

		setRootView(column);
	}

//	@Override
//	public Dimension render(Graphics2D graphics)
//	{
//
////		int w = 140;
////		int h = 70;
////
////		panelComponent.setPreferredSize(new Dimension(w, h));
////
////		TextSize textSize = config.textSize();
////		if (textSize == TextSize.SMALL)
////		{
////			graphics.setFont(FontManager.getRunescapeSmallFont());
////		}
////		else if (textSize == TextSize.LARGE)
////		{
////			graphics.setFont(FontManager.getRunescapeFont());
////		}
////		else
////		{
////			graphics.setFont(FontManager.getRunescapeBoldFont());
////		}
////
////		viewportWidget = getViewportWidget();
////
////		AnchorType anchorType = config.anchorType();
////
////		// once to get dimension
////		Dimension dimension = renderReminders(graphics, -10000, -10000, w, h);
////
//////		System.out.println("Height is " + dimension.height);
////
////		int anchorX = config.anchorX();
////		if (anchorType == AnchorType.TOP_RIGHT || anchorType == AnchorType.BOTTOM_RIGHT)
////		{
////			anchorX = viewportWidget.getCanvasLocation().getX() + viewportWidget.getWidth() + 28 - anchorX - dimension.width;
////		}
////
////		int anchorY = config.anchorY();
////		if (anchorType == AnchorType.BOTTOM_LEFT || anchorType == AnchorType.BOTTOM_RIGHT)
////		{
////			anchorY = viewportWidget.getCanvasLocation().getY() + viewportWidget.getHeight() + 41 - anchorY - dimension.height;
////		}
////
//////		System.out.println("Anchor Y " + anchorY);
////
////		// again in position
////		renderReminders(graphics, anchorX, anchorY, dimension.width, dimension.height);
//
//		return super.render(graphics);
//	}

//	private Dimension renderReminders(Graphics2D graphics, int x, int y, int w, int h)
//	{
//		panelComponent.setPreferredLocation(new Point(x, y));
//
//		int maxReminders = config.maxReminders();
//		int i = 0;
//		for (Reminder reminder: plugin.activeReminders.stream()
//				.sorted(((o1, o2) -> (int) (o2.posted - o1.posted)))
//				.collect(Collectors.toList())) {
//			if (i == maxReminders) break;
//
//			String text = reminder.text;
//			if (text.trim().isEmpty()) continue;
//
//			Color color;
//			if (reminder.colur != null)
//			{
//				color = reminder.colur;
//			}
//			else
//			{
//				try
//				{
//					color = Color.decode(reminder.colorStr);
//				}
//				catch (Exception exception)
//				{
//					color = Color.WHITE;
//				}
//			}
//
//			panelComponent.getChildren().add(
//					WeightedLineComponent.builder()
//							.left("•")
//							.leftColor(color)
//							.right(text)
//							.rightColor(color)
//							.rightWeight(1f)
//							.rightAlignment(TextAlignment.LEADING)
//							.build()
//			);
//
//			i++;
//		}
//
//		if (config.idFinder())
//		{
//			renderIds();
//		}
//
//		return super.render(graphics);
//	}
//
//	private void renderIds()
//	{
//		panelComponent.getChildren().add(
//				LineComponent.builder()
//						.left("Location")
//						.leftColor(Color.GREEN)
//						.right(String.format("(%d, %d)", plugin.worldPos.getX(), plugin.worldPos.getY()))
//						.build()
//		);
//
//		panelComponent.getChildren().add(
//				LineComponent.builder()
//						.left("Region")
//						.leftColor(Color.GREEN)
//						.right(String.valueOf(plugin.regionId))
//						.build()
//		);
//
//		java.util.List<Integer> npcIds = new ArrayList<>();
//		for (NPC npc: plugin.npcs)
//		{
//			if (npc.getId() == -1) continue;
//
//			if (!npcIds.contains(npc.getId()))
//			{
//				panelComponent.getChildren().add(
//						LineComponent.builder()
//								.left(npc.getName())
//								.leftColor(Color.CYAN)
//								.right(String.valueOf(npc.getId()))
//								.build()
//				);
//				npcIds.add(npc.getId());
//			}
//		}
//
//		for (ItemComposition item: plugin.inventoryItems)
//		{
//			if (item.getId() == -1) continue;
//
//			panelComponent.getChildren().add(
//					LineComponent.builder()
//							.left(item.getName())
//							.leftColor(Color.YELLOW)
//							.right(String.valueOf(item.getId()))
//							.build()
//			);
//		}
//	}

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

	private String printItems() {
		StringBuilder sb = new StringBuilder();
		for (ItemComposition item : plugin.inventoryItems) {
			if (item.getId() < 0) continue;

			sb.append(item.getName());
			sb.append(" ");
			sb.append(item.getId());
			sb.append(", ");
		}

		if (sb.length() > 1) {
			return sb.substring(0, sb.length() - 2);
		}
		return "";

	}
}
