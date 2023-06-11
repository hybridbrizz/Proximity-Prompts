package com.ericversteeg;

import com.ericversteeg.config.ColorAnimationType;
import com.ericversteeg.config.TimeUnit;
import com.ericversteeg.views.RSAnchorType;
import com.ericversteeg.views.RSViewGroup;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup(RemindersConfig.GROUP)
public interface RemindersConfig extends Config {
	String GROUP = "reminders_4";

	@ConfigItem(
			position = 1,
			keyName = "anchorType",
			name = "Anchor",
			description = "Configure anchor."
	)
	default RSAnchorType anchorType() {
		return RSAnchorType.TOP_LEFT;
	}

	@ConfigItem(
			position = 2,
			keyName = "anchorX",
			name = "X Position",
			description = "Configure x position relative to anchor."
	)
	default int anchorX() {
		return 10;
	}

	@ConfigItem(
			position = 3,
			keyName = "anchorY",
			name = "Y Position",
			description = "Configures y position relative to anchor."
	)
	default int anchorY() {
		return 120;
	}

	@ConfigItem(
			position = 4,
			keyName = "width",
			name = "Width",
			description = "Configures the width."
	)
	default int width() {
		return 140;
	}

	@ConfigItem(
			position = 5,
			keyName = "idFinder",
			name = "Finder",
			description = "Configures whether or not to show ids."
	)
	default boolean idFinder() {
		return false;
	}

	@ConfigItem(
			position = 6,
			keyName = "textSize",
			name = "Text Size",
			description = "Configures the text size."
	)
	default TextSize textSize() {
		return TextSize.SMALL;
	}

	@ConfigItem(
			position = 7,
			keyName = "max",
			name = "Max",
			description = "Configures the max number of reminders."
	)
	default int maxReminders() {
		return 5;
	}

	@ConfigSection(
			name = "Custom Reminders",
			description = "Custom Reminders",
			position = 20,
			closedByDefault = true
	)
	String customReminders = "customRemindersSection";

	@ConfigItem(
			position = 0,
			keyName = "customReminders",
			name = "Json",
			description = "Json array of reminders.",
			section = customReminders

	)
	default String customReminders() {
		return "[\n" +
				"  {\n" +
				"    \"enable\": false,\n" +
				"    \"text\": \"Reminder text.\",\n" +
				"    \"color\": \"#00FFFF\",\n" +
				"    \"duration\": 0,\n" +
				"    \"cooldown\": 0,\n" +
				"    \"time_unit\": 1,\n" +
				"    \"notify\": false,\n" +
				"    \"times\": [\n" +
				"      \"10:00pm\",\n" +
				"      \"5:30pm-7:00pm\"\n" +
				"    ],\n" +
				"    \"days_of_week\": [\n" +
				"      \"Thu\",\n" +
				"      \"Sat\"\n" +
				"    ],\n" +
				"    \"dates\": [\n" +
				"      \"05/30/23\",\n" +
				"      \"10/20\"\n" +
				"    ],\n" +
				"    \"coordinates\": [\n" +
				"      \"(300, 400)\",\n" +
				"      \"(1000, 750)\"\n" +
				"    ],\n" +
				"    \"radius\": 3,\n" +
				"    \"geofences\": [\n" +
				"      \"(4000, 3000, 4500, 2500)\",\n" +
				"      \"(500, 1000, 1500, 500)\"\n" +
				"    ],\n" +
				"    \"region_ids\": [\n" +
				"      \"500\",\n" +
				"      \"750\"\n" +
				"    ],\n" +
				"    \"npc_ids\": [\n" +
				"      \"300\",\n" +
				"      \"400\"\n" +
				"    ],\n" +
				"    \"item_ids\": [\n" +
				"      \"1500\",\n" +
				"      \"2000\"\n" +
				"    ],\n" +
				"    \"chat_patterns\": [\n" +
				"      \"text\",\n" +
				"      \"regex\"\n" +
				"    ]\n" +
				"  }  \n" +
				"]";
	}

	@ConfigSection(
			name = "Reminder1",
			description = "Reminder 1",
			position = 21,
			closedByDefault = true
	)
	String reminder1= "reminder1";

