package com.ericversteeg;

import com.ericversteeg.config.AnchorType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(RemindersConfig.GROUP)
public interface RemindersConfig extends Config
{
	String GROUP = "reminders";

	@ConfigItem(
			position = 1,
			keyName = "anchorType",
			name = "Anchor",
			description = "Configure anchor."
	)
	default AnchorType anchorType() { return AnchorType.TOP_RIGHT; }

	@ConfigItem(
			position = 2,
			keyName = "anchorX",
			name = "X Position",
			description = "Configure x position relative to anchor."
	)
	default int anchorX() { return 10; }

	@ConfigItem(
			position = 3,
			keyName = "anchorY",
			name = "Y Position",
			description = "Configures y position relative to anchor."
	)
	default int anchorY() { return 120; }

	@ConfigItem(
			position = 4,
			keyName = "listIds",
			name = "List Ids",
			description = "Configures whether or not to list location, region, npcs, and item ids."
	)
	default boolean listIds() { return false; }
}