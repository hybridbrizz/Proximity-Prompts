package com.ericversteeg;

import com.ericversteeg.model.config.Location;
import com.ericversteeg.model.config.TextSize;
import com.ericversteeg.model.Prompt;
import com.ericversteeg.view.*;
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

class ProximityPromptOverlay extends RSViewOverlay {

	private final Client client;
	private final ItemManager itemManager;
	private final ProximityPromptPlugin plugin;
	private final ProximityPromptConfig config;

	private Font font;

	private final Color panelBackgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;
	private final Color outerBorderColor = new Color(57, 41, 13, 124);
	private final Color innerBorderColor = new Color(147, 141, 130, 37);

	@Inject
	private ProximityPromptOverlay(
			Client client,
			ItemManager itemManager,
			ProximityPromptPlugin plugin,
			ProximityPromptConfig config)
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

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	void updateViews()
	{
		clearViewInfo();

		//long start = Instant.now().toEpochMilli();

		font = fontForTextSize(config.textSize().ordinal());

		int minWidth = 140;
		if (font == FontManager.getRunescapeBoldFont())
		{
			minWidth = 160;
		}
		int panelWidth = Math.max(config.width(), minWidth);

		RSColumn panel = new RSColumn(10, 120, panelWidth, RSView.WRAP_CONTENT);
		panel.setBgColor(panelBackgroundColor);
		panel.addBorder(innerBorderColor, outerBorderColor);
		panel.setPadding(4);

		java.util.List<Prompt> listPrompts = plugin.activePrompts.stream()
				.sorted(((o1, o2) -> (int) (o2.posted - o1.posted)))
				.filter(obj -> obj.location == Location.IN_LIST.ordinal())
				.filter(obj -> !obj.text.trim().isEmpty())
				.collect(Collectors.toList());

		for (Prompt prompt : listPrompts)
		{
			String text = prompt.text;
			if (text.trim().isEmpty()) continue;

			Color color;
			if (prompt.color != null)
			{
				color = prompt.color;
			}
			else
			{
				try
				{
					color = Color.decode(prompt.colorStr);
				}
				catch (Exception exception)
				{
					color = Color.WHITE;
				}
			}

			RSRow row = new RSRow(0, 0, RSView.MATCH_PARENT, RSView.WRAP_CONTENT);
			if (listPrompts.indexOf(prompt) + 1 < listPrompts.size())
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

			int imageId = prompt.imageId;

			if (imageId > 0)
			{
				BufferedImage image = itemManager.getImage(imageId);
				if (image != null)
				{
					int imageWidth;
					if (config.textSize() == TextSize.SMALL)
					{
						imageWidth = 24;
					}
					else
					{
						imageWidth = 32;
					}

					image = ImageUtil.resizeImage(image, imageWidth, imageWidth, true);
					rightText.setImage(image, imageWidth, imageWidth, RSViewGroup.Gravity.TOP_START);
					rightText.setImageOffset(prompt.imageOffset, prompt.isOffsetNegative);
				}
			}

			row.addView(rightText);

			panel.addView(row);
		}

		java.util.List<Prompt> panelPrompts = plugin.activePrompts.stream()
				.sorted(((o1, o2) -> (int) (o2.posted - o1.posted)))
				.filter(obj -> obj.location != Location.IN_LIST.ordinal())
				.filter(obj -> !obj.text.trim().isEmpty())
				.collect(Collectors.toList());

		for (Prompt prompt : panelPrompts)
		{
			String text = prompt.text;
			if (text.trim().isEmpty()) continue;

			if (prompt.location == Location.WORD_WRAP.ordinal())
			{
				renderPromptWordWrapPanel(prompt);
			}
			else if (prompt.location == Location.SINGLE_LINE.ordinal())
			{
				renderPromptSingleLinePanel(prompt);
			}
		}

		if (config.idFinder())
		{
			renderIds(panel);
		}
		else if (listPrompts.isEmpty())
		{
			return;
		}

		addViewInfo(new ViewInfo(client, panel, config.anchorType(),
				config.anchorX(), config.anchorY()));

		//System.out.println("View setup in " + (Instant.now().toEpochMilli() - start) + "ms");
	}

