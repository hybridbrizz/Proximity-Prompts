package com.ericversteeg;

import com.ericversteeg.config.AnchorType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup(RemindersConfig.GROUP)
public interface RemindersConfig extends Config
{
	String GROUP = "reminders_2";

	@ConfigItem(
			position = 1,
			keyName = "anchorType",
			name = "Anchor",
			description = "Configure anchor."
	)
	default AnchorType anchorType() {
		return AnchorType.TOP_RIGHT;
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
			keyName = "listIds",
			name = "List Ids",
			description = "Configures whether or not to list location, region, npcs, and item ids."
	)
	default boolean listIds() {
		return false;
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
			name = "Enabled",
			description = "Configures whether or not reminder #1 is enabled.",
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
			keyName = "reminder1Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder1
	)
	default String reminder1Time() { return ""; }

	@ConfigItem(
			keyName = "reminder1Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder1
	)
	default boolean reminder1Monday() { return false; }

	@ConfigItem(
			keyName = "reminder1Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder1
	)
	default boolean reminder1Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder1Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder1
	)
	default boolean reminder1Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder1Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder1
	)
	default boolean reminder1Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder1Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder1
	)
	default boolean reminder1Friday() { return false; }

	@ConfigItem(
			keyName = "reminder1Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder1
	)
	default boolean reminder1Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder1Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder1
	)
	default boolean reminder1Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder1Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder1
	)
	default String reminder1Date() { return ""; }

	@ConfigItem(
			keyName = "reminder1LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder1
	)
	default int reminder1LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder1LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder1
	)
	default int reminder1LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder1Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder1
	)
	default int reminder1Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder1RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder1
	)
	default int reminder1RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder1NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder1
	)
	default String reminder1NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder1
	)
	default String reminder1ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder1Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder1
	)
	default int reminder1Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder1Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder1
	)
	default int reminder1Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #2 is enabled.",
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
			keyName = "reminder2Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder2
	)
	default String reminder2Time() { return ""; }

	@ConfigItem(
			keyName = "reminder2Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder2
	)
	default boolean reminder2Monday() { return false; }

	@ConfigItem(
			keyName = "reminder2Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder2
	)
	default boolean reminder2Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder2Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder2
	)
	default boolean reminder2Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder2Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder2
	)
	default boolean reminder2Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder2Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder2
	)
	default boolean reminder2Friday() { return false; }

	@ConfigItem(
			keyName = "reminder2Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder2
	)
	default boolean reminder2Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder2Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder2
	)
	default boolean reminder2Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder2Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder2
	)
	default String reminder2Date() { return ""; }

	@ConfigItem(
			keyName = "reminder2LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder2
	)
	default int reminder2LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder2LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder2
	)
	default int reminder2LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder2Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder2
	)
	default int reminder2Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder2RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder2
	)
	default int reminder2RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder2NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder2
	)
	default String reminder2NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder2
	)
	default String reminder2ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder2Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder2
	)
	default int reminder2Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder2Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder2
	)
	default int reminder2Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #3 is enabled.",
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
			keyName = "reminder3Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder3
	)
	default String reminder3Time() { return ""; }

	@ConfigItem(
			keyName = "reminder3Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder3
	)
	default boolean reminder3Monday() { return false; }

	@ConfigItem(
			keyName = "reminder3Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder3
	)
	default boolean reminder3Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder3Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder3
	)
	default boolean reminder3Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder3Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder3
	)
	default boolean reminder3Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder3Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder3
	)
	default boolean reminder3Friday() { return false; }

	@ConfigItem(
			keyName = "reminder3Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder3
	)
	default boolean reminder3Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder3Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder3
	)
	default boolean reminder3Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder3Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder3
	)
	default String reminder3Date() { return ""; }

	@ConfigItem(
			keyName = "reminder3LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder3
	)
	default int reminder3LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder3LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder3
	)
	default int reminder3LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder3Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder3
	)
	default int reminder3Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder3RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder3
	)
	default int reminder3RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder3NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder3
	)
	default String reminder3NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder3
	)
	default String reminder3ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder3Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder3
	)
	default int reminder3Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder3Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder3
	)
	default int reminder3Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #4 is enabled.",
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
			keyName = "reminder4Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder4
	)
	default String reminder4Time() { return ""; }

	@ConfigItem(
			keyName = "reminder4Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder4
	)
	default boolean reminder4Monday() { return false; }

	@ConfigItem(
			keyName = "reminder4Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder4
	)
	default boolean reminder4Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder4Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder4
	)
	default boolean reminder4Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder4Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder4
	)
	default boolean reminder4Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder4Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder4
	)
	default boolean reminder4Friday() { return false; }

	@ConfigItem(
			keyName = "reminder4Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder4
	)
	default boolean reminder4Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder4Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder4
	)
	default boolean reminder4Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder4Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder4
	)
	default String reminder4Date() { return ""; }

	@ConfigItem(
			keyName = "reminder4LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder4
	)
	default int reminder4LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder4LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder4
	)
	default int reminder4LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder4Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder4
	)
	default int reminder4Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder4RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder4
	)
	default int reminder4RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder4NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder4
	)
	default String reminder4NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder4
	)
	default String reminder4ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder4Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder4
	)
	default int reminder4Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder4Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder4
	)
	default int reminder4Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #5 is enabled.",
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
			keyName = "reminder5Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder5
	)
	default String reminder5Time() { return ""; }

	@ConfigItem(
			keyName = "reminder5Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder5
	)
	default boolean reminder5Monday() { return false; }

	@ConfigItem(
			keyName = "reminder5Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder5
	)
	default boolean reminder5Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder5Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder5
	)
	default boolean reminder5Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder5Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder5
	)
	default boolean reminder5Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder5Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder5
	)
	default boolean reminder5Friday() { return false; }

	@ConfigItem(
			keyName = "reminder5Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder5
	)
	default boolean reminder5Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder5Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder5
	)
	default boolean reminder5Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder5Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder5
	)
	default String reminder5Date() { return ""; }

	@ConfigItem(
			keyName = "reminder5LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder5
	)
	default int reminder5LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder5LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder5
	)
	default int reminder5LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder5Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder5
	)
	default int reminder5Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder5RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder5
	)
	default int reminder5RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder5NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder5
	)
	default String reminder5NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder5
	)
	default String reminder5ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder5Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder5
	)
	default int reminder5Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder5Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder5
	)
	default int reminder5Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #6 is enabled.",
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
			keyName = "reminder6Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder6
	)
	default String reminder6Time() { return ""; }

	@ConfigItem(
			keyName = "reminder6Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder6
	)
	default boolean reminder6Monday() { return false; }

	@ConfigItem(
			keyName = "reminder6Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder6
	)
	default boolean reminder6Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder6Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder6
	)
	default boolean reminder6Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder6Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder6
	)
	default boolean reminder6Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder6Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder6
	)
	default boolean reminder6Friday() { return false; }

	@ConfigItem(
			keyName = "reminder6Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder6
	)
	default boolean reminder6Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder6Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder6
	)
	default boolean reminder6Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder6Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder6
	)
	default String reminder6Date() { return ""; }

	@ConfigItem(
			keyName = "reminder6LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder6
	)
	default int reminder6LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder6LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder6
	)
	default int reminder6LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder6Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder6
	)
	default int reminder6Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder6RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder6
	)
	default int reminder6RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder6NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder6
	)
	default String reminder6NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder6
	)
	default String reminder6ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder6Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder6
	)
	default int reminder6Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder6Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder6
	)
	default int reminder6Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #7 is enabled.",
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
			keyName = "reminder7Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder7
	)
	default String reminder7Time() { return ""; }

	@ConfigItem(
			keyName = "reminder7Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder7
	)
	default boolean reminder7Monday() { return false; }

	@ConfigItem(
			keyName = "reminder7Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder7
	)
	default boolean reminder7Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder7Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder7
	)
	default boolean reminder7Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder7Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder7
	)
	default boolean reminder7Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder7Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder7
	)
	default boolean reminder7Friday() { return false; }

	@ConfigItem(
			keyName = "reminder7Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder7
	)
	default boolean reminder7Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder7Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder7
	)
	default boolean reminder7Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder7Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder7
	)
	default String reminder7Date() { return ""; }

	@ConfigItem(
			keyName = "reminder7LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder7
	)
	default int reminder7LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder7LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder7
	)
	default int reminder7LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder7Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder7
	)
	default int reminder7Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder7RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder7
	)
	default int reminder7RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder7NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder7
	)
	default String reminder7NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder7
	)
	default String reminder7ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder7Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder7
	)
	default int reminder7Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder7Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder7
	)
	default int reminder7Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #8 is enabled.",
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
			keyName = "reminder8Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder8
	)
	default String reminder8Time() { return ""; }

	@ConfigItem(
			keyName = "reminder8Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder8
	)
	default boolean reminder8Monday() { return false; }

	@ConfigItem(
			keyName = "reminder8Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder8
	)
	default boolean reminder8Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder8Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder8
	)
	default boolean reminder8Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder8Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder8
	)
	default boolean reminder8Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder8Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder8
	)
	default boolean reminder8Friday() { return false; }

	@ConfigItem(
			keyName = "reminder8Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder8
	)
	default boolean reminder8Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder8Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder8
	)
	default boolean reminder8Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder8Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder8
	)
	default String reminder8Date() { return ""; }

	@ConfigItem(
			keyName = "reminder8LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder8
	)
	default int reminder8LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder8LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder8
	)
	default int reminder8LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder8Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder8
	)
	default int reminder8Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder8RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder8
	)
	default int reminder8RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder8NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder8
	)
	default String reminder8NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder8
	)
	default String reminder8ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder8Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder8
	)
	default int reminder8Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder8Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder8
	)
	default int reminder8Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #9 is enabled.",
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
			keyName = "reminder9Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder9
	)
	default String reminder9Time() { return ""; }

	@ConfigItem(
			keyName = "reminder9Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder9
	)
	default boolean reminder9Monday() { return false; }

	@ConfigItem(
			keyName = "reminder9Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder9
	)
	default boolean reminder9Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder9Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder9
	)
	default boolean reminder9Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder9Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder9
	)
	default boolean reminder9Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder9Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder9
	)
	default boolean reminder9Friday() { return false; }

	@ConfigItem(
			keyName = "reminder9Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder9
	)
	default boolean reminder9Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder9Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder9
	)
	default boolean reminder9Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder9Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder9
	)
	default String reminder9Date() { return ""; }

	@ConfigItem(
			keyName = "reminder9LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder9
	)
	default int reminder9LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder9LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder9
	)
	default int reminder9LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder9Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder9
	)
	default int reminder9Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder9RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder9
	)
	default int reminder9RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder9NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder9
	)
	default String reminder9NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder9
	)
	default String reminder9ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder9Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder9
	)
	default int reminder9Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder9Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder9
	)
	default int reminder9Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #10 is enabled.",
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
			keyName = "reminder10Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder10
	)
	default String reminder10Time() { return ""; }

	@ConfigItem(
			keyName = "reminder10Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder10
	)
	default boolean reminder10Monday() { return false; }

	@ConfigItem(
			keyName = "reminder10Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder10
	)
	default boolean reminder10Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder10Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder10
	)
	default boolean reminder10Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder10Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder10
	)
	default boolean reminder10Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder10Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder10
	)
	default boolean reminder10Friday() { return false; }

	@ConfigItem(
			keyName = "reminder10Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder10
	)
	default boolean reminder10Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder10Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder10
	)
	default boolean reminder10Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder10Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder10
	)
	default String reminder10Date() { return ""; }

	@ConfigItem(
			keyName = "reminder10LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder10
	)
	default int reminder10LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder10LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder10
	)
	default int reminder10LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder10Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder10
	)
	default int reminder10Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder10RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder10
	)
	default int reminder10RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder10NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder10
	)
	default String reminder10NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder10
	)
	default String reminder10ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder10Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder10
	)
	default int reminder10Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder10Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder10
	)
	default int reminder10Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #11 is enabled.",
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
			keyName = "reminder11Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder11
	)
	default String reminder11Time() { return ""; }

	@ConfigItem(
			keyName = "reminder11Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder11
	)
	default boolean reminder11Monday() { return false; }

	@ConfigItem(
			keyName = "reminder11Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder11
	)
	default boolean reminder11Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder11Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder11
	)
	default boolean reminder11Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder11Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder11
	)
	default boolean reminder11Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder11Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder11
	)
	default boolean reminder11Friday() { return false; }

	@ConfigItem(
			keyName = "reminder11Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder11
	)
	default boolean reminder11Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder11Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder11
	)
	default boolean reminder11Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder11Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder11
	)
	default String reminder11Date() { return ""; }

	@ConfigItem(
			keyName = "reminder11LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder11
	)
	default int reminder11LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder11LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder11
	)
	default int reminder11LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder11Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder11
	)
	default int reminder11Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder11RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder11
	)
	default int reminder11RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder11NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder11
	)
	default String reminder11NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder11
	)
	default String reminder11ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder11Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder11
	)
	default int reminder11Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder11Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder11
	)
	default int reminder11Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #12 is enabled.",
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
			keyName = "reminder12Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder12
	)
	default String reminder12Time() { return ""; }

	@ConfigItem(
			keyName = "reminder12Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder12
	)
	default boolean reminder12Monday() { return false; }

	@ConfigItem(
			keyName = "reminder12Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder12
	)
	default boolean reminder12Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder12Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder12
	)
	default boolean reminder12Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder12Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder12
	)
	default boolean reminder12Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder12Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder12
	)
	default boolean reminder12Friday() { return false; }

	@ConfigItem(
			keyName = "reminder12Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder12
	)
	default boolean reminder12Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder12Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder12
	)
	default boolean reminder12Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder12Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder12
	)
	default String reminder12Date() { return ""; }

	@ConfigItem(
			keyName = "reminder12LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder12
	)
	default int reminder12LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder12LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder12
	)
	default int reminder12LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder12Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder12
	)
	default int reminder12Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder12RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder12
	)
	default int reminder12RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder12NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder12
	)
	default String reminder12NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder12
	)
	default String reminder12ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder12Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder12
	)
	default int reminder12Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder12Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder12
	)
	default int reminder12Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #13 is enabled.",
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
			keyName = "reminder13Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder13
	)
	default String reminder13Time() { return ""; }

	@ConfigItem(
			keyName = "reminder13Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder13
	)
	default boolean reminder13Monday() { return false; }

	@ConfigItem(
			keyName = "reminder13Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder13
	)
	default boolean reminder13Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder13Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder13
	)
	default boolean reminder13Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder13Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder13
	)
	default boolean reminder13Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder13Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder13
	)
	default boolean reminder13Friday() { return false; }

	@ConfigItem(
			keyName = "reminder13Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder13
	)
	default boolean reminder13Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder13Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder13
	)
	default boolean reminder13Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder13Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder13
	)
	default String reminder13Date() { return ""; }

	@ConfigItem(
			keyName = "reminder13LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder13
	)
	default int reminder13LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder13LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder13
	)
	default int reminder13LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder13Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder13
	)
	default int reminder13Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder13RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder13
	)
	default int reminder13RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder13NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder13
	)
	default String reminder13NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder13
	)
	default String reminder13ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder13Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder13
	)
	default int reminder13Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder13Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder13
	)
	default int reminder13Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #14 is enabled.",
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
			keyName = "reminder14Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder14
	)
	default String reminder14Time() { return ""; }

	@ConfigItem(
			keyName = "reminder14Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder14
	)
	default boolean reminder14Monday() { return false; }

	@ConfigItem(
			keyName = "reminder14Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder14
	)
	default boolean reminder14Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder14Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder14
	)
	default boolean reminder14Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder14Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder14
	)
	default boolean reminder14Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder14Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder14
	)
	default boolean reminder14Friday() { return false; }

	@ConfigItem(
			keyName = "reminder14Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder14
	)
	default boolean reminder14Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder14Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder14
	)
	default boolean reminder14Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder14Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder14
	)
	default String reminder14Date() { return ""; }

	@ConfigItem(
			keyName = "reminder14LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder14
	)
	default int reminder14LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder14LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder14
	)
	default int reminder14LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder14Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder14
	)
	default int reminder14Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder14RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder14
	)
	default int reminder14RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder14NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder14
	)
	default String reminder14NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder14
	)
	default String reminder14ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder14Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder14
	)
	default int reminder14Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder14Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder14
	)
	default int reminder14Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #15 is enabled.",
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
			keyName = "reminder15Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder15
	)
	default String reminder15Time() { return ""; }

	@ConfigItem(
			keyName = "reminder15Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder15
	)
	default boolean reminder15Monday() { return false; }

	@ConfigItem(
			keyName = "reminder15Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder15
	)
	default boolean reminder15Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder15Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder15
	)
	default boolean reminder15Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder15Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder15
	)
	default boolean reminder15Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder15Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder15
	)
	default boolean reminder15Friday() { return false; }

	@ConfigItem(
			keyName = "reminder15Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder15
	)
	default boolean reminder15Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder15Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder15
	)
	default boolean reminder15Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder15Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder15
	)
	default String reminder15Date() { return ""; }

	@ConfigItem(
			keyName = "reminder15LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder15
	)
	default int reminder15LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder15LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder15
	)
	default int reminder15LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder15Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder15
	)
	default int reminder15Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder15RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder15
	)
	default int reminder15RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder15NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder15
	)
	default String reminder15NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder15
	)
	default String reminder15ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder15Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder15
	)
	default int reminder15Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder15Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder15
	)
	default int reminder15Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #16 is enabled.",
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
			keyName = "reminder16Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder16
	)
	default String reminder16Time() { return ""; }

	@ConfigItem(
			keyName = "reminder16Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder16
	)
	default boolean reminder16Monday() { return false; }

	@ConfigItem(
			keyName = "reminder16Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder16
	)
	default boolean reminder16Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder16Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder16
	)
	default boolean reminder16Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder16Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder16
	)
	default boolean reminder16Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder16Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder16
	)
	default boolean reminder16Friday() { return false; }

	@ConfigItem(
			keyName = "reminder16Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder16
	)
	default boolean reminder16Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder16Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder16
	)
	default boolean reminder16Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder16Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder16
	)
	default String reminder16Date() { return ""; }

	@ConfigItem(
			keyName = "reminder16LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder16
	)
	default int reminder16LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder16LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder16
	)
	default int reminder16LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder16Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder16
	)
	default int reminder16Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder16RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder16
	)
	default int reminder16RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder16NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder16
	)
	default String reminder16NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder16
	)
	default String reminder16ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder16Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder16
	)
	default int reminder16Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder16Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder16
	)
	default int reminder16Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #17 is enabled.",
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
			keyName = "reminder17Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder17
	)
	default String reminder17Time() { return ""; }

	@ConfigItem(
			keyName = "reminder17Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder17
	)
	default boolean reminder17Monday() { return false; }

	@ConfigItem(
			keyName = "reminder17Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder17
	)
	default boolean reminder17Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder17Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder17
	)
	default boolean reminder17Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder17Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder17
	)
	default boolean reminder17Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder17Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder17
	)
	default boolean reminder17Friday() { return false; }

	@ConfigItem(
			keyName = "reminder17Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder17
	)
	default boolean reminder17Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder17Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder17
	)
	default boolean reminder17Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder17Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder17
	)
	default String reminder17Date() { return ""; }

	@ConfigItem(
			keyName = "reminder17LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder17
	)
	default int reminder17LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder17LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder17
	)
	default int reminder17LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder17Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder17
	)
	default int reminder17Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder17RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder17
	)
	default int reminder17RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder17NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder17
	)
	default String reminder17NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder17
	)
	default String reminder17ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder17Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder17
	)
	default int reminder17Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder17Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder17
	)
	default int reminder17Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #18 is enabled.",
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
			keyName = "reminder18Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder18
	)
	default String reminder18Time() { return ""; }

	@ConfigItem(
			keyName = "reminder18Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder18
	)
	default boolean reminder18Monday() { return false; }

	@ConfigItem(
			keyName = "reminder18Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder18
	)
	default boolean reminder18Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder18Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder18
	)
	default boolean reminder18Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder18Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder18
	)
	default boolean reminder18Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder18Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder18
	)
	default boolean reminder18Friday() { return false; }

	@ConfigItem(
			keyName = "reminder18Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder18
	)
	default boolean reminder18Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder18Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder18
	)
	default boolean reminder18Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder18Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder18
	)
	default String reminder18Date() { return ""; }

	@ConfigItem(
			keyName = "reminder18LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder18
	)
	default int reminder18LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder18LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder18
	)
	default int reminder18LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder18Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder18
	)
	default int reminder18Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder18RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder18
	)
	default int reminder18RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder18NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder18
	)
	default String reminder18NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder18
	)
	default String reminder18ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder18Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder18
	)
	default int reminder18Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder18Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder18
	)
	default int reminder18Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #19 is enabled.",
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
			keyName = "reminder19Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder19
	)
	default String reminder19Time() { return ""; }

	@ConfigItem(
			keyName = "reminder19Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder19
	)
	default boolean reminder19Monday() { return false; }

	@ConfigItem(
			keyName = "reminder19Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder19
	)
	default boolean reminder19Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder19Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder19
	)
	default boolean reminder19Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder19Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder19
	)
	default boolean reminder19Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder19Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder19
	)
	default boolean reminder19Friday() { return false; }

	@ConfigItem(
			keyName = "reminder19Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder19
	)
	default boolean reminder19Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder19Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder19
	)
	default boolean reminder19Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder19Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder19
	)
	default String reminder19Date() { return ""; }

	@ConfigItem(
			keyName = "reminder19LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder19
	)
	default int reminder19LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder19LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder19
	)
	default int reminder19LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder19Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder19
	)
	default int reminder19Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder19RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder19
	)
	default int reminder19RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder19NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder19
	)
	default String reminder19NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder19
	)
	default String reminder19ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder19Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder19
	)
	default int reminder19Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder19Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder19
	)
	default int reminder19Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #20 is enabled.",
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
			keyName = "reminder20Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder20
	)
	default String reminder20Time() { return ""; }

	@ConfigItem(
			keyName = "reminder20Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder20
	)
	default boolean reminder20Monday() { return false; }

	@ConfigItem(
			keyName = "reminder20Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder20
	)
	default boolean reminder20Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder20Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder20
	)
	default boolean reminder20Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder20Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder20
	)
	default boolean reminder20Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder20Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder20
	)
	default boolean reminder20Friday() { return false; }

	@ConfigItem(
			keyName = "reminder20Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder20
	)
	default boolean reminder20Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder20Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder20
	)
	default boolean reminder20Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder20Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder20
	)
	default String reminder20Date() { return ""; }

	@ConfigItem(
			keyName = "reminder20LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder20
	)
	default int reminder20LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder20LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder20
	)
	default int reminder20LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder20Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder20
	)
	default int reminder20Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder20RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder20
	)
	default int reminder20RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder20NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder20
	)
	default String reminder20NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder20
	)
	default String reminder20ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder20Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder20
	)
	default int reminder20Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder20Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder20
	)
	default int reminder20Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #21 is enabled.",
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
			keyName = "reminder21Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder21
	)
	default String reminder21Time() { return ""; }

	@ConfigItem(
			keyName = "reminder21Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder21
	)
	default boolean reminder21Monday() { return false; }

	@ConfigItem(
			keyName = "reminder21Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder21
	)
	default boolean reminder21Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder21Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder21
	)
	default boolean reminder21Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder21Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder21
	)
	default boolean reminder21Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder21Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder21
	)
	default boolean reminder21Friday() { return false; }

	@ConfigItem(
			keyName = "reminder21Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder21
	)
	default boolean reminder21Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder21Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder21
	)
	default boolean reminder21Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder21Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder21
	)
	default String reminder21Date() { return ""; }

	@ConfigItem(
			keyName = "reminder21LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder21
	)
	default int reminder21LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder21LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder21
	)
	default int reminder21LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder21Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder21
	)
	default int reminder21Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder21RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder21
	)
	default int reminder21RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder21NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder21
	)
	default String reminder21NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder21
	)
	default String reminder21ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder21Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder21
	)
	default int reminder21Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder21Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder21
	)
	default int reminder21Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #22 is enabled.",
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
			keyName = "reminder22Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder22
	)
	default String reminder22Time() { return ""; }

	@ConfigItem(
			keyName = "reminder22Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder22
	)
	default boolean reminder22Monday() { return false; }

	@ConfigItem(
			keyName = "reminder22Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder22
	)
	default boolean reminder22Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder22Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder22
	)
	default boolean reminder22Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder22Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder22
	)
	default boolean reminder22Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder22Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder22
	)
	default boolean reminder22Friday() { return false; }

	@ConfigItem(
			keyName = "reminder22Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder22
	)
	default boolean reminder22Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder22Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder22
	)
	default boolean reminder22Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder22Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder22
	)
	default String reminder22Date() { return ""; }

	@ConfigItem(
			keyName = "reminder22LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder22
	)
	default int reminder22LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder22LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder22
	)
	default int reminder22LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder22Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder22
	)
	default int reminder22Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder22RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder22
	)
	default int reminder22RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder22NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder22
	)
	default String reminder22NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder22
	)
	default String reminder22ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder22Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder22
	)
	default int reminder22Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder22Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder22
	)
	default int reminder22Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #23 is enabled.",
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
			keyName = "reminder23Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder23
	)
	default String reminder23Time() { return ""; }

	@ConfigItem(
			keyName = "reminder23Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder23
	)
	default boolean reminder23Monday() { return false; }

	@ConfigItem(
			keyName = "reminder23Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder23
	)
	default boolean reminder23Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder23Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder23
	)
	default boolean reminder23Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder23Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder23
	)
	default boolean reminder23Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder23Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder23
	)
	default boolean reminder23Friday() { return false; }

	@ConfigItem(
			keyName = "reminder23Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder23
	)
	default boolean reminder23Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder23Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder23
	)
	default boolean reminder23Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder23Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder23
	)
	default String reminder23Date() { return ""; }

	@ConfigItem(
			keyName = "reminder23LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder23
	)
	default int reminder23LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder23LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder23
	)
	default int reminder23LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder23Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder23
	)
	default int reminder23Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder23RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder23
	)
	default int reminder23RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder23NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder23
	)
	default String reminder23NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder23
	)
	default String reminder23ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder23Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder23
	)
	default int reminder23Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder23Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder23
	)
	default int reminder23Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #24 is enabled.",
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
			keyName = "reminder24Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder24
	)
	default String reminder24Time() { return ""; }

	@ConfigItem(
			keyName = "reminder24Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder24
	)
	default boolean reminder24Monday() { return false; }

	@ConfigItem(
			keyName = "reminder24Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder24
	)
	default boolean reminder24Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder24Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder24
	)
	default boolean reminder24Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder24Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder24
	)
	default boolean reminder24Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder24Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder24
	)
	default boolean reminder24Friday() { return false; }

	@ConfigItem(
			keyName = "reminder24Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder24
	)
	default boolean reminder24Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder24Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder24
	)
	default boolean reminder24Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder24Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder24
	)
	default String reminder24Date() { return ""; }

	@ConfigItem(
			keyName = "reminder24LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder24
	)
	default int reminder24LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder24LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder24
	)
	default int reminder24LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder24Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder24
	)
	default int reminder24Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder24RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder24
	)
	default int reminder24RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder24NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder24
	)
	default String reminder24NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder24
	)
	default String reminder24ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder24Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder24
	)
	default int reminder24Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder24Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder24
	)
	default int reminder24Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #25 is enabled.",
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
			keyName = "reminder25Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder25
	)
	default String reminder25Time() { return ""; }

	@ConfigItem(
			keyName = "reminder25Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder25
	)
	default boolean reminder25Monday() { return false; }

	@ConfigItem(
			keyName = "reminder25Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder25
	)
	default boolean reminder25Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder25Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder25
	)
	default boolean reminder25Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder25Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder25
	)
	default boolean reminder25Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder25Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder25
	)
	default boolean reminder25Friday() { return false; }

	@ConfigItem(
			keyName = "reminder25Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder25
	)
	default boolean reminder25Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder25Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder25
	)
	default boolean reminder25Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder25Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder25
	)
	default String reminder25Date() { return ""; }

	@ConfigItem(
			keyName = "reminder25LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder25
	)
	default int reminder25LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder25LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder25
	)
	default int reminder25LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder25Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder25
	)
	default int reminder25Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder25RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder25
	)
	default int reminder25RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder25NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder25
	)
	default String reminder25NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder25
	)
	default String reminder25ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder25Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder25
	)
	default int reminder25Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder25Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder25
	)
	default int reminder25Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #26 is enabled.",
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
			keyName = "reminder26Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder26
	)
	default String reminder26Time() { return ""; }

	@ConfigItem(
			keyName = "reminder26Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder26
	)
	default boolean reminder26Monday() { return false; }

	@ConfigItem(
			keyName = "reminder26Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder26
	)
	default boolean reminder26Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder26Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder26
	)
	default boolean reminder26Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder26Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder26
	)
	default boolean reminder26Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder26Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder26
	)
	default boolean reminder26Friday() { return false; }

	@ConfigItem(
			keyName = "reminder26Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder26
	)
	default boolean reminder26Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder26Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder26
	)
	default boolean reminder26Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder26Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder26
	)
	default String reminder26Date() { return ""; }

	@ConfigItem(
			keyName = "reminder26LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder26
	)
	default int reminder26LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder26LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder26
	)
	default int reminder26LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder26Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder26
	)
	default int reminder26Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder26RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder26
	)
	default int reminder26RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder26NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder26
	)
	default String reminder26NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder26
	)
	default String reminder26ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder26Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder26
	)
	default int reminder26Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder26Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder26
	)
	default int reminder26Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #27 is enabled.",
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
			keyName = "reminder27Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder27
	)
	default String reminder27Time() { return ""; }

	@ConfigItem(
			keyName = "reminder27Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder27
	)
	default boolean reminder27Monday() { return false; }

	@ConfigItem(
			keyName = "reminder27Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder27
	)
	default boolean reminder27Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder27Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder27
	)
	default boolean reminder27Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder27Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder27
	)
	default boolean reminder27Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder27Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder27
	)
	default boolean reminder27Friday() { return false; }

	@ConfigItem(
			keyName = "reminder27Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder27
	)
	default boolean reminder27Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder27Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder27
	)
	default boolean reminder27Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder27Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder27
	)
	default String reminder27Date() { return ""; }

	@ConfigItem(
			keyName = "reminder27LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder27
	)
	default int reminder27LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder27LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder27
	)
	default int reminder27LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder27Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder27
	)
	default int reminder27Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder27RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder27
	)
	default int reminder27RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder27NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder27
	)
	default String reminder27NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder27
	)
	default String reminder27ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder27Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder27
	)
	default int reminder27Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder27Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder27
	)
	default int reminder27Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #28 is enabled.",
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
			keyName = "reminder28Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder28
	)
	default String reminder28Time() { return ""; }

	@ConfigItem(
			keyName = "reminder28Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder28
	)
	default boolean reminder28Monday() { return false; }

	@ConfigItem(
			keyName = "reminder28Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder28
	)
	default boolean reminder28Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder28Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder28
	)
	default boolean reminder28Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder28Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder28
	)
	default boolean reminder28Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder28Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder28
	)
	default boolean reminder28Friday() { return false; }

	@ConfigItem(
			keyName = "reminder28Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder28
	)
	default boolean reminder28Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder28Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder28
	)
	default boolean reminder28Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder28Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder28
	)
	default String reminder28Date() { return ""; }

	@ConfigItem(
			keyName = "reminder28LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder28
	)
	default int reminder28LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder28LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder28
	)
	default int reminder28LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder28Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder28
	)
	default int reminder28Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder28RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder28
	)
	default int reminder28RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder28NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder28
	)
	default String reminder28NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder28
	)
	default String reminder28ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder28Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder28
	)
	default int reminder28Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder28Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder28
	)
	default int reminder28Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #29 is enabled.",
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
			keyName = "reminder29Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder29
	)
	default String reminder29Time() { return ""; }

	@ConfigItem(
			keyName = "reminder29Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder29
	)
	default boolean reminder29Monday() { return false; }

	@ConfigItem(
			keyName = "reminder29Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder29
	)
	default boolean reminder29Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder29Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder29
	)
	default boolean reminder29Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder29Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder29
	)
	default boolean reminder29Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder29Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder29
	)
	default boolean reminder29Friday() { return false; }

	@ConfigItem(
			keyName = "reminder29Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder29
	)
	default boolean reminder29Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder29Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder29
	)
	default boolean reminder29Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder29Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder29
	)
	default String reminder29Date() { return ""; }

	@ConfigItem(
			keyName = "reminder29LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder29
	)
	default int reminder29LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder29LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder29
	)
	default int reminder29LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder29Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder29
	)
	default int reminder29Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder29RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder29
	)
	default int reminder29RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder29NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder29
	)
	default String reminder29NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder29
	)
	default String reminder29ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder29Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder29
	)
	default int reminder29Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder29Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder29
	)
	default int reminder29Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #30 is enabled.",
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
			keyName = "reminder30Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder30
	)
	default String reminder30Time() { return ""; }

	@ConfigItem(
			keyName = "reminder30Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder30
	)
	default boolean reminder30Monday() { return false; }

	@ConfigItem(
			keyName = "reminder30Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder30
	)
	default boolean reminder30Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder30Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder30
	)
	default boolean reminder30Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder30Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder30
	)
	default boolean reminder30Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder30Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder30
	)
	default boolean reminder30Friday() { return false; }

	@ConfigItem(
			keyName = "reminder30Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder30
	)
	default boolean reminder30Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder30Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder30
	)
	default boolean reminder30Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder30Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder30
	)
	default String reminder30Date() { return ""; }

	@ConfigItem(
			keyName = "reminder30LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder30
	)
	default int reminder30LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder30LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder30
	)
	default int reminder30LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder30Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder30
	)
	default int reminder30Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder30RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder30
	)
	default int reminder30RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder30NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder30
	)
	default String reminder30NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder30
	)
	default String reminder30ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder30Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder30
	)
	default int reminder30Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder30Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder30
	)
	default int reminder30Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #31 is enabled.",
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
			keyName = "reminder31Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder31
	)
	default String reminder31Time() { return ""; }

	@ConfigItem(
			keyName = "reminder31Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder31
	)
	default boolean reminder31Monday() { return false; }

	@ConfigItem(
			keyName = "reminder31Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder31
	)
	default boolean reminder31Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder31Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder31
	)
	default boolean reminder31Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder31Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder31
	)
	default boolean reminder31Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder31Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder31
	)
	default boolean reminder31Friday() { return false; }

	@ConfigItem(
			keyName = "reminder31Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder31
	)
	default boolean reminder31Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder31Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder31
	)
	default boolean reminder31Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder31Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder31
	)
	default String reminder31Date() { return ""; }

	@ConfigItem(
			keyName = "reminder31LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder31
	)
	default int reminder31LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder31LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder31
	)
	default int reminder31LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder31Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder31
	)
	default int reminder31Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder31RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder31
	)
	default int reminder31RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder31NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder31
	)
	default String reminder31NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder31
	)
	default String reminder31ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder31Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder31
	)
	default int reminder31Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder31Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder31
	)
	default int reminder31Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #32 is enabled.",
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
			keyName = "reminder32Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder32
	)
	default String reminder32Time() { return ""; }

	@ConfigItem(
			keyName = "reminder32Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder32
	)
	default boolean reminder32Monday() { return false; }

	@ConfigItem(
			keyName = "reminder32Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder32
	)
	default boolean reminder32Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder32Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder32
	)
	default boolean reminder32Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder32Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder32
	)
	default boolean reminder32Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder32Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder32
	)
	default boolean reminder32Friday() { return false; }

	@ConfigItem(
			keyName = "reminder32Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder32
	)
	default boolean reminder32Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder32Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder32
	)
	default boolean reminder32Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder32Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder32
	)
	default String reminder32Date() { return ""; }

	@ConfigItem(
			keyName = "reminder32LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder32
	)
	default int reminder32LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder32LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder32
	)
	default int reminder32LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder32Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder32
	)
	default int reminder32Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder32RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder32
	)
	default int reminder32RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder32NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder32
	)
	default String reminder32NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder32
	)
	default String reminder32ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder32Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder32
	)
	default int reminder32Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder32Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder32
	)
	default int reminder32Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #33 is enabled.",
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
			keyName = "reminder33Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder33
	)
	default String reminder33Time() { return ""; }

	@ConfigItem(
			keyName = "reminder33Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder33
	)
	default boolean reminder33Monday() { return false; }

	@ConfigItem(
			keyName = "reminder33Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder33
	)
	default boolean reminder33Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder33Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder33
	)
	default boolean reminder33Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder33Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder33
	)
	default boolean reminder33Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder33Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder33
	)
	default boolean reminder33Friday() { return false; }

	@ConfigItem(
			keyName = "reminder33Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder33
	)
	default boolean reminder33Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder33Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder33
	)
	default boolean reminder33Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder33Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder33
	)
	default String reminder33Date() { return ""; }

	@ConfigItem(
			keyName = "reminder33LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder33
	)
	default int reminder33LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder33LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder33
	)
	default int reminder33LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder33Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder33
	)
	default int reminder33Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder33RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder33
	)
	default int reminder33RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder33NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder33
	)
	default String reminder33NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder33
	)
	default String reminder33ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder33Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder33
	)
	default int reminder33Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder33Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder33
	)
	default int reminder33Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #34 is enabled.",
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
			keyName = "reminder34Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder34
	)
	default String reminder34Time() { return ""; }

	@ConfigItem(
			keyName = "reminder34Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder34
	)
	default boolean reminder34Monday() { return false; }

	@ConfigItem(
			keyName = "reminder34Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder34
	)
	default boolean reminder34Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder34Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder34
	)
	default boolean reminder34Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder34Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder34
	)
	default boolean reminder34Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder34Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder34
	)
	default boolean reminder34Friday() { return false; }

	@ConfigItem(
			keyName = "reminder34Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder34
	)
	default boolean reminder34Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder34Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder34
	)
	default boolean reminder34Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder34Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder34
	)
	default String reminder34Date() { return ""; }

	@ConfigItem(
			keyName = "reminder34LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder34
	)
	default int reminder34LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder34LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder34
	)
	default int reminder34LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder34Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder34
	)
	default int reminder34Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder34RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder34
	)
	default int reminder34RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder34NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder34
	)
	default String reminder34NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder34
	)
	default String reminder34ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder34Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder34
	)
	default int reminder34Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder34Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder34
	)
	default int reminder34Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #35 is enabled.",
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
			keyName = "reminder35Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder35
	)
	default String reminder35Time() { return ""; }

	@ConfigItem(
			keyName = "reminder35Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder35
	)
	default boolean reminder35Monday() { return false; }

	@ConfigItem(
			keyName = "reminder35Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder35
	)
	default boolean reminder35Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder35Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder35
	)
	default boolean reminder35Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder35Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder35
	)
	default boolean reminder35Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder35Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder35
	)
	default boolean reminder35Friday() { return false; }

	@ConfigItem(
			keyName = "reminder35Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder35
	)
	default boolean reminder35Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder35Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder35
	)
	default boolean reminder35Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder35Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder35
	)
	default String reminder35Date() { return ""; }

	@ConfigItem(
			keyName = "reminder35LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder35
	)
	default int reminder35LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder35LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder35
	)
	default int reminder35LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder35Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder35
	)
	default int reminder35Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder35RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder35
	)
	default int reminder35RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder35NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder35
	)
	default String reminder35NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder35
	)
	default String reminder35ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder35Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder35
	)
	default int reminder35Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder35Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder35
	)
	default int reminder35Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #36 is enabled.",
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
			keyName = "reminder36Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder36
	)
	default String reminder36Time() { return ""; }

	@ConfigItem(
			keyName = "reminder36Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder36
	)
	default boolean reminder36Monday() { return false; }

	@ConfigItem(
			keyName = "reminder36Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder36
	)
	default boolean reminder36Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder36Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder36
	)
	default boolean reminder36Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder36Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder36
	)
	default boolean reminder36Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder36Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder36
	)
	default boolean reminder36Friday() { return false; }

	@ConfigItem(
			keyName = "reminder36Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder36
	)
	default boolean reminder36Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder36Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder36
	)
	default boolean reminder36Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder36Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder36
	)
	default String reminder36Date() { return ""; }

	@ConfigItem(
			keyName = "reminder36LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder36
	)
	default int reminder36LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder36LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder36
	)
	default int reminder36LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder36Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder36
	)
	default int reminder36Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder36RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder36
	)
	default int reminder36RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder36NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder36
	)
	default String reminder36NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder36
	)
	default String reminder36ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder36Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder36
	)
	default int reminder36Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder36Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder36
	)
	default int reminder36Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #37 is enabled.",
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
			keyName = "reminder37Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder37
	)
	default String reminder37Time() { return ""; }

	@ConfigItem(
			keyName = "reminder37Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder37
	)
	default boolean reminder37Monday() { return false; }

	@ConfigItem(
			keyName = "reminder37Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder37
	)
	default boolean reminder37Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder37Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder37
	)
	default boolean reminder37Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder37Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder37
	)
	default boolean reminder37Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder37Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder37
	)
	default boolean reminder37Friday() { return false; }

	@ConfigItem(
			keyName = "reminder37Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder37
	)
	default boolean reminder37Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder37Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder37
	)
	default boolean reminder37Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder37Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder37
	)
	default String reminder37Date() { return ""; }

	@ConfigItem(
			keyName = "reminder37LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder37
	)
	default int reminder37LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder37LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder37
	)
	default int reminder37LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder37Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder37
	)
	default int reminder37Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder37RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder37
	)
	default int reminder37RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder37NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder37
	)
	default String reminder37NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder37
	)
	default String reminder37ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder37Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder37
	)
	default int reminder37Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder37Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder37
	)
	default int reminder37Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #38 is enabled.",
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
			keyName = "reminder38Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder38
	)
	default String reminder38Time() { return ""; }

	@ConfigItem(
			keyName = "reminder38Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder38
	)
	default boolean reminder38Monday() { return false; }

	@ConfigItem(
			keyName = "reminder38Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder38
	)
	default boolean reminder38Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder38Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder38
	)
	default boolean reminder38Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder38Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder38
	)
	default boolean reminder38Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder38Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder38
	)
	default boolean reminder38Friday() { return false; }

	@ConfigItem(
			keyName = "reminder38Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder38
	)
	default boolean reminder38Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder38Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder38
	)
	default boolean reminder38Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder38Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder38
	)
	default String reminder38Date() { return ""; }

	@ConfigItem(
			keyName = "reminder38LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder38
	)
	default int reminder38LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder38LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder38
	)
	default int reminder38LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder38Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder38
	)
	default int reminder38Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder38RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder38
	)
	default int reminder38RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder38NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder38
	)
	default String reminder38NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder38
	)
	default String reminder38ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder38Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder38
	)
	default int reminder38Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder38Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder38
	)
	default int reminder38Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #39 is enabled.",
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
			keyName = "reminder39Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder39
	)
	default String reminder39Time() { return ""; }

	@ConfigItem(
			keyName = "reminder39Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder39
	)
	default boolean reminder39Monday() { return false; }

	@ConfigItem(
			keyName = "reminder39Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder39
	)
	default boolean reminder39Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder39Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder39
	)
	default boolean reminder39Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder39Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder39
	)
	default boolean reminder39Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder39Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder39
	)
	default boolean reminder39Friday() { return false; }

	@ConfigItem(
			keyName = "reminder39Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder39
	)
	default boolean reminder39Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder39Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder39
	)
	default boolean reminder39Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder39Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder39
	)
	default String reminder39Date() { return ""; }

	@ConfigItem(
			keyName = "reminder39LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder39
	)
	default int reminder39LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder39LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder39
	)
	default int reminder39LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder39Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder39
	)
	default int reminder39Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder39RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder39
	)
	default int reminder39RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder39NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder39
	)
	default String reminder39NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder39
	)
	default String reminder39ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder39Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder39
	)
	default int reminder39Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder39Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder39
	)
	default int reminder39Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #40 is enabled.",
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
			keyName = "reminder40Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder40
	)
	default String reminder40Time() { return ""; }

	@ConfigItem(
			keyName = "reminder40Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder40
	)
	default boolean reminder40Monday() { return false; }

	@ConfigItem(
			keyName = "reminder40Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder40
	)
	default boolean reminder40Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder40Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder40
	)
	default boolean reminder40Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder40Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder40
	)
	default boolean reminder40Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder40Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder40
	)
	default boolean reminder40Friday() { return false; }

	@ConfigItem(
			keyName = "reminder40Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder40
	)
	default boolean reminder40Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder40Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder40
	)
	default boolean reminder40Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder40Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder40
	)
	default String reminder40Date() { return ""; }

	@ConfigItem(
			keyName = "reminder40LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder40
	)
	default int reminder40LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder40LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder40
	)
	default int reminder40LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder40Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder40
	)
	default int reminder40Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder40RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder40
	)
	default int reminder40RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder40NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder40
	)
	default String reminder40NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder40
	)
	default String reminder40ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder40Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder40
	)
	default int reminder40Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder40Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder40
	)
	default int reminder40Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #41 is enabled.",
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
			keyName = "reminder41Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder41
	)
	default String reminder41Time() { return ""; }

	@ConfigItem(
			keyName = "reminder41Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder41
	)
	default boolean reminder41Monday() { return false; }

	@ConfigItem(
			keyName = "reminder41Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder41
	)
	default boolean reminder41Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder41Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder41
	)
	default boolean reminder41Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder41Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder41
	)
	default boolean reminder41Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder41Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder41
	)
	default boolean reminder41Friday() { return false; }

	@ConfigItem(
			keyName = "reminder41Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder41
	)
	default boolean reminder41Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder41Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder41
	)
	default boolean reminder41Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder41Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder41
	)
	default String reminder41Date() { return ""; }

	@ConfigItem(
			keyName = "reminder41LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder41
	)
	default int reminder41LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder41LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder41
	)
	default int reminder41LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder41Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder41
	)
	default int reminder41Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder41RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder41
	)
	default int reminder41RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder41NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder41
	)
	default String reminder41NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder41
	)
	default String reminder41ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder41Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder41
	)
	default int reminder41Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder41Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder41
	)
	default int reminder41Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #42 is enabled.",
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
			keyName = "reminder42Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder42
	)
	default String reminder42Time() { return ""; }

	@ConfigItem(
			keyName = "reminder42Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder42
	)
	default boolean reminder42Monday() { return false; }

	@ConfigItem(
			keyName = "reminder42Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder42
	)
	default boolean reminder42Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder42Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder42
	)
	default boolean reminder42Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder42Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder42
	)
	default boolean reminder42Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder42Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder42
	)
	default boolean reminder42Friday() { return false; }

	@ConfigItem(
			keyName = "reminder42Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder42
	)
	default boolean reminder42Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder42Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder42
	)
	default boolean reminder42Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder42Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder42
	)
	default String reminder42Date() { return ""; }

	@ConfigItem(
			keyName = "reminder42LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder42
	)
	default int reminder42LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder42LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder42
	)
	default int reminder42LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder42Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder42
	)
	default int reminder42Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder42RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder42
	)
	default int reminder42RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder42NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder42
	)
	default String reminder42NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder42
	)
	default String reminder42ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder42Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder42
	)
	default int reminder42Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder42Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder42
	)
	default int reminder42Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #43 is enabled.",
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
			keyName = "reminder43Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder43
	)
	default String reminder43Time() { return ""; }

	@ConfigItem(
			keyName = "reminder43Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder43
	)
	default boolean reminder43Monday() { return false; }

	@ConfigItem(
			keyName = "reminder43Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder43
	)
	default boolean reminder43Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder43Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder43
	)
	default boolean reminder43Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder43Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder43
	)
	default boolean reminder43Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder43Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder43
	)
	default boolean reminder43Friday() { return false; }

	@ConfigItem(
			keyName = "reminder43Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder43
	)
	default boolean reminder43Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder43Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder43
	)
	default boolean reminder43Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder43Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder43
	)
	default String reminder43Date() { return ""; }

	@ConfigItem(
			keyName = "reminder43LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder43
	)
	default int reminder43LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder43LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder43
	)
	default int reminder43LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder43Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder43
	)
	default int reminder43Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder43RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder43
	)
	default int reminder43RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder43NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder43
	)
	default String reminder43NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder43
	)
	default String reminder43ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder43Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder43
	)
	default int reminder43Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder43Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder43
	)
	default int reminder43Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #44 is enabled.",
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
			keyName = "reminder44Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder44
	)
	default String reminder44Time() { return ""; }

	@ConfigItem(
			keyName = "reminder44Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder44
	)
	default boolean reminder44Monday() { return false; }

	@ConfigItem(
			keyName = "reminder44Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder44
	)
	default boolean reminder44Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder44Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder44
	)
	default boolean reminder44Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder44Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder44
	)
	default boolean reminder44Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder44Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder44
	)
	default boolean reminder44Friday() { return false; }

	@ConfigItem(
			keyName = "reminder44Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder44
	)
	default boolean reminder44Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder44Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder44
	)
	default boolean reminder44Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder44Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder44
	)
	default String reminder44Date() { return ""; }

	@ConfigItem(
			keyName = "reminder44LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder44
	)
	default int reminder44LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder44LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder44
	)
	default int reminder44LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder44Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder44
	)
	default int reminder44Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder44RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder44
	)
	default int reminder44RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder44NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder44
	)
	default String reminder44NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder44
	)
	default String reminder44ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder44Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder44
	)
	default int reminder44Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder44Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder44
	)
	default int reminder44Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #45 is enabled.",
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
			keyName = "reminder45Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder45
	)
	default String reminder45Time() { return ""; }

	@ConfigItem(
			keyName = "reminder45Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder45
	)
	default boolean reminder45Monday() { return false; }

	@ConfigItem(
			keyName = "reminder45Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder45
	)
	default boolean reminder45Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder45Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder45
	)
	default boolean reminder45Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder45Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder45
	)
	default boolean reminder45Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder45Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder45
	)
	default boolean reminder45Friday() { return false; }

	@ConfigItem(
			keyName = "reminder45Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder45
	)
	default boolean reminder45Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder45Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder45
	)
	default boolean reminder45Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder45Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder45
	)
	default String reminder45Date() { return ""; }

	@ConfigItem(
			keyName = "reminder45LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder45
	)
	default int reminder45LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder45LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder45
	)
	default int reminder45LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder45Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder45
	)
	default int reminder45Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder45RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder45
	)
	default int reminder45RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder45NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder45
	)
	default String reminder45NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder45
	)
	default String reminder45ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder45Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder45
	)
	default int reminder45Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder45Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder45
	)
	default int reminder45Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #46 is enabled.",
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
			keyName = "reminder46Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder46
	)
	default String reminder46Time() { return ""; }

	@ConfigItem(
			keyName = "reminder46Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder46
	)
	default boolean reminder46Monday() { return false; }

	@ConfigItem(
			keyName = "reminder46Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder46
	)
	default boolean reminder46Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder46Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder46
	)
	default boolean reminder46Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder46Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder46
	)
	default boolean reminder46Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder46Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder46
	)
	default boolean reminder46Friday() { return false; }

	@ConfigItem(
			keyName = "reminder46Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder46
	)
	default boolean reminder46Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder46Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder46
	)
	default boolean reminder46Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder46Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder46
	)
	default String reminder46Date() { return ""; }

	@ConfigItem(
			keyName = "reminder46LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder46
	)
	default int reminder46LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder46LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder46
	)
	default int reminder46LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder46Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder46
	)
	default int reminder46Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder46RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder46
	)
	default int reminder46RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder46NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder46
	)
	default String reminder46NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder46
	)
	default String reminder46ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder46Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder46
	)
	default int reminder46Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder46Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder46
	)
	default int reminder46Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #47 is enabled.",
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
			keyName = "reminder47Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder47
	)
	default String reminder47Time() { return ""; }

	@ConfigItem(
			keyName = "reminder47Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder47
	)
	default boolean reminder47Monday() { return false; }

	@ConfigItem(
			keyName = "reminder47Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder47
	)
	default boolean reminder47Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder47Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder47
	)
	default boolean reminder47Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder47Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder47
	)
	default boolean reminder47Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder47Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder47
	)
	default boolean reminder47Friday() { return false; }

	@ConfigItem(
			keyName = "reminder47Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder47
	)
	default boolean reminder47Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder47Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder47
	)
	default boolean reminder47Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder47Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder47
	)
	default String reminder47Date() { return ""; }

	@ConfigItem(
			keyName = "reminder47LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder47
	)
	default int reminder47LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder47LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder47
	)
	default int reminder47LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder47Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder47
	)
	default int reminder47Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder47RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder47
	)
	default int reminder47RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder47NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder47
	)
	default String reminder47NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder47
	)
	default String reminder47ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder47Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder47
	)
	default int reminder47Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder47Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder47
	)
	default int reminder47Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #48 is enabled.",
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
			keyName = "reminder48Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder48
	)
	default String reminder48Time() { return ""; }

	@ConfigItem(
			keyName = "reminder48Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder48
	)
	default boolean reminder48Monday() { return false; }

	@ConfigItem(
			keyName = "reminder48Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder48
	)
	default boolean reminder48Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder48Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder48
	)
	default boolean reminder48Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder48Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder48
	)
	default boolean reminder48Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder48Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder48
	)
	default boolean reminder48Friday() { return false; }

	@ConfigItem(
			keyName = "reminder48Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder48
	)
	default boolean reminder48Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder48Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder48
	)
	default boolean reminder48Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder48Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder48
	)
	default String reminder48Date() { return ""; }

	@ConfigItem(
			keyName = "reminder48LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder48
	)
	default int reminder48LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder48LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder48
	)
	default int reminder48LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder48Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder48
	)
	default int reminder48Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder48RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder48
	)
	default int reminder48RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder48NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder48
	)
	default String reminder48NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder48
	)
	default String reminder48ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder48Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder48
	)
	default int reminder48Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder48Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder48
	)
	default int reminder48Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #49 is enabled.",
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
			keyName = "reminder49Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder49
	)
	default String reminder49Time() { return ""; }

	@ConfigItem(
			keyName = "reminder49Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder49
	)
	default boolean reminder49Monday() { return false; }

	@ConfigItem(
			keyName = "reminder49Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder49
	)
	default boolean reminder49Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder49Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder49
	)
	default boolean reminder49Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder49Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder49
	)
	default boolean reminder49Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder49Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder49
	)
	default boolean reminder49Friday() { return false; }

	@ConfigItem(
			keyName = "reminder49Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder49
	)
	default boolean reminder49Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder49Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder49
	)
	default boolean reminder49Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder49Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder49
	)
	default String reminder49Date() { return ""; }

	@ConfigItem(
			keyName = "reminder49LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder49
	)
	default int reminder49LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder49LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder49
	)
	default int reminder49LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder49Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder49
	)
	default int reminder49Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder49RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder49
	)
	default int reminder49RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder49NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder49
	)
	default String reminder49NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder49
	)
	default String reminder49ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder49Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder49
	)
	default int reminder49Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder49Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder49
	)
	default int reminder49Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #50 is enabled.",
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
			keyName = "reminder50Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder50
	)
	default String reminder50Time() { return ""; }

	@ConfigItem(
			keyName = "reminder50Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder50
	)
	default boolean reminder50Monday() { return false; }

	@ConfigItem(
			keyName = "reminder50Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder50
	)
	default boolean reminder50Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder50Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder50
	)
	default boolean reminder50Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder50Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder50
	)
	default boolean reminder50Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder50Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder50
	)
	default boolean reminder50Friday() { return false; }

	@ConfigItem(
			keyName = "reminder50Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder50
	)
	default boolean reminder50Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder50Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder50
	)
	default boolean reminder50Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder50Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder50
	)
	default String reminder50Date() { return ""; }

	@ConfigItem(
			keyName = "reminder50LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder50
	)
	default int reminder50LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder50LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder50
	)
	default int reminder50LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder50Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder50
	)
	default int reminder50Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder50RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder50
	)
	default int reminder50RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder50NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder50
	)
	default String reminder50NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder50
	)
	default String reminder50ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder50Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder50
	)
	default int reminder50Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder50Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder50
	)
	default int reminder50Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #51 is enabled.",
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
			keyName = "reminder51Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder51
	)
	default String reminder51Time() { return ""; }

	@ConfigItem(
			keyName = "reminder51Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder51
	)
	default boolean reminder51Monday() { return false; }

	@ConfigItem(
			keyName = "reminder51Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder51
	)
	default boolean reminder51Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder51Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder51
	)
	default boolean reminder51Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder51Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder51
	)
	default boolean reminder51Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder51Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder51
	)
	default boolean reminder51Friday() { return false; }

	@ConfigItem(
			keyName = "reminder51Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder51
	)
	default boolean reminder51Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder51Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder51
	)
	default boolean reminder51Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder51Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder51
	)
	default String reminder51Date() { return ""; }

	@ConfigItem(
			keyName = "reminder51LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder51
	)
	default int reminder51LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder51LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder51
	)
	default int reminder51LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder51Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder51
	)
	default int reminder51Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder51RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder51
	)
	default int reminder51RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder51NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder51
	)
	default String reminder51NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder51
	)
	default String reminder51ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder51Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder51
	)
	default int reminder51Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder51Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder51
	)
	default int reminder51Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #52 is enabled.",
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
			keyName = "reminder52Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder52
	)
	default String reminder52Time() { return ""; }

	@ConfigItem(
			keyName = "reminder52Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder52
	)
	default boolean reminder52Monday() { return false; }

	@ConfigItem(
			keyName = "reminder52Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder52
	)
	default boolean reminder52Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder52Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder52
	)
	default boolean reminder52Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder52Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder52
	)
	default boolean reminder52Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder52Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder52
	)
	default boolean reminder52Friday() { return false; }

	@ConfigItem(
			keyName = "reminder52Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder52
	)
	default boolean reminder52Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder52Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder52
	)
	default boolean reminder52Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder52Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder52
	)
	default String reminder52Date() { return ""; }

	@ConfigItem(
			keyName = "reminder52LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder52
	)
	default int reminder52LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder52LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder52
	)
	default int reminder52LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder52Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder52
	)
	default int reminder52Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder52RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder52
	)
	default int reminder52RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder52NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder52
	)
	default String reminder52NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder52
	)
	default String reminder52ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder52Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder52
	)
	default int reminder52Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder52Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder52
	)
	default int reminder52Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #53 is enabled.",
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
			keyName = "reminder53Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder53
	)
	default String reminder53Time() { return ""; }

	@ConfigItem(
			keyName = "reminder53Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder53
	)
	default boolean reminder53Monday() { return false; }

	@ConfigItem(
			keyName = "reminder53Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder53
	)
	default boolean reminder53Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder53Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder53
	)
	default boolean reminder53Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder53Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder53
	)
	default boolean reminder53Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder53Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder53
	)
	default boolean reminder53Friday() { return false; }

	@ConfigItem(
			keyName = "reminder53Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder53
	)
	default boolean reminder53Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder53Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder53
	)
	default boolean reminder53Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder53Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder53
	)
	default String reminder53Date() { return ""; }

	@ConfigItem(
			keyName = "reminder53LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder53
	)
	default int reminder53LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder53LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder53
	)
	default int reminder53LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder53Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder53
	)
	default int reminder53Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder53RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder53
	)
	default int reminder53RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder53NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder53
	)
	default String reminder53NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder53
	)
	default String reminder53ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder53Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder53
	)
	default int reminder53Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder53Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder53
	)
	default int reminder53Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #54 is enabled.",
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
			keyName = "reminder54Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder54
	)
	default String reminder54Time() { return ""; }

	@ConfigItem(
			keyName = "reminder54Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder54
	)
	default boolean reminder54Monday() { return false; }

	@ConfigItem(
			keyName = "reminder54Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder54
	)
	default boolean reminder54Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder54Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder54
	)
	default boolean reminder54Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder54Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder54
	)
	default boolean reminder54Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder54Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder54
	)
	default boolean reminder54Friday() { return false; }

	@ConfigItem(
			keyName = "reminder54Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder54
	)
	default boolean reminder54Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder54Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder54
	)
	default boolean reminder54Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder54Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder54
	)
	default String reminder54Date() { return ""; }

	@ConfigItem(
			keyName = "reminder54LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder54
	)
	default int reminder54LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder54LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder54
	)
	default int reminder54LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder54Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder54
	)
	default int reminder54Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder54RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder54
	)
	default int reminder54RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder54NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder54
	)
	default String reminder54NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder54
	)
	default String reminder54ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder54Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder54
	)
	default int reminder54Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder54Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder54
	)
	default int reminder54Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #55 is enabled.",
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
			keyName = "reminder55Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder55
	)
	default String reminder55Time() { return ""; }

	@ConfigItem(
			keyName = "reminder55Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder55
	)
	default boolean reminder55Monday() { return false; }

	@ConfigItem(
			keyName = "reminder55Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder55
	)
	default boolean reminder55Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder55Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder55
	)
	default boolean reminder55Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder55Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder55
	)
	default boolean reminder55Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder55Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder55
	)
	default boolean reminder55Friday() { return false; }

	@ConfigItem(
			keyName = "reminder55Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder55
	)
	default boolean reminder55Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder55Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder55
	)
	default boolean reminder55Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder55Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder55
	)
	default String reminder55Date() { return ""; }

	@ConfigItem(
			keyName = "reminder55LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder55
	)
	default int reminder55LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder55LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder55
	)
	default int reminder55LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder55Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder55
	)
	default int reminder55Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder55RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder55
	)
	default int reminder55RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder55NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder55
	)
	default String reminder55NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder55
	)
	default String reminder55ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder55Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder55
	)
	default int reminder55Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder55Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder55
	)
	default int reminder55Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #56 is enabled.",
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
			keyName = "reminder56Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder56
	)
	default String reminder56Time() { return ""; }

	@ConfigItem(
			keyName = "reminder56Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder56
	)
	default boolean reminder56Monday() { return false; }

	@ConfigItem(
			keyName = "reminder56Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder56
	)
	default boolean reminder56Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder56Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder56
	)
	default boolean reminder56Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder56Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder56
	)
	default boolean reminder56Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder56Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder56
	)
	default boolean reminder56Friday() { return false; }

	@ConfigItem(
			keyName = "reminder56Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder56
	)
	default boolean reminder56Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder56Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder56
	)
	default boolean reminder56Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder56Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder56
	)
	default String reminder56Date() { return ""; }

	@ConfigItem(
			keyName = "reminder56LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder56
	)
	default int reminder56LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder56LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder56
	)
	default int reminder56LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder56Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder56
	)
	default int reminder56Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder56RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder56
	)
	default int reminder56RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder56NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder56
	)
	default String reminder56NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder56
	)
	default String reminder56ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder56Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder56
	)
	default int reminder56Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder56Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder56
	)
	default int reminder56Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #57 is enabled.",
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
			keyName = "reminder57Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder57
	)
	default String reminder57Time() { return ""; }

	@ConfigItem(
			keyName = "reminder57Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder57
	)
	default boolean reminder57Monday() { return false; }

	@ConfigItem(
			keyName = "reminder57Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder57
	)
	default boolean reminder57Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder57Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder57
	)
	default boolean reminder57Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder57Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder57
	)
	default boolean reminder57Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder57Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder57
	)
	default boolean reminder57Friday() { return false; }

	@ConfigItem(
			keyName = "reminder57Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder57
	)
	default boolean reminder57Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder57Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder57
	)
	default boolean reminder57Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder57Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder57
	)
	default String reminder57Date() { return ""; }

	@ConfigItem(
			keyName = "reminder57LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder57
	)
	default int reminder57LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder57LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder57
	)
	default int reminder57LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder57Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder57
	)
	default int reminder57Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder57RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder57
	)
	default int reminder57RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder57NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder57
	)
	default String reminder57NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder57
	)
	default String reminder57ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder57Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder57
	)
	default int reminder57Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder57Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder57
	)
	default int reminder57Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #58 is enabled.",
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
			keyName = "reminder58Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder58
	)
	default String reminder58Time() { return ""; }

	@ConfigItem(
			keyName = "reminder58Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder58
	)
	default boolean reminder58Monday() { return false; }

	@ConfigItem(
			keyName = "reminder58Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder58
	)
	default boolean reminder58Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder58Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder58
	)
	default boolean reminder58Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder58Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder58
	)
	default boolean reminder58Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder58Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder58
	)
	default boolean reminder58Friday() { return false; }

	@ConfigItem(
			keyName = "reminder58Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder58
	)
	default boolean reminder58Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder58Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder58
	)
	default boolean reminder58Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder58Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder58
	)
	default String reminder58Date() { return ""; }

	@ConfigItem(
			keyName = "reminder58LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder58
	)
	default int reminder58LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder58LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder58
	)
	default int reminder58LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder58Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder58
	)
	default int reminder58Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder58RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder58
	)
	default int reminder58RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder58NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder58
	)
	default String reminder58NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder58
	)
	default String reminder58ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder58Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder58
	)
	default int reminder58Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder58Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder58
	)
	default int reminder58Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #59 is enabled.",
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
			keyName = "reminder59Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder59
	)
	default String reminder59Time() { return ""; }

	@ConfigItem(
			keyName = "reminder59Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder59
	)
	default boolean reminder59Monday() { return false; }

	@ConfigItem(
			keyName = "reminder59Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder59
	)
	default boolean reminder59Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder59Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder59
	)
	default boolean reminder59Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder59Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder59
	)
	default boolean reminder59Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder59Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder59
	)
	default boolean reminder59Friday() { return false; }

	@ConfigItem(
			keyName = "reminder59Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder59
	)
	default boolean reminder59Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder59Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder59
	)
	default boolean reminder59Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder59Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder59
	)
	default String reminder59Date() { return ""; }

	@ConfigItem(
			keyName = "reminder59LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder59
	)
	default int reminder59LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder59LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder59
	)
	default int reminder59LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder59Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder59
	)
	default int reminder59Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder59RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder59
	)
	default int reminder59RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder59NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder59
	)
	default String reminder59NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder59
	)
	default String reminder59ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder59Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder59
	)
	default int reminder59Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder59Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder59
	)
	default int reminder59Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #60 is enabled.",
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
			keyName = "reminder60Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder60
	)
	default String reminder60Time() { return ""; }

	@ConfigItem(
			keyName = "reminder60Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder60
	)
	default boolean reminder60Monday() { return false; }

	@ConfigItem(
			keyName = "reminder60Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder60
	)
	default boolean reminder60Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder60Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder60
	)
	default boolean reminder60Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder60Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder60
	)
	default boolean reminder60Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder60Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder60
	)
	default boolean reminder60Friday() { return false; }

	@ConfigItem(
			keyName = "reminder60Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder60
	)
	default boolean reminder60Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder60Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder60
	)
	default boolean reminder60Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder60Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder60
	)
	default String reminder60Date() { return ""; }

	@ConfigItem(
			keyName = "reminder60LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder60
	)
	default int reminder60LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder60LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder60
	)
	default int reminder60LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder60Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder60
	)
	default int reminder60Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder60RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder60
	)
	default int reminder60RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder60NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder60
	)
	default String reminder60NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder60
	)
	default String reminder60ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder60Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder60
	)
	default int reminder60Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder60Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder60
	)
	default int reminder60Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #61 is enabled.",
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
			keyName = "reminder61Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder61
	)
	default String reminder61Time() { return ""; }

	@ConfigItem(
			keyName = "reminder61Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder61
	)
	default boolean reminder61Monday() { return false; }

	@ConfigItem(
			keyName = "reminder61Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder61
	)
	default boolean reminder61Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder61Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder61
	)
	default boolean reminder61Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder61Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder61
	)
	default boolean reminder61Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder61Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder61
	)
	default boolean reminder61Friday() { return false; }

	@ConfigItem(
			keyName = "reminder61Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder61
	)
	default boolean reminder61Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder61Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder61
	)
	default boolean reminder61Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder61Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder61
	)
	default String reminder61Date() { return ""; }

	@ConfigItem(
			keyName = "reminder61LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder61
	)
	default int reminder61LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder61LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder61
	)
	default int reminder61LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder61Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder61
	)
	default int reminder61Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder61RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder61
	)
	default int reminder61RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder61NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder61
	)
	default String reminder61NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder61
	)
	default String reminder61ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder61Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder61
	)
	default int reminder61Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder61Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder61
	)
	default int reminder61Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #62 is enabled.",
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
			keyName = "reminder62Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder62
	)
	default String reminder62Time() { return ""; }

	@ConfigItem(
			keyName = "reminder62Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder62
	)
	default boolean reminder62Monday() { return false; }

	@ConfigItem(
			keyName = "reminder62Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder62
	)
	default boolean reminder62Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder62Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder62
	)
	default boolean reminder62Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder62Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder62
	)
	default boolean reminder62Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder62Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder62
	)
	default boolean reminder62Friday() { return false; }

	@ConfigItem(
			keyName = "reminder62Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder62
	)
	default boolean reminder62Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder62Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder62
	)
	default boolean reminder62Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder62Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder62
	)
	default String reminder62Date() { return ""; }

	@ConfigItem(
			keyName = "reminder62LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder62
	)
	default int reminder62LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder62LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder62
	)
	default int reminder62LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder62Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder62
	)
	default int reminder62Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder62RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder62
	)
	default int reminder62RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder62NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder62
	)
	default String reminder62NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder62
	)
	default String reminder62ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder62Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder62
	)
	default int reminder62Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder62Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder62
	)
	default int reminder62Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #63 is enabled.",
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
			keyName = "reminder63Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder63
	)
	default String reminder63Time() { return ""; }

	@ConfigItem(
			keyName = "reminder63Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder63
	)
	default boolean reminder63Monday() { return false; }

	@ConfigItem(
			keyName = "reminder63Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder63
	)
	default boolean reminder63Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder63Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder63
	)
	default boolean reminder63Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder63Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder63
	)
	default boolean reminder63Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder63Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder63
	)
	default boolean reminder63Friday() { return false; }

	@ConfigItem(
			keyName = "reminder63Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder63
	)
	default boolean reminder63Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder63Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder63
	)
	default boolean reminder63Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder63Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder63
	)
	default String reminder63Date() { return ""; }

	@ConfigItem(
			keyName = "reminder63LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder63
	)
	default int reminder63LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder63LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder63
	)
	default int reminder63LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder63Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder63
	)
	default int reminder63Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder63RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder63
	)
	default int reminder63RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder63NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder63
	)
	default String reminder63NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder63
	)
	default String reminder63ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder63Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder63
	)
	default int reminder63Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder63Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder63
	)
	default int reminder63Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #64 is enabled.",
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
			keyName = "reminder64Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder64
	)
	default String reminder64Time() { return ""; }

	@ConfigItem(
			keyName = "reminder64Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder64
	)
	default boolean reminder64Monday() { return false; }

	@ConfigItem(
			keyName = "reminder64Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder64
	)
	default boolean reminder64Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder64Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder64
	)
	default boolean reminder64Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder64Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder64
	)
	default boolean reminder64Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder64Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder64
	)
	default boolean reminder64Friday() { return false; }

	@ConfigItem(
			keyName = "reminder64Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder64
	)
	default boolean reminder64Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder64Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder64
	)
	default boolean reminder64Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder64Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder64
	)
	default String reminder64Date() { return ""; }

	@ConfigItem(
			keyName = "reminder64LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder64
	)
	default int reminder64LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder64LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder64
	)
	default int reminder64LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder64Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder64
	)
	default int reminder64Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder64RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder64
	)
	default int reminder64RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder64NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder64
	)
	default String reminder64NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder64
	)
	default String reminder64ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder64Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder64
	)
	default int reminder64Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder64Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder64
	)
	default int reminder64Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #65 is enabled.",
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
			keyName = "reminder65Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder65
	)
	default String reminder65Time() { return ""; }

	@ConfigItem(
			keyName = "reminder65Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder65
	)
	default boolean reminder65Monday() { return false; }

	@ConfigItem(
			keyName = "reminder65Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder65
	)
	default boolean reminder65Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder65Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder65
	)
	default boolean reminder65Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder65Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder65
	)
	default boolean reminder65Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder65Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder65
	)
	default boolean reminder65Friday() { return false; }

	@ConfigItem(
			keyName = "reminder65Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder65
	)
	default boolean reminder65Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder65Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder65
	)
	default boolean reminder65Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder65Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder65
	)
	default String reminder65Date() { return ""; }

	@ConfigItem(
			keyName = "reminder65LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder65
	)
	default int reminder65LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder65LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder65
	)
	default int reminder65LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder65Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder65
	)
	default int reminder65Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder65RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder65
	)
	default int reminder65RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder65NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder65
	)
	default String reminder65NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder65
	)
	default String reminder65ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder65Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder65
	)
	default int reminder65Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder65Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder65
	)
	default int reminder65Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #66 is enabled.",
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
			keyName = "reminder66Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder66
	)
	default String reminder66Time() { return ""; }

	@ConfigItem(
			keyName = "reminder66Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder66
	)
	default boolean reminder66Monday() { return false; }

	@ConfigItem(
			keyName = "reminder66Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder66
	)
	default boolean reminder66Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder66Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder66
	)
	default boolean reminder66Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder66Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder66
	)
	default boolean reminder66Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder66Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder66
	)
	default boolean reminder66Friday() { return false; }

	@ConfigItem(
			keyName = "reminder66Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder66
	)
	default boolean reminder66Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder66Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder66
	)
	default boolean reminder66Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder66Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder66
	)
	default String reminder66Date() { return ""; }

	@ConfigItem(
			keyName = "reminder66LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder66
	)
	default int reminder66LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder66LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder66
	)
	default int reminder66LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder66Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder66
	)
	default int reminder66Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder66RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder66
	)
	default int reminder66RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder66NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder66
	)
	default String reminder66NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder66
	)
	default String reminder66ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder66Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder66
	)
	default int reminder66Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder66Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder66
	)
	default int reminder66Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #67 is enabled.",
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
			keyName = "reminder67Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder67
	)
	default String reminder67Time() { return ""; }

	@ConfigItem(
			keyName = "reminder67Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder67
	)
	default boolean reminder67Monday() { return false; }

	@ConfigItem(
			keyName = "reminder67Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder67
	)
	default boolean reminder67Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder67Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder67
	)
	default boolean reminder67Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder67Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder67
	)
	default boolean reminder67Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder67Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder67
	)
	default boolean reminder67Friday() { return false; }

	@ConfigItem(
			keyName = "reminder67Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder67
	)
	default boolean reminder67Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder67Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder67
	)
	default boolean reminder67Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder67Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder67
	)
	default String reminder67Date() { return ""; }

	@ConfigItem(
			keyName = "reminder67LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder67
	)
	default int reminder67LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder67LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder67
	)
	default int reminder67LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder67Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder67
	)
	default int reminder67Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder67RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder67
	)
	default int reminder67RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder67NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder67
	)
	default String reminder67NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder67
	)
	default String reminder67ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder67Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder67
	)
	default int reminder67Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder67Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder67
	)
	default int reminder67Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #68 is enabled.",
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
			keyName = "reminder68Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder68
	)
	default String reminder68Time() { return ""; }

	@ConfigItem(
			keyName = "reminder68Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder68
	)
	default boolean reminder68Monday() { return false; }

	@ConfigItem(
			keyName = "reminder68Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder68
	)
	default boolean reminder68Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder68Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder68
	)
	default boolean reminder68Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder68Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder68
	)
	default boolean reminder68Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder68Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder68
	)
	default boolean reminder68Friday() { return false; }

	@ConfigItem(
			keyName = "reminder68Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder68
	)
	default boolean reminder68Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder68Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder68
	)
	default boolean reminder68Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder68Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder68
	)
	default String reminder68Date() { return ""; }

	@ConfigItem(
			keyName = "reminder68LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder68
	)
	default int reminder68LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder68LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder68
	)
	default int reminder68LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder68Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder68
	)
	default int reminder68Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder68RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder68
	)
	default int reminder68RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder68NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder68
	)
	default String reminder68NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder68
	)
	default String reminder68ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder68Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder68
	)
	default int reminder68Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder68Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder68
	)
	default int reminder68Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #69 is enabled.",
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
			keyName = "reminder69Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder69
	)
	default String reminder69Time() { return ""; }

	@ConfigItem(
			keyName = "reminder69Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder69
	)
	default boolean reminder69Monday() { return false; }

	@ConfigItem(
			keyName = "reminder69Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder69
	)
	default boolean reminder69Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder69Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder69
	)
	default boolean reminder69Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder69Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder69
	)
	default boolean reminder69Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder69Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder69
	)
	default boolean reminder69Friday() { return false; }

	@ConfigItem(
			keyName = "reminder69Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder69
	)
	default boolean reminder69Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder69Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder69
	)
	default boolean reminder69Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder69Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder69
	)
	default String reminder69Date() { return ""; }

	@ConfigItem(
			keyName = "reminder69LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder69
	)
	default int reminder69LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder69LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder69
	)
	default int reminder69LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder69Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder69
	)
	default int reminder69Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder69RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder69
	)
	default int reminder69RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder69NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder69
	)
	default String reminder69NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder69
	)
	default String reminder69ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder69Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder69
	)
	default int reminder69Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder69Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder69
	)
	default int reminder69Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #70 is enabled.",
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
			keyName = "reminder70Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder70
	)
	default String reminder70Time() { return ""; }

	@ConfigItem(
			keyName = "reminder70Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder70
	)
	default boolean reminder70Monday() { return false; }

	@ConfigItem(
			keyName = "reminder70Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder70
	)
	default boolean reminder70Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder70Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder70
	)
	default boolean reminder70Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder70Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder70
	)
	default boolean reminder70Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder70Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder70
	)
	default boolean reminder70Friday() { return false; }

	@ConfigItem(
			keyName = "reminder70Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder70
	)
	default boolean reminder70Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder70Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder70
	)
	default boolean reminder70Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder70Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder70
	)
	default String reminder70Date() { return ""; }

	@ConfigItem(
			keyName = "reminder70LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder70
	)
	default int reminder70LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder70LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder70
	)
	default int reminder70LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder70Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder70
	)
	default int reminder70Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder70RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder70
	)
	default int reminder70RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder70NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder70
	)
	default String reminder70NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder70
	)
	default String reminder70ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder70Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder70
	)
	default int reminder70Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder70Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder70
	)
	default int reminder70Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #71 is enabled.",
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
			keyName = "reminder71Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder71
	)
	default String reminder71Time() { return ""; }

	@ConfigItem(
			keyName = "reminder71Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder71
	)
	default boolean reminder71Monday() { return false; }

	@ConfigItem(
			keyName = "reminder71Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder71
	)
	default boolean reminder71Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder71Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder71
	)
	default boolean reminder71Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder71Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder71
	)
	default boolean reminder71Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder71Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder71
	)
	default boolean reminder71Friday() { return false; }

	@ConfigItem(
			keyName = "reminder71Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder71
	)
	default boolean reminder71Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder71Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder71
	)
	default boolean reminder71Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder71Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder71
	)
	default String reminder71Date() { return ""; }

	@ConfigItem(
			keyName = "reminder71LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder71
	)
	default int reminder71LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder71LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder71
	)
	default int reminder71LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder71Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder71
	)
	default int reminder71Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder71RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder71
	)
	default int reminder71RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder71NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder71
	)
	default String reminder71NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder71
	)
	default String reminder71ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder71Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder71
	)
	default int reminder71Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder71Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder71
	)
	default int reminder71Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #72 is enabled.",
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
			keyName = "reminder72Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder72
	)
	default String reminder72Time() { return ""; }

	@ConfigItem(
			keyName = "reminder72Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder72
	)
	default boolean reminder72Monday() { return false; }

	@ConfigItem(
			keyName = "reminder72Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder72
	)
	default boolean reminder72Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder72Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder72
	)
	default boolean reminder72Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder72Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder72
	)
	default boolean reminder72Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder72Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder72
	)
	default boolean reminder72Friday() { return false; }

	@ConfigItem(
			keyName = "reminder72Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder72
	)
	default boolean reminder72Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder72Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder72
	)
	default boolean reminder72Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder72Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder72
	)
	default String reminder72Date() { return ""; }

	@ConfigItem(
			keyName = "reminder72LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder72
	)
	default int reminder72LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder72LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder72
	)
	default int reminder72LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder72Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder72
	)
	default int reminder72Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder72RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder72
	)
	default int reminder72RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder72NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder72
	)
	default String reminder72NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder72
	)
	default String reminder72ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder72Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder72
	)
	default int reminder72Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder72Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder72
	)
	default int reminder72Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #73 is enabled.",
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
			keyName = "reminder73Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder73
	)
	default String reminder73Time() { return ""; }

	@ConfigItem(
			keyName = "reminder73Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder73
	)
	default boolean reminder73Monday() { return false; }

	@ConfigItem(
			keyName = "reminder73Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder73
	)
	default boolean reminder73Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder73Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder73
	)
	default boolean reminder73Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder73Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder73
	)
	default boolean reminder73Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder73Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder73
	)
	default boolean reminder73Friday() { return false; }

	@ConfigItem(
			keyName = "reminder73Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder73
	)
	default boolean reminder73Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder73Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder73
	)
	default boolean reminder73Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder73Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder73
	)
	default String reminder73Date() { return ""; }

	@ConfigItem(
			keyName = "reminder73LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder73
	)
	default int reminder73LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder73LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder73
	)
	default int reminder73LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder73Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder73
	)
	default int reminder73Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder73RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder73
	)
	default int reminder73RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder73NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder73
	)
	default String reminder73NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder73
	)
	default String reminder73ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder73Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder73
	)
	default int reminder73Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder73Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder73
	)
	default int reminder73Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #74 is enabled.",
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
			keyName = "reminder74Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder74
	)
	default String reminder74Time() { return ""; }

	@ConfigItem(
			keyName = "reminder74Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder74
	)
	default boolean reminder74Monday() { return false; }

	@ConfigItem(
			keyName = "reminder74Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder74
	)
	default boolean reminder74Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder74Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder74
	)
	default boolean reminder74Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder74Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder74
	)
	default boolean reminder74Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder74Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder74
	)
	default boolean reminder74Friday() { return false; }

	@ConfigItem(
			keyName = "reminder74Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder74
	)
	default boolean reminder74Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder74Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder74
	)
	default boolean reminder74Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder74Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder74
	)
	default String reminder74Date() { return ""; }

	@ConfigItem(
			keyName = "reminder74LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder74
	)
	default int reminder74LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder74LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder74
	)
	default int reminder74LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder74Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder74
	)
	default int reminder74Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder74RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder74
	)
	default int reminder74RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder74NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder74
	)
	default String reminder74NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder74
	)
	default String reminder74ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder74Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder74
	)
	default int reminder74Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder74Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder74
	)
	default int reminder74Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #75 is enabled.",
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
			keyName = "reminder75Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder75
	)
	default String reminder75Time() { return ""; }

	@ConfigItem(
			keyName = "reminder75Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder75
	)
	default boolean reminder75Monday() { return false; }

	@ConfigItem(
			keyName = "reminder75Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder75
	)
	default boolean reminder75Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder75Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder75
	)
	default boolean reminder75Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder75Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder75
	)
	default boolean reminder75Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder75Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder75
	)
	default boolean reminder75Friday() { return false; }

	@ConfigItem(
			keyName = "reminder75Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder75
	)
	default boolean reminder75Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder75Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder75
	)
	default boolean reminder75Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder75Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder75
	)
	default String reminder75Date() { return ""; }

	@ConfigItem(
			keyName = "reminder75LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder75
	)
	default int reminder75LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder75LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder75
	)
	default int reminder75LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder75Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder75
	)
	default int reminder75Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder75RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder75
	)
	default int reminder75RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder75NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder75
	)
	default String reminder75NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder75
	)
	default String reminder75ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder75Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder75
	)
	default int reminder75Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder75Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder75
	)
	default int reminder75Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #76 is enabled.",
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
			keyName = "reminder76Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder76
	)
	default String reminder76Time() { return ""; }

	@ConfigItem(
			keyName = "reminder76Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder76
	)
	default boolean reminder76Monday() { return false; }

	@ConfigItem(
			keyName = "reminder76Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder76
	)
	default boolean reminder76Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder76Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder76
	)
	default boolean reminder76Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder76Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder76
	)
	default boolean reminder76Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder76Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder76
	)
	default boolean reminder76Friday() { return false; }

	@ConfigItem(
			keyName = "reminder76Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder76
	)
	default boolean reminder76Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder76Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder76
	)
	default boolean reminder76Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder76Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder76
	)
	default String reminder76Date() { return ""; }

	@ConfigItem(
			keyName = "reminder76LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder76
	)
	default int reminder76LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder76LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder76
	)
	default int reminder76LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder76Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder76
	)
	default int reminder76Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder76RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder76
	)
	default int reminder76RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder76NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder76
	)
	default String reminder76NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder76
	)
	default String reminder76ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder76Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder76
	)
	default int reminder76Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder76Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder76
	)
	default int reminder76Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #77 is enabled.",
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
			keyName = "reminder77Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder77
	)
	default String reminder77Time() { return ""; }

	@ConfigItem(
			keyName = "reminder77Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder77
	)
	default boolean reminder77Monday() { return false; }

	@ConfigItem(
			keyName = "reminder77Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder77
	)
	default boolean reminder77Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder77Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder77
	)
	default boolean reminder77Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder77Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder77
	)
	default boolean reminder77Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder77Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder77
	)
	default boolean reminder77Friday() { return false; }

	@ConfigItem(
			keyName = "reminder77Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder77
	)
	default boolean reminder77Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder77Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder77
	)
	default boolean reminder77Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder77Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder77
	)
	default String reminder77Date() { return ""; }

	@ConfigItem(
			keyName = "reminder77LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder77
	)
	default int reminder77LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder77LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder77
	)
	default int reminder77LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder77Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder77
	)
	default int reminder77Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder77RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder77
	)
	default int reminder77RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder77NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder77
	)
	default String reminder77NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder77
	)
	default String reminder77ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder77Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder77
	)
	default int reminder77Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder77Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder77
	)
	default int reminder77Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #78 is enabled.",
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
			keyName = "reminder78Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder78
	)
	default String reminder78Time() { return ""; }

	@ConfigItem(
			keyName = "reminder78Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder78
	)
	default boolean reminder78Monday() { return false; }

	@ConfigItem(
			keyName = "reminder78Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder78
	)
	default boolean reminder78Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder78Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder78
	)
	default boolean reminder78Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder78Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder78
	)
	default boolean reminder78Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder78Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder78
	)
	default boolean reminder78Friday() { return false; }

	@ConfigItem(
			keyName = "reminder78Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder78
	)
	default boolean reminder78Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder78Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder78
	)
	default boolean reminder78Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder78Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder78
	)
	default String reminder78Date() { return ""; }

	@ConfigItem(
			keyName = "reminder78LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder78
	)
	default int reminder78LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder78LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder78
	)
	default int reminder78LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder78Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder78
	)
	default int reminder78Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder78RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder78
	)
	default int reminder78RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder78NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder78
	)
	default String reminder78NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder78
	)
	default String reminder78ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder78Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder78
	)
	default int reminder78Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder78Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder78
	)
	default int reminder78Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #79 is enabled.",
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
			keyName = "reminder79Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder79
	)
	default String reminder79Time() { return ""; }

	@ConfigItem(
			keyName = "reminder79Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder79
	)
	default boolean reminder79Monday() { return false; }

	@ConfigItem(
			keyName = "reminder79Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder79
	)
	default boolean reminder79Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder79Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder79
	)
	default boolean reminder79Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder79Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder79
	)
	default boolean reminder79Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder79Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder79
	)
	default boolean reminder79Friday() { return false; }

	@ConfigItem(
			keyName = "reminder79Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder79
	)
	default boolean reminder79Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder79Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder79
	)
	default boolean reminder79Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder79Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder79
	)
	default String reminder79Date() { return ""; }

	@ConfigItem(
			keyName = "reminder79LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder79
	)
	default int reminder79LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder79LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder79
	)
	default int reminder79LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder79Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder79
	)
	default int reminder79Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder79RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder79
	)
	default int reminder79RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder79NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder79
	)
	default String reminder79NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder79
	)
	default String reminder79ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder79Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder79
	)
	default int reminder79Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder79Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder79
	)
	default int reminder79Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #80 is enabled.",
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
			keyName = "reminder80Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder80
	)
	default String reminder80Time() { return ""; }

	@ConfigItem(
			keyName = "reminder80Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder80
	)
	default boolean reminder80Monday() { return false; }

	@ConfigItem(
			keyName = "reminder80Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder80
	)
	default boolean reminder80Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder80Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder80
	)
	default boolean reminder80Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder80Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder80
	)
	default boolean reminder80Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder80Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder80
	)
	default boolean reminder80Friday() { return false; }

	@ConfigItem(
			keyName = "reminder80Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder80
	)
	default boolean reminder80Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder80Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder80
	)
	default boolean reminder80Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder80Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder80
	)
	default String reminder80Date() { return ""; }

	@ConfigItem(
			keyName = "reminder80LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder80
	)
	default int reminder80LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder80LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder80
	)
	default int reminder80LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder80Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder80
	)
	default int reminder80Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder80RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder80
	)
	default int reminder80RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder80NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder80
	)
	default String reminder80NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder80
	)
	default String reminder80ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder80Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder80
	)
	default int reminder80Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder80Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder80
	)
	default int reminder80Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #81 is enabled.",
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
			keyName = "reminder81Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder81
	)
	default String reminder81Time() { return ""; }

	@ConfigItem(
			keyName = "reminder81Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder81
	)
	default boolean reminder81Monday() { return false; }

	@ConfigItem(
			keyName = "reminder81Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder81
	)
	default boolean reminder81Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder81Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder81
	)
	default boolean reminder81Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder81Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder81
	)
	default boolean reminder81Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder81Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder81
	)
	default boolean reminder81Friday() { return false; }

	@ConfigItem(
			keyName = "reminder81Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder81
	)
	default boolean reminder81Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder81Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder81
	)
	default boolean reminder81Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder81Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder81
	)
	default String reminder81Date() { return ""; }

	@ConfigItem(
			keyName = "reminder81LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder81
	)
	default int reminder81LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder81LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder81
	)
	default int reminder81LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder81Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder81
	)
	default int reminder81Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder81RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder81
	)
	default int reminder81RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder81NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder81
	)
	default String reminder81NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder81
	)
	default String reminder81ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder81Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder81
	)
	default int reminder81Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder81Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder81
	)
	default int reminder81Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #82 is enabled.",
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
			keyName = "reminder82Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder82
	)
	default String reminder82Time() { return ""; }

	@ConfigItem(
			keyName = "reminder82Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder82
	)
	default boolean reminder82Monday() { return false; }

	@ConfigItem(
			keyName = "reminder82Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder82
	)
	default boolean reminder82Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder82Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder82
	)
	default boolean reminder82Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder82Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder82
	)
	default boolean reminder82Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder82Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder82
	)
	default boolean reminder82Friday() { return false; }

	@ConfigItem(
			keyName = "reminder82Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder82
	)
	default boolean reminder82Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder82Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder82
	)
	default boolean reminder82Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder82Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder82
	)
	default String reminder82Date() { return ""; }

	@ConfigItem(
			keyName = "reminder82LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder82
	)
	default int reminder82LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder82LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder82
	)
	default int reminder82LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder82Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder82
	)
	default int reminder82Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder82RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder82
	)
	default int reminder82RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder82NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder82
	)
	default String reminder82NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder82
	)
	default String reminder82ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder82Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder82
	)
	default int reminder82Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder82Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder82
	)
	default int reminder82Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #83 is enabled.",
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
			keyName = "reminder83Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder83
	)
	default String reminder83Time() { return ""; }

	@ConfigItem(
			keyName = "reminder83Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder83
	)
	default boolean reminder83Monday() { return false; }

	@ConfigItem(
			keyName = "reminder83Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder83
	)
	default boolean reminder83Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder83Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder83
	)
	default boolean reminder83Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder83Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder83
	)
	default boolean reminder83Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder83Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder83
	)
	default boolean reminder83Friday() { return false; }

	@ConfigItem(
			keyName = "reminder83Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder83
	)
	default boolean reminder83Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder83Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder83
	)
	default boolean reminder83Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder83Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder83
	)
	default String reminder83Date() { return ""; }

	@ConfigItem(
			keyName = "reminder83LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder83
	)
	default int reminder83LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder83LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder83
	)
	default int reminder83LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder83Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder83
	)
	default int reminder83Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder83RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder83
	)
	default int reminder83RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder83NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder83
	)
	default String reminder83NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder83
	)
	default String reminder83ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder83Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder83
	)
	default int reminder83Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder83Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder83
	)
	default int reminder83Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #84 is enabled.",
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
			keyName = "reminder84Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder84
	)
	default String reminder84Time() { return ""; }

	@ConfigItem(
			keyName = "reminder84Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder84
	)
	default boolean reminder84Monday() { return false; }

	@ConfigItem(
			keyName = "reminder84Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder84
	)
	default boolean reminder84Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder84Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder84
	)
	default boolean reminder84Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder84Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder84
	)
	default boolean reminder84Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder84Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder84
	)
	default boolean reminder84Friday() { return false; }

	@ConfigItem(
			keyName = "reminder84Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder84
	)
	default boolean reminder84Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder84Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder84
	)
	default boolean reminder84Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder84Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder84
	)
	default String reminder84Date() { return ""; }

	@ConfigItem(
			keyName = "reminder84LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder84
	)
	default int reminder84LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder84LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder84
	)
	default int reminder84LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder84Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder84
	)
	default int reminder84Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder84RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder84
	)
	default int reminder84RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder84NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder84
	)
	default String reminder84NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder84
	)
	default String reminder84ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder84Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder84
	)
	default int reminder84Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder84Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder84
	)
	default int reminder84Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #85 is enabled.",
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
			keyName = "reminder85Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder85
	)
	default String reminder85Time() { return ""; }

	@ConfigItem(
			keyName = "reminder85Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder85
	)
	default boolean reminder85Monday() { return false; }

	@ConfigItem(
			keyName = "reminder85Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder85
	)
	default boolean reminder85Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder85Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder85
	)
	default boolean reminder85Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder85Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder85
	)
	default boolean reminder85Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder85Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder85
	)
	default boolean reminder85Friday() { return false; }

	@ConfigItem(
			keyName = "reminder85Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder85
	)
	default boolean reminder85Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder85Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder85
	)
	default boolean reminder85Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder85Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder85
	)
	default String reminder85Date() { return ""; }

	@ConfigItem(
			keyName = "reminder85LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder85
	)
	default int reminder85LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder85LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder85
	)
	default int reminder85LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder85Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder85
	)
	default int reminder85Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder85RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder85
	)
	default int reminder85RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder85NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder85
	)
	default String reminder85NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder85
	)
	default String reminder85ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder85Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder85
	)
	default int reminder85Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder85Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder85
	)
	default int reminder85Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #86 is enabled.",
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
			keyName = "reminder86Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder86
	)
	default String reminder86Time() { return ""; }

	@ConfigItem(
			keyName = "reminder86Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder86
	)
	default boolean reminder86Monday() { return false; }

	@ConfigItem(
			keyName = "reminder86Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder86
	)
	default boolean reminder86Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder86Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder86
	)
	default boolean reminder86Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder86Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder86
	)
	default boolean reminder86Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder86Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder86
	)
	default boolean reminder86Friday() { return false; }

	@ConfigItem(
			keyName = "reminder86Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder86
	)
	default boolean reminder86Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder86Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder86
	)
	default boolean reminder86Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder86Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder86
	)
	default String reminder86Date() { return ""; }

	@ConfigItem(
			keyName = "reminder86LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder86
	)
	default int reminder86LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder86LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder86
	)
	default int reminder86LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder86Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder86
	)
	default int reminder86Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder86RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder86
	)
	default int reminder86RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder86NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder86
	)
	default String reminder86NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder86
	)
	default String reminder86ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder86Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder86
	)
	default int reminder86Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder86Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder86
	)
	default int reminder86Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #87 is enabled.",
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
			keyName = "reminder87Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder87
	)
	default String reminder87Time() { return ""; }

	@ConfigItem(
			keyName = "reminder87Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder87
	)
	default boolean reminder87Monday() { return false; }

	@ConfigItem(
			keyName = "reminder87Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder87
	)
	default boolean reminder87Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder87Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder87
	)
	default boolean reminder87Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder87Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder87
	)
	default boolean reminder87Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder87Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder87
	)
	default boolean reminder87Friday() { return false; }

	@ConfigItem(
			keyName = "reminder87Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder87
	)
	default boolean reminder87Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder87Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder87
	)
	default boolean reminder87Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder87Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder87
	)
	default String reminder87Date() { return ""; }

	@ConfigItem(
			keyName = "reminder87LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder87
	)
	default int reminder87LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder87LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder87
	)
	default int reminder87LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder87Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder87
	)
	default int reminder87Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder87RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder87
	)
	default int reminder87RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder87NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder87
	)
	default String reminder87NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder87
	)
	default String reminder87ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder87Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder87
	)
	default int reminder87Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder87Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder87
	)
	default int reminder87Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #88 is enabled.",
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
			keyName = "reminder88Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder88
	)
	default String reminder88Time() { return ""; }

	@ConfigItem(
			keyName = "reminder88Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder88
	)
	default boolean reminder88Monday() { return false; }

	@ConfigItem(
			keyName = "reminder88Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder88
	)
	default boolean reminder88Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder88Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder88
	)
	default boolean reminder88Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder88Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder88
	)
	default boolean reminder88Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder88Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder88
	)
	default boolean reminder88Friday() { return false; }

	@ConfigItem(
			keyName = "reminder88Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder88
	)
	default boolean reminder88Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder88Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder88
	)
	default boolean reminder88Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder88Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder88
	)
	default String reminder88Date() { return ""; }

	@ConfigItem(
			keyName = "reminder88LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder88
	)
	default int reminder88LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder88LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder88
	)
	default int reminder88LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder88Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder88
	)
	default int reminder88Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder88RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder88
	)
	default int reminder88RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder88NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder88
	)
	default String reminder88NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder88
	)
	default String reminder88ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder88Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder88
	)
	default int reminder88Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder88Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder88
	)
	default int reminder88Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #89 is enabled.",
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
			keyName = "reminder89Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder89
	)
	default String reminder89Time() { return ""; }

	@ConfigItem(
			keyName = "reminder89Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder89
	)
	default boolean reminder89Monday() { return false; }

	@ConfigItem(
			keyName = "reminder89Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder89
	)
	default boolean reminder89Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder89Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder89
	)
	default boolean reminder89Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder89Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder89
	)
	default boolean reminder89Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder89Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder89
	)
	default boolean reminder89Friday() { return false; }

	@ConfigItem(
			keyName = "reminder89Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder89
	)
	default boolean reminder89Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder89Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder89
	)
	default boolean reminder89Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder89Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder89
	)
	default String reminder89Date() { return ""; }

	@ConfigItem(
			keyName = "reminder89LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder89
	)
	default int reminder89LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder89LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder89
	)
	default int reminder89LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder89Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder89
	)
	default int reminder89Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder89RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder89
	)
	default int reminder89RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder89NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder89
	)
	default String reminder89NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder89
	)
	default String reminder89ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder89Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder89
	)
	default int reminder89Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder89Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder89
	)
	default int reminder89Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #90 is enabled.",
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
			keyName = "reminder90Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder90
	)
	default String reminder90Time() { return ""; }

	@ConfigItem(
			keyName = "reminder90Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder90
	)
	default boolean reminder90Monday() { return false; }

	@ConfigItem(
			keyName = "reminder90Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder90
	)
	default boolean reminder90Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder90Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder90
	)
	default boolean reminder90Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder90Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder90
	)
	default boolean reminder90Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder90Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder90
	)
	default boolean reminder90Friday() { return false; }

	@ConfigItem(
			keyName = "reminder90Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder90
	)
	default boolean reminder90Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder90Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder90
	)
	default boolean reminder90Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder90Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder90
	)
	default String reminder90Date() { return ""; }

	@ConfigItem(
			keyName = "reminder90LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder90
	)
	default int reminder90LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder90LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder90
	)
	default int reminder90LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder90Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder90
	)
	default int reminder90Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder90RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder90
	)
	default int reminder90RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder90NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder90
	)
	default String reminder90NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder90
	)
	default String reminder90ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder90Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder90
	)
	default int reminder90Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder90Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder90
	)
	default int reminder90Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #91 is enabled.",
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
			keyName = "reminder91Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder91
	)
	default String reminder91Time() { return ""; }

	@ConfigItem(
			keyName = "reminder91Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder91
	)
	default boolean reminder91Monday() { return false; }

	@ConfigItem(
			keyName = "reminder91Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder91
	)
	default boolean reminder91Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder91Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder91
	)
	default boolean reminder91Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder91Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder91
	)
	default boolean reminder91Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder91Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder91
	)
	default boolean reminder91Friday() { return false; }

	@ConfigItem(
			keyName = "reminder91Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder91
	)
	default boolean reminder91Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder91Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder91
	)
	default boolean reminder91Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder91Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder91
	)
	default String reminder91Date() { return ""; }

	@ConfigItem(
			keyName = "reminder91LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder91
	)
	default int reminder91LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder91LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder91
	)
	default int reminder91LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder91Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder91
	)
	default int reminder91Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder91RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder91
	)
	default int reminder91RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder91NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder91
	)
	default String reminder91NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder91
	)
	default String reminder91ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder91Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder91
	)
	default int reminder91Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder91Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder91
	)
	default int reminder91Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #92 is enabled.",
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
			keyName = "reminder92Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder92
	)
	default String reminder92Time() { return ""; }

	@ConfigItem(
			keyName = "reminder92Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder92
	)
	default boolean reminder92Monday() { return false; }

	@ConfigItem(
			keyName = "reminder92Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder92
	)
	default boolean reminder92Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder92Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder92
	)
	default boolean reminder92Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder92Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder92
	)
	default boolean reminder92Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder92Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder92
	)
	default boolean reminder92Friday() { return false; }

	@ConfigItem(
			keyName = "reminder92Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder92
	)
	default boolean reminder92Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder92Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder92
	)
	default boolean reminder92Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder92Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder92
	)
	default String reminder92Date() { return ""; }

	@ConfigItem(
			keyName = "reminder92LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder92
	)
	default int reminder92LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder92LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder92
	)
	default int reminder92LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder92Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder92
	)
	default int reminder92Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder92RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder92
	)
	default int reminder92RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder92NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder92
	)
	default String reminder92NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder92
	)
	default String reminder92ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder92Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder92
	)
	default int reminder92Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder92Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder92
	)
	default int reminder92Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #93 is enabled.",
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
			keyName = "reminder93Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder93
	)
	default String reminder93Time() { return ""; }

	@ConfigItem(
			keyName = "reminder93Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder93
	)
	default boolean reminder93Monday() { return false; }

	@ConfigItem(
			keyName = "reminder93Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder93
	)
	default boolean reminder93Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder93Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder93
	)
	default boolean reminder93Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder93Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder93
	)
	default boolean reminder93Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder93Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder93
	)
	default boolean reminder93Friday() { return false; }

	@ConfigItem(
			keyName = "reminder93Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder93
	)
	default boolean reminder93Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder93Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder93
	)
	default boolean reminder93Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder93Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder93
	)
	default String reminder93Date() { return ""; }

	@ConfigItem(
			keyName = "reminder93LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder93
	)
	default int reminder93LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder93LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder93
	)
	default int reminder93LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder93Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder93
	)
	default int reminder93Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder93RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder93
	)
	default int reminder93RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder93NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder93
	)
	default String reminder93NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder93
	)
	default String reminder93ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder93Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder93
	)
	default int reminder93Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder93Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder93
	)
	default int reminder93Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #94 is enabled.",
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
			keyName = "reminder94Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder94
	)
	default String reminder94Time() { return ""; }

	@ConfigItem(
			keyName = "reminder94Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder94
	)
	default boolean reminder94Monday() { return false; }

	@ConfigItem(
			keyName = "reminder94Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder94
	)
	default boolean reminder94Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder94Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder94
	)
	default boolean reminder94Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder94Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder94
	)
	default boolean reminder94Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder94Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder94
	)
	default boolean reminder94Friday() { return false; }

	@ConfigItem(
			keyName = "reminder94Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder94
	)
	default boolean reminder94Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder94Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder94
	)
	default boolean reminder94Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder94Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder94
	)
	default String reminder94Date() { return ""; }

	@ConfigItem(
			keyName = "reminder94LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder94
	)
	default int reminder94LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder94LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder94
	)
	default int reminder94LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder94Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder94
	)
	default int reminder94Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder94RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder94
	)
	default int reminder94RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder94NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder94
	)
	default String reminder94NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder94
	)
	default String reminder94ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder94Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder94
	)
	default int reminder94Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder94Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder94
	)
	default int reminder94Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #95 is enabled.",
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
			keyName = "reminder95Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder95
	)
	default String reminder95Time() { return ""; }

	@ConfigItem(
			keyName = "reminder95Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder95
	)
	default boolean reminder95Monday() { return false; }

	@ConfigItem(
			keyName = "reminder95Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder95
	)
	default boolean reminder95Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder95Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder95
	)
	default boolean reminder95Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder95Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder95
	)
	default boolean reminder95Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder95Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder95
	)
	default boolean reminder95Friday() { return false; }

	@ConfigItem(
			keyName = "reminder95Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder95
	)
	default boolean reminder95Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder95Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder95
	)
	default boolean reminder95Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder95Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder95
	)
	default String reminder95Date() { return ""; }

	@ConfigItem(
			keyName = "reminder95LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder95
	)
	default int reminder95LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder95LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder95
	)
	default int reminder95LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder95Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder95
	)
	default int reminder95Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder95RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder95
	)
	default int reminder95RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder95NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder95
	)
	default String reminder95NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder95
	)
	default String reminder95ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder95Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder95
	)
	default int reminder95Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder95Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder95
	)
	default int reminder95Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #96 is enabled.",
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
			keyName = "reminder96Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder96
	)
	default String reminder96Time() { return ""; }

	@ConfigItem(
			keyName = "reminder96Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder96
	)
	default boolean reminder96Monday() { return false; }

	@ConfigItem(
			keyName = "reminder96Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder96
	)
	default boolean reminder96Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder96Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder96
	)
	default boolean reminder96Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder96Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder96
	)
	default boolean reminder96Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder96Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder96
	)
	default boolean reminder96Friday() { return false; }

	@ConfigItem(
			keyName = "reminder96Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder96
	)
	default boolean reminder96Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder96Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder96
	)
	default boolean reminder96Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder96Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder96
	)
	default String reminder96Date() { return ""; }

	@ConfigItem(
			keyName = "reminder96LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder96
	)
	default int reminder96LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder96LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder96
	)
	default int reminder96LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder96Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder96
	)
	default int reminder96Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder96RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder96
	)
	default int reminder96RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder96NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder96
	)
	default String reminder96NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder96
	)
	default String reminder96ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder96Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder96
	)
	default int reminder96Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder96Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder96
	)
	default int reminder96Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #97 is enabled.",
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
			keyName = "reminder97Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder97
	)
	default String reminder97Time() { return ""; }

	@ConfigItem(
			keyName = "reminder97Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder97
	)
	default boolean reminder97Monday() { return false; }

	@ConfigItem(
			keyName = "reminder97Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder97
	)
	default boolean reminder97Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder97Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder97
	)
	default boolean reminder97Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder97Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder97
	)
	default boolean reminder97Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder97Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder97
	)
	default boolean reminder97Friday() { return false; }

	@ConfigItem(
			keyName = "reminder97Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder97
	)
	default boolean reminder97Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder97Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder97
	)
	default boolean reminder97Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder97Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder97
	)
	default String reminder97Date() { return ""; }

	@ConfigItem(
			keyName = "reminder97LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder97
	)
	default int reminder97LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder97LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder97
	)
	default int reminder97LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder97Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder97
	)
	default int reminder97Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder97RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder97
	)
	default int reminder97RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder97NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder97
	)
	default String reminder97NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder97
	)
	default String reminder97ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder97Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder97
	)
	default int reminder97Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder97Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder97
	)
	default int reminder97Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #98 is enabled.",
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
			keyName = "reminder98Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder98
	)
	default String reminder98Time() { return ""; }

	@ConfigItem(
			keyName = "reminder98Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder98
	)
	default boolean reminder98Monday() { return false; }

	@ConfigItem(
			keyName = "reminder98Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder98
	)
	default boolean reminder98Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder98Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder98
	)
	default boolean reminder98Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder98Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder98
	)
	default boolean reminder98Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder98Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder98
	)
	default boolean reminder98Friday() { return false; }

	@ConfigItem(
			keyName = "reminder98Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder98
	)
	default boolean reminder98Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder98Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder98
	)
	default boolean reminder98Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder98Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder98
	)
	default String reminder98Date() { return ""; }

	@ConfigItem(
			keyName = "reminder98LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder98
	)
	default int reminder98LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder98LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder98
	)
	default int reminder98LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder98Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder98
	)
	default int reminder98Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder98RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder98
	)
	default int reminder98RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder98NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder98
	)
	default String reminder98NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder98
	)
	default String reminder98ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder98Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder98
	)
	default int reminder98Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder98Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder98
	)
	default int reminder98Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #99 is enabled.",
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
			keyName = "reminder99Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder99
	)
	default String reminder99Time() { return ""; }

	@ConfigItem(
			keyName = "reminder99Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder99
	)
	default boolean reminder99Monday() { return false; }

	@ConfigItem(
			keyName = "reminder99Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder99
	)
	default boolean reminder99Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder99Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder99
	)
	default boolean reminder99Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder99Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder99
	)
	default boolean reminder99Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder99Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder99
	)
	default boolean reminder99Friday() { return false; }

	@ConfigItem(
			keyName = "reminder99Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder99
	)
	default boolean reminder99Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder99Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder99
	)
	default boolean reminder99Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder99Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder99
	)
	default String reminder99Date() { return ""; }

	@ConfigItem(
			keyName = "reminder99LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder99
	)
	default int reminder99LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder99LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder99
	)
	default int reminder99LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder99Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder99
	)
	default int reminder99Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder99RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder99
	)
	default int reminder99RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder99NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder99
	)
	default String reminder99NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder99
	)
	default String reminder99ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder99Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder99
	)
	default int reminder99Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder99Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder99
	)
	default int reminder99Cooldown() { return 5; }


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
			name = "Enabled",
			description = "Configures whether or not reminder #100 is enabled.",
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
			keyName = "reminder100Time",
			position = 3,
			name = "Time",
			description = "Configures what time reminder is shown, e.g. 8:30am, 12:00pm.",
			section = reminder100
	)
	default String reminder100Time() { return ""; }

	@ConfigItem(
			keyName = "reminder100Monday",
			position = 4,
			name = "Monday",
			description = "Configures whether or not reminder is shown on Mondays.",
			section = reminder100
	)
	default boolean reminder100Monday() { return false; }

	@ConfigItem(
			keyName = "reminder100Tuesday",
			position = 5,
			name = "Tuesday",
			description = "Configures whether or not reminder is shown on Tuesdays.",
			section = reminder100
	)
	default boolean reminder100Tuesday() { return false; }

	@ConfigItem(
			keyName = "reminder100Wednesday",
			position = 6,
			name = "Wednesday",
			description = "Configures whether or not reminder is shown on Wednesdays.",
			section = reminder100
	)
	default boolean reminder100Wednesday() { return false; }

	@ConfigItem(
			keyName = "reminder100Thursday",
			position = 7,
			name = "Thursday",
			description = "Configures whether or not reminder is shown on Thursdays.",
			section = reminder100
	)
	default boolean reminder100Thursday() { return false; }

	@ConfigItem(
			keyName = "reminder100Friday",
			position = 8,
			name = "Friday",
			description = "Configures whether or reminder is shown on Fridays.",
			section = reminder100
	)
	default boolean reminder100Friday() { return false; }

	@ConfigItem(
			keyName = "reminder100Saturday",
			position = 9,
			name = "Saturday",
			description = "Configures whether or not reminder is shown on Saturdays.",
			section = reminder100
	)
	default boolean reminder100Saturday() { return false; }

	@ConfigItem(
			keyName = "reminder100Sunday",
			position = 10,
			name = "Sunday",
			description = "Configures whether or not reminder is shown on Sundays.",
			section = reminder100
	)
	default boolean reminder100Sunday() { return false; }

	@ConfigItem(
			keyName = "reminder100Date",
			position = 11,
			name = "Date",
			description = "Configures the date when reminder is shown, e.g. 04/30, 05/28/23",
			section = reminder100
	)
	default String reminder100Date() { return ""; }

	@ConfigItem(
			keyName = "reminder100LocationX",
			position = 12,
			name = "Location X",
			description = "Configures the x coordinate for when reminder is shown.",
			section = reminder100
	)
	default int reminder100LocationX() { return 0; }

	@ConfigItem(
			keyName = "reminder100LocationY",
			position = 13,
			name = "Location Y",
			description = "Configures the y coordinate for when reminder is shown.",
			section = reminder100
	)
	default int reminder100LocationY() { return 0; }

	@ConfigItem(
			keyName = "reminder100Radius",
			position = 14,
			name = "Location Radius",
			description = "Configures how far from the location reminder is shown.",
			section = reminder100
	)
	default int reminder100Radius() { return 0; }

	@ConfigItem(
			keyName = "Reminder100RegionId",
			position = 15,
			name = "Region ID",
			description = "Configures the region id for when reminder is shown.",
			section = reminder100
	)
	default int reminder100RegionId() { return 0; }

	@ConfigItem(
			keyName = "Reminder100NpcIds",
			position = 16,
			name = "Npc IDs",
			description = "Configures the npc ids for when reminder is shown.",
			section = reminder100
	)
	default String reminder100NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100ItemIds",
			position = 17,
			name = "Item IDs",
			description = "Configures the item ids for when reminder is shown.",
			section = reminder100
	)
	default String reminder100ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Reminder100Duration",
			position = 19,
			name = "Duration",
			description = "Configures the duration reminder is shown (minutes).",
			section = reminder100
	)
	default int reminder100Duration() { return 5; }

	@ConfigItem(
			keyName = "Reminder100Cooldown",
			position = 20,
			name = "Cooldown",
			description = "Configures the cooldown before reminder can be shown again (minutes).",
			section = reminder100
	)
	default int reminder100Cooldown() { return 5; }
}