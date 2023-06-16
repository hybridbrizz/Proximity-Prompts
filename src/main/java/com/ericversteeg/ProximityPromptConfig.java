package com.ericversteeg;

import com.ericversteeg.model.config.Location;
import com.ericversteeg.model.config.TextSize;
import com.ericversteeg.model.config.TimeUnit;
import com.ericversteeg.view.RSAnchorType;
import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup(ProximityPromptConfig.GROUP)
public interface ProximityPromptConfig extends Config {
	String GROUP = "proximity_prompt";

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
			position = 0,
			keyName = "idFinder",
			name = "ID Finder",
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

	@ConfigSection(
			name = "JSON",
			description = "JSON Prompts",
			position = 20,
			closedByDefault = true
	)
	String customPrompts = "customPromptsSection";

	@ConfigItem(
			position = 0,
			keyName = "jsonPrompts",
			name = "Json",
			description = "Json array of prompts.",
			section = customPrompts

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
			name = "1",
			description = "Prompt 1",
			position = 21,
			closedByDefault = true
	)
	String prompt1= "prompt1";

	@ConfigItem(
			keyName = "enablePrompt1",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt1
	)
	default boolean prompt1Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt1Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt1
	)
	default String prompt1Text() { return ""; }

	@ConfigItem(
			keyName = "prompt1Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt1
	)
	default Color prompt1Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt1Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt1
	)
	default String prompt1Times() { return ""; }

	@ConfigItem(
			keyName = "prompt1DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt1
	)
	default String prompt1DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt1Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt1
	)
	default String prompt1Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt1Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt1
	)
	default String prompt1Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt1Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt1
	)
	default String prompt1Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt1Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt1
	)
	default int prompt1Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt1RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt1
	)
	default String prompt1RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt1NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt1
	)
	default String prompt1NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt1ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt1
	)
	default String prompt1ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt1Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt1
	)
	default int prompt1Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt1Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt1
	)
	default int prompt1Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt1TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt1
	)
	default TimeUnit prompt1TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt1ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt1
	)
	default String prompt1ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt1Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt1
	)
	default boolean prompt1Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt1SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt1
	)
	default Location prompt1Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt1panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt1
	)
	default RSAnchorType prompt1PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt1PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt1
	)
	default int prompt1PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt1PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt1
	)
	default int prompt1PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt1ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt1
	)
	default int prompt1ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt1Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt1
	)
	default boolean prompt1Image() { return false; }

	@ConfigItem(
			keyName = "Prompt1ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt1
	)
	default boolean prompt1ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt1PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt1
	)
	default int prompt1PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt1PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt1
	)
	default TextSize prompt1PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt1PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt1
	)
	default Color prompt1PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt1PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt1
	)
	default boolean prompt1PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt1ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt1
	)
	default boolean prompt1ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt1ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt1
	)
	default int prompt1ImageOffset() { return 0; }


	@ConfigSection(
			name = "2",
			description = "Prompt 2",
			position = 22,
			closedByDefault = true
	)
	String prompt2= "prompt2";

	@ConfigItem(
			keyName = "enablePrompt2",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt2
	)
	default boolean prompt2Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt2Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt2
	)
	default String prompt2Text() { return ""; }

	@ConfigItem(
			keyName = "prompt2Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt2
	)
	default Color prompt2Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt2Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt2
	)
	default String prompt2Times() { return ""; }

	@ConfigItem(
			keyName = "prompt2DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt2
	)
	default String prompt2DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt2Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt2
	)
	default String prompt2Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt2Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt2
	)
	default String prompt2Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt2Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt2
	)
	default String prompt2Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt2Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt2
	)
	default int prompt2Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt2RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt2
	)
	default String prompt2RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt2NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt2
	)
	default String prompt2NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt2ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt2
	)
	default String prompt2ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt2Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt2
	)
	default int prompt2Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt2Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt2
	)
	default int prompt2Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt2TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt2
	)
	default TimeUnit prompt2TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt2ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt2
	)
	default String prompt2ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt2Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt2
	)
	default boolean prompt2Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt2SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt2
	)
	default Location prompt2Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt2panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt2
	)
	default RSAnchorType prompt2PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt2PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt2
	)
	default int prompt2PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt2PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt2
	)
	default int prompt2PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt2ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt2
	)
	default int prompt2ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt2Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt2
	)
	default boolean prompt2Image() { return false; }

	@ConfigItem(
			keyName = "Prompt2ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt2
	)
	default boolean prompt2ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt2PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt2
	)
	default int prompt2PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt2PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt2
	)
	default TextSize prompt2PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt2PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt2
	)
	default Color prompt2PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt2PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt2
	)
	default boolean prompt2PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt2ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt2
	)
	default boolean prompt2ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt2ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt2
	)
	default int prompt2ImageOffset() { return 0; }


	@ConfigSection(
			name = "3",
			description = "Prompt 3",
			position = 23,
			closedByDefault = true
	)
	String prompt3= "prompt3";

	@ConfigItem(
			keyName = "enablePrompt3",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt3
	)
	default boolean prompt3Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt3Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt3
	)
	default String prompt3Text() { return ""; }

	@ConfigItem(
			keyName = "prompt3Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt3
	)
	default Color prompt3Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt3Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt3
	)
	default String prompt3Times() { return ""; }

	@ConfigItem(
			keyName = "prompt3DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt3
	)
	default String prompt3DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt3Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt3
	)
	default String prompt3Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt3Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt3
	)
	default String prompt3Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt3Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt3
	)
	default String prompt3Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt3Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt3
	)
	default int prompt3Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt3RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt3
	)
	default String prompt3RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt3NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt3
	)
	default String prompt3NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt3ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt3
	)
	default String prompt3ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt3Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt3
	)
	default int prompt3Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt3Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt3
	)
	default int prompt3Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt3TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt3
	)
	default TimeUnit prompt3TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt3ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt3
	)
	default String prompt3ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt3Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt3
	)
	default boolean prompt3Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt3SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt3
	)
	default Location prompt3Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt3panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt3
	)
	default RSAnchorType prompt3PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt3PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt3
	)
	default int prompt3PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt3PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt3
	)
	default int prompt3PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt3ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt3
	)
	default int prompt3ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt3Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt3
	)
	default boolean prompt3Image() { return false; }

	@ConfigItem(
			keyName = "Prompt3ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt3
	)
	default boolean prompt3ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt3PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt3
	)
	default int prompt3PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt3PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt3
	)
	default TextSize prompt3PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt3PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt3
	)
	default Color prompt3PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt3PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt3
	)
	default boolean prompt3PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt3ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt3
	)
	default boolean prompt3ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt3ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt3
	)
	default int prompt3ImageOffset() { return 0; }


	@ConfigSection(
			name = "4",
			description = "Prompt 4",
			position = 24,
			closedByDefault = true
	)
	String prompt4= "prompt4";

	@ConfigItem(
			keyName = "enablePrompt4",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt4
	)
	default boolean prompt4Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt4Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt4
	)
	default String prompt4Text() { return ""; }

	@ConfigItem(
			keyName = "prompt4Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt4
	)
	default Color prompt4Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt4Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt4
	)
	default String prompt4Times() { return ""; }

	@ConfigItem(
			keyName = "prompt4DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt4
	)
	default String prompt4DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt4Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt4
	)
	default String prompt4Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt4Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt4
	)
	default String prompt4Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt4Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt4
	)
	default String prompt4Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt4Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt4
	)
	default int prompt4Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt4RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt4
	)
	default String prompt4RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt4NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt4
	)
	default String prompt4NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt4ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt4
	)
	default String prompt4ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt4Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt4
	)
	default int prompt4Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt4Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt4
	)
	default int prompt4Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt4TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt4
	)
	default TimeUnit prompt4TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt4ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt4
	)
	default String prompt4ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt4Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt4
	)
	default boolean prompt4Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt4SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt4
	)
	default Location prompt4Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt4panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt4
	)
	default RSAnchorType prompt4PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt4PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt4
	)
	default int prompt4PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt4PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt4
	)
	default int prompt4PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt4ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt4
	)
	default int prompt4ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt4Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt4
	)
	default boolean prompt4Image() { return false; }

	@ConfigItem(
			keyName = "Prompt4ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt4
	)
	default boolean prompt4ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt4PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt4
	)
	default int prompt4PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt4PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt4
	)
	default TextSize prompt4PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt4PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt4
	)
	default Color prompt4PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt4PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt4
	)
	default boolean prompt4PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt4ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt4
	)
	default boolean prompt4ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt4ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt4
	)
	default int prompt4ImageOffset() { return 0; }


	@ConfigSection(
			name = "5",
			description = "Prompt 5",
			position = 25,
			closedByDefault = true
	)
	String prompt5= "prompt5";

	@ConfigItem(
			keyName = "enablePrompt5",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt5
	)
	default boolean prompt5Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt5Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt5
	)
	default String prompt5Text() { return ""; }

	@ConfigItem(
			keyName = "prompt5Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt5
	)
	default Color prompt5Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt5Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt5
	)
	default String prompt5Times() { return ""; }

	@ConfigItem(
			keyName = "prompt5DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt5
	)
	default String prompt5DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt5Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt5
	)
	default String prompt5Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt5Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt5
	)
	default String prompt5Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt5Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt5
	)
	default String prompt5Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt5Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt5
	)
	default int prompt5Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt5RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt5
	)
	default String prompt5RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt5NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt5
	)
	default String prompt5NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt5ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt5
	)
	default String prompt5ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt5Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt5
	)
	default int prompt5Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt5Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt5
	)
	default int prompt5Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt5TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt5
	)
	default TimeUnit prompt5TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt5ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt5
	)
	default String prompt5ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt5Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt5
	)
	default boolean prompt5Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt5SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt5
	)
	default Location prompt5Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt5panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt5
	)
	default RSAnchorType prompt5PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt5PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt5
	)
	default int prompt5PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt5PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt5
	)
	default int prompt5PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt5ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt5
	)
	default int prompt5ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt5Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt5
	)
	default boolean prompt5Image() { return false; }

	@ConfigItem(
			keyName = "Prompt5ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt5
	)
	default boolean prompt5ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt5PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt5
	)
	default int prompt5PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt5PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt5
	)
	default TextSize prompt5PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt5PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt5
	)
	default Color prompt5PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt5PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt5
	)
	default boolean prompt5PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt5ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt5
	)
	default boolean prompt5ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt5ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt5
	)
	default int prompt5ImageOffset() { return 0; }


	@ConfigSection(
			name = "6",
			description = "Prompt 6",
			position = 26,
			closedByDefault = true
	)
	String prompt6= "prompt6";

	@ConfigItem(
			keyName = "enablePrompt6",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt6
	)
	default boolean prompt6Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt6Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt6
	)
	default String prompt6Text() { return ""; }

	@ConfigItem(
			keyName = "prompt6Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt6
	)
	default Color prompt6Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt6Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt6
	)
	default String prompt6Times() { return ""; }

	@ConfigItem(
			keyName = "prompt6DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt6
	)
	default String prompt6DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt6Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt6
	)
	default String prompt6Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt6Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt6
	)
	default String prompt6Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt6Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt6
	)
	default String prompt6Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt6Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt6
	)
	default int prompt6Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt6RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt6
	)
	default String prompt6RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt6NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt6
	)
	default String prompt6NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt6ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt6
	)
	default String prompt6ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt6Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt6
	)
	default int prompt6Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt6Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt6
	)
	default int prompt6Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt6TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt6
	)
	default TimeUnit prompt6TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt6ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt6
	)
	default String prompt6ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt6Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt6
	)
	default boolean prompt6Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt6SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt6
	)
	default Location prompt6Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt6panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt6
	)
	default RSAnchorType prompt6PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt6PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt6
	)
	default int prompt6PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt6PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt6
	)
	default int prompt6PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt6ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt6
	)
	default int prompt6ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt6Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt6
	)
	default boolean prompt6Image() { return false; }

	@ConfigItem(
			keyName = "Prompt6ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt6
	)
	default boolean prompt6ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt6PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt6
	)
	default int prompt6PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt6PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt6
	)
	default TextSize prompt6PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt6PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt6
	)
	default Color prompt6PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt6PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt6
	)
	default boolean prompt6PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt6ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt6
	)
	default boolean prompt6ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt6ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt6
	)
	default int prompt6ImageOffset() { return 0; }


	@ConfigSection(
			name = "7",
			description = "Prompt 7",
			position = 27,
			closedByDefault = true
	)
	String prompt7= "prompt7";

	@ConfigItem(
			keyName = "enablePrompt7",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt7
	)
	default boolean prompt7Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt7Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt7
	)
	default String prompt7Text() { return ""; }

	@ConfigItem(
			keyName = "prompt7Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt7
	)
	default Color prompt7Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt7Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt7
	)
	default String prompt7Times() { return ""; }

	@ConfigItem(
			keyName = "prompt7DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt7
	)
	default String prompt7DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt7Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt7
	)
	default String prompt7Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt7Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt7
	)
	default String prompt7Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt7Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt7
	)
	default String prompt7Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt7Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt7
	)
	default int prompt7Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt7RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt7
	)
	default String prompt7RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt7NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt7
	)
	default String prompt7NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt7ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt7
	)
	default String prompt7ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt7Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt7
	)
	default int prompt7Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt7Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt7
	)
	default int prompt7Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt7TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt7
	)
	default TimeUnit prompt7TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt7ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt7
	)
	default String prompt7ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt7Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt7
	)
	default boolean prompt7Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt7SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt7
	)
	default Location prompt7Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt7panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt7
	)
	default RSAnchorType prompt7PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt7PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt7
	)
	default int prompt7PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt7PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt7
	)
	default int prompt7PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt7ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt7
	)
	default int prompt7ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt7Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt7
	)
	default boolean prompt7Image() { return false; }

	@ConfigItem(
			keyName = "Prompt7ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt7
	)
	default boolean prompt7ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt7PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt7
	)
	default int prompt7PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt7PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt7
	)
	default TextSize prompt7PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt7PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt7
	)
	default Color prompt7PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt7PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt7
	)
	default boolean prompt7PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt7ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt7
	)
	default boolean prompt7ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt7ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt7
	)
	default int prompt7ImageOffset() { return 0; }


	@ConfigSection(
			name = "8",
			description = "Prompt 8",
			position = 28,
			closedByDefault = true
	)
	String prompt8= "prompt8";

	@ConfigItem(
			keyName = "enablePrompt8",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt8
	)
	default boolean prompt8Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt8Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt8
	)
	default String prompt8Text() { return ""; }

	@ConfigItem(
			keyName = "prompt8Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt8
	)
	default Color prompt8Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt8Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt8
	)
	default String prompt8Times() { return ""; }

	@ConfigItem(
			keyName = "prompt8DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt8
	)
	default String prompt8DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt8Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt8
	)
	default String prompt8Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt8Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt8
	)
	default String prompt8Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt8Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt8
	)
	default String prompt8Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt8Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt8
	)
	default int prompt8Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt8RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt8
	)
	default String prompt8RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt8NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt8
	)
	default String prompt8NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt8ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt8
	)
	default String prompt8ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt8Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt8
	)
	default int prompt8Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt8Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt8
	)
	default int prompt8Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt8TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt8
	)
	default TimeUnit prompt8TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt8ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt8
	)
	default String prompt8ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt8Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt8
	)
	default boolean prompt8Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt8SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt8
	)
	default Location prompt8Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt8panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt8
	)
	default RSAnchorType prompt8PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt8PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt8
	)
	default int prompt8PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt8PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt8
	)
	default int prompt8PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt8ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt8
	)
	default int prompt8ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt8Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt8
	)
	default boolean prompt8Image() { return false; }

	@ConfigItem(
			keyName = "Prompt8ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt8
	)
	default boolean prompt8ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt8PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt8
	)
	default int prompt8PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt8PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt8
	)
	default TextSize prompt8PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt8PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt8
	)
	default Color prompt8PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt8PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt8
	)
	default boolean prompt8PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt8ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt8
	)
	default boolean prompt8ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt8ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt8
	)
	default int prompt8ImageOffset() { return 0; }


	@ConfigSection(
			name = "9",
			description = "Prompt 9",
			position = 29,
			closedByDefault = true
	)
	String prompt9= "prompt9";

	@ConfigItem(
			keyName = "enablePrompt9",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt9
	)
	default boolean prompt9Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt9Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt9
	)
	default String prompt9Text() { return ""; }

	@ConfigItem(
			keyName = "prompt9Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt9
	)
	default Color prompt9Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt9Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt9
	)
	default String prompt9Times() { return ""; }

	@ConfigItem(
			keyName = "prompt9DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt9
	)
	default String prompt9DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt9Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt9
	)
	default String prompt9Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt9Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt9
	)
	default String prompt9Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt9Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt9
	)
	default String prompt9Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt9Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt9
	)
	default int prompt9Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt9RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt9
	)
	default String prompt9RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt9NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt9
	)
	default String prompt9NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt9ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt9
	)
	default String prompt9ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt9Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt9
	)
	default int prompt9Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt9Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt9
	)
	default int prompt9Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt9TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt9
	)
	default TimeUnit prompt9TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt9ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt9
	)
	default String prompt9ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt9Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt9
	)
	default boolean prompt9Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt9SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt9
	)
	default Location prompt9Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt9panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt9
	)
	default RSAnchorType prompt9PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt9PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt9
	)
	default int prompt9PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt9PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt9
	)
	default int prompt9PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt9ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt9
	)
	default int prompt9ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt9Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt9
	)
	default boolean prompt9Image() { return false; }

	@ConfigItem(
			keyName = "Prompt9ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt9
	)
	default boolean prompt9ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt9PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt9
	)
	default int prompt9PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt9PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt9
	)
	default TextSize prompt9PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt9PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt9
	)
	default Color prompt9PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt9PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt9
	)
	default boolean prompt9PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt9ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt9
	)
	default boolean prompt9ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt9ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt9
	)
	default int prompt9ImageOffset() { return 0; }


	@ConfigSection(
			name = "10",
			description = "Prompt 10",
			position = 30,
			closedByDefault = true
	)
	String prompt10= "prompt10";

	@ConfigItem(
			keyName = "enablePrompt10",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt10
	)
	default boolean prompt10Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt10Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt10
	)
	default String prompt10Text() { return ""; }

	@ConfigItem(
			keyName = "prompt10Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt10
	)
	default Color prompt10Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt10Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt10
	)
	default String prompt10Times() { return ""; }

	@ConfigItem(
			keyName = "prompt10DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt10
	)
	default String prompt10DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt10Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt10
	)
	default String prompt10Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt10Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt10
	)
	default String prompt10Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt10Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt10
	)
	default String prompt10Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt10Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt10
	)
	default int prompt10Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt10RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt10
	)
	default String prompt10RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt10NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt10
	)
	default String prompt10NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt10ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt10
	)
	default String prompt10ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt10Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt10
	)
	default int prompt10Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt10Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt10
	)
	default int prompt10Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt10TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt10
	)
	default TimeUnit prompt10TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt10ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt10
	)
	default String prompt10ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt10Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt10
	)
	default boolean prompt10Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt10SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt10
	)
	default Location prompt10Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt10panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt10
	)
	default RSAnchorType prompt10PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt10PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt10
	)
	default int prompt10PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt10PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt10
	)
	default int prompt10PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt10ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt10
	)
	default int prompt10ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt10Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt10
	)
	default boolean prompt10Image() { return false; }

	@ConfigItem(
			keyName = "Prompt10ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt10
	)
	default boolean prompt10ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt10PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt10
	)
	default int prompt10PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt10PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt10
	)
	default TextSize prompt10PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt10PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt10
	)
	default Color prompt10PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt10PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt10
	)
	default boolean prompt10PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt10ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt10
	)
	default boolean prompt10ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt10ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt10
	)
	default int prompt10ImageOffset() { return 0; }


	@ConfigSection(
			name = "11",
			description = "Prompt 11",
			position = 31,
			closedByDefault = true
	)
	String prompt11= "prompt11";

	@ConfigItem(
			keyName = "enablePrompt11",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt11
	)
	default boolean prompt11Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt11Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt11
	)
	default String prompt11Text() { return ""; }

	@ConfigItem(
			keyName = "prompt11Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt11
	)
	default Color prompt11Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt11Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt11
	)
	default String prompt11Times() { return ""; }

	@ConfigItem(
			keyName = "prompt11DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt11
	)
	default String prompt11DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt11Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt11
	)
	default String prompt11Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt11Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt11
	)
	default String prompt11Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt11Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt11
	)
	default String prompt11Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt11Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt11
	)
	default int prompt11Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt11RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt11
	)
	default String prompt11RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt11NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt11
	)
	default String prompt11NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt11ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt11
	)
	default String prompt11ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt11Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt11
	)
	default int prompt11Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt11Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt11
	)
	default int prompt11Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt11TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt11
	)
	default TimeUnit prompt11TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt11ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt11
	)
	default String prompt11ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt11Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt11
	)
	default boolean prompt11Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt11SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt11
	)
	default Location prompt11Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt11panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt11
	)
	default RSAnchorType prompt11PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt11PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt11
	)
	default int prompt11PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt11PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt11
	)
	default int prompt11PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt11ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt11
	)
	default int prompt11ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt11Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt11
	)
	default boolean prompt11Image() { return false; }

	@ConfigItem(
			keyName = "Prompt11ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt11
	)
	default boolean prompt11ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt11PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt11
	)
	default int prompt11PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt11PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt11
	)
	default TextSize prompt11PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt11PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt11
	)
	default Color prompt11PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt11PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt11
	)
	default boolean prompt11PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt11ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt11
	)
	default boolean prompt11ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt11ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt11
	)
	default int prompt11ImageOffset() { return 0; }


	@ConfigSection(
			name = "12",
			description = "Prompt 12",
			position = 32,
			closedByDefault = true
	)
	String prompt12= "prompt12";

	@ConfigItem(
			keyName = "enablePrompt12",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt12
	)
	default boolean prompt12Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt12Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt12
	)
	default String prompt12Text() { return ""; }

	@ConfigItem(
			keyName = "prompt12Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt12
	)
	default Color prompt12Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt12Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt12
	)
	default String prompt12Times() { return ""; }

	@ConfigItem(
			keyName = "prompt12DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt12
	)
	default String prompt12DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt12Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt12
	)
	default String prompt12Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt12Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt12
	)
	default String prompt12Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt12Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt12
	)
	default String prompt12Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt12Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt12
	)
	default int prompt12Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt12RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt12
	)
	default String prompt12RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt12NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt12
	)
	default String prompt12NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt12ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt12
	)
	default String prompt12ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt12Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt12
	)
	default int prompt12Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt12Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt12
	)
	default int prompt12Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt12TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt12
	)
	default TimeUnit prompt12TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt12ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt12
	)
	default String prompt12ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt12Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt12
	)
	default boolean prompt12Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt12SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt12
	)
	default Location prompt12Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt12panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt12
	)
	default RSAnchorType prompt12PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt12PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt12
	)
	default int prompt12PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt12PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt12
	)
	default int prompt12PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt12ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt12
	)
	default int prompt12ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt12Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt12
	)
	default boolean prompt12Image() { return false; }

	@ConfigItem(
			keyName = "Prompt12ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt12
	)
	default boolean prompt12ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt12PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt12
	)
	default int prompt12PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt12PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt12
	)
	default TextSize prompt12PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt12PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt12
	)
	default Color prompt12PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt12PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt12
	)
	default boolean prompt12PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt12ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt12
	)
	default boolean prompt12ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt12ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt12
	)
	default int prompt12ImageOffset() { return 0; }


	@ConfigSection(
			name = "13",
			description = "Prompt 13",
			position = 33,
			closedByDefault = true
	)
	String prompt13= "prompt13";

	@ConfigItem(
			keyName = "enablePrompt13",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt13
	)
	default boolean prompt13Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt13Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt13
	)
	default String prompt13Text() { return ""; }

	@ConfigItem(
			keyName = "prompt13Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt13
	)
	default Color prompt13Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt13Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt13
	)
	default String prompt13Times() { return ""; }

	@ConfigItem(
			keyName = "prompt13DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt13
	)
	default String prompt13DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt13Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt13
	)
	default String prompt13Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt13Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt13
	)
	default String prompt13Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt13Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt13
	)
	default String prompt13Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt13Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt13
	)
	default int prompt13Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt13RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt13
	)
	default String prompt13RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt13NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt13
	)
	default String prompt13NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt13ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt13
	)
	default String prompt13ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt13Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt13
	)
	default int prompt13Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt13Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt13
	)
	default int prompt13Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt13TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt13
	)
	default TimeUnit prompt13TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt13ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt13
	)
	default String prompt13ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt13Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt13
	)
	default boolean prompt13Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt13SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt13
	)
	default Location prompt13Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt13panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt13
	)
	default RSAnchorType prompt13PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt13PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt13
	)
	default int prompt13PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt13PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt13
	)
	default int prompt13PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt13ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt13
	)
	default int prompt13ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt13Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt13
	)
	default boolean prompt13Image() { return false; }

	@ConfigItem(
			keyName = "Prompt13ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt13
	)
	default boolean prompt13ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt13PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt13
	)
	default int prompt13PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt13PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt13
	)
	default TextSize prompt13PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt13PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt13
	)
	default Color prompt13PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt13PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt13
	)
	default boolean prompt13PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt13ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt13
	)
	default boolean prompt13ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt13ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt13
	)
	default int prompt13ImageOffset() { return 0; }


	@ConfigSection(
			name = "14",
			description = "Prompt 14",
			position = 34,
			closedByDefault = true
	)
	String prompt14= "prompt14";

	@ConfigItem(
			keyName = "enablePrompt14",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt14
	)
	default boolean prompt14Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt14Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt14
	)
	default String prompt14Text() { return ""; }

	@ConfigItem(
			keyName = "prompt14Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt14
	)
	default Color prompt14Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt14Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt14
	)
	default String prompt14Times() { return ""; }

	@ConfigItem(
			keyName = "prompt14DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt14
	)
	default String prompt14DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt14Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt14
	)
	default String prompt14Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt14Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt14
	)
	default String prompt14Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt14Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt14
	)
	default String prompt14Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt14Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt14
	)
	default int prompt14Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt14RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt14
	)
	default String prompt14RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt14NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt14
	)
	default String prompt14NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt14ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt14
	)
	default String prompt14ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt14Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt14
	)
	default int prompt14Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt14Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt14
	)
	default int prompt14Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt14TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt14
	)
	default TimeUnit prompt14TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt14ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt14
	)
	default String prompt14ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt14Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt14
	)
	default boolean prompt14Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt14SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt14
	)
	default Location prompt14Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt14panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt14
	)
	default RSAnchorType prompt14PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt14PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt14
	)
	default int prompt14PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt14PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt14
	)
	default int prompt14PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt14ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt14
	)
	default int prompt14ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt14Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt14
	)
	default boolean prompt14Image() { return false; }

	@ConfigItem(
			keyName = "Prompt14ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt14
	)
	default boolean prompt14ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt14PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt14
	)
	default int prompt14PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt14PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt14
	)
	default TextSize prompt14PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt14PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt14
	)
	default Color prompt14PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt14PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt14
	)
	default boolean prompt14PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt14ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt14
	)
	default boolean prompt14ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt14ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt14
	)
	default int prompt14ImageOffset() { return 0; }


	@ConfigSection(
			name = "15",
			description = "Prompt 15",
			position = 35,
			closedByDefault = true
	)
	String prompt15= "prompt15";

	@ConfigItem(
			keyName = "enablePrompt15",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt15
	)
	default boolean prompt15Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt15Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt15
	)
	default String prompt15Text() { return ""; }

	@ConfigItem(
			keyName = "prompt15Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt15
	)
	default Color prompt15Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt15Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt15
	)
	default String prompt15Times() { return ""; }

	@ConfigItem(
			keyName = "prompt15DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt15
	)
	default String prompt15DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt15Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt15
	)
	default String prompt15Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt15Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt15
	)
	default String prompt15Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt15Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt15
	)
	default String prompt15Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt15Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt15
	)
	default int prompt15Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt15RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt15
	)
	default String prompt15RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt15NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt15
	)
	default String prompt15NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt15ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt15
	)
	default String prompt15ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt15Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt15
	)
	default int prompt15Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt15Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt15
	)
	default int prompt15Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt15TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt15
	)
	default TimeUnit prompt15TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt15ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt15
	)
	default String prompt15ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt15Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt15
	)
	default boolean prompt15Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt15SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt15
	)
	default Location prompt15Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt15panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt15
	)
	default RSAnchorType prompt15PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt15PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt15
	)
	default int prompt15PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt15PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt15
	)
	default int prompt15PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt15ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt15
	)
	default int prompt15ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt15Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt15
	)
	default boolean prompt15Image() { return false; }

	@ConfigItem(
			keyName = "Prompt15ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt15
	)
	default boolean prompt15ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt15PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt15
	)
	default int prompt15PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt15PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt15
	)
	default TextSize prompt15PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt15PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt15
	)
	default Color prompt15PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt15PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt15
	)
	default boolean prompt15PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt15ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt15
	)
	default boolean prompt15ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt15ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt15
	)
	default int prompt15ImageOffset() { return 0; }


	@ConfigSection(
			name = "16",
			description = "Prompt 16",
			position = 36,
			closedByDefault = true
	)
	String prompt16= "prompt16";

	@ConfigItem(
			keyName = "enablePrompt16",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt16
	)
	default boolean prompt16Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt16Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt16
	)
	default String prompt16Text() { return ""; }

	@ConfigItem(
			keyName = "prompt16Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt16
	)
	default Color prompt16Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt16Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt16
	)
	default String prompt16Times() { return ""; }

	@ConfigItem(
			keyName = "prompt16DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt16
	)
	default String prompt16DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt16Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt16
	)
	default String prompt16Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt16Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt16
	)
	default String prompt16Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt16Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt16
	)
	default String prompt16Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt16Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt16
	)
	default int prompt16Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt16RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt16
	)
	default String prompt16RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt16NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt16
	)
	default String prompt16NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt16ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt16
	)
	default String prompt16ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt16Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt16
	)
	default int prompt16Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt16Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt16
	)
	default int prompt16Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt16TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt16
	)
	default TimeUnit prompt16TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt16ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt16
	)
	default String prompt16ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt16Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt16
	)
	default boolean prompt16Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt16SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt16
	)
	default Location prompt16Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt16panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt16
	)
	default RSAnchorType prompt16PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt16PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt16
	)
	default int prompt16PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt16PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt16
	)
	default int prompt16PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt16ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt16
	)
	default int prompt16ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt16Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt16
	)
	default boolean prompt16Image() { return false; }

	@ConfigItem(
			keyName = "Prompt16ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt16
	)
	default boolean prompt16ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt16PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt16
	)
	default int prompt16PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt16PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt16
	)
	default TextSize prompt16PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt16PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt16
	)
	default Color prompt16PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt16PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt16
	)
	default boolean prompt16PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt16ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt16
	)
	default boolean prompt16ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt16ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt16
	)
	default int prompt16ImageOffset() { return 0; }


	@ConfigSection(
			name = "17",
			description = "Prompt 17",
			position = 37,
			closedByDefault = true
	)
	String prompt17= "prompt17";

	@ConfigItem(
			keyName = "enablePrompt17",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt17
	)
	default boolean prompt17Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt17Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt17
	)
	default String prompt17Text() { return ""; }

	@ConfigItem(
			keyName = "prompt17Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt17
	)
	default Color prompt17Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt17Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt17
	)
	default String prompt17Times() { return ""; }

	@ConfigItem(
			keyName = "prompt17DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt17
	)
	default String prompt17DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt17Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt17
	)
	default String prompt17Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt17Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt17
	)
	default String prompt17Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt17Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt17
	)
	default String prompt17Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt17Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt17
	)
	default int prompt17Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt17RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt17
	)
	default String prompt17RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt17NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt17
	)
	default String prompt17NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt17ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt17
	)
	default String prompt17ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt17Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt17
	)
	default int prompt17Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt17Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt17
	)
	default int prompt17Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt17TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt17
	)
	default TimeUnit prompt17TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt17ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt17
	)
	default String prompt17ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt17Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt17
	)
	default boolean prompt17Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt17SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt17
	)
	default Location prompt17Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt17panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt17
	)
	default RSAnchorType prompt17PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt17PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt17
	)
	default int prompt17PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt17PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt17
	)
	default int prompt17PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt17ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt17
	)
	default int prompt17ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt17Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt17
	)
	default boolean prompt17Image() { return false; }

	@ConfigItem(
			keyName = "Prompt17ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt17
	)
	default boolean prompt17ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt17PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt17
	)
	default int prompt17PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt17PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt17
	)
	default TextSize prompt17PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt17PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt17
	)
	default Color prompt17PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt17PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt17
	)
	default boolean prompt17PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt17ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt17
	)
	default boolean prompt17ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt17ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt17
	)
	default int prompt17ImageOffset() { return 0; }


	@ConfigSection(
			name = "18",
			description = "Prompt 18",
			position = 38,
			closedByDefault = true
	)
	String prompt18= "prompt18";

	@ConfigItem(
			keyName = "enablePrompt18",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt18
	)
	default boolean prompt18Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt18Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt18
	)
	default String prompt18Text() { return ""; }

	@ConfigItem(
			keyName = "prompt18Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt18
	)
	default Color prompt18Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt18Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt18
	)
	default String prompt18Times() { return ""; }

	@ConfigItem(
			keyName = "prompt18DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt18
	)
	default String prompt18DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt18Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt18
	)
	default String prompt18Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt18Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt18
	)
	default String prompt18Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt18Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt18
	)
	default String prompt18Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt18Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt18
	)
	default int prompt18Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt18RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt18
	)
	default String prompt18RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt18NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt18
	)
	default String prompt18NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt18ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt18
	)
	default String prompt18ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt18Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt18
	)
	default int prompt18Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt18Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt18
	)
	default int prompt18Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt18TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt18
	)
	default TimeUnit prompt18TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt18ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt18
	)
	default String prompt18ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt18Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt18
	)
	default boolean prompt18Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt18SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt18
	)
	default Location prompt18Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt18panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt18
	)
	default RSAnchorType prompt18PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt18PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt18
	)
	default int prompt18PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt18PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt18
	)
	default int prompt18PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt18ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt18
	)
	default int prompt18ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt18Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt18
	)
	default boolean prompt18Image() { return false; }

	@ConfigItem(
			keyName = "Prompt18ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt18
	)
	default boolean prompt18ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt18PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt18
	)
	default int prompt18PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt18PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt18
	)
	default TextSize prompt18PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt18PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt18
	)
	default Color prompt18PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt18PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt18
	)
	default boolean prompt18PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt18ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt18
	)
	default boolean prompt18ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt18ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt18
	)
	default int prompt18ImageOffset() { return 0; }


	@ConfigSection(
			name = "19",
			description = "Prompt 19",
			position = 39,
			closedByDefault = true
	)
	String prompt19= "prompt19";

	@ConfigItem(
			keyName = "enablePrompt19",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt19
	)
	default boolean prompt19Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt19Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt19
	)
	default String prompt19Text() { return ""; }

	@ConfigItem(
			keyName = "prompt19Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt19
	)
	default Color prompt19Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt19Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt19
	)
	default String prompt19Times() { return ""; }

	@ConfigItem(
			keyName = "prompt19DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt19
	)
	default String prompt19DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt19Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt19
	)
	default String prompt19Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt19Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt19
	)
	default String prompt19Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt19Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt19
	)
	default String prompt19Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt19Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt19
	)
	default int prompt19Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt19RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt19
	)
	default String prompt19RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt19NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt19
	)
	default String prompt19NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt19ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt19
	)
	default String prompt19ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt19Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt19
	)
	default int prompt19Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt19Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt19
	)
	default int prompt19Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt19TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt19
	)
	default TimeUnit prompt19TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt19ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt19
	)
	default String prompt19ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt19Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt19
	)
	default boolean prompt19Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt19SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt19
	)
	default Location prompt19Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt19panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt19
	)
	default RSAnchorType prompt19PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt19PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt19
	)
	default int prompt19PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt19PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt19
	)
	default int prompt19PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt19ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt19
	)
	default int prompt19ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt19Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt19
	)
	default boolean prompt19Image() { return false; }

	@ConfigItem(
			keyName = "Prompt19ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt19
	)
	default boolean prompt19ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt19PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt19
	)
	default int prompt19PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt19PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt19
	)
	default TextSize prompt19PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt19PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt19
	)
	default Color prompt19PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt19PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt19
	)
	default boolean prompt19PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt19ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt19
	)
	default boolean prompt19ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt19ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt19
	)
	default int prompt19ImageOffset() { return 0; }


	@ConfigSection(
			name = "20",
			description = "Prompt 20",
			position = 40,
			closedByDefault = true
	)
	String prompt20= "prompt20";

	@ConfigItem(
			keyName = "enablePrompt20",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt20
	)
	default boolean prompt20Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt20Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt20
	)
	default String prompt20Text() { return ""; }

	@ConfigItem(
			keyName = "prompt20Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt20
	)
	default Color prompt20Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt20Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt20
	)
	default String prompt20Times() { return ""; }

	@ConfigItem(
			keyName = "prompt20DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt20
	)
	default String prompt20DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt20Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt20
	)
	default String prompt20Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt20Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt20
	)
	default String prompt20Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt20Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt20
	)
	default String prompt20Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt20Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt20
	)
	default int prompt20Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt20RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt20
	)
	default String prompt20RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt20NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt20
	)
	default String prompt20NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt20ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt20
	)
	default String prompt20ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt20Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt20
	)
	default int prompt20Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt20Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt20
	)
	default int prompt20Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt20TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt20
	)
	default TimeUnit prompt20TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt20ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt20
	)
	default String prompt20ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt20Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt20
	)
	default boolean prompt20Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt20SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt20
	)
	default Location prompt20Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt20panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt20
	)
	default RSAnchorType prompt20PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt20PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt20
	)
	default int prompt20PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt20PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt20
	)
	default int prompt20PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt20ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt20
	)
	default int prompt20ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt20Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt20
	)
	default boolean prompt20Image() { return false; }

	@ConfigItem(
			keyName = "Prompt20ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt20
	)
	default boolean prompt20ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt20PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt20
	)
	default int prompt20PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt20PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt20
	)
	default TextSize prompt20PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt20PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt20
	)
	default Color prompt20PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt20PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt20
	)
	default boolean prompt20PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt20ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt20
	)
	default boolean prompt20ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt20ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt20
	)
	default int prompt20ImageOffset() { return 0; }


	@ConfigSection(
			name = "21",
			description = "Prompt 21",
			position = 41,
			closedByDefault = true
	)
	String prompt21= "prompt21";

	@ConfigItem(
			keyName = "enablePrompt21",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt21
	)
	default boolean prompt21Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt21Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt21
	)
	default String prompt21Text() { return ""; }

	@ConfigItem(
			keyName = "prompt21Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt21
	)
	default Color prompt21Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt21Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt21
	)
	default String prompt21Times() { return ""; }

	@ConfigItem(
			keyName = "prompt21DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt21
	)
	default String prompt21DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt21Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt21
	)
	default String prompt21Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt21Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt21
	)
	default String prompt21Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt21Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt21
	)
	default String prompt21Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt21Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt21
	)
	default int prompt21Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt21RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt21
	)
	default String prompt21RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt21NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt21
	)
	default String prompt21NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt21ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt21
	)
	default String prompt21ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt21Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt21
	)
	default int prompt21Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt21Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt21
	)
	default int prompt21Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt21TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt21
	)
	default TimeUnit prompt21TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt21ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt21
	)
	default String prompt21ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt21Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt21
	)
	default boolean prompt21Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt21SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt21
	)
	default Location prompt21Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt21panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt21
	)
	default RSAnchorType prompt21PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt21PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt21
	)
	default int prompt21PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt21PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt21
	)
	default int prompt21PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt21ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt21
	)
	default int prompt21ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt21Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt21
	)
	default boolean prompt21Image() { return false; }

	@ConfigItem(
			keyName = "Prompt21ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt21
	)
	default boolean prompt21ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt21PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt21
	)
	default int prompt21PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt21PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt21
	)
	default TextSize prompt21PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt21PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt21
	)
	default Color prompt21PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt21PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt21
	)
	default boolean prompt21PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt21ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt21
	)
	default boolean prompt21ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt21ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt21
	)
	default int prompt21ImageOffset() { return 0; }


	@ConfigSection(
			name = "22",
			description = "Prompt 22",
			position = 42,
			closedByDefault = true
	)
	String prompt22= "prompt22";

	@ConfigItem(
			keyName = "enablePrompt22",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt22
	)
	default boolean prompt22Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt22Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt22
	)
	default String prompt22Text() { return ""; }

	@ConfigItem(
			keyName = "prompt22Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt22
	)
	default Color prompt22Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt22Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt22
	)
	default String prompt22Times() { return ""; }

	@ConfigItem(
			keyName = "prompt22DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt22
	)
	default String prompt22DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt22Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt22
	)
	default String prompt22Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt22Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt22
	)
	default String prompt22Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt22Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt22
	)
	default String prompt22Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt22Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt22
	)
	default int prompt22Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt22RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt22
	)
	default String prompt22RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt22NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt22
	)
	default String prompt22NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt22ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt22
	)
	default String prompt22ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt22Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt22
	)
	default int prompt22Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt22Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt22
	)
	default int prompt22Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt22TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt22
	)
	default TimeUnit prompt22TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt22ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt22
	)
	default String prompt22ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt22Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt22
	)
	default boolean prompt22Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt22SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt22
	)
	default Location prompt22Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt22panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt22
	)
	default RSAnchorType prompt22PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt22PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt22
	)
	default int prompt22PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt22PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt22
	)
	default int prompt22PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt22ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt22
	)
	default int prompt22ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt22Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt22
	)
	default boolean prompt22Image() { return false; }

	@ConfigItem(
			keyName = "Prompt22ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt22
	)
	default boolean prompt22ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt22PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt22
	)
	default int prompt22PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt22PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt22
	)
	default TextSize prompt22PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt22PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt22
	)
	default Color prompt22PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt22PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt22
	)
	default boolean prompt22PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt22ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt22
	)
	default boolean prompt22ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt22ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt22
	)
	default int prompt22ImageOffset() { return 0; }


	@ConfigSection(
			name = "23",
			description = "Prompt 23",
			position = 43,
			closedByDefault = true
	)
	String prompt23= "prompt23";

	@ConfigItem(
			keyName = "enablePrompt23",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt23
	)
	default boolean prompt23Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt23Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt23
	)
	default String prompt23Text() { return ""; }

	@ConfigItem(
			keyName = "prompt23Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt23
	)
	default Color prompt23Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt23Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt23
	)
	default String prompt23Times() { return ""; }

	@ConfigItem(
			keyName = "prompt23DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt23
	)
	default String prompt23DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt23Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt23
	)
	default String prompt23Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt23Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt23
	)
	default String prompt23Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt23Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt23
	)
	default String prompt23Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt23Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt23
	)
	default int prompt23Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt23RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt23
	)
	default String prompt23RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt23NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt23
	)
	default String prompt23NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt23ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt23
	)
	default String prompt23ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt23Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt23
	)
	default int prompt23Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt23Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt23
	)
	default int prompt23Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt23TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt23
	)
	default TimeUnit prompt23TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt23ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt23
	)
	default String prompt23ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt23Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt23
	)
	default boolean prompt23Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt23SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt23
	)
	default Location prompt23Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt23panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt23
	)
	default RSAnchorType prompt23PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt23PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt23
	)
	default int prompt23PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt23PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt23
	)
	default int prompt23PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt23ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt23
	)
	default int prompt23ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt23Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt23
	)
	default boolean prompt23Image() { return false; }

	@ConfigItem(
			keyName = "Prompt23ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt23
	)
	default boolean prompt23ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt23PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt23
	)
	default int prompt23PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt23PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt23
	)
	default TextSize prompt23PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt23PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt23
	)
	default Color prompt23PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt23PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt23
	)
	default boolean prompt23PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt23ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt23
	)
	default boolean prompt23ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt23ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt23
	)
	default int prompt23ImageOffset() { return 0; }


	@ConfigSection(
			name = "24",
			description = "Prompt 24",
			position = 44,
			closedByDefault = true
	)
	String prompt24= "prompt24";

	@ConfigItem(
			keyName = "enablePrompt24",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt24
	)
	default boolean prompt24Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt24Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt24
	)
	default String prompt24Text() { return ""; }

	@ConfigItem(
			keyName = "prompt24Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt24
	)
	default Color prompt24Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt24Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt24
	)
	default String prompt24Times() { return ""; }

	@ConfigItem(
			keyName = "prompt24DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt24
	)
	default String prompt24DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt24Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt24
	)
	default String prompt24Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt24Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt24
	)
	default String prompt24Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt24Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt24
	)
	default String prompt24Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt24Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt24
	)
	default int prompt24Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt24RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt24
	)
	default String prompt24RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt24NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt24
	)
	default String prompt24NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt24ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt24
	)
	default String prompt24ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt24Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt24
	)
	default int prompt24Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt24Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt24
	)
	default int prompt24Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt24TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt24
	)
	default TimeUnit prompt24TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt24ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt24
	)
	default String prompt24ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt24Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt24
	)
	default boolean prompt24Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt24SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt24
	)
	default Location prompt24Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt24panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt24
	)
	default RSAnchorType prompt24PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt24PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt24
	)
	default int prompt24PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt24PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt24
	)
	default int prompt24PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt24ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt24
	)
	default int prompt24ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt24Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt24
	)
	default boolean prompt24Image() { return false; }

	@ConfigItem(
			keyName = "Prompt24ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt24
	)
	default boolean prompt24ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt24PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt24
	)
	default int prompt24PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt24PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt24
	)
	default TextSize prompt24PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt24PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt24
	)
	default Color prompt24PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt24PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt24
	)
	default boolean prompt24PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt24ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt24
	)
	default boolean prompt24ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt24ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt24
	)
	default int prompt24ImageOffset() { return 0; }


	@ConfigSection(
			name = "25",
			description = "Prompt 25",
			position = 45,
			closedByDefault = true
	)
	String prompt25= "prompt25";

	@ConfigItem(
			keyName = "enablePrompt25",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt25
	)
	default boolean prompt25Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt25Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt25
	)
	default String prompt25Text() { return ""; }

	@ConfigItem(
			keyName = "prompt25Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt25
	)
	default Color prompt25Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt25Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt25
	)
	default String prompt25Times() { return ""; }

	@ConfigItem(
			keyName = "prompt25DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt25
	)
	default String prompt25DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt25Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt25
	)
	default String prompt25Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt25Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt25
	)
	default String prompt25Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt25Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt25
	)
	default String prompt25Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt25Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt25
	)
	default int prompt25Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt25RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt25
	)
	default String prompt25RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt25NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt25
	)
	default String prompt25NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt25ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt25
	)
	default String prompt25ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt25Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt25
	)
	default int prompt25Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt25Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt25
	)
	default int prompt25Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt25TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt25
	)
	default TimeUnit prompt25TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt25ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt25
	)
	default String prompt25ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt25Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt25
	)
	default boolean prompt25Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt25SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt25
	)
	default Location prompt25Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt25panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt25
	)
	default RSAnchorType prompt25PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt25PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt25
	)
	default int prompt25PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt25PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt25
	)
	default int prompt25PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt25ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt25
	)
	default int prompt25ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt25Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt25
	)
	default boolean prompt25Image() { return false; }

	@ConfigItem(
			keyName = "Prompt25ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt25
	)
	default boolean prompt25ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt25PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt25
	)
	default int prompt25PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt25PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt25
	)
	default TextSize prompt25PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt25PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt25
	)
	default Color prompt25PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt25PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt25
	)
	default boolean prompt25PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt25ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt25
	)
	default boolean prompt25ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt25ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt25
	)
	default int prompt25ImageOffset() { return 0; }


	@ConfigSection(
			name = "26",
			description = "Prompt 26",
			position = 46,
			closedByDefault = true
	)
	String prompt26= "prompt26";

	@ConfigItem(
			keyName = "enablePrompt26",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt26
	)
	default boolean prompt26Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt26Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt26
	)
	default String prompt26Text() { return ""; }

	@ConfigItem(
			keyName = "prompt26Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt26
	)
	default Color prompt26Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt26Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt26
	)
	default String prompt26Times() { return ""; }

	@ConfigItem(
			keyName = "prompt26DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt26
	)
	default String prompt26DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt26Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt26
	)
	default String prompt26Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt26Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt26
	)
	default String prompt26Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt26Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt26
	)
	default String prompt26Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt26Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt26
	)
	default int prompt26Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt26RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt26
	)
	default String prompt26RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt26NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt26
	)
	default String prompt26NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt26ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt26
	)
	default String prompt26ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt26Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt26
	)
	default int prompt26Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt26Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt26
	)
	default int prompt26Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt26TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt26
	)
	default TimeUnit prompt26TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt26ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt26
	)
	default String prompt26ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt26Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt26
	)
	default boolean prompt26Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt26SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt26
	)
	default Location prompt26Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt26panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt26
	)
	default RSAnchorType prompt26PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt26PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt26
	)
	default int prompt26PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt26PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt26
	)
	default int prompt26PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt26ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt26
	)
	default int prompt26ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt26Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt26
	)
	default boolean prompt26Image() { return false; }

	@ConfigItem(
			keyName = "Prompt26ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt26
	)
	default boolean prompt26ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt26PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt26
	)
	default int prompt26PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt26PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt26
	)
	default TextSize prompt26PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt26PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt26
	)
	default Color prompt26PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt26PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt26
	)
	default boolean prompt26PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt26ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt26
	)
	default boolean prompt26ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt26ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt26
	)
	default int prompt26ImageOffset() { return 0; }


	@ConfigSection(
			name = "27",
			description = "Prompt 27",
			position = 47,
			closedByDefault = true
	)
	String prompt27= "prompt27";

	@ConfigItem(
			keyName = "enablePrompt27",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt27
	)
	default boolean prompt27Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt27Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt27
	)
	default String prompt27Text() { return ""; }

	@ConfigItem(
			keyName = "prompt27Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt27
	)
	default Color prompt27Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt27Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt27
	)
	default String prompt27Times() { return ""; }

	@ConfigItem(
			keyName = "prompt27DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt27
	)
	default String prompt27DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt27Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt27
	)
	default String prompt27Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt27Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt27
	)
	default String prompt27Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt27Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt27
	)
	default String prompt27Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt27Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt27
	)
	default int prompt27Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt27RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt27
	)
	default String prompt27RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt27NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt27
	)
	default String prompt27NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt27ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt27
	)
	default String prompt27ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt27Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt27
	)
	default int prompt27Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt27Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt27
	)
	default int prompt27Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt27TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt27
	)
	default TimeUnit prompt27TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt27ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt27
	)
	default String prompt27ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt27Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt27
	)
	default boolean prompt27Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt27SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt27
	)
	default Location prompt27Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt27panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt27
	)
	default RSAnchorType prompt27PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt27PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt27
	)
	default int prompt27PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt27PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt27
	)
	default int prompt27PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt27ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt27
	)
	default int prompt27ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt27Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt27
	)
	default boolean prompt27Image() { return false; }

	@ConfigItem(
			keyName = "Prompt27ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt27
	)
	default boolean prompt27ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt27PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt27
	)
	default int prompt27PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt27PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt27
	)
	default TextSize prompt27PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt27PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt27
	)
	default Color prompt27PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt27PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt27
	)
	default boolean prompt27PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt27ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt27
	)
	default boolean prompt27ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt27ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt27
	)
	default int prompt27ImageOffset() { return 0; }


	@ConfigSection(
			name = "28",
			description = "Prompt 28",
			position = 48,
			closedByDefault = true
	)
	String prompt28= "prompt28";

	@ConfigItem(
			keyName = "enablePrompt28",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt28
	)
	default boolean prompt28Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt28Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt28
	)
	default String prompt28Text() { return ""; }

	@ConfigItem(
			keyName = "prompt28Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt28
	)
	default Color prompt28Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt28Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt28
	)
	default String prompt28Times() { return ""; }

	@ConfigItem(
			keyName = "prompt28DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt28
	)
	default String prompt28DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt28Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt28
	)
	default String prompt28Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt28Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt28
	)
	default String prompt28Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt28Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt28
	)
	default String prompt28Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt28Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt28
	)
	default int prompt28Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt28RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt28
	)
	default String prompt28RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt28NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt28
	)
	default String prompt28NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt28ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt28
	)
	default String prompt28ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt28Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt28
	)
	default int prompt28Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt28Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt28
	)
	default int prompt28Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt28TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt28
	)
	default TimeUnit prompt28TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt28ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt28
	)
	default String prompt28ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt28Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt28
	)
	default boolean prompt28Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt28SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt28
	)
	default Location prompt28Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt28panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt28
	)
	default RSAnchorType prompt28PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt28PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt28
	)
	default int prompt28PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt28PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt28
	)
	default int prompt28PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt28ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt28
	)
	default int prompt28ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt28Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt28
	)
	default boolean prompt28Image() { return false; }

	@ConfigItem(
			keyName = "Prompt28ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt28
	)
	default boolean prompt28ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt28PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt28
	)
	default int prompt28PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt28PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt28
	)
	default TextSize prompt28PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt28PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt28
	)
	default Color prompt28PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt28PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt28
	)
	default boolean prompt28PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt28ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt28
	)
	default boolean prompt28ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt28ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt28
	)
	default int prompt28ImageOffset() { return 0; }


	@ConfigSection(
			name = "29",
			description = "Prompt 29",
			position = 49,
			closedByDefault = true
	)
	String prompt29= "prompt29";

	@ConfigItem(
			keyName = "enablePrompt29",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt29
	)
	default boolean prompt29Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt29Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt29
	)
	default String prompt29Text() { return ""; }

	@ConfigItem(
			keyName = "prompt29Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt29
	)
	default Color prompt29Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt29Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt29
	)
	default String prompt29Times() { return ""; }

	@ConfigItem(
			keyName = "prompt29DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt29
	)
	default String prompt29DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt29Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt29
	)
	default String prompt29Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt29Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt29
	)
	default String prompt29Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt29Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt29
	)
	default String prompt29Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt29Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt29
	)
	default int prompt29Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt29RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt29
	)
	default String prompt29RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt29NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt29
	)
	default String prompt29NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt29ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt29
	)
	default String prompt29ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt29Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt29
	)
	default int prompt29Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt29Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt29
	)
	default int prompt29Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt29TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt29
	)
	default TimeUnit prompt29TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt29ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt29
	)
	default String prompt29ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt29Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt29
	)
	default boolean prompt29Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt29SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt29
	)
	default Location prompt29Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt29panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt29
	)
	default RSAnchorType prompt29PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt29PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt29
	)
	default int prompt29PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt29PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt29
	)
	default int prompt29PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt29ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt29
	)
	default int prompt29ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt29Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt29
	)
	default boolean prompt29Image() { return false; }

	@ConfigItem(
			keyName = "Prompt29ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt29
	)
	default boolean prompt29ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt29PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt29
	)
	default int prompt29PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt29PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt29
	)
	default TextSize prompt29PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt29PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt29
	)
	default Color prompt29PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt29PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt29
	)
	default boolean prompt29PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt29ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt29
	)
	default boolean prompt29ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt29ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt29
	)
	default int prompt29ImageOffset() { return 0; }


	@ConfigSection(
			name = "30",
			description = "Prompt 30",
			position = 50,
			closedByDefault = true
	)
	String prompt30= "prompt30";

	@ConfigItem(
			keyName = "enablePrompt30",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt30
	)
	default boolean prompt30Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt30Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt30
	)
	default String prompt30Text() { return ""; }

	@ConfigItem(
			keyName = "prompt30Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt30
	)
	default Color prompt30Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt30Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt30
	)
	default String prompt30Times() { return ""; }

	@ConfigItem(
			keyName = "prompt30DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt30
	)
	default String prompt30DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt30Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt30
	)
	default String prompt30Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt30Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt30
	)
	default String prompt30Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt30Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt30
	)
	default String prompt30Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt30Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt30
	)
	default int prompt30Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt30RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt30
	)
	default String prompt30RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt30NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt30
	)
	default String prompt30NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt30ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt30
	)
	default String prompt30ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt30Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt30
	)
	default int prompt30Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt30Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt30
	)
	default int prompt30Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt30TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt30
	)
	default TimeUnit prompt30TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt30ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt30
	)
	default String prompt30ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt30Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt30
	)
	default boolean prompt30Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt30SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt30
	)
	default Location prompt30Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt30panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt30
	)
	default RSAnchorType prompt30PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt30PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt30
	)
	default int prompt30PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt30PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt30
	)
	default int prompt30PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt30ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt30
	)
	default int prompt30ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt30Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt30
	)
	default boolean prompt30Image() { return false; }

	@ConfigItem(
			keyName = "Prompt30ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt30
	)
	default boolean prompt30ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt30PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt30
	)
	default int prompt30PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt30PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt30
	)
	default TextSize prompt30PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt30PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt30
	)
	default Color prompt30PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt30PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt30
	)
	default boolean prompt30PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt30ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt30
	)
	default boolean prompt30ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt30ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt30
	)
	default int prompt30ImageOffset() { return 0; }


	@ConfigSection(
			name = "31",
			description = "Prompt 31",
			position = 51,
			closedByDefault = true
	)
	String prompt31= "prompt31";

	@ConfigItem(
			keyName = "enablePrompt31",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt31
	)
	default boolean prompt31Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt31Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt31
	)
	default String prompt31Text() { return ""; }

	@ConfigItem(
			keyName = "prompt31Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt31
	)
	default Color prompt31Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt31Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt31
	)
	default String prompt31Times() { return ""; }

	@ConfigItem(
			keyName = "prompt31DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt31
	)
	default String prompt31DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt31Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt31
	)
	default String prompt31Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt31Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt31
	)
	default String prompt31Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt31Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt31
	)
	default String prompt31Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt31Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt31
	)
	default int prompt31Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt31RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt31
	)
	default String prompt31RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt31NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt31
	)
	default String prompt31NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt31ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt31
	)
	default String prompt31ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt31Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt31
	)
	default int prompt31Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt31Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt31
	)
	default int prompt31Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt31TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt31
	)
	default TimeUnit prompt31TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt31ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt31
	)
	default String prompt31ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt31Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt31
	)
	default boolean prompt31Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt31SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt31
	)
	default Location prompt31Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt31panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt31
	)
	default RSAnchorType prompt31PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt31PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt31
	)
	default int prompt31PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt31PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt31
	)
	default int prompt31PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt31ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt31
	)
	default int prompt31ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt31Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt31
	)
	default boolean prompt31Image() { return false; }

	@ConfigItem(
			keyName = "Prompt31ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt31
	)
	default boolean prompt31ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt31PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt31
	)
	default int prompt31PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt31PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt31
	)
	default TextSize prompt31PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt31PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt31
	)
	default Color prompt31PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt31PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt31
	)
	default boolean prompt31PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt31ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt31
	)
	default boolean prompt31ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt31ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt31
	)
	default int prompt31ImageOffset() { return 0; }


	@ConfigSection(
			name = "32",
			description = "Prompt 32",
			position = 52,
			closedByDefault = true
	)
	String prompt32= "prompt32";

	@ConfigItem(
			keyName = "enablePrompt32",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt32
	)
	default boolean prompt32Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt32Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt32
	)
	default String prompt32Text() { return ""; }

	@ConfigItem(
			keyName = "prompt32Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt32
	)
	default Color prompt32Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt32Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt32
	)
	default String prompt32Times() { return ""; }

	@ConfigItem(
			keyName = "prompt32DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt32
	)
	default String prompt32DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt32Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt32
	)
	default String prompt32Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt32Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt32
	)
	default String prompt32Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt32Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt32
	)
	default String prompt32Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt32Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt32
	)
	default int prompt32Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt32RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt32
	)
	default String prompt32RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt32NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt32
	)
	default String prompt32NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt32ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt32
	)
	default String prompt32ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt32Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt32
	)
	default int prompt32Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt32Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt32
	)
	default int prompt32Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt32TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt32
	)
	default TimeUnit prompt32TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt32ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt32
	)
	default String prompt32ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt32Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt32
	)
	default boolean prompt32Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt32SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt32
	)
	default Location prompt32Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt32panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt32
	)
	default RSAnchorType prompt32PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt32PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt32
	)
	default int prompt32PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt32PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt32
	)
	default int prompt32PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt32ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt32
	)
	default int prompt32ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt32Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt32
	)
	default boolean prompt32Image() { return false; }

	@ConfigItem(
			keyName = "Prompt32ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt32
	)
	default boolean prompt32ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt32PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt32
	)
	default int prompt32PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt32PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt32
	)
	default TextSize prompt32PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt32PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt32
	)
	default Color prompt32PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt32PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt32
	)
	default boolean prompt32PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt32ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt32
	)
	default boolean prompt32ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt32ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt32
	)
	default int prompt32ImageOffset() { return 0; }


	@ConfigSection(
			name = "33",
			description = "Prompt 33",
			position = 53,
			closedByDefault = true
	)
	String prompt33= "prompt33";

	@ConfigItem(
			keyName = "enablePrompt33",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt33
	)
	default boolean prompt33Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt33Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt33
	)
	default String prompt33Text() { return ""; }

	@ConfigItem(
			keyName = "prompt33Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt33
	)
	default Color prompt33Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt33Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt33
	)
	default String prompt33Times() { return ""; }

	@ConfigItem(
			keyName = "prompt33DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt33
	)
	default String prompt33DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt33Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt33
	)
	default String prompt33Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt33Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt33
	)
	default String prompt33Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt33Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt33
	)
	default String prompt33Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt33Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt33
	)
	default int prompt33Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt33RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt33
	)
	default String prompt33RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt33NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt33
	)
	default String prompt33NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt33ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt33
	)
	default String prompt33ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt33Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt33
	)
	default int prompt33Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt33Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt33
	)
	default int prompt33Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt33TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt33
	)
	default TimeUnit prompt33TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt33ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt33
	)
	default String prompt33ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt33Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt33
	)
	default boolean prompt33Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt33SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt33
	)
	default Location prompt33Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt33panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt33
	)
	default RSAnchorType prompt33PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt33PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt33
	)
	default int prompt33PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt33PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt33
	)
	default int prompt33PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt33ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt33
	)
	default int prompt33ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt33Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt33
	)
	default boolean prompt33Image() { return false; }

	@ConfigItem(
			keyName = "Prompt33ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt33
	)
	default boolean prompt33ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt33PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt33
	)
	default int prompt33PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt33PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt33
	)
	default TextSize prompt33PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt33PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt33
	)
	default Color prompt33PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt33PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt33
	)
	default boolean prompt33PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt33ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt33
	)
	default boolean prompt33ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt33ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt33
	)
	default int prompt33ImageOffset() { return 0; }


	@ConfigSection(
			name = "34",
			description = "Prompt 34",
			position = 54,
			closedByDefault = true
	)
	String prompt34= "prompt34";

	@ConfigItem(
			keyName = "enablePrompt34",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt34
	)
	default boolean prompt34Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt34Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt34
	)
	default String prompt34Text() { return ""; }

	@ConfigItem(
			keyName = "prompt34Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt34
	)
	default Color prompt34Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt34Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt34
	)
	default String prompt34Times() { return ""; }

	@ConfigItem(
			keyName = "prompt34DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt34
	)
	default String prompt34DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt34Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt34
	)
	default String prompt34Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt34Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt34
	)
	default String prompt34Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt34Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt34
	)
	default String prompt34Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt34Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt34
	)
	default int prompt34Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt34RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt34
	)
	default String prompt34RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt34NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt34
	)
	default String prompt34NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt34ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt34
	)
	default String prompt34ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt34Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt34
	)
	default int prompt34Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt34Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt34
	)
	default int prompt34Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt34TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt34
	)
	default TimeUnit prompt34TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt34ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt34
	)
	default String prompt34ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt34Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt34
	)
	default boolean prompt34Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt34SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt34
	)
	default Location prompt34Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt34panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt34
	)
	default RSAnchorType prompt34PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt34PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt34
	)
	default int prompt34PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt34PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt34
	)
	default int prompt34PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt34ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt34
	)
	default int prompt34ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt34Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt34
	)
	default boolean prompt34Image() { return false; }

	@ConfigItem(
			keyName = "Prompt34ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt34
	)
	default boolean prompt34ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt34PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt34
	)
	default int prompt34PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt34PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt34
	)
	default TextSize prompt34PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt34PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt34
	)
	default Color prompt34PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt34PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt34
	)
	default boolean prompt34PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt34ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt34
	)
	default boolean prompt34ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt34ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt34
	)
	default int prompt34ImageOffset() { return 0; }


	@ConfigSection(
			name = "35",
			description = "Prompt 35",
			position = 55,
			closedByDefault = true
	)
	String prompt35= "prompt35";

	@ConfigItem(
			keyName = "enablePrompt35",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt35
	)
	default boolean prompt35Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt35Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt35
	)
	default String prompt35Text() { return ""; }

	@ConfigItem(
			keyName = "prompt35Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt35
	)
	default Color prompt35Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt35Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt35
	)
	default String prompt35Times() { return ""; }

	@ConfigItem(
			keyName = "prompt35DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt35
	)
	default String prompt35DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt35Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt35
	)
	default String prompt35Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt35Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt35
	)
	default String prompt35Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt35Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt35
	)
	default String prompt35Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt35Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt35
	)
	default int prompt35Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt35RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt35
	)
	default String prompt35RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt35NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt35
	)
	default String prompt35NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt35ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt35
	)
	default String prompt35ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt35Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt35
	)
	default int prompt35Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt35Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt35
	)
	default int prompt35Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt35TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt35
	)
	default TimeUnit prompt35TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt35ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt35
	)
	default String prompt35ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt35Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt35
	)
	default boolean prompt35Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt35SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt35
	)
	default Location prompt35Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt35panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt35
	)
	default RSAnchorType prompt35PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt35PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt35
	)
	default int prompt35PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt35PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt35
	)
	default int prompt35PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt35ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt35
	)
	default int prompt35ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt35Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt35
	)
	default boolean prompt35Image() { return false; }

	@ConfigItem(
			keyName = "Prompt35ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt35
	)
	default boolean prompt35ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt35PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt35
	)
	default int prompt35PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt35PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt35
	)
	default TextSize prompt35PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt35PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt35
	)
	default Color prompt35PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt35PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt35
	)
	default boolean prompt35PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt35ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt35
	)
	default boolean prompt35ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt35ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt35
	)
	default int prompt35ImageOffset() { return 0; }


	@ConfigSection(
			name = "36",
			description = "Prompt 36",
			position = 56,
			closedByDefault = true
	)
	String prompt36= "prompt36";

	@ConfigItem(
			keyName = "enablePrompt36",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt36
	)
	default boolean prompt36Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt36Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt36
	)
	default String prompt36Text() { return ""; }

	@ConfigItem(
			keyName = "prompt36Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt36
	)
	default Color prompt36Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt36Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt36
	)
	default String prompt36Times() { return ""; }

	@ConfigItem(
			keyName = "prompt36DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt36
	)
	default String prompt36DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt36Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt36
	)
	default String prompt36Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt36Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt36
	)
	default String prompt36Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt36Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt36
	)
	default String prompt36Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt36Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt36
	)
	default int prompt36Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt36RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt36
	)
	default String prompt36RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt36NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt36
	)
	default String prompt36NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt36ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt36
	)
	default String prompt36ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt36Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt36
	)
	default int prompt36Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt36Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt36
	)
	default int prompt36Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt36TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt36
	)
	default TimeUnit prompt36TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt36ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt36
	)
	default String prompt36ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt36Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt36
	)
	default boolean prompt36Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt36SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt36
	)
	default Location prompt36Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt36panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt36
	)
	default RSAnchorType prompt36PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt36PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt36
	)
	default int prompt36PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt36PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt36
	)
	default int prompt36PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt36ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt36
	)
	default int prompt36ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt36Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt36
	)
	default boolean prompt36Image() { return false; }

	@ConfigItem(
			keyName = "Prompt36ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt36
	)
	default boolean prompt36ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt36PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt36
	)
	default int prompt36PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt36PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt36
	)
	default TextSize prompt36PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt36PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt36
	)
	default Color prompt36PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt36PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt36
	)
	default boolean prompt36PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt36ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt36
	)
	default boolean prompt36ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt36ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt36
	)
	default int prompt36ImageOffset() { return 0; }


	@ConfigSection(
			name = "37",
			description = "Prompt 37",
			position = 57,
			closedByDefault = true
	)
	String prompt37= "prompt37";

	@ConfigItem(
			keyName = "enablePrompt37",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt37
	)
	default boolean prompt37Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt37Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt37
	)
	default String prompt37Text() { return ""; }

	@ConfigItem(
			keyName = "prompt37Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt37
	)
	default Color prompt37Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt37Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt37
	)
	default String prompt37Times() { return ""; }

	@ConfigItem(
			keyName = "prompt37DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt37
	)
	default String prompt37DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt37Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt37
	)
	default String prompt37Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt37Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt37
	)
	default String prompt37Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt37Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt37
	)
	default String prompt37Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt37Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt37
	)
	default int prompt37Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt37RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt37
	)
	default String prompt37RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt37NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt37
	)
	default String prompt37NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt37ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt37
	)
	default String prompt37ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt37Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt37
	)
	default int prompt37Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt37Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt37
	)
	default int prompt37Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt37TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt37
	)
	default TimeUnit prompt37TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt37ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt37
	)
	default String prompt37ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt37Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt37
	)
	default boolean prompt37Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt37SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt37
	)
	default Location prompt37Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt37panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt37
	)
	default RSAnchorType prompt37PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt37PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt37
	)
	default int prompt37PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt37PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt37
	)
	default int prompt37PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt37ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt37
	)
	default int prompt37ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt37Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt37
	)
	default boolean prompt37Image() { return false; }

	@ConfigItem(
			keyName = "Prompt37ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt37
	)
	default boolean prompt37ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt37PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt37
	)
	default int prompt37PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt37PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt37
	)
	default TextSize prompt37PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt37PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt37
	)
	default Color prompt37PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt37PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt37
	)
	default boolean prompt37PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt37ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt37
	)
	default boolean prompt37ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt37ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt37
	)
	default int prompt37ImageOffset() { return 0; }


	@ConfigSection(
			name = "38",
			description = "Prompt 38",
			position = 58,
			closedByDefault = true
	)
	String prompt38= "prompt38";

	@ConfigItem(
			keyName = "enablePrompt38",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt38
	)
	default boolean prompt38Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt38Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt38
	)
	default String prompt38Text() { return ""; }

	@ConfigItem(
			keyName = "prompt38Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt38
	)
	default Color prompt38Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt38Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt38
	)
	default String prompt38Times() { return ""; }

	@ConfigItem(
			keyName = "prompt38DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt38
	)
	default String prompt38DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt38Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt38
	)
	default String prompt38Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt38Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt38
	)
	default String prompt38Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt38Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt38
	)
	default String prompt38Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt38Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt38
	)
	default int prompt38Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt38RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt38
	)
	default String prompt38RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt38NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt38
	)
	default String prompt38NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt38ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt38
	)
	default String prompt38ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt38Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt38
	)
	default int prompt38Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt38Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt38
	)
	default int prompt38Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt38TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt38
	)
	default TimeUnit prompt38TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt38ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt38
	)
	default String prompt38ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt38Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt38
	)
	default boolean prompt38Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt38SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt38
	)
	default Location prompt38Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt38panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt38
	)
	default RSAnchorType prompt38PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt38PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt38
	)
	default int prompt38PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt38PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt38
	)
	default int prompt38PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt38ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt38
	)
	default int prompt38ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt38Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt38
	)
	default boolean prompt38Image() { return false; }

	@ConfigItem(
			keyName = "Prompt38ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt38
	)
	default boolean prompt38ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt38PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt38
	)
	default int prompt38PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt38PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt38
	)
	default TextSize prompt38PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt38PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt38
	)
	default Color prompt38PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt38PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt38
	)
	default boolean prompt38PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt38ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt38
	)
	default boolean prompt38ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt38ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt38
	)
	default int prompt38ImageOffset() { return 0; }


	@ConfigSection(
			name = "39",
			description = "Prompt 39",
			position = 59,
			closedByDefault = true
	)
	String prompt39= "prompt39";

	@ConfigItem(
			keyName = "enablePrompt39",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt39
	)
	default boolean prompt39Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt39Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt39
	)
	default String prompt39Text() { return ""; }

	@ConfigItem(
			keyName = "prompt39Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt39
	)
	default Color prompt39Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt39Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt39
	)
	default String prompt39Times() { return ""; }

	@ConfigItem(
			keyName = "prompt39DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt39
	)
	default String prompt39DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt39Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt39
	)
	default String prompt39Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt39Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt39
	)
	default String prompt39Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt39Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt39
	)
	default String prompt39Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt39Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt39
	)
	default int prompt39Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt39RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt39
	)
	default String prompt39RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt39NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt39
	)
	default String prompt39NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt39ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt39
	)
	default String prompt39ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt39Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt39
	)
	default int prompt39Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt39Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt39
	)
	default int prompt39Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt39TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt39
	)
	default TimeUnit prompt39TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt39ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt39
	)
	default String prompt39ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt39Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt39
	)
	default boolean prompt39Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt39SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt39
	)
	default Location prompt39Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt39panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt39
	)
	default RSAnchorType prompt39PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt39PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt39
	)
	default int prompt39PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt39PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt39
	)
	default int prompt39PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt39ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt39
	)
	default int prompt39ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt39Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt39
	)
	default boolean prompt39Image() { return false; }

	@ConfigItem(
			keyName = "Prompt39ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt39
	)
	default boolean prompt39ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt39PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt39
	)
	default int prompt39PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt39PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt39
	)
	default TextSize prompt39PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt39PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt39
	)
	default Color prompt39PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt39PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt39
	)
	default boolean prompt39PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt39ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt39
	)
	default boolean prompt39ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt39ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt39
	)
	default int prompt39ImageOffset() { return 0; }


	@ConfigSection(
			name = "40",
			description = "Prompt 40",
			position = 60,
			closedByDefault = true
	)
	String prompt40= "prompt40";

	@ConfigItem(
			keyName = "enablePrompt40",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt40
	)
	default boolean prompt40Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt40Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt40
	)
	default String prompt40Text() { return ""; }

	@ConfigItem(
			keyName = "prompt40Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt40
	)
	default Color prompt40Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt40Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt40
	)
	default String prompt40Times() { return ""; }

	@ConfigItem(
			keyName = "prompt40DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt40
	)
	default String prompt40DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt40Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt40
	)
	default String prompt40Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt40Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt40
	)
	default String prompt40Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt40Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt40
	)
	default String prompt40Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt40Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt40
	)
	default int prompt40Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt40RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt40
	)
	default String prompt40RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt40NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt40
	)
	default String prompt40NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt40ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt40
	)
	default String prompt40ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt40Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt40
	)
	default int prompt40Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt40Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt40
	)
	default int prompt40Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt40TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt40
	)
	default TimeUnit prompt40TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt40ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt40
	)
	default String prompt40ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt40Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt40
	)
	default boolean prompt40Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt40SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt40
	)
	default Location prompt40Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt40panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt40
	)
	default RSAnchorType prompt40PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt40PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt40
	)
	default int prompt40PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt40PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt40
	)
	default int prompt40PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt40ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt40
	)
	default int prompt40ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt40Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt40
	)
	default boolean prompt40Image() { return false; }

	@ConfigItem(
			keyName = "Prompt40ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt40
	)
	default boolean prompt40ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt40PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt40
	)
	default int prompt40PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt40PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt40
	)
	default TextSize prompt40PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt40PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt40
	)
	default Color prompt40PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt40PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt40
	)
	default boolean prompt40PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt40ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt40
	)
	default boolean prompt40ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt40ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt40
	)
	default int prompt40ImageOffset() { return 0; }


	@ConfigSection(
			name = "41",
			description = "Prompt 41",
			position = 61,
			closedByDefault = true
	)
	String prompt41= "prompt41";

	@ConfigItem(
			keyName = "enablePrompt41",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt41
	)
	default boolean prompt41Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt41Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt41
	)
	default String prompt41Text() { return ""; }

	@ConfigItem(
			keyName = "prompt41Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt41
	)
	default Color prompt41Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt41Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt41
	)
	default String prompt41Times() { return ""; }

	@ConfigItem(
			keyName = "prompt41DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt41
	)
	default String prompt41DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt41Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt41
	)
	default String prompt41Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt41Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt41
	)
	default String prompt41Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt41Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt41
	)
	default String prompt41Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt41Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt41
	)
	default int prompt41Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt41RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt41
	)
	default String prompt41RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt41NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt41
	)
	default String prompt41NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt41ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt41
	)
	default String prompt41ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt41Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt41
	)
	default int prompt41Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt41Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt41
	)
	default int prompt41Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt41TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt41
	)
	default TimeUnit prompt41TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt41ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt41
	)
	default String prompt41ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt41Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt41
	)
	default boolean prompt41Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt41SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt41
	)
	default Location prompt41Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt41panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt41
	)
	default RSAnchorType prompt41PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt41PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt41
	)
	default int prompt41PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt41PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt41
	)
	default int prompt41PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt41ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt41
	)
	default int prompt41ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt41Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt41
	)
	default boolean prompt41Image() { return false; }

	@ConfigItem(
			keyName = "Prompt41ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt41
	)
	default boolean prompt41ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt41PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt41
	)
	default int prompt41PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt41PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt41
	)
	default TextSize prompt41PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt41PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt41
	)
	default Color prompt41PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt41PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt41
	)
	default boolean prompt41PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt41ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt41
	)
	default boolean prompt41ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt41ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt41
	)
	default int prompt41ImageOffset() { return 0; }


	@ConfigSection(
			name = "42",
			description = "Prompt 42",
			position = 62,
			closedByDefault = true
	)
	String prompt42= "prompt42";

	@ConfigItem(
			keyName = "enablePrompt42",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt42
	)
	default boolean prompt42Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt42Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt42
	)
	default String prompt42Text() { return ""; }

	@ConfigItem(
			keyName = "prompt42Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt42
	)
	default Color prompt42Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt42Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt42
	)
	default String prompt42Times() { return ""; }

	@ConfigItem(
			keyName = "prompt42DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt42
	)
	default String prompt42DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt42Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt42
	)
	default String prompt42Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt42Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt42
	)
	default String prompt42Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt42Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt42
	)
	default String prompt42Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt42Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt42
	)
	default int prompt42Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt42RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt42
	)
	default String prompt42RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt42NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt42
	)
	default String prompt42NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt42ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt42
	)
	default String prompt42ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt42Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt42
	)
	default int prompt42Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt42Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt42
	)
	default int prompt42Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt42TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt42
	)
	default TimeUnit prompt42TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt42ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt42
	)
	default String prompt42ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt42Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt42
	)
	default boolean prompt42Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt42SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt42
	)
	default Location prompt42Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt42panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt42
	)
	default RSAnchorType prompt42PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt42PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt42
	)
	default int prompt42PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt42PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt42
	)
	default int prompt42PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt42ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt42
	)
	default int prompt42ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt42Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt42
	)
	default boolean prompt42Image() { return false; }

	@ConfigItem(
			keyName = "Prompt42ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt42
	)
	default boolean prompt42ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt42PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt42
	)
	default int prompt42PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt42PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt42
	)
	default TextSize prompt42PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt42PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt42
	)
	default Color prompt42PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt42PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt42
	)
	default boolean prompt42PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt42ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt42
	)
	default boolean prompt42ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt42ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt42
	)
	default int prompt42ImageOffset() { return 0; }


	@ConfigSection(
			name = "43",
			description = "Prompt 43",
			position = 63,
			closedByDefault = true
	)
	String prompt43= "prompt43";

	@ConfigItem(
			keyName = "enablePrompt43",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt43
	)
	default boolean prompt43Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt43Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt43
	)
	default String prompt43Text() { return ""; }

	@ConfigItem(
			keyName = "prompt43Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt43
	)
	default Color prompt43Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt43Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt43
	)
	default String prompt43Times() { return ""; }

	@ConfigItem(
			keyName = "prompt43DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt43
	)
	default String prompt43DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt43Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt43
	)
	default String prompt43Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt43Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt43
	)
	default String prompt43Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt43Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt43
	)
	default String prompt43Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt43Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt43
	)
	default int prompt43Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt43RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt43
	)
	default String prompt43RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt43NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt43
	)
	default String prompt43NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt43ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt43
	)
	default String prompt43ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt43Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt43
	)
	default int prompt43Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt43Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt43
	)
	default int prompt43Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt43TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt43
	)
	default TimeUnit prompt43TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt43ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt43
	)
	default String prompt43ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt43Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt43
	)
	default boolean prompt43Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt43SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt43
	)
	default Location prompt43Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt43panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt43
	)
	default RSAnchorType prompt43PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt43PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt43
	)
	default int prompt43PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt43PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt43
	)
	default int prompt43PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt43ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt43
	)
	default int prompt43ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt43Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt43
	)
	default boolean prompt43Image() { return false; }

	@ConfigItem(
			keyName = "Prompt43ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt43
	)
	default boolean prompt43ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt43PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt43
	)
	default int prompt43PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt43PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt43
	)
	default TextSize prompt43PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt43PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt43
	)
	default Color prompt43PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt43PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt43
	)
	default boolean prompt43PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt43ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt43
	)
	default boolean prompt43ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt43ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt43
	)
	default int prompt43ImageOffset() { return 0; }


	@ConfigSection(
			name = "44",
			description = "Prompt 44",
			position = 64,
			closedByDefault = true
	)
	String prompt44= "prompt44";

	@ConfigItem(
			keyName = "enablePrompt44",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt44
	)
	default boolean prompt44Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt44Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt44
	)
	default String prompt44Text() { return ""; }

	@ConfigItem(
			keyName = "prompt44Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt44
	)
	default Color prompt44Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt44Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt44
	)
	default String prompt44Times() { return ""; }

	@ConfigItem(
			keyName = "prompt44DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt44
	)
	default String prompt44DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt44Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt44
	)
	default String prompt44Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt44Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt44
	)
	default String prompt44Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt44Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt44
	)
	default String prompt44Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt44Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt44
	)
	default int prompt44Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt44RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt44
	)
	default String prompt44RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt44NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt44
	)
	default String prompt44NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt44ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt44
	)
	default String prompt44ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt44Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt44
	)
	default int prompt44Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt44Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt44
	)
	default int prompt44Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt44TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt44
	)
	default TimeUnit prompt44TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt44ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt44
	)
	default String prompt44ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt44Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt44
	)
	default boolean prompt44Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt44SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt44
	)
	default Location prompt44Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt44panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt44
	)
	default RSAnchorType prompt44PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt44PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt44
	)
	default int prompt44PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt44PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt44
	)
	default int prompt44PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt44ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt44
	)
	default int prompt44ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt44Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt44
	)
	default boolean prompt44Image() { return false; }

	@ConfigItem(
			keyName = "Prompt44ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt44
	)
	default boolean prompt44ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt44PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt44
	)
	default int prompt44PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt44PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt44
	)
	default TextSize prompt44PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt44PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt44
	)
	default Color prompt44PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt44PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt44
	)
	default boolean prompt44PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt44ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt44
	)
	default boolean prompt44ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt44ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt44
	)
	default int prompt44ImageOffset() { return 0; }


	@ConfigSection(
			name = "45",
			description = "Prompt 45",
			position = 65,
			closedByDefault = true
	)
	String prompt45= "prompt45";

	@ConfigItem(
			keyName = "enablePrompt45",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt45
	)
	default boolean prompt45Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt45Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt45
	)
	default String prompt45Text() { return ""; }

	@ConfigItem(
			keyName = "prompt45Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt45
	)
	default Color prompt45Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt45Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt45
	)
	default String prompt45Times() { return ""; }

	@ConfigItem(
			keyName = "prompt45DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt45
	)
	default String prompt45DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt45Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt45
	)
	default String prompt45Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt45Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt45
	)
	default String prompt45Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt45Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt45
	)
	default String prompt45Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt45Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt45
	)
	default int prompt45Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt45RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt45
	)
	default String prompt45RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt45NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt45
	)
	default String prompt45NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt45ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt45
	)
	default String prompt45ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt45Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt45
	)
	default int prompt45Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt45Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt45
	)
	default int prompt45Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt45TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt45
	)
	default TimeUnit prompt45TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt45ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt45
	)
	default String prompt45ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt45Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt45
	)
	default boolean prompt45Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt45SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt45
	)
	default Location prompt45Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt45panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt45
	)
	default RSAnchorType prompt45PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt45PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt45
	)
	default int prompt45PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt45PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt45
	)
	default int prompt45PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt45ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt45
	)
	default int prompt45ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt45Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt45
	)
	default boolean prompt45Image() { return false; }

	@ConfigItem(
			keyName = "Prompt45ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt45
	)
	default boolean prompt45ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt45PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt45
	)
	default int prompt45PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt45PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt45
	)
	default TextSize prompt45PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt45PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt45
	)
	default Color prompt45PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt45PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt45
	)
	default boolean prompt45PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt45ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt45
	)
	default boolean prompt45ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt45ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt45
	)
	default int prompt45ImageOffset() { return 0; }


	@ConfigSection(
			name = "46",
			description = "Prompt 46",
			position = 66,
			closedByDefault = true
	)
	String prompt46= "prompt46";

	@ConfigItem(
			keyName = "enablePrompt46",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt46
	)
	default boolean prompt46Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt46Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt46
	)
	default String prompt46Text() { return ""; }

	@ConfigItem(
			keyName = "prompt46Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt46
	)
	default Color prompt46Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt46Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt46
	)
	default String prompt46Times() { return ""; }

	@ConfigItem(
			keyName = "prompt46DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt46
	)
	default String prompt46DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt46Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt46
	)
	default String prompt46Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt46Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt46
	)
	default String prompt46Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt46Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt46
	)
	default String prompt46Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt46Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt46
	)
	default int prompt46Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt46RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt46
	)
	default String prompt46RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt46NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt46
	)
	default String prompt46NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt46ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt46
	)
	default String prompt46ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt46Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt46
	)
	default int prompt46Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt46Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt46
	)
	default int prompt46Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt46TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt46
	)
	default TimeUnit prompt46TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt46ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt46
	)
	default String prompt46ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt46Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt46
	)
	default boolean prompt46Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt46SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt46
	)
	default Location prompt46Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt46panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt46
	)
	default RSAnchorType prompt46PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt46PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt46
	)
	default int prompt46PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt46PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt46
	)
	default int prompt46PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt46ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt46
	)
	default int prompt46ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt46Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt46
	)
	default boolean prompt46Image() { return false; }

	@ConfigItem(
			keyName = "Prompt46ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt46
	)
	default boolean prompt46ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt46PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt46
	)
	default int prompt46PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt46PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt46
	)
	default TextSize prompt46PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt46PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt46
	)
	default Color prompt46PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt46PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt46
	)
	default boolean prompt46PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt46ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt46
	)
	default boolean prompt46ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt46ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt46
	)
	default int prompt46ImageOffset() { return 0; }


	@ConfigSection(
			name = "47",
			description = "Prompt 47",
			position = 67,
			closedByDefault = true
	)
	String prompt47= "prompt47";

	@ConfigItem(
			keyName = "enablePrompt47",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt47
	)
	default boolean prompt47Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt47Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt47
	)
	default String prompt47Text() { return ""; }

	@ConfigItem(
			keyName = "prompt47Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt47
	)
	default Color prompt47Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt47Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt47
	)
	default String prompt47Times() { return ""; }

	@ConfigItem(
			keyName = "prompt47DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt47
	)
	default String prompt47DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt47Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt47
	)
	default String prompt47Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt47Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt47
	)
	default String prompt47Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt47Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt47
	)
	default String prompt47Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt47Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt47
	)
	default int prompt47Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt47RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt47
	)
	default String prompt47RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt47NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt47
	)
	default String prompt47NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt47ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt47
	)
	default String prompt47ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt47Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt47
	)
	default int prompt47Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt47Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt47
	)
	default int prompt47Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt47TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt47
	)
	default TimeUnit prompt47TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt47ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt47
	)
	default String prompt47ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt47Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt47
	)
	default boolean prompt47Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt47SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt47
	)
	default Location prompt47Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt47panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt47
	)
	default RSAnchorType prompt47PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt47PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt47
	)
	default int prompt47PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt47PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt47
	)
	default int prompt47PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt47ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt47
	)
	default int prompt47ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt47Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt47
	)
	default boolean prompt47Image() { return false; }

	@ConfigItem(
			keyName = "Prompt47ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt47
	)
	default boolean prompt47ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt47PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt47
	)
	default int prompt47PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt47PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt47
	)
	default TextSize prompt47PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt47PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt47
	)
	default Color prompt47PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt47PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt47
	)
	default boolean prompt47PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt47ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt47
	)
	default boolean prompt47ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt47ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt47
	)
	default int prompt47ImageOffset() { return 0; }


	@ConfigSection(
			name = "48",
			description = "Prompt 48",
			position = 68,
			closedByDefault = true
	)
	String prompt48= "prompt48";

	@ConfigItem(
			keyName = "enablePrompt48",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt48
	)
	default boolean prompt48Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt48Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt48
	)
	default String prompt48Text() { return ""; }

	@ConfigItem(
			keyName = "prompt48Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt48
	)
	default Color prompt48Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt48Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt48
	)
	default String prompt48Times() { return ""; }

	@ConfigItem(
			keyName = "prompt48DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt48
	)
	default String prompt48DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt48Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt48
	)
	default String prompt48Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt48Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt48
	)
	default String prompt48Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt48Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt48
	)
	default String prompt48Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt48Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt48
	)
	default int prompt48Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt48RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt48
	)
	default String prompt48RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt48NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt48
	)
	default String prompt48NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt48ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt48
	)
	default String prompt48ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt48Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt48
	)
	default int prompt48Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt48Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt48
	)
	default int prompt48Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt48TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt48
	)
	default TimeUnit prompt48TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt48ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt48
	)
	default String prompt48ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt48Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt48
	)
	default boolean prompt48Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt48SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt48
	)
	default Location prompt48Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt48panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt48
	)
	default RSAnchorType prompt48PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt48PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt48
	)
	default int prompt48PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt48PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt48
	)
	default int prompt48PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt48ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt48
	)
	default int prompt48ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt48Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt48
	)
	default boolean prompt48Image() { return false; }

	@ConfigItem(
			keyName = "Prompt48ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt48
	)
	default boolean prompt48ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt48PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt48
	)
	default int prompt48PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt48PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt48
	)
	default TextSize prompt48PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt48PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt48
	)
	default Color prompt48PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt48PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt48
	)
	default boolean prompt48PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt48ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt48
	)
	default boolean prompt48ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt48ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt48
	)
	default int prompt48ImageOffset() { return 0; }


	@ConfigSection(
			name = "49",
			description = "Prompt 49",
			position = 69,
			closedByDefault = true
	)
	String prompt49= "prompt49";

	@ConfigItem(
			keyName = "enablePrompt49",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt49
	)
	default boolean prompt49Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt49Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt49
	)
	default String prompt49Text() { return ""; }

	@ConfigItem(
			keyName = "prompt49Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt49
	)
	default Color prompt49Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt49Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt49
	)
	default String prompt49Times() { return ""; }

	@ConfigItem(
			keyName = "prompt49DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt49
	)
	default String prompt49DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt49Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt49
	)
	default String prompt49Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt49Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt49
	)
	default String prompt49Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt49Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt49
	)
	default String prompt49Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt49Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt49
	)
	default int prompt49Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt49RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt49
	)
	default String prompt49RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt49NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt49
	)
	default String prompt49NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt49ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt49
	)
	default String prompt49ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt49Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt49
	)
	default int prompt49Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt49Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt49
	)
	default int prompt49Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt49TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt49
	)
	default TimeUnit prompt49TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt49ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt49
	)
	default String prompt49ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt49Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt49
	)
	default boolean prompt49Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt49SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt49
	)
	default Location prompt49Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt49panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt49
	)
	default RSAnchorType prompt49PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt49PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt49
	)
	default int prompt49PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt49PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt49
	)
	default int prompt49PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt49ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt49
	)
	default int prompt49ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt49Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt49
	)
	default boolean prompt49Image() { return false; }

	@ConfigItem(
			keyName = "Prompt49ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt49
	)
	default boolean prompt49ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt49PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt49
	)
	default int prompt49PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt49PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt49
	)
	default TextSize prompt49PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt49PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt49
	)
	default Color prompt49PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt49PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt49
	)
	default boolean prompt49PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt49ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt49
	)
	default boolean prompt49ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt49ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt49
	)
	default int prompt49ImageOffset() { return 0; }


	@ConfigSection(
			name = "50",
			description = "Prompt 50",
			position = 70,
			closedByDefault = true
	)
	String prompt50= "prompt50";

	@ConfigItem(
			keyName = "enablePrompt50",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt50
	)
	default boolean prompt50Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt50Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt50
	)
	default String prompt50Text() { return ""; }

	@ConfigItem(
			keyName = "prompt50Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt50
	)
	default Color prompt50Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt50Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt50
	)
	default String prompt50Times() { return ""; }

	@ConfigItem(
			keyName = "prompt50DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt50
	)
	default String prompt50DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt50Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt50
	)
	default String prompt50Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt50Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt50
	)
	default String prompt50Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt50Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt50
	)
	default String prompt50Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt50Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt50
	)
	default int prompt50Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt50RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt50
	)
	default String prompt50RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt50NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt50
	)
	default String prompt50NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt50ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt50
	)
	default String prompt50ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt50Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt50
	)
	default int prompt50Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt50Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt50
	)
	default int prompt50Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt50TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt50
	)
	default TimeUnit prompt50TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt50ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt50
	)
	default String prompt50ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt50Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt50
	)
	default boolean prompt50Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt50SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt50
	)
	default Location prompt50Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt50panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt50
	)
	default RSAnchorType prompt50PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt50PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt50
	)
	default int prompt50PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt50PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt50
	)
	default int prompt50PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt50ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt50
	)
	default int prompt50ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt50Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt50
	)
	default boolean prompt50Image() { return false; }

	@ConfigItem(
			keyName = "Prompt50ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt50
	)
	default boolean prompt50ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt50PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt50
	)
	default int prompt50PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt50PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt50
	)
	default TextSize prompt50PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt50PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt50
	)
	default Color prompt50PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt50PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt50
	)
	default boolean prompt50PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt50ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt50
	)
	default boolean prompt50ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt50ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt50
	)
	default int prompt50ImageOffset() { return 0; }


	@ConfigSection(
			name = "51",
			description = "Prompt 51",
			position = 71,
			closedByDefault = true
	)
	String prompt51= "prompt51";

	@ConfigItem(
			keyName = "enablePrompt51",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt51
	)
	default boolean prompt51Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt51Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt51
	)
	default String prompt51Text() { return ""; }

	@ConfigItem(
			keyName = "prompt51Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt51
	)
	default Color prompt51Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt51Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt51
	)
	default String prompt51Times() { return ""; }

	@ConfigItem(
			keyName = "prompt51DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt51
	)
	default String prompt51DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt51Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt51
	)
	default String prompt51Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt51Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt51
	)
	default String prompt51Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt51Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt51
	)
	default String prompt51Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt51Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt51
	)
	default int prompt51Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt51RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt51
	)
	default String prompt51RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt51NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt51
	)
	default String prompt51NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt51ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt51
	)
	default String prompt51ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt51Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt51
	)
	default int prompt51Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt51Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt51
	)
	default int prompt51Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt51TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt51
	)
	default TimeUnit prompt51TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt51ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt51
	)
	default String prompt51ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt51Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt51
	)
	default boolean prompt51Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt51SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt51
	)
	default Location prompt51Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt51panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt51
	)
	default RSAnchorType prompt51PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt51PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt51
	)
	default int prompt51PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt51PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt51
	)
	default int prompt51PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt51ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt51
	)
	default int prompt51ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt51Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt51
	)
	default boolean prompt51Image() { return false; }

	@ConfigItem(
			keyName = "Prompt51ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt51
	)
	default boolean prompt51ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt51PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt51
	)
	default int prompt51PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt51PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt51
	)
	default TextSize prompt51PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt51PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt51
	)
	default Color prompt51PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt51PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt51
	)
	default boolean prompt51PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt51ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt51
	)
	default boolean prompt51ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt51ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt51
	)
	default int prompt51ImageOffset() { return 0; }


	@ConfigSection(
			name = "52",
			description = "Prompt 52",
			position = 72,
			closedByDefault = true
	)
	String prompt52= "prompt52";

	@ConfigItem(
			keyName = "enablePrompt52",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt52
	)
	default boolean prompt52Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt52Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt52
	)
	default String prompt52Text() { return ""; }

	@ConfigItem(
			keyName = "prompt52Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt52
	)
	default Color prompt52Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt52Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt52
	)
	default String prompt52Times() { return ""; }

	@ConfigItem(
			keyName = "prompt52DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt52
	)
	default String prompt52DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt52Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt52
	)
	default String prompt52Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt52Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt52
	)
	default String prompt52Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt52Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt52
	)
	default String prompt52Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt52Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt52
	)
	default int prompt52Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt52RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt52
	)
	default String prompt52RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt52NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt52
	)
	default String prompt52NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt52ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt52
	)
	default String prompt52ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt52Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt52
	)
	default int prompt52Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt52Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt52
	)
	default int prompt52Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt52TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt52
	)
	default TimeUnit prompt52TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt52ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt52
	)
	default String prompt52ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt52Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt52
	)
	default boolean prompt52Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt52SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt52
	)
	default Location prompt52Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt52panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt52
	)
	default RSAnchorType prompt52PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt52PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt52
	)
	default int prompt52PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt52PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt52
	)
	default int prompt52PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt52ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt52
	)
	default int prompt52ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt52Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt52
	)
	default boolean prompt52Image() { return false; }

	@ConfigItem(
			keyName = "Prompt52ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt52
	)
	default boolean prompt52ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt52PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt52
	)
	default int prompt52PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt52PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt52
	)
	default TextSize prompt52PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt52PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt52
	)
	default Color prompt52PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt52PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt52
	)
	default boolean prompt52PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt52ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt52
	)
	default boolean prompt52ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt52ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt52
	)
	default int prompt52ImageOffset() { return 0; }


	@ConfigSection(
			name = "53",
			description = "Prompt 53",
			position = 73,
			closedByDefault = true
	)
	String prompt53= "prompt53";

	@ConfigItem(
			keyName = "enablePrompt53",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt53
	)
	default boolean prompt53Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt53Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt53
	)
	default String prompt53Text() { return ""; }

	@ConfigItem(
			keyName = "prompt53Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt53
	)
	default Color prompt53Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt53Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt53
	)
	default String prompt53Times() { return ""; }

	@ConfigItem(
			keyName = "prompt53DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt53
	)
	default String prompt53DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt53Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt53
	)
	default String prompt53Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt53Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt53
	)
	default String prompt53Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt53Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt53
	)
	default String prompt53Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt53Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt53
	)
	default int prompt53Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt53RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt53
	)
	default String prompt53RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt53NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt53
	)
	default String prompt53NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt53ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt53
	)
	default String prompt53ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt53Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt53
	)
	default int prompt53Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt53Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt53
	)
	default int prompt53Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt53TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt53
	)
	default TimeUnit prompt53TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt53ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt53
	)
	default String prompt53ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt53Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt53
	)
	default boolean prompt53Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt53SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt53
	)
	default Location prompt53Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt53panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt53
	)
	default RSAnchorType prompt53PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt53PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt53
	)
	default int prompt53PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt53PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt53
	)
	default int prompt53PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt53ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt53
	)
	default int prompt53ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt53Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt53
	)
	default boolean prompt53Image() { return false; }

	@ConfigItem(
			keyName = "Prompt53ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt53
	)
	default boolean prompt53ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt53PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt53
	)
	default int prompt53PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt53PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt53
	)
	default TextSize prompt53PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt53PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt53
	)
	default Color prompt53PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt53PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt53
	)
	default boolean prompt53PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt53ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt53
	)
	default boolean prompt53ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt53ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt53
	)
	default int prompt53ImageOffset() { return 0; }


	@ConfigSection(
			name = "54",
			description = "Prompt 54",
			position = 74,
			closedByDefault = true
	)
	String prompt54= "prompt54";

	@ConfigItem(
			keyName = "enablePrompt54",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt54
	)
	default boolean prompt54Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt54Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt54
	)
	default String prompt54Text() { return ""; }

	@ConfigItem(
			keyName = "prompt54Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt54
	)
	default Color prompt54Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt54Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt54
	)
	default String prompt54Times() { return ""; }

	@ConfigItem(
			keyName = "prompt54DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt54
	)
	default String prompt54DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt54Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt54
	)
	default String prompt54Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt54Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt54
	)
	default String prompt54Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt54Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt54
	)
	default String prompt54Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt54Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt54
	)
	default int prompt54Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt54RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt54
	)
	default String prompt54RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt54NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt54
	)
	default String prompt54NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt54ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt54
	)
	default String prompt54ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt54Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt54
	)
	default int prompt54Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt54Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt54
	)
	default int prompt54Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt54TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt54
	)
	default TimeUnit prompt54TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt54ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt54
	)
	default String prompt54ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt54Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt54
	)
	default boolean prompt54Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt54SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt54
	)
	default Location prompt54Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt54panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt54
	)
	default RSAnchorType prompt54PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt54PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt54
	)
	default int prompt54PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt54PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt54
	)
	default int prompt54PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt54ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt54
	)
	default int prompt54ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt54Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt54
	)
	default boolean prompt54Image() { return false; }

	@ConfigItem(
			keyName = "Prompt54ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt54
	)
	default boolean prompt54ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt54PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt54
	)
	default int prompt54PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt54PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt54
	)
	default TextSize prompt54PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt54PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt54
	)
	default Color prompt54PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt54PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt54
	)
	default boolean prompt54PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt54ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt54
	)
	default boolean prompt54ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt54ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt54
	)
	default int prompt54ImageOffset() { return 0; }


	@ConfigSection(
			name = "55",
			description = "Prompt 55",
			position = 75,
			closedByDefault = true
	)
	String prompt55= "prompt55";

	@ConfigItem(
			keyName = "enablePrompt55",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt55
	)
	default boolean prompt55Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt55Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt55
	)
	default String prompt55Text() { return ""; }

	@ConfigItem(
			keyName = "prompt55Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt55
	)
	default Color prompt55Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt55Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt55
	)
	default String prompt55Times() { return ""; }

	@ConfigItem(
			keyName = "prompt55DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt55
	)
	default String prompt55DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt55Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt55
	)
	default String prompt55Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt55Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt55
	)
	default String prompt55Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt55Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt55
	)
	default String prompt55Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt55Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt55
	)
	default int prompt55Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt55RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt55
	)
	default String prompt55RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt55NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt55
	)
	default String prompt55NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt55ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt55
	)
	default String prompt55ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt55Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt55
	)
	default int prompt55Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt55Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt55
	)
	default int prompt55Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt55TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt55
	)
	default TimeUnit prompt55TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt55ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt55
	)
	default String prompt55ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt55Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt55
	)
	default boolean prompt55Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt55SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt55
	)
	default Location prompt55Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt55panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt55
	)
	default RSAnchorType prompt55PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt55PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt55
	)
	default int prompt55PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt55PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt55
	)
	default int prompt55PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt55ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt55
	)
	default int prompt55ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt55Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt55
	)
	default boolean prompt55Image() { return false; }

	@ConfigItem(
			keyName = "Prompt55ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt55
	)
	default boolean prompt55ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt55PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt55
	)
	default int prompt55PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt55PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt55
	)
	default TextSize prompt55PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt55PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt55
	)
	default Color prompt55PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt55PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt55
	)
	default boolean prompt55PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt55ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt55
	)
	default boolean prompt55ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt55ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt55
	)
	default int prompt55ImageOffset() { return 0; }


	@ConfigSection(
			name = "56",
			description = "Prompt 56",
			position = 76,
			closedByDefault = true
	)
	String prompt56= "prompt56";

	@ConfigItem(
			keyName = "enablePrompt56",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt56
	)
	default boolean prompt56Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt56Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt56
	)
	default String prompt56Text() { return ""; }

	@ConfigItem(
			keyName = "prompt56Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt56
	)
	default Color prompt56Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt56Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt56
	)
	default String prompt56Times() { return ""; }

	@ConfigItem(
			keyName = "prompt56DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt56
	)
	default String prompt56DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt56Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt56
	)
	default String prompt56Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt56Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt56
	)
	default String prompt56Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt56Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt56
	)
	default String prompt56Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt56Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt56
	)
	default int prompt56Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt56RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt56
	)
	default String prompt56RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt56NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt56
	)
	default String prompt56NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt56ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt56
	)
	default String prompt56ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt56Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt56
	)
	default int prompt56Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt56Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt56
	)
	default int prompt56Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt56TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt56
	)
	default TimeUnit prompt56TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt56ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt56
	)
	default String prompt56ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt56Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt56
	)
	default boolean prompt56Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt56SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt56
	)
	default Location prompt56Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt56panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt56
	)
	default RSAnchorType prompt56PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt56PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt56
	)
	default int prompt56PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt56PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt56
	)
	default int prompt56PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt56ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt56
	)
	default int prompt56ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt56Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt56
	)
	default boolean prompt56Image() { return false; }

	@ConfigItem(
			keyName = "Prompt56ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt56
	)
	default boolean prompt56ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt56PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt56
	)
	default int prompt56PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt56PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt56
	)
	default TextSize prompt56PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt56PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt56
	)
	default Color prompt56PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt56PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt56
	)
	default boolean prompt56PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt56ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt56
	)
	default boolean prompt56ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt56ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt56
	)
	default int prompt56ImageOffset() { return 0; }


	@ConfigSection(
			name = "57",
			description = "Prompt 57",
			position = 77,
			closedByDefault = true
	)
	String prompt57= "prompt57";

	@ConfigItem(
			keyName = "enablePrompt57",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt57
	)
	default boolean prompt57Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt57Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt57
	)
	default String prompt57Text() { return ""; }

	@ConfigItem(
			keyName = "prompt57Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt57
	)
	default Color prompt57Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt57Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt57
	)
	default String prompt57Times() { return ""; }

	@ConfigItem(
			keyName = "prompt57DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt57
	)
	default String prompt57DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt57Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt57
	)
	default String prompt57Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt57Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt57
	)
	default String prompt57Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt57Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt57
	)
	default String prompt57Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt57Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt57
	)
	default int prompt57Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt57RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt57
	)
	default String prompt57RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt57NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt57
	)
	default String prompt57NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt57ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt57
	)
	default String prompt57ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt57Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt57
	)
	default int prompt57Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt57Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt57
	)
	default int prompt57Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt57TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt57
	)
	default TimeUnit prompt57TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt57ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt57
	)
	default String prompt57ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt57Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt57
	)
	default boolean prompt57Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt57SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt57
	)
	default Location prompt57Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt57panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt57
	)
	default RSAnchorType prompt57PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt57PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt57
	)
	default int prompt57PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt57PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt57
	)
	default int prompt57PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt57ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt57
	)
	default int prompt57ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt57Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt57
	)
	default boolean prompt57Image() { return false; }

	@ConfigItem(
			keyName = "Prompt57ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt57
	)
	default boolean prompt57ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt57PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt57
	)
	default int prompt57PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt57PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt57
	)
	default TextSize prompt57PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt57PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt57
	)
	default Color prompt57PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt57PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt57
	)
	default boolean prompt57PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt57ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt57
	)
	default boolean prompt57ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt57ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt57
	)
	default int prompt57ImageOffset() { return 0; }


	@ConfigSection(
			name = "58",
			description = "Prompt 58",
			position = 78,
			closedByDefault = true
	)
	String prompt58= "prompt58";

	@ConfigItem(
			keyName = "enablePrompt58",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt58
	)
	default boolean prompt58Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt58Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt58
	)
	default String prompt58Text() { return ""; }

	@ConfigItem(
			keyName = "prompt58Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt58
	)
	default Color prompt58Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt58Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt58
	)
	default String prompt58Times() { return ""; }

	@ConfigItem(
			keyName = "prompt58DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt58
	)
	default String prompt58DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt58Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt58
	)
	default String prompt58Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt58Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt58
	)
	default String prompt58Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt58Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt58
	)
	default String prompt58Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt58Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt58
	)
	default int prompt58Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt58RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt58
	)
	default String prompt58RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt58NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt58
	)
	default String prompt58NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt58ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt58
	)
	default String prompt58ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt58Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt58
	)
	default int prompt58Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt58Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt58
	)
	default int prompt58Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt58TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt58
	)
	default TimeUnit prompt58TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt58ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt58
	)
	default String prompt58ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt58Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt58
	)
	default boolean prompt58Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt58SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt58
	)
	default Location prompt58Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt58panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt58
	)
	default RSAnchorType prompt58PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt58PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt58
	)
	default int prompt58PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt58PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt58
	)
	default int prompt58PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt58ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt58
	)
	default int prompt58ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt58Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt58
	)
	default boolean prompt58Image() { return false; }

	@ConfigItem(
			keyName = "Prompt58ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt58
	)
	default boolean prompt58ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt58PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt58
	)
	default int prompt58PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt58PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt58
	)
	default TextSize prompt58PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt58PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt58
	)
	default Color prompt58PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt58PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt58
	)
	default boolean prompt58PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt58ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt58
	)
	default boolean prompt58ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt58ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt58
	)
	default int prompt58ImageOffset() { return 0; }


	@ConfigSection(
			name = "59",
			description = "Prompt 59",
			position = 79,
			closedByDefault = true
	)
	String prompt59= "prompt59";

	@ConfigItem(
			keyName = "enablePrompt59",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt59
	)
	default boolean prompt59Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt59Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt59
	)
	default String prompt59Text() { return ""; }

	@ConfigItem(
			keyName = "prompt59Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt59
	)
	default Color prompt59Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt59Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt59
	)
	default String prompt59Times() { return ""; }

	@ConfigItem(
			keyName = "prompt59DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt59
	)
	default String prompt59DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt59Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt59
	)
	default String prompt59Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt59Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt59
	)
	default String prompt59Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt59Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt59
	)
	default String prompt59Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt59Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt59
	)
	default int prompt59Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt59RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt59
	)
	default String prompt59RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt59NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt59
	)
	default String prompt59NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt59ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt59
	)
	default String prompt59ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt59Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt59
	)
	default int prompt59Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt59Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt59
	)
	default int prompt59Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt59TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt59
	)
	default TimeUnit prompt59TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt59ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt59
	)
	default String prompt59ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt59Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt59
	)
	default boolean prompt59Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt59SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt59
	)
	default Location prompt59Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt59panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt59
	)
	default RSAnchorType prompt59PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt59PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt59
	)
	default int prompt59PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt59PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt59
	)
	default int prompt59PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt59ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt59
	)
	default int prompt59ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt59Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt59
	)
	default boolean prompt59Image() { return false; }

	@ConfigItem(
			keyName = "Prompt59ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt59
	)
	default boolean prompt59ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt59PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt59
	)
	default int prompt59PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt59PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt59
	)
	default TextSize prompt59PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt59PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt59
	)
	default Color prompt59PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt59PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt59
	)
	default boolean prompt59PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt59ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt59
	)
	default boolean prompt59ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt59ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt59
	)
	default int prompt59ImageOffset() { return 0; }


	@ConfigSection(
			name = "60",
			description = "Prompt 60",
			position = 80,
			closedByDefault = true
	)
	String prompt60= "prompt60";

	@ConfigItem(
			keyName = "enablePrompt60",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt60
	)
	default boolean prompt60Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt60Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt60
	)
	default String prompt60Text() { return ""; }

	@ConfigItem(
			keyName = "prompt60Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt60
	)
	default Color prompt60Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt60Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt60
	)
	default String prompt60Times() { return ""; }

	@ConfigItem(
			keyName = "prompt60DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt60
	)
	default String prompt60DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt60Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt60
	)
	default String prompt60Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt60Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt60
	)
	default String prompt60Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt60Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt60
	)
	default String prompt60Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt60Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt60
	)
	default int prompt60Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt60RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt60
	)
	default String prompt60RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt60NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt60
	)
	default String prompt60NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt60ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt60
	)
	default String prompt60ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt60Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt60
	)
	default int prompt60Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt60Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt60
	)
	default int prompt60Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt60TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt60
	)
	default TimeUnit prompt60TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt60ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt60
	)
	default String prompt60ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt60Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt60
	)
	default boolean prompt60Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt60SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt60
	)
	default Location prompt60Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt60panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt60
	)
	default RSAnchorType prompt60PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt60PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt60
	)
	default int prompt60PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt60PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt60
	)
	default int prompt60PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt60ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt60
	)
	default int prompt60ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt60Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt60
	)
	default boolean prompt60Image() { return false; }

	@ConfigItem(
			keyName = "Prompt60ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt60
	)
	default boolean prompt60ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt60PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt60
	)
	default int prompt60PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt60PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt60
	)
	default TextSize prompt60PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt60PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt60
	)
	default Color prompt60PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt60PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt60
	)
	default boolean prompt60PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt60ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt60
	)
	default boolean prompt60ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt60ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt60
	)
	default int prompt60ImageOffset() { return 0; }


	@ConfigSection(
			name = "61",
			description = "Prompt 61",
			position = 81,
			closedByDefault = true
	)
	String prompt61= "prompt61";

	@ConfigItem(
			keyName = "enablePrompt61",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt61
	)
	default boolean prompt61Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt61Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt61
	)
	default String prompt61Text() { return ""; }

	@ConfigItem(
			keyName = "prompt61Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt61
	)
	default Color prompt61Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt61Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt61
	)
	default String prompt61Times() { return ""; }

	@ConfigItem(
			keyName = "prompt61DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt61
	)
	default String prompt61DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt61Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt61
	)
	default String prompt61Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt61Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt61
	)
	default String prompt61Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt61Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt61
	)
	default String prompt61Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt61Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt61
	)
	default int prompt61Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt61RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt61
	)
	default String prompt61RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt61NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt61
	)
	default String prompt61NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt61ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt61
	)
	default String prompt61ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt61Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt61
	)
	default int prompt61Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt61Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt61
	)
	default int prompt61Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt61TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt61
	)
	default TimeUnit prompt61TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt61ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt61
	)
	default String prompt61ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt61Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt61
	)
	default boolean prompt61Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt61SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt61
	)
	default Location prompt61Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt61panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt61
	)
	default RSAnchorType prompt61PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt61PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt61
	)
	default int prompt61PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt61PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt61
	)
	default int prompt61PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt61ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt61
	)
	default int prompt61ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt61Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt61
	)
	default boolean prompt61Image() { return false; }

	@ConfigItem(
			keyName = "Prompt61ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt61
	)
	default boolean prompt61ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt61PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt61
	)
	default int prompt61PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt61PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt61
	)
	default TextSize prompt61PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt61PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt61
	)
	default Color prompt61PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt61PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt61
	)
	default boolean prompt61PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt61ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt61
	)
	default boolean prompt61ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt61ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt61
	)
	default int prompt61ImageOffset() { return 0; }


	@ConfigSection(
			name = "62",
			description = "Prompt 62",
			position = 82,
			closedByDefault = true
	)
	String prompt62= "prompt62";

	@ConfigItem(
			keyName = "enablePrompt62",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt62
	)
	default boolean prompt62Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt62Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt62
	)
	default String prompt62Text() { return ""; }

	@ConfigItem(
			keyName = "prompt62Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt62
	)
	default Color prompt62Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt62Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt62
	)
	default String prompt62Times() { return ""; }

	@ConfigItem(
			keyName = "prompt62DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt62
	)
	default String prompt62DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt62Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt62
	)
	default String prompt62Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt62Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt62
	)
	default String prompt62Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt62Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt62
	)
	default String prompt62Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt62Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt62
	)
	default int prompt62Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt62RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt62
	)
	default String prompt62RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt62NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt62
	)
	default String prompt62NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt62ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt62
	)
	default String prompt62ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt62Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt62
	)
	default int prompt62Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt62Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt62
	)
	default int prompt62Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt62TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt62
	)
	default TimeUnit prompt62TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt62ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt62
	)
	default String prompt62ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt62Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt62
	)
	default boolean prompt62Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt62SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt62
	)
	default Location prompt62Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt62panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt62
	)
	default RSAnchorType prompt62PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt62PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt62
	)
	default int prompt62PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt62PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt62
	)
	default int prompt62PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt62ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt62
	)
	default int prompt62ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt62Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt62
	)
	default boolean prompt62Image() { return false; }

	@ConfigItem(
			keyName = "Prompt62ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt62
	)
	default boolean prompt62ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt62PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt62
	)
	default int prompt62PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt62PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt62
	)
	default TextSize prompt62PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt62PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt62
	)
	default Color prompt62PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt62PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt62
	)
	default boolean prompt62PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt62ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt62
	)
	default boolean prompt62ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt62ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt62
	)
	default int prompt62ImageOffset() { return 0; }


	@ConfigSection(
			name = "63",
			description = "Prompt 63",
			position = 83,
			closedByDefault = true
	)
	String prompt63= "prompt63";

	@ConfigItem(
			keyName = "enablePrompt63",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt63
	)
	default boolean prompt63Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt63Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt63
	)
	default String prompt63Text() { return ""; }

	@ConfigItem(
			keyName = "prompt63Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt63
	)
	default Color prompt63Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt63Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt63
	)
	default String prompt63Times() { return ""; }

	@ConfigItem(
			keyName = "prompt63DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt63
	)
	default String prompt63DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt63Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt63
	)
	default String prompt63Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt63Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt63
	)
	default String prompt63Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt63Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt63
	)
	default String prompt63Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt63Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt63
	)
	default int prompt63Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt63RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt63
	)
	default String prompt63RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt63NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt63
	)
	default String prompt63NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt63ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt63
	)
	default String prompt63ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt63Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt63
	)
	default int prompt63Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt63Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt63
	)
	default int prompt63Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt63TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt63
	)
	default TimeUnit prompt63TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt63ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt63
	)
	default String prompt63ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt63Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt63
	)
	default boolean prompt63Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt63SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt63
	)
	default Location prompt63Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt63panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt63
	)
	default RSAnchorType prompt63PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt63PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt63
	)
	default int prompt63PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt63PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt63
	)
	default int prompt63PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt63ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt63
	)
	default int prompt63ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt63Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt63
	)
	default boolean prompt63Image() { return false; }

	@ConfigItem(
			keyName = "Prompt63ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt63
	)
	default boolean prompt63ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt63PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt63
	)
	default int prompt63PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt63PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt63
	)
	default TextSize prompt63PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt63PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt63
	)
	default Color prompt63PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt63PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt63
	)
	default boolean prompt63PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt63ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt63
	)
	default boolean prompt63ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt63ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt63
	)
	default int prompt63ImageOffset() { return 0; }


	@ConfigSection(
			name = "64",
			description = "Prompt 64",
			position = 84,
			closedByDefault = true
	)
	String prompt64= "prompt64";

	@ConfigItem(
			keyName = "enablePrompt64",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt64
	)
	default boolean prompt64Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt64Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt64
	)
	default String prompt64Text() { return ""; }

	@ConfigItem(
			keyName = "prompt64Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt64
	)
	default Color prompt64Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt64Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt64
	)
	default String prompt64Times() { return ""; }

	@ConfigItem(
			keyName = "prompt64DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt64
	)
	default String prompt64DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt64Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt64
	)
	default String prompt64Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt64Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt64
	)
	default String prompt64Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt64Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt64
	)
	default String prompt64Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt64Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt64
	)
	default int prompt64Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt64RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt64
	)
	default String prompt64RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt64NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt64
	)
	default String prompt64NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt64ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt64
	)
	default String prompt64ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt64Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt64
	)
	default int prompt64Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt64Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt64
	)
	default int prompt64Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt64TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt64
	)
	default TimeUnit prompt64TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt64ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt64
	)
	default String prompt64ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt64Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt64
	)
	default boolean prompt64Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt64SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt64
	)
	default Location prompt64Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt64panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt64
	)
	default RSAnchorType prompt64PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt64PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt64
	)
	default int prompt64PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt64PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt64
	)
	default int prompt64PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt64ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt64
	)
	default int prompt64ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt64Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt64
	)
	default boolean prompt64Image() { return false; }

	@ConfigItem(
			keyName = "Prompt64ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt64
	)
	default boolean prompt64ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt64PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt64
	)
	default int prompt64PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt64PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt64
	)
	default TextSize prompt64PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt64PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt64
	)
	default Color prompt64PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt64PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt64
	)
	default boolean prompt64PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt64ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt64
	)
	default boolean prompt64ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt64ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt64
	)
	default int prompt64ImageOffset() { return 0; }


	@ConfigSection(
			name = "65",
			description = "Prompt 65",
			position = 85,
			closedByDefault = true
	)
	String prompt65= "prompt65";

	@ConfigItem(
			keyName = "enablePrompt65",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt65
	)
	default boolean prompt65Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt65Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt65
	)
	default String prompt65Text() { return ""; }

	@ConfigItem(
			keyName = "prompt65Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt65
	)
	default Color prompt65Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt65Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt65
	)
	default String prompt65Times() { return ""; }

	@ConfigItem(
			keyName = "prompt65DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt65
	)
	default String prompt65DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt65Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt65
	)
	default String prompt65Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt65Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt65
	)
	default String prompt65Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt65Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt65
	)
	default String prompt65Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt65Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt65
	)
	default int prompt65Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt65RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt65
	)
	default String prompt65RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt65NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt65
	)
	default String prompt65NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt65ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt65
	)
	default String prompt65ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt65Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt65
	)
	default int prompt65Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt65Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt65
	)
	default int prompt65Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt65TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt65
	)
	default TimeUnit prompt65TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt65ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt65
	)
	default String prompt65ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt65Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt65
	)
	default boolean prompt65Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt65SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt65
	)
	default Location prompt65Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt65panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt65
	)
	default RSAnchorType prompt65PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt65PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt65
	)
	default int prompt65PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt65PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt65
	)
	default int prompt65PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt65ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt65
	)
	default int prompt65ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt65Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt65
	)
	default boolean prompt65Image() { return false; }

	@ConfigItem(
			keyName = "Prompt65ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt65
	)
	default boolean prompt65ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt65PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt65
	)
	default int prompt65PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt65PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt65
	)
	default TextSize prompt65PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt65PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt65
	)
	default Color prompt65PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt65PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt65
	)
	default boolean prompt65PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt65ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt65
	)
	default boolean prompt65ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt65ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt65
	)
	default int prompt65ImageOffset() { return 0; }


	@ConfigSection(
			name = "66",
			description = "Prompt 66",
			position = 86,
			closedByDefault = true
	)
	String prompt66= "prompt66";

	@ConfigItem(
			keyName = "enablePrompt66",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt66
	)
	default boolean prompt66Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt66Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt66
	)
	default String prompt66Text() { return ""; }

	@ConfigItem(
			keyName = "prompt66Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt66
	)
	default Color prompt66Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt66Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt66
	)
	default String prompt66Times() { return ""; }

	@ConfigItem(
			keyName = "prompt66DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt66
	)
	default String prompt66DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt66Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt66
	)
	default String prompt66Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt66Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt66
	)
	default String prompt66Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt66Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt66
	)
	default String prompt66Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt66Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt66
	)
	default int prompt66Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt66RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt66
	)
	default String prompt66RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt66NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt66
	)
	default String prompt66NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt66ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt66
	)
	default String prompt66ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt66Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt66
	)
	default int prompt66Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt66Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt66
	)
	default int prompt66Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt66TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt66
	)
	default TimeUnit prompt66TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt66ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt66
	)
	default String prompt66ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt66Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt66
	)
	default boolean prompt66Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt66SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt66
	)
	default Location prompt66Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt66panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt66
	)
	default RSAnchorType prompt66PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt66PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt66
	)
	default int prompt66PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt66PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt66
	)
	default int prompt66PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt66ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt66
	)
	default int prompt66ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt66Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt66
	)
	default boolean prompt66Image() { return false; }

	@ConfigItem(
			keyName = "Prompt66ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt66
	)
	default boolean prompt66ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt66PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt66
	)
	default int prompt66PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt66PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt66
	)
	default TextSize prompt66PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt66PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt66
	)
	default Color prompt66PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt66PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt66
	)
	default boolean prompt66PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt66ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt66
	)
	default boolean prompt66ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt66ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt66
	)
	default int prompt66ImageOffset() { return 0; }


	@ConfigSection(
			name = "67",
			description = "Prompt 67",
			position = 87,
			closedByDefault = true
	)
	String prompt67= "prompt67";

	@ConfigItem(
			keyName = "enablePrompt67",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt67
	)
	default boolean prompt67Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt67Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt67
	)
	default String prompt67Text() { return ""; }

	@ConfigItem(
			keyName = "prompt67Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt67
	)
	default Color prompt67Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt67Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt67
	)
	default String prompt67Times() { return ""; }

	@ConfigItem(
			keyName = "prompt67DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt67
	)
	default String prompt67DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt67Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt67
	)
	default String prompt67Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt67Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt67
	)
	default String prompt67Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt67Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt67
	)
	default String prompt67Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt67Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt67
	)
	default int prompt67Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt67RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt67
	)
	default String prompt67RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt67NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt67
	)
	default String prompt67NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt67ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt67
	)
	default String prompt67ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt67Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt67
	)
	default int prompt67Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt67Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt67
	)
	default int prompt67Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt67TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt67
	)
	default TimeUnit prompt67TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt67ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt67
	)
	default String prompt67ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt67Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt67
	)
	default boolean prompt67Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt67SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt67
	)
	default Location prompt67Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt67panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt67
	)
	default RSAnchorType prompt67PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt67PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt67
	)
	default int prompt67PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt67PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt67
	)
	default int prompt67PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt67ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt67
	)
	default int prompt67ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt67Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt67
	)
	default boolean prompt67Image() { return false; }

	@ConfigItem(
			keyName = "Prompt67ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt67
	)
	default boolean prompt67ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt67PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt67
	)
	default int prompt67PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt67PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt67
	)
	default TextSize prompt67PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt67PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt67
	)
	default Color prompt67PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt67PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt67
	)
	default boolean prompt67PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt67ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt67
	)
	default boolean prompt67ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt67ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt67
	)
	default int prompt67ImageOffset() { return 0; }


	@ConfigSection(
			name = "68",
			description = "Prompt 68",
			position = 88,
			closedByDefault = true
	)
	String prompt68= "prompt68";

	@ConfigItem(
			keyName = "enablePrompt68",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt68
	)
	default boolean prompt68Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt68Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt68
	)
	default String prompt68Text() { return ""; }

	@ConfigItem(
			keyName = "prompt68Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt68
	)
	default Color prompt68Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt68Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt68
	)
	default String prompt68Times() { return ""; }

	@ConfigItem(
			keyName = "prompt68DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt68
	)
	default String prompt68DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt68Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt68
	)
	default String prompt68Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt68Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt68
	)
	default String prompt68Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt68Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt68
	)
	default String prompt68Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt68Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt68
	)
	default int prompt68Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt68RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt68
	)
	default String prompt68RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt68NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt68
	)
	default String prompt68NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt68ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt68
	)
	default String prompt68ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt68Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt68
	)
	default int prompt68Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt68Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt68
	)
	default int prompt68Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt68TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt68
	)
	default TimeUnit prompt68TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt68ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt68
	)
	default String prompt68ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt68Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt68
	)
	default boolean prompt68Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt68SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt68
	)
	default Location prompt68Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt68panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt68
	)
	default RSAnchorType prompt68PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt68PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt68
	)
	default int prompt68PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt68PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt68
	)
	default int prompt68PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt68ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt68
	)
	default int prompt68ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt68Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt68
	)
	default boolean prompt68Image() { return false; }

	@ConfigItem(
			keyName = "Prompt68ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt68
	)
	default boolean prompt68ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt68PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt68
	)
	default int prompt68PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt68PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt68
	)
	default TextSize prompt68PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt68PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt68
	)
	default Color prompt68PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt68PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt68
	)
	default boolean prompt68PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt68ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt68
	)
	default boolean prompt68ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt68ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt68
	)
	default int prompt68ImageOffset() { return 0; }


	@ConfigSection(
			name = "69",
			description = "Prompt 69",
			position = 89,
			closedByDefault = true
	)
	String prompt69= "prompt69";

	@ConfigItem(
			keyName = "enablePrompt69",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt69
	)
	default boolean prompt69Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt69Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt69
	)
	default String prompt69Text() { return ""; }

	@ConfigItem(
			keyName = "prompt69Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt69
	)
	default Color prompt69Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt69Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt69
	)
	default String prompt69Times() { return ""; }

	@ConfigItem(
			keyName = "prompt69DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt69
	)
	default String prompt69DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt69Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt69
	)
	default String prompt69Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt69Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt69
	)
	default String prompt69Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt69Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt69
	)
	default String prompt69Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt69Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt69
	)
	default int prompt69Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt69RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt69
	)
	default String prompt69RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt69NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt69
	)
	default String prompt69NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt69ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt69
	)
	default String prompt69ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt69Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt69
	)
	default int prompt69Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt69Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt69
	)
	default int prompt69Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt69TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt69
	)
	default TimeUnit prompt69TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt69ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt69
	)
	default String prompt69ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt69Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt69
	)
	default boolean prompt69Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt69SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt69
	)
	default Location prompt69Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt69panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt69
	)
	default RSAnchorType prompt69PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt69PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt69
	)
	default int prompt69PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt69PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt69
	)
	default int prompt69PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt69ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt69
	)
	default int prompt69ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt69Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt69
	)
	default boolean prompt69Image() { return false; }

	@ConfigItem(
			keyName = "Prompt69ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt69
	)
	default boolean prompt69ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt69PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt69
	)
	default int prompt69PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt69PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt69
	)
	default TextSize prompt69PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt69PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt69
	)
	default Color prompt69PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt69PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt69
	)
	default boolean prompt69PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt69ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt69
	)
	default boolean prompt69ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt69ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt69
	)
	default int prompt69ImageOffset() { return 0; }


	@ConfigSection(
			name = "70",
			description = "Prompt 70",
			position = 90,
			closedByDefault = true
	)
	String prompt70= "prompt70";

	@ConfigItem(
			keyName = "enablePrompt70",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt70
	)
	default boolean prompt70Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt70Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt70
	)
	default String prompt70Text() { return ""; }

	@ConfigItem(
			keyName = "prompt70Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt70
	)
	default Color prompt70Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt70Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt70
	)
	default String prompt70Times() { return ""; }

	@ConfigItem(
			keyName = "prompt70DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt70
	)
	default String prompt70DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt70Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt70
	)
	default String prompt70Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt70Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt70
	)
	default String prompt70Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt70Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt70
	)
	default String prompt70Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt70Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt70
	)
	default int prompt70Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt70RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt70
	)
	default String prompt70RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt70NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt70
	)
	default String prompt70NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt70ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt70
	)
	default String prompt70ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt70Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt70
	)
	default int prompt70Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt70Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt70
	)
	default int prompt70Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt70TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt70
	)
	default TimeUnit prompt70TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt70ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt70
	)
	default String prompt70ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt70Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt70
	)
	default boolean prompt70Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt70SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt70
	)
	default Location prompt70Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt70panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt70
	)
	default RSAnchorType prompt70PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt70PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt70
	)
	default int prompt70PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt70PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt70
	)
	default int prompt70PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt70ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt70
	)
	default int prompt70ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt70Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt70
	)
	default boolean prompt70Image() { return false; }

	@ConfigItem(
			keyName = "Prompt70ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt70
	)
	default boolean prompt70ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt70PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt70
	)
	default int prompt70PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt70PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt70
	)
	default TextSize prompt70PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt70PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt70
	)
	default Color prompt70PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt70PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt70
	)
	default boolean prompt70PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt70ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt70
	)
	default boolean prompt70ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt70ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt70
	)
	default int prompt70ImageOffset() { return 0; }


	@ConfigSection(
			name = "71",
			description = "Prompt 71",
			position = 91,
			closedByDefault = true
	)
	String prompt71= "prompt71";

	@ConfigItem(
			keyName = "enablePrompt71",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt71
	)
	default boolean prompt71Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt71Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt71
	)
	default String prompt71Text() { return ""; }

	@ConfigItem(
			keyName = "prompt71Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt71
	)
	default Color prompt71Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt71Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt71
	)
	default String prompt71Times() { return ""; }

	@ConfigItem(
			keyName = "prompt71DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt71
	)
	default String prompt71DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt71Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt71
	)
	default String prompt71Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt71Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt71
	)
	default String prompt71Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt71Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt71
	)
	default String prompt71Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt71Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt71
	)
	default int prompt71Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt71RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt71
	)
	default String prompt71RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt71NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt71
	)
	default String prompt71NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt71ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt71
	)
	default String prompt71ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt71Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt71
	)
	default int prompt71Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt71Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt71
	)
	default int prompt71Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt71TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt71
	)
	default TimeUnit prompt71TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt71ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt71
	)
	default String prompt71ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt71Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt71
	)
	default boolean prompt71Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt71SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt71
	)
	default Location prompt71Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt71panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt71
	)
	default RSAnchorType prompt71PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt71PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt71
	)
	default int prompt71PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt71PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt71
	)
	default int prompt71PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt71ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt71
	)
	default int prompt71ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt71Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt71
	)
	default boolean prompt71Image() { return false; }

	@ConfigItem(
			keyName = "Prompt71ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt71
	)
	default boolean prompt71ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt71PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt71
	)
	default int prompt71PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt71PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt71
	)
	default TextSize prompt71PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt71PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt71
	)
	default Color prompt71PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt71PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt71
	)
	default boolean prompt71PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt71ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt71
	)
	default boolean prompt71ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt71ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt71
	)
	default int prompt71ImageOffset() { return 0; }


	@ConfigSection(
			name = "72",
			description = "Prompt 72",
			position = 92,
			closedByDefault = true
	)
	String prompt72= "prompt72";

	@ConfigItem(
			keyName = "enablePrompt72",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt72
	)
	default boolean prompt72Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt72Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt72
	)
	default String prompt72Text() { return ""; }

	@ConfigItem(
			keyName = "prompt72Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt72
	)
	default Color prompt72Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt72Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt72
	)
	default String prompt72Times() { return ""; }

	@ConfigItem(
			keyName = "prompt72DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt72
	)
	default String prompt72DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt72Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt72
	)
	default String prompt72Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt72Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt72
	)
	default String prompt72Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt72Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt72
	)
	default String prompt72Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt72Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt72
	)
	default int prompt72Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt72RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt72
	)
	default String prompt72RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt72NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt72
	)
	default String prompt72NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt72ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt72
	)
	default String prompt72ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt72Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt72
	)
	default int prompt72Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt72Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt72
	)
	default int prompt72Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt72TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt72
	)
	default TimeUnit prompt72TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt72ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt72
	)
	default String prompt72ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt72Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt72
	)
	default boolean prompt72Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt72SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt72
	)
	default Location prompt72Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt72panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt72
	)
	default RSAnchorType prompt72PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt72PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt72
	)
	default int prompt72PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt72PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt72
	)
	default int prompt72PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt72ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt72
	)
	default int prompt72ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt72Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt72
	)
	default boolean prompt72Image() { return false; }

	@ConfigItem(
			keyName = "Prompt72ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt72
	)
	default boolean prompt72ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt72PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt72
	)
	default int prompt72PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt72PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt72
	)
	default TextSize prompt72PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt72PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt72
	)
	default Color prompt72PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt72PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt72
	)
	default boolean prompt72PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt72ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt72
	)
	default boolean prompt72ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt72ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt72
	)
	default int prompt72ImageOffset() { return 0; }


	@ConfigSection(
			name = "73",
			description = "Prompt 73",
			position = 93,
			closedByDefault = true
	)
	String prompt73= "prompt73";

	@ConfigItem(
			keyName = "enablePrompt73",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt73
	)
	default boolean prompt73Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt73Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt73
	)
	default String prompt73Text() { return ""; }

	@ConfigItem(
			keyName = "prompt73Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt73
	)
	default Color prompt73Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt73Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt73
	)
	default String prompt73Times() { return ""; }

	@ConfigItem(
			keyName = "prompt73DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt73
	)
	default String prompt73DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt73Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt73
	)
	default String prompt73Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt73Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt73
	)
	default String prompt73Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt73Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt73
	)
	default String prompt73Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt73Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt73
	)
	default int prompt73Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt73RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt73
	)
	default String prompt73RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt73NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt73
	)
	default String prompt73NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt73ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt73
	)
	default String prompt73ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt73Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt73
	)
	default int prompt73Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt73Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt73
	)
	default int prompt73Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt73TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt73
	)
	default TimeUnit prompt73TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt73ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt73
	)
	default String prompt73ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt73Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt73
	)
	default boolean prompt73Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt73SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt73
	)
	default Location prompt73Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt73panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt73
	)
	default RSAnchorType prompt73PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt73PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt73
	)
	default int prompt73PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt73PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt73
	)
	default int prompt73PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt73ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt73
	)
	default int prompt73ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt73Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt73
	)
	default boolean prompt73Image() { return false; }

	@ConfigItem(
			keyName = "Prompt73ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt73
	)
	default boolean prompt73ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt73PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt73
	)
	default int prompt73PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt73PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt73
	)
	default TextSize prompt73PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt73PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt73
	)
	default Color prompt73PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt73PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt73
	)
	default boolean prompt73PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt73ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt73
	)
	default boolean prompt73ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt73ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt73
	)
	default int prompt73ImageOffset() { return 0; }


	@ConfigSection(
			name = "74",
			description = "Prompt 74",
			position = 94,
			closedByDefault = true
	)
	String prompt74= "prompt74";

	@ConfigItem(
			keyName = "enablePrompt74",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt74
	)
	default boolean prompt74Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt74Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt74
	)
	default String prompt74Text() { return ""; }

	@ConfigItem(
			keyName = "prompt74Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt74
	)
	default Color prompt74Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt74Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt74
	)
	default String prompt74Times() { return ""; }

	@ConfigItem(
			keyName = "prompt74DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt74
	)
	default String prompt74DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt74Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt74
	)
	default String prompt74Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt74Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt74
	)
	default String prompt74Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt74Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt74
	)
	default String prompt74Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt74Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt74
	)
	default int prompt74Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt74RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt74
	)
	default String prompt74RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt74NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt74
	)
	default String prompt74NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt74ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt74
	)
	default String prompt74ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt74Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt74
	)
	default int prompt74Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt74Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt74
	)
	default int prompt74Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt74TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt74
	)
	default TimeUnit prompt74TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt74ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt74
	)
	default String prompt74ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt74Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt74
	)
	default boolean prompt74Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt74SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt74
	)
	default Location prompt74Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt74panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt74
	)
	default RSAnchorType prompt74PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt74PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt74
	)
	default int prompt74PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt74PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt74
	)
	default int prompt74PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt74ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt74
	)
	default int prompt74ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt74Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt74
	)
	default boolean prompt74Image() { return false; }

	@ConfigItem(
			keyName = "Prompt74ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt74
	)
	default boolean prompt74ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt74PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt74
	)
	default int prompt74PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt74PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt74
	)
	default TextSize prompt74PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt74PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt74
	)
	default Color prompt74PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt74PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt74
	)
	default boolean prompt74PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt74ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt74
	)
	default boolean prompt74ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt74ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt74
	)
	default int prompt74ImageOffset() { return 0; }


	@ConfigSection(
			name = "75",
			description = "Prompt 75",
			position = 95,
			closedByDefault = true
	)
	String prompt75= "prompt75";

	@ConfigItem(
			keyName = "enablePrompt75",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt75
	)
	default boolean prompt75Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt75Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt75
	)
	default String prompt75Text() { return ""; }

	@ConfigItem(
			keyName = "prompt75Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt75
	)
	default Color prompt75Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt75Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt75
	)
	default String prompt75Times() { return ""; }

	@ConfigItem(
			keyName = "prompt75DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt75
	)
	default String prompt75DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt75Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt75
	)
	default String prompt75Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt75Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt75
	)
	default String prompt75Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt75Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt75
	)
	default String prompt75Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt75Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt75
	)
	default int prompt75Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt75RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt75
	)
	default String prompt75RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt75NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt75
	)
	default String prompt75NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt75ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt75
	)
	default String prompt75ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt75Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt75
	)
	default int prompt75Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt75Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt75
	)
	default int prompt75Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt75TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt75
	)
	default TimeUnit prompt75TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt75ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt75
	)
	default String prompt75ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt75Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt75
	)
	default boolean prompt75Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt75SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt75
	)
	default Location prompt75Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt75panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt75
	)
	default RSAnchorType prompt75PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt75PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt75
	)
	default int prompt75PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt75PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt75
	)
	default int prompt75PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt75ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt75
	)
	default int prompt75ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt75Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt75
	)
	default boolean prompt75Image() { return false; }

	@ConfigItem(
			keyName = "Prompt75ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt75
	)
	default boolean prompt75ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt75PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt75
	)
	default int prompt75PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt75PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt75
	)
	default TextSize prompt75PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt75PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt75
	)
	default Color prompt75PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt75PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt75
	)
	default boolean prompt75PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt75ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt75
	)
	default boolean prompt75ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt75ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt75
	)
	default int prompt75ImageOffset() { return 0; }


	@ConfigSection(
			name = "76",
			description = "Prompt 76",
			position = 96,
			closedByDefault = true
	)
	String prompt76= "prompt76";

	@ConfigItem(
			keyName = "enablePrompt76",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt76
	)
	default boolean prompt76Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt76Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt76
	)
	default String prompt76Text() { return ""; }

	@ConfigItem(
			keyName = "prompt76Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt76
	)
	default Color prompt76Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt76Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt76
	)
	default String prompt76Times() { return ""; }

	@ConfigItem(
			keyName = "prompt76DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt76
	)
	default String prompt76DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt76Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt76
	)
	default String prompt76Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt76Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt76
	)
	default String prompt76Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt76Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt76
	)
	default String prompt76Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt76Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt76
	)
	default int prompt76Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt76RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt76
	)
	default String prompt76RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt76NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt76
	)
	default String prompt76NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt76ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt76
	)
	default String prompt76ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt76Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt76
	)
	default int prompt76Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt76Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt76
	)
	default int prompt76Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt76TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt76
	)
	default TimeUnit prompt76TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt76ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt76
	)
	default String prompt76ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt76Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt76
	)
	default boolean prompt76Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt76SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt76
	)
	default Location prompt76Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt76panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt76
	)
	default RSAnchorType prompt76PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt76PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt76
	)
	default int prompt76PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt76PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt76
	)
	default int prompt76PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt76ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt76
	)
	default int prompt76ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt76Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt76
	)
	default boolean prompt76Image() { return false; }

	@ConfigItem(
			keyName = "Prompt76ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt76
	)
	default boolean prompt76ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt76PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt76
	)
	default int prompt76PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt76PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt76
	)
	default TextSize prompt76PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt76PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt76
	)
	default Color prompt76PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt76PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt76
	)
	default boolean prompt76PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt76ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt76
	)
	default boolean prompt76ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt76ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt76
	)
	default int prompt76ImageOffset() { return 0; }


	@ConfigSection(
			name = "77",
			description = "Prompt 77",
			position = 97,
			closedByDefault = true
	)
	String prompt77= "prompt77";

	@ConfigItem(
			keyName = "enablePrompt77",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt77
	)
	default boolean prompt77Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt77Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt77
	)
	default String prompt77Text() { return ""; }

	@ConfigItem(
			keyName = "prompt77Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt77
	)
	default Color prompt77Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt77Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt77
	)
	default String prompt77Times() { return ""; }

	@ConfigItem(
			keyName = "prompt77DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt77
	)
	default String prompt77DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt77Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt77
	)
	default String prompt77Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt77Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt77
	)
	default String prompt77Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt77Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt77
	)
	default String prompt77Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt77Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt77
	)
	default int prompt77Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt77RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt77
	)
	default String prompt77RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt77NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt77
	)
	default String prompt77NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt77ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt77
	)
	default String prompt77ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt77Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt77
	)
	default int prompt77Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt77Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt77
	)
	default int prompt77Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt77TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt77
	)
	default TimeUnit prompt77TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt77ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt77
	)
	default String prompt77ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt77Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt77
	)
	default boolean prompt77Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt77SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt77
	)
	default Location prompt77Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt77panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt77
	)
	default RSAnchorType prompt77PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt77PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt77
	)
	default int prompt77PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt77PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt77
	)
	default int prompt77PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt77ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt77
	)
	default int prompt77ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt77Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt77
	)
	default boolean prompt77Image() { return false; }

	@ConfigItem(
			keyName = "Prompt77ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt77
	)
	default boolean prompt77ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt77PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt77
	)
	default int prompt77PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt77PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt77
	)
	default TextSize prompt77PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt77PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt77
	)
	default Color prompt77PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt77PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt77
	)
	default boolean prompt77PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt77ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt77
	)
	default boolean prompt77ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt77ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt77
	)
	default int prompt77ImageOffset() { return 0; }


	@ConfigSection(
			name = "78",
			description = "Prompt 78",
			position = 98,
			closedByDefault = true
	)
	String prompt78= "prompt78";

	@ConfigItem(
			keyName = "enablePrompt78",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt78
	)
	default boolean prompt78Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt78Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt78
	)
	default String prompt78Text() { return ""; }

	@ConfigItem(
			keyName = "prompt78Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt78
	)
	default Color prompt78Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt78Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt78
	)
	default String prompt78Times() { return ""; }

	@ConfigItem(
			keyName = "prompt78DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt78
	)
	default String prompt78DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt78Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt78
	)
	default String prompt78Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt78Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt78
	)
	default String prompt78Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt78Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt78
	)
	default String prompt78Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt78Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt78
	)
	default int prompt78Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt78RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt78
	)
	default String prompt78RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt78NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt78
	)
	default String prompt78NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt78ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt78
	)
	default String prompt78ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt78Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt78
	)
	default int prompt78Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt78Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt78
	)
	default int prompt78Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt78TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt78
	)
	default TimeUnit prompt78TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt78ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt78
	)
	default String prompt78ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt78Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt78
	)
	default boolean prompt78Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt78SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt78
	)
	default Location prompt78Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt78panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt78
	)
	default RSAnchorType prompt78PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt78PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt78
	)
	default int prompt78PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt78PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt78
	)
	default int prompt78PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt78ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt78
	)
	default int prompt78ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt78Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt78
	)
	default boolean prompt78Image() { return false; }

	@ConfigItem(
			keyName = "Prompt78ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt78
	)
	default boolean prompt78ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt78PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt78
	)
	default int prompt78PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt78PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt78
	)
	default TextSize prompt78PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt78PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt78
	)
	default Color prompt78PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt78PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt78
	)
	default boolean prompt78PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt78ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt78
	)
	default boolean prompt78ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt78ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt78
	)
	default int prompt78ImageOffset() { return 0; }


	@ConfigSection(
			name = "79",
			description = "Prompt 79",
			position = 99,
			closedByDefault = true
	)
	String prompt79= "prompt79";

	@ConfigItem(
			keyName = "enablePrompt79",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt79
	)
	default boolean prompt79Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt79Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt79
	)
	default String prompt79Text() { return ""; }

	@ConfigItem(
			keyName = "prompt79Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt79
	)
	default Color prompt79Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt79Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt79
	)
	default String prompt79Times() { return ""; }

	@ConfigItem(
			keyName = "prompt79DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt79
	)
	default String prompt79DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt79Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt79
	)
	default String prompt79Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt79Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt79
	)
	default String prompt79Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt79Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt79
	)
	default String prompt79Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt79Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt79
	)
	default int prompt79Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt79RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt79
	)
	default String prompt79RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt79NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt79
	)
	default String prompt79NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt79ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt79
	)
	default String prompt79ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt79Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt79
	)
	default int prompt79Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt79Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt79
	)
	default int prompt79Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt79TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt79
	)
	default TimeUnit prompt79TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt79ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt79
	)
	default String prompt79ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt79Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt79
	)
	default boolean prompt79Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt79SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt79
	)
	default Location prompt79Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt79panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt79
	)
	default RSAnchorType prompt79PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt79PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt79
	)
	default int prompt79PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt79PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt79
	)
	default int prompt79PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt79ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt79
	)
	default int prompt79ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt79Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt79
	)
	default boolean prompt79Image() { return false; }

	@ConfigItem(
			keyName = "Prompt79ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt79
	)
	default boolean prompt79ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt79PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt79
	)
	default int prompt79PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt79PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt79
	)
	default TextSize prompt79PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt79PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt79
	)
	default Color prompt79PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt79PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt79
	)
	default boolean prompt79PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt79ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt79
	)
	default boolean prompt79ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt79ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt79
	)
	default int prompt79ImageOffset() { return 0; }


	@ConfigSection(
			name = "80",
			description = "Prompt 80",
			position = 100,
			closedByDefault = true
	)
	String prompt80= "prompt80";

	@ConfigItem(
			keyName = "enablePrompt80",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt80
	)
	default boolean prompt80Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt80Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt80
	)
	default String prompt80Text() { return ""; }

	@ConfigItem(
			keyName = "prompt80Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt80
	)
	default Color prompt80Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt80Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt80
	)
	default String prompt80Times() { return ""; }

	@ConfigItem(
			keyName = "prompt80DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt80
	)
	default String prompt80DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt80Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt80
	)
	default String prompt80Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt80Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt80
	)
	default String prompt80Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt80Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt80
	)
	default String prompt80Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt80Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt80
	)
	default int prompt80Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt80RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt80
	)
	default String prompt80RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt80NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt80
	)
	default String prompt80NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt80ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt80
	)
	default String prompt80ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt80Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt80
	)
	default int prompt80Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt80Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt80
	)
	default int prompt80Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt80TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt80
	)
	default TimeUnit prompt80TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt80ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt80
	)
	default String prompt80ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt80Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt80
	)
	default boolean prompt80Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt80SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt80
	)
	default Location prompt80Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt80panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt80
	)
	default RSAnchorType prompt80PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt80PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt80
	)
	default int prompt80PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt80PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt80
	)
	default int prompt80PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt80ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt80
	)
	default int prompt80ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt80Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt80
	)
	default boolean prompt80Image() { return false; }

	@ConfigItem(
			keyName = "Prompt80ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt80
	)
	default boolean prompt80ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt80PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt80
	)
	default int prompt80PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt80PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt80
	)
	default TextSize prompt80PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt80PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt80
	)
	default Color prompt80PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt80PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt80
	)
	default boolean prompt80PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt80ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt80
	)
	default boolean prompt80ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt80ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt80
	)
	default int prompt80ImageOffset() { return 0; }


	@ConfigSection(
			name = "81",
			description = "Prompt 81",
			position = 101,
			closedByDefault = true
	)
	String prompt81= "prompt81";

	@ConfigItem(
			keyName = "enablePrompt81",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt81
	)
	default boolean prompt81Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt81Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt81
	)
	default String prompt81Text() { return ""; }

	@ConfigItem(
			keyName = "prompt81Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt81
	)
	default Color prompt81Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt81Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt81
	)
	default String prompt81Times() { return ""; }

	@ConfigItem(
			keyName = "prompt81DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt81
	)
	default String prompt81DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt81Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt81
	)
	default String prompt81Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt81Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt81
	)
	default String prompt81Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt81Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt81
	)
	default String prompt81Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt81Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt81
	)
	default int prompt81Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt81RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt81
	)
	default String prompt81RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt81NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt81
	)
	default String prompt81NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt81ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt81
	)
	default String prompt81ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt81Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt81
	)
	default int prompt81Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt81Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt81
	)
	default int prompt81Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt81TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt81
	)
	default TimeUnit prompt81TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt81ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt81
	)
	default String prompt81ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt81Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt81
	)
	default boolean prompt81Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt81SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt81
	)
	default Location prompt81Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt81panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt81
	)
	default RSAnchorType prompt81PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt81PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt81
	)
	default int prompt81PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt81PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt81
	)
	default int prompt81PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt81ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt81
	)
	default int prompt81ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt81Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt81
	)
	default boolean prompt81Image() { return false; }

	@ConfigItem(
			keyName = "Prompt81ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt81
	)
	default boolean prompt81ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt81PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt81
	)
	default int prompt81PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt81PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt81
	)
	default TextSize prompt81PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt81PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt81
	)
	default Color prompt81PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt81PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt81
	)
	default boolean prompt81PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt81ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt81
	)
	default boolean prompt81ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt81ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt81
	)
	default int prompt81ImageOffset() { return 0; }


	@ConfigSection(
			name = "82",
			description = "Prompt 82",
			position = 102,
			closedByDefault = true
	)
	String prompt82= "prompt82";

	@ConfigItem(
			keyName = "enablePrompt82",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt82
	)
	default boolean prompt82Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt82Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt82
	)
	default String prompt82Text() { return ""; }

	@ConfigItem(
			keyName = "prompt82Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt82
	)
	default Color prompt82Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt82Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt82
	)
	default String prompt82Times() { return ""; }

	@ConfigItem(
			keyName = "prompt82DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt82
	)
	default String prompt82DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt82Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt82
	)
	default String prompt82Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt82Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt82
	)
	default String prompt82Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt82Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt82
	)
	default String prompt82Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt82Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt82
	)
	default int prompt82Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt82RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt82
	)
	default String prompt82RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt82NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt82
	)
	default String prompt82NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt82ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt82
	)
	default String prompt82ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt82Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt82
	)
	default int prompt82Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt82Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt82
	)
	default int prompt82Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt82TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt82
	)
	default TimeUnit prompt82TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt82ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt82
	)
	default String prompt82ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt82Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt82
	)
	default boolean prompt82Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt82SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt82
	)
	default Location prompt82Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt82panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt82
	)
	default RSAnchorType prompt82PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt82PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt82
	)
	default int prompt82PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt82PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt82
	)
	default int prompt82PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt82ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt82
	)
	default int prompt82ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt82Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt82
	)
	default boolean prompt82Image() { return false; }

	@ConfigItem(
			keyName = "Prompt82ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt82
	)
	default boolean prompt82ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt82PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt82
	)
	default int prompt82PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt82PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt82
	)
	default TextSize prompt82PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt82PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt82
	)
	default Color prompt82PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt82PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt82
	)
	default boolean prompt82PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt82ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt82
	)
	default boolean prompt82ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt82ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt82
	)
	default int prompt82ImageOffset() { return 0; }


	@ConfigSection(
			name = "83",
			description = "Prompt 83",
			position = 103,
			closedByDefault = true
	)
	String prompt83= "prompt83";

	@ConfigItem(
			keyName = "enablePrompt83",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt83
	)
	default boolean prompt83Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt83Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt83
	)
	default String prompt83Text() { return ""; }

	@ConfigItem(
			keyName = "prompt83Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt83
	)
	default Color prompt83Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt83Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt83
	)
	default String prompt83Times() { return ""; }

	@ConfigItem(
			keyName = "prompt83DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt83
	)
	default String prompt83DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt83Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt83
	)
	default String prompt83Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt83Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt83
	)
	default String prompt83Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt83Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt83
	)
	default String prompt83Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt83Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt83
	)
	default int prompt83Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt83RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt83
	)
	default String prompt83RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt83NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt83
	)
	default String prompt83NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt83ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt83
	)
	default String prompt83ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt83Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt83
	)
	default int prompt83Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt83Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt83
	)
	default int prompt83Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt83TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt83
	)
	default TimeUnit prompt83TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt83ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt83
	)
	default String prompt83ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt83Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt83
	)
	default boolean prompt83Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt83SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt83
	)
	default Location prompt83Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt83panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt83
	)
	default RSAnchorType prompt83PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt83PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt83
	)
	default int prompt83PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt83PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt83
	)
	default int prompt83PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt83ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt83
	)
	default int prompt83ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt83Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt83
	)
	default boolean prompt83Image() { return false; }

	@ConfigItem(
			keyName = "Prompt83ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt83
	)
	default boolean prompt83ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt83PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt83
	)
	default int prompt83PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt83PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt83
	)
	default TextSize prompt83PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt83PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt83
	)
	default Color prompt83PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt83PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt83
	)
	default boolean prompt83PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt83ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt83
	)
	default boolean prompt83ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt83ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt83
	)
	default int prompt83ImageOffset() { return 0; }


	@ConfigSection(
			name = "84",
			description = "Prompt 84",
			position = 104,
			closedByDefault = true
	)
	String prompt84= "prompt84";

	@ConfigItem(
			keyName = "enablePrompt84",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt84
	)
	default boolean prompt84Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt84Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt84
	)
	default String prompt84Text() { return ""; }

	@ConfigItem(
			keyName = "prompt84Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt84
	)
	default Color prompt84Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt84Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt84
	)
	default String prompt84Times() { return ""; }

	@ConfigItem(
			keyName = "prompt84DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt84
	)
	default String prompt84DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt84Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt84
	)
	default String prompt84Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt84Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt84
	)
	default String prompt84Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt84Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt84
	)
	default String prompt84Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt84Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt84
	)
	default int prompt84Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt84RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt84
	)
	default String prompt84RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt84NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt84
	)
	default String prompt84NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt84ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt84
	)
	default String prompt84ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt84Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt84
	)
	default int prompt84Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt84Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt84
	)
	default int prompt84Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt84TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt84
	)
	default TimeUnit prompt84TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt84ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt84
	)
	default String prompt84ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt84Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt84
	)
	default boolean prompt84Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt84SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt84
	)
	default Location prompt84Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt84panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt84
	)
	default RSAnchorType prompt84PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt84PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt84
	)
	default int prompt84PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt84PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt84
	)
	default int prompt84PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt84ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt84
	)
	default int prompt84ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt84Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt84
	)
	default boolean prompt84Image() { return false; }

	@ConfigItem(
			keyName = "Prompt84ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt84
	)
	default boolean prompt84ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt84PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt84
	)
	default int prompt84PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt84PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt84
	)
	default TextSize prompt84PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt84PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt84
	)
	default Color prompt84PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt84PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt84
	)
	default boolean prompt84PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt84ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt84
	)
	default boolean prompt84ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt84ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt84
	)
	default int prompt84ImageOffset() { return 0; }


	@ConfigSection(
			name = "85",
			description = "Prompt 85",
			position = 105,
			closedByDefault = true
	)
	String prompt85= "prompt85";

	@ConfigItem(
			keyName = "enablePrompt85",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt85
	)
	default boolean prompt85Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt85Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt85
	)
	default String prompt85Text() { return ""; }

	@ConfigItem(
			keyName = "prompt85Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt85
	)
	default Color prompt85Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt85Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt85
	)
	default String prompt85Times() { return ""; }

	@ConfigItem(
			keyName = "prompt85DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt85
	)
	default String prompt85DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt85Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt85
	)
	default String prompt85Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt85Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt85
	)
	default String prompt85Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt85Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt85
	)
	default String prompt85Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt85Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt85
	)
	default int prompt85Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt85RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt85
	)
	default String prompt85RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt85NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt85
	)
	default String prompt85NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt85ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt85
	)
	default String prompt85ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt85Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt85
	)
	default int prompt85Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt85Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt85
	)
	default int prompt85Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt85TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt85
	)
	default TimeUnit prompt85TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt85ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt85
	)
	default String prompt85ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt85Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt85
	)
	default boolean prompt85Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt85SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt85
	)
	default Location prompt85Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt85panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt85
	)
	default RSAnchorType prompt85PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt85PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt85
	)
	default int prompt85PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt85PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt85
	)
	default int prompt85PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt85ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt85
	)
	default int prompt85ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt85Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt85
	)
	default boolean prompt85Image() { return false; }

	@ConfigItem(
			keyName = "Prompt85ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt85
	)
	default boolean prompt85ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt85PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt85
	)
	default int prompt85PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt85PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt85
	)
	default TextSize prompt85PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt85PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt85
	)
	default Color prompt85PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt85PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt85
	)
	default boolean prompt85PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt85ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt85
	)
	default boolean prompt85ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt85ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt85
	)
	default int prompt85ImageOffset() { return 0; }


	@ConfigSection(
			name = "86",
			description = "Prompt 86",
			position = 106,
			closedByDefault = true
	)
	String prompt86= "prompt86";

	@ConfigItem(
			keyName = "enablePrompt86",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt86
	)
	default boolean prompt86Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt86Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt86
	)
	default String prompt86Text() { return ""; }

	@ConfigItem(
			keyName = "prompt86Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt86
	)
	default Color prompt86Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt86Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt86
	)
	default String prompt86Times() { return ""; }

	@ConfigItem(
			keyName = "prompt86DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt86
	)
	default String prompt86DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt86Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt86
	)
	default String prompt86Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt86Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt86
	)
	default String prompt86Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt86Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt86
	)
	default String prompt86Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt86Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt86
	)
	default int prompt86Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt86RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt86
	)
	default String prompt86RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt86NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt86
	)
	default String prompt86NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt86ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt86
	)
	default String prompt86ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt86Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt86
	)
	default int prompt86Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt86Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt86
	)
	default int prompt86Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt86TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt86
	)
	default TimeUnit prompt86TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt86ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt86
	)
	default String prompt86ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt86Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt86
	)
	default boolean prompt86Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt86SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt86
	)
	default Location prompt86Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt86panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt86
	)
	default RSAnchorType prompt86PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt86PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt86
	)
	default int prompt86PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt86PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt86
	)
	default int prompt86PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt86ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt86
	)
	default int prompt86ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt86Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt86
	)
	default boolean prompt86Image() { return false; }

	@ConfigItem(
			keyName = "Prompt86ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt86
	)
	default boolean prompt86ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt86PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt86
	)
	default int prompt86PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt86PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt86
	)
	default TextSize prompt86PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt86PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt86
	)
	default Color prompt86PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt86PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt86
	)
	default boolean prompt86PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt86ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt86
	)
	default boolean prompt86ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt86ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt86
	)
	default int prompt86ImageOffset() { return 0; }


	@ConfigSection(
			name = "87",
			description = "Prompt 87",
			position = 107,
			closedByDefault = true
	)
	String prompt87= "prompt87";

	@ConfigItem(
			keyName = "enablePrompt87",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt87
	)
	default boolean prompt87Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt87Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt87
	)
	default String prompt87Text() { return ""; }

	@ConfigItem(
			keyName = "prompt87Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt87
	)
	default Color prompt87Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt87Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt87
	)
	default String prompt87Times() { return ""; }

	@ConfigItem(
			keyName = "prompt87DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt87
	)
	default String prompt87DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt87Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt87
	)
	default String prompt87Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt87Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt87
	)
	default String prompt87Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt87Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt87
	)
	default String prompt87Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt87Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt87
	)
	default int prompt87Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt87RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt87
	)
	default String prompt87RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt87NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt87
	)
	default String prompt87NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt87ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt87
	)
	default String prompt87ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt87Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt87
	)
	default int prompt87Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt87Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt87
	)
	default int prompt87Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt87TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt87
	)
	default TimeUnit prompt87TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt87ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt87
	)
	default String prompt87ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt87Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt87
	)
	default boolean prompt87Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt87SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt87
	)
	default Location prompt87Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt87panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt87
	)
	default RSAnchorType prompt87PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt87PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt87
	)
	default int prompt87PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt87PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt87
	)
	default int prompt87PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt87ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt87
	)
	default int prompt87ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt87Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt87
	)
	default boolean prompt87Image() { return false; }

	@ConfigItem(
			keyName = "Prompt87ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt87
	)
	default boolean prompt87ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt87PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt87
	)
	default int prompt87PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt87PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt87
	)
	default TextSize prompt87PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt87PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt87
	)
	default Color prompt87PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt87PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt87
	)
	default boolean prompt87PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt87ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt87
	)
	default boolean prompt87ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt87ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt87
	)
	default int prompt87ImageOffset() { return 0; }


	@ConfigSection(
			name = "88",
			description = "Prompt 88",
			position = 108,
			closedByDefault = true
	)
	String prompt88= "prompt88";

	@ConfigItem(
			keyName = "enablePrompt88",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt88
	)
	default boolean prompt88Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt88Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt88
	)
	default String prompt88Text() { return ""; }

	@ConfigItem(
			keyName = "prompt88Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt88
	)
	default Color prompt88Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt88Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt88
	)
	default String prompt88Times() { return ""; }

	@ConfigItem(
			keyName = "prompt88DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt88
	)
	default String prompt88DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt88Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt88
	)
	default String prompt88Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt88Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt88
	)
	default String prompt88Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt88Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt88
	)
	default String prompt88Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt88Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt88
	)
	default int prompt88Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt88RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt88
	)
	default String prompt88RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt88NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt88
	)
	default String prompt88NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt88ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt88
	)
	default String prompt88ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt88Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt88
	)
	default int prompt88Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt88Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt88
	)
	default int prompt88Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt88TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt88
	)
	default TimeUnit prompt88TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt88ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt88
	)
	default String prompt88ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt88Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt88
	)
	default boolean prompt88Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt88SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt88
	)
	default Location prompt88Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt88panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt88
	)
	default RSAnchorType prompt88PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt88PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt88
	)
	default int prompt88PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt88PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt88
	)
	default int prompt88PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt88ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt88
	)
	default int prompt88ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt88Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt88
	)
	default boolean prompt88Image() { return false; }

	@ConfigItem(
			keyName = "Prompt88ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt88
	)
	default boolean prompt88ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt88PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt88
	)
	default int prompt88PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt88PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt88
	)
	default TextSize prompt88PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt88PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt88
	)
	default Color prompt88PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt88PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt88
	)
	default boolean prompt88PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt88ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt88
	)
	default boolean prompt88ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt88ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt88
	)
	default int prompt88ImageOffset() { return 0; }


	@ConfigSection(
			name = "89",
			description = "Prompt 89",
			position = 109,
			closedByDefault = true
	)
	String prompt89= "prompt89";

	@ConfigItem(
			keyName = "enablePrompt89",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt89
	)
	default boolean prompt89Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt89Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt89
	)
	default String prompt89Text() { return ""; }

	@ConfigItem(
			keyName = "prompt89Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt89
	)
	default Color prompt89Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt89Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt89
	)
	default String prompt89Times() { return ""; }

	@ConfigItem(
			keyName = "prompt89DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt89
	)
	default String prompt89DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt89Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt89
	)
	default String prompt89Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt89Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt89
	)
	default String prompt89Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt89Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt89
	)
	default String prompt89Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt89Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt89
	)
	default int prompt89Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt89RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt89
	)
	default String prompt89RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt89NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt89
	)
	default String prompt89NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt89ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt89
	)
	default String prompt89ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt89Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt89
	)
	default int prompt89Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt89Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt89
	)
	default int prompt89Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt89TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt89
	)
	default TimeUnit prompt89TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt89ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt89
	)
	default String prompt89ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt89Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt89
	)
	default boolean prompt89Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt89SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt89
	)
	default Location prompt89Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt89panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt89
	)
	default RSAnchorType prompt89PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt89PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt89
	)
	default int prompt89PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt89PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt89
	)
	default int prompt89PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt89ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt89
	)
	default int prompt89ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt89Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt89
	)
	default boolean prompt89Image() { return false; }

	@ConfigItem(
			keyName = "Prompt89ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt89
	)
	default boolean prompt89ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt89PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt89
	)
	default int prompt89PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt89PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt89
	)
	default TextSize prompt89PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt89PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt89
	)
	default Color prompt89PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt89PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt89
	)
	default boolean prompt89PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt89ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt89
	)
	default boolean prompt89ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt89ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt89
	)
	default int prompt89ImageOffset() { return 0; }


	@ConfigSection(
			name = "90",
			description = "Prompt 90",
			position = 110,
			closedByDefault = true
	)
	String prompt90= "prompt90";

	@ConfigItem(
			keyName = "enablePrompt90",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt90
	)
	default boolean prompt90Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt90Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt90
	)
	default String prompt90Text() { return ""; }

	@ConfigItem(
			keyName = "prompt90Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt90
	)
	default Color prompt90Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt90Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt90
	)
	default String prompt90Times() { return ""; }

	@ConfigItem(
			keyName = "prompt90DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt90
	)
	default String prompt90DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt90Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt90
	)
	default String prompt90Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt90Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt90
	)
	default String prompt90Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt90Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt90
	)
	default String prompt90Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt90Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt90
	)
	default int prompt90Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt90RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt90
	)
	default String prompt90RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt90NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt90
	)
	default String prompt90NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt90ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt90
	)
	default String prompt90ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt90Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt90
	)
	default int prompt90Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt90Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt90
	)
	default int prompt90Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt90TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt90
	)
	default TimeUnit prompt90TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt90ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt90
	)
	default String prompt90ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt90Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt90
	)
	default boolean prompt90Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt90SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt90
	)
	default Location prompt90Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt90panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt90
	)
	default RSAnchorType prompt90PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt90PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt90
	)
	default int prompt90PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt90PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt90
	)
	default int prompt90PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt90ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt90
	)
	default int prompt90ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt90Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt90
	)
	default boolean prompt90Image() { return false; }

	@ConfigItem(
			keyName = "Prompt90ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt90
	)
	default boolean prompt90ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt90PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt90
	)
	default int prompt90PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt90PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt90
	)
	default TextSize prompt90PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt90PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt90
	)
	default Color prompt90PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt90PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt90
	)
	default boolean prompt90PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt90ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt90
	)
	default boolean prompt90ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt90ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt90
	)
	default int prompt90ImageOffset() { return 0; }


	@ConfigSection(
			name = "91",
			description = "Prompt 91",
			position = 111,
			closedByDefault = true
	)
	String prompt91= "prompt91";

	@ConfigItem(
			keyName = "enablePrompt91",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt91
	)
	default boolean prompt91Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt91Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt91
	)
	default String prompt91Text() { return ""; }

	@ConfigItem(
			keyName = "prompt91Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt91
	)
	default Color prompt91Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt91Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt91
	)
	default String prompt91Times() { return ""; }

	@ConfigItem(
			keyName = "prompt91DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt91
	)
	default String prompt91DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt91Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt91
	)
	default String prompt91Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt91Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt91
	)
	default String prompt91Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt91Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt91
	)
	default String prompt91Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt91Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt91
	)
	default int prompt91Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt91RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt91
	)
	default String prompt91RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt91NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt91
	)
	default String prompt91NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt91ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt91
	)
	default String prompt91ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt91Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt91
	)
	default int prompt91Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt91Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt91
	)
	default int prompt91Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt91TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt91
	)
	default TimeUnit prompt91TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt91ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt91
	)
	default String prompt91ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt91Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt91
	)
	default boolean prompt91Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt91SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt91
	)
	default Location prompt91Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt91panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt91
	)
	default RSAnchorType prompt91PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt91PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt91
	)
	default int prompt91PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt91PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt91
	)
	default int prompt91PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt91ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt91
	)
	default int prompt91ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt91Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt91
	)
	default boolean prompt91Image() { return false; }

	@ConfigItem(
			keyName = "Prompt91ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt91
	)
	default boolean prompt91ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt91PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt91
	)
	default int prompt91PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt91PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt91
	)
	default TextSize prompt91PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt91PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt91
	)
	default Color prompt91PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt91PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt91
	)
	default boolean prompt91PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt91ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt91
	)
	default boolean prompt91ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt91ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt91
	)
	default int prompt91ImageOffset() { return 0; }


	@ConfigSection(
			name = "92",
			description = "Prompt 92",
			position = 112,
			closedByDefault = true
	)
	String prompt92= "prompt92";

	@ConfigItem(
			keyName = "enablePrompt92",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt92
	)
	default boolean prompt92Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt92Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt92
	)
	default String prompt92Text() { return ""; }

	@ConfigItem(
			keyName = "prompt92Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt92
	)
	default Color prompt92Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt92Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt92
	)
	default String prompt92Times() { return ""; }

	@ConfigItem(
			keyName = "prompt92DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt92
	)
	default String prompt92DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt92Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt92
	)
	default String prompt92Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt92Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt92
	)
	default String prompt92Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt92Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt92
	)
	default String prompt92Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt92Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt92
	)
	default int prompt92Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt92RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt92
	)
	default String prompt92RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt92NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt92
	)
	default String prompt92NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt92ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt92
	)
	default String prompt92ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt92Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt92
	)
	default int prompt92Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt92Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt92
	)
	default int prompt92Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt92TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt92
	)
	default TimeUnit prompt92TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt92ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt92
	)
	default String prompt92ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt92Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt92
	)
	default boolean prompt92Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt92SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt92
	)
	default Location prompt92Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt92panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt92
	)
	default RSAnchorType prompt92PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt92PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt92
	)
	default int prompt92PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt92PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt92
	)
	default int prompt92PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt92ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt92
	)
	default int prompt92ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt92Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt92
	)
	default boolean prompt92Image() { return false; }

	@ConfigItem(
			keyName = "Prompt92ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt92
	)
	default boolean prompt92ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt92PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt92
	)
	default int prompt92PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt92PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt92
	)
	default TextSize prompt92PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt92PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt92
	)
	default Color prompt92PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt92PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt92
	)
	default boolean prompt92PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt92ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt92
	)
	default boolean prompt92ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt92ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt92
	)
	default int prompt92ImageOffset() { return 0; }


	@ConfigSection(
			name = "93",
			description = "Prompt 93",
			position = 113,
			closedByDefault = true
	)
	String prompt93= "prompt93";

	@ConfigItem(
			keyName = "enablePrompt93",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt93
	)
	default boolean prompt93Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt93Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt93
	)
	default String prompt93Text() { return ""; }

	@ConfigItem(
			keyName = "prompt93Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt93
	)
	default Color prompt93Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt93Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt93
	)
	default String prompt93Times() { return ""; }

	@ConfigItem(
			keyName = "prompt93DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt93
	)
	default String prompt93DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt93Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt93
	)
	default String prompt93Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt93Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt93
	)
	default String prompt93Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt93Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt93
	)
	default String prompt93Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt93Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt93
	)
	default int prompt93Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt93RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt93
	)
	default String prompt93RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt93NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt93
	)
	default String prompt93NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt93ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt93
	)
	default String prompt93ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt93Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt93
	)
	default int prompt93Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt93Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt93
	)
	default int prompt93Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt93TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt93
	)
	default TimeUnit prompt93TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt93ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt93
	)
	default String prompt93ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt93Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt93
	)
	default boolean prompt93Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt93SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt93
	)
	default Location prompt93Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt93panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt93
	)
	default RSAnchorType prompt93PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt93PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt93
	)
	default int prompt93PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt93PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt93
	)
	default int prompt93PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt93ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt93
	)
	default int prompt93ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt93Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt93
	)
	default boolean prompt93Image() { return false; }

	@ConfigItem(
			keyName = "Prompt93ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt93
	)
	default boolean prompt93ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt93PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt93
	)
	default int prompt93PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt93PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt93
	)
	default TextSize prompt93PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt93PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt93
	)
	default Color prompt93PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt93PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt93
	)
	default boolean prompt93PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt93ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt93
	)
	default boolean prompt93ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt93ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt93
	)
	default int prompt93ImageOffset() { return 0; }


	@ConfigSection(
			name = "94",
			description = "Prompt 94",
			position = 114,
			closedByDefault = true
	)
	String prompt94= "prompt94";

	@ConfigItem(
			keyName = "enablePrompt94",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt94
	)
	default boolean prompt94Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt94Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt94
	)
	default String prompt94Text() { return ""; }

	@ConfigItem(
			keyName = "prompt94Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt94
	)
	default Color prompt94Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt94Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt94
	)
	default String prompt94Times() { return ""; }

	@ConfigItem(
			keyName = "prompt94DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt94
	)
	default String prompt94DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt94Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt94
	)
	default String prompt94Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt94Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt94
	)
	default String prompt94Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt94Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt94
	)
	default String prompt94Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt94Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt94
	)
	default int prompt94Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt94RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt94
	)
	default String prompt94RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt94NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt94
	)
	default String prompt94NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt94ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt94
	)
	default String prompt94ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt94Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt94
	)
	default int prompt94Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt94Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt94
	)
	default int prompt94Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt94TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt94
	)
	default TimeUnit prompt94TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt94ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt94
	)
	default String prompt94ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt94Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt94
	)
	default boolean prompt94Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt94SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt94
	)
	default Location prompt94Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt94panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt94
	)
	default RSAnchorType prompt94PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt94PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt94
	)
	default int prompt94PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt94PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt94
	)
	default int prompt94PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt94ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt94
	)
	default int prompt94ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt94Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt94
	)
	default boolean prompt94Image() { return false; }

	@ConfigItem(
			keyName = "Prompt94ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt94
	)
	default boolean prompt94ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt94PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt94
	)
	default int prompt94PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt94PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt94
	)
	default TextSize prompt94PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt94PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt94
	)
	default Color prompt94PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt94PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt94
	)
	default boolean prompt94PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt94ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt94
	)
	default boolean prompt94ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt94ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt94
	)
	default int prompt94ImageOffset() { return 0; }


	@ConfigSection(
			name = "95",
			description = "Prompt 95",
			position = 115,
			closedByDefault = true
	)
	String prompt95= "prompt95";

	@ConfigItem(
			keyName = "enablePrompt95",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt95
	)
	default boolean prompt95Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt95Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt95
	)
	default String prompt95Text() { return ""; }

	@ConfigItem(
			keyName = "prompt95Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt95
	)
	default Color prompt95Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt95Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt95
	)
	default String prompt95Times() { return ""; }

	@ConfigItem(
			keyName = "prompt95DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt95
	)
	default String prompt95DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt95Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt95
	)
	default String prompt95Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt95Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt95
	)
	default String prompt95Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt95Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt95
	)
	default String prompt95Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt95Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt95
	)
	default int prompt95Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt95RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt95
	)
	default String prompt95RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt95NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt95
	)
	default String prompt95NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt95ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt95
	)
	default String prompt95ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt95Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt95
	)
	default int prompt95Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt95Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt95
	)
	default int prompt95Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt95TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt95
	)
	default TimeUnit prompt95TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt95ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt95
	)
	default String prompt95ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt95Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt95
	)
	default boolean prompt95Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt95SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt95
	)
	default Location prompt95Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt95panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt95
	)
	default RSAnchorType prompt95PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt95PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt95
	)
	default int prompt95PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt95PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt95
	)
	default int prompt95PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt95ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt95
	)
	default int prompt95ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt95Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt95
	)
	default boolean prompt95Image() { return false; }

	@ConfigItem(
			keyName = "Prompt95ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt95
	)
	default boolean prompt95ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt95PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt95
	)
	default int prompt95PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt95PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt95
	)
	default TextSize prompt95PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt95PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt95
	)
	default Color prompt95PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt95PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt95
	)
	default boolean prompt95PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt95ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt95
	)
	default boolean prompt95ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt95ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt95
	)
	default int prompt95ImageOffset() { return 0; }


	@ConfigSection(
			name = "96",
			description = "Prompt 96",
			position = 116,
			closedByDefault = true
	)
	String prompt96= "prompt96";

	@ConfigItem(
			keyName = "enablePrompt96",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt96
	)
	default boolean prompt96Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt96Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt96
	)
	default String prompt96Text() { return ""; }

	@ConfigItem(
			keyName = "prompt96Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt96
	)
	default Color prompt96Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt96Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt96
	)
	default String prompt96Times() { return ""; }

	@ConfigItem(
			keyName = "prompt96DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt96
	)
	default String prompt96DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt96Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt96
	)
	default String prompt96Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt96Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt96
	)
	default String prompt96Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt96Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt96
	)
	default String prompt96Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt96Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt96
	)
	default int prompt96Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt96RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt96
	)
	default String prompt96RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt96NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt96
	)
	default String prompt96NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt96ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt96
	)
	default String prompt96ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt96Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt96
	)
	default int prompt96Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt96Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt96
	)
	default int prompt96Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt96TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt96
	)
	default TimeUnit prompt96TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt96ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt96
	)
	default String prompt96ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt96Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt96
	)
	default boolean prompt96Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt96SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt96
	)
	default Location prompt96Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt96panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt96
	)
	default RSAnchorType prompt96PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt96PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt96
	)
	default int prompt96PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt96PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt96
	)
	default int prompt96PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt96ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt96
	)
	default int prompt96ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt96Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt96
	)
	default boolean prompt96Image() { return false; }

	@ConfigItem(
			keyName = "Prompt96ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt96
	)
	default boolean prompt96ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt96PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt96
	)
	default int prompt96PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt96PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt96
	)
	default TextSize prompt96PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt96PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt96
	)
	default Color prompt96PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt96PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt96
	)
	default boolean prompt96PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt96ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt96
	)
	default boolean prompt96ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt96ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt96
	)
	default int prompt96ImageOffset() { return 0; }


	@ConfigSection(
			name = "97",
			description = "Prompt 97",
			position = 117,
			closedByDefault = true
	)
	String prompt97= "prompt97";

	@ConfigItem(
			keyName = "enablePrompt97",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt97
	)
	default boolean prompt97Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt97Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt97
	)
	default String prompt97Text() { return ""; }

	@ConfigItem(
			keyName = "prompt97Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt97
	)
	default Color prompt97Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt97Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt97
	)
	default String prompt97Times() { return ""; }

	@ConfigItem(
			keyName = "prompt97DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt97
	)
	default String prompt97DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt97Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt97
	)
	default String prompt97Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt97Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt97
	)
	default String prompt97Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt97Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt97
	)
	default String prompt97Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt97Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt97
	)
	default int prompt97Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt97RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt97
	)
	default String prompt97RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt97NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt97
	)
	default String prompt97NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt97ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt97
	)
	default String prompt97ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt97Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt97
	)
	default int prompt97Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt97Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt97
	)
	default int prompt97Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt97TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt97
	)
	default TimeUnit prompt97TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt97ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt97
	)
	default String prompt97ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt97Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt97
	)
	default boolean prompt97Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt97SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt97
	)
	default Location prompt97Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt97panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt97
	)
	default RSAnchorType prompt97PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt97PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt97
	)
	default int prompt97PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt97PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt97
	)
	default int prompt97PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt97ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt97
	)
	default int prompt97ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt97Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt97
	)
	default boolean prompt97Image() { return false; }

	@ConfigItem(
			keyName = "Prompt97ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt97
	)
	default boolean prompt97ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt97PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt97
	)
	default int prompt97PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt97PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt97
	)
	default TextSize prompt97PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt97PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt97
	)
	default Color prompt97PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt97PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt97
	)
	default boolean prompt97PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt97ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt97
	)
	default boolean prompt97ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt97ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt97
	)
	default int prompt97ImageOffset() { return 0; }


	@ConfigSection(
			name = "98",
			description = "Prompt 98",
			position = 118,
			closedByDefault = true
	)
	String prompt98= "prompt98";

	@ConfigItem(
			keyName = "enablePrompt98",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt98
	)
	default boolean prompt98Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt98Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt98
	)
	default String prompt98Text() { return ""; }

	@ConfigItem(
			keyName = "prompt98Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt98
	)
	default Color prompt98Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt98Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt98
	)
	default String prompt98Times() { return ""; }

	@ConfigItem(
			keyName = "prompt98DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt98
	)
	default String prompt98DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt98Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt98
	)
	default String prompt98Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt98Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt98
	)
	default String prompt98Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt98Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt98
	)
	default String prompt98Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt98Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt98
	)
	default int prompt98Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt98RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt98
	)
	default String prompt98RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt98NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt98
	)
	default String prompt98NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt98ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt98
	)
	default String prompt98ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt98Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt98
	)
	default int prompt98Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt98Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt98
	)
	default int prompt98Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt98TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt98
	)
	default TimeUnit prompt98TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt98ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt98
	)
	default String prompt98ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt98Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt98
	)
	default boolean prompt98Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt98SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt98
	)
	default Location prompt98Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt98panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt98
	)
	default RSAnchorType prompt98PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt98PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt98
	)
	default int prompt98PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt98PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt98
	)
	default int prompt98PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt98ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt98
	)
	default int prompt98ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt98Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt98
	)
	default boolean prompt98Image() { return false; }

	@ConfigItem(
			keyName = "Prompt98ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt98
	)
	default boolean prompt98ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt98PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt98
	)
	default int prompt98PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt98PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt98
	)
	default TextSize prompt98PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt98PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt98
	)
	default Color prompt98PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt98PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt98
	)
	default boolean prompt98PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt98ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt98
	)
	default boolean prompt98ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt98ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt98
	)
	default int prompt98ImageOffset() { return 0; }


	@ConfigSection(
			name = "99",
			description = "Prompt 99",
			position = 119,
			closedByDefault = true
	)
	String prompt99= "prompt99";

	@ConfigItem(
			keyName = "enablePrompt99",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt99
	)
	default boolean prompt99Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt99Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt99
	)
	default String prompt99Text() { return ""; }

	@ConfigItem(
			keyName = "prompt99Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt99
	)
	default Color prompt99Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt99Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt99
	)
	default String prompt99Times() { return ""; }

	@ConfigItem(
			keyName = "prompt99DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt99
	)
	default String prompt99DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt99Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt99
	)
	default String prompt99Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt99Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt99
	)
	default String prompt99Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt99Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt99
	)
	default String prompt99Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt99Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt99
	)
	default int prompt99Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt99RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt99
	)
	default String prompt99RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt99NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt99
	)
	default String prompt99NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt99ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt99
	)
	default String prompt99ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt99Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt99
	)
	default int prompt99Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt99Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt99
	)
	default int prompt99Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt99TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt99
	)
	default TimeUnit prompt99TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt99ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt99
	)
	default String prompt99ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt99Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt99
	)
	default boolean prompt99Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt99SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt99
	)
	default Location prompt99Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt99panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt99
	)
	default RSAnchorType prompt99PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt99PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt99
	)
	default int prompt99PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt99PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt99
	)
	default int prompt99PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt99ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt99
	)
	default int prompt99ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt99Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt99
	)
	default boolean prompt99Image() { return false; }

	@ConfigItem(
			keyName = "Prompt99ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt99
	)
	default boolean prompt99ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt99PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt99
	)
	default int prompt99PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt99PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt99
	)
	default TextSize prompt99PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt99PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt99
	)
	default Color prompt99PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt99PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt99
	)
	default boolean prompt99PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt99ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt99
	)
	default boolean prompt99ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt99ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt99
	)
	default int prompt99ImageOffset() { return 0; }


	@ConfigSection(
			name = "100",
			description = "Prompt 100",
			position = 120,
			closedByDefault = true
	)
	String prompt100= "prompt100";

	@ConfigItem(
			keyName = "enablePrompt100",
			position = 0,
			name = "Enable",
			description = "Configures whether or not prompt is enabled.",
			section = prompt100
	)
	default boolean prompt100Enable()  { return false; }

	@ConfigItem(
			keyName = "prompt100Text",
			position = 1,
			name = "Text",
			description = "Configures the text.",
			section = prompt100
	)
	default String prompt100Text() { return ""; }

	@ConfigItem(
			keyName = "prompt100Color",
			position = 2,
			name = "Color",
			description = "Configures the color.",
			section = prompt100
	)
	default Color prompt100Color() { return Color.WHITE; }

	@ConfigItem(
			keyName = "prompt100Times",
			position = 37,
			name = "Times",
			description = "Configures what times prompt is shown. Set times 10:00pm, 7:30pm or spans 8:30am-12:00pm, 10:00pm-1:00am. (comma separated).",
			section = prompt100
	)
	default String prompt100Times() { return ""; }

	@ConfigItem(
			keyName = "prompt100DaysOfWeek",
			position = 38,
			name = "Days",
			description = "Configures what days of week prompt is shown, e.g. Mon, Thu (comma separated).",
			section = prompt100
	)
	default String prompt100DaysOfWeek() { return ""; }

	@ConfigItem(
			keyName = "prompt100Datess",
			position = 39,
			name = "Dates",
			description = "Configures what dates prompt is shown. Set dates 04/30, 05/28/23 or ranges 9/20/22-10/30/22, 7/20-8/9. (comma separated).",
			section = prompt100
	)
	default String prompt100Dates() { return ""; }

	@ConfigItem(
			keyName = "prompt100Coordinates",
			position = 30,
			name = "Coordinates",
			description = "Configures coordinates where prompt is shown (x, y), e.g. (40, 50), (1000, 750) (comma separated).",
			section = prompt100
	)
	default String prompt100Coordinates() { return ""; }

	@ConfigItem(
			keyName = "prompt100Geofences",
			position = 31,
			name = "Geofences",
			description = "Configures geofences where prompt is shown (west, north, east, south), e.g. (40, 50, 1000, 750) (comma separated).",
			section = prompt100
	)
	default String prompt100Geofences() { return ""; }

	@ConfigItem(
			keyName = "prompt100Radius",
			position = 32,
			name = "Coordinate Radius",
			description = "Configures how far away from coordinates prompt is shown.",
			section = prompt100
	)
	default int prompt100Radius() { return 0; }

	@ConfigItem(
			keyName = "Prompt100RegionId",
			position = 33,
			name = "Regions",
			description = "Configures region ids when prompt is shown (comma separated).",
			section = prompt100
	)
	default String prompt100RegionIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt100NpcIds",
			position = 34,
			name = "Npcs",
			description = "Configures the npc ids when prompt is shown (comma separated).",
			section = prompt100
	)
	default String prompt100NpcIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt100ItemIds",
			position = 35,
			name = "Items",
			description = "Configures the item ids when prompt is shown (comma separated).",
			section = prompt100
	)
	default String prompt100ItemIds() { return ""; }

	@ConfigItem(
			keyName = "Prompt100Duration",
			position = 3,
			name = "Duration",
			description = "Configures the duration for prompt.",
			section = prompt100
	)
	default int prompt100Duration() { return 0; }

	@ConfigItem(
			keyName = "Prompt100Cooldown",
			position = 4,
			name = "Cooldown",
			description = "Configures how long before prompt can be shown again.",
			section = prompt100
	)
	default int prompt100Cooldown() { return 0; }

	@ConfigItem(
			keyName = "Prompt100TimeUnit",
			position = 5,
			name = "Time Unit",
			description = "Configures the time unit for duration and cooldown.",
			section = prompt100
	)
	default TimeUnit prompt100TimeUnit() { return TimeUnit.SECONDS; }

	@ConfigItem(
			keyName = "Prompt100ChatPatterns",
			position = 36,
			name = "Patterns",
			description = "Configures text or regex patterns to match in messages to show prompt. (comma seperated)",
			section = prompt100
	)
	default String prompt100ChatPatterns() { return ""; }

	@ConfigItem(
			keyName = "Prompt100Notification",
			position = 6,
			name = "Notification",
			description = "Configures whether or not to show a background notification.",
			section = prompt100
	)
	default boolean prompt100Notify() { return false; }

	@ConfigItem(
			keyName = "Prompt100SeparatePanel",
			position = 7,
			name = "Location",
			description = "Configures the location for prompt.",
			section = prompt100
	)
	default Location prompt100Location() { return Location.IN_LIST; }

	@ConfigItem(
			keyName = "Prompt100panelAnchorType",
			position = 8,
			name = "Panel Anchor Type",
			description = "Configures the anchor type for the panel.",
			section = prompt100
	)
	default RSAnchorType prompt100PanelAnchorType() { return RSAnchorType.TOP_LEFT; }

	@ConfigItem(
			keyName = "Prompt100PanelAnchorX",
			position = 9,
			name = "Panel Anchor X",
			description = "Configures the anchor x position for the panel.",
			section = prompt100
	)
	default int prompt100PanelAnchorX() { return 0; }

	@ConfigItem(
			keyName = "Prompt100PanelAnchorY",
			position = 10,
			name = "Panel Anchor Y",
			description = "Configures the anchor y position for the panel.",
			section = prompt100
	)
	default int prompt100PanelAnchorY() { return 0; }

	@ConfigItem(
			keyName = "Prompt100ImageId",
			position = 14,
			name = "Image ID",
			description = "Configures the image id.",
			section = prompt100
	)
	default int prompt100ImageId() { return 0; }

	@ConfigItem(
			keyName = "Prompt100Image",
			position = 13,
			name = "Image",
			description = "Configures whether or not the prompt has an image.",
			section = prompt100
	)
	default boolean prompt100Image() { return false; }

	@ConfigItem(
			keyName = "Prompt100ImageOffsetNegative",
			position = 14,
			name = "Offset Negative",
			description = "Configures whether or not the image offset is a negative number.",
			section = prompt100
	)
	default boolean prompt100ImageOffsetNegative() { return false; }


	@ConfigItem(
			keyName = "Prompt100PanelWidth",
			position = 11,
			name = "Word Wrap Width",
			description = "Configures width for panel.",
			section = prompt100
	)
	default int prompt100PanelWidth() { return 140; }


	@ConfigItem(
			keyName = "Prompt100PanelTextSize",
			position = 12,
			name = "Panel Text Size",
			description = "Configures the text Size.",
			section = prompt100
	)
	default TextSize prompt100PanelTextSize() { return TextSize.SMALL; }


	@ConfigItem(
			keyName = "Prompt100PanelColor",
			position = 12,
			name = "Panel Color",
			description = "Configures panel color.",
			section = prompt100
	)
	default Color prompt100PanelColor() { return new Color(115, 115, 115); }

	@Alpha
	@ConfigItem(
			keyName = "Prompt100PanelBorder",
			position = 12,
			name = "Panel Border",
			description = "Configures whether or not panel has a border.",
			section = prompt100
	)
	default boolean prompt100PanelBorder() { return true; }


	@ConfigItem(
			keyName = "Prompt100ForceShow",
			position = 0,
			name = "Force",
			description = "Configures whether or not to force show prompt.",
			section = prompt100
	)
	default boolean prompt100ForceShow() { return false; }

	@ConfigItem(
			keyName = "Prompt100ImageOffset",
			position = 14,
			name = "Image Offset",
			description = "Configures offset for image.",
			section = prompt100
	)
	default int prompt100ImageOffset() { return 0; }
}