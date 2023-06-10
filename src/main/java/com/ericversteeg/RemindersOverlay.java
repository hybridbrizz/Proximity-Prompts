package com.ericversteeg;

import com.ericversteeg.reminder.Reminder;
import com.ericversteeg.views.*;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.NPC;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;

import javax.inject.Inject;
import java.awt.*;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.Collectors;

class RemindersOverlay extends RSViewOverlay {

	private final Client client;
	private final RemindersPlugin plugin;
	private final RemindersConfig config;

	private Font font;

	private Color panelBackgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private Color outerBorderColor = new Color(57, 41, 13, 124);
	private Color innerBorderColor = new Color(147, 141, 130, 37);

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

//		RSRow column = new RSRow(10, 120, 500, 50);
//		column.setBgColor(Color.decode("#45AB76"));
//		column.setPadding(5);
//
//		RSColumn column2 = new RSColumn(0, 0, 120, RSView.MATCH_PARENT);
//		column2.setBgColor(new Color(0, 255, 0));
//		column2.setPadding(5);
//		column2.setMarginBottom(5);
//
//		RSView view = new RSView(0, 0, RSView.MATCH_PARENT, 20);
//		view.setBgColor(new Color(255, 0, 0));
//		view.setMarginEnd(5);
//		view.setMarginBottom(5);
//
//		column2.addView(view);
//
//		column.addView(column2);
//
//		RSBox box = new RSBox(0, 0, 140, RSView.MATCH_PARENT);
//		box.setBgColor(new Color(255, 255, 0));
//		//view.setMarginBottom(5);
//		box.setWeight(4f);
//
//		view = new RSView(0, 0, 20, 20);
//		view.setBgColor(Color.ORANGE);
//		view.setLayoutGravity(RSViewGroup.Gravity.CENTER);
//
//		box.addView(view);
//
//		view = new RSView(0, 0, 20, 20);
//		view.setBgColor(Color.ORANGE);
//		view.setLayoutGravity(RSViewGroup.Gravity.BOTTOM_END);
//		view.setMarginBottom(5);
//		view.setMarginEnd(5);
//
//		box.addView(view);
//
//		column.addView(box);
//
//		view = new RSView(0, 0, 140, RSView.MATCH_PARENT);
//		view.setBgColor(new Color(0, 0, 255));
//		view.setWeight(1f);
//
//		column.addView(view);
//
//		setRootView(column);
	}

	void updateViews()
	{
		long start = Instant.now().toEpochMilli();

		TextSize textSize = config.textSize();
		if (textSize == TextSize.SMALL)
		{
			font = FontManager.getRunescapeSmallFont();
		}
		else if (textSize == TextSize.LARGE)
		{
			font = FontManager.getRunescapeFont();
		}
		else
		{
			font = FontManager.getRunescapeBoldFont();
		}

		RSColumn panel = new RSColumn(10, 120, 140, RSView.WRAP_CONTENT);
		panel.setBgColor(panelBackgroundColor);
		panel.addBorder(innerBorderColor, outerBorderColor);
		panel.setPadding(4);

		int maxReminders = config.maxReminders();
		int i = 0;
		for (Reminder reminder: plugin.activeReminders.stream()
				.sorted(((o1, o2) -> (int) (o2.posted - o1.posted)))
				.collect(Collectors.toList())) {
			if (i == maxReminders) break;

			String text = reminder.text;
			if (text.trim().isEmpty()) continue;

			Color color;
			if (reminder.colur != null)
			{
				color = reminder.colur;
			}
			else
			{
				try
				{
					color = Color.decode(reminder.colorStr);
				}
				catch (Exception exception)
				{
					color = Color.WHITE;
				}
			}

			RSRow row = new RSRow(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);
			if (i + 1 < maxReminders)
			{
				row.setMarginBottom(5);
			}

			RSTextView leftText = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);

			leftText.setTextColor(color);
			leftText.setText("•");
			leftText.setMarginEnd(3);

			row.addView(leftText);

			RSTextView rightText = new RSTextView(0, 0, 0, RSView.WRAP_CONTENT, font);

			rightText.setTextColor(color);
			rightText.setText(text);
			rightText.setWeight(1f);

			row.addView(rightText);

			panel.addView(row);

			i++;
		}

		if (config.idFinder())
		{
			renderIds(panel);
		}

		setRootView(panel);
		setAnchor(client, config.anchorType(), config.anchorX(), config.anchorY());

		System.out.println("View setup in " + (Instant.now().toEpochMilli() - start) + "ms");
	}

	private void renderIds(RSColumn panel)
	{
		RSBox box = new RSBox(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);

		RSTextView left = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
		left.setTextColor(Color.GREEN);
		left.setText("Location");
		left.setLayoutGravity(RSViewGroup.Gravity.START);

		RSTextView right = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
		right.setText(String.format("(%d, %d)", plugin.worldPos.getX(), plugin.worldPos.getY()));
		right.setLayoutGravity(RSViewGroup.Gravity.END);

		box.addView(left);
		box.addView(right);

		panel.addView(box);

		box = new RSBox(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);

		left = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
		left.setTextColor(Color.GREEN);
		left.setText("Region");
		left.setLayoutGravity(RSViewGroup.Gravity.START);

		right = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
		right.setText(String.valueOf(plugin.regionId));
		right.setLayoutGravity(RSViewGroup.Gravity.END);

		box.addView(left);
		box.addView(right);

		panel.addView(box);

		java.util.List<Integer> npcIds = new ArrayList<>();
		for (NPC npc: plugin.npcs)
		{
			if (npc.getId() == -1) continue;

			if (!npcIds.contains(npc.getId()))
			{
				RSRow row = new RSRow(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);

				left = new RSTextView(0, 0, 0, RSView.WRAP_CONTENT, font);
				left.setTextColor(Color.CYAN);
				left.setText(npc.getName());
				left.setWeight(1f);

				right = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
				right.setText(String.valueOf(npc.getId()));
				right.setMarginStart(10);

				row.addView(left);
				row.addView(right);

				panel.addView(row);

				npcIds.add(npc.getId());
			}
		}

		for (ItemComposition item: plugin.inventoryItems)
		{
			if (item.getId() == -1) continue;

			RSRow row = new RSRow(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);

			left = new RSTextView(0, 0, 0, RSView.WRAP_CONTENT, font);
			left.setTextColor(Color.YELLOW);
			left.setText(item.getName());
			left.setWeight(1f);

			right = new RSTextView(0, 0, RSView.WRAP_CONTENT, RSView.WRAP_CONTENT, font);
			right.setText(String.valueOf(item.getId()));
			right.setMarginStart(10);

			row.addView(left);
			row.addView(right);

			panel.addView(row);
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		updateViews();
		return super.render(graphics);
	}
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