	@ConfigItem(
			keyName = "enableReminder1",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder1
	)
	default boolean reminder1Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder1Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder1
	)
	default String reminder1Text() { return ""; }

	@ConfigItem(
			keyName = "reminder1Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder1
	)
	default Color reminder1Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder1Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder1
	)
	default String reminder1Times() { return ""; }

	@ConfigItem(
			keyName = "reminder1DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder1
	)
	default String reminder1DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder1Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder1
	)
	default String reminder1Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder1Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder1
	)
	default String reminder1Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder1Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder1
	)
	default String reminder1Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder1Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder1
	)
	default int reminder1Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder1RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder1
	)
	default String reminder1RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder1
	)
	default String reminder1NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder1
	)
	default String reminder1ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder1
	)
	default int reminder1Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder1Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder1
	)
	default int reminder1Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder1TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder1
	)
	default TimeUnit reminder1TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder1ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder1
	)
	default String reminder1ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder1Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder1
	)
	default boolean reminder1Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder1SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder1
	)
	default boolean reminder1SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder1panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder1
	)
	default RSAnchorType reminder1PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder1PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder1
	)
	default int reminder1PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder1PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder1
	)
	default int reminder1PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder1ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder1
	)
	default RSViewGroup.Gravity reminder1ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder1ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder1
	)
	default int reminder1ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder1Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder1
	)
	default boolean reminder1Image() { return false; }

	@ConfigItem(
			keyName = "Reminder1Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder1
	)
	default boolean reminder1Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder1AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder1
	)
	default ColorAnimationType reminder1AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder1CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder1
	)
	default int reminder1CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder2",
			description = "Reminder 2",
			position = 22,
			closedByDefault = true
	)
	String reminder2= "reminder2";

	@ConfigItem(
			keyName = "enableReminder2",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder2
	)
	default boolean reminder2Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder2Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder2
	)
	default String reminder2Text() { return ""; }

	@ConfigItem(
			keyName = "reminder2Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder2
	)
	default Color reminder2Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder2Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder2
	)
	default String reminder2Times() { return ""; }

	@ConfigItem(
			keyName = "reminder2DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder2
	)
	default String reminder2DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder2Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder2
	)
	default String reminder2Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder2Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder2
	)
	default String reminder2Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder2Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder2
	)
	default String reminder2Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder2Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder2
	)
	default int reminder2Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder2RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder2
	)
	default String reminder2RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder2
	)
	default String reminder2NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder2
	)
	default String reminder2ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder2
	)
	default int reminder2Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder2Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder2
	)
	default int reminder2Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder2TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder2
	)
	default TimeUnit reminder2TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder2ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder2
	)
	default String reminder2ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder2Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder2
	)
	default boolean reminder2Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder2SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder2
	)
	default boolean reminder2SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder2panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder2
	)
	default RSAnchorType reminder2PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder2PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder2
	)
	default int reminder2PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder2PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder2
	)
	default int reminder2PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder2ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder2
	)
	default RSViewGroup.Gravity reminder2ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder2ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder2
	)
	default int reminder2ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder2Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder2
	)
	default boolean reminder2Image() { return false; }

	@ConfigItem(
			keyName = "Reminder2Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder2
	)
	default boolean reminder2Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder2AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder2
	)
	default ColorAnimationType reminder2AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder2CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder2
	)
	default int reminder2CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder3",
			description = "Reminder 3",
			position = 23,
			closedByDefault = true
	)
	String reminder3= "reminder3";

	@ConfigItem(
			keyName = "enableReminder3",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder3
	)
	default boolean reminder3Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder3Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder3
	)
	default String reminder3Text() { return ""; }

	@ConfigItem(
			keyName = "reminder3Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder3
	)
	default Color reminder3Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder3Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder3
	)
	default String reminder3Times() { return ""; }

	@ConfigItem(
			keyName = "reminder3DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder3
	)
	default String reminder3DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder3Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder3
	)
	default String reminder3Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder3Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder3
	)
	default String reminder3Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder3Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder3
	)
	default String reminder3Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder3Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder3
	)
	default int reminder3Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder3RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder3
	)
	default String reminder3RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder3
	)
	default String reminder3NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder3
	)
	default String reminder3ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder3
	)
	default int reminder3Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder3Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder3
	)
	default int reminder3Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder3TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder3
	)
	default TimeUnit reminder3TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder3ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder3
	)
	default String reminder3ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder3Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder3
	)
	default boolean reminder3Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder3SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder3
	)
	default boolean reminder3SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder3panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder3
	)
	default RSAnchorType reminder3PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder3PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder3
	)
	default int reminder3PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder3PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder3
	)
	default int reminder3PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder3ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder3
	)
	default RSViewGroup.Gravity reminder3ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder3ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder3
	)
	default int reminder3ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder3Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder3
	)
	default boolean reminder3Image() { return false; }

	@ConfigItem(
			keyName = "Reminder3Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder3
	)
	default boolean reminder3Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder3AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder3
	)
	default ColorAnimationType reminder3AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder3CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder3
	)
	default int reminder3CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder4",
			description = "Reminder 4",
			position = 24,
			closedByDefault = true
	)
	String reminder4= "reminder4";

	@ConfigItem(
			keyName = "enableReminder4",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder4
	)
	default boolean reminder4Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder4Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder4
	)
	default String reminder4Text() { return ""; }

	@ConfigItem(
			keyName = "reminder4Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder4
	)
	default Color reminder4Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder4Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder4
	)
	default String reminder4Times() { return ""; }

	@ConfigItem(
			keyName = "reminder4DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder4
	)
	default String reminder4DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder4Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder4
	)
	default String reminder4Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder4Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder4
	)
	default String reminder4Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder4Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder4
	)
	default String reminder4Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder4Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder4
	)
	default int reminder4Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder4RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder4
	)
	default String reminder4RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder4
	)
	default String reminder4NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder4
	)
	default String reminder4ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder4
	)
	default int reminder4Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder4Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder4
	)
	default int reminder4Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder4TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder4
	)
	default TimeUnit reminder4TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder4ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder4
	)
	default String reminder4ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder4Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder4
	)
	default boolean reminder4Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder4SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder4
	)
	default boolean reminder4SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder4panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder4
	)
	default RSAnchorType reminder4PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder4PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder4
	)
	default int reminder4PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder4PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder4
	)
	default int reminder4PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder4ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder4
	)
	default RSViewGroup.Gravity reminder4ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder4ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder4
	)
	default int reminder4ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder4Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder4
	)
	default boolean reminder4Image() { return false; }

	@ConfigItem(
			keyName = "Reminder4Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder4
	)
	default boolean reminder4Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder4AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder4
	)
	default ColorAnimationType reminder4AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder4CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder4
	)
	default int reminder4CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder5",
			description = "Reminder 5",
			position = 25,
			closedByDefault = true
	)
	String reminder5= "reminder5";

	@ConfigItem(
			keyName = "enableReminder5",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder5
	)
	default boolean reminder5Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder5Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder5
	)
	default String reminder5Text() { return ""; }

	@ConfigItem(
			keyName = "reminder5Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder5
	)
	default Color reminder5Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder5Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder5
	)
	default String reminder5Times() { return ""; }

	@ConfigItem(
			keyName = "reminder5DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder5
	)
	default String reminder5DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder5Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder5
	)
	default String reminder5Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder5Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder5
	)
	default String reminder5Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder5Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder5
	)
	default String reminder5Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder5Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder5
	)
	default int reminder5Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder5RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder5
	)
	default String reminder5RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder5
	)
	default String reminder5NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder5
	)
	default String reminder5ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder5
	)
	default int reminder5Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder5Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder5
	)
	default int reminder5Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder5TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder5
	)
	default TimeUnit reminder5TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder5ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder5
	)
	default String reminder5ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder5Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder5
	)
	default boolean reminder5Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder5SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder5
	)
	default boolean reminder5SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder5panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder5
	)
	default RSAnchorType reminder5PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder5PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder5
	)
	default int reminder5PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder5PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder5
	)
	default int reminder5PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder5ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder5
	)
	default RSViewGroup.Gravity reminder5ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder5ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder5
	)
	default int reminder5ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder5Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder5
	)
	default boolean reminder5Image() { return false; }

	@ConfigItem(
			keyName = "Reminder5Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder5
	)
	default boolean reminder5Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder5AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder5
	)
	default ColorAnimationType reminder5AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder5CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder5
	)
	default int reminder5CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder6",
			description = "Reminder 6",
			position = 26,
			closedByDefault = true
	)
	String reminder6= "reminder6";

	@ConfigItem(
			keyName = "enableReminder6",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder6
	)
	default boolean reminder6Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder6Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder6
	)
	default String reminder6Text() { return ""; }

	@ConfigItem(
			keyName = "reminder6Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder6
	)
	default Color reminder6Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder6Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder6
	)
	default String reminder6Times() { return ""; }

	@ConfigItem(
			keyName = "reminder6DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder6
	)
	default String reminder6DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder6Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder6
	)
	default String reminder6Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder6Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder6
	)
	default String reminder6Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder6Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder6
	)
	default String reminder6Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder6Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder6
	)
	default int reminder6Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder6RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder6
	)
	default String reminder6RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder6
	)
	default String reminder6NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder6
	)
	default String reminder6ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder6
	)
	default int reminder6Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder6Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder6
	)
	default int reminder6Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder6TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder6
	)
	default TimeUnit reminder6TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder6ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder6
	)
	default String reminder6ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder6Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder6
	)
	default boolean reminder6Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder6SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder6
	)
	default boolean reminder6SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder6panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder6
	)
	default RSAnchorType reminder6PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder6PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder6
	)
	default int reminder6PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder6PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder6
	)
	default int reminder6PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder6ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder6
	)
	default RSViewGroup.Gravity reminder6ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder6ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder6
	)
	default int reminder6ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder6Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder6
	)
	default boolean reminder6Image() { return false; }

	@ConfigItem(
			keyName = "Reminder6Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder6
	)
	default boolean reminder6Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder6AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder6
	)
	default ColorAnimationType reminder6AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder6CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder6
	)
	default int reminder6CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder7",
			description = "Reminder 7",
			position = 27,
			closedByDefault = true
	)
	String reminder7= "reminder7";

	@ConfigItem(
			keyName = "enableReminder7",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder7
	)
	default boolean reminder7Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder7Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder7
	)
	default String reminder7Text() { return ""; }

	@ConfigItem(
			keyName = "reminder7Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder7
	)
	default Color reminder7Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder7Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder7
	)
	default String reminder7Times() { return ""; }

	@ConfigItem(
			keyName = "reminder7DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder7
	)
	default String reminder7DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder7Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder7
	)
	default String reminder7Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder7Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder7
	)
	default String reminder7Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder7Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder7
	)
	default String reminder7Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder7Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder7
	)
	default int reminder7Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder7RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder7
	)
	default String reminder7RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder7
	)
	default String reminder7NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder7
	)
	default String reminder7ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder7
	)
	default int reminder7Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder7Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder7
	)
	default int reminder7Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder7TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder7
	)
	default TimeUnit reminder7TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder7ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder7
	)
	default String reminder7ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder7Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder7
	)
	default boolean reminder7Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder7SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder7
	)
	default boolean reminder7SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder7panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder7
	)
	default RSAnchorType reminder7PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder7PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder7
	)
	default int reminder7PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder7PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder7
	)
	default int reminder7PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder7ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder7
	)
	default RSViewGroup.Gravity reminder7ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder7ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder7
	)
	default int reminder7ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder7Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder7
	)
	default boolean reminder7Image() { return false; }

	@ConfigItem(
			keyName = "Reminder7Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder7
	)
	default boolean reminder7Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder7AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder7
	)
	default ColorAnimationType reminder7AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder7CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder7
	)
	default int reminder7CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder8",
			description = "Reminder 8",
			position = 28,
			closedByDefault = true
	)
	String reminder8= "reminder8";

	@ConfigItem(
			keyName = "enableReminder8",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder8
	)
	default boolean reminder8Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder8Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder8
	)
	default String reminder8Text() { return ""; }

	@ConfigItem(
			keyName = "reminder8Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder8
	)
	default Color reminder8Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder8Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder8
	)
	default String reminder8Times() { return ""; }

	@ConfigItem(
			keyName = "reminder8DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder8
	)
	default String reminder8DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder8Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder8
	)
	default String reminder8Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder8Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder8
	)
	default String reminder8Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder8Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder8
	)
	default String reminder8Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder8Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder8
	)
	default int reminder8Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder8RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder8
	)
	default String reminder8RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder8
	)
	default String reminder8NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder8
	)
	default String reminder8ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder8
	)
	default int reminder8Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder8Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder8
	)
	default int reminder8Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder8TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder8
	)
	default TimeUnit reminder8TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder8ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder8
	)
	default String reminder8ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder8Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder8
	)
	default boolean reminder8Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder8SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder8
	)
	default boolean reminder8SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder8panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder8
	)
	default RSAnchorType reminder8PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder8PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder8
	)
	default int reminder8PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder8PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder8
	)
	default int reminder8PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder8ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder8
	)
	default RSViewGroup.Gravity reminder8ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder8ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder8
	)
	default int reminder8ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder8Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder8
	)
	default boolean reminder8Image() { return false; }

	@ConfigItem(
			keyName = "Reminder8Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder8
	)
	default boolean reminder8Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder8AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder8
	)
	default ColorAnimationType reminder8AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder8CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder8
	)
	default int reminder8CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder9",
			description = "Reminder 9",
			position = 29,
			closedByDefault = true
	)
	String reminder9= "reminder9";

	@ConfigItem(
			keyName = "enableReminder9",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder9
	)
	default boolean reminder9Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder9Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder9
	)
	default String reminder9Text() { return ""; }

	@ConfigItem(
			keyName = "reminder9Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder9
	)
	default Color reminder9Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder9Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder9
	)
	default String reminder9Times() { return ""; }

	@ConfigItem(
			keyName = "reminder9DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder9
	)
	default String reminder9DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder9Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder9
	)
	default String reminder9Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder9Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder9
	)
	default String reminder9Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder9Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder9
	)
	default String reminder9Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder9Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder9
	)
	default int reminder9Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder9RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder9
	)
	default String reminder9RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder9
	)
	default String reminder9NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder9
	)
	default String reminder9ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder9
	)
	default int reminder9Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder9Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder9
	)
	default int reminder9Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder9TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder9
	)
	default TimeUnit reminder9TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder9ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder9
	)
	default String reminder9ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder9Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder9
	)
	default boolean reminder9Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder9SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder9
	)
	default boolean reminder9SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder9panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder9
	)
	default RSAnchorType reminder9PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder9PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder9
	)
	default int reminder9PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder9PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder9
	)
	default int reminder9PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder9ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder9
	)
	default RSViewGroup.Gravity reminder9ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder9ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder9
	)
	default int reminder9ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder9Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder9
	)
	default boolean reminder9Image() { return false; }

	@ConfigItem(
			keyName = "Reminder9Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder9
	)
	default boolean reminder9Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder9AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder9
	)
	default ColorAnimationType reminder9AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder9CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder9
	)
	default int reminder9CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder10",
			description = "Reminder 10",
			position = 30,
			closedByDefault = true
	)
	String reminder10= "reminder10";

	@ConfigItem(
			keyName = "enableReminder10",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder10
	)
	default boolean reminder10Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder10Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder10
	)
	default String reminder10Text() { return ""; }

	@ConfigItem(
			keyName = "reminder10Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder10
	)
	default Color reminder10Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder10Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder10
	)
	default String reminder10Times() { return ""; }

	@ConfigItem(
			keyName = "reminder10DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder10
	)
	default String reminder10DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder10Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder10
	)
	default String reminder10Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder10Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder10
	)
	default String reminder10Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder10Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder10
	)
	default String reminder10Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder10Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder10
	)
	default int reminder10Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder10RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder10
	)
	default String reminder10RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder10
	)
	default String reminder10NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder10
	)
	default String reminder10ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder10
	)
	default int reminder10Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder10Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder10
	)
	default int reminder10Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder10TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder10
	)
	default TimeUnit reminder10TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder10ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder10
	)
	default String reminder10ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder10Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder10
	)
	default boolean reminder10Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder10SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder10
	)
	default boolean reminder10SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder10panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder10
	)
	default RSAnchorType reminder10PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder10PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder10
	)
	default int reminder10PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder10PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder10
	)
	default int reminder10PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder10ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder10
	)
	default RSViewGroup.Gravity reminder10ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder10ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder10
	)
	default int reminder10ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder10Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder10
	)
	default boolean reminder10Image() { return false; }

	@ConfigItem(
			keyName = "Reminder10Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder10
	)
	default boolean reminder10Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder10AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder10
	)
	default ColorAnimationType reminder10AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder10CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder10
	)
	default int reminder10CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder11",
			description = "Reminder 11",
			position = 31,
			closedByDefault = true
	)
	String reminder11= "reminder11";

	@ConfigItem(
			keyName = "enableReminder11",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder11
	)
	default boolean reminder11Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder11Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder11
	)
	default String reminder11Text() { return ""; }

	@ConfigItem(
			keyName = "reminder11Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder11
	)
	default Color reminder11Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder11Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder11
	)
	default String reminder11Times() { return ""; }

	@ConfigItem(
			keyName = "reminder11DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder11
	)
	default String reminder11DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder11Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder11
	)
	default String reminder11Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder11Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder11
	)
	default String reminder11Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder11Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder11
	)
	default String reminder11Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder11Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder11
	)
	default int reminder11Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder11RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder11
	)
	default String reminder11RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder11
	)
	default String reminder11NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder11
	)
	default String reminder11ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder11
	)
	default int reminder11Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder11Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder11
	)
	default int reminder11Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder11TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder11
	)
	default TimeUnit reminder11TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder11ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder11
	)
	default String reminder11ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder11Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder11
	)
	default boolean reminder11Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder11SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder11
	)
	default boolean reminder11SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder11panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder11
	)
	default RSAnchorType reminder11PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder11PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder11
	)
	default int reminder11PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder11PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder11
	)
	default int reminder11PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder11ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder11
	)
	default RSViewGroup.Gravity reminder11ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder11ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder11
	)
	default int reminder11ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder11Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder11
	)
	default boolean reminder11Image() { return false; }

	@ConfigItem(
			keyName = "Reminder11Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder11
	)
	default boolean reminder11Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder11AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder11
	)
	default ColorAnimationType reminder11AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder11CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder11
	)
	default int reminder11CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder12",
			description = "Reminder 12",
			position = 32,
			closedByDefault = true
	)
	String reminder12= "reminder12";

	@ConfigItem(
			keyName = "enableReminder12",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder12
	)
	default boolean reminder12Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder12Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder12
	)
	default String reminder12Text() { return ""; }

	@ConfigItem(
			keyName = "reminder12Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder12
	)
	default Color reminder12Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder12Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder12
	)
	default String reminder12Times() { return ""; }

	@ConfigItem(
			keyName = "reminder12DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder12
	)
	default String reminder12DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder12Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder12
	)
	default String reminder12Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder12Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder12
	)
	default String reminder12Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder12Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder12
	)
	default String reminder12Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder12Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder12
	)
	default int reminder12Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder12RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder12
	)
	default String reminder12RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder12
	)
	default String reminder12NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder12
	)
	default String reminder12ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder12
	)
	default int reminder12Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder12Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder12
	)
	default int reminder12Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder12TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder12
	)
	default TimeUnit reminder12TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder12ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder12
	)
	default String reminder12ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder12Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder12
	)
	default boolean reminder12Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder12SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder12
	)
	default boolean reminder12SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder12panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder12
	)
	default RSAnchorType reminder12PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder12PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder12
	)
	default int reminder12PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder12PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder12
	)
	default int reminder12PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder12ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder12
	)
	default RSViewGroup.Gravity reminder12ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder12ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder12
	)
	default int reminder12ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder12Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder12
	)
	default boolean reminder12Image() { return false; }

	@ConfigItem(
			keyName = "Reminder12Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder12
	)
	default boolean reminder12Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder12AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder12
	)
	default ColorAnimationType reminder12AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder12CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder12
	)
	default int reminder12CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder13",
			description = "Reminder 13",
			position = 33,
			closedByDefault = true
	)
	String reminder13= "reminder13";

	@ConfigItem(
			keyName = "enableReminder13",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder13
	)
	default boolean reminder13Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder13Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder13
	)
	default String reminder13Text() { return ""; }

	@ConfigItem(
			keyName = "reminder13Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder13
	)
	default Color reminder13Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder13Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder13
	)
	default String reminder13Times() { return ""; }

	@ConfigItem(
			keyName = "reminder13DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder13
	)
	default String reminder13DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder13Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder13
	)
	default String reminder13Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder13Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder13
	)
	default String reminder13Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder13Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder13
	)
	default String reminder13Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder13Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder13
	)
	default int reminder13Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder13RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder13
	)
	default String reminder13RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder13
	)
	default String reminder13NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder13
	)
	default String reminder13ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder13
	)
	default int reminder13Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder13Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder13
	)
	default int reminder13Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder13TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder13
	)
	default TimeUnit reminder13TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder13ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder13
	)
	default String reminder13ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder13Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder13
	)
	default boolean reminder13Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder13SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder13
	)
	default boolean reminder13SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder13panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder13
	)
	default RSAnchorType reminder13PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder13PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder13
	)
	default int reminder13PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder13PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder13
	)
	default int reminder13PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder13ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder13
	)
	default RSViewGroup.Gravity reminder13ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder13ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder13
	)
	default int reminder13ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder13Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder13
	)
	default boolean reminder13Image() { return false; }

	@ConfigItem(
			keyName = "Reminder13Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder13
	)
	default boolean reminder13Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder13AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder13
	)
	default ColorAnimationType reminder13AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder13CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder13
	)
	default int reminder13CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder14",
			description = "Reminder 14",
			position = 34,
			closedByDefault = true
	)
	String reminder14= "reminder14";

	@ConfigItem(
			keyName = "enableReminder14",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder14
	)
	default boolean reminder14Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder14Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder14
	)
	default String reminder14Text() { return ""; }

	@ConfigItem(
			keyName = "reminder14Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder14
	)
	default Color reminder14Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder14Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder14
	)
	default String reminder14Times() { return ""; }

	@ConfigItem(
			keyName = "reminder14DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder14
	)
	default String reminder14DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder14Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder14
	)
	default String reminder14Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder14Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder14
	)
	default String reminder14Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder14Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder14
	)
	default String reminder14Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder14Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder14
	)
	default int reminder14Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder14RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder14
	)
	default String reminder14RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder14
	)
	default String reminder14NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder14
	)
	default String reminder14ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder14
	)
	default int reminder14Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder14Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder14
	)
	default int reminder14Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder14TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder14
	)
	default TimeUnit reminder14TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder14ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder14
	)
	default String reminder14ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder14Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder14
	)
	default boolean reminder14Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder14SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder14
	)
	default boolean reminder14SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder14panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder14
	)
	default RSAnchorType reminder14PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder14PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder14
	)
	default int reminder14PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder14PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder14
	)
	default int reminder14PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder14ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder14
	)
	default RSViewGroup.Gravity reminder14ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder14ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder14
	)
	default int reminder14ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder14Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder14
	)
	default boolean reminder14Image() { return false; }

	@ConfigItem(
			keyName = "Reminder14Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder14
	)
	default boolean reminder14Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder14AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder14
	)
	default ColorAnimationType reminder14AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder14CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder14
	)
	default int reminder14CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder15",
			description = "Reminder 15",
			position = 35,
			closedByDefault = true
	)
	String reminder15= "reminder15";

	@ConfigItem(
			keyName = "enableReminder15",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder15
	)
	default boolean reminder15Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder15Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder15
	)
	default String reminder15Text() { return ""; }

	@ConfigItem(
			keyName = "reminder15Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder15
	)
	default Color reminder15Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder15Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder15
	)
	default String reminder15Times() { return ""; }

	@ConfigItem(
			keyName = "reminder15DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder15
	)
	default String reminder15DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder15Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder15
	)
	default String reminder15Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder15Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder15
	)
	default String reminder15Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder15Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder15
	)
	default String reminder15Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder15Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder15
	)
	default int reminder15Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder15RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder15
	)
	default String reminder15RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder15
	)
	default String reminder15NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder15
	)
	default String reminder15ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder15
	)
	default int reminder15Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder15Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder15
	)
	default int reminder15Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder15TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder15
	)
	default TimeUnit reminder15TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder15ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder15
	)
	default String reminder15ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder15Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder15
	)
	default boolean reminder15Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder15SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder15
	)
	default boolean reminder15SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder15panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder15
	)
	default RSAnchorType reminder15PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder15PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder15
	)
	default int reminder15PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder15PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder15
	)
	default int reminder15PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder15ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder15
	)
	default RSViewGroup.Gravity reminder15ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder15ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder15
	)
	default int reminder15ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder15Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder15
	)
	default boolean reminder15Image() { return false; }

	@ConfigItem(
			keyName = "Reminder15Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder15
	)
	default boolean reminder15Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder15AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder15
	)
	default ColorAnimationType reminder15AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder15CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder15
	)
	default int reminder15CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder16",
			description = "Reminder 16",
			position = 36,
			closedByDefault = true
	)
	String reminder16= "reminder16";

	@ConfigItem(
			keyName = "enableReminder16",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder16
	)
	default boolean reminder16Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder16Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder16
	)
	default String reminder16Text() { return ""; }

	@ConfigItem(
			keyName = "reminder16Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder16
	)
	default Color reminder16Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder16Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder16
	)
	default String reminder16Times() { return ""; }

	@ConfigItem(
			keyName = "reminder16DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder16
	)
	default String reminder16DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder16Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder16
	)
	default String reminder16Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder16Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder16
	)
	default String reminder16Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder16Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder16
	)
	default String reminder16Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder16Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder16
	)
	default int reminder16Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder16RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder16
	)
	default String reminder16RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder16
	)
	default String reminder16NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder16
	)
	default String reminder16ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder16
	)
	default int reminder16Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder16Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder16
	)
	default int reminder16Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder16TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder16
	)
	default TimeUnit reminder16TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder16ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder16
	)
	default String reminder16ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder16Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder16
	)
	default boolean reminder16Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder16SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder16
	)
	default boolean reminder16SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder16panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder16
	)
	default RSAnchorType reminder16PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder16PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder16
	)
	default int reminder16PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder16PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder16
	)
	default int reminder16PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder16ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder16
	)
	default RSViewGroup.Gravity reminder16ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder16ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder16
	)
	default int reminder16ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder16Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder16
	)
	default boolean reminder16Image() { return false; }

	@ConfigItem(
			keyName = "Reminder16Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder16
	)
	default boolean reminder16Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder16AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder16
	)
	default ColorAnimationType reminder16AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder16CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder16
	)
	default int reminder16CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder17",
			description = "Reminder 17",
			position = 37,
			closedByDefault = true
	)
	String reminder17= "reminder17";

	@ConfigItem(
			keyName = "enableReminder17",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder17
	)
	default boolean reminder17Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder17Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder17
	)
	default String reminder17Text() { return ""; }

	@ConfigItem(
			keyName = "reminder17Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder17
	)
	default Color reminder17Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder17Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder17
	)
	default String reminder17Times() { return ""; }

	@ConfigItem(
			keyName = "reminder17DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder17
	)
	default String reminder17DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder17Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder17
	)
	default String reminder17Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder17Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder17
	)
	default String reminder17Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder17Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder17
	)
	default String reminder17Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder17Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder17
	)
	default int reminder17Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder17RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder17
	)
	default String reminder17RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder17
	)
	default String reminder17NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder17
	)
	default String reminder17ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder17
	)
	default int reminder17Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder17Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder17
	)
	default int reminder17Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder17TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder17
	)
	default TimeUnit reminder17TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder17ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder17
	)
	default String reminder17ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder17Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder17
	)
	default boolean reminder17Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder17SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder17
	)
	default boolean reminder17SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder17panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder17
	)
	default RSAnchorType reminder17PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder17PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder17
	)
	default int reminder17PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder17PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder17
	)
	default int reminder17PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder17ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder17
	)
	default RSViewGroup.Gravity reminder17ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder17ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder17
	)
	default int reminder17ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder17Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder17
	)
	default boolean reminder17Image() { return false; }

	@ConfigItem(
			keyName = "Reminder17Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder17
	)
	default boolean reminder17Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder17AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder17
	)
	default ColorAnimationType reminder17AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder17CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder17
	)
	default int reminder17CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder18",
			description = "Reminder 18",
			position = 38,
			closedByDefault = true
	)
	String reminder18= "reminder18";

	@ConfigItem(
			keyName = "enableReminder18",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder18
	)
	default boolean reminder18Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder18Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder18
	)
	default String reminder18Text() { return ""; }

	@ConfigItem(
			keyName = "reminder18Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder18
	)
	default Color reminder18Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder18Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder18
	)
	default String reminder18Times() { return ""; }

	@ConfigItem(
			keyName = "reminder18DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder18
	)
	default String reminder18DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder18Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder18
	)
	default String reminder18Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder18Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder18
	)
	default String reminder18Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder18Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder18
	)
	default String reminder18Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder18Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder18
	)
	default int reminder18Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder18RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder18
	)
	default String reminder18RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder18
	)
	default String reminder18NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder18
	)
	default String reminder18ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder18
	)
	default int reminder18Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder18Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder18
	)
	default int reminder18Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder18TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder18
	)
	default TimeUnit reminder18TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder18ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder18
	)
	default String reminder18ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder18Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder18
	)
	default boolean reminder18Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder18SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder18
	)
	default boolean reminder18SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder18panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder18
	)
	default RSAnchorType reminder18PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder18PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder18
	)
	default int reminder18PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder18PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder18
	)
	default int reminder18PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder18ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder18
	)
	default RSViewGroup.Gravity reminder18ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder18ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder18
	)
	default int reminder18ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder18Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder18
	)
	default boolean reminder18Image() { return false; }

	@ConfigItem(
			keyName = "Reminder18Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder18
	)
	default boolean reminder18Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder18AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder18
	)
	default ColorAnimationType reminder18AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder18CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder18
	)
	default int reminder18CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder19",
			description = "Reminder 19",
			position = 39,
			closedByDefault = true
	)
	String reminder19= "reminder19";

	@ConfigItem(
			keyName = "enableReminder19",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder19
	)
	default boolean reminder19Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder19Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder19
	)
	default String reminder19Text() { return ""; }

	@ConfigItem(
			keyName = "reminder19Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder19
	)
	default Color reminder19Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder19Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder19
	)
	default String reminder19Times() { return ""; }

	@ConfigItem(
			keyName = "reminder19DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder19
	)
	default String reminder19DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder19Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder19
	)
	default String reminder19Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder19Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder19
	)
	default String reminder19Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder19Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder19
	)
	default String reminder19Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder19Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder19
	)
	default int reminder19Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder19RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder19
	)
	default String reminder19RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder19
	)
	default String reminder19NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder19
	)
	default String reminder19ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder19
	)
	default int reminder19Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder19Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder19
	)
	default int reminder19Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder19TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder19
	)
	default TimeUnit reminder19TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder19ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder19
	)
	default String reminder19ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder19Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder19
	)
	default boolean reminder19Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder19SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder19
	)
	default boolean reminder19SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder19panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder19
	)
	default RSAnchorType reminder19PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder19PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder19
	)
	default int reminder19PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder19PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder19
	)
	default int reminder19PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder19ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder19
	)
	default RSViewGroup.Gravity reminder19ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder19ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder19
	)
	default int reminder19ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder19Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder19
	)
	default boolean reminder19Image() { return false; }

	@ConfigItem(
			keyName = "Reminder19Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder19
	)
	default boolean reminder19Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder19AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder19
	)
	default ColorAnimationType reminder19AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder19CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder19
	)
	default int reminder19CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder20",
			description = "Reminder 20",
			position = 40,
			closedByDefault = true
	)
	String reminder20= "reminder20";

	@ConfigItem(
			keyName = "enableReminder20",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder20
	)
	default boolean reminder20Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder20Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder20
	)
	default String reminder20Text() { return ""; }

	@ConfigItem(
			keyName = "reminder20Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder20
	)
	default Color reminder20Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder20Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder20
	)
	default String reminder20Times() { return ""; }

	@ConfigItem(
			keyName = "reminder20DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder20
	)
	default String reminder20DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder20Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder20
	)
	default String reminder20Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder20Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder20
	)
	default String reminder20Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder20Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder20
	)
	default String reminder20Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder20Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder20
	)
	default int reminder20Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder20RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder20
	)
	default String reminder20RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder20
	)
	default String reminder20NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder20
	)
	default String reminder20ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder20
	)
	default int reminder20Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder20Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder20
	)
	default int reminder20Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder20TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder20
	)
	default TimeUnit reminder20TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder20ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder20
	)
	default String reminder20ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder20Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder20
	)
	default boolean reminder20Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder20SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder20
	)
	default boolean reminder20SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder20panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder20
	)
	default RSAnchorType reminder20PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder20PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder20
	)
	default int reminder20PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder20PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder20
	)
	default int reminder20PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder20ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder20
	)
	default RSViewGroup.Gravity reminder20ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder20ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder20
	)
	default int reminder20ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder20Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder20
	)
	default boolean reminder20Image() { return false; }

	@ConfigItem(
			keyName = "Reminder20Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder20
	)
	default boolean reminder20Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder20AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder20
	)
	default ColorAnimationType reminder20AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder20CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder20
	)
	default int reminder20CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder21",
			description = "Reminder 21",
			position = 41,
			closedByDefault = true
	)
	String reminder21= "reminder21";

	@ConfigItem(
			keyName = "enableReminder21",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder21
	)
	default boolean reminder21Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder21Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder21
	)
	default String reminder21Text() { return ""; }

	@ConfigItem(
			keyName = "reminder21Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder21
	)
	default Color reminder21Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder21Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder21
	)
	default String reminder21Times() { return ""; }

	@ConfigItem(
			keyName = "reminder21DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder21
	)
	default String reminder21DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder21Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder21
	)
	default String reminder21Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder21Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder21
	)
	default String reminder21Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder21Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder21
	)
	default String reminder21Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder21Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder21
	)
	default int reminder21Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder21RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder21
	)
	default String reminder21RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder21
	)
	default String reminder21NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder21
	)
	default String reminder21ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder21
	)
	default int reminder21Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder21Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder21
	)
	default int reminder21Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder21TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder21
	)
	default TimeUnit reminder21TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder21ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder21
	)
	default String reminder21ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder21Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder21
	)
	default boolean reminder21Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder21SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder21
	)
	default boolean reminder21SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder21panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder21
	)
	default RSAnchorType reminder21PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder21PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder21
	)
	default int reminder21PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder21PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder21
	)
	default int reminder21PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder21ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder21
	)
	default RSViewGroup.Gravity reminder21ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder21ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder21
	)
	default int reminder21ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder21Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder21
	)
	default boolean reminder21Image() { return false; }

	@ConfigItem(
			keyName = "Reminder21Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder21
	)
	default boolean reminder21Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder21AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder21
	)
	default ColorAnimationType reminder21AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder21CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder21
	)
	default int reminder21CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder22",
			description = "Reminder 22",
			position = 42,
			closedByDefault = true
	)
	String reminder22= "reminder22";

	@ConfigItem(
			keyName = "enableReminder22",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder22
	)
	default boolean reminder22Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder22Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder22
	)
	default String reminder22Text() { return ""; }

	@ConfigItem(
			keyName = "reminder22Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder22
	)
	default Color reminder22Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder22Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder22
	)
	default String reminder22Times() { return ""; }

	@ConfigItem(
			keyName = "reminder22DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder22
	)
	default String reminder22DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder22Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder22
	)
	default String reminder22Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder22Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder22
	)
	default String reminder22Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder22Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder22
	)
	default String reminder22Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder22Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder22
	)
	default int reminder22Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder22RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder22
	)
	default String reminder22RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder22
	)
	default String reminder22NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder22
	)
	default String reminder22ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder22
	)
	default int reminder22Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder22Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder22
	)
	default int reminder22Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder22TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder22
	)
	default TimeUnit reminder22TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder22ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder22
	)
	default String reminder22ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder22Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder22
	)
	default boolean reminder22Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder22SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder22
	)
	default boolean reminder22SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder22panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder22
	)
	default RSAnchorType reminder22PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder22PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder22
	)
	default int reminder22PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder22PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder22
	)
	default int reminder22PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder22ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder22
	)
	default RSViewGroup.Gravity reminder22ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder22ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder22
	)
	default int reminder22ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder22Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder22
	)
	default boolean reminder22Image() { return false; }

	@ConfigItem(
			keyName = "Reminder22Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder22
	)
	default boolean reminder22Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder22AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder22
	)
	default ColorAnimationType reminder22AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder22CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder22
	)
	default int reminder22CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder23",
			description = "Reminder 23",
			position = 43,
			closedByDefault = true
	)
	String reminder23= "reminder23";

	@ConfigItem(
			keyName = "enableReminder23",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder23
	)
	default boolean reminder23Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder23Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder23
	)
	default String reminder23Text() { return ""; }

	@ConfigItem(
			keyName = "reminder23Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder23
	)
	default Color reminder23Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder23Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder23
	)
	default String reminder23Times() { return ""; }

	@ConfigItem(
			keyName = "reminder23DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder23
	)
	default String reminder23DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder23Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder23
	)
	default String reminder23Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder23Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder23
	)
	default String reminder23Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder23Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder23
	)
	default String reminder23Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder23Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder23
	)
	default int reminder23Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder23RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder23
	)
	default String reminder23RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder23
	)
	default String reminder23NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder23
	)
	default String reminder23ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder23
	)
	default int reminder23Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder23Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder23
	)
	default int reminder23Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder23TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder23
	)
	default TimeUnit reminder23TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder23ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder23
	)
	default String reminder23ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder23Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder23
	)
	default boolean reminder23Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder23SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder23
	)
	default boolean reminder23SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder23panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder23
	)
	default RSAnchorType reminder23PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder23PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder23
	)
	default int reminder23PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder23PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder23
	)
	default int reminder23PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder23ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder23
	)
	default RSViewGroup.Gravity reminder23ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder23ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder23
	)
	default int reminder23ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder23Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder23
	)
	default boolean reminder23Image() { return false; }

	@ConfigItem(
			keyName = "Reminder23Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder23
	)
	default boolean reminder23Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder23AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder23
	)
	default ColorAnimationType reminder23AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder23CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder23
	)
	default int reminder23CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder24",
			description = "Reminder 24",
			position = 44,
			closedByDefault = true
	)
	String reminder24= "reminder24";

	@ConfigItem(
			keyName = "enableReminder24",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder24
	)
	default boolean reminder24Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder24Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder24
	)
	default String reminder24Text() { return ""; }

	@ConfigItem(
			keyName = "reminder24Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder24
	)
	default Color reminder24Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder24Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder24
	)
	default String reminder24Times() { return ""; }

	@ConfigItem(
			keyName = "reminder24DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder24
	)
	default String reminder24DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder24Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder24
	)
	default String reminder24Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder24Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder24
	)
	default String reminder24Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder24Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder24
	)
	default String reminder24Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder24Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder24
	)
	default int reminder24Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder24RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder24
	)
	default String reminder24RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder24
	)
	default String reminder24NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder24
	)
	default String reminder24ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder24
	)
	default int reminder24Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder24Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder24
	)
	default int reminder24Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder24TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder24
	)
	default TimeUnit reminder24TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder24ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder24
	)
	default String reminder24ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder24Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder24
	)
	default boolean reminder24Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder24SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder24
	)
	default boolean reminder24SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder24panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder24
	)
	default RSAnchorType reminder24PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder24PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder24
	)
	default int reminder24PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder24PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder24
	)
	default int reminder24PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder24ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder24
	)
	default RSViewGroup.Gravity reminder24ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder24ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder24
	)
	default int reminder24ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder24Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder24
	)
	default boolean reminder24Image() { return false; }

	@ConfigItem(
			keyName = "Reminder24Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder24
	)
	default boolean reminder24Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder24AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder24
	)
	default ColorAnimationType reminder24AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder24CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder24
	)
	default int reminder24CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder25",
			description = "Reminder 25",
			position = 45,
			closedByDefault = true
	)
	String reminder25= "reminder25";

	@ConfigItem(
			keyName = "enableReminder25",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder25
	)
	default boolean reminder25Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder25Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder25
	)
	default String reminder25Text() { return ""; }

	@ConfigItem(
			keyName = "reminder25Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder25
	)
	default Color reminder25Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder25Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder25
	)
	default String reminder25Times() { return ""; }

	@ConfigItem(
			keyName = "reminder25DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder25
	)
	default String reminder25DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder25Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder25
	)
	default String reminder25Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder25Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder25
	)
	default String reminder25Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder25Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder25
	)
	default String reminder25Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder25Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder25
	)
	default int reminder25Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder25RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder25
	)
	default String reminder25RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder25
	)
	default String reminder25NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder25
	)
	default String reminder25ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder25
	)
	default int reminder25Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder25Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder25
	)
	default int reminder25Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder25TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder25
	)
	default TimeUnit reminder25TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder25ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder25
	)
	default String reminder25ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder25Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder25
	)
	default boolean reminder25Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder25SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder25
	)
	default boolean reminder25SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder25panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder25
	)
	default RSAnchorType reminder25PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder25PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder25
	)
	default int reminder25PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder25PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder25
	)
	default int reminder25PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder25ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder25
	)
	default RSViewGroup.Gravity reminder25ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder25ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder25
	)
	default int reminder25ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder25Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder25
	)
	default boolean reminder25Image() { return false; }

	@ConfigItem(
			keyName = "Reminder25Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder25
	)
	default boolean reminder25Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder25AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder25
	)
	default ColorAnimationType reminder25AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder25CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder25
	)
	default int reminder25CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder26",
			description = "Reminder 26",
			position = 46,
			closedByDefault = true
	)
	String reminder26= "reminder26";

	@ConfigItem(
			keyName = "enableReminder26",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder26
	)
	default boolean reminder26Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder26Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder26
	)
	default String reminder26Text() { return ""; }

	@ConfigItem(
			keyName = "reminder26Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder26
	)
	default Color reminder26Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder26Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder26
	)
	default String reminder26Times() { return ""; }

	@ConfigItem(
			keyName = "reminder26DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder26
	)
	default String reminder26DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder26Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder26
	)
	default String reminder26Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder26Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder26
	)
	default String reminder26Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder26Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder26
	)
	default String reminder26Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder26Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder26
	)
	default int reminder26Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder26RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder26
	)
	default String reminder26RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder26
	)
	default String reminder26NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder26
	)
	default String reminder26ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder26
	)
	default int reminder26Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder26Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder26
	)
	default int reminder26Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder26TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder26
	)
	default TimeUnit reminder26TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder26ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder26
	)
	default String reminder26ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder26Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder26
	)
	default boolean reminder26Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder26SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder26
	)
	default boolean reminder26SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder26panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder26
	)
	default RSAnchorType reminder26PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder26PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder26
	)
	default int reminder26PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder26PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder26
	)
	default int reminder26PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder26ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder26
	)
	default RSViewGroup.Gravity reminder26ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder26ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder26
	)
	default int reminder26ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder26Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder26
	)
	default boolean reminder26Image() { return false; }

	@ConfigItem(
			keyName = "Reminder26Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder26
	)
	default boolean reminder26Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder26AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder26
	)
	default ColorAnimationType reminder26AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder26CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder26
	)
	default int reminder26CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder27",
			description = "Reminder 27",
			position = 47,
			closedByDefault = true
	)
	String reminder27= "reminder27";

	@ConfigItem(
			keyName = "enableReminder27",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder27
	)
	default boolean reminder27Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder27Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder27
	)
	default String reminder27Text() { return ""; }

	@ConfigItem(
			keyName = "reminder27Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder27
	)
	default Color reminder27Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder27Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder27
	)
	default String reminder27Times() { return ""; }

	@ConfigItem(
			keyName = "reminder27DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder27
	)
	default String reminder27DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder27Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder27
	)
	default String reminder27Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder27Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder27
	)
	default String reminder27Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder27Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder27
	)
	default String reminder27Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder27Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder27
	)
	default int reminder27Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder27RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder27
	)
	default String reminder27RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder27
	)
	default String reminder27NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder27
	)
	default String reminder27ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder27
	)
	default int reminder27Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder27Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder27
	)
	default int reminder27Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder27TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder27
	)
	default TimeUnit reminder27TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder27ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder27
	)
	default String reminder27ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder27Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder27
	)
	default boolean reminder27Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder27SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder27
	)
	default boolean reminder27SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder27panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder27
	)
	default RSAnchorType reminder27PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder27PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder27
	)
	default int reminder27PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder27PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder27
	)
	default int reminder27PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder27ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder27
	)
	default RSViewGroup.Gravity reminder27ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder27ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder27
	)
	default int reminder27ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder27Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder27
	)
	default boolean reminder27Image() { return false; }

	@ConfigItem(
			keyName = "Reminder27Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder27
	)
	default boolean reminder27Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder27AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder27
	)
	default ColorAnimationType reminder27AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder27CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder27
	)
	default int reminder27CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder28",
			description = "Reminder 28",
			position = 48,
			closedByDefault = true
	)
	String reminder28= "reminder28";

	@ConfigItem(
			keyName = "enableReminder28",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder28
	)
	default boolean reminder28Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder28Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder28
	)
	default String reminder28Text() { return ""; }

	@ConfigItem(
			keyName = "reminder28Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder28
	)
	default Color reminder28Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder28Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder28
	)
	default String reminder28Times() { return ""; }

	@ConfigItem(
			keyName = "reminder28DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder28
	)
	default String reminder28DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder28Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder28
	)
	default String reminder28Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder28Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder28
	)
	default String reminder28Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder28Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder28
	)
	default String reminder28Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder28Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder28
	)
	default int reminder28Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder28RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder28
	)
	default String reminder28RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder28
	)
	default String reminder28NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder28
	)
	default String reminder28ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder28
	)
	default int reminder28Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder28Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder28
	)
	default int reminder28Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder28TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder28
	)
	default TimeUnit reminder28TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder28ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder28
	)
	default String reminder28ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder28Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder28
	)
	default boolean reminder28Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder28SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder28
	)
	default boolean reminder28SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder28panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder28
	)
	default RSAnchorType reminder28PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder28PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder28
	)
	default int reminder28PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder28PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder28
	)
	default int reminder28PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder28ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder28
	)
	default RSViewGroup.Gravity reminder28ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder28ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder28
	)
	default int reminder28ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder28Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder28
	)
	default boolean reminder28Image() { return false; }

	@ConfigItem(
			keyName = "Reminder28Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder28
	)
	default boolean reminder28Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder28AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder28
	)
	default ColorAnimationType reminder28AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder28CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder28
	)
	default int reminder28CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder29",
			description = "Reminder 29",
			position = 49,
			closedByDefault = true
	)
	String reminder29= "reminder29";

	@ConfigItem(
			keyName = "enableReminder29",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder29
	)
	default boolean reminder29Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder29Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder29
	)
	default String reminder29Text() { return ""; }

	@ConfigItem(
			keyName = "reminder29Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder29
	)
	default Color reminder29Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder29Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder29
	)
	default String reminder29Times() { return ""; }

	@ConfigItem(
			keyName = "reminder29DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder29
	)
	default String reminder29DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder29Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder29
	)
	default String reminder29Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder29Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder29
	)
	default String reminder29Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder29Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder29
	)
	default String reminder29Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder29Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder29
	)
	default int reminder29Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder29RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder29
	)
	default String reminder29RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder29
	)
	default String reminder29NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder29
	)
	default String reminder29ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder29
	)
	default int reminder29Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder29Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder29
	)
	default int reminder29Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder29TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder29
	)
	default TimeUnit reminder29TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder29ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder29
	)
	default String reminder29ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder29Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder29
	)
	default boolean reminder29Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder29SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder29
	)
	default boolean reminder29SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder29panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder29
	)
	default RSAnchorType reminder29PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder29PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder29
	)
	default int reminder29PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder29PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder29
	)
	default int reminder29PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder29ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder29
	)
	default RSViewGroup.Gravity reminder29ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder29ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder29
	)
	default int reminder29ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder29Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder29
	)
	default boolean reminder29Image() { return false; }

	@ConfigItem(
			keyName = "Reminder29Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder29
	)
	default boolean reminder29Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder29AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder29
	)
	default ColorAnimationType reminder29AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder29CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder29
	)
	default int reminder29CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder30",
			description = "Reminder 30",
			position = 50,
			closedByDefault = true
	)
	String reminder30= "reminder30";

	@ConfigItem(
			keyName = "enableReminder30",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder30
	)
	default boolean reminder30Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder30Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder30
	)
	default String reminder30Text() { return ""; }

	@ConfigItem(
			keyName = "reminder30Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder30
	)
	default Color reminder30Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder30Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder30
	)
	default String reminder30Times() { return ""; }

	@ConfigItem(
			keyName = "reminder30DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder30
	)
	default String reminder30DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder30Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder30
	)
	default String reminder30Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder30Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder30
	)
	default String reminder30Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder30Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder30
	)
	default String reminder30Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder30Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder30
	)
	default int reminder30Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder30RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder30
	)
	default String reminder30RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder30
	)
	default String reminder30NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder30
	)
	default String reminder30ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder30
	)
	default int reminder30Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder30Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder30
	)
	default int reminder30Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder30TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder30
	)
	default TimeUnit reminder30TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder30ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder30
	)
	default String reminder30ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder30Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder30
	)
	default boolean reminder30Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder30SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder30
	)
	default boolean reminder30SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder30panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder30
	)
	default RSAnchorType reminder30PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder30PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder30
	)
	default int reminder30PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder30PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder30
	)
	default int reminder30PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder30ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder30
	)
	default RSViewGroup.Gravity reminder30ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder30ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder30
	)
	default int reminder30ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder30Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder30
	)
	default boolean reminder30Image() { return false; }

	@ConfigItem(
			keyName = "Reminder30Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder30
	)
	default boolean reminder30Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder30AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder30
	)
	default ColorAnimationType reminder30AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder30CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder30
	)
	default int reminder30CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder31",
			description = "Reminder 31",
			position = 51,
			closedByDefault = true
	)
	String reminder31= "reminder31";

	@ConfigItem(
			keyName = "enableReminder31",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder31
	)
	default boolean reminder31Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder31Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder31
	)
	default String reminder31Text() { return ""; }

	@ConfigItem(
			keyName = "reminder31Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder31
	)
	default Color reminder31Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder31Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder31
	)
	default String reminder31Times() { return ""; }

	@ConfigItem(
			keyName = "reminder31DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder31
	)
	default String reminder31DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder31Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder31
	)
	default String reminder31Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder31Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder31
	)
	default String reminder31Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder31Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder31
	)
	default String reminder31Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder31Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder31
	)
	default int reminder31Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder31RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder31
	)
	default String reminder31RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder31
	)
	default String reminder31NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder31
	)
	default String reminder31ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder31
	)
	default int reminder31Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder31Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder31
	)
	default int reminder31Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder31TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder31
	)
	default TimeUnit reminder31TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder31ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder31
	)
	default String reminder31ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder31Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder31
	)
	default boolean reminder31Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder31SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder31
	)
	default boolean reminder31SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder31panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder31
	)
	default RSAnchorType reminder31PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder31PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder31
	)
	default int reminder31PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder31PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder31
	)
	default int reminder31PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder31ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder31
	)
	default RSViewGroup.Gravity reminder31ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder31ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder31
	)
	default int reminder31ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder31Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder31
	)
	default boolean reminder31Image() { return false; }

	@ConfigItem(
			keyName = "Reminder31Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder31
	)
	default boolean reminder31Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder31AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder31
	)
	default ColorAnimationType reminder31AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder31CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder31
	)
	default int reminder31CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder32",
			description = "Reminder 32",
			position = 52,
			closedByDefault = true
	)
	String reminder32= "reminder32";

	@ConfigItem(
			keyName = "enableReminder32",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder32
	)
	default boolean reminder32Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder32Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder32
	)
	default String reminder32Text() { return ""; }

	@ConfigItem(
			keyName = "reminder32Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder32
	)
	default Color reminder32Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder32Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder32
	)
	default String reminder32Times() { return ""; }

	@ConfigItem(
			keyName = "reminder32DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder32
	)
	default String reminder32DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder32Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder32
	)
	default String reminder32Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder32Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder32
	)
	default String reminder32Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder32Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder32
	)
	default String reminder32Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder32Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder32
	)
	default int reminder32Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder32RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder32
	)
	default String reminder32RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder32
	)
	default String reminder32NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder32
	)
	default String reminder32ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder32
	)
	default int reminder32Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder32Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder32
	)
	default int reminder32Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder32TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder32
	)
	default TimeUnit reminder32TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder32ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder32
	)
	default String reminder32ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder32Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder32
	)
	default boolean reminder32Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder32SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder32
	)
	default boolean reminder32SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder32panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder32
	)
	default RSAnchorType reminder32PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder32PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder32
	)
	default int reminder32PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder32PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder32
	)
	default int reminder32PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder32ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder32
	)
	default RSViewGroup.Gravity reminder32ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder32ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder32
	)
	default int reminder32ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder32Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder32
	)
	default boolean reminder32Image() { return false; }

	@ConfigItem(
			keyName = "Reminder32Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder32
	)
	default boolean reminder32Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder32AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder32
	)
	default ColorAnimationType reminder32AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder32CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder32
	)
	default int reminder32CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder33",
			description = "Reminder 33",
			position = 53,
			closedByDefault = true
	)
	String reminder33= "reminder33";

	@ConfigItem(
			keyName = "enableReminder33",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder33
	)
	default boolean reminder33Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder33Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder33
	)
	default String reminder33Text() { return ""; }

	@ConfigItem(
			keyName = "reminder33Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder33
	)
	default Color reminder33Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder33Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder33
	)
	default String reminder33Times() { return ""; }

	@ConfigItem(
			keyName = "reminder33DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder33
	)
	default String reminder33DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder33Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder33
	)
	default String reminder33Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder33Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder33
	)
	default String reminder33Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder33Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder33
	)
	default String reminder33Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder33Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder33
	)
	default int reminder33Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder33RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder33
	)
	default String reminder33RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder33
	)
	default String reminder33NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder33
	)
	default String reminder33ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder33
	)
	default int reminder33Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder33Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder33
	)
	default int reminder33Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder33TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder33
	)
	default TimeUnit reminder33TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder33ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder33
	)
	default String reminder33ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder33Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder33
	)
	default boolean reminder33Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder33SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder33
	)
	default boolean reminder33SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder33panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder33
	)
	default RSAnchorType reminder33PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder33PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder33
	)
	default int reminder33PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder33PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder33
	)
	default int reminder33PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder33ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder33
	)
	default RSViewGroup.Gravity reminder33ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder33ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder33
	)
	default int reminder33ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder33Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder33
	)
	default boolean reminder33Image() { return false; }

	@ConfigItem(
			keyName = "Reminder33Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder33
	)
	default boolean reminder33Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder33AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder33
	)
	default ColorAnimationType reminder33AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder33CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder33
	)
	default int reminder33CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder34",
			description = "Reminder 34",
			position = 54,
			closedByDefault = true
	)
	String reminder34= "reminder34";

	@ConfigItem(
			keyName = "enableReminder34",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder34
	)
	default boolean reminder34Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder34Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder34
	)
	default String reminder34Text() { return ""; }

	@ConfigItem(
			keyName = "reminder34Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder34
	)
	default Color reminder34Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder34Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder34
	)
	default String reminder34Times() { return ""; }

	@ConfigItem(
			keyName = "reminder34DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder34
	)
	default String reminder34DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder34Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder34
	)
	default String reminder34Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder34Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder34
	)
	default String reminder34Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder34Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder34
	)
	default String reminder34Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder34Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder34
	)
	default int reminder34Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder34RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder34
	)
	default String reminder34RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder34
	)
	default String reminder34NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder34
	)
	default String reminder34ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder34
	)
	default int reminder34Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder34Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder34
	)
	default int reminder34Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder34TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder34
	)
	default TimeUnit reminder34TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder34ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder34
	)
	default String reminder34ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder34Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder34
	)
	default boolean reminder34Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder34SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder34
	)
	default boolean reminder34SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder34panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder34
	)
	default RSAnchorType reminder34PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder34PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder34
	)
	default int reminder34PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder34PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder34
	)
	default int reminder34PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder34ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder34
	)
	default RSViewGroup.Gravity reminder34ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder34ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder34
	)
	default int reminder34ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder34Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder34
	)
	default boolean reminder34Image() { return false; }

	@ConfigItem(
			keyName = "Reminder34Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder34
	)
	default boolean reminder34Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder34AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder34
	)
	default ColorAnimationType reminder34AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder34CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder34
	)
	default int reminder34CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder35",
			description = "Reminder 35",
			position = 55,
			closedByDefault = true
	)
	String reminder35= "reminder35";

	@ConfigItem(
			keyName = "enableReminder35",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder35
	)
	default boolean reminder35Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder35Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder35
	)
	default String reminder35Text() { return ""; }

	@ConfigItem(
			keyName = "reminder35Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder35
	)
	default Color reminder35Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder35Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder35
	)
	default String reminder35Times() { return ""; }

	@ConfigItem(
			keyName = "reminder35DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder35
	)
	default String reminder35DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder35Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder35
	)
	default String reminder35Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder35Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder35
	)
	default String reminder35Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder35Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder35
	)
	default String reminder35Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder35Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder35
	)
	default int reminder35Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder35RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder35
	)
	default String reminder35RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder35
	)
	default String reminder35NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder35
	)
	default String reminder35ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder35
	)
	default int reminder35Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder35Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder35
	)
	default int reminder35Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder35TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder35
	)
	default TimeUnit reminder35TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder35ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder35
	)
	default String reminder35ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder35Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder35
	)
	default boolean reminder35Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder35SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder35
	)
	default boolean reminder35SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder35panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder35
	)
	default RSAnchorType reminder35PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder35PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder35
	)
	default int reminder35PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder35PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder35
	)
	default int reminder35PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder35ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder35
	)
	default RSViewGroup.Gravity reminder35ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder35ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder35
	)
	default int reminder35ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder35Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder35
	)
	default boolean reminder35Image() { return false; }

	@ConfigItem(
			keyName = "Reminder35Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder35
	)
	default boolean reminder35Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder35AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder35
	)
	default ColorAnimationType reminder35AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder35CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder35
	)
	default int reminder35CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder36",
			description = "Reminder 36",
			position = 56,
			closedByDefault = true
	)
	String reminder36= "reminder36";

	@ConfigItem(
			keyName = "enableReminder36",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder36
	)
	default boolean reminder36Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder36Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder36
	)
	default String reminder36Text() { return ""; }

	@ConfigItem(
			keyName = "reminder36Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder36
	)
	default Color reminder36Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder36Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder36
	)
	default String reminder36Times() { return ""; }

	@ConfigItem(
			keyName = "reminder36DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder36
	)
	default String reminder36DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder36Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder36
	)
	default String reminder36Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder36Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder36
	)
	default String reminder36Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder36Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder36
	)
	default String reminder36Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder36Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder36
	)
	default int reminder36Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder36RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder36
	)
	default String reminder36RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder36
	)
	default String reminder36NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder36
	)
	default String reminder36ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder36
	)
	default int reminder36Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder36Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder36
	)
	default int reminder36Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder36TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder36
	)
	default TimeUnit reminder36TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder36ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder36
	)
	default String reminder36ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder36Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder36
	)
	default boolean reminder36Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder36SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder36
	)
	default boolean reminder36SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder36panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder36
	)
	default RSAnchorType reminder36PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder36PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder36
	)
	default int reminder36PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder36PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder36
	)
	default int reminder36PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder36ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder36
	)
	default RSViewGroup.Gravity reminder36ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder36ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder36
	)
	default int reminder36ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder36Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder36
	)
	default boolean reminder36Image() { return false; }

	@ConfigItem(
			keyName = "Reminder36Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder36
	)
	default boolean reminder36Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder36AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder36
	)
	default ColorAnimationType reminder36AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder36CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder36
	)
	default int reminder36CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder37",
			description = "Reminder 37",
			position = 57,
			closedByDefault = true
	)
	String reminder37= "reminder37";

	@ConfigItem(
			keyName = "enableReminder37",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder37
	)
	default boolean reminder37Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder37Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder37
	)
	default String reminder37Text() { return ""; }

	@ConfigItem(
			keyName = "reminder37Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder37
	)
	default Color reminder37Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder37Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder37
	)
	default String reminder37Times() { return ""; }

	@ConfigItem(
			keyName = "reminder37DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder37
	)
	default String reminder37DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder37Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder37
	)
	default String reminder37Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder37Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder37
	)
	default String reminder37Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder37Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder37
	)
	default String reminder37Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder37Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder37
	)
	default int reminder37Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder37RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder37
	)
	default String reminder37RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder37
	)
	default String reminder37NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder37
	)
	default String reminder37ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder37
	)
	default int reminder37Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder37Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder37
	)
	default int reminder37Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder37TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder37
	)
	default TimeUnit reminder37TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder37ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder37
	)
	default String reminder37ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder37Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder37
	)
	default boolean reminder37Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder37SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder37
	)
	default boolean reminder37SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder37panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder37
	)
	default RSAnchorType reminder37PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder37PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder37
	)
	default int reminder37PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder37PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder37
	)
	default int reminder37PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder37ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder37
	)
	default RSViewGroup.Gravity reminder37ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder37ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder37
	)
	default int reminder37ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder37Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder37
	)
	default boolean reminder37Image() { return false; }

	@ConfigItem(
			keyName = "Reminder37Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder37
	)
	default boolean reminder37Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder37AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder37
	)
	default ColorAnimationType reminder37AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder37CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder37
	)
	default int reminder37CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder38",
			description = "Reminder 38",
			position = 58,
			closedByDefault = true
	)
	String reminder38= "reminder38";

	@ConfigItem(
			keyName = "enableReminder38",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder38
	)
	default boolean reminder38Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder38Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder38
	)
	default String reminder38Text() { return ""; }

	@ConfigItem(
			keyName = "reminder38Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder38
	)
	default Color reminder38Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder38Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder38
	)
	default String reminder38Times() { return ""; }

	@ConfigItem(
			keyName = "reminder38DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder38
	)
	default String reminder38DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder38Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder38
	)
	default String reminder38Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder38Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder38
	)
	default String reminder38Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder38Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder38
	)
	default String reminder38Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder38Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder38
	)
	default int reminder38Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder38RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder38
	)
	default String reminder38RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder38
	)
	default String reminder38NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder38
	)
	default String reminder38ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder38
	)
	default int reminder38Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder38Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder38
	)
	default int reminder38Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder38TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder38
	)
	default TimeUnit reminder38TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder38ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder38
	)
	default String reminder38ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder38Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder38
	)
	default boolean reminder38Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder38SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder38
	)
	default boolean reminder38SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder38panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder38
	)
	default RSAnchorType reminder38PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder38PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder38
	)
	default int reminder38PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder38PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder38
	)
	default int reminder38PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder38ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder38
	)
	default RSViewGroup.Gravity reminder38ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder38ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder38
	)
	default int reminder38ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder38Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder38
	)
	default boolean reminder38Image() { return false; }

	@ConfigItem(
			keyName = "Reminder38Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder38
	)
	default boolean reminder38Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder38AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder38
	)
	default ColorAnimationType reminder38AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder38CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder38
	)
	default int reminder38CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder39",
			description = "Reminder 39",
			position = 59,
			closedByDefault = true
	)
	String reminder39= "reminder39";

	@ConfigItem(
			keyName = "enableReminder39",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder39
	)
	default boolean reminder39Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder39Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder39
	)
	default String reminder39Text() { return ""; }

	@ConfigItem(
			keyName = "reminder39Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder39
	)
	default Color reminder39Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder39Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder39
	)
	default String reminder39Times() { return ""; }

	@ConfigItem(
			keyName = "reminder39DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder39
	)
	default String reminder39DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder39Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder39
	)
	default String reminder39Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder39Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder39
	)
	default String reminder39Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder39Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder39
	)
	default String reminder39Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder39Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder39
	)
	default int reminder39Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder39RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder39
	)
	default String reminder39RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder39
	)
	default String reminder39NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder39
	)
	default String reminder39ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder39
	)
	default int reminder39Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder39Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder39
	)
	default int reminder39Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder39TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder39
	)
	default TimeUnit reminder39TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder39ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder39
	)
	default String reminder39ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder39Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder39
	)
	default boolean reminder39Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder39SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder39
	)
	default boolean reminder39SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder39panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder39
	)
	default RSAnchorType reminder39PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder39PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder39
	)
	default int reminder39PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder39PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder39
	)
	default int reminder39PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder39ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder39
	)
	default RSViewGroup.Gravity reminder39ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder39ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder39
	)
	default int reminder39ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder39Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder39
	)
	default boolean reminder39Image() { return false; }

	@ConfigItem(
			keyName = "Reminder39Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder39
	)
	default boolean reminder39Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder39AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder39
	)
	default ColorAnimationType reminder39AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder39CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder39
	)
	default int reminder39CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder40",
			description = "Reminder 40",
			position = 60,
			closedByDefault = true
	)
	String reminder40= "reminder40";

	@ConfigItem(
			keyName = "enableReminder40",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder40
	)
	default boolean reminder40Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder40Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder40
	)
	default String reminder40Text() { return ""; }

	@ConfigItem(
			keyName = "reminder40Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder40
	)
	default Color reminder40Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder40Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder40
	)
	default String reminder40Times() { return ""; }

	@ConfigItem(
			keyName = "reminder40DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder40
	)
	default String reminder40DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder40Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder40
	)
	default String reminder40Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder40Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder40
	)
	default String reminder40Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder40Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder40
	)
	default String reminder40Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder40Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder40
	)
	default int reminder40Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder40RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder40
	)
	default String reminder40RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder40
	)
	default String reminder40NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder40
	)
	default String reminder40ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder40
	)
	default int reminder40Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder40Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder40
	)
	default int reminder40Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder40TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder40
	)
	default TimeUnit reminder40TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder40ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder40
	)
	default String reminder40ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder40Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder40
	)
	default boolean reminder40Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder40SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder40
	)
	default boolean reminder40SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder40panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder40
	)
	default RSAnchorType reminder40PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder40PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder40
	)
	default int reminder40PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder40PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder40
	)
	default int reminder40PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder40ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder40
	)
	default RSViewGroup.Gravity reminder40ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder40ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder40
	)
	default int reminder40ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder40Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder40
	)
	default boolean reminder40Image() { return false; }

	@ConfigItem(
			keyName = "Reminder40Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder40
	)
	default boolean reminder40Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder40AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder40
	)
	default ColorAnimationType reminder40AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder40CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder40
	)
	default int reminder40CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder41",
			description = "Reminder 41",
			position = 61,
			closedByDefault = true
	)
	String reminder41= "reminder41";

	@ConfigItem(
			keyName = "enableReminder41",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder41
	)
	default boolean reminder41Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder41Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder41
	)
	default String reminder41Text() { return ""; }

	@ConfigItem(
			keyName = "reminder41Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder41
	)
	default Color reminder41Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder41Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder41
	)
	default String reminder41Times() { return ""; }

	@ConfigItem(
			keyName = "reminder41DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder41
	)
	default String reminder41DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder41Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder41
	)
	default String reminder41Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder41Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder41
	)
	default String reminder41Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder41Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder41
	)
	default String reminder41Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder41Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder41
	)
	default int reminder41Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder41RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder41
	)
	default String reminder41RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder41
	)
	default String reminder41NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder41
	)
	default String reminder41ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder41
	)
	default int reminder41Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder41Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder41
	)
	default int reminder41Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder41TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder41
	)
	default TimeUnit reminder41TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder41ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder41
	)
	default String reminder41ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder41Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder41
	)
	default boolean reminder41Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder41SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder41
	)
	default boolean reminder41SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder41panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder41
	)
	default RSAnchorType reminder41PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder41PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder41
	)
	default int reminder41PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder41PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder41
	)
	default int reminder41PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder41ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder41
	)
	default RSViewGroup.Gravity reminder41ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder41ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder41
	)
	default int reminder41ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder41Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder41
	)
	default boolean reminder41Image() { return false; }

	@ConfigItem(
			keyName = "Reminder41Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder41
	)
	default boolean reminder41Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder41AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder41
	)
	default ColorAnimationType reminder41AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder41CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder41
	)
	default int reminder41CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder42",
			description = "Reminder 42",
			position = 62,
			closedByDefault = true
	)
	String reminder42= "reminder42";

	@ConfigItem(
			keyName = "enableReminder42",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder42
	)
	default boolean reminder42Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder42Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder42
	)
	default String reminder42Text() { return ""; }

	@ConfigItem(
			keyName = "reminder42Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder42
	)
	default Color reminder42Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder42Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder42
	)
	default String reminder42Times() { return ""; }

	@ConfigItem(
			keyName = "reminder42DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder42
	)
	default String reminder42DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder42Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder42
	)
	default String reminder42Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder42Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder42
	)
	default String reminder42Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder42Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder42
	)
	default String reminder42Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder42Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder42
	)
	default int reminder42Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder42RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder42
	)
	default String reminder42RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder42
	)
	default String reminder42NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder42
	)
	default String reminder42ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder42
	)
	default int reminder42Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder42Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder42
	)
	default int reminder42Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder42TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder42
	)
	default TimeUnit reminder42TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder42ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder42
	)
	default String reminder42ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder42Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder42
	)
	default boolean reminder42Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder42SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder42
	)
	default boolean reminder42SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder42panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder42
	)
	default RSAnchorType reminder42PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder42PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder42
	)
	default int reminder42PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder42PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder42
	)
	default int reminder42PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder42ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder42
	)
	default RSViewGroup.Gravity reminder42ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder42ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder42
	)
	default int reminder42ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder42Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder42
	)
	default boolean reminder42Image() { return false; }

	@ConfigItem(
			keyName = "Reminder42Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder42
	)
	default boolean reminder42Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder42AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder42
	)
	default ColorAnimationType reminder42AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder42CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder42
	)
	default int reminder42CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder43",
			description = "Reminder 43",
			position = 63,
			closedByDefault = true
	)
	String reminder43= "reminder43";

	@ConfigItem(
			keyName = "enableReminder43",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder43
	)
	default boolean reminder43Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder43Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder43
	)
	default String reminder43Text() { return ""; }

	@ConfigItem(
			keyName = "reminder43Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder43
	)
	default Color reminder43Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder43Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder43
	)
	default String reminder43Times() { return ""; }

	@ConfigItem(
			keyName = "reminder43DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder43
	)
	default String reminder43DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder43Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder43
	)
	default String reminder43Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder43Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder43
	)
	default String reminder43Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder43Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder43
	)
	default String reminder43Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder43Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder43
	)
	default int reminder43Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder43RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder43
	)
	default String reminder43RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder43
	)
	default String reminder43NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder43
	)
	default String reminder43ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder43
	)
	default int reminder43Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder43Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder43
	)
	default int reminder43Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder43TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder43
	)
	default TimeUnit reminder43TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder43ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder43
	)
	default String reminder43ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder43Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder43
	)
	default boolean reminder43Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder43SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder43
	)
	default boolean reminder43SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder43panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder43
	)
	default RSAnchorType reminder43PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder43PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder43
	)
	default int reminder43PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder43PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder43
	)
	default int reminder43PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder43ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder43
	)
	default RSViewGroup.Gravity reminder43ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder43ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder43
	)
	default int reminder43ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder43Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder43
	)
	default boolean reminder43Image() { return false; }

	@ConfigItem(
			keyName = "Reminder43Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder43
	)
	default boolean reminder43Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder43AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder43
	)
	default ColorAnimationType reminder43AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder43CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder43
	)
	default int reminder43CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder44",
			description = "Reminder 44",
			position = 64,
			closedByDefault = true
	)
	String reminder44= "reminder44";

	@ConfigItem(
			keyName = "enableReminder44",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder44
	)
	default boolean reminder44Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder44Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder44
	)
	default String reminder44Text() { return ""; }

	@ConfigItem(
			keyName = "reminder44Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder44
	)
	default Color reminder44Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder44Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder44
	)
	default String reminder44Times() { return ""; }

	@ConfigItem(
			keyName = "reminder44DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder44
	)
	default String reminder44DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder44Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder44
	)
	default String reminder44Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder44Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder44
	)
	default String reminder44Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder44Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder44
	)
	default String reminder44Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder44Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder44
	)
	default int reminder44Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder44RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder44
	)
	default String reminder44RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder44
	)
	default String reminder44NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder44
	)
	default String reminder44ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder44
	)
	default int reminder44Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder44Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder44
	)
	default int reminder44Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder44TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder44
	)
	default TimeUnit reminder44TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder44ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder44
	)
	default String reminder44ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder44Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder44
	)
	default boolean reminder44Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder44SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder44
	)
	default boolean reminder44SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder44panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder44
	)
	default RSAnchorType reminder44PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder44PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder44
	)
	default int reminder44PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder44PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder44
	)
	default int reminder44PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder44ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder44
	)
	default RSViewGroup.Gravity reminder44ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder44ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder44
	)
	default int reminder44ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder44Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder44
	)
	default boolean reminder44Image() { return false; }

	@ConfigItem(
			keyName = "Reminder44Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder44
	)
	default boolean reminder44Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder44AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder44
	)
	default ColorAnimationType reminder44AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder44CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder44
	)
	default int reminder44CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder45",
			description = "Reminder 45",
			position = 65,
			closedByDefault = true
	)
	String reminder45= "reminder45";

	@ConfigItem(
			keyName = "enableReminder45",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder45
	)
	default boolean reminder45Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder45Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder45
	)
	default String reminder45Text() { return ""; }

	@ConfigItem(
			keyName = "reminder45Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder45
	)
	default Color reminder45Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder45Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder45
	)
	default String reminder45Times() { return ""; }

	@ConfigItem(
			keyName = "reminder45DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder45
	)
	default String reminder45DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder45Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder45
	)
	default String reminder45Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder45Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder45
	)
	default String reminder45Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder45Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder45
	)
	default String reminder45Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder45Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder45
	)
	default int reminder45Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder45RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder45
	)
	default String reminder45RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder45
	)
	default String reminder45NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder45
	)
	default String reminder45ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder45
	)
	default int reminder45Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder45Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder45
	)
	default int reminder45Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder45TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder45
	)
	default TimeUnit reminder45TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder45ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder45
	)
	default String reminder45ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder45Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder45
	)
	default boolean reminder45Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder45SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder45
	)
	default boolean reminder45SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder45panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder45
	)
	default RSAnchorType reminder45PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder45PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder45
	)
	default int reminder45PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder45PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder45
	)
	default int reminder45PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder45ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder45
	)
	default RSViewGroup.Gravity reminder45ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder45ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder45
	)
	default int reminder45ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder45Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder45
	)
	default boolean reminder45Image() { return false; }

	@ConfigItem(
			keyName = "Reminder45Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder45
	)
	default boolean reminder45Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder45AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder45
	)
	default ColorAnimationType reminder45AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder45CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder45
	)
	default int reminder45CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder46",
			description = "Reminder 46",
			position = 66,
			closedByDefault = true
	)
	String reminder46= "reminder46";

	@ConfigItem(
			keyName = "enableReminder46",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder46
	)
	default boolean reminder46Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder46Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder46
	)
	default String reminder46Text() { return ""; }

	@ConfigItem(
			keyName = "reminder46Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder46
	)
	default Color reminder46Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder46Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder46
	)
	default String reminder46Times() { return ""; }

	@ConfigItem(
			keyName = "reminder46DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder46
	)
	default String reminder46DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder46Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder46
	)
	default String reminder46Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder46Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder46
	)
	default String reminder46Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder46Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder46
	)
	default String reminder46Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder46Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder46
	)
	default int reminder46Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder46RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder46
	)
	default String reminder46RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder46
	)
	default String reminder46NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder46
	)
	default String reminder46ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder46
	)
	default int reminder46Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder46Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder46
	)
	default int reminder46Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder46TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder46
	)
	default TimeUnit reminder46TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder46ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder46
	)
	default String reminder46ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder46Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder46
	)
	default boolean reminder46Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder46SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder46
	)
	default boolean reminder46SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder46panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder46
	)
	default RSAnchorType reminder46PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder46PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder46
	)
	default int reminder46PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder46PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder46
	)
	default int reminder46PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder46ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder46
	)
	default RSViewGroup.Gravity reminder46ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder46ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder46
	)
	default int reminder46ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder46Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder46
	)
	default boolean reminder46Image() { return false; }

	@ConfigItem(
			keyName = "Reminder46Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder46
	)
	default boolean reminder46Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder46AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder46
	)
	default ColorAnimationType reminder46AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder46CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder46
	)
	default int reminder46CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder47",
			description = "Reminder 47",
			position = 67,
			closedByDefault = true
	)
	String reminder47= "reminder47";

	@ConfigItem(
			keyName = "enableReminder47",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder47
	)
	default boolean reminder47Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder47Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder47
	)
	default String reminder47Text() { return ""; }

	@ConfigItem(
			keyName = "reminder47Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder47
	)
	default Color reminder47Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder47Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder47
	)
	default String reminder47Times() { return ""; }

	@ConfigItem(
			keyName = "reminder47DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder47
	)
	default String reminder47DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder47Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder47
	)
	default String reminder47Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder47Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder47
	)
	default String reminder47Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder47Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder47
	)
	default String reminder47Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder47Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder47
	)
	default int reminder47Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder47RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder47
	)
	default String reminder47RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder47
	)
	default String reminder47NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder47
	)
	default String reminder47ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder47
	)
	default int reminder47Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder47Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder47
	)
	default int reminder47Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder47TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder47
	)
	default TimeUnit reminder47TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder47ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder47
	)
	default String reminder47ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder47Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder47
	)
	default boolean reminder47Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder47SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder47
	)
	default boolean reminder47SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder47panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder47
	)
	default RSAnchorType reminder47PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder47PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder47
	)
	default int reminder47PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder47PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder47
	)
	default int reminder47PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder47ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder47
	)
	default RSViewGroup.Gravity reminder47ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder47ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder47
	)
	default int reminder47ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder47Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder47
	)
	default boolean reminder47Image() { return false; }

	@ConfigItem(
			keyName = "Reminder47Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder47
	)
	default boolean reminder47Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder47AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder47
	)
	default ColorAnimationType reminder47AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder47CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder47
	)
	default int reminder47CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder48",
			description = "Reminder 48",
			position = 68,
			closedByDefault = true
	)
	String reminder48= "reminder48";

	@ConfigItem(
			keyName = "enableReminder48",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder48
	)
	default boolean reminder48Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder48Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder48
	)
	default String reminder48Text() { return ""; }

	@ConfigItem(
			keyName = "reminder48Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder48
	)
	default Color reminder48Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder48Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder48
	)
	default String reminder48Times() { return ""; }

	@ConfigItem(
			keyName = "reminder48DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder48
	)
	default String reminder48DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder48Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder48
	)
	default String reminder48Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder48Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder48
	)
	default String reminder48Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder48Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder48
	)
	default String reminder48Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder48Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder48
	)
	default int reminder48Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder48RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder48
	)
	default String reminder48RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder48
	)
	default String reminder48NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder48
	)
	default String reminder48ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder48
	)
	default int reminder48Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder48Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder48
	)
	default int reminder48Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder48TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder48
	)
	default TimeUnit reminder48TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder48ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder48
	)
	default String reminder48ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder48Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder48
	)
	default boolean reminder48Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder48SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder48
	)
	default boolean reminder48SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder48panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder48
	)
	default RSAnchorType reminder48PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder48PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder48
	)
	default int reminder48PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder48PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder48
	)
	default int reminder48PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder48ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder48
	)
	default RSViewGroup.Gravity reminder48ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder48ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder48
	)
	default int reminder48ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder48Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder48
	)
	default boolean reminder48Image() { return false; }

	@ConfigItem(
			keyName = "Reminder48Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder48
	)
	default boolean reminder48Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder48AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder48
	)
	default ColorAnimationType reminder48AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder48CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder48
	)
	default int reminder48CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder49",
			description = "Reminder 49",
			position = 69,
			closedByDefault = true
	)
	String reminder49= "reminder49";

	@ConfigItem(
			keyName = "enableReminder49",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder49
	)
	default boolean reminder49Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder49Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder49
	)
	default String reminder49Text() { return ""; }

	@ConfigItem(
			keyName = "reminder49Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder49
	)
	default Color reminder49Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder49Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder49
	)
	default String reminder49Times() { return ""; }

	@ConfigItem(
			keyName = "reminder49DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder49
	)
	default String reminder49DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder49Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder49
	)
	default String reminder49Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder49Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder49
	)
	default String reminder49Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder49Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder49
	)
	default String reminder49Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder49Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder49
	)
	default int reminder49Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder49RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder49
	)
	default String reminder49RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder49
	)
	default String reminder49NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder49
	)
	default String reminder49ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder49
	)
	default int reminder49Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder49Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder49
	)
	default int reminder49Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder49TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder49
	)
	default TimeUnit reminder49TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder49ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder49
	)
	default String reminder49ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder49Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder49
	)
	default boolean reminder49Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder49SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder49
	)
	default boolean reminder49SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder49panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder49
	)
	default RSAnchorType reminder49PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder49PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder49
	)
	default int reminder49PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder49PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder49
	)
	default int reminder49PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder49ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder49
	)
	default RSViewGroup.Gravity reminder49ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder49ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder49
	)
	default int reminder49ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder49Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder49
	)
	default boolean reminder49Image() { return false; }

	@ConfigItem(
			keyName = "Reminder49Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder49
	)
	default boolean reminder49Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder49AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder49
	)
	default ColorAnimationType reminder49AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder49CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder49
	)
	default int reminder49CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder50",
			description = "Reminder 50",
			position = 70,
			closedByDefault = true
	)
	String reminder50= "reminder50";

	@ConfigItem(
			keyName = "enableReminder50",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder50
	)
	default boolean reminder50Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder50Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder50
	)
	default String reminder50Text() { return ""; }

	@ConfigItem(
			keyName = "reminder50Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder50
	)
	default Color reminder50Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder50Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder50
	)
	default String reminder50Times() { return ""; }

	@ConfigItem(
			keyName = "reminder50DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder50
	)
	default String reminder50DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder50Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder50
	)
	default String reminder50Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder50Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder50
	)
	default String reminder50Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder50Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder50
	)
	default String reminder50Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder50Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder50
	)
	default int reminder50Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder50RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder50
	)
	default String reminder50RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder50
	)
	default String reminder50NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder50
	)
	default String reminder50ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder50
	)
	default int reminder50Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder50Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder50
	)
	default int reminder50Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder50TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder50
	)
	default TimeUnit reminder50TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder50ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder50
	)
	default String reminder50ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder50Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder50
	)
	default boolean reminder50Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder50SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder50
	)
	default boolean reminder50SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder50panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder50
	)
	default RSAnchorType reminder50PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder50PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder50
	)
	default int reminder50PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder50PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder50
	)
	default int reminder50PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder50ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder50
	)
	default RSViewGroup.Gravity reminder50ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder50ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder50
	)
	default int reminder50ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder50Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder50
	)
	default boolean reminder50Image() { return false; }

	@ConfigItem(
			keyName = "Reminder50Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder50
	)
	default boolean reminder50Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder50AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder50
	)
	default ColorAnimationType reminder50AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder50CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder50
	)
	default int reminder50CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder51",
			description = "Reminder 51",
			position = 71,
			closedByDefault = true
	)
	String reminder51= "reminder51";

	@ConfigItem(
			keyName = "enableReminder51",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder51
	)
	default boolean reminder51Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder51Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder51
	)
	default String reminder51Text() { return ""; }

	@ConfigItem(
			keyName = "reminder51Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder51
	)
	default Color reminder51Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder51Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder51
	)
	default String reminder51Times() { return ""; }

	@ConfigItem(
			keyName = "reminder51DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder51
	)
	default String reminder51DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder51Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder51
	)
	default String reminder51Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder51Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder51
	)
	default String reminder51Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder51Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder51
	)
	default String reminder51Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder51Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder51
	)
	default int reminder51Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder51RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder51
	)
	default String reminder51RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder51
	)
	default String reminder51NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder51
	)
	default String reminder51ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder51
	)
	default int reminder51Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder51Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder51
	)
	default int reminder51Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder51TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder51
	)
	default TimeUnit reminder51TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder51ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder51
	)
	default String reminder51ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder51Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder51
	)
	default boolean reminder51Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder51SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder51
	)
	default boolean reminder51SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder51panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder51
	)
	default RSAnchorType reminder51PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder51PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder51
	)
	default int reminder51PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder51PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder51
	)
	default int reminder51PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder51ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder51
	)
	default RSViewGroup.Gravity reminder51ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder51ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder51
	)
	default int reminder51ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder51Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder51
	)
	default boolean reminder51Image() { return false; }

	@ConfigItem(
			keyName = "Reminder51Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder51
	)
	default boolean reminder51Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder51AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder51
	)
	default ColorAnimationType reminder51AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder51CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder51
	)
	default int reminder51CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder52",
			description = "Reminder 52",
			position = 72,
			closedByDefault = true
	)
	String reminder52= "reminder52";

	@ConfigItem(
			keyName = "enableReminder52",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder52
	)
	default boolean reminder52Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder52Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder52
	)
	default String reminder52Text() { return ""; }

	@ConfigItem(
			keyName = "reminder52Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder52
	)
	default Color reminder52Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder52Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder52
	)
	default String reminder52Times() { return ""; }

	@ConfigItem(
			keyName = "reminder52DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder52
	)
	default String reminder52DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder52Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder52
	)
	default String reminder52Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder52Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder52
	)
	default String reminder52Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder52Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder52
	)
	default String reminder52Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder52Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder52
	)
	default int reminder52Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder52RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder52
	)
	default String reminder52RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder52
	)
	default String reminder52NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder52
	)
	default String reminder52ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder52
	)
	default int reminder52Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder52Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder52
	)
	default int reminder52Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder52TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder52
	)
	default TimeUnit reminder52TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder52ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder52
	)
	default String reminder52ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder52Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder52
	)
	default boolean reminder52Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder52SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder52
	)
	default boolean reminder52SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder52panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder52
	)
	default RSAnchorType reminder52PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder52PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder52
	)
	default int reminder52PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder52PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder52
	)
	default int reminder52PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder52ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder52
	)
	default RSViewGroup.Gravity reminder52ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder52ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder52
	)
	default int reminder52ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder52Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder52
	)
	default boolean reminder52Image() { return false; }

	@ConfigItem(
			keyName = "Reminder52Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder52
	)
	default boolean reminder52Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder52AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder52
	)
	default ColorAnimationType reminder52AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder52CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder52
	)
	default int reminder52CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder53",
			description = "Reminder 53",
			position = 73,
			closedByDefault = true
	)
	String reminder53= "reminder53";

	@ConfigItem(
			keyName = "enableReminder53",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder53
	)
	default boolean reminder53Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder53Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder53
	)
	default String reminder53Text() { return ""; }

	@ConfigItem(
			keyName = "reminder53Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder53
	)
	default Color reminder53Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder53Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder53
	)
	default String reminder53Times() { return ""; }

	@ConfigItem(
			keyName = "reminder53DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder53
	)
	default String reminder53DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder53Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder53
	)
	default String reminder53Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder53Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder53
	)
	default String reminder53Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder53Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder53
	)
	default String reminder53Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder53Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder53
	)
	default int reminder53Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder53RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder53
	)
	default String reminder53RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder53
	)
	default String reminder53NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder53
	)
	default String reminder53ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder53
	)
	default int reminder53Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder53Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder53
	)
	default int reminder53Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder53TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder53
	)
	default TimeUnit reminder53TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder53ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder53
	)
	default String reminder53ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder53Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder53
	)
	default boolean reminder53Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder53SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder53
	)
	default boolean reminder53SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder53panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder53
	)
	default RSAnchorType reminder53PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder53PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder53
	)
	default int reminder53PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder53PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder53
	)
	default int reminder53PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder53ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder53
	)
	default RSViewGroup.Gravity reminder53ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder53ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder53
	)
	default int reminder53ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder53Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder53
	)
	default boolean reminder53Image() { return false; }

	@ConfigItem(
			keyName = "Reminder53Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder53
	)
	default boolean reminder53Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder53AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder53
	)
	default ColorAnimationType reminder53AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder53CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder53
	)
	default int reminder53CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder54",
			description = "Reminder 54",
			position = 74,
			closedByDefault = true
	)
	String reminder54= "reminder54";

	@ConfigItem(
			keyName = "enableReminder54",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder54
	)
	default boolean reminder54Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder54Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder54
	)
	default String reminder54Text() { return ""; }

	@ConfigItem(
			keyName = "reminder54Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder54
	)
	default Color reminder54Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder54Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder54
	)
	default String reminder54Times() { return ""; }

	@ConfigItem(
			keyName = "reminder54DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder54
	)
	default String reminder54DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder54Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder54
	)
	default String reminder54Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder54Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder54
	)
	default String reminder54Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder54Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder54
	)
	default String reminder54Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder54Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder54
	)
	default int reminder54Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder54RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder54
	)
	default String reminder54RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder54
	)
	default String reminder54NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder54
	)
	default String reminder54ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder54
	)
	default int reminder54Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder54Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder54
	)
	default int reminder54Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder54TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder54
	)
	default TimeUnit reminder54TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder54ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder54
	)
	default String reminder54ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder54Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder54
	)
	default boolean reminder54Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder54SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder54
	)
	default boolean reminder54SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder54panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder54
	)
	default RSAnchorType reminder54PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder54PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder54
	)
	default int reminder54PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder54PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder54
	)
	default int reminder54PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder54ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder54
	)
	default RSViewGroup.Gravity reminder54ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder54ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder54
	)
	default int reminder54ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder54Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder54
	)
	default boolean reminder54Image() { return false; }

	@ConfigItem(
			keyName = "Reminder54Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder54
	)
	default boolean reminder54Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder54AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder54
	)
	default ColorAnimationType reminder54AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder54CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder54
	)
	default int reminder54CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder55",
			description = "Reminder 55",
			position = 75,
			closedByDefault = true
	)
	String reminder55= "reminder55";

	@ConfigItem(
			keyName = "enableReminder55",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder55
	)
	default boolean reminder55Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder55Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder55
	)
	default String reminder55Text() { return ""; }

	@ConfigItem(
			keyName = "reminder55Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder55
	)
	default Color reminder55Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder55Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder55
	)
	default String reminder55Times() { return ""; }

	@ConfigItem(
			keyName = "reminder55DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder55
	)
	default String reminder55DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder55Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder55
	)
	default String reminder55Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder55Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder55
	)
	default String reminder55Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder55Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder55
	)
	default String reminder55Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder55Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder55
	)
	default int reminder55Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder55RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder55
	)
	default String reminder55RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder55
	)
	default String reminder55NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder55
	)
	default String reminder55ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder55
	)
	default int reminder55Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder55Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder55
	)
	default int reminder55Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder55TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder55
	)
	default TimeUnit reminder55TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder55ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder55
	)
	default String reminder55ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder55Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder55
	)
	default boolean reminder55Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder55SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder55
	)
	default boolean reminder55SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder55panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder55
	)
	default RSAnchorType reminder55PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder55PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder55
	)
	default int reminder55PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder55PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder55
	)
	default int reminder55PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder55ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder55
	)
	default RSViewGroup.Gravity reminder55ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder55ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder55
	)
	default int reminder55ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder55Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder55
	)
	default boolean reminder55Image() { return false; }

	@ConfigItem(
			keyName = "Reminder55Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder55
	)
	default boolean reminder55Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder55AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder55
	)
	default ColorAnimationType reminder55AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder55CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder55
	)
	default int reminder55CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder56",
			description = "Reminder 56",
			position = 76,
			closedByDefault = true
	)
	String reminder56= "reminder56";

	@ConfigItem(
			keyName = "enableReminder56",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder56
	)
	default boolean reminder56Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder56Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder56
	)
	default String reminder56Text() { return ""; }

	@ConfigItem(
			keyName = "reminder56Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder56
	)
	default Color reminder56Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder56Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder56
	)
	default String reminder56Times() { return ""; }

	@ConfigItem(
			keyName = "reminder56DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder56
	)
	default String reminder56DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder56Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder56
	)
	default String reminder56Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder56Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder56
	)
	default String reminder56Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder56Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder56
	)
	default String reminder56Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder56Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder56
	)
	default int reminder56Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder56RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder56
	)
	default String reminder56RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder56
	)
	default String reminder56NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder56
	)
	default String reminder56ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder56
	)
	default int reminder56Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder56Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder56
	)
	default int reminder56Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder56TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder56
	)
	default TimeUnit reminder56TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder56ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder56
	)
	default String reminder56ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder56Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder56
	)
	default boolean reminder56Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder56SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder56
	)
	default boolean reminder56SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder56panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder56
	)
	default RSAnchorType reminder56PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder56PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder56
	)
	default int reminder56PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder56PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder56
	)
	default int reminder56PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder56ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder56
	)
	default RSViewGroup.Gravity reminder56ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder56ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder56
	)
	default int reminder56ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder56Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder56
	)
	default boolean reminder56Image() { return false; }

	@ConfigItem(
			keyName = "Reminder56Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder56
	)
	default boolean reminder56Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder56AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder56
	)
	default ColorAnimationType reminder56AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder56CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder56
	)
	default int reminder56CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder57",
			description = "Reminder 57",
			position = 77,
			closedByDefault = true
	)
	String reminder57= "reminder57";

	@ConfigItem(
			keyName = "enableReminder57",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder57
	)
	default boolean reminder57Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder57Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder57
	)
	default String reminder57Text() { return ""; }

	@ConfigItem(
			keyName = "reminder57Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder57
	)
	default Color reminder57Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder57Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder57
	)
	default String reminder57Times() { return ""; }

	@ConfigItem(
			keyName = "reminder57DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder57
	)
	default String reminder57DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder57Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder57
	)
	default String reminder57Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder57Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder57
	)
	default String reminder57Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder57Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder57
	)
	default String reminder57Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder57Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder57
	)
	default int reminder57Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder57RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder57
	)
	default String reminder57RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder57
	)
	default String reminder57NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder57
	)
	default String reminder57ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder57
	)
	default int reminder57Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder57Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder57
	)
	default int reminder57Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder57TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder57
	)
	default TimeUnit reminder57TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder57ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder57
	)
	default String reminder57ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder57Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder57
	)
	default boolean reminder57Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder57SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder57
	)
	default boolean reminder57SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder57panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder57
	)
	default RSAnchorType reminder57PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder57PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder57
	)
	default int reminder57PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder57PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder57
	)
	default int reminder57PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder57ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder57
	)
	default RSViewGroup.Gravity reminder57ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder57ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder57
	)
	default int reminder57ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder57Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder57
	)
	default boolean reminder57Image() { return false; }

	@ConfigItem(
			keyName = "Reminder57Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder57
	)
	default boolean reminder57Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder57AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder57
	)
	default ColorAnimationType reminder57AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder57CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder57
	)
	default int reminder57CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder58",
			description = "Reminder 58",
			position = 78,
			closedByDefault = true
	)
	String reminder58= "reminder58";

	@ConfigItem(
			keyName = "enableReminder58",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder58
	)
	default boolean reminder58Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder58Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder58
	)
	default String reminder58Text() { return ""; }

	@ConfigItem(
			keyName = "reminder58Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder58
	)
	default Color reminder58Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder58Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder58
	)
	default String reminder58Times() { return ""; }

	@ConfigItem(
			keyName = "reminder58DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder58
	)
	default String reminder58DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder58Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder58
	)
	default String reminder58Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder58Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder58
	)
	default String reminder58Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder58Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder58
	)
	default String reminder58Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder58Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder58
	)
	default int reminder58Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder58RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder58
	)
	default String reminder58RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder58
	)
	default String reminder58NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder58
	)
	default String reminder58ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder58
	)
	default int reminder58Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder58Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder58
	)
	default int reminder58Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder58TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder58
	)
	default TimeUnit reminder58TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder58ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder58
	)
	default String reminder58ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder58Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder58
	)
	default boolean reminder58Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder58SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder58
	)
	default boolean reminder58SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder58panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder58
	)
	default RSAnchorType reminder58PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder58PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder58
	)
	default int reminder58PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder58PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder58
	)
	default int reminder58PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder58ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder58
	)
	default RSViewGroup.Gravity reminder58ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder58ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder58
	)
	default int reminder58ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder58Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder58
	)
	default boolean reminder58Image() { return false; }

	@ConfigItem(
			keyName = "Reminder58Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder58
	)
	default boolean reminder58Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder58AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder58
	)
	default ColorAnimationType reminder58AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder58CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder58
	)
	default int reminder58CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder59",
			description = "Reminder 59",
			position = 79,
			closedByDefault = true
	)
	String reminder59= "reminder59";

	@ConfigItem(
			keyName = "enableReminder59",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder59
	)
	default boolean reminder59Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder59Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder59
	)
	default String reminder59Text() { return ""; }

	@ConfigItem(
			keyName = "reminder59Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder59
	)
	default Color reminder59Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder59Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder59
	)
	default String reminder59Times() { return ""; }

	@ConfigItem(
			keyName = "reminder59DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder59
	)
	default String reminder59DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder59Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder59
	)
	default String reminder59Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder59Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder59
	)
	default String reminder59Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder59Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder59
	)
	default String reminder59Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder59Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder59
	)
	default int reminder59Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder59RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder59
	)
	default String reminder59RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder59
	)
	default String reminder59NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder59
	)
	default String reminder59ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder59
	)
	default int reminder59Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder59Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder59
	)
	default int reminder59Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder59TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder59
	)
	default TimeUnit reminder59TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder59ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder59
	)
	default String reminder59ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder59Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder59
	)
	default boolean reminder59Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder59SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder59
	)
	default boolean reminder59SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder59panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder59
	)
	default RSAnchorType reminder59PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder59PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder59
	)
	default int reminder59PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder59PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder59
	)
	default int reminder59PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder59ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder59
	)
	default RSViewGroup.Gravity reminder59ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder59ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder59
	)
	default int reminder59ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder59Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder59
	)
	default boolean reminder59Image() { return false; }

	@ConfigItem(
			keyName = "Reminder59Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder59
	)
	default boolean reminder59Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder59AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder59
	)
	default ColorAnimationType reminder59AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder59CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder59
	)
	default int reminder59CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder60",
			description = "Reminder 60",
			position = 80,
			closedByDefault = true
	)
	String reminder60= "reminder60";

	@ConfigItem(
			keyName = "enableReminder60",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder60
	)
	default boolean reminder60Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder60Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder60
	)
	default String reminder60Text() { return ""; }

	@ConfigItem(
			keyName = "reminder60Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder60
	)
	default Color reminder60Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder60Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder60
	)
	default String reminder60Times() { return ""; }

	@ConfigItem(
			keyName = "reminder60DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder60
	)
	default String reminder60DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder60Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder60
	)
	default String reminder60Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder60Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder60
	)
	default String reminder60Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder60Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder60
	)
	default String reminder60Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder60Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder60
	)
	default int reminder60Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder60RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder60
	)
	default String reminder60RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder60
	)
	default String reminder60NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder60
	)
	default String reminder60ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder60
	)
	default int reminder60Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder60Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder60
	)
	default int reminder60Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder60TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder60
	)
	default TimeUnit reminder60TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder60ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder60
	)
	default String reminder60ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder60Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder60
	)
	default boolean reminder60Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder60SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder60
	)
	default boolean reminder60SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder60panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder60
	)
	default RSAnchorType reminder60PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder60PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder60
	)
	default int reminder60PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder60PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder60
	)
	default int reminder60PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder60ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder60
	)
	default RSViewGroup.Gravity reminder60ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder60ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder60
	)
	default int reminder60ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder60Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder60
	)
	default boolean reminder60Image() { return false; }

	@ConfigItem(
			keyName = "Reminder60Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder60
	)
	default boolean reminder60Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder60AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder60
	)
	default ColorAnimationType reminder60AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder60CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder60
	)
	default int reminder60CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder61",
			description = "Reminder 61",
			position = 81,
			closedByDefault = true
	)
	String reminder61= "reminder61";

	@ConfigItem(
			keyName = "enableReminder61",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder61
	)
	default boolean reminder61Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder61Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder61
	)
	default String reminder61Text() { return ""; }

	@ConfigItem(
			keyName = "reminder61Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder61
	)
	default Color reminder61Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder61Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder61
	)
	default String reminder61Times() { return ""; }

	@ConfigItem(
			keyName = "reminder61DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder61
	)
	default String reminder61DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder61Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder61
	)
	default String reminder61Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder61Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder61
	)
	default String reminder61Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder61Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder61
	)
	default String reminder61Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder61Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder61
	)
	default int reminder61Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder61RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder61
	)
	default String reminder61RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder61
	)
	default String reminder61NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder61
	)
	default String reminder61ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder61
	)
	default int reminder61Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder61Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder61
	)
	default int reminder61Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder61TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder61
	)
	default TimeUnit reminder61TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder61ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder61
	)
	default String reminder61ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder61Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder61
	)
	default boolean reminder61Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder61SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder61
	)
	default boolean reminder61SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder61panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder61
	)
	default RSAnchorType reminder61PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder61PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder61
	)
	default int reminder61PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder61PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder61
	)
	default int reminder61PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder61ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder61
	)
	default RSViewGroup.Gravity reminder61ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder61ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder61
	)
	default int reminder61ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder61Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder61
	)
	default boolean reminder61Image() { return false; }

	@ConfigItem(
			keyName = "Reminder61Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder61
	)
	default boolean reminder61Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder61AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder61
	)
	default ColorAnimationType reminder61AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder61CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder61
	)
	default int reminder61CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder62",
			description = "Reminder 62",
			position = 82,
			closedByDefault = true
	)
	String reminder62= "reminder62";

	@ConfigItem(
			keyName = "enableReminder62",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder62
	)
	default boolean reminder62Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder62Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder62
	)
	default String reminder62Text() { return ""; }

	@ConfigItem(
			keyName = "reminder62Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder62
	)
	default Color reminder62Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder62Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder62
	)
	default String reminder62Times() { return ""; }

	@ConfigItem(
			keyName = "reminder62DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder62
	)
	default String reminder62DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder62Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder62
	)
	default String reminder62Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder62Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder62
	)
	default String reminder62Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder62Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder62
	)
	default String reminder62Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder62Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder62
	)
	default int reminder62Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder62RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder62
	)
	default String reminder62RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder62
	)
	default String reminder62NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder62
	)
	default String reminder62ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder62
	)
	default int reminder62Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder62Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder62
	)
	default int reminder62Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder62TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder62
	)
	default TimeUnit reminder62TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder62ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder62
	)
	default String reminder62ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder62Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder62
	)
	default boolean reminder62Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder62SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder62
	)
	default boolean reminder62SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder62panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder62
	)
	default RSAnchorType reminder62PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder62PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder62
	)
	default int reminder62PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder62PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder62
	)
	default int reminder62PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder62ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder62
	)
	default RSViewGroup.Gravity reminder62ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder62ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder62
	)
	default int reminder62ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder62Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder62
	)
	default boolean reminder62Image() { return false; }

	@ConfigItem(
			keyName = "Reminder62Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder62
	)
	default boolean reminder62Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder62AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder62
	)
	default ColorAnimationType reminder62AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder62CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder62
	)
	default int reminder62CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder63",
			description = "Reminder 63",
			position = 83,
			closedByDefault = true
	)
	String reminder63= "reminder63";

	@ConfigItem(
			keyName = "enableReminder63",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder63
	)
	default boolean reminder63Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder63Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder63
	)
	default String reminder63Text() { return ""; }

	@ConfigItem(
			keyName = "reminder63Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder63
	)
	default Color reminder63Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder63Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder63
	)
	default String reminder63Times() { return ""; }

	@ConfigItem(
			keyName = "reminder63DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder63
	)
	default String reminder63DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder63Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder63
	)
	default String reminder63Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder63Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder63
	)
	default String reminder63Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder63Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder63
	)
	default String reminder63Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder63Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder63
	)
	default int reminder63Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder63RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder63
	)
	default String reminder63RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder63
	)
	default String reminder63NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder63
	)
	default String reminder63ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder63
	)
	default int reminder63Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder63Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder63
	)
	default int reminder63Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder63TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder63
	)
	default TimeUnit reminder63TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder63ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder63
	)
	default String reminder63ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder63Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder63
	)
	default boolean reminder63Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder63SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder63
	)
	default boolean reminder63SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder63panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder63
	)
	default RSAnchorType reminder63PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder63PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder63
	)
	default int reminder63PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder63PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder63
	)
	default int reminder63PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder63ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder63
	)
	default RSViewGroup.Gravity reminder63ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder63ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder63
	)
	default int reminder63ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder63Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder63
	)
	default boolean reminder63Image() { return false; }

	@ConfigItem(
			keyName = "Reminder63Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder63
	)
	default boolean reminder63Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder63AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder63
	)
	default ColorAnimationType reminder63AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder63CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder63
	)
	default int reminder63CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder64",
			description = "Reminder 64",
			position = 84,
			closedByDefault = true
	)
	String reminder64= "reminder64";

	@ConfigItem(
			keyName = "enableReminder64",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder64
	)
	default boolean reminder64Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder64Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder64
	)
	default String reminder64Text() { return ""; }

	@ConfigItem(
			keyName = "reminder64Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder64
	)
	default Color reminder64Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder64Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder64
	)
	default String reminder64Times() { return ""; }

	@ConfigItem(
			keyName = "reminder64DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder64
	)
	default String reminder64DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder64Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder64
	)
	default String reminder64Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder64Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder64
	)
	default String reminder64Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder64Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder64
	)
	default String reminder64Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder64Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder64
	)
	default int reminder64Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder64RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder64
	)
	default String reminder64RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder64
	)
	default String reminder64NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder64
	)
	default String reminder64ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder64
	)
	default int reminder64Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder64Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder64
	)
	default int reminder64Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder64TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder64
	)
	default TimeUnit reminder64TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder64ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder64
	)
	default String reminder64ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder64Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder64
	)
	default boolean reminder64Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder64SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder64
	)
	default boolean reminder64SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder64panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder64
	)
	default RSAnchorType reminder64PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder64PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder64
	)
	default int reminder64PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder64PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder64
	)
	default int reminder64PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder64ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder64
	)
	default RSViewGroup.Gravity reminder64ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder64ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder64
	)
	default int reminder64ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder64Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder64
	)
	default boolean reminder64Image() { return false; }

	@ConfigItem(
			keyName = "Reminder64Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder64
	)
	default boolean reminder64Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder64AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder64
	)
	default ColorAnimationType reminder64AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder64CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder64
	)
	default int reminder64CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder65",
			description = "Reminder 65",
			position = 85,
			closedByDefault = true
	)
	String reminder65= "reminder65";

	@ConfigItem(
			keyName = "enableReminder65",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder65
	)
	default boolean reminder65Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder65Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder65
	)
	default String reminder65Text() { return ""; }

	@ConfigItem(
			keyName = "reminder65Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder65
	)
	default Color reminder65Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder65Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder65
	)
	default String reminder65Times() { return ""; }

	@ConfigItem(
			keyName = "reminder65DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder65
	)
	default String reminder65DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder65Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder65
	)
	default String reminder65Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder65Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder65
	)
	default String reminder65Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder65Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder65
	)
	default String reminder65Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder65Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder65
	)
	default int reminder65Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder65RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder65
	)
	default String reminder65RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder65
	)
	default String reminder65NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder65
	)
	default String reminder65ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder65
	)
	default int reminder65Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder65Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder65
	)
	default int reminder65Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder65TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder65
	)
	default TimeUnit reminder65TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder65ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder65
	)
	default String reminder65ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder65Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder65
	)
	default boolean reminder65Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder65SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder65
	)
	default boolean reminder65SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder65panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder65
	)
	default RSAnchorType reminder65PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder65PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder65
	)
	default int reminder65PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder65PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder65
	)
	default int reminder65PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder65ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder65
	)
	default RSViewGroup.Gravity reminder65ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder65ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder65
	)
	default int reminder65ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder65Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder65
	)
	default boolean reminder65Image() { return false; }

	@ConfigItem(
			keyName = "Reminder65Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder65
	)
	default boolean reminder65Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder65AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder65
	)
	default ColorAnimationType reminder65AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder65CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder65
	)
	default int reminder65CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder66",
			description = "Reminder 66",
			position = 86,
			closedByDefault = true
	)
	String reminder66= "reminder66";

	@ConfigItem(
			keyName = "enableReminder66",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder66
	)
	default boolean reminder66Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder66Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder66
	)
	default String reminder66Text() { return ""; }

	@ConfigItem(
			keyName = "reminder66Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder66
	)
	default Color reminder66Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder66Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder66
	)
	default String reminder66Times() { return ""; }

	@ConfigItem(
			keyName = "reminder66DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder66
	)
	default String reminder66DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder66Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder66
	)
	default String reminder66Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder66Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder66
	)
	default String reminder66Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder66Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder66
	)
	default String reminder66Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder66Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder66
	)
	default int reminder66Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder66RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder66
	)
	default String reminder66RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder66
	)
	default String reminder66NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder66
	)
	default String reminder66ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder66
	)
	default int reminder66Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder66Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder66
	)
	default int reminder66Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder66TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder66
	)
	default TimeUnit reminder66TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder66ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder66
	)
	default String reminder66ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder66Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder66
	)
	default boolean reminder66Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder66SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder66
	)
	default boolean reminder66SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder66panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder66
	)
	default RSAnchorType reminder66PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder66PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder66
	)
	default int reminder66PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder66PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder66
	)
	default int reminder66PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder66ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder66
	)
	default RSViewGroup.Gravity reminder66ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder66ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder66
	)
	default int reminder66ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder66Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder66
	)
	default boolean reminder66Image() { return false; }

	@ConfigItem(
			keyName = "Reminder66Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder66
	)
	default boolean reminder66Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder66AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder66
	)
	default ColorAnimationType reminder66AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder66CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder66
	)
	default int reminder66CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder67",
			description = "Reminder 67",
			position = 87,
			closedByDefault = true
	)
	String reminder67= "reminder67";

	@ConfigItem(
			keyName = "enableReminder67",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder67
	)
	default boolean reminder67Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder67Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder67
	)
	default String reminder67Text() { return ""; }

	@ConfigItem(
			keyName = "reminder67Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder67
	)
	default Color reminder67Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder67Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder67
	)
	default String reminder67Times() { return ""; }

	@ConfigItem(
			keyName = "reminder67DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder67
	)
	default String reminder67DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder67Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder67
	)
	default String reminder67Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder67Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder67
	)
	default String reminder67Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder67Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder67
	)
	default String reminder67Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder67Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder67
	)
	default int reminder67Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder67RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder67
	)
	default String reminder67RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder67
	)
	default String reminder67NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder67
	)
	default String reminder67ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder67
	)
	default int reminder67Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder67Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder67
	)
	default int reminder67Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder67TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder67
	)
	default TimeUnit reminder67TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder67ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder67
	)
	default String reminder67ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder67Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder67
	)
	default boolean reminder67Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder67SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder67
	)
	default boolean reminder67SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder67panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder67
	)
	default RSAnchorType reminder67PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder67PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder67
	)
	default int reminder67PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder67PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder67
	)
	default int reminder67PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder67ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder67
	)
	default RSViewGroup.Gravity reminder67ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder67ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder67
	)
	default int reminder67ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder67Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder67
	)
	default boolean reminder67Image() { return false; }

	@ConfigItem(
			keyName = "Reminder67Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder67
	)
	default boolean reminder67Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder67AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder67
	)
	default ColorAnimationType reminder67AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder67CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder67
	)
	default int reminder67CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder68",
			description = "Reminder 68",
			position = 88,
			closedByDefault = true
	)
	String reminder68= "reminder68";

	@ConfigItem(
			keyName = "enableReminder68",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder68
	)
	default boolean reminder68Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder68Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder68
	)
	default String reminder68Text() { return ""; }

	@ConfigItem(
			keyName = "reminder68Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder68
	)
	default Color reminder68Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder68Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder68
	)
	default String reminder68Times() { return ""; }

	@ConfigItem(
			keyName = "reminder68DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder68
	)
	default String reminder68DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder68Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder68
	)
	default String reminder68Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder68Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder68
	)
	default String reminder68Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder68Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder68
	)
	default String reminder68Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder68Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder68
	)
	default int reminder68Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder68RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder68
	)
	default String reminder68RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder68
	)
	default String reminder68NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder68
	)
	default String reminder68ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder68
	)
	default int reminder68Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder68Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder68
	)
	default int reminder68Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder68TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder68
	)
	default TimeUnit reminder68TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder68ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder68
	)
	default String reminder68ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder68Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder68
	)
	default boolean reminder68Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder68SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder68
	)
	default boolean reminder68SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder68panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder68
	)
	default RSAnchorType reminder68PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder68PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder68
	)
	default int reminder68PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder68PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder68
	)
	default int reminder68PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder68ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder68
	)
	default RSViewGroup.Gravity reminder68ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder68ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder68
	)
	default int reminder68ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder68Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder68
	)
	default boolean reminder68Image() { return false; }

	@ConfigItem(
			keyName = "Reminder68Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder68
	)
	default boolean reminder68Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder68AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder68
	)
	default ColorAnimationType reminder68AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder68CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder68
	)
	default int reminder68CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder69",
			description = "Reminder 69",
			position = 89,
			closedByDefault = true
	)
	String reminder69= "reminder69";

	@ConfigItem(
			keyName = "enableReminder69",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder69
	)
	default boolean reminder69Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder69Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder69
	)
	default String reminder69Text() { return ""; }

	@ConfigItem(
			keyName = "reminder69Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder69
	)
	default Color reminder69Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder69Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder69
	)
	default String reminder69Times() { return ""; }

	@ConfigItem(
			keyName = "reminder69DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder69
	)
	default String reminder69DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder69Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder69
	)
	default String reminder69Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder69Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder69
	)
	default String reminder69Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder69Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder69
	)
	default String reminder69Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder69Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder69
	)
	default int reminder69Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder69RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder69
	)
	default String reminder69RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder69
	)
	default String reminder69NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder69
	)
	default String reminder69ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder69
	)
	default int reminder69Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder69Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder69
	)
	default int reminder69Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder69TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder69
	)
	default TimeUnit reminder69TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder69ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder69
	)
	default String reminder69ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder69Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder69
	)
	default boolean reminder69Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder69SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder69
	)
	default boolean reminder69SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder69panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder69
	)
	default RSAnchorType reminder69PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder69PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder69
	)
	default int reminder69PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder69PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder69
	)
	default int reminder69PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder69ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder69
	)
	default RSViewGroup.Gravity reminder69ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder69ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder69
	)
	default int reminder69ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder69Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder69
	)
	default boolean reminder69Image() { return false; }

	@ConfigItem(
			keyName = "Reminder69Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder69
	)
	default boolean reminder69Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder69AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder69
	)
	default ColorAnimationType reminder69AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder69CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder69
	)
	default int reminder69CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder70",
			description = "Reminder 70",
			position = 90,
			closedByDefault = true
	)
	String reminder70= "reminder70";

	@ConfigItem(
			keyName = "enableReminder70",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder70
	)
	default boolean reminder70Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder70Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder70
	)
	default String reminder70Text() { return ""; }

	@ConfigItem(
			keyName = "reminder70Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder70
	)
	default Color reminder70Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder70Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder70
	)
	default String reminder70Times() { return ""; }

	@ConfigItem(
			keyName = "reminder70DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder70
	)
	default String reminder70DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder70Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder70
	)
	default String reminder70Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder70Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder70
	)
	default String reminder70Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder70Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder70
	)
	default String reminder70Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder70Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder70
	)
	default int reminder70Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder70RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder70
	)
	default String reminder70RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder70
	)
	default String reminder70NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder70
	)
	default String reminder70ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder70
	)
	default int reminder70Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder70Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder70
	)
	default int reminder70Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder70TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder70
	)
	default TimeUnit reminder70TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder70ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder70
	)
	default String reminder70ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder70Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder70
	)
	default boolean reminder70Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder70SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder70
	)
	default boolean reminder70SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder70panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder70
	)
	default RSAnchorType reminder70PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder70PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder70
	)
	default int reminder70PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder70PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder70
	)
	default int reminder70PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder70ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder70
	)
	default RSViewGroup.Gravity reminder70ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder70ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder70
	)
	default int reminder70ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder70Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder70
	)
	default boolean reminder70Image() { return false; }

	@ConfigItem(
			keyName = "Reminder70Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder70
	)
	default boolean reminder70Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder70AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder70
	)
	default ColorAnimationType reminder70AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder70CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder70
	)
	default int reminder70CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder71",
			description = "Reminder 71",
			position = 91,
			closedByDefault = true
	)
	String reminder71= "reminder71";

	@ConfigItem(
			keyName = "enableReminder71",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder71
	)
	default boolean reminder71Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder71Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder71
	)
	default String reminder71Text() { return ""; }

	@ConfigItem(
			keyName = "reminder71Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder71
	)
	default Color reminder71Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder71Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder71
	)
	default String reminder71Times() { return ""; }

	@ConfigItem(
			keyName = "reminder71DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder71
	)
	default String reminder71DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder71Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder71
	)
	default String reminder71Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder71Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder71
	)
	default String reminder71Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder71Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder71
	)
	default String reminder71Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder71Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder71
	)
	default int reminder71Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder71RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder71
	)
	default String reminder71RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder71
	)
	default String reminder71NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder71
	)
	default String reminder71ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder71
	)
	default int reminder71Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder71Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder71
	)
	default int reminder71Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder71TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder71
	)
	default TimeUnit reminder71TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder71ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder71
	)
	default String reminder71ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder71Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder71
	)
	default boolean reminder71Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder71SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder71
	)
	default boolean reminder71SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder71panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder71
	)
	default RSAnchorType reminder71PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder71PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder71
	)
	default int reminder71PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder71PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder71
	)
	default int reminder71PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder71ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder71
	)
	default RSViewGroup.Gravity reminder71ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder71ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder71
	)
	default int reminder71ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder71Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder71
	)
	default boolean reminder71Image() { return false; }

	@ConfigItem(
			keyName = "Reminder71Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder71
	)
	default boolean reminder71Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder71AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder71
	)
	default ColorAnimationType reminder71AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder71CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder71
	)
	default int reminder71CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder72",
			description = "Reminder 72",
			position = 92,
			closedByDefault = true
	)
	String reminder72= "reminder72";

	@ConfigItem(
			keyName = "enableReminder72",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder72
	)
	default boolean reminder72Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder72Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder72
	)
	default String reminder72Text() { return ""; }

	@ConfigItem(
			keyName = "reminder72Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder72
	)
	default Color reminder72Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder72Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder72
	)
	default String reminder72Times() { return ""; }

	@ConfigItem(
			keyName = "reminder72DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder72
	)
	default String reminder72DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder72Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder72
	)
	default String reminder72Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder72Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder72
	)
	default String reminder72Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder72Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder72
	)
	default String reminder72Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder72Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder72
	)
	default int reminder72Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder72RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder72
	)
	default String reminder72RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder72
	)
	default String reminder72NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder72
	)
	default String reminder72ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder72
	)
	default int reminder72Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder72Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder72
	)
	default int reminder72Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder72TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder72
	)
	default TimeUnit reminder72TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder72ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder72
	)
	default String reminder72ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder72Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder72
	)
	default boolean reminder72Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder72SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder72
	)
	default boolean reminder72SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder72panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder72
	)
	default RSAnchorType reminder72PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder72PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder72
	)
	default int reminder72PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder72PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder72
	)
	default int reminder72PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder72ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder72
	)
	default RSViewGroup.Gravity reminder72ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder72ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder72
	)
	default int reminder72ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder72Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder72
	)
	default boolean reminder72Image() { return false; }

	@ConfigItem(
			keyName = "Reminder72Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder72
	)
	default boolean reminder72Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder72AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder72
	)
	default ColorAnimationType reminder72AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder72CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder72
	)
	default int reminder72CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder73",
			description = "Reminder 73",
			position = 93,
			closedByDefault = true
	)
	String reminder73= "reminder73";

	@ConfigItem(
			keyName = "enableReminder73",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder73
	)
	default boolean reminder73Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder73Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder73
	)
	default String reminder73Text() { return ""; }

	@ConfigItem(
			keyName = "reminder73Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder73
	)
	default Color reminder73Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder73Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder73
	)
	default String reminder73Times() { return ""; }

	@ConfigItem(
			keyName = "reminder73DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder73
	)
	default String reminder73DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder73Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder73
	)
	default String reminder73Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder73Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder73
	)
	default String reminder73Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder73Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder73
	)
	default String reminder73Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder73Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder73
	)
	default int reminder73Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder73RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder73
	)
	default String reminder73RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder73
	)
	default String reminder73NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder73
	)
	default String reminder73ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder73
	)
	default int reminder73Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder73Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder73
	)
	default int reminder73Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder73TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder73
	)
	default TimeUnit reminder73TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder73ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder73
	)
	default String reminder73ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder73Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder73
	)
	default boolean reminder73Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder73SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder73
	)
	default boolean reminder73SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder73panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder73
	)
	default RSAnchorType reminder73PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder73PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder73
	)
	default int reminder73PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder73PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder73
	)
	default int reminder73PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder73ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder73
	)
	default RSViewGroup.Gravity reminder73ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder73ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder73
	)
	default int reminder73ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder73Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder73
	)
	default boolean reminder73Image() { return false; }

	@ConfigItem(
			keyName = "Reminder73Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder73
	)
	default boolean reminder73Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder73AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder73
	)
	default ColorAnimationType reminder73AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder73CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder73
	)
	default int reminder73CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder74",
			description = "Reminder 74",
			position = 94,
			closedByDefault = true
	)
	String reminder74= "reminder74";

	@ConfigItem(
			keyName = "enableReminder74",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder74
	)
	default boolean reminder74Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder74Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder74
	)
	default String reminder74Text() { return ""; }

	@ConfigItem(
			keyName = "reminder74Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder74
	)
	default Color reminder74Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder74Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder74
	)
	default String reminder74Times() { return ""; }

	@ConfigItem(
			keyName = "reminder74DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder74
	)
	default String reminder74DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder74Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder74
	)
	default String reminder74Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder74Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder74
	)
	default String reminder74Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder74Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder74
	)
	default String reminder74Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder74Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder74
	)
	default int reminder74Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder74RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder74
	)
	default String reminder74RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder74
	)
	default String reminder74NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder74
	)
	default String reminder74ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder74
	)
	default int reminder74Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder74Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder74
	)
	default int reminder74Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder74TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder74
	)
	default TimeUnit reminder74TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder74ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder74
	)
	default String reminder74ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder74Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder74
	)
	default boolean reminder74Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder74SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder74
	)
	default boolean reminder74SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder74panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder74
	)
	default RSAnchorType reminder74PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder74PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder74
	)
	default int reminder74PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder74PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder74
	)
	default int reminder74PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder74ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder74
	)
	default RSViewGroup.Gravity reminder74ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder74ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder74
	)
	default int reminder74ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder74Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder74
	)
	default boolean reminder74Image() { return false; }

	@ConfigItem(
			keyName = "Reminder74Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder74
	)
	default boolean reminder74Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder74AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder74
	)
	default ColorAnimationType reminder74AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder74CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder74
	)
	default int reminder74CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder75",
			description = "Reminder 75",
			position = 95,
			closedByDefault = true
	)
	String reminder75= "reminder75";

	@ConfigItem(
			keyName = "enableReminder75",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder75
	)
	default boolean reminder75Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder75Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder75
	)
	default String reminder75Text() { return ""; }

	@ConfigItem(
			keyName = "reminder75Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder75
	)
	default Color reminder75Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder75Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder75
	)
	default String reminder75Times() { return ""; }

	@ConfigItem(
			keyName = "reminder75DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder75
	)
	default String reminder75DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder75Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder75
	)
	default String reminder75Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder75Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder75
	)
	default String reminder75Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder75Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder75
	)
	default String reminder75Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder75Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder75
	)
	default int reminder75Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder75RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder75
	)
	default String reminder75RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder75
	)
	default String reminder75NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder75
	)
	default String reminder75ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder75
	)
	default int reminder75Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder75Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder75
	)
	default int reminder75Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder75TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder75
	)
	default TimeUnit reminder75TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder75ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder75
	)
	default String reminder75ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder75Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder75
	)
	default boolean reminder75Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder75SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder75
	)
	default boolean reminder75SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder75panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder75
	)
	default RSAnchorType reminder75PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder75PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder75
	)
	default int reminder75PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder75PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder75
	)
	default int reminder75PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder75ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder75
	)
	default RSViewGroup.Gravity reminder75ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder75ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder75
	)
	default int reminder75ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder75Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder75
	)
	default boolean reminder75Image() { return false; }

	@ConfigItem(
			keyName = "Reminder75Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder75
	)
	default boolean reminder75Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder75AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder75
	)
	default ColorAnimationType reminder75AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder75CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder75
	)
	default int reminder75CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder76",
			description = "Reminder 76",
			position = 96,
			closedByDefault = true
	)
	String reminder76= "reminder76";

	@ConfigItem(
			keyName = "enableReminder76",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder76
	)
	default boolean reminder76Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder76Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder76
	)
	default String reminder76Text() { return ""; }

	@ConfigItem(
			keyName = "reminder76Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder76
	)
	default Color reminder76Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder76Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder76
	)
	default String reminder76Times() { return ""; }

	@ConfigItem(
			keyName = "reminder76DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder76
	)
	default String reminder76DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder76Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder76
	)
	default String reminder76Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder76Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder76
	)
	default String reminder76Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder76Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder76
	)
	default String reminder76Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder76Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder76
	)
	default int reminder76Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder76RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder76
	)
	default String reminder76RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder76
	)
	default String reminder76NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder76
	)
	default String reminder76ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder76
	)
	default int reminder76Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder76Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder76
	)
	default int reminder76Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder76TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder76
	)
	default TimeUnit reminder76TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder76ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder76
	)
	default String reminder76ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder76Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder76
	)
	default boolean reminder76Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder76SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder76
	)
	default boolean reminder76SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder76panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder76
	)
	default RSAnchorType reminder76PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder76PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder76
	)
	default int reminder76PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder76PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder76
	)
	default int reminder76PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder76ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder76
	)
	default RSViewGroup.Gravity reminder76ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder76ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder76
	)
	default int reminder76ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder76Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder76
	)
	default boolean reminder76Image() { return false; }

	@ConfigItem(
			keyName = "Reminder76Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder76
	)
	default boolean reminder76Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder76AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder76
	)
	default ColorAnimationType reminder76AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder76CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder76
	)
	default int reminder76CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder77",
			description = "Reminder 77",
			position = 97,
			closedByDefault = true
	)
	String reminder77= "reminder77";

	@ConfigItem(
			keyName = "enableReminder77",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder77
	)
	default boolean reminder77Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder77Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder77
	)
	default String reminder77Text() { return ""; }

	@ConfigItem(
			keyName = "reminder77Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder77
	)
	default Color reminder77Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder77Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder77
	)
	default String reminder77Times() { return ""; }

	@ConfigItem(
			keyName = "reminder77DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder77
	)
	default String reminder77DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder77Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder77
	)
	default String reminder77Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder77Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder77
	)
	default String reminder77Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder77Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder77
	)
	default String reminder77Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder77Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder77
	)
	default int reminder77Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder77RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder77
	)
	default String reminder77RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder77
	)
	default String reminder77NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder77
	)
	default String reminder77ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder77
	)
	default int reminder77Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder77Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder77
	)
	default int reminder77Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder77TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder77
	)
	default TimeUnit reminder77TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder77ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder77
	)
	default String reminder77ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder77Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder77
	)
	default boolean reminder77Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder77SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder77
	)
	default boolean reminder77SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder77panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder77
	)
	default RSAnchorType reminder77PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder77PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder77
	)
	default int reminder77PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder77PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder77
	)
	default int reminder77PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder77ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder77
	)
	default RSViewGroup.Gravity reminder77ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder77ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder77
	)
	default int reminder77ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder77Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder77
	)
	default boolean reminder77Image() { return false; }

	@ConfigItem(
			keyName = "Reminder77Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder77
	)
	default boolean reminder77Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder77AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder77
	)
	default ColorAnimationType reminder77AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder77CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder77
	)
	default int reminder77CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder78",
			description = "Reminder 78",
			position = 98,
			closedByDefault = true
	)
	String reminder78= "reminder78";

	@ConfigItem(
			keyName = "enableReminder78",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder78
	)
	default boolean reminder78Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder78Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder78
	)
	default String reminder78Text() { return ""; }

	@ConfigItem(
			keyName = "reminder78Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder78
	)
	default Color reminder78Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder78Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder78
	)
	default String reminder78Times() { return ""; }

	@ConfigItem(
			keyName = "reminder78DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder78
	)
	default String reminder78DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder78Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder78
	)
	default String reminder78Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder78Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder78
	)
	default String reminder78Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder78Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder78
	)
	default String reminder78Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder78Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder78
	)
	default int reminder78Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder78RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder78
	)
	default String reminder78RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder78
	)
	default String reminder78NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder78
	)
	default String reminder78ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder78
	)
	default int reminder78Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder78Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder78
	)
	default int reminder78Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder78TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder78
	)
	default TimeUnit reminder78TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder78ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder78
	)
	default String reminder78ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder78Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder78
	)
	default boolean reminder78Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder78SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder78
	)
	default boolean reminder78SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder78panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder78
	)
	default RSAnchorType reminder78PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder78PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder78
	)
	default int reminder78PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder78PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder78
	)
	default int reminder78PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder78ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder78
	)
	default RSViewGroup.Gravity reminder78ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder78ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder78
	)
	default int reminder78ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder78Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder78
	)
	default boolean reminder78Image() { return false; }

	@ConfigItem(
			keyName = "Reminder78Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder78
	)
	default boolean reminder78Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder78AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder78
	)
	default ColorAnimationType reminder78AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder78CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder78
	)
	default int reminder78CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder79",
			description = "Reminder 79",
			position = 99,
			closedByDefault = true
	)
	String reminder79= "reminder79";

	@ConfigItem(
			keyName = "enableReminder79",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder79
	)
	default boolean reminder79Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder79Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder79
	)
	default String reminder79Text() { return ""; }

	@ConfigItem(
			keyName = "reminder79Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder79
	)
	default Color reminder79Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder79Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder79
	)
	default String reminder79Times() { return ""; }

	@ConfigItem(
			keyName = "reminder79DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder79
	)
	default String reminder79DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder79Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder79
	)
	default String reminder79Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder79Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder79
	)
	default String reminder79Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder79Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder79
	)
	default String reminder79Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder79Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder79
	)
	default int reminder79Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder79RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder79
	)
	default String reminder79RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder79
	)
	default String reminder79NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder79
	)
	default String reminder79ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder79
	)
	default int reminder79Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder79Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder79
	)
	default int reminder79Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder79TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder79
	)
	default TimeUnit reminder79TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder79ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder79
	)
	default String reminder79ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder79Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder79
	)
	default boolean reminder79Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder79SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder79
	)
	default boolean reminder79SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder79panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder79
	)
	default RSAnchorType reminder79PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder79PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder79
	)
	default int reminder79PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder79PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder79
	)
	default int reminder79PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder79ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder79
	)
	default RSViewGroup.Gravity reminder79ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder79ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder79
	)
	default int reminder79ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder79Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder79
	)
	default boolean reminder79Image() { return false; }

	@ConfigItem(
			keyName = "Reminder79Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder79
	)
	default boolean reminder79Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder79AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder79
	)
	default ColorAnimationType reminder79AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder79CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder79
	)
	default int reminder79CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder80",
			description = "Reminder 80",
			position = 100,
			closedByDefault = true
	)
	String reminder80= "reminder80";

	@ConfigItem(
			keyName = "enableReminder80",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder80
	)
	default boolean reminder80Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder80Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder80
	)
	default String reminder80Text() { return ""; }

	@ConfigItem(
			keyName = "reminder80Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder80
	)
	default Color reminder80Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder80Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder80
	)
	default String reminder80Times() { return ""; }

	@ConfigItem(
			keyName = "reminder80DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder80
	)
	default String reminder80DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder80Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder80
	)
	default String reminder80Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder80Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder80
	)
	default String reminder80Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder80Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder80
	)
	default String reminder80Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder80Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder80
	)
	default int reminder80Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder80RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder80
	)
	default String reminder80RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder80
	)
	default String reminder80NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder80
	)
	default String reminder80ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder80
	)
	default int reminder80Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder80Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder80
	)
	default int reminder80Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder80TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder80
	)
	default TimeUnit reminder80TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder80ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder80
	)
	default String reminder80ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder80Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder80
	)
	default boolean reminder80Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder80SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder80
	)
	default boolean reminder80SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder80panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder80
	)
	default RSAnchorType reminder80PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder80PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder80
	)
	default int reminder80PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder80PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder80
	)
	default int reminder80PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder80ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder80
	)
	default RSViewGroup.Gravity reminder80ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder80ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder80
	)
	default int reminder80ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder80Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder80
	)
	default boolean reminder80Image() { return false; }

	@ConfigItem(
			keyName = "Reminder80Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder80
	)
	default boolean reminder80Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder80AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder80
	)
	default ColorAnimationType reminder80AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder80CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder80
	)
	default int reminder80CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder81",
			description = "Reminder 81",
			position = 101,
			closedByDefault = true
	)
	String reminder81= "reminder81";

	@ConfigItem(
			keyName = "enableReminder81",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder81
	)
	default boolean reminder81Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder81Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder81
	)
	default String reminder81Text() { return ""; }

	@ConfigItem(
			keyName = "reminder81Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder81
	)
	default Color reminder81Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder81Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder81
	)
	default String reminder81Times() { return ""; }

	@ConfigItem(
			keyName = "reminder81DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder81
	)
	default String reminder81DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder81Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder81
	)
	default String reminder81Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder81Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder81
	)
	default String reminder81Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder81Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder81
	)
	default String reminder81Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder81Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder81
	)
	default int reminder81Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder81RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder81
	)
	default String reminder81RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder81
	)
	default String reminder81NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder81
	)
	default String reminder81ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder81
	)
	default int reminder81Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder81Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder81
	)
	default int reminder81Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder81TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder81
	)
	default TimeUnit reminder81TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder81ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder81
	)
	default String reminder81ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder81Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder81
	)
	default boolean reminder81Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder81SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder81
	)
	default boolean reminder81SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder81panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder81
	)
	default RSAnchorType reminder81PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder81PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder81
	)
	default int reminder81PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder81PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder81
	)
	default int reminder81PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder81ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder81
	)
	default RSViewGroup.Gravity reminder81ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder81ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder81
	)
	default int reminder81ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder81Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder81
	)
	default boolean reminder81Image() { return false; }

	@ConfigItem(
			keyName = "Reminder81Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder81
	)
	default boolean reminder81Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder81AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder81
	)
	default ColorAnimationType reminder81AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder81CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder81
	)
	default int reminder81CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder82",
			description = "Reminder 82",
			position = 102,
			closedByDefault = true
	)
	String reminder82= "reminder82";

	@ConfigItem(
			keyName = "enableReminder82",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder82
	)
	default boolean reminder82Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder82Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder82
	)
	default String reminder82Text() { return ""; }

	@ConfigItem(
			keyName = "reminder82Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder82
	)
	default Color reminder82Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder82Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder82
	)
	default String reminder82Times() { return ""; }

	@ConfigItem(
			keyName = "reminder82DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder82
	)
	default String reminder82DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder82Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder82
	)
	default String reminder82Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder82Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder82
	)
	default String reminder82Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder82Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder82
	)
	default String reminder82Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder82Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder82
	)
	default int reminder82Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder82RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder82
	)
	default String reminder82RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder82
	)
	default String reminder82NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder82
	)
	default String reminder82ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder82
	)
	default int reminder82Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder82Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder82
	)
	default int reminder82Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder82TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder82
	)
	default TimeUnit reminder82TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder82ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder82
	)
	default String reminder82ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder82Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder82
	)
	default boolean reminder82Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder82SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder82
	)
	default boolean reminder82SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder82panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder82
	)
	default RSAnchorType reminder82PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder82PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder82
	)
	default int reminder82PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder82PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder82
	)
	default int reminder82PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder82ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder82
	)
	default RSViewGroup.Gravity reminder82ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder82ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder82
	)
	default int reminder82ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder82Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder82
	)
	default boolean reminder82Image() { return false; }

	@ConfigItem(
			keyName = "Reminder82Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder82
	)
	default boolean reminder82Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder82AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder82
	)
	default ColorAnimationType reminder82AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder82CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder82
	)
	default int reminder82CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder83",
			description = "Reminder 83",
			position = 103,
			closedByDefault = true
	)
	String reminder83= "reminder83";

	@ConfigItem(
			keyName = "enableReminder83",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder83
	)
	default boolean reminder83Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder83Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder83
	)
	default String reminder83Text() { return ""; }

	@ConfigItem(
			keyName = "reminder83Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder83
	)
	default Color reminder83Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder83Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder83
	)
	default String reminder83Times() { return ""; }

	@ConfigItem(
			keyName = "reminder83DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder83
	)
	default String reminder83DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder83Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder83
	)
	default String reminder83Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder83Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder83
	)
	default String reminder83Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder83Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder83
	)
	default String reminder83Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder83Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder83
	)
	default int reminder83Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder83RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder83
	)
	default String reminder83RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder83
	)
	default String reminder83NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder83
	)
	default String reminder83ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder83
	)
	default int reminder83Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder83Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder83
	)
	default int reminder83Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder83TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder83
	)
	default TimeUnit reminder83TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder83ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder83
	)
	default String reminder83ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder83Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder83
	)
	default boolean reminder83Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder83SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder83
	)
	default boolean reminder83SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder83panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder83
	)
	default RSAnchorType reminder83PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder83PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder83
	)
	default int reminder83PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder83PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder83
	)
	default int reminder83PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder83ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder83
	)
	default RSViewGroup.Gravity reminder83ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder83ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder83
	)
	default int reminder83ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder83Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder83
	)
	default boolean reminder83Image() { return false; }

	@ConfigItem(
			keyName = "Reminder83Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder83
	)
	default boolean reminder83Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder83AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder83
	)
	default ColorAnimationType reminder83AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder83CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder83
	)
	default int reminder83CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder84",
			description = "Reminder 84",
			position = 104,
			closedByDefault = true
	)
	String reminder84= "reminder84";

	@ConfigItem(
			keyName = "enableReminder84",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder84
	)
	default boolean reminder84Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder84Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder84
	)
	default String reminder84Text() { return ""; }

	@ConfigItem(
			keyName = "reminder84Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder84
	)
	default Color reminder84Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder84Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder84
	)
	default String reminder84Times() { return ""; }

	@ConfigItem(
			keyName = "reminder84DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder84
	)
	default String reminder84DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder84Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder84
	)
	default String reminder84Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder84Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder84
	)
	default String reminder84Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder84Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder84
	)
	default String reminder84Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder84Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder84
	)
	default int reminder84Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder84RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder84
	)
	default String reminder84RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder84
	)
	default String reminder84NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder84
	)
	default String reminder84ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder84
	)
	default int reminder84Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder84Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder84
	)
	default int reminder84Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder84TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder84
	)
	default TimeUnit reminder84TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder84ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder84
	)
	default String reminder84ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder84Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder84
	)
	default boolean reminder84Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder84SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder84
	)
	default boolean reminder84SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder84panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder84
	)
	default RSAnchorType reminder84PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder84PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder84
	)
	default int reminder84PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder84PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder84
	)
	default int reminder84PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder84ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder84
	)
	default RSViewGroup.Gravity reminder84ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder84ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder84
	)
	default int reminder84ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder84Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder84
	)
	default boolean reminder84Image() { return false; }

	@ConfigItem(
			keyName = "Reminder84Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder84
	)
	default boolean reminder84Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder84AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder84
	)
	default ColorAnimationType reminder84AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder84CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder84
	)
	default int reminder84CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder85",
			description = "Reminder 85",
			position = 105,
			closedByDefault = true
	)
	String reminder85= "reminder85";

	@ConfigItem(
			keyName = "enableReminder85",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder85
	)
	default boolean reminder85Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder85Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder85
	)
	default String reminder85Text() { return ""; }

	@ConfigItem(
			keyName = "reminder85Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder85
	)
	default Color reminder85Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder85Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder85
	)
	default String reminder85Times() { return ""; }

	@ConfigItem(
			keyName = "reminder85DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder85
	)
	default String reminder85DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder85Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder85
	)
	default String reminder85Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder85Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder85
	)
	default String reminder85Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder85Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder85
	)
	default String reminder85Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder85Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder85
	)
	default int reminder85Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder85RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder85
	)
	default String reminder85RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder85
	)
	default String reminder85NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder85
	)
	default String reminder85ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder85
	)
	default int reminder85Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder85Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder85
	)
	default int reminder85Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder85TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder85
	)
	default TimeUnit reminder85TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder85ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder85
	)
	default String reminder85ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder85Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder85
	)
	default boolean reminder85Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder85SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder85
	)
	default boolean reminder85SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder85panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder85
	)
	default RSAnchorType reminder85PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder85PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder85
	)
	default int reminder85PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder85PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder85
	)
	default int reminder85PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder85ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder85
	)
	default RSViewGroup.Gravity reminder85ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder85ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder85
	)
	default int reminder85ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder85Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder85
	)
	default boolean reminder85Image() { return false; }

	@ConfigItem(
			keyName = "Reminder85Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder85
	)
	default boolean reminder85Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder85AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder85
	)
	default ColorAnimationType reminder85AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder85CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder85
	)
	default int reminder85CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder86",
			description = "Reminder 86",
			position = 106,
			closedByDefault = true
	)
	String reminder86= "reminder86";

	@ConfigItem(
			keyName = "enableReminder86",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder86
	)
	default boolean reminder86Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder86Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder86
	)
	default String reminder86Text() { return ""; }

	@ConfigItem(
			keyName = "reminder86Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder86
	)
	default Color reminder86Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder86Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder86
	)
	default String reminder86Times() { return ""; }

	@ConfigItem(
			keyName = "reminder86DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder86
	)
	default String reminder86DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder86Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder86
	)
	default String reminder86Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder86Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder86
	)
	default String reminder86Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder86Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder86
	)
	default String reminder86Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder86Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder86
	)
	default int reminder86Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder86RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder86
	)
	default String reminder86RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder86
	)
	default String reminder86NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder86
	)
	default String reminder86ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder86
	)
	default int reminder86Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder86Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder86
	)
	default int reminder86Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder86TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder86
	)
	default TimeUnit reminder86TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder86ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder86
	)
	default String reminder86ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder86Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder86
	)
	default boolean reminder86Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder86SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder86
	)
	default boolean reminder86SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder86panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder86
	)
	default RSAnchorType reminder86PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder86PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder86
	)
	default int reminder86PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder86PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder86
	)
	default int reminder86PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder86ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder86
	)
	default RSViewGroup.Gravity reminder86ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder86ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder86
	)
	default int reminder86ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder86Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder86
	)
	default boolean reminder86Image() { return false; }

	@ConfigItem(
			keyName = "Reminder86Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder86
	)
	default boolean reminder86Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder86AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder86
	)
	default ColorAnimationType reminder86AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder86CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder86
	)
	default int reminder86CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder87",
			description = "Reminder 87",
			position = 107,
			closedByDefault = true
	)
	String reminder87= "reminder87";

	@ConfigItem(
			keyName = "enableReminder87",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder87
	)
	default boolean reminder87Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder87Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder87
	)
	default String reminder87Text() { return ""; }

	@ConfigItem(
			keyName = "reminder87Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder87
	)
	default Color reminder87Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder87Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder87
	)
	default String reminder87Times() { return ""; }

	@ConfigItem(
			keyName = "reminder87DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder87
	)
	default String reminder87DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder87Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder87
	)
	default String reminder87Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder87Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder87
	)
	default String reminder87Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder87Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder87
	)
	default String reminder87Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder87Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder87
	)
	default int reminder87Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder87RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder87
	)
	default String reminder87RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder87
	)
	default String reminder87NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder87
	)
	default String reminder87ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder87
	)
	default int reminder87Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder87Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder87
	)
	default int reminder87Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder87TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder87
	)
	default TimeUnit reminder87TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder87ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder87
	)
	default String reminder87ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder87Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder87
	)
	default boolean reminder87Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder87SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder87
	)
	default boolean reminder87SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder87panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder87
	)
	default RSAnchorType reminder87PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder87PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder87
	)
	default int reminder87PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder87PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder87
	)
	default int reminder87PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder87ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder87
	)
	default RSViewGroup.Gravity reminder87ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder87ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder87
	)
	default int reminder87ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder87Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder87
	)
	default boolean reminder87Image() { return false; }

	@ConfigItem(
			keyName = "Reminder87Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder87
	)
	default boolean reminder87Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder87AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder87
	)
	default ColorAnimationType reminder87AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder87CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder87
	)
	default int reminder87CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder88",
			description = "Reminder 88",
			position = 108,
			closedByDefault = true
	)
	String reminder88= "reminder88";

	@ConfigItem(
			keyName = "enableReminder88",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder88
	)
	default boolean reminder88Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder88Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder88
	)
	default String reminder88Text() { return ""; }

	@ConfigItem(
			keyName = "reminder88Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder88
	)
	default Color reminder88Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder88Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder88
	)
	default String reminder88Times() { return ""; }

	@ConfigItem(
			keyName = "reminder88DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder88
	)
	default String reminder88DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder88Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder88
	)
	default String reminder88Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder88Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder88
	)
	default String reminder88Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder88Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder88
	)
	default String reminder88Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder88Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder88
	)
	default int reminder88Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder88RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder88
	)
	default String reminder88RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder88
	)
	default String reminder88NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder88
	)
	default String reminder88ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder88
	)
	default int reminder88Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder88Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder88
	)
	default int reminder88Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder88TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder88
	)
	default TimeUnit reminder88TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder88ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder88
	)
	default String reminder88ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder88Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder88
	)
	default boolean reminder88Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder88SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder88
	)
	default boolean reminder88SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder88panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder88
	)
	default RSAnchorType reminder88PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder88PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder88
	)
	default int reminder88PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder88PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder88
	)
	default int reminder88PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder88ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder88
	)
	default RSViewGroup.Gravity reminder88ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder88ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder88
	)
	default int reminder88ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder88Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder88
	)
	default boolean reminder88Image() { return false; }

	@ConfigItem(
			keyName = "Reminder88Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder88
	)
	default boolean reminder88Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder88AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder88
	)
	default ColorAnimationType reminder88AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder88CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder88
	)
	default int reminder88CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder89",
			description = "Reminder 89",
			position = 109,
			closedByDefault = true
	)
	String reminder89= "reminder89";

	@ConfigItem(
			keyName = "enableReminder89",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder89
	)
	default boolean reminder89Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder89Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder89
	)
	default String reminder89Text() { return ""; }

	@ConfigItem(
			keyName = "reminder89Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder89
	)
	default Color reminder89Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder89Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder89
	)
	default String reminder89Times() { return ""; }

	@ConfigItem(
			keyName = "reminder89DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder89
	)
	default String reminder89DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder89Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder89
	)
	default String reminder89Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder89Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder89
	)
	default String reminder89Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder89Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder89
	)
	default String reminder89Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder89Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder89
	)
	default int reminder89Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder89RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder89
	)
	default String reminder89RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder89
	)
	default String reminder89NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder89
	)
	default String reminder89ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder89
	)
	default int reminder89Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder89Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder89
	)
	default int reminder89Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder89TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder89
	)
	default TimeUnit reminder89TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder89ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder89
	)
	default String reminder89ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder89Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder89
	)
	default boolean reminder89Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder89SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder89
	)
	default boolean reminder89SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder89panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder89
	)
	default RSAnchorType reminder89PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder89PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder89
	)
	default int reminder89PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder89PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder89
	)
	default int reminder89PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder89ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder89
	)
	default RSViewGroup.Gravity reminder89ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder89ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder89
	)
	default int reminder89ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder89Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder89
	)
	default boolean reminder89Image() { return false; }

	@ConfigItem(
			keyName = "Reminder89Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder89
	)
	default boolean reminder89Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder89AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder89
	)
	default ColorAnimationType reminder89AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder89CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder89
	)
	default int reminder89CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder90",
			description = "Reminder 90",
			position = 110,
			closedByDefault = true
	)
	String reminder90= "reminder90";

	@ConfigItem(
			keyName = "enableReminder90",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder90
	)
	default boolean reminder90Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder90Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder90
	)
	default String reminder90Text() { return ""; }

	@ConfigItem(
			keyName = "reminder90Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder90
	)
	default Color reminder90Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder90Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder90
	)
	default String reminder90Times() { return ""; }

	@ConfigItem(
			keyName = "reminder90DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder90
	)
	default String reminder90DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder90Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder90
	)
	default String reminder90Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder90Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder90
	)
	default String reminder90Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder90Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder90
	)
	default String reminder90Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder90Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder90
	)
	default int reminder90Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder90RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder90
	)
	default String reminder90RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder90
	)
	default String reminder90NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder90
	)
	default String reminder90ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder90
	)
	default int reminder90Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder90Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder90
	)
	default int reminder90Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder90TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder90
	)
	default TimeUnit reminder90TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder90ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder90
	)
	default String reminder90ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder90Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder90
	)
	default boolean reminder90Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder90SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder90
	)
	default boolean reminder90SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder90panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder90
	)
	default RSAnchorType reminder90PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder90PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder90
	)
	default int reminder90PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder90PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder90
	)
	default int reminder90PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder90ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder90
	)
	default RSViewGroup.Gravity reminder90ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder90ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder90
	)
	default int reminder90ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder90Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder90
	)
	default boolean reminder90Image() { return false; }

	@ConfigItem(
			keyName = "Reminder90Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder90
	)
	default boolean reminder90Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder90AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder90
	)
	default ColorAnimationType reminder90AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder90CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder90
	)
	default int reminder90CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder91",
			description = "Reminder 91",
			position = 111,
			closedByDefault = true
	)
	String reminder91= "reminder91";

	@ConfigItem(
			keyName = "enableReminder91",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder91
	)
	default boolean reminder91Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder91Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder91
	)
	default String reminder91Text() { return ""; }

	@ConfigItem(
			keyName = "reminder91Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder91
	)
	default Color reminder91Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder91Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder91
	)
	default String reminder91Times() { return ""; }

	@ConfigItem(
			keyName = "reminder91DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder91
	)
	default String reminder91DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder91Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder91
	)
	default String reminder91Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder91Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder91
	)
	default String reminder91Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder91Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder91
	)
	default String reminder91Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder91Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder91
	)
	default int reminder91Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder91RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder91
	)
	default String reminder91RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder91
	)
	default String reminder91NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder91
	)
	default String reminder91ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder91
	)
	default int reminder91Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder91Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder91
	)
	default int reminder91Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder91TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder91
	)
	default TimeUnit reminder91TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder91ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder91
	)
	default String reminder91ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder91Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder91
	)
	default boolean reminder91Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder91SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder91
	)
	default boolean reminder91SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder91panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder91
	)
	default RSAnchorType reminder91PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder91PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder91
	)
	default int reminder91PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder91PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder91
	)
	default int reminder91PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder91ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder91
	)
	default RSViewGroup.Gravity reminder91ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder91ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder91
	)
	default int reminder91ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder91Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder91
	)
	default boolean reminder91Image() { return false; }

	@ConfigItem(
			keyName = "Reminder91Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder91
	)
	default boolean reminder91Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder91AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder91
	)
	default ColorAnimationType reminder91AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder91CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder91
	)
	default int reminder91CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder92",
			description = "Reminder 92",
			position = 112,
			closedByDefault = true
	)
	String reminder92= "reminder92";

	@ConfigItem(
			keyName = "enableReminder92",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder92
	)
	default boolean reminder92Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder92Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder92
	)
	default String reminder92Text() { return ""; }

	@ConfigItem(
			keyName = "reminder92Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder92
	)
	default Color reminder92Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder92Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder92
	)
	default String reminder92Times() { return ""; }

	@ConfigItem(
			keyName = "reminder92DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder92
	)
	default String reminder92DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder92Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder92
	)
	default String reminder92Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder92Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder92
	)
	default String reminder92Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder92Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder92
	)
	default String reminder92Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder92Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder92
	)
	default int reminder92Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder92RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder92
	)
	default String reminder92RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder92
	)
	default String reminder92NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder92
	)
	default String reminder92ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder92
	)
	default int reminder92Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder92Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder92
	)
	default int reminder92Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder92TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder92
	)
	default TimeUnit reminder92TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder92ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder92
	)
	default String reminder92ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder92Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder92
	)
	default boolean reminder92Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder92SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder92
	)
	default boolean reminder92SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder92panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder92
	)
	default RSAnchorType reminder92PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder92PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder92
	)
	default int reminder92PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder92PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder92
	)
	default int reminder92PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder92ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder92
	)
	default RSViewGroup.Gravity reminder92ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder92ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder92
	)
	default int reminder92ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder92Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder92
	)
	default boolean reminder92Image() { return false; }

	@ConfigItem(
			keyName = "Reminder92Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder92
	)
	default boolean reminder92Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder92AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder92
	)
	default ColorAnimationType reminder92AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder92CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder92
	)
	default int reminder92CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder93",
			description = "Reminder 93",
			position = 113,
			closedByDefault = true
	)
	String reminder93= "reminder93";

	@ConfigItem(
			keyName = "enableReminder93",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder93
	)
	default boolean reminder93Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder93Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder93
	)
	default String reminder93Text() { return ""; }

	@ConfigItem(
			keyName = "reminder93Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder93
	)
	default Color reminder93Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder93Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder93
	)
	default String reminder93Times() { return ""; }

	@ConfigItem(
			keyName = "reminder93DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder93
	)
	default String reminder93DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder93Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder93
	)
	default String reminder93Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder93Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder93
	)
	default String reminder93Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder93Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder93
	)
	default String reminder93Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder93Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder93
	)
	default int reminder93Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder93RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder93
	)
	default String reminder93RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder93
	)
	default String reminder93NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder93
	)
	default String reminder93ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder93
	)
	default int reminder93Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder93Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder93
	)
	default int reminder93Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder93TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder93
	)
	default TimeUnit reminder93TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder93ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder93
	)
	default String reminder93ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder93Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder93
	)
	default boolean reminder93Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder93SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder93
	)
	default boolean reminder93SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder93panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder93
	)
	default RSAnchorType reminder93PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder93PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder93
	)
	default int reminder93PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder93PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder93
	)
	default int reminder93PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder93ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder93
	)
	default RSViewGroup.Gravity reminder93ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder93ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder93
	)
	default int reminder93ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder93Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder93
	)
	default boolean reminder93Image() { return false; }

	@ConfigItem(
			keyName = "Reminder93Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder93
	)
	default boolean reminder93Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder93AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder93
	)
	default ColorAnimationType reminder93AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder93CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder93
	)
	default int reminder93CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder94",
			description = "Reminder 94",
			position = 114,
			closedByDefault = true
	)
	String reminder94= "reminder94";

	@ConfigItem(
			keyName = "enableReminder94",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder94
	)
	default boolean reminder94Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder94Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder94
	)
	default String reminder94Text() { return ""; }

	@ConfigItem(
			keyName = "reminder94Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder94
	)
	default Color reminder94Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder94Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder94
	)
	default String reminder94Times() { return ""; }

	@ConfigItem(
			keyName = "reminder94DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder94
	)
	default String reminder94DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder94Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder94
	)
	default String reminder94Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder94Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder94
	)
	default String reminder94Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder94Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder94
	)
	default String reminder94Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder94Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder94
	)
	default int reminder94Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder94RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder94
	)
	default String reminder94RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder94
	)
	default String reminder94NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder94
	)
	default String reminder94ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder94
	)
	default int reminder94Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder94Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder94
	)
	default int reminder94Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder94TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder94
	)
	default TimeUnit reminder94TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder94ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder94
	)
	default String reminder94ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder94Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder94
	)
	default boolean reminder94Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder94SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder94
	)
	default boolean reminder94SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder94panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder94
	)
	default RSAnchorType reminder94PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder94PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder94
	)
	default int reminder94PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder94PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder94
	)
	default int reminder94PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder94ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder94
	)
	default RSViewGroup.Gravity reminder94ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder94ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder94
	)
	default int reminder94ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder94Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder94
	)
	default boolean reminder94Image() { return false; }

	@ConfigItem(
			keyName = "Reminder94Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder94
	)
	default boolean reminder94Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder94AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder94
	)
	default ColorAnimationType reminder94AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder94CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder94
	)
	default int reminder94CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder95",
			description = "Reminder 95",
			position = 115,
			closedByDefault = true
	)
	String reminder95= "reminder95";

	@ConfigItem(
			keyName = "enableReminder95",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder95
	)
	default boolean reminder95Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder95Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder95
	)
	default String reminder95Text() { return ""; }

	@ConfigItem(
			keyName = "reminder95Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder95
	)
	default Color reminder95Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder95Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder95
	)
	default String reminder95Times() { return ""; }

	@ConfigItem(
			keyName = "reminder95DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder95
	)
	default String reminder95DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder95Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder95
	)
	default String reminder95Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder95Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder95
	)
	default String reminder95Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder95Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder95
	)
	default String reminder95Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder95Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder95
	)
	default int reminder95Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder95RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder95
	)
	default String reminder95RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder95
	)
	default String reminder95NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder95
	)
	default String reminder95ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder95
	)
	default int reminder95Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder95Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder95
	)
	default int reminder95Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder95TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder95
	)
	default TimeUnit reminder95TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder95ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder95
	)
	default String reminder95ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder95Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder95
	)
	default boolean reminder95Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder95SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder95
	)
	default boolean reminder95SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder95panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder95
	)
	default RSAnchorType reminder95PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder95PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder95
	)
	default int reminder95PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder95PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder95
	)
	default int reminder95PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder95ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder95
	)
	default RSViewGroup.Gravity reminder95ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder95ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder95
	)
	default int reminder95ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder95Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder95
	)
	default boolean reminder95Image() { return false; }

	@ConfigItem(
			keyName = "Reminder95Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder95
	)
	default boolean reminder95Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder95AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder95
	)
	default ColorAnimationType reminder95AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder95CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder95
	)
	default int reminder95CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder96",
			description = "Reminder 96",
			position = 116,
			closedByDefault = true
	)
	String reminder96= "reminder96";

	@ConfigItem(
			keyName = "enableReminder96",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder96
	)
	default boolean reminder96Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder96Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder96
	)
	default String reminder96Text() { return ""; }

	@ConfigItem(
			keyName = "reminder96Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder96
	)
	default Color reminder96Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder96Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder96
	)
	default String reminder96Times() { return ""; }

	@ConfigItem(
			keyName = "reminder96DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder96
	)
	default String reminder96DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder96Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder96
	)
	default String reminder96Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder96Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder96
	)
	default String reminder96Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder96Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder96
	)
	default String reminder96Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder96Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder96
	)
	default int reminder96Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder96RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder96
	)
	default String reminder96RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder96
	)
	default String reminder96NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder96
	)
	default String reminder96ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder96
	)
	default int reminder96Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder96Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder96
	)
	default int reminder96Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder96TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder96
	)
	default TimeUnit reminder96TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder96ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder96
	)
	default String reminder96ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder96Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder96
	)
	default boolean reminder96Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder96SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder96
	)
	default boolean reminder96SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder96panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder96
	)
	default RSAnchorType reminder96PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder96PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder96
	)
	default int reminder96PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder96PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder96
	)
	default int reminder96PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder96ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder96
	)
	default RSViewGroup.Gravity reminder96ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder96ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder96
	)
	default int reminder96ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder96Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder96
	)
	default boolean reminder96Image() { return false; }

	@ConfigItem(
			keyName = "Reminder96Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder96
	)
	default boolean reminder96Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder96AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder96
	)
	default ColorAnimationType reminder96AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder96CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder96
	)
	default int reminder96CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder97",
			description = "Reminder 97",
			position = 117,
			closedByDefault = true
	)
	String reminder97= "reminder97";

	@ConfigItem(
			keyName = "enableReminder97",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder97
	)
	default boolean reminder97Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder97Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder97
	)
	default String reminder97Text() { return ""; }

	@ConfigItem(
			keyName = "reminder97Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder97
	)
	default Color reminder97Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder97Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder97
	)
	default String reminder97Times() { return ""; }

	@ConfigItem(
			keyName = "reminder97DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder97
	)
	default String reminder97DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder97Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder97
	)
	default String reminder97Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder97Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder97
	)
	default String reminder97Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder97Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder97
	)
	default String reminder97Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder97Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder97
	)
	default int reminder97Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder97RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder97
	)
	default String reminder97RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder97
	)
	default String reminder97NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder97
	)
	default String reminder97ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder97
	)
	default int reminder97Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder97Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder97
	)
	default int reminder97Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder97TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder97
	)
	default TimeUnit reminder97TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder97ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder97
	)
	default String reminder97ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder97Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder97
	)
	default boolean reminder97Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder97SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder97
	)
	default boolean reminder97SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder97panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder97
	)
	default RSAnchorType reminder97PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder97PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder97
	)
	default int reminder97PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder97PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder97
	)
	default int reminder97PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder97ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder97
	)
	default RSViewGroup.Gravity reminder97ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder97ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder97
	)
	default int reminder97ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder97Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder97
	)
	default boolean reminder97Image() { return false; }

	@ConfigItem(
			keyName = "Reminder97Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder97
	)
	default boolean reminder97Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder97AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder97
	)
	default ColorAnimationType reminder97AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder97CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder97
	)
	default int reminder97CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder98",
			description = "Reminder 98",
			position = 118,
			closedByDefault = true
	)
	String reminder98= "reminder98";

	@ConfigItem(
			keyName = "enableReminder98",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder98
	)
	default boolean reminder98Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder98Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder98
	)
	default String reminder98Text() { return ""; }

	@ConfigItem(
			keyName = "reminder98Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder98
	)
	default Color reminder98Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder98Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder98
	)
	default String reminder98Times() { return ""; }

	@ConfigItem(
			keyName = "reminder98DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder98
	)
	default String reminder98DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder98Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder98
	)
	default String reminder98Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder98Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder98
	)
	default String reminder98Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder98Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder98
	)
	default String reminder98Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder98Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder98
	)
	default int reminder98Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder98RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder98
	)
	default String reminder98RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder98
	)
	default String reminder98NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder98
	)
	default String reminder98ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder98
	)
	default int reminder98Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder98Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder98
	)
	default int reminder98Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder98TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder98
	)
	default TimeUnit reminder98TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder98ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder98
	)
	default String reminder98ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder98Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder98
	)
	default boolean reminder98Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder98SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder98
	)
	default boolean reminder98SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder98panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder98
	)
	default RSAnchorType reminder98PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder98PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder98
	)
	default int reminder98PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder98PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder98
	)
	default int reminder98PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder98ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder98
	)
	default RSViewGroup.Gravity reminder98ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder98ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder98
	)
	default int reminder98ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder98Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder98
	)
	default boolean reminder98Image() { return false; }

	@ConfigItem(
			keyName = "Reminder98Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder98
	)
	default boolean reminder98Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder98AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder98
	)
	default ColorAnimationType reminder98AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder98CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder98
	)
	default int reminder98CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder99",
			description = "Reminder 99",
			position = 119,
			closedByDefault = true
	)
	String reminder99= "reminder99";

	@ConfigItem(
			keyName = "enableReminder99",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder99
	)
	default boolean reminder99Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder99Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder99
	)
	default String reminder99Text() { return ""; }

	@ConfigItem(
			keyName = "reminder99Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder99
	)
	default Color reminder99Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder99Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder99
	)
	default String reminder99Times() { return ""; }

	@ConfigItem(
			keyName = "reminder99DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder99
	)
	default String reminder99DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder99Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder99
	)
	default String reminder99Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder99Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder99
	)
	default String reminder99Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder99Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder99
	)
	default String reminder99Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder99Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder99
	)
	default int reminder99Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder99RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder99
	)
	default String reminder99RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder99
	)
	default String reminder99NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder99
	)
	default String reminder99ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder99
	)
	default int reminder99Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder99Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder99
	)
	default int reminder99Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder99TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder99
	)
	default TimeUnit reminder99TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder99ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder99
	)
	default String reminder99ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder99Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder99
	)
	default boolean reminder99Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder99SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder99
	)
	default boolean reminder99SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder99panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder99
	)
	default RSAnchorType reminder99PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder99PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder99
	)
	default int reminder99PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder99PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder99
	)
	default int reminder99PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder99ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder99
	)
	default RSViewGroup.Gravity reminder99ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder99ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder99
	)
	default int reminder99ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder99Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder99
	)
	default boolean reminder99Image() { return false; }

	@ConfigItem(
			keyName = "Reminder99Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder99
	)
	default boolean reminder99Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder99AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder99
	)
	default ColorAnimationType reminder99AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder99CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder99
	)
	default int reminder99CycleDuration() { return 2; }

	@ConfigSection(
			name = "Reminder100",
			description = "Reminder 100",
			position = 120,
			closedByDefault = true
	)
	String reminder100= "reminder100";

	@ConfigItem(
			keyName = "enableReminder100",
			position = 0,
			name = "Enable",
			description = "Configures whether or not reminder is enabled.",
			section = reminder100
	)
	default boolean reminder100Enable()  { return false; }

	@ConfigItem(
			keyName = "reminder100Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = reminder100
	)
	default String reminder100Text() { return ""; }

	@ConfigItem(
			keyName = "reminder100Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = reminder100
	)
	default Color reminder100Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "reminder100Times",
			position = 37,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder100
	)
	default String reminder100Times() { return ""; }

	@ConfigItem(
			keyName = "reminder100DaysOfWeek",
			position = 38,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder100
	)
	default String reminder100DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder100Datess",
			position = 39,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder100
	)
	default String reminder100Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder100Coordinates",
			position = 30,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder100
	)
	default String reminder100Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder100Geofences",
			position = 31,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder100
	)
	default String reminder100Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder100Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder100
	)
	default int reminder100Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder100RegionId",
			position = 33,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder100
	)
	default String reminder100RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100NpcIds",
			position = 34,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder100
	)
	default String reminder100NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100ItemIds",
			position = 35,
			name = "Items in Inventory",
			description = "Configures the item ids in inventory for when reminder is shown (comma separated).",
			section = reminder100
	)
	default String reminder100ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for reminder (Duration 0, Cooldown 0 = infinite).",
			section = reminder100
	)
	default int reminder100Duration() { return 0; }

	@ConfigItem(
			keyName = "Reminder100Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before reminder can be shown again.",
			section = reminder100
	)
	default int reminder100Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Reminder100TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = reminder100
	)
	default TimeUnit reminder100TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Reminder100ChatPatterns",
			position = 36,
			name = "Chat Patterns",
			description = "Configures what text or regex patterns to match in chat messages to show reminder. (comma seperated)",
			section = reminder100
	)
	default String reminder100ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Reminder100Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = reminder100
	)
	default boolean reminder100Notify() { return false; }

	@ConfigItem(
			keyName = "Reminder100SeparatePanel",
			position = 7,
			name = "Separate Panel",
			description = "Configures whether or not reminder is shown in separate panel.",
			section = reminder100
	)
	default boolean reminder100SeparatePanel() { return false; }

	@ConfigItem(
			keyName = "Reminder100panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = reminder100
	)
	default RSAnchorType reminder100PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Reminder100PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = reminder100
	)
	default int reminder100PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Reminder100PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = reminder100
	)
	default int reminder100PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Reminder100ImageAlignment",
			position = 11,
			name = "Image Alignment",
			description = "Configures the image alignment.",
			section = reminder100
	)
	default RSViewGroup.Gravity reminder100ImageAlignment() { return RSViewGroup.Gravity.TOP_START; }

	@ConfigItem(
			keyName = "Reminder100ImageId",
			position = 12,
			name = "Image ID",
			description = "Configures the image id.",
			section = reminder100
	)
	default int reminder100ImageId() { return 0; }

	@ConfigItem(
			keyName = "Reminder100Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the reminder has an image.",
			section = reminder100
	)
	default boolean reminder100Image() { return false; }

	@ConfigItem(
			keyName = "Reminder100Animate",
			position = 14,
			name = "Animate",
			description = "Configures whether or not to animate.",
			section = reminder100
	)
	default boolean reminder100Animate() { return false; }

	@ConfigItem(
			keyName = "Reminder100AnimationType",
			position = 15,
			name = "Animation Type",
			description = "Configures the animation type.",
			section = reminder100
	)
	default ColorAnimationType reminder100AnimationType() { return ColorAnimationType.ANALOGOUS; }

	@ConfigItem(
			keyName = "Reminder100CycleDuration",
			position = 16,
			name = "Cycle Duration",
			description = "Configures the cycle duration for animation.",
			section = reminder100
	)
	default int reminder100CycleDuration() { return 2; }
}