package com.ericversteeg;

import com.ericversteeg.config.TimeUnit;
import com.ericversteeg.views.RSAnchorType;
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder1
	)
	default String reminder1Times() { return ""; }

	@ConfigItem(
			keyName = "reminder1DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder1
	)
	default String reminder1DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder1Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder1
	)
	default String reminder1Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder1Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder1
	)
	default String reminder1Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder1Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder1
	)
	default String reminder1Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder1Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder1
	)
	default int reminder1Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder1RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder1
	)
	default String reminder1RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder1
	)
	default String reminder1NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder2
	)
	default String reminder2Times() { return ""; }

	@ConfigItem(
			keyName = "reminder2DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder2
	)
	default String reminder2DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder2Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder2
	)
	default String reminder2Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder2Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder2
	)
	default String reminder2Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder2Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder2
	)
	default String reminder2Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder2Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder2
	)
	default int reminder2Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder2RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder2
	)
	default String reminder2RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder2
	)
	default String reminder2NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder3
	)
	default String reminder3Times() { return ""; }

	@ConfigItem(
			keyName = "reminder3DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder3
	)
	default String reminder3DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder3Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder3
	)
	default String reminder3Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder3Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder3
	)
	default String reminder3Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder3Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder3
	)
	default String reminder3Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder3Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder3
	)
	default int reminder3Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder3RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder3
	)
	default String reminder3RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder3
	)
	default String reminder3NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder4
	)
	default String reminder4Times() { return ""; }

	@ConfigItem(
			keyName = "reminder4DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder4
	)
	default String reminder4DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder4Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder4
	)
	default String reminder4Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder4Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder4
	)
	default String reminder4Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder4Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder4
	)
	default String reminder4Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder4Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder4
	)
	default int reminder4Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder4RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder4
	)
	default String reminder4RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder4
	)
	default String reminder4NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder5
	)
	default String reminder5Times() { return ""; }

	@ConfigItem(
			keyName = "reminder5DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder5
	)
	default String reminder5DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder5Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder5
	)
	default String reminder5Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder5Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder5
	)
	default String reminder5Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder5Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder5
	)
	default String reminder5Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder5Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder5
	)
	default int reminder5Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder5RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder5
	)
	default String reminder5RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder5
	)
	default String reminder5NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder6
	)
	default String reminder6Times() { return ""; }

	@ConfigItem(
			keyName = "reminder6DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder6
	)
	default String reminder6DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder6Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder6
	)
	default String reminder6Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder6Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder6
	)
	default String reminder6Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder6Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder6
	)
	default String reminder6Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder6Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder6
	)
	default int reminder6Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder6RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder6
	)
	default String reminder6RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder6
	)
	default String reminder6NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder7
	)
	default String reminder7Times() { return ""; }

	@ConfigItem(
			keyName = "reminder7DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder7
	)
	default String reminder7DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder7Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder7
	)
	default String reminder7Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder7Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder7
	)
	default String reminder7Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder7Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder7
	)
	default String reminder7Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder7Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder7
	)
	default int reminder7Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder7RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder7
	)
	default String reminder7RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder7
	)
	default String reminder7NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder8
	)
	default String reminder8Times() { return ""; }

	@ConfigItem(
			keyName = "reminder8DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder8
	)
	default String reminder8DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder8Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder8
	)
	default String reminder8Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder8Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder8
	)
	default String reminder8Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder8Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder8
	)
	default String reminder8Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder8Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder8
	)
	default int reminder8Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder8RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder8
	)
	default String reminder8RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder8
	)
	default String reminder8NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder9
	)
	default String reminder9Times() { return ""; }

	@ConfigItem(
			keyName = "reminder9DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder9
	)
	default String reminder9DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder9Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder9
	)
	default String reminder9Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder9Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder9
	)
	default String reminder9Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder9Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder9
	)
	default String reminder9Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder9Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder9
	)
	default int reminder9Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder9RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder9
	)
	default String reminder9RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder9
	)
	default String reminder9NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder10
	)
	default String reminder10Times() { return ""; }

	@ConfigItem(
			keyName = "reminder10DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder10
	)
	default String reminder10DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder10Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder10
	)
	default String reminder10Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder10Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder10
	)
	default String reminder10Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder10Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder10
	)
	default String reminder10Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder10Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder10
	)
	default int reminder10Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder10RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder10
	)
	default String reminder10RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder10
	)
	default String reminder10NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder11
	)
	default String reminder11Times() { return ""; }

	@ConfigItem(
			keyName = "reminder11DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder11
	)
	default String reminder11DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder11Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder11
	)
	default String reminder11Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder11Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder11
	)
	default String reminder11Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder11Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder11
	)
	default String reminder11Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder11Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder11
	)
	default int reminder11Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder11RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder11
	)
	default String reminder11RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder11
	)
	default String reminder11NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder12
	)
	default String reminder12Times() { return ""; }

	@ConfigItem(
			keyName = "reminder12DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder12
	)
	default String reminder12DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder12Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder12
	)
	default String reminder12Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder12Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder12
	)
	default String reminder12Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder12Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder12
	)
	default String reminder12Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder12Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder12
	)
	default int reminder12Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder12RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder12
	)
	default String reminder12RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder12
	)
	default String reminder12NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder13
	)
	default String reminder13Times() { return ""; }

	@ConfigItem(
			keyName = "reminder13DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder13
	)
	default String reminder13DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder13Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder13
	)
	default String reminder13Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder13Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder13
	)
	default String reminder13Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder13Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder13
	)
	default String reminder13Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder13Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder13
	)
	default int reminder13Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder13RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder13
	)
	default String reminder13RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder13
	)
	default String reminder13NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder14
	)
	default String reminder14Times() { return ""; }

	@ConfigItem(
			keyName = "reminder14DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder14
	)
	default String reminder14DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder14Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder14
	)
	default String reminder14Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder14Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder14
	)
	default String reminder14Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder14Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder14
	)
	default String reminder14Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder14Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder14
	)
	default int reminder14Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder14RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder14
	)
	default String reminder14RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder14
	)
	default String reminder14NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder15
	)
	default String reminder15Times() { return ""; }

	@ConfigItem(
			keyName = "reminder15DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder15
	)
	default String reminder15DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder15Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder15
	)
	default String reminder15Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder15Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder15
	)
	default String reminder15Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder15Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder15
	)
	default String reminder15Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder15Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder15
	)
	default int reminder15Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder15RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder15
	)
	default String reminder15RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder15
	)
	default String reminder15NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder16
	)
	default String reminder16Times() { return ""; }

	@ConfigItem(
			keyName = "reminder16DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder16
	)
	default String reminder16DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder16Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder16
	)
	default String reminder16Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder16Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder16
	)
	default String reminder16Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder16Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder16
	)
	default String reminder16Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder16Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder16
	)
	default int reminder16Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder16RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder16
	)
	default String reminder16RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder16
	)
	default String reminder16NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder17
	)
	default String reminder17Times() { return ""; }

	@ConfigItem(
			keyName = "reminder17DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder17
	)
	default String reminder17DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder17Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder17
	)
	default String reminder17Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder17Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder17
	)
	default String reminder17Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder17Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder17
	)
	default String reminder17Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder17Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder17
	)
	default int reminder17Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder17RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder17
	)
	default String reminder17RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder17
	)
	default String reminder17NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder18
	)
	default String reminder18Times() { return ""; }

	@ConfigItem(
			keyName = "reminder18DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder18
	)
	default String reminder18DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder18Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder18
	)
	default String reminder18Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder18Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder18
	)
	default String reminder18Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder18Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder18
	)
	default String reminder18Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder18Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder18
	)
	default int reminder18Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder18RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder18
	)
	default String reminder18RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder18
	)
	default String reminder18NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder19
	)
	default String reminder19Times() { return ""; }

	@ConfigItem(
			keyName = "reminder19DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder19
	)
	default String reminder19DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder19Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder19
	)
	default String reminder19Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder19Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder19
	)
	default String reminder19Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder19Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder19
	)
	default String reminder19Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder19Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder19
	)
	default int reminder19Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder19RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder19
	)
	default String reminder19RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder19
	)
	default String reminder19NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder20
	)
	default String reminder20Times() { return ""; }

	@ConfigItem(
			keyName = "reminder20DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder20
	)
	default String reminder20DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder20Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder20
	)
	default String reminder20Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder20Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder20
	)
	default String reminder20Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder20Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder20
	)
	default String reminder20Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder20Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder20
	)
	default int reminder20Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder20RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder20
	)
	default String reminder20RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder20
	)
	default String reminder20NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder21
	)
	default String reminder21Times() { return ""; }

	@ConfigItem(
			keyName = "reminder21DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder21
	)
	default String reminder21DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder21Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder21
	)
	default String reminder21Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder21Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder21
	)
	default String reminder21Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder21Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder21
	)
	default String reminder21Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder21Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder21
	)
	default int reminder21Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder21RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder21
	)
	default String reminder21RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder21
	)
	default String reminder21NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder22
	)
	default String reminder22Times() { return ""; }

	@ConfigItem(
			keyName = "reminder22DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder22
	)
	default String reminder22DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder22Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder22
	)
	default String reminder22Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder22Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder22
	)
	default String reminder22Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder22Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder22
	)
	default String reminder22Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder22Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder22
	)
	default int reminder22Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder22RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder22
	)
	default String reminder22RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder22
	)
	default String reminder22NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder23
	)
	default String reminder23Times() { return ""; }

	@ConfigItem(
			keyName = "reminder23DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder23
	)
	default String reminder23DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder23Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder23
	)
	default String reminder23Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder23Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder23
	)
	default String reminder23Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder23Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder23
	)
	default String reminder23Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder23Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder23
	)
	default int reminder23Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder23RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder23
	)
	default String reminder23RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder23
	)
	default String reminder23NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder24
	)
	default String reminder24Times() { return ""; }

	@ConfigItem(
			keyName = "reminder24DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder24
	)
	default String reminder24DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder24Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder24
	)
	default String reminder24Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder24Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder24
	)
	default String reminder24Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder24Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder24
	)
	default String reminder24Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder24Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder24
	)
	default int reminder24Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder24RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder24
	)
	default String reminder24RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder24
	)
	default String reminder24NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder25
	)
	default String reminder25Times() { return ""; }

	@ConfigItem(
			keyName = "reminder25DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder25
	)
	default String reminder25DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder25Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder25
	)
	default String reminder25Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder25Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder25
	)
	default String reminder25Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder25Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder25
	)
	default String reminder25Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder25Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder25
	)
	default int reminder25Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder25RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder25
	)
	default String reminder25RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder25
	)
	default String reminder25NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder26
	)
	default String reminder26Times() { return ""; }

	@ConfigItem(
			keyName = "reminder26DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder26
	)
	default String reminder26DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder26Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder26
	)
	default String reminder26Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder26Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder26
	)
	default String reminder26Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder26Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder26
	)
	default String reminder26Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder26Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder26
	)
	default int reminder26Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder26RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder26
	)
	default String reminder26RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder26
	)
	default String reminder26NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder27
	)
	default String reminder27Times() { return ""; }

	@ConfigItem(
			keyName = "reminder27DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder27
	)
	default String reminder27DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder27Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder27
	)
	default String reminder27Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder27Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder27
	)
	default String reminder27Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder27Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder27
	)
	default String reminder27Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder27Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder27
	)
	default int reminder27Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder27RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder27
	)
	default String reminder27RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder27
	)
	default String reminder27NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder28
	)
	default String reminder28Times() { return ""; }

	@ConfigItem(
			keyName = "reminder28DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder28
	)
	default String reminder28DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder28Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder28
	)
	default String reminder28Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder28Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder28
	)
	default String reminder28Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder28Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder28
	)
	default String reminder28Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder28Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder28
	)
	default int reminder28Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder28RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder28
	)
	default String reminder28RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder28
	)
	default String reminder28NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder29
	)
	default String reminder29Times() { return ""; }

	@ConfigItem(
			keyName = "reminder29DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder29
	)
	default String reminder29DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder29Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder29
	)
	default String reminder29Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder29Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder29
	)
	default String reminder29Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder29Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder29
	)
	default String reminder29Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder29Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder29
	)
	default int reminder29Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder29RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder29
	)
	default String reminder29RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder29
	)
	default String reminder29NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder30
	)
	default String reminder30Times() { return ""; }

	@ConfigItem(
			keyName = "reminder30DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder30
	)
	default String reminder30DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder30Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder30
	)
	default String reminder30Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder30Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder30
	)
	default String reminder30Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder30Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder30
	)
	default String reminder30Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder30Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder30
	)
	default int reminder30Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder30RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder30
	)
	default String reminder30RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder30
	)
	default String reminder30NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder31
	)
	default String reminder31Times() { return ""; }

	@ConfigItem(
			keyName = "reminder31DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder31
	)
	default String reminder31DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder31Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder31
	)
	default String reminder31Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder31Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder31
	)
	default String reminder31Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder31Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder31
	)
	default String reminder31Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder31Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder31
	)
	default int reminder31Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder31RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder31
	)
	default String reminder31RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder31
	)
	default String reminder31NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder32
	)
	default String reminder32Times() { return ""; }

	@ConfigItem(
			keyName = "reminder32DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder32
	)
	default String reminder32DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder32Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder32
	)
	default String reminder32Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder32Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder32
	)
	default String reminder32Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder32Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder32
	)
	default String reminder32Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder32Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder32
	)
	default int reminder32Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder32RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder32
	)
	default String reminder32RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder32
	)
	default String reminder32NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder33
	)
	default String reminder33Times() { return ""; }

	@ConfigItem(
			keyName = "reminder33DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder33
	)
	default String reminder33DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder33Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder33
	)
	default String reminder33Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder33Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder33
	)
	default String reminder33Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder33Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder33
	)
	default String reminder33Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder33Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder33
	)
	default int reminder33Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder33RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder33
	)
	default String reminder33RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder33
	)
	default String reminder33NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder34
	)
	default String reminder34Times() { return ""; }

	@ConfigItem(
			keyName = "reminder34DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder34
	)
	default String reminder34DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder34Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder34
	)
	default String reminder34Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder34Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder34
	)
	default String reminder34Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder34Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder34
	)
	default String reminder34Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder34Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder34
	)
	default int reminder34Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder34RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder34
	)
	default String reminder34RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder34
	)
	default String reminder34NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder35
	)
	default String reminder35Times() { return ""; }

	@ConfigItem(
			keyName = "reminder35DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder35
	)
	default String reminder35DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder35Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder35
	)
	default String reminder35Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder35Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder35
	)
	default String reminder35Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder35Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder35
	)
	default String reminder35Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder35Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder35
	)
	default int reminder35Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder35RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder35
	)
	default String reminder35RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder35
	)
	default String reminder35NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder36
	)
	default String reminder36Times() { return ""; }

	@ConfigItem(
			keyName = "reminder36DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder36
	)
	default String reminder36DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder36Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder36
	)
	default String reminder36Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder36Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder36
	)
	default String reminder36Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder36Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder36
	)
	default String reminder36Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder36Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder36
	)
	default int reminder36Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder36RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder36
	)
	default String reminder36RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder36
	)
	default String reminder36NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder37
	)
	default String reminder37Times() { return ""; }

	@ConfigItem(
			keyName = "reminder37DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder37
	)
	default String reminder37DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder37Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder37
	)
	default String reminder37Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder37Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder37
	)
	default String reminder37Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder37Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder37
	)
	default String reminder37Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder37Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder37
	)
	default int reminder37Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder37RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder37
	)
	default String reminder37RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder37
	)
	default String reminder37NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder38
	)
	default String reminder38Times() { return ""; }

	@ConfigItem(
			keyName = "reminder38DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder38
	)
	default String reminder38DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder38Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder38
	)
	default String reminder38Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder38Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder38
	)
	default String reminder38Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder38Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder38
	)
	default String reminder38Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder38Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder38
	)
	default int reminder38Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder38RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder38
	)
	default String reminder38RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder38
	)
	default String reminder38NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder39
	)
	default String reminder39Times() { return ""; }

	@ConfigItem(
			keyName = "reminder39DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder39
	)
	default String reminder39DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder39Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder39
	)
	default String reminder39Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder39Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder39
	)
	default String reminder39Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder39Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder39
	)
	default String reminder39Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder39Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder39
	)
	default int reminder39Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder39RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder39
	)
	default String reminder39RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder39
	)
	default String reminder39NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder40
	)
	default String reminder40Times() { return ""; }

	@ConfigItem(
			keyName = "reminder40DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder40
	)
	default String reminder40DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder40Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder40
	)
	default String reminder40Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder40Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder40
	)
	default String reminder40Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder40Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder40
	)
	default String reminder40Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder40Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder40
	)
	default int reminder40Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder40RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder40
	)
	default String reminder40RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder40
	)
	default String reminder40NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder41
	)
	default String reminder41Times() { return ""; }

	@ConfigItem(
			keyName = "reminder41DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder41
	)
	default String reminder41DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder41Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder41
	)
	default String reminder41Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder41Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder41
	)
	default String reminder41Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder41Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder41
	)
	default String reminder41Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder41Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder41
	)
	default int reminder41Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder41RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder41
	)
	default String reminder41RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder41
	)
	default String reminder41NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder42
	)
	default String reminder42Times() { return ""; }

	@ConfigItem(
			keyName = "reminder42DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder42
	)
	default String reminder42DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder42Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder42
	)
	default String reminder42Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder42Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder42
	)
	default String reminder42Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder42Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder42
	)
	default String reminder42Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder42Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder42
	)
	default int reminder42Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder42RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder42
	)
	default String reminder42RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder42
	)
	default String reminder42NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder43
	)
	default String reminder43Times() { return ""; }

	@ConfigItem(
			keyName = "reminder43DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder43
	)
	default String reminder43DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder43Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder43
	)
	default String reminder43Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder43Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder43
	)
	default String reminder43Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder43Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder43
	)
	default String reminder43Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder43Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder43
	)
	default int reminder43Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder43RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder43
	)
	default String reminder43RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder43
	)
	default String reminder43NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder44
	)
	default String reminder44Times() { return ""; }

	@ConfigItem(
			keyName = "reminder44DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder44
	)
	default String reminder44DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder44Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder44
	)
	default String reminder44Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder44Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder44
	)
	default String reminder44Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder44Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder44
	)
	default String reminder44Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder44Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder44
	)
	default int reminder44Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder44RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder44
	)
	default String reminder44RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder44
	)
	default String reminder44NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder45
	)
	default String reminder45Times() { return ""; }

	@ConfigItem(
			keyName = "reminder45DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder45
	)
	default String reminder45DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder45Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder45
	)
	default String reminder45Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder45Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder45
	)
	default String reminder45Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder45Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder45
	)
	default String reminder45Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder45Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder45
	)
	default int reminder45Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder45RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder45
	)
	default String reminder45RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder45
	)
	default String reminder45NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder46
	)
	default String reminder46Times() { return ""; }

	@ConfigItem(
			keyName = "reminder46DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder46
	)
	default String reminder46DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder46Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder46
	)
	default String reminder46Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder46Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder46
	)
	default String reminder46Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder46Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder46
	)
	default String reminder46Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder46Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder46
	)
	default int reminder46Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder46RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder46
	)
	default String reminder46RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder46
	)
	default String reminder46NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder47
	)
	default String reminder47Times() { return ""; }

	@ConfigItem(
			keyName = "reminder47DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder47
	)
	default String reminder47DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder47Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder47
	)
	default String reminder47Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder47Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder47
	)
	default String reminder47Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder47Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder47
	)
	default String reminder47Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder47Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder47
	)
	default int reminder47Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder47RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder47
	)
	default String reminder47RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder47
	)
	default String reminder47NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder48
	)
	default String reminder48Times() { return ""; }

	@ConfigItem(
			keyName = "reminder48DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder48
	)
	default String reminder48DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder48Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder48
	)
	default String reminder48Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder48Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder48
	)
	default String reminder48Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder48Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder48
	)
	default String reminder48Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder48Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder48
	)
	default int reminder48Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder48RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder48
	)
	default String reminder48RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder48
	)
	default String reminder48NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder49
	)
	default String reminder49Times() { return ""; }

	@ConfigItem(
			keyName = "reminder49DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder49
	)
	default String reminder49DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder49Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder49
	)
	default String reminder49Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder49Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder49
	)
	default String reminder49Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder49Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder49
	)
	default String reminder49Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder49Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder49
	)
	default int reminder49Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder49RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder49
	)
	default String reminder49RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder49
	)
	default String reminder49NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder50
	)
	default String reminder50Times() { return ""; }

	@ConfigItem(
			keyName = "reminder50DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder50
	)
	default String reminder50DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder50Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder50
	)
	default String reminder50Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder50Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder50
	)
	default String reminder50Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder50Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder50
	)
	default String reminder50Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder50Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder50
	)
	default int reminder50Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder50RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder50
	)
	default String reminder50RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder50
	)
	default String reminder50NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder51
	)
	default String reminder51Times() { return ""; }

	@ConfigItem(
			keyName = "reminder51DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder51
	)
	default String reminder51DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder51Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder51
	)
	default String reminder51Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder51Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder51
	)
	default String reminder51Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder51Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder51
	)
	default String reminder51Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder51Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder51
	)
	default int reminder51Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder51RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder51
	)
	default String reminder51RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder51
	)
	default String reminder51NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder52
	)
	default String reminder52Times() { return ""; }

	@ConfigItem(
			keyName = "reminder52DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder52
	)
	default String reminder52DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder52Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder52
	)
	default String reminder52Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder52Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder52
	)
	default String reminder52Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder52Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder52
	)
	default String reminder52Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder52Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder52
	)
	default int reminder52Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder52RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder52
	)
	default String reminder52RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder52
	)
	default String reminder52NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder53
	)
	default String reminder53Times() { return ""; }

	@ConfigItem(
			keyName = "reminder53DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder53
	)
	default String reminder53DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder53Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder53
	)
	default String reminder53Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder53Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder53
	)
	default String reminder53Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder53Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder53
	)
	default String reminder53Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder53Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder53
	)
	default int reminder53Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder53RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder53
	)
	default String reminder53RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder53
	)
	default String reminder53NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder54
	)
	default String reminder54Times() { return ""; }

	@ConfigItem(
			keyName = "reminder54DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder54
	)
	default String reminder54DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder54Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder54
	)
	default String reminder54Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder54Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder54
	)
	default String reminder54Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder54Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder54
	)
	default String reminder54Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder54Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder54
	)
	default int reminder54Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder54RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder54
	)
	default String reminder54RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder54
	)
	default String reminder54NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder55
	)
	default String reminder55Times() { return ""; }

	@ConfigItem(
			keyName = "reminder55DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder55
	)
	default String reminder55DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder55Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder55
	)
	default String reminder55Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder55Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder55
	)
	default String reminder55Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder55Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder55
	)
	default String reminder55Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder55Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder55
	)
	default int reminder55Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder55RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder55
	)
	default String reminder55RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder55
	)
	default String reminder55NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder56
	)
	default String reminder56Times() { return ""; }

	@ConfigItem(
			keyName = "reminder56DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder56
	)
	default String reminder56DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder56Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder56
	)
	default String reminder56Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder56Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder56
	)
	default String reminder56Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder56Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder56
	)
	default String reminder56Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder56Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder56
	)
	default int reminder56Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder56RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder56
	)
	default String reminder56RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder56
	)
	default String reminder56NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder57
	)
	default String reminder57Times() { return ""; }

	@ConfigItem(
			keyName = "reminder57DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder57
	)
	default String reminder57DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder57Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder57
	)
	default String reminder57Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder57Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder57
	)
	default String reminder57Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder57Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder57
	)
	default String reminder57Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder57Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder57
	)
	default int reminder57Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder57RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder57
	)
	default String reminder57RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder57
	)
	default String reminder57NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder58
	)
	default String reminder58Times() { return ""; }

	@ConfigItem(
			keyName = "reminder58DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder58
	)
	default String reminder58DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder58Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder58
	)
	default String reminder58Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder58Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder58
	)
	default String reminder58Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder58Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder58
	)
	default String reminder58Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder58Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder58
	)
	default int reminder58Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder58RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder58
	)
	default String reminder58RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder58
	)
	default String reminder58NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder59
	)
	default String reminder59Times() { return ""; }

	@ConfigItem(
			keyName = "reminder59DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder59
	)
	default String reminder59DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder59Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder59
	)
	default String reminder59Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder59Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder59
	)
	default String reminder59Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder59Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder59
	)
	default String reminder59Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder59Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder59
	)
	default int reminder59Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder59RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder59
	)
	default String reminder59RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder59
	)
	default String reminder59NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder60
	)
	default String reminder60Times() { return ""; }

	@ConfigItem(
			keyName = "reminder60DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder60
	)
	default String reminder60DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder60Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder60
	)
	default String reminder60Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder60Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder60
	)
	default String reminder60Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder60Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder60
	)
	default String reminder60Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder60Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder60
	)
	default int reminder60Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder60RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder60
	)
	default String reminder60RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder60
	)
	default String reminder60NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder61
	)
	default String reminder61Times() { return ""; }

	@ConfigItem(
			keyName = "reminder61DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder61
	)
	default String reminder61DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder61Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder61
	)
	default String reminder61Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder61Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder61
	)
	default String reminder61Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder61Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder61
	)
	default String reminder61Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder61Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder61
	)
	default int reminder61Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder61RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder61
	)
	default String reminder61RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder61
	)
	default String reminder61NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder62
	)
	default String reminder62Times() { return ""; }

	@ConfigItem(
			keyName = "reminder62DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder62
	)
	default String reminder62DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder62Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder62
	)
	default String reminder62Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder62Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder62
	)
	default String reminder62Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder62Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder62
	)
	default String reminder62Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder62Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder62
	)
	default int reminder62Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder62RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder62
	)
	default String reminder62RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder62
	)
	default String reminder62NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder63
	)
	default String reminder63Times() { return ""; }

	@ConfigItem(
			keyName = "reminder63DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder63
	)
	default String reminder63DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder63Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder63
	)
	default String reminder63Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder63Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder63
	)
	default String reminder63Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder63Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder63
	)
	default String reminder63Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder63Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder63
	)
	default int reminder63Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder63RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder63
	)
	default String reminder63RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder63
	)
	default String reminder63NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder64
	)
	default String reminder64Times() { return ""; }

	@ConfigItem(
			keyName = "reminder64DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder64
	)
	default String reminder64DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder64Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder64
	)
	default String reminder64Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder64Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder64
	)
	default String reminder64Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder64Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder64
	)
	default String reminder64Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder64Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder64
	)
	default int reminder64Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder64RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder64
	)
	default String reminder64RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder64
	)
	default String reminder64NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder65
	)
	default String reminder65Times() { return ""; }

	@ConfigItem(
			keyName = "reminder65DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder65
	)
	default String reminder65DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder65Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder65
	)
	default String reminder65Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder65Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder65
	)
	default String reminder65Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder65Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder65
	)
	default String reminder65Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder65Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder65
	)
	default int reminder65Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder65RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder65
	)
	default String reminder65RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder65
	)
	default String reminder65NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder66
	)
	default String reminder66Times() { return ""; }

	@ConfigItem(
			keyName = "reminder66DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder66
	)
	default String reminder66DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder66Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder66
	)
	default String reminder66Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder66Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder66
	)
	default String reminder66Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder66Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder66
	)
	default String reminder66Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder66Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder66
	)
	default int reminder66Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder66RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder66
	)
	default String reminder66RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder66
	)
	default String reminder66NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder67
	)
	default String reminder67Times() { return ""; }

	@ConfigItem(
			keyName = "reminder67DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder67
	)
	default String reminder67DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder67Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder67
	)
	default String reminder67Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder67Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder67
	)
	default String reminder67Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder67Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder67
	)
	default String reminder67Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder67Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder67
	)
	default int reminder67Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder67RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder67
	)
	default String reminder67RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder67
	)
	default String reminder67NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder68
	)
	default String reminder68Times() { return ""; }

	@ConfigItem(
			keyName = "reminder68DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder68
	)
	default String reminder68DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder68Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder68
	)
	default String reminder68Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder68Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder68
	)
	default String reminder68Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder68Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder68
	)
	default String reminder68Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder68Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder68
	)
	default int reminder68Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder68RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder68
	)
	default String reminder68RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder68
	)
	default String reminder68NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder69
	)
	default String reminder69Times() { return ""; }

	@ConfigItem(
			keyName = "reminder69DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder69
	)
	default String reminder69DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder69Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder69
	)
	default String reminder69Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder69Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder69
	)
	default String reminder69Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder69Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder69
	)
	default String reminder69Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder69Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder69
	)
	default int reminder69Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder69RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder69
	)
	default String reminder69RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder69
	)
	default String reminder69NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder70
	)
	default String reminder70Times() { return ""; }

	@ConfigItem(
			keyName = "reminder70DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder70
	)
	default String reminder70DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder70Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder70
	)
	default String reminder70Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder70Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder70
	)
	default String reminder70Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder70Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder70
	)
	default String reminder70Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder70Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder70
	)
	default int reminder70Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder70RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder70
	)
	default String reminder70RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder70
	)
	default String reminder70NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder71
	)
	default String reminder71Times() { return ""; }

	@ConfigItem(
			keyName = "reminder71DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder71
	)
	default String reminder71DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder71Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder71
	)
	default String reminder71Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder71Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder71
	)
	default String reminder71Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder71Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder71
	)
	default String reminder71Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder71Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder71
	)
	default int reminder71Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder71RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder71
	)
	default String reminder71RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder71
	)
	default String reminder71NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder72
	)
	default String reminder72Times() { return ""; }

	@ConfigItem(
			keyName = "reminder72DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder72
	)
	default String reminder72DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder72Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder72
	)
	default String reminder72Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder72Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder72
	)
	default String reminder72Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder72Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder72
	)
	default String reminder72Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder72Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder72
	)
	default int reminder72Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder72RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder72
	)
	default String reminder72RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder72
	)
	default String reminder72NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder73
	)
	default String reminder73Times() { return ""; }

	@ConfigItem(
			keyName = "reminder73DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder73
	)
	default String reminder73DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder73Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder73
	)
	default String reminder73Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder73Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder73
	)
	default String reminder73Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder73Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder73
	)
	default String reminder73Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder73Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder73
	)
	default int reminder73Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder73RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder73
	)
	default String reminder73RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder73
	)
	default String reminder73NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder74
	)
	default String reminder74Times() { return ""; }

	@ConfigItem(
			keyName = "reminder74DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder74
	)
	default String reminder74DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder74Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder74
	)
	default String reminder74Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder74Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder74
	)
	default String reminder74Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder74Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder74
	)
	default String reminder74Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder74Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder74
	)
	default int reminder74Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder74RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder74
	)
	default String reminder74RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder74
	)
	default String reminder74NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder75
	)
	default String reminder75Times() { return ""; }

	@ConfigItem(
			keyName = "reminder75DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder75
	)
	default String reminder75DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder75Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder75
	)
	default String reminder75Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder75Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder75
	)
	default String reminder75Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder75Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder75
	)
	default String reminder75Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder75Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder75
	)
	default int reminder75Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder75RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder75
	)
	default String reminder75RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder75
	)
	default String reminder75NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder76
	)
	default String reminder76Times() { return ""; }

	@ConfigItem(
			keyName = "reminder76DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder76
	)
	default String reminder76DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder76Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder76
	)
	default String reminder76Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder76Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder76
	)
	default String reminder76Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder76Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder76
	)
	default String reminder76Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder76Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder76
	)
	default int reminder76Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder76RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder76
	)
	default String reminder76RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder76
	)
	default String reminder76NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder77
	)
	default String reminder77Times() { return ""; }

	@ConfigItem(
			keyName = "reminder77DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder77
	)
	default String reminder77DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder77Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder77
	)
	default String reminder77Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder77Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder77
	)
	default String reminder77Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder77Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder77
	)
	default String reminder77Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder77Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder77
	)
	default int reminder77Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder77RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder77
	)
	default String reminder77RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder77
	)
	default String reminder77NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder78
	)
	default String reminder78Times() { return ""; }

	@ConfigItem(
			keyName = "reminder78DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder78
	)
	default String reminder78DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder78Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder78
	)
	default String reminder78Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder78Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder78
	)
	default String reminder78Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder78Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder78
	)
	default String reminder78Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder78Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder78
	)
	default int reminder78Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder78RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder78
	)
	default String reminder78RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder78
	)
	default String reminder78NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder79
	)
	default String reminder79Times() { return ""; }

	@ConfigItem(
			keyName = "reminder79DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder79
	)
	default String reminder79DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder79Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder79
	)
	default String reminder79Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder79Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder79
	)
	default String reminder79Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder79Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder79
	)
	default String reminder79Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder79Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder79
	)
	default int reminder79Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder79RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder79
	)
	default String reminder79RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder79
	)
	default String reminder79NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder80
	)
	default String reminder80Times() { return ""; }

	@ConfigItem(
			keyName = "reminder80DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder80
	)
	default String reminder80DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder80Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder80
	)
	default String reminder80Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder80Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder80
	)
	default String reminder80Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder80Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder80
	)
	default String reminder80Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder80Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder80
	)
	default int reminder80Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder80RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder80
	)
	default String reminder80RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder80
	)
	default String reminder80NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder81
	)
	default String reminder81Times() { return ""; }

	@ConfigItem(
			keyName = "reminder81DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder81
	)
	default String reminder81DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder81Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder81
	)
	default String reminder81Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder81Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder81
	)
	default String reminder81Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder81Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder81
	)
	default String reminder81Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder81Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder81
	)
	default int reminder81Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder81RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder81
	)
	default String reminder81RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder81
	)
	default String reminder81NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder82
	)
	default String reminder82Times() { return ""; }

	@ConfigItem(
			keyName = "reminder82DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder82
	)
	default String reminder82DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder82Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder82
	)
	default String reminder82Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder82Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder82
	)
	default String reminder82Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder82Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder82
	)
	default String reminder82Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder82Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder82
	)
	default int reminder82Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder82RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder82
	)
	default String reminder82RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder82
	)
	default String reminder82NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder83
	)
	default String reminder83Times() { return ""; }

	@ConfigItem(
			keyName = "reminder83DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder83
	)
	default String reminder83DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder83Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder83
	)
	default String reminder83Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder83Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder83
	)
	default String reminder83Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder83Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder83
	)
	default String reminder83Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder83Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder83
	)
	default int reminder83Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder83RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder83
	)
	default String reminder83RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder83
	)
	default String reminder83NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder84
	)
	default String reminder84Times() { return ""; }

	@ConfigItem(
			keyName = "reminder84DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder84
	)
	default String reminder84DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder84Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder84
	)
	default String reminder84Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder84Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder84
	)
	default String reminder84Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder84Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder84
	)
	default String reminder84Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder84Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder84
	)
	default int reminder84Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder84RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder84
	)
	default String reminder84RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder84
	)
	default String reminder84NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder85
	)
	default String reminder85Times() { return ""; }

	@ConfigItem(
			keyName = "reminder85DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder85
	)
	default String reminder85DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder85Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder85
	)
	default String reminder85Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder85Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder85
	)
	default String reminder85Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder85Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder85
	)
	default String reminder85Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder85Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder85
	)
	default int reminder85Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder85RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder85
	)
	default String reminder85RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder85
	)
	default String reminder85NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder86
	)
	default String reminder86Times() { return ""; }

	@ConfigItem(
			keyName = "reminder86DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder86
	)
	default String reminder86DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder86Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder86
	)
	default String reminder86Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder86Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder86
	)
	default String reminder86Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder86Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder86
	)
	default String reminder86Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder86Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder86
	)
	default int reminder86Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder86RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder86
	)
	default String reminder86RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder86
	)
	default String reminder86NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder87
	)
	default String reminder87Times() { return ""; }

	@ConfigItem(
			keyName = "reminder87DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder87
	)
	default String reminder87DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder87Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder87
	)
	default String reminder87Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder87Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder87
	)
	default String reminder87Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder87Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder87
	)
	default String reminder87Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder87Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder87
	)
	default int reminder87Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder87RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder87
	)
	default String reminder87RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder87
	)
	default String reminder87NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder88
	)
	default String reminder88Times() { return ""; }

	@ConfigItem(
			keyName = "reminder88DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder88
	)
	default String reminder88DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder88Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder88
	)
	default String reminder88Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder88Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder88
	)
	default String reminder88Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder88Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder88
	)
	default String reminder88Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder88Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder88
	)
	default int reminder88Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder88RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder88
	)
	default String reminder88RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder88
	)
	default String reminder88NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder89
	)
	default String reminder89Times() { return ""; }

	@ConfigItem(
			keyName = "reminder89DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder89
	)
	default String reminder89DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder89Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder89
	)
	default String reminder89Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder89Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder89
	)
	default String reminder89Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder89Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder89
	)
	default String reminder89Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder89Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder89
	)
	default int reminder89Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder89RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder89
	)
	default String reminder89RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder89
	)
	default String reminder89NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder90
	)
	default String reminder90Times() { return ""; }

	@ConfigItem(
			keyName = "reminder90DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder90
	)
	default String reminder90DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder90Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder90
	)
	default String reminder90Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder90Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder90
	)
	default String reminder90Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder90Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder90
	)
	default String reminder90Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder90Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder90
	)
	default int reminder90Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder90RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder90
	)
	default String reminder90RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder90
	)
	default String reminder90NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder91
	)
	default String reminder91Times() { return ""; }

	@ConfigItem(
			keyName = "reminder91DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder91
	)
	default String reminder91DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder91Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder91
	)
	default String reminder91Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder91Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder91
	)
	default String reminder91Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder91Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder91
	)
	default String reminder91Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder91Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder91
	)
	default int reminder91Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder91RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder91
	)
	default String reminder91RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder91
	)
	default String reminder91NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder92
	)
	default String reminder92Times() { return ""; }

	@ConfigItem(
			keyName = "reminder92DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder92
	)
	default String reminder92DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder92Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder92
	)
	default String reminder92Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder92Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder92
	)
	default String reminder92Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder92Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder92
	)
	default String reminder92Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder92Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder92
	)
	default int reminder92Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder92RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder92
	)
	default String reminder92RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder92
	)
	default String reminder92NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder93
	)
	default String reminder93Times() { return ""; }

	@ConfigItem(
			keyName = "reminder93DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder93
	)
	default String reminder93DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder93Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder93
	)
	default String reminder93Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder93Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder93
	)
	default String reminder93Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder93Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder93
	)
	default String reminder93Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder93Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder93
	)
	default int reminder93Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder93RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder93
	)
	default String reminder93RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder93
	)
	default String reminder93NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder94
	)
	default String reminder94Times() { return ""; }

	@ConfigItem(
			keyName = "reminder94DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder94
	)
	default String reminder94DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder94Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder94
	)
	default String reminder94Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder94Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder94
	)
	default String reminder94Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder94Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder94
	)
	default String reminder94Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder94Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder94
	)
	default int reminder94Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder94RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder94
	)
	default String reminder94RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder94
	)
	default String reminder94NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder95
	)
	default String reminder95Times() { return ""; }

	@ConfigItem(
			keyName = "reminder95DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder95
	)
	default String reminder95DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder95Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder95
	)
	default String reminder95Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder95Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder95
	)
	default String reminder95Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder95Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder95
	)
	default String reminder95Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder95Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder95
	)
	default int reminder95Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder95RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder95
	)
	default String reminder95RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder95
	)
	default String reminder95NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder96
	)
	default String reminder96Times() { return ""; }

	@ConfigItem(
			keyName = "reminder96DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder96
	)
	default String reminder96DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder96Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder96
	)
	default String reminder96Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder96Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder96
	)
	default String reminder96Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder96Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder96
	)
	default String reminder96Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder96Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder96
	)
	default int reminder96Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder96RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder96
	)
	default String reminder96RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder96
	)
	default String reminder96NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder97
	)
	default String reminder97Times() { return ""; }

	@ConfigItem(
			keyName = "reminder97DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder97
	)
	default String reminder97DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder97Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder97
	)
	default String reminder97Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder97Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder97
	)
	default String reminder97Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder97Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder97
	)
	default String reminder97Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder97Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder97
	)
	default int reminder97Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder97RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder97
	)
	default String reminder97RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder97
	)
	default String reminder97NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder98
	)
	default String reminder98Times() { return ""; }

	@ConfigItem(
			keyName = "reminder98DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder98
	)
	default String reminder98DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder98Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder98
	)
	default String reminder98Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder98Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder98
	)
	default String reminder98Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder98Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder98
	)
	default String reminder98Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder98Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder98
	)
	default int reminder98Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder98RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder98
	)
	default String reminder98RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder98
	)
	default String reminder98NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder99
	)
	default String reminder99Times() { return ""; }

	@ConfigItem(
			keyName = "reminder99DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder99
	)
	default String reminder99DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder99Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder99
	)
	default String reminder99Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder99Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder99
	)
	default String reminder99Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder99Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder99
	)
	default String reminder99Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder99Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder99
	)
	default int reminder99Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder99RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder99
	)
	default String reminder99RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder99
	)
	default String reminder99NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99ItemIds",
			position = 17,
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
			position = 18,
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
			position = 30,
			name = "Times of Day",
			description = "Configures what times reminder is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = reminder100
	)
	default String reminder100Times() { return ""; }

	@ConfigItem(
			keyName = "reminder100DaysOfWeek",
			position = 31,
			name = "Days of Week",
			description = "Configures what days of week reminder is shown, e.g. Mon, Thu (comma separated).",
			section = reminder100
	)
	default String reminder100DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "reminder100Datess",
			position = 32,
			name = "Calendar Dates",
			description = "Configures what dates reminder is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = reminder100
	)
	default String reminder100Dates() { return ""; }

	@ConfigItem(
			keyName = "reminder100Coordinates",
			position = 12,
			name = "Near Coordinates",
			description = "Configures coordinates where reminder is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = reminder100
	)
	default String reminder100Coordinates() { return ""; }

	@ConfigItem(
			keyName = "reminder100Geofences",
			position = 14,
			name = "Inside Geofences",
			description = "Configures geofences where reminder is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = reminder100
	)
	default String reminder100Geofences() { return ""; }

	@ConfigItem(
			keyName = "reminder100Radius",
			position = 13,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates reminder is shown.",
			section = reminder100
	)
	default int reminder100Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder100RegionId",
			position = 15,
			name = "Inside Regions",
			description = "Configures region ids when reminder is shown (comma separated).",
			section = reminder100
	)
	default String reminder100RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100NpcIds",
			position = 16,
			name = "Npcs Spawned",
			description = "Configures the npc ids when spawned reminder is shown (comma separated).",
			section = reminder100
	)
	default String reminder100NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100ItemIds",
			position = 17,
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
			position = 18,
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
}