	private void renderPromptWordWrapPanel(Prompt prompt)
	{
		String text = prompt.text;
		Color color = prompt.color;

		Color panelColor = prompt.bgColor;

		RSRow panel = new RSRow(10, 120, Math.max(prompt.width, 50), RSView.WRAP_CONTENT);
		panel.setBgColor(new Color(panelColor.getRed(), panelColor.getGreen(), panelColor.getBlue(), 156));

		if (prompt.hasBorder)
		{
			panel.addBorder(panelColor);
		}

		panel.setPadding(4);

		RSTextView textView = new RSTextView(0, 0, RSView.MATCH_PARENT,
				RSView.WRAP_CONTENT, fontForTextSize(prompt.textSize));

		textView.setTextColor(color);
		textView.setText(text);

		int imageId = prompt.imageId;

		if (imageId > 0)
		{
			BufferedImage image = itemManager.getImage(imageId);
			if (image != null)
			{
				int imageWidth;
				if (prompt.textSize == TextSize.SMALL.ordinal())
				{
					imageWidth = 24;
				}
				else
				{
					imageWidth = 32;
				}

				image = ImageUtil.resizeImage(image, imageWidth, imageWidth, true);
				textView.setImage(image, imageWidth, imageWidth, RSViewGroup.Gravity.TOP_START);
				textView.setImageOffset(prompt.imageOffset, prompt.isOffsetNegative);
			}
		}

		panel.addView(textView);

		addViewInfo(new ViewInfo(client, panel, RSAnchorType.values()[prompt.anchorType],
				prompt.anchorX, prompt.anchorY));
	}

	private void renderPromptSingleLinePanel(Prompt prompt)
	{
		String text = prompt.text;
		Color color = prompt.color;

		RSImageView imageView = new RSImageView(RSView.WRAP_CONTENT, RSView.WRAP_CONTENT);
		
		int imageId = prompt.imageId;

		int imageWidth = 0;
		if (imageId > 0)
		{
			BufferedImage image = itemManager.getImage(imageId);
			if (image != null)
			{
				if (prompt.textSize == TextSize.SMALL.ordinal())
				{
					imageWidth = 24;
				}
				else
				{
					imageWidth = 32;
				}

				image = ImageUtil.resizeImage(image, imageWidth, imageWidth, true);
				imageView.setImage(image);
				imageView.setOffset(prompt.imageOffset, prompt.isOffsetNegative);
			}
		}

		Color panelColor = prompt.bgColor;

		int panelHeight = RSView.WRAP_CONTENT;
		if (imageWidth > 0)
		{
			panelHeight = imageWidth;
		}

		RSRow panel = new RSRow(10, 120, RSView.WRAP_CONTENT, panelHeight);
		panel.setBgColor(new Color(panelColor.getRed(), panelColor.getGreen(), panelColor.getBlue(), 156));

		if (prompt.hasBorder)
		{
			panel.addBorder(panelColor);
		}

		panel.setPadding(4);

		panel.addView(imageView);

		RSTextView textView = new RSTextView(0, 0, RSView.WRAP_CONTENT,
				RSView.WRAP_CONTENT, fontForTextSize(prompt.textSize));

		if (imageWidth > 0)
		{
			textView.setLayoutGravity(RSViewGroup.Gravity.START);
		}

		textView.setTextColor(color);
		textView.setText(text);

		panel.addView(textView);

		addViewInfo(new ViewInfo(client, panel, RSAnchorType.values()[prompt.anchorType],
				prompt.anchorX, prompt.anchorY));
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

		for (ItemComposition item: plugin.items)
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

	private Font fontForTextSize(int textSize)
	{
		Font font;
		if (textSize == TextSize.SMALL.ordinal())
		{
			font = FontManager.getRunescapeSmallFont();
		}
		else if (textSize == TextSize.LARGE.ordinal())
		{
			font = FontManager.getRunescapeFont();
		}
		else
		{
			font = FontManager.getRunescapeBoldFont();
		}

		return font;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		updateViews();
		return super.render(graphics);
	}
}
