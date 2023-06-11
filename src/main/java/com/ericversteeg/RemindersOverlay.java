package com.ericversteeg;

import com.ericversteeg.reminder.Reminder;
import com.ericversteeg.views.*;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.NPC;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.Collectors;

class RemindersOverlay extends RSViewOverlay {

	private final Client client;
	private final ItemManager itemManager;
	private final RemindersPlugin plugin;
	private final RemindersConfig config;

	private Font font;

	private Color panelBackgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private Color outerBorderColor = new Color(57, 41, 13, 124);
	private Color innerBorderColor = new Color(147, 141, 130, 37);

	@Inject
	private RemindersOverlay(
			Client client,
			ItemManager itemManager,
			RemindersPlugin plugin,
			RemindersConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);

		this.client = client;
		this.itemManager = itemManager;
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
		clearViewInfo();

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

		int panelWidth = config.width();

		RSColumn panel = new RSColumn(10, 120, panelWidth, RSView.WRAP_CONTENT);
		panel.setBgColor(panelBackgroundColor);
		panel.addBorder(innerBorderColor, outerBorderColor);
		panel.setPadding(4);

		int maxReminders = config.maxReminders();
		int activeCount = 0;

		java.util.List<Reminder> reminders = plugin.activeReminders.stream()
				.sorted(((o1, o2) -> (int) (o2.posted - o1.posted)))
				.collect(Collectors.toList());

		for (Reminder reminder: reminders) {
			if (activeCount == maxReminders) break;

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

			if (plugin.isSeparatePanel(reminder.id))
			{
				renderReminderPanel(reminder, color);
				continue;
			}

			RSRow row = new RSRow(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);
			if (activeCount + 1 < Math.min(reminders.size(), maxReminders))
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

			boolean isImage = plugin.isImage(reminder.id);
			int imageId = plugin.getImageId(reminder.id);

			if (isImage && imageId > 0)
			{
				BufferedImage image = itemManager.getImage(imageId);
				if (image != null)
				{
					int imageWidth = 0;
					if (config.textSize() == TextSize.SMALL)
					{
						imageWidth = 24;
					}
					else
					{
						imageWidth = 32;
					}

					image = ImageUtil.resizeImage(image, imageWidth, imageWidth, true);
					rightText.setImage(image, imageWidth, imageWidth, plugin.getImageAlignment(reminder.id));
				}
			}

			rightText.setAnimatesColor(plugin.isAnimate(reminder.id));
			rightText.setAnimationCycleDuration(plugin.getCycleDuration(reminder.id));

			row.addView(rightText);

			panel.addView(row);

			activeCount++;
		}

		if (config.idFinder())
		{
			renderIds(panel);
		}
		else if (activeCount == 0)
		{
			return;
		}

		addViewInfo(new ViewInfo(client, panel, config.anchorType(),
				config.anchorX(), config.anchorY()));

		//System.out.println("View setup in " + (Instant.now().toEpochMilli() - start) + "ms");
	}

	private void renderReminderPanel(Reminder reminder, Color color)
	{
		String text = reminder.text;

		RSRow panel = new RSRow(10, 120, config.width(), RSView.WRAP_CONTENT);
		panel.setBgColor(panelBackgroundColor);
		panel.addBorder(innerBorderColor, outerBorderColor);
		panel.setPadding(4);

		RSTextView textView = new RSTextView(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT, font);

		textView.setTextColor(color);
		textView.setText(text);

		boolean isImage = plugin.isImage(reminder.id);
		int imageId = plugin.getImageId(reminder.id);

		if (isImage && imageId > 0)
		{
			BufferedImage image = itemManager.getImage(imageId);
			if (image != null)
			{
				int imageWidth = 0;
				if (config.textSize() == TextSize.SMALL)
				{
					imageWidth = 24;
				}
				else
				{
					imageWidth = 32;
				}

				image = ImageUtil.resizeImage(image, imageWidth, imageWidth, true);
				textView.setImage(image, imageWidth, imageWidth, plugin.getImageAlignment(reminder.id));
			}
		}

		textView.setAnimatesColor(plugin.isAnimate(reminder.id));
		textView.setAnimationCycleDuration(plugin.getCycleDuration(reminder.id));

		panel.addView(textView);

		addViewInfo(new ViewInfo(client, panel, plugin.getPanelAnchorType(reminder.id),
				plugin.getPanelAnchorX(reminder.id), plugin.getPanelAnchorY(reminder.id)));
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
