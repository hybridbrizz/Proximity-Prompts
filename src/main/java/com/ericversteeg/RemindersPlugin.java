package com.ericversteeg;

import com.ericversteeg.reminder.Reminder;
import com.ericversteeg.reminder.Reminders;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.util.*;
import java.util.List;

@PluginDescriptor(
	name = "Reminders",
	description = "Show reminders."
)

public class RemindersPlugin extends Plugin {
	@Inject
	private RemindersOverlay overlay;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private Client client;
	@Inject
	private RemindersConfig config;
	@Inject
	private ConfigManager configManager;
	@Inject
	private Gson gson;

	@Inject
	private ItemManager itemManager;

	List<Reminder> activeReminders = new ArrayList<>();

	LocalDateTime dateTime = LocalDateTime.now(ZoneId.systemDefault());

	int regionId = 0;
	int lastRegionId = 0;

	List<NPC> npcs = new ArrayList<>();

	List<ItemComposition> inventoryItems = new ArrayList<>();

	WorldPoint worldPos = new WorldPoint(0, 0, 0);

	boolean progressUpdated = false;

	// so the first hit after a reset is tracked
	private Map<Integer, Integer> skillsXp = new HashMap<>();

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(overlay);
	}

	@Provides
	RemindersConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(RemindersConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config) {

	}

	@Subscribe
	public void onGameTick(GameTick tick) {
		dateTime = LocalDateTime.now(ZoneId.systemDefault());

		activeReminders = getActiveReminders();

		//overlay.updateViews();

		inventoryItems.clear();

		regionId = WorldPoint.fromLocalInstance(
				client,
				client.getLocalPlayer().getLocalLocation()
		).getRegionID();

		lastRegionId = regionId;

		worldPos = client.getLocalPlayer().getWorldLocation();

		final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer == null) {
			return;
		}

		final Item[] items = itemContainer.getItems();
		for (Item item : items) {
			ItemComposition itemComposition = itemManager.getItemComposition(item.getId());

			if (!itemsContainsName(itemComposition.getName())) {
				inventoryItems.add(itemComposition);
			}
		}
	}

	@Subscribe(priority = -1)
	private void onNpcSpawned(NpcSpawned npcSpawned) {
		NPC npc = npcSpawned.getNpc();
		npcs.add(npc);
	}

	@Subscribe(priority = -1)
	public void onNpcDespawned(NpcDespawned npcDespawned) {
		NPC npc = npcDespawned.getNpc();
		npcs.remove(npc);
	}


	private boolean npcsContainsName(String name) {
		for (NPC npc : npcs) {
			if (name.equals(npc.getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean itemsContainsName(String name) {
		for (ItemComposition item : inventoryItems) {
			if (name.equals(item.getName())) {
				return true;
			}
		}
		return false;
	}

	private List<Reminder> getActiveReminders()
	{
		long start = Instant.now().toEpochMilli();

		List<Reminder> activeList = new ArrayList<>();

		for (int i = 1; i <= 100; i++)
		{
			Reminder reminder = new Reminder();

			reminder.id = i;
			reminder.enable = isEnable(i);
			reminder.text = getText(i);
			reminder.text = reminder.text
					.substring(0, Math.min(reminder.text.length(), 255));
			reminder.colur = getColor(i);
			reminder.times = getTimes(i);
			reminder.daysOfWeek = getDaysOfWeek(i);
			reminder.dates = getDates(i);
			reminder.coordinates = getCoordinates(i);
			reminder.radius = getRadius(i);
			reminder.geoFences = getGeofences(i);
			reminder.regionIds = getRegionIds(i);
			reminder.npcIds = getNpcIds(i);
			reminder.itemIds = getItemIds(i);

			if (reminder.enable)
			{
				if ((checkTimes(reminder.times) && !matchesTimes(reminder.times)) ||
					(checkDaysOfWeek(reminder.daysOfWeek) && !matchesDaysOfWeek(reminder.daysOfWeek)) ||
					(checkDates(reminder.dates) && !matchesDates(reminder.dates)) ||
					(checkCoordinates(reminder.coordinates) && !matchesCoordinates(reminder.coordinates, reminder.radius)) ||
					(checkGeoFences(reminder.geoFences) && !matchesGeoFences(reminder.geoFences)) ||
					(checkRegions(reminder.regionIds) && !matchesRegions(reminder.regionIds)) ||
					(checkNpcIds(reminder.npcIds) && !matchesNpcIds(reminder.npcIds)) ||
					(checkItemIds(reminder.itemIds) && !matchesItemIds(reminder.itemIds))
				)
				{
					continue;
				}

				Reminder currentActive = currentActiveReminder(reminder.id);
				if (currentActive != null)
				{
					reminder.posted = currentActive.posted;
				}
				else
				{
					reminder.posted = Instant.now().toEpochMilli();
				}

				activeList.add(reminder);
			}
		}

//		try {
//			JsonArray jsonArray = gson.fromJson(config.customReminders(), JsonArray.class);
//			List<Reminder> reminders = new ArrayList<>();
//
//			int i = 0;
//			for (JsonElement jsonElement: jsonArray)
//			{
//				JsonObject jsonObject = jsonElement.getAsJsonObject();
//
//				Reminder reminder = new Reminder();
//
//				reminder.id = 100 + i;
//
//				if (jsonObject.has("enable"))
//				{
//					reminder.enable = jsonObject.get("enable").getAsBoolean();
//				}
//
//				if (jsonObject.has("text"))
//				{
//					reminder.text = jsonObject.get("text").getAsString();
//					reminder.text = reminder.text
//							.substring(0, Math.min(reminder.text.length(), 255));
//				}
//
//				if (jsonObject.has("color"))
//				{
//					reminder.colorStr = jsonObject.get("color").getAsString();
//				}
//
//				if (jsonObject.has("times"))
//				{
//					reminder.times = toCsv(jsonObject.get("times").getAsJsonArray());
//				}
//
//				if (jsonObject.has("days"))
//				{
//					reminder.daysOfWeek = toCsv(jsonObject.get("days").getAsJsonArray());
//				}
//
//				if (jsonObject.has("dates"))
//				{
//					reminder.dates = toCsv(jsonObject.get("dates").getAsJsonArray());
//				}
//
//				if (jsonObject.has("locations"))
//				{
//					reminder.coordinates = toCsv(jsonObject.get("locations").getAsJsonArray());
//				}
//
//				if (jsonObject.has("radius"))
//				{
//					reminder.radius = jsonObject.get("radius").getAsInt();
//				}
//
//				if (jsonObject.has("geofences"))
//				{
//					reminder.geoFences = toCsv(jsonObject.get("geofences").getAsJsonArray());
//				}
//
//				if (jsonObject.has("regions"))
//				{
//					reminder.regionIds = toCsv(jsonObject.get("regions").getAsJsonArray());
//				}
//
//				if (jsonObject.has("npcs"))
//				{
//					reminder.npcIds = toCsv(jsonObject.get("npcs").getAsJsonArray());
//				}
//
//				if (jsonObject.has("items"))
//				{
//					reminder.itemIds = toCsv(jsonObject.get("items").getAsJsonArray());
//				}
//
//				Reminder currentActive = currentActiveReminder(reminder.id);
//				if (currentActive != null)
//				{
//					reminder.posted = currentActive.posted;
//				}
//				else
//				{
//					reminder.posted = Instant.now().toEpochMilli();
//				}
//
//				reminders.add(reminder);
//
//				i++;
//			}
//
//			for (Reminder reminder: reminders)
//			{
//				if (reminder.enable)
//				{
//					if ((checkTimes(reminder.times) && !matchesTimes(reminder.times)) ||
//						(checkDaysOfWeek(reminder.daysOfWeek) && !matchesDaysOfWeek(reminder.daysOfWeek)) ||
//						(checkDates(reminder.dates) && !matchesDates(reminder.dates)) ||
//						(checkCoordinates(reminder.coordinates) && !matchesCoordinates(reminder.coordinates, reminder.radius)) ||
//						(checkGeoFences(reminder.geoFences) && !matchesGeoFences(reminder.geoFences)) ||
//						(checkRegions(reminder.regionIds) && !matchesRegions(reminder.regionIds)) ||
//						(checkNpcIds(reminder.npcIds) && !matchesNpcIds(reminder.npcIds)) ||
//						(checkItemIds(reminder.itemIds) && !matchesItemIds(reminder.itemIds))
//					)
//					{
//						continue;
//					}
//
//					activeList.add(reminder);
//				}
//			}
//		}
//		catch (Exception exception)
//		{
//			System.out.println(exception.getMessage());
//			return activeList;
//		}

		System.out.println("Active list took " + (Instant.now().toEpochMilli() - start) + "ms");

		return activeList;
	}

	private Reminder currentActiveReminder(int id)
	{
		for (Reminder reminder: activeReminders)
		{
			if (reminder.id == id)
			{
				return reminder;
			}
		}
		return null;
	}

	private String toCsv(JsonArray jsonArray)
	{
		StringBuilder sb = new StringBuilder();

		for (JsonElement jsonElement: jsonArray)
		{
			sb.append(jsonElement.getAsString());
			sb.append(",");
		}

		return sb.substring(0, sb.length() - 1);
	}

	private boolean checkTimes(String times)
	{
		return !times.isEmpty();
	}

	private boolean matchesTimes(String times)
	{
		try {
			String [] timeRanges = times.split(",");

			for (String timeRangeStr: timeRanges)
			{
				LocalDateTime startDateTime;
				LocalDateTime endDateTime;

				if (!timeRangeStr.contains("-"))
				{
					startDateTime = toLocalDateTime(timeRangeStr);
					endDateTime = startDateTime.plusMinutes(30);
				}
				else
				{
					String [] timeRangeParts = timeRangeStr.split("-");

					startDateTime = toLocalDateTime(timeRangeParts[0]);
					endDateTime = toLocalDateTime(timeRangeParts[1]);
				}

				if (dateTime.isAfter(startDateTime) && dateTime.isBefore(endDateTime))
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private LocalDateTime toLocalDateTime(String amPmTime)
	{
		String [] timeParts = amPmTime.split(":");

		int h = Integer.parseInt(timeParts[0].trim());

		String ma = timeParts[1]
				.toLowerCase()
				.trim();

		int m = Integer.parseInt(ma
				.replace("am", "")
				.replace("pm", ""));


		String aStr = ma
				.substring(ma.length() - 2);

		if (aStr.equals("pm"))
		{
			if (h != 12)
			{
				h += 12;
			}
		}
		else
		{
			if (h == 12)
			{
				h = 0;
			}
		}

		return LocalDate.now(ZoneId.systemDefault()).atTime(h, m);
	}

	private boolean checkDaysOfWeek(String daysOfWeek)
	{
		return !daysOfWeek.isEmpty();
	}

	private boolean matchesDaysOfWeek(String daysOfWeekStr)
	{
		try {
			String [] daysOfWeek = daysOfWeekStr.split(",");

			for (String dayOfWeek: daysOfWeek)
			{
				String lcDayOfWeek = dayOfWeek.toLowerCase();
				int d = 0;
				if (lcDayOfWeek.startsWith("mo")) d = 1;
				else if (lcDayOfWeek.startsWith("tu")) d = 2;
				else if (lcDayOfWeek.startsWith("we")) d = 3;
				else if (lcDayOfWeek.startsWith("th")) d = 4;
				else if (lcDayOfWeek.startsWith("fr")) d = 5;
				else if (lcDayOfWeek.startsWith("sa")) d = 6;
				else if (lcDayOfWeek.startsWith("su")) d = 7;

				boolean matches = dateTime.get(ChronoField.DAY_OF_WEEK) == d;

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private boolean checkDates(String dates)
	{
		return !dates.isEmpty();
	}

	private boolean matchesDates(String datesStr)
	{
		try {
			String [] dateRanges = datesStr.split(",");

			for (String dateRangeOrStr: dateRanges)
			{
				LocalDate startLocalDate;
				LocalDate endLocalDate;

				if (dateRangeOrStr.contains("-"))
				{
					String [] dateRangeParts = dateRangeOrStr.split("-");

					startLocalDate = toLocalDate(dateRangeParts[0]);
					endLocalDate = toLocalDate(dateRangeParts[1]);
				}
				else
				{
					startLocalDate = toLocalDate(dateRangeOrStr);
					endLocalDate = toLocalDate(dateRangeOrStr);
				}

				if (startLocalDate.atStartOfDay().isBefore(dateTime)
						&& endLocalDate.plusDays(1).atStartOfDay().isAfter(dateTime))
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private LocalDate toLocalDate(String dateStr)
	{
		String [] dateParts = dateStr.split("/");

		int m = Integer.parseInt(dateParts[0].trim());
		int d = Integer.parseInt(dateParts[1].trim());

		if (dateParts.length > 2)
		{
			int y = Integer.parseInt(dateParts[2].trim());
			return LocalDate.of(y + 2000, m, d);
		}

		return LocalDate.of(dateTime.getYear(), m, d);
	}

	private boolean checkCoordinates(String coordinates)
	{
		return !coordinates.isEmpty();
	}

	private boolean matchesCoordinates(String coordinatesStr, int radius)
	{
		try {
			String [] coordinates = coordinatesStr.split(",");

			int x = 0;
			for (int i = 0; i < coordinates.length; i++)
			{
				String xOrY = coordinates[i]
						.replace("(", "")
						.replace(")", "")
						.trim();

				if (i % 2 == 0)
				{
					x = Integer.parseInt(xOrY);
					continue;
				}

				int y = Integer.parseInt(xOrY);

				double distance = Math.sqrt(
						Math.pow(x - worldPos.getX(), 2) +
								Math.pow(y - worldPos.getY(), 2)
				);

				boolean matches = distance <= radius;

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private boolean checkGeoFences(String geoFences)
	{
		return !geoFences.isEmpty();
	}

	private boolean matchesGeoFences(String geoFences)
	{
		try {
			String [] coordinates = geoFences.split(",");

			int left = 0;
			int top = 0;
			int right = 0;
			for (int i = 0; i < coordinates.length; i++)
			{
				String side = coordinates[i]
						.replace("(", "")
						.replace(")", "")
						.trim();

				if (i % 4 == 0)
				{
					left = Integer.parseInt(side);
					continue;
				}
				else if (i % 4 == 1)
				{
					top = Integer.parseInt(side);
					continue;
				}
				else if (i % 4 == 2)
				{
					right = Integer.parseInt(side);
					continue;
				}

				int bottom = Integer.parseInt(side);

				boolean matches = worldPos.getX() >= left && worldPos.getX() <= right
						&& worldPos.getY() >= bottom && worldPos.getY() <= top;

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private boolean checkRegions(String regionIds)
	{
		return !regionIds.isEmpty();
	}

	private boolean matchesRegions(String regionIds)
	{
		try {
			String [] ids = regionIds.split(",");

			for (String idStr: ids)
			{
				int id = Integer.parseInt(idStr.trim());

				boolean matches = regionId == id;

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			return false;
		}
	}

	private boolean checkNpcIds(String npcIds)
	{
		return !npcIds.isEmpty();
	}

	private boolean matchesNpcIds(String npcIdsStr)
	{
		try {
			String [] npcIds = npcIdsStr.split(",");

			for (String npcIdStr: npcIds)
			{
				int npcId = Integer.parseInt(npcIdStr.trim());

				boolean matches = false;
				for (NPC npc: npcs)
				{
					if (npc.getId() == npcId) {
						matches = true;
						break;
					}
				}

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			return false;
		}
	}

	private boolean checkItemIds(String itemIds)
	{
		return !itemIds.isEmpty();
	}

	private boolean matchesItemIds(String itemIdsStr)
	{
		try {
			String [] itemIds = itemIdsStr.split(",");

			for (String itemIdStr: itemIds)
			{
				int itemId = Integer.parseInt(itemIdStr.trim());

				boolean matches = false;
				for (ItemComposition item: inventoryItems)
				{
					if (item.getId() == itemId) {
						matches = true;
						break;
					}
				}

				if (matches)
				{
					return true;
				}
			}

			return false;
		}
		catch (Exception exception)
		{
			return false;
		}
	}

	boolean isEnable(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Enable();
		else if (reminderId == 2) return config.reminder2Enable();
		else if (reminderId == 3) return config.reminder3Enable();
		else if (reminderId == 4) return config.reminder4Enable();
		else if (reminderId == 5) return config.reminder5Enable();
		else if (reminderId == 6) return config.reminder6Enable();
		else if (reminderId == 7) return config.reminder7Enable();
		else if (reminderId == 8) return config.reminder8Enable();
		else if (reminderId == 9) return config.reminder9Enable();
		else if (reminderId == 10) return config.reminder10Enable();
		else if (reminderId == 11) return config.reminder11Enable();
		else if (reminderId == 12) return config.reminder12Enable();
		else if (reminderId == 13) return config.reminder13Enable();
		else if (reminderId == 14) return config.reminder14Enable();
		else if (reminderId == 15) return config.reminder15Enable();
		else if (reminderId == 16) return config.reminder16Enable();
		else if (reminderId == 17) return config.reminder17Enable();
		else if (reminderId == 18) return config.reminder18Enable();
		else if (reminderId == 19) return config.reminder19Enable();
		else if (reminderId == 20) return config.reminder20Enable();
		else if (reminderId == 21) return config.reminder21Enable();
		else if (reminderId == 22) return config.reminder22Enable();
		else if (reminderId == 23) return config.reminder23Enable();
		else if (reminderId == 24) return config.reminder24Enable();
		else if (reminderId == 25) return config.reminder25Enable();
		else if (reminderId == 26) return config.reminder26Enable();
		else if (reminderId == 27) return config.reminder27Enable();
		else if (reminderId == 28) return config.reminder28Enable();
		else if (reminderId == 29) return config.reminder29Enable();
		else if (reminderId == 30) return config.reminder30Enable();
		else if (reminderId == 31) return config.reminder31Enable();
		else if (reminderId == 32) return config.reminder32Enable();
		else if (reminderId == 33) return config.reminder33Enable();
		else if (reminderId == 34) return config.reminder34Enable();
		else if (reminderId == 35) return config.reminder35Enable();
		else if (reminderId == 36) return config.reminder36Enable();
		else if (reminderId == 37) return config.reminder37Enable();
		else if (reminderId == 38) return config.reminder38Enable();
		else if (reminderId == 39) return config.reminder39Enable();
		else if (reminderId == 40) return config.reminder40Enable();
		else if (reminderId == 41) return config.reminder41Enable();
		else if (reminderId == 42) return config.reminder42Enable();
		else if (reminderId == 43) return config.reminder43Enable();
		else if (reminderId == 44) return config.reminder44Enable();
		else if (reminderId == 45) return config.reminder45Enable();
		else if (reminderId == 46) return config.reminder46Enable();
		else if (reminderId == 47) return config.reminder47Enable();
		else if (reminderId == 48) return config.reminder48Enable();
		else if (reminderId == 49) return config.reminder49Enable();
		else if (reminderId == 50) return config.reminder50Enable();
		else if (reminderId == 51) return config.reminder51Enable();
		else if (reminderId == 52) return config.reminder52Enable();
		else if (reminderId == 53) return config.reminder53Enable();
		else if (reminderId == 54) return config.reminder54Enable();
		else if (reminderId == 55) return config.reminder55Enable();
		else if (reminderId == 56) return config.reminder56Enable();
		else if (reminderId == 57) return config.reminder57Enable();
		else if (reminderId == 58) return config.reminder58Enable();
		else if (reminderId == 59) return config.reminder59Enable();
		else if (reminderId == 60) return config.reminder60Enable();
		else if (reminderId == 61) return config.reminder61Enable();
		else if (reminderId == 62) return config.reminder62Enable();
		else if (reminderId == 63) return config.reminder63Enable();
		else if (reminderId == 64) return config.reminder64Enable();
		else if (reminderId == 65) return config.reminder65Enable();
		else if (reminderId == 66) return config.reminder66Enable();
		else if (reminderId == 67) return config.reminder67Enable();
		else if (reminderId == 68) return config.reminder68Enable();
		else if (reminderId == 69) return config.reminder69Enable();
		else if (reminderId == 70) return config.reminder70Enable();
		else if (reminderId == 71) return config.reminder71Enable();
		else if (reminderId == 72) return config.reminder72Enable();
		else if (reminderId == 73) return config.reminder73Enable();
		else if (reminderId == 74) return config.reminder74Enable();
		else if (reminderId == 75) return config.reminder75Enable();
		else if (reminderId == 76) return config.reminder76Enable();
		else if (reminderId == 77) return config.reminder77Enable();
		else if (reminderId == 78) return config.reminder78Enable();
		else if (reminderId == 79) return config.reminder79Enable();
		else if (reminderId == 80) return config.reminder80Enable();
		else if (reminderId == 81) return config.reminder81Enable();
		else if (reminderId == 82) return config.reminder82Enable();
		else if (reminderId == 83) return config.reminder83Enable();
		else if (reminderId == 84) return config.reminder84Enable();
		else if (reminderId == 85) return config.reminder85Enable();
		else if (reminderId == 86) return config.reminder86Enable();
		else if (reminderId == 87) return config.reminder87Enable();
		else if (reminderId == 88) return config.reminder88Enable();
		else if (reminderId == 89) return config.reminder89Enable();
		else if (reminderId == 90) return config.reminder90Enable();
		else if (reminderId == 91) return config.reminder91Enable();
		else if (reminderId == 92) return config.reminder92Enable();
		else if (reminderId == 93) return config.reminder93Enable();
		else if (reminderId == 94) return config.reminder94Enable();
		else if (reminderId == 95) return config.reminder95Enable();
		else if (reminderId == 96) return config.reminder96Enable();
		else if (reminderId == 97) return config.reminder97Enable();
		else if (reminderId == 98) return config.reminder98Enable();
		else if (reminderId == 99) return config.reminder99Enable();
		else if (reminderId == 100) return config.reminder100Enable();
		else return false;
	}

	String getText(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Text();
		else if (reminderId == 2) return config.reminder2Text();
		else if (reminderId == 3) return config.reminder3Text();
		else if (reminderId == 4) return config.reminder4Text();
		else if (reminderId == 5) return config.reminder5Text();
		else if (reminderId == 6) return config.reminder6Text();
		else if (reminderId == 7) return config.reminder7Text();
		else if (reminderId == 8) return config.reminder8Text();
		else if (reminderId == 9) return config.reminder9Text();
		else if (reminderId == 10) return config.reminder10Text();
		else if (reminderId == 11) return config.reminder11Text();
		else if (reminderId == 12) return config.reminder12Text();
		else if (reminderId == 13) return config.reminder13Text();
		else if (reminderId == 14) return config.reminder14Text();
		else if (reminderId == 15) return config.reminder15Text();
		else if (reminderId == 16) return config.reminder16Text();
		else if (reminderId == 17) return config.reminder17Text();
		else if (reminderId == 18) return config.reminder18Text();
		else if (reminderId == 19) return config.reminder19Text();
		else if (reminderId == 20) return config.reminder20Text();
		else if (reminderId == 21) return config.reminder21Text();
		else if (reminderId == 22) return config.reminder22Text();
		else if (reminderId == 23) return config.reminder23Text();
		else if (reminderId == 24) return config.reminder24Text();
		else if (reminderId == 25) return config.reminder25Text();
		else if (reminderId == 26) return config.reminder26Text();
		else if (reminderId == 27) return config.reminder27Text();
		else if (reminderId == 28) return config.reminder28Text();
		else if (reminderId == 29) return config.reminder29Text();
		else if (reminderId == 30) return config.reminder30Text();
		else if (reminderId == 31) return config.reminder31Text();
		else if (reminderId == 32) return config.reminder32Text();
		else if (reminderId == 33) return config.reminder33Text();
		else if (reminderId == 34) return config.reminder34Text();
		else if (reminderId == 35) return config.reminder35Text();
		else if (reminderId == 36) return config.reminder36Text();
		else if (reminderId == 37) return config.reminder37Text();
		else if (reminderId == 38) return config.reminder38Text();
		else if (reminderId == 39) return config.reminder39Text();
		else if (reminderId == 40) return config.reminder40Text();
		else if (reminderId == 41) return config.reminder41Text();
		else if (reminderId == 42) return config.reminder42Text();
		else if (reminderId == 43) return config.reminder43Text();
		else if (reminderId == 44) return config.reminder44Text();
		else if (reminderId == 45) return config.reminder45Text();
		else if (reminderId == 46) return config.reminder46Text();
		else if (reminderId == 47) return config.reminder47Text();
		else if (reminderId == 48) return config.reminder48Text();
		else if (reminderId == 49) return config.reminder49Text();
		else if (reminderId == 50) return config.reminder50Text();
		else if (reminderId == 51) return config.reminder51Text();
		else if (reminderId == 52) return config.reminder52Text();
		else if (reminderId == 53) return config.reminder53Text();
		else if (reminderId == 54) return config.reminder54Text();
		else if (reminderId == 55) return config.reminder55Text();
		else if (reminderId == 56) return config.reminder56Text();
		else if (reminderId == 57) return config.reminder57Text();
		else if (reminderId == 58) return config.reminder58Text();
		else if (reminderId == 59) return config.reminder59Text();
		else if (reminderId == 60) return config.reminder60Text();
		else if (reminderId == 61) return config.reminder61Text();
		else if (reminderId == 62) return config.reminder62Text();
		else if (reminderId == 63) return config.reminder63Text();
		else if (reminderId == 64) return config.reminder64Text();
		else if (reminderId == 65) return config.reminder65Text();
		else if (reminderId == 66) return config.reminder66Text();
		else if (reminderId == 67) return config.reminder67Text();
		else if (reminderId == 68) return config.reminder68Text();
		else if (reminderId == 69) return config.reminder69Text();
		else if (reminderId == 70) return config.reminder70Text();
		else if (reminderId == 71) return config.reminder71Text();
		else if (reminderId == 72) return config.reminder72Text();
		else if (reminderId == 73) return config.reminder73Text();
		else if (reminderId == 74) return config.reminder74Text();
		else if (reminderId == 75) return config.reminder75Text();
		else if (reminderId == 76) return config.reminder76Text();
		else if (reminderId == 77) return config.reminder77Text();
		else if (reminderId == 78) return config.reminder78Text();
		else if (reminderId == 79) return config.reminder79Text();
		else if (reminderId == 80) return config.reminder80Text();
		else if (reminderId == 81) return config.reminder81Text();
		else if (reminderId == 82) return config.reminder82Text();
		else if (reminderId == 83) return config.reminder83Text();
		else if (reminderId == 84) return config.reminder84Text();
		else if (reminderId == 85) return config.reminder85Text();
		else if (reminderId == 86) return config.reminder86Text();
		else if (reminderId == 87) return config.reminder87Text();
		else if (reminderId == 88) return config.reminder88Text();
		else if (reminderId == 89) return config.reminder89Text();
		else if (reminderId == 90) return config.reminder90Text();
		else if (reminderId == 91) return config.reminder91Text();
		else if (reminderId == 92) return config.reminder92Text();
		else if (reminderId == 93) return config.reminder93Text();
		else if (reminderId == 94) return config.reminder94Text();
		else if (reminderId == 95) return config.reminder95Text();
		else if (reminderId == 96) return config.reminder96Text();
		else if (reminderId == 97) return config.reminder97Text();
		else if (reminderId == 98) return config.reminder98Text();
		else if (reminderId == 99) return config.reminder99Text();
		else if (reminderId == 100) return config.reminder100Text();
		else return "";
	}

	Color getColor(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Color();
		else if (reminderId == 2) return config.reminder2Color();
		else if (reminderId == 3) return config.reminder3Color();
		else if (reminderId == 4) return config.reminder4Color();
		else if (reminderId == 5) return config.reminder5Color();
		else if (reminderId == 6) return config.reminder6Color();
		else if (reminderId == 7) return config.reminder7Color();
		else if (reminderId == 8) return config.reminder8Color();
		else if (reminderId == 9) return config.reminder9Color();
		else if (reminderId == 10) return config.reminder10Color();
		else if (reminderId == 11) return config.reminder11Color();
		else if (reminderId == 12) return config.reminder12Color();
		else if (reminderId == 13) return config.reminder13Color();
		else if (reminderId == 14) return config.reminder14Color();
		else if (reminderId == 15) return config.reminder15Color();
		else if (reminderId == 16) return config.reminder16Color();
		else if (reminderId == 17) return config.reminder17Color();
		else if (reminderId == 18) return config.reminder18Color();
		else if (reminderId == 19) return config.reminder19Color();
		else if (reminderId == 20) return config.reminder20Color();
		else if (reminderId == 21) return config.reminder21Color();
		else if (reminderId == 22) return config.reminder22Color();
		else if (reminderId == 23) return config.reminder23Color();
		else if (reminderId == 24) return config.reminder24Color();
		else if (reminderId == 25) return config.reminder25Color();
		else if (reminderId == 26) return config.reminder26Color();
		else if (reminderId == 27) return config.reminder27Color();
		else if (reminderId == 28) return config.reminder28Color();
		else if (reminderId == 29) return config.reminder29Color();
		else if (reminderId == 30) return config.reminder30Color();
		else if (reminderId == 31) return config.reminder31Color();
		else if (reminderId == 32) return config.reminder32Color();
		else if (reminderId == 33) return config.reminder33Color();
		else if (reminderId == 34) return config.reminder34Color();
		else if (reminderId == 35) return config.reminder35Color();
		else if (reminderId == 36) return config.reminder36Color();
		else if (reminderId == 37) return config.reminder37Color();
		else if (reminderId == 38) return config.reminder38Color();
		else if (reminderId == 39) return config.reminder39Color();
		else if (reminderId == 40) return config.reminder40Color();
		else if (reminderId == 41) return config.reminder41Color();
		else if (reminderId == 42) return config.reminder42Color();
		else if (reminderId == 43) return config.reminder43Color();
		else if (reminderId == 44) return config.reminder44Color();
		else if (reminderId == 45) return config.reminder45Color();
		else if (reminderId == 46) return config.reminder46Color();
		else if (reminderId == 47) return config.reminder47Color();
		else if (reminderId == 48) return config.reminder48Color();
		else if (reminderId == 49) return config.reminder49Color();
		else if (reminderId == 50) return config.reminder50Color();
		else if (reminderId == 51) return config.reminder51Color();
		else if (reminderId == 52) return config.reminder52Color();
		else if (reminderId == 53) return config.reminder53Color();
		else if (reminderId == 54) return config.reminder54Color();
		else if (reminderId == 55) return config.reminder55Color();
		else if (reminderId == 56) return config.reminder56Color();
		else if (reminderId == 57) return config.reminder57Color();
		else if (reminderId == 58) return config.reminder58Color();
		else if (reminderId == 59) return config.reminder59Color();
		else if (reminderId == 60) return config.reminder60Color();
		else if (reminderId == 61) return config.reminder61Color();
		else if (reminderId == 62) return config.reminder62Color();
		else if (reminderId == 63) return config.reminder63Color();
		else if (reminderId == 64) return config.reminder64Color();
		else if (reminderId == 65) return config.reminder65Color();
		else if (reminderId == 66) return config.reminder66Color();
		else if (reminderId == 67) return config.reminder67Color();
		else if (reminderId == 68) return config.reminder68Color();
		else if (reminderId == 69) return config.reminder69Color();
		else if (reminderId == 70) return config.reminder70Color();
		else if (reminderId == 71) return config.reminder71Color();
		else if (reminderId == 72) return config.reminder72Color();
		else if (reminderId == 73) return config.reminder73Color();
		else if (reminderId == 74) return config.reminder74Color();
		else if (reminderId == 75) return config.reminder75Color();
		else if (reminderId == 76) return config.reminder76Color();
		else if (reminderId == 77) return config.reminder77Color();
		else if (reminderId == 78) return config.reminder78Color();
		else if (reminderId == 79) return config.reminder79Color();
		else if (reminderId == 80) return config.reminder80Color();
		else if (reminderId == 81) return config.reminder81Color();
		else if (reminderId == 82) return config.reminder82Color();
		else if (reminderId == 83) return config.reminder83Color();
		else if (reminderId == 84) return config.reminder84Color();
		else if (reminderId == 85) return config.reminder85Color();
		else if (reminderId == 86) return config.reminder86Color();
		else if (reminderId == 87) return config.reminder87Color();
		else if (reminderId == 88) return config.reminder88Color();
		else if (reminderId == 89) return config.reminder89Color();
		else if (reminderId == 90) return config.reminder90Color();
		else if (reminderId == 91) return config.reminder91Color();
		else if (reminderId == 92) return config.reminder92Color();
		else if (reminderId == 93) return config.reminder93Color();
		else if (reminderId == 94) return config.reminder94Color();
		else if (reminderId == 95) return config.reminder95Color();
		else if (reminderId == 96) return config.reminder96Color();
		else if (reminderId == 97) return config.reminder97Color();
		else if (reminderId == 98) return config.reminder98Color();
		else if (reminderId == 99) return config.reminder99Color();
		else if (reminderId == 100) return config.reminder100Color();
		else return Color.WHITE;
	}

	String getTimes(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Times();
		else if (reminderId == 2) return config.reminder2Times();
		else if (reminderId == 3) return config.reminder3Times();
		else if (reminderId == 4) return config.reminder4Times();
		else if (reminderId == 5) return config.reminder5Times();
		else if (reminderId == 6) return config.reminder6Times();
		else if (reminderId == 7) return config.reminder7Times();
		else if (reminderId == 8) return config.reminder8Times();
		else if (reminderId == 9) return config.reminder9Times();
		else if (reminderId == 10) return config.reminder10Times();
		else if (reminderId == 11) return config.reminder11Times();
		else if (reminderId == 12) return config.reminder12Times();
		else if (reminderId == 13) return config.reminder13Times();
		else if (reminderId == 14) return config.reminder14Times();
		else if (reminderId == 15) return config.reminder15Times();
		else if (reminderId == 16) return config.reminder16Times();
		else if (reminderId == 17) return config.reminder17Times();
		else if (reminderId == 18) return config.reminder18Times();
		else if (reminderId == 19) return config.reminder19Times();
		else if (reminderId == 20) return config.reminder20Times();
		else if (reminderId == 21) return config.reminder21Times();
		else if (reminderId == 22) return config.reminder22Times();
		else if (reminderId == 23) return config.reminder23Times();
		else if (reminderId == 24) return config.reminder24Times();
		else if (reminderId == 25) return config.reminder25Times();
		else if (reminderId == 26) return config.reminder26Times();
		else if (reminderId == 27) return config.reminder27Times();
		else if (reminderId == 28) return config.reminder28Times();
		else if (reminderId == 29) return config.reminder29Times();
		else if (reminderId == 30) return config.reminder30Times();
		else if (reminderId == 31) return config.reminder31Times();
		else if (reminderId == 32) return config.reminder32Times();
		else if (reminderId == 33) return config.reminder33Times();
		else if (reminderId == 34) return config.reminder34Times();
		else if (reminderId == 35) return config.reminder35Times();
		else if (reminderId == 36) return config.reminder36Times();
		else if (reminderId == 37) return config.reminder37Times();
		else if (reminderId == 38) return config.reminder38Times();
		else if (reminderId == 39) return config.reminder39Times();
		else if (reminderId == 40) return config.reminder40Times();
		else if (reminderId == 41) return config.reminder41Times();
		else if (reminderId == 42) return config.reminder42Times();
		else if (reminderId == 43) return config.reminder43Times();
		else if (reminderId == 44) return config.reminder44Times();
		else if (reminderId == 45) return config.reminder45Times();
		else if (reminderId == 46) return config.reminder46Times();
		else if (reminderId == 47) return config.reminder47Times();
		else if (reminderId == 48) return config.reminder48Times();
		else if (reminderId == 49) return config.reminder49Times();
		else if (reminderId == 50) return config.reminder50Times();
		else if (reminderId == 51) return config.reminder51Times();
		else if (reminderId == 52) return config.reminder52Times();
		else if (reminderId == 53) return config.reminder53Times();
		else if (reminderId == 54) return config.reminder54Times();
		else if (reminderId == 55) return config.reminder55Times();
		else if (reminderId == 56) return config.reminder56Times();
		else if (reminderId == 57) return config.reminder57Times();
		else if (reminderId == 58) return config.reminder58Times();
		else if (reminderId == 59) return config.reminder59Times();
		else if (reminderId == 60) return config.reminder60Times();
		else if (reminderId == 61) return config.reminder61Times();
		else if (reminderId == 62) return config.reminder62Times();
		else if (reminderId == 63) return config.reminder63Times();
		else if (reminderId == 64) return config.reminder64Times();
		else if (reminderId == 65) return config.reminder65Times();
		else if (reminderId == 66) return config.reminder66Times();
		else if (reminderId == 67) return config.reminder67Times();
		else if (reminderId == 68) return config.reminder68Times();
		else if (reminderId == 69) return config.reminder69Times();
		else if (reminderId == 70) return config.reminder70Times();
		else if (reminderId == 71) return config.reminder71Times();
		else if (reminderId == 72) return config.reminder72Times();
		else if (reminderId == 73) return config.reminder73Times();
		else if (reminderId == 74) return config.reminder74Times();
		else if (reminderId == 75) return config.reminder75Times();
		else if (reminderId == 76) return config.reminder76Times();
		else if (reminderId == 77) return config.reminder77Times();
		else if (reminderId == 78) return config.reminder78Times();
		else if (reminderId == 79) return config.reminder79Times();
		else if (reminderId == 80) return config.reminder80Times();
		else if (reminderId == 81) return config.reminder81Times();
		else if (reminderId == 82) return config.reminder82Times();
		else if (reminderId == 83) return config.reminder83Times();
		else if (reminderId == 84) return config.reminder84Times();
		else if (reminderId == 85) return config.reminder85Times();
		else if (reminderId == 86) return config.reminder86Times();
		else if (reminderId == 87) return config.reminder87Times();
		else if (reminderId == 88) return config.reminder88Times();
		else if (reminderId == 89) return config.reminder89Times();
		else if (reminderId == 90) return config.reminder90Times();
		else if (reminderId == 91) return config.reminder91Times();
		else if (reminderId == 92) return config.reminder92Times();
		else if (reminderId == 93) return config.reminder93Times();
		else if (reminderId == 94) return config.reminder94Times();
		else if (reminderId == 95) return config.reminder95Times();
		else if (reminderId == 96) return config.reminder96Times();
		else if (reminderId == 97) return config.reminder97Times();
		else if (reminderId == 98) return config.reminder98Times();
		else if (reminderId == 99) return config.reminder99Times();
		else if (reminderId == 100) return config.reminder100Times();
		else return "";
	}

	String getDaysOfWeek(int reminderId)
	{
		if (reminderId == 1) return config.reminder1DaysOfWeek();
		else if (reminderId == 2) return config.reminder2DaysOfWeek();
		else if (reminderId == 3) return config.reminder3DaysOfWeek();
		else if (reminderId == 4) return config.reminder4DaysOfWeek();
		else if (reminderId == 5) return config.reminder5DaysOfWeek();
		else if (reminderId == 6) return config.reminder6DaysOfWeek();
		else if (reminderId == 7) return config.reminder7DaysOfWeek();
		else if (reminderId == 8) return config.reminder8DaysOfWeek();
		else if (reminderId == 9) return config.reminder9DaysOfWeek();
		else if (reminderId == 10) return config.reminder10DaysOfWeek();
		else if (reminderId == 11) return config.reminder11DaysOfWeek();
		else if (reminderId == 12) return config.reminder12DaysOfWeek();
		else if (reminderId == 13) return config.reminder13DaysOfWeek();
		else if (reminderId == 14) return config.reminder14DaysOfWeek();
		else if (reminderId == 15) return config.reminder15DaysOfWeek();
		else if (reminderId == 16) return config.reminder16DaysOfWeek();
		else if (reminderId == 17) return config.reminder17DaysOfWeek();
		else if (reminderId == 18) return config.reminder18DaysOfWeek();
		else if (reminderId == 19) return config.reminder19DaysOfWeek();
		else if (reminderId == 20) return config.reminder20DaysOfWeek();
		else if (reminderId == 21) return config.reminder21DaysOfWeek();
		else if (reminderId == 22) return config.reminder22DaysOfWeek();
		else if (reminderId == 23) return config.reminder23DaysOfWeek();
		else if (reminderId == 24) return config.reminder24DaysOfWeek();
		else if (reminderId == 25) return config.reminder25DaysOfWeek();
		else if (reminderId == 26) return config.reminder26DaysOfWeek();
		else if (reminderId == 27) return config.reminder27DaysOfWeek();
		else if (reminderId == 28) return config.reminder28DaysOfWeek();
		else if (reminderId == 29) return config.reminder29DaysOfWeek();
		else if (reminderId == 30) return config.reminder30DaysOfWeek();
		else if (reminderId == 31) return config.reminder31DaysOfWeek();
		else if (reminderId == 32) return config.reminder32DaysOfWeek();
		else if (reminderId == 33) return config.reminder33DaysOfWeek();
		else if (reminderId == 34) return config.reminder34DaysOfWeek();
		else if (reminderId == 35) return config.reminder35DaysOfWeek();
		else if (reminderId == 36) return config.reminder36DaysOfWeek();
		else if (reminderId == 37) return config.reminder37DaysOfWeek();
		else if (reminderId == 38) return config.reminder38DaysOfWeek();
		else if (reminderId == 39) return config.reminder39DaysOfWeek();
		else if (reminderId == 40) return config.reminder40DaysOfWeek();
		else if (reminderId == 41) return config.reminder41DaysOfWeek();
		else if (reminderId == 42) return config.reminder42DaysOfWeek();
		else if (reminderId == 43) return config.reminder43DaysOfWeek();
		else if (reminderId == 44) return config.reminder44DaysOfWeek();
		else if (reminderId == 45) return config.reminder45DaysOfWeek();
		else if (reminderId == 46) return config.reminder46DaysOfWeek();
		else if (reminderId == 47) return config.reminder47DaysOfWeek();
		else if (reminderId == 48) return config.reminder48DaysOfWeek();
		else if (reminderId == 49) return config.reminder49DaysOfWeek();
		else if (reminderId == 50) return config.reminder50DaysOfWeek();
		else if (reminderId == 51) return config.reminder51DaysOfWeek();
		else if (reminderId == 52) return config.reminder52DaysOfWeek();
		else if (reminderId == 53) return config.reminder53DaysOfWeek();
		else if (reminderId == 54) return config.reminder54DaysOfWeek();
		else if (reminderId == 55) return config.reminder55DaysOfWeek();
		else if (reminderId == 56) return config.reminder56DaysOfWeek();
		else if (reminderId == 57) return config.reminder57DaysOfWeek();
		else if (reminderId == 58) return config.reminder58DaysOfWeek();
		else if (reminderId == 59) return config.reminder59DaysOfWeek();
		else if (reminderId == 60) return config.reminder60DaysOfWeek();
		else if (reminderId == 61) return config.reminder61DaysOfWeek();
		else if (reminderId == 62) return config.reminder62DaysOfWeek();
		else if (reminderId == 63) return config.reminder63DaysOfWeek();
		else if (reminderId == 64) return config.reminder64DaysOfWeek();
		else if (reminderId == 65) return config.reminder65DaysOfWeek();
		else if (reminderId == 66) return config.reminder66DaysOfWeek();
		else if (reminderId == 67) return config.reminder67DaysOfWeek();
		else if (reminderId == 68) return config.reminder68DaysOfWeek();
		else if (reminderId == 69) return config.reminder69DaysOfWeek();
		else if (reminderId == 70) return config.reminder70DaysOfWeek();
		else if (reminderId == 71) return config.reminder71DaysOfWeek();
		else if (reminderId == 72) return config.reminder72DaysOfWeek();
		else if (reminderId == 73) return config.reminder73DaysOfWeek();
		else if (reminderId == 74) return config.reminder74DaysOfWeek();
		else if (reminderId == 75) return config.reminder75DaysOfWeek();
		else if (reminderId == 76) return config.reminder76DaysOfWeek();
		else if (reminderId == 77) return config.reminder77DaysOfWeek();
		else if (reminderId == 78) return config.reminder78DaysOfWeek();
		else if (reminderId == 79) return config.reminder79DaysOfWeek();
		else if (reminderId == 80) return config.reminder80DaysOfWeek();
		else if (reminderId == 81) return config.reminder81DaysOfWeek();
		else if (reminderId == 82) return config.reminder82DaysOfWeek();
		else if (reminderId == 83) return config.reminder83DaysOfWeek();
		else if (reminderId == 84) return config.reminder84DaysOfWeek();
		else if (reminderId == 85) return config.reminder85DaysOfWeek();
		else if (reminderId == 86) return config.reminder86DaysOfWeek();
		else if (reminderId == 87) return config.reminder87DaysOfWeek();
		else if (reminderId == 88) return config.reminder88DaysOfWeek();
		else if (reminderId == 89) return config.reminder89DaysOfWeek();
		else if (reminderId == 90) return config.reminder90DaysOfWeek();
		else if (reminderId == 91) return config.reminder91DaysOfWeek();
		else if (reminderId == 92) return config.reminder92DaysOfWeek();
		else if (reminderId == 93) return config.reminder93DaysOfWeek();
		else if (reminderId == 94) return config.reminder94DaysOfWeek();
		else if (reminderId == 95) return config.reminder95DaysOfWeek();
		else if (reminderId == 96) return config.reminder96DaysOfWeek();
		else if (reminderId == 97) return config.reminder97DaysOfWeek();
		else if (reminderId == 98) return config.reminder98DaysOfWeek();
		else if (reminderId == 99) return config.reminder99DaysOfWeek();
		else if (reminderId == 100) return config.reminder100DaysOfWeek();
		else return "";
	}

	String getDates(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Dates();
		else if (reminderId == 2) return config.reminder2Dates();
		else if (reminderId == 3) return config.reminder3Dates();
		else if (reminderId == 4) return config.reminder4Dates();
		else if (reminderId == 5) return config.reminder5Dates();
		else if (reminderId == 6) return config.reminder6Dates();
		else if (reminderId == 7) return config.reminder7Dates();
		else if (reminderId == 8) return config.reminder8Dates();
		else if (reminderId == 9) return config.reminder9Dates();
		else if (reminderId == 10) return config.reminder10Dates();
		else if (reminderId == 11) return config.reminder11Dates();
		else if (reminderId == 12) return config.reminder12Dates();
		else if (reminderId == 13) return config.reminder13Dates();
		else if (reminderId == 14) return config.reminder14Dates();
		else if (reminderId == 15) return config.reminder15Dates();
		else if (reminderId == 16) return config.reminder16Dates();
		else if (reminderId == 17) return config.reminder17Dates();
		else if (reminderId == 18) return config.reminder18Dates();
		else if (reminderId == 19) return config.reminder19Dates();
		else if (reminderId == 20) return config.reminder20Dates();
		else if (reminderId == 21) return config.reminder21Dates();
		else if (reminderId == 22) return config.reminder22Dates();
		else if (reminderId == 23) return config.reminder23Dates();
		else if (reminderId == 24) return config.reminder24Dates();
		else if (reminderId == 25) return config.reminder25Dates();
		else if (reminderId == 26) return config.reminder26Dates();
		else if (reminderId == 27) return config.reminder27Dates();
		else if (reminderId == 28) return config.reminder28Dates();
		else if (reminderId == 29) return config.reminder29Dates();
		else if (reminderId == 30) return config.reminder30Dates();
		else if (reminderId == 31) return config.reminder31Dates();
		else if (reminderId == 32) return config.reminder32Dates();
		else if (reminderId == 33) return config.reminder33Dates();
		else if (reminderId == 34) return config.reminder34Dates();
		else if (reminderId == 35) return config.reminder35Dates();
		else if (reminderId == 36) return config.reminder36Dates();
		else if (reminderId == 37) return config.reminder37Dates();
		else if (reminderId == 38) return config.reminder38Dates();
		else if (reminderId == 39) return config.reminder39Dates();
		else if (reminderId == 40) return config.reminder40Dates();
		else if (reminderId == 41) return config.reminder41Dates();
		else if (reminderId == 42) return config.reminder42Dates();
		else if (reminderId == 43) return config.reminder43Dates();
		else if (reminderId == 44) return config.reminder44Dates();
		else if (reminderId == 45) return config.reminder45Dates();
		else if (reminderId == 46) return config.reminder46Dates();
		else if (reminderId == 47) return config.reminder47Dates();
		else if (reminderId == 48) return config.reminder48Dates();
		else if (reminderId == 49) return config.reminder49Dates();
		else if (reminderId == 50) return config.reminder50Dates();
		else if (reminderId == 51) return config.reminder51Dates();
		else if (reminderId == 52) return config.reminder52Dates();
		else if (reminderId == 53) return config.reminder53Dates();
		else if (reminderId == 54) return config.reminder54Dates();
		else if (reminderId == 55) return config.reminder55Dates();
		else if (reminderId == 56) return config.reminder56Dates();
		else if (reminderId == 57) return config.reminder57Dates();
		else if (reminderId == 58) return config.reminder58Dates();
		else if (reminderId == 59) return config.reminder59Dates();
		else if (reminderId == 60) return config.reminder60Dates();
		else if (reminderId == 61) return config.reminder61Dates();
		else if (reminderId == 62) return config.reminder62Dates();
		else if (reminderId == 63) return config.reminder63Dates();
		else if (reminderId == 64) return config.reminder64Dates();
		else if (reminderId == 65) return config.reminder65Dates();
		else if (reminderId == 66) return config.reminder66Dates();
		else if (reminderId == 67) return config.reminder67Dates();
		else if (reminderId == 68) return config.reminder68Dates();
		else if (reminderId == 69) return config.reminder69Dates();
		else if (reminderId == 70) return config.reminder70Dates();
		else if (reminderId == 71) return config.reminder71Dates();
		else if (reminderId == 72) return config.reminder72Dates();
		else if (reminderId == 73) return config.reminder73Dates();
		else if (reminderId == 74) return config.reminder74Dates();
		else if (reminderId == 75) return config.reminder75Dates();
		else if (reminderId == 76) return config.reminder76Dates();
		else if (reminderId == 77) return config.reminder77Dates();
		else if (reminderId == 78) return config.reminder78Dates();
		else if (reminderId == 79) return config.reminder79Dates();
		else if (reminderId == 80) return config.reminder80Dates();
		else if (reminderId == 81) return config.reminder81Dates();
		else if (reminderId == 82) return config.reminder82Dates();
		else if (reminderId == 83) return config.reminder83Dates();
		else if (reminderId == 84) return config.reminder84Dates();
		else if (reminderId == 85) return config.reminder85Dates();
		else if (reminderId == 86) return config.reminder86Dates();
		else if (reminderId == 87) return config.reminder87Dates();
		else if (reminderId == 88) return config.reminder88Dates();
		else if (reminderId == 89) return config.reminder89Dates();
		else if (reminderId == 90) return config.reminder90Dates();
		else if (reminderId == 91) return config.reminder91Dates();
		else if (reminderId == 92) return config.reminder92Dates();
		else if (reminderId == 93) return config.reminder93Dates();
		else if (reminderId == 94) return config.reminder94Dates();
		else if (reminderId == 95) return config.reminder95Dates();
		else if (reminderId == 96) return config.reminder96Dates();
		else if (reminderId == 97) return config.reminder97Dates();
		else if (reminderId == 98) return config.reminder98Dates();
		else if (reminderId == 99) return config.reminder99Dates();
		else if (reminderId == 100) return config.reminder100Dates();
		else return "";
	}

	String getCoordinates(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Coordinates();
		else if (reminderId == 2) return config.reminder2Coordinates();
		else if (reminderId == 3) return config.reminder3Coordinates();
		else if (reminderId == 4) return config.reminder4Coordinates();
		else if (reminderId == 5) return config.reminder5Coordinates();
		else if (reminderId == 6) return config.reminder6Coordinates();
		else if (reminderId == 7) return config.reminder7Coordinates();
		else if (reminderId == 8) return config.reminder8Coordinates();
		else if (reminderId == 9) return config.reminder9Coordinates();
		else if (reminderId == 10) return config.reminder10Coordinates();
		else if (reminderId == 11) return config.reminder11Coordinates();
		else if (reminderId == 12) return config.reminder12Coordinates();
		else if (reminderId == 13) return config.reminder13Coordinates();
		else if (reminderId == 14) return config.reminder14Coordinates();
		else if (reminderId == 15) return config.reminder15Coordinates();
		else if (reminderId == 16) return config.reminder16Coordinates();
		else if (reminderId == 17) return config.reminder17Coordinates();
		else if (reminderId == 18) return config.reminder18Coordinates();
		else if (reminderId == 19) return config.reminder19Coordinates();
		else if (reminderId == 20) return config.reminder20Coordinates();
		else if (reminderId == 21) return config.reminder21Coordinates();
		else if (reminderId == 22) return config.reminder22Coordinates();
		else if (reminderId == 23) return config.reminder23Coordinates();
		else if (reminderId == 24) return config.reminder24Coordinates();
		else if (reminderId == 25) return config.reminder25Coordinates();
		else if (reminderId == 26) return config.reminder26Coordinates();
		else if (reminderId == 27) return config.reminder27Coordinates();
		else if (reminderId == 28) return config.reminder28Coordinates();
		else if (reminderId == 29) return config.reminder29Coordinates();
		else if (reminderId == 30) return config.reminder30Coordinates();
		else if (reminderId == 31) return config.reminder31Coordinates();
		else if (reminderId == 32) return config.reminder32Coordinates();
		else if (reminderId == 33) return config.reminder33Coordinates();
		else if (reminderId == 34) return config.reminder34Coordinates();
		else if (reminderId == 35) return config.reminder35Coordinates();
		else if (reminderId == 36) return config.reminder36Coordinates();
		else if (reminderId == 37) return config.reminder37Coordinates();
		else if (reminderId == 38) return config.reminder38Coordinates();
		else if (reminderId == 39) return config.reminder39Coordinates();
		else if (reminderId == 40) return config.reminder40Coordinates();
		else if (reminderId == 41) return config.reminder41Coordinates();
		else if (reminderId == 42) return config.reminder42Coordinates();
		else if (reminderId == 43) return config.reminder43Coordinates();
		else if (reminderId == 44) return config.reminder44Coordinates();
		else if (reminderId == 45) return config.reminder45Coordinates();
		else if (reminderId == 46) return config.reminder46Coordinates();
		else if (reminderId == 47) return config.reminder47Coordinates();
		else if (reminderId == 48) return config.reminder48Coordinates();
		else if (reminderId == 49) return config.reminder49Coordinates();
		else if (reminderId == 50) return config.reminder50Coordinates();
		else if (reminderId == 51) return config.reminder51Coordinates();
		else if (reminderId == 52) return config.reminder52Coordinates();
		else if (reminderId == 53) return config.reminder53Coordinates();
		else if (reminderId == 54) return config.reminder54Coordinates();
		else if (reminderId == 55) return config.reminder55Coordinates();
		else if (reminderId == 56) return config.reminder56Coordinates();
		else if (reminderId == 57) return config.reminder57Coordinates();
		else if (reminderId == 58) return config.reminder58Coordinates();
		else if (reminderId == 59) return config.reminder59Coordinates();
		else if (reminderId == 60) return config.reminder60Coordinates();
		else if (reminderId == 61) return config.reminder61Coordinates();
		else if (reminderId == 62) return config.reminder62Coordinates();
		else if (reminderId == 63) return config.reminder63Coordinates();
		else if (reminderId == 64) return config.reminder64Coordinates();
		else if (reminderId == 65) return config.reminder65Coordinates();
		else if (reminderId == 66) return config.reminder66Coordinates();
		else if (reminderId == 67) return config.reminder67Coordinates();
		else if (reminderId == 68) return config.reminder68Coordinates();
		else if (reminderId == 69) return config.reminder69Coordinates();
		else if (reminderId == 70) return config.reminder70Coordinates();
		else if (reminderId == 71) return config.reminder71Coordinates();
		else if (reminderId == 72) return config.reminder72Coordinates();
		else if (reminderId == 73) return config.reminder73Coordinates();
		else if (reminderId == 74) return config.reminder74Coordinates();
		else if (reminderId == 75) return config.reminder75Coordinates();
		else if (reminderId == 76) return config.reminder76Coordinates();
		else if (reminderId == 77) return config.reminder77Coordinates();
		else if (reminderId == 78) return config.reminder78Coordinates();
		else if (reminderId == 79) return config.reminder79Coordinates();
		else if (reminderId == 80) return config.reminder80Coordinates();
		else if (reminderId == 81) return config.reminder81Coordinates();
		else if (reminderId == 82) return config.reminder82Coordinates();
		else if (reminderId == 83) return config.reminder83Coordinates();
		else if (reminderId == 84) return config.reminder84Coordinates();
		else if (reminderId == 85) return config.reminder85Coordinates();
		else if (reminderId == 86) return config.reminder86Coordinates();
		else if (reminderId == 87) return config.reminder87Coordinates();
		else if (reminderId == 88) return config.reminder88Coordinates();
		else if (reminderId == 89) return config.reminder89Coordinates();
		else if (reminderId == 90) return config.reminder90Coordinates();
		else if (reminderId == 91) return config.reminder91Coordinates();
		else if (reminderId == 92) return config.reminder92Coordinates();
		else if (reminderId == 93) return config.reminder93Coordinates();
		else if (reminderId == 94) return config.reminder94Coordinates();
		else if (reminderId == 95) return config.reminder95Coordinates();
		else if (reminderId == 96) return config.reminder96Coordinates();
		else if (reminderId == 97) return config.reminder97Coordinates();
		else if (reminderId == 98) return config.reminder98Coordinates();
		else if (reminderId == 99) return config.reminder99Coordinates();
		else if (reminderId == 100) return config.reminder100Coordinates();
		else return "";
	}

	int getRadius(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Radius();
		else if (reminderId == 2) return config.reminder2Radius();
		else if (reminderId == 3) return config.reminder3Radius();
		else if (reminderId == 4) return config.reminder4Radius();
		else if (reminderId == 5) return config.reminder5Radius();
		else if (reminderId == 6) return config.reminder6Radius();
		else if (reminderId == 7) return config.reminder7Radius();
		else if (reminderId == 8) return config.reminder8Radius();
		else if (reminderId == 9) return config.reminder9Radius();
		else if (reminderId == 10) return config.reminder10Radius();
		else if (reminderId == 11) return config.reminder11Radius();
		else if (reminderId == 12) return config.reminder12Radius();
		else if (reminderId == 13) return config.reminder13Radius();
		else if (reminderId == 14) return config.reminder14Radius();
		else if (reminderId == 15) return config.reminder15Radius();
		else if (reminderId == 16) return config.reminder16Radius();
		else if (reminderId == 17) return config.reminder17Radius();
		else if (reminderId == 18) return config.reminder18Radius();
		else if (reminderId == 19) return config.reminder19Radius();
		else if (reminderId == 20) return config.reminder20Radius();
		else if (reminderId == 21) return config.reminder21Radius();
		else if (reminderId == 22) return config.reminder22Radius();
		else if (reminderId == 23) return config.reminder23Radius();
		else if (reminderId == 24) return config.reminder24Radius();
		else if (reminderId == 25) return config.reminder25Radius();
		else if (reminderId == 26) return config.reminder26Radius();
		else if (reminderId == 27) return config.reminder27Radius();
		else if (reminderId == 28) return config.reminder28Radius();
		else if (reminderId == 29) return config.reminder29Radius();
		else if (reminderId == 30) return config.reminder30Radius();
		else if (reminderId == 31) return config.reminder31Radius();
		else if (reminderId == 32) return config.reminder32Radius();
		else if (reminderId == 33) return config.reminder33Radius();
		else if (reminderId == 34) return config.reminder34Radius();
		else if (reminderId == 35) return config.reminder35Radius();
		else if (reminderId == 36) return config.reminder36Radius();
		else if (reminderId == 37) return config.reminder37Radius();
		else if (reminderId == 38) return config.reminder38Radius();
		else if (reminderId == 39) return config.reminder39Radius();
		else if (reminderId == 40) return config.reminder40Radius();
		else if (reminderId == 41) return config.reminder41Radius();
		else if (reminderId == 42) return config.reminder42Radius();
		else if (reminderId == 43) return config.reminder43Radius();
		else if (reminderId == 44) return config.reminder44Radius();
		else if (reminderId == 45) return config.reminder45Radius();
		else if (reminderId == 46) return config.reminder46Radius();
		else if (reminderId == 47) return config.reminder47Radius();
		else if (reminderId == 48) return config.reminder48Radius();
		else if (reminderId == 49) return config.reminder49Radius();
		else if (reminderId == 50) return config.reminder50Radius();
		else if (reminderId == 51) return config.reminder51Radius();
		else if (reminderId == 52) return config.reminder52Radius();
		else if (reminderId == 53) return config.reminder53Radius();
		else if (reminderId == 54) return config.reminder54Radius();
		else if (reminderId == 55) return config.reminder55Radius();
		else if (reminderId == 56) return config.reminder56Radius();
		else if (reminderId == 57) return config.reminder57Radius();
		else if (reminderId == 58) return config.reminder58Radius();
		else if (reminderId == 59) return config.reminder59Radius();
		else if (reminderId == 60) return config.reminder60Radius();
		else if (reminderId == 61) return config.reminder61Radius();
		else if (reminderId == 62) return config.reminder62Radius();
		else if (reminderId == 63) return config.reminder63Radius();
		else if (reminderId == 64) return config.reminder64Radius();
		else if (reminderId == 65) return config.reminder65Radius();
		else if (reminderId == 66) return config.reminder66Radius();
		else if (reminderId == 67) return config.reminder67Radius();
		else if (reminderId == 68) return config.reminder68Radius();
		else if (reminderId == 69) return config.reminder69Radius();
		else if (reminderId == 70) return config.reminder70Radius();
		else if (reminderId == 71) return config.reminder71Radius();
		else if (reminderId == 72) return config.reminder72Radius();
		else if (reminderId == 73) return config.reminder73Radius();
		else if (reminderId == 74) return config.reminder74Radius();
		else if (reminderId == 75) return config.reminder75Radius();
		else if (reminderId == 76) return config.reminder76Radius();
		else if (reminderId == 77) return config.reminder77Radius();
		else if (reminderId == 78) return config.reminder78Radius();
		else if (reminderId == 79) return config.reminder79Radius();
		else if (reminderId == 80) return config.reminder80Radius();
		else if (reminderId == 81) return config.reminder81Radius();
		else if (reminderId == 82) return config.reminder82Radius();
		else if (reminderId == 83) return config.reminder83Radius();
		else if (reminderId == 84) return config.reminder84Radius();
		else if (reminderId == 85) return config.reminder85Radius();
		else if (reminderId == 86) return config.reminder86Radius();
		else if (reminderId == 87) return config.reminder87Radius();
		else if (reminderId == 88) return config.reminder88Radius();
		else if (reminderId == 89) return config.reminder89Radius();
		else if (reminderId == 90) return config.reminder90Radius();
		else if (reminderId == 91) return config.reminder91Radius();
		else if (reminderId == 92) return config.reminder92Radius();
		else if (reminderId == 93) return config.reminder93Radius();
		else if (reminderId == 94) return config.reminder94Radius();
		else if (reminderId == 95) return config.reminder95Radius();
		else if (reminderId == 96) return config.reminder96Radius();
		else if (reminderId == 97) return config.reminder97Radius();
		else if (reminderId == 98) return config.reminder98Radius();
		else if (reminderId == 99) return config.reminder99Radius();
		else if (reminderId == 100) return config.reminder100Radius();
		else return 0;
	}

	String getGeofences(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Geofences();
		else if (reminderId == 2) return config.reminder2Geofences();
		else if (reminderId == 3) return config.reminder3Geofences();
		else if (reminderId == 4) return config.reminder4Geofences();
		else if (reminderId == 5) return config.reminder5Geofences();
		else if (reminderId == 6) return config.reminder6Geofences();
		else if (reminderId == 7) return config.reminder7Geofences();
		else if (reminderId == 8) return config.reminder8Geofences();
		else if (reminderId == 9) return config.reminder9Geofences();
		else if (reminderId == 10) return config.reminder10Geofences();
		else if (reminderId == 11) return config.reminder11Geofences();
		else if (reminderId == 12) return config.reminder12Geofences();
		else if (reminderId == 13) return config.reminder13Geofences();
		else if (reminderId == 14) return config.reminder14Geofences();
		else if (reminderId == 15) return config.reminder15Geofences();
		else if (reminderId == 16) return config.reminder16Geofences();
		else if (reminderId == 17) return config.reminder17Geofences();
		else if (reminderId == 18) return config.reminder18Geofences();
		else if (reminderId == 19) return config.reminder19Geofences();
		else if (reminderId == 20) return config.reminder20Geofences();
		else if (reminderId == 21) return config.reminder21Geofences();
		else if (reminderId == 22) return config.reminder22Geofences();
		else if (reminderId == 23) return config.reminder23Geofences();
		else if (reminderId == 24) return config.reminder24Geofences();
		else if (reminderId == 25) return config.reminder25Geofences();
		else if (reminderId == 26) return config.reminder26Geofences();
		else if (reminderId == 27) return config.reminder27Geofences();
		else if (reminderId == 28) return config.reminder28Geofences();
		else if (reminderId == 29) return config.reminder29Geofences();
		else if (reminderId == 30) return config.reminder30Geofences();
		else if (reminderId == 31) return config.reminder31Geofences();
		else if (reminderId == 32) return config.reminder32Geofences();
		else if (reminderId == 33) return config.reminder33Geofences();
		else if (reminderId == 34) return config.reminder34Geofences();
		else if (reminderId == 35) return config.reminder35Geofences();
		else if (reminderId == 36) return config.reminder36Geofences();
		else if (reminderId == 37) return config.reminder37Geofences();
		else if (reminderId == 38) return config.reminder38Geofences();
		else if (reminderId == 39) return config.reminder39Geofences();
		else if (reminderId == 40) return config.reminder40Geofences();
		else if (reminderId == 41) return config.reminder41Geofences();
		else if (reminderId == 42) return config.reminder42Geofences();
		else if (reminderId == 43) return config.reminder43Geofences();
		else if (reminderId == 44) return config.reminder44Geofences();
		else if (reminderId == 45) return config.reminder45Geofences();
		else if (reminderId == 46) return config.reminder46Geofences();
		else if (reminderId == 47) return config.reminder47Geofences();
		else if (reminderId == 48) return config.reminder48Geofences();
		else if (reminderId == 49) return config.reminder49Geofences();
		else if (reminderId == 50) return config.reminder50Geofences();
		else if (reminderId == 51) return config.reminder51Geofences();
		else if (reminderId == 52) return config.reminder52Geofences();
		else if (reminderId == 53) return config.reminder53Geofences();
		else if (reminderId == 54) return config.reminder54Geofences();
		else if (reminderId == 55) return config.reminder55Geofences();
		else if (reminderId == 56) return config.reminder56Geofences();
		else if (reminderId == 57) return config.reminder57Geofences();
		else if (reminderId == 58) return config.reminder58Geofences();
		else if (reminderId == 59) return config.reminder59Geofences();
		else if (reminderId == 60) return config.reminder60Geofences();
		else if (reminderId == 61) return config.reminder61Geofences();
		else if (reminderId == 62) return config.reminder62Geofences();
		else if (reminderId == 63) return config.reminder63Geofences();
		else if (reminderId == 64) return config.reminder64Geofences();
		else if (reminderId == 65) return config.reminder65Geofences();
		else if (reminderId == 66) return config.reminder66Geofences();
		else if (reminderId == 67) return config.reminder67Geofences();
		else if (reminderId == 68) return config.reminder68Geofences();
		else if (reminderId == 69) return config.reminder69Geofences();
		else if (reminderId == 70) return config.reminder70Geofences();
		else if (reminderId == 71) return config.reminder71Geofences();
		else if (reminderId == 72) return config.reminder72Geofences();
		else if (reminderId == 73) return config.reminder73Geofences();
		else if (reminderId == 74) return config.reminder74Geofences();
		else if (reminderId == 75) return config.reminder75Geofences();
		else if (reminderId == 76) return config.reminder76Geofences();
		else if (reminderId == 77) return config.reminder77Geofences();
		else if (reminderId == 78) return config.reminder78Geofences();
		else if (reminderId == 79) return config.reminder79Geofences();
		else if (reminderId == 80) return config.reminder80Geofences();
		else if (reminderId == 81) return config.reminder81Geofences();
		else if (reminderId == 82) return config.reminder82Geofences();
		else if (reminderId == 83) return config.reminder83Geofences();
		else if (reminderId == 84) return config.reminder84Geofences();
		else if (reminderId == 85) return config.reminder85Geofences();
		else if (reminderId == 86) return config.reminder86Geofences();
		else if (reminderId == 87) return config.reminder87Geofences();
		else if (reminderId == 88) return config.reminder88Geofences();
		else if (reminderId == 89) return config.reminder89Geofences();
		else if (reminderId == 90) return config.reminder90Geofences();
		else if (reminderId == 91) return config.reminder91Geofences();
		else if (reminderId == 92) return config.reminder92Geofences();
		else if (reminderId == 93) return config.reminder93Geofences();
		else if (reminderId == 94) return config.reminder94Geofences();
		else if (reminderId == 95) return config.reminder95Geofences();
		else if (reminderId == 96) return config.reminder96Geofences();
		else if (reminderId == 97) return config.reminder97Geofences();
		else if (reminderId == 98) return config.reminder98Geofences();
		else if (reminderId == 99) return config.reminder99Geofences();
		else if (reminderId == 100) return config.reminder100Geofences();
		else return "";
	}

	String getRegionIds(int reminderId)
	{
		if (reminderId == 1) return config.reminder1RegionIds();
		else if (reminderId == 2) return config.reminder2RegionIds();
		else if (reminderId == 3) return config.reminder3RegionIds();
		else if (reminderId == 4) return config.reminder4RegionIds();
		else if (reminderId == 5) return config.reminder5RegionIds();
		else if (reminderId == 6) return config.reminder6RegionIds();
		else if (reminderId == 7) return config.reminder7RegionIds();
		else if (reminderId == 8) return config.reminder8RegionIds();
		else if (reminderId == 9) return config.reminder9RegionIds();
		else if (reminderId == 10) return config.reminder10RegionIds();
		else if (reminderId == 11) return config.reminder11RegionIds();
		else if (reminderId == 12) return config.reminder12RegionIds();
		else if (reminderId == 13) return config.reminder13RegionIds();
		else if (reminderId == 14) return config.reminder14RegionIds();
		else if (reminderId == 15) return config.reminder15RegionIds();
		else if (reminderId == 16) return config.reminder16RegionIds();
		else if (reminderId == 17) return config.reminder17RegionIds();
		else if (reminderId == 18) return config.reminder18RegionIds();
		else if (reminderId == 19) return config.reminder19RegionIds();
		else if (reminderId == 20) return config.reminder20RegionIds();
		else if (reminderId == 21) return config.reminder21RegionIds();
		else if (reminderId == 22) return config.reminder22RegionIds();
		else if (reminderId == 23) return config.reminder23RegionIds();
		else if (reminderId == 24) return config.reminder24RegionIds();
		else if (reminderId == 25) return config.reminder25RegionIds();
		else if (reminderId == 26) return config.reminder26RegionIds();
		else if (reminderId == 27) return config.reminder27RegionIds();
		else if (reminderId == 28) return config.reminder28RegionIds();
		else if (reminderId == 29) return config.reminder29RegionIds();
		else if (reminderId == 30) return config.reminder30RegionIds();
		else if (reminderId == 31) return config.reminder31RegionIds();
		else if (reminderId == 32) return config.reminder32RegionIds();
		else if (reminderId == 33) return config.reminder33RegionIds();
		else if (reminderId == 34) return config.reminder34RegionIds();
		else if (reminderId == 35) return config.reminder35RegionIds();
		else if (reminderId == 36) return config.reminder36RegionIds();
		else if (reminderId == 37) return config.reminder37RegionIds();
		else if (reminderId == 38) return config.reminder38RegionIds();
		else if (reminderId == 39) return config.reminder39RegionIds();
		else if (reminderId == 40) return config.reminder40RegionIds();
		else if (reminderId == 41) return config.reminder41RegionIds();
		else if (reminderId == 42) return config.reminder42RegionIds();
		else if (reminderId == 43) return config.reminder43RegionIds();
		else if (reminderId == 44) return config.reminder44RegionIds();
		else if (reminderId == 45) return config.reminder45RegionIds();
		else if (reminderId == 46) return config.reminder46RegionIds();
		else if (reminderId == 47) return config.reminder47RegionIds();
		else if (reminderId == 48) return config.reminder48RegionIds();
		else if (reminderId == 49) return config.reminder49RegionIds();
		else if (reminderId == 50) return config.reminder50RegionIds();
		else if (reminderId == 51) return config.reminder51RegionIds();
		else if (reminderId == 52) return config.reminder52RegionIds();
		else if (reminderId == 53) return config.reminder53RegionIds();
		else if (reminderId == 54) return config.reminder54RegionIds();
		else if (reminderId == 55) return config.reminder55RegionIds();
		else if (reminderId == 56) return config.reminder56RegionIds();
		else if (reminderId == 57) return config.reminder57RegionIds();
		else if (reminderId == 58) return config.reminder58RegionIds();
		else if (reminderId == 59) return config.reminder59RegionIds();
		else if (reminderId == 60) return config.reminder60RegionIds();
		else if (reminderId == 61) return config.reminder61RegionIds();
		else if (reminderId == 62) return config.reminder62RegionIds();
		else if (reminderId == 63) return config.reminder63RegionIds();
		else if (reminderId == 64) return config.reminder64RegionIds();
		else if (reminderId == 65) return config.reminder65RegionIds();
		else if (reminderId == 66) return config.reminder66RegionIds();
		else if (reminderId == 67) return config.reminder67RegionIds();
		else if (reminderId == 68) return config.reminder68RegionIds();
		else if (reminderId == 69) return config.reminder69RegionIds();
		else if (reminderId == 70) return config.reminder70RegionIds();
		else if (reminderId == 71) return config.reminder71RegionIds();
		else if (reminderId == 72) return config.reminder72RegionIds();
		else if (reminderId == 73) return config.reminder73RegionIds();
		else if (reminderId == 74) return config.reminder74RegionIds();
		else if (reminderId == 75) return config.reminder75RegionIds();
		else if (reminderId == 76) return config.reminder76RegionIds();
		else if (reminderId == 77) return config.reminder77RegionIds();
		else if (reminderId == 78) return config.reminder78RegionIds();
		else if (reminderId == 79) return config.reminder79RegionIds();
		else if (reminderId == 80) return config.reminder80RegionIds();
		else if (reminderId == 81) return config.reminder81RegionIds();
		else if (reminderId == 82) return config.reminder82RegionIds();
		else if (reminderId == 83) return config.reminder83RegionIds();
		else if (reminderId == 84) return config.reminder84RegionIds();
		else if (reminderId == 85) return config.reminder85RegionIds();
		else if (reminderId == 86) return config.reminder86RegionIds();
		else if (reminderId == 87) return config.reminder87RegionIds();
		else if (reminderId == 88) return config.reminder88RegionIds();
		else if (reminderId == 89) return config.reminder89RegionIds();
		else if (reminderId == 90) return config.reminder90RegionIds();
		else if (reminderId == 91) return config.reminder91RegionIds();
		else if (reminderId == 92) return config.reminder92RegionIds();
		else if (reminderId == 93) return config.reminder93RegionIds();
		else if (reminderId == 94) return config.reminder94RegionIds();
		else if (reminderId == 95) return config.reminder95RegionIds();
		else if (reminderId == 96) return config.reminder96RegionIds();
		else if (reminderId == 97) return config.reminder97RegionIds();
		else if (reminderId == 98) return config.reminder98RegionIds();
		else if (reminderId == 99) return config.reminder99RegionIds();
		else if (reminderId == 100) return config.reminder100RegionIds();
		else return "";
	}

	String getNpcIds(int reminderId)
	{
		if (reminderId == 1) return config.reminder1NpcIds();
		else if (reminderId == 2) return config.reminder2NpcIds();
		else if (reminderId == 3) return config.reminder3NpcIds();
		else if (reminderId == 4) return config.reminder4NpcIds();
		else if (reminderId == 5) return config.reminder5NpcIds();
		else if (reminderId == 6) return config.reminder6NpcIds();
		else if (reminderId == 7) return config.reminder7NpcIds();
		else if (reminderId == 8) return config.reminder8NpcIds();
		else if (reminderId == 9) return config.reminder9NpcIds();
		else if (reminderId == 10) return config.reminder10NpcIds();
		else if (reminderId == 11) return config.reminder11NpcIds();
		else if (reminderId == 12) return config.reminder12NpcIds();
		else if (reminderId == 13) return config.reminder13NpcIds();
		else if (reminderId == 14) return config.reminder14NpcIds();
		else if (reminderId == 15) return config.reminder15NpcIds();
		else if (reminderId == 16) return config.reminder16NpcIds();
		else if (reminderId == 17) return config.reminder17NpcIds();
		else if (reminderId == 18) return config.reminder18NpcIds();
		else if (reminderId == 19) return config.reminder19NpcIds();
		else if (reminderId == 20) return config.reminder20NpcIds();
		else if (reminderId == 21) return config.reminder21NpcIds();
		else if (reminderId == 22) return config.reminder22NpcIds();
		else if (reminderId == 23) return config.reminder23NpcIds();
		else if (reminderId == 24) return config.reminder24NpcIds();
		else if (reminderId == 25) return config.reminder25NpcIds();
		else if (reminderId == 26) return config.reminder26NpcIds();
		else if (reminderId == 27) return config.reminder27NpcIds();
		else if (reminderId == 28) return config.reminder28NpcIds();
		else if (reminderId == 29) return config.reminder29NpcIds();
		else if (reminderId == 30) return config.reminder30NpcIds();
		else if (reminderId == 31) return config.reminder31NpcIds();
		else if (reminderId == 32) return config.reminder32NpcIds();
		else if (reminderId == 33) return config.reminder33NpcIds();
		else if (reminderId == 34) return config.reminder34NpcIds();
		else if (reminderId == 35) return config.reminder35NpcIds();
		else if (reminderId == 36) return config.reminder36NpcIds();
		else if (reminderId == 37) return config.reminder37NpcIds();
		else if (reminderId == 38) return config.reminder38NpcIds();
		else if (reminderId == 39) return config.reminder39NpcIds();
		else if (reminderId == 40) return config.reminder40NpcIds();
		else if (reminderId == 41) return config.reminder41NpcIds();
		else if (reminderId == 42) return config.reminder42NpcIds();
		else if (reminderId == 43) return config.reminder43NpcIds();
		else if (reminderId == 44) return config.reminder44NpcIds();
		else if (reminderId == 45) return config.reminder45NpcIds();
		else if (reminderId == 46) return config.reminder46NpcIds();
		else if (reminderId == 47) return config.reminder47NpcIds();
		else if (reminderId == 48) return config.reminder48NpcIds();
		else if (reminderId == 49) return config.reminder49NpcIds();
		else if (reminderId == 50) return config.reminder50NpcIds();
		else if (reminderId == 51) return config.reminder51NpcIds();
		else if (reminderId == 52) return config.reminder52NpcIds();
		else if (reminderId == 53) return config.reminder53NpcIds();
		else if (reminderId == 54) return config.reminder54NpcIds();
		else if (reminderId == 55) return config.reminder55NpcIds();
		else if (reminderId == 56) return config.reminder56NpcIds();
		else if (reminderId == 57) return config.reminder57NpcIds();
		else if (reminderId == 58) return config.reminder58NpcIds();
		else if (reminderId == 59) return config.reminder59NpcIds();
		else if (reminderId == 60) return config.reminder60NpcIds();
		else if (reminderId == 61) return config.reminder61NpcIds();
		else if (reminderId == 62) return config.reminder62NpcIds();
		else if (reminderId == 63) return config.reminder63NpcIds();
		else if (reminderId == 64) return config.reminder64NpcIds();
		else if (reminderId == 65) return config.reminder65NpcIds();
		else if (reminderId == 66) return config.reminder66NpcIds();
		else if (reminderId == 67) return config.reminder67NpcIds();
		else if (reminderId == 68) return config.reminder68NpcIds();
		else if (reminderId == 69) return config.reminder69NpcIds();
		else if (reminderId == 70) return config.reminder70NpcIds();
		else if (reminderId == 71) return config.reminder71NpcIds();
		else if (reminderId == 72) return config.reminder72NpcIds();
		else if (reminderId == 73) return config.reminder73NpcIds();
		else if (reminderId == 74) return config.reminder74NpcIds();
		else if (reminderId == 75) return config.reminder75NpcIds();
		else if (reminderId == 76) return config.reminder76NpcIds();
		else if (reminderId == 77) return config.reminder77NpcIds();
		else if (reminderId == 78) return config.reminder78NpcIds();
		else if (reminderId == 79) return config.reminder79NpcIds();
		else if (reminderId == 80) return config.reminder80NpcIds();
		else if (reminderId == 81) return config.reminder81NpcIds();
		else if (reminderId == 82) return config.reminder82NpcIds();
		else if (reminderId == 83) return config.reminder83NpcIds();
		else if (reminderId == 84) return config.reminder84NpcIds();
		else if (reminderId == 85) return config.reminder85NpcIds();
		else if (reminderId == 86) return config.reminder86NpcIds();
		else if (reminderId == 87) return config.reminder87NpcIds();
		else if (reminderId == 88) return config.reminder88NpcIds();
		else if (reminderId == 89) return config.reminder89NpcIds();
		else if (reminderId == 90) return config.reminder90NpcIds();
		else if (reminderId == 91) return config.reminder91NpcIds();
		else if (reminderId == 92) return config.reminder92NpcIds();
		else if (reminderId == 93) return config.reminder93NpcIds();
		else if (reminderId == 94) return config.reminder94NpcIds();
		else if (reminderId == 95) return config.reminder95NpcIds();
		else if (reminderId == 96) return config.reminder96NpcIds();
		else if (reminderId == 97) return config.reminder97NpcIds();
		else if (reminderId == 98) return config.reminder98NpcIds();
		else if (reminderId == 99) return config.reminder99NpcIds();
		else if (reminderId == 100) return config.reminder100NpcIds();
		else return "";
	}

	String getItemIds(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ItemIds();
		else if (reminderId == 2) return config.reminder2ItemIds();
		else if (reminderId == 3) return config.reminder3ItemIds();
		else if (reminderId == 4) return config.reminder4ItemIds();
		else if (reminderId == 5) return config.reminder5ItemIds();
		else if (reminderId == 6) return config.reminder6ItemIds();
		else if (reminderId == 7) return config.reminder7ItemIds();
		else if (reminderId == 8) return config.reminder8ItemIds();
		else if (reminderId == 9) return config.reminder9ItemIds();
		else if (reminderId == 10) return config.reminder10ItemIds();
		else if (reminderId == 11) return config.reminder11ItemIds();
		else if (reminderId == 12) return config.reminder12ItemIds();
		else if (reminderId == 13) return config.reminder13ItemIds();
		else if (reminderId == 14) return config.reminder14ItemIds();
		else if (reminderId == 15) return config.reminder15ItemIds();
		else if (reminderId == 16) return config.reminder16ItemIds();
		else if (reminderId == 17) return config.reminder17ItemIds();
		else if (reminderId == 18) return config.reminder18ItemIds();
		else if (reminderId == 19) return config.reminder19ItemIds();
		else if (reminderId == 20) return config.reminder20ItemIds();
		else if (reminderId == 21) return config.reminder21ItemIds();
		else if (reminderId == 22) return config.reminder22ItemIds();
		else if (reminderId == 23) return config.reminder23ItemIds();
		else if (reminderId == 24) return config.reminder24ItemIds();
		else if (reminderId == 25) return config.reminder25ItemIds();
		else if (reminderId == 26) return config.reminder26ItemIds();
		else if (reminderId == 27) return config.reminder27ItemIds();
		else if (reminderId == 28) return config.reminder28ItemIds();
		else if (reminderId == 29) return config.reminder29ItemIds();
		else if (reminderId == 30) return config.reminder30ItemIds();
		else if (reminderId == 31) return config.reminder31ItemIds();
		else if (reminderId == 32) return config.reminder32ItemIds();
		else if (reminderId == 33) return config.reminder33ItemIds();
		else if (reminderId == 34) return config.reminder34ItemIds();
		else if (reminderId == 35) return config.reminder35ItemIds();
		else if (reminderId == 36) return config.reminder36ItemIds();
		else if (reminderId == 37) return config.reminder37ItemIds();
		else if (reminderId == 38) return config.reminder38ItemIds();
		else if (reminderId == 39) return config.reminder39ItemIds();
		else if (reminderId == 40) return config.reminder40ItemIds();
		else if (reminderId == 41) return config.reminder41ItemIds();
		else if (reminderId == 42) return config.reminder42ItemIds();
		else if (reminderId == 43) return config.reminder43ItemIds();
		else if (reminderId == 44) return config.reminder44ItemIds();
		else if (reminderId == 45) return config.reminder45ItemIds();
		else if (reminderId == 46) return config.reminder46ItemIds();
		else if (reminderId == 47) return config.reminder47ItemIds();
		else if (reminderId == 48) return config.reminder48ItemIds();
		else if (reminderId == 49) return config.reminder49ItemIds();
		else if (reminderId == 50) return config.reminder50ItemIds();
		else if (reminderId == 51) return config.reminder51ItemIds();
		else if (reminderId == 52) return config.reminder52ItemIds();
		else if (reminderId == 53) return config.reminder53ItemIds();
		else if (reminderId == 54) return config.reminder54ItemIds();
		else if (reminderId == 55) return config.reminder55ItemIds();
		else if (reminderId == 56) return config.reminder56ItemIds();
		else if (reminderId == 57) return config.reminder57ItemIds();
		else if (reminderId == 58) return config.reminder58ItemIds();
		else if (reminderId == 59) return config.reminder59ItemIds();
		else if (reminderId == 60) return config.reminder60ItemIds();
		else if (reminderId == 61) return config.reminder61ItemIds();
		else if (reminderId == 62) return config.reminder62ItemIds();
		else if (reminderId == 63) return config.reminder63ItemIds();
		else if (reminderId == 64) return config.reminder64ItemIds();
		else if (reminderId == 65) return config.reminder65ItemIds();
		else if (reminderId == 66) return config.reminder66ItemIds();
		else if (reminderId == 67) return config.reminder67ItemIds();
		else if (reminderId == 68) return config.reminder68ItemIds();
		else if (reminderId == 69) return config.reminder69ItemIds();
		else if (reminderId == 70) return config.reminder70ItemIds();
		else if (reminderId == 71) return config.reminder71ItemIds();
		else if (reminderId == 72) return config.reminder72ItemIds();
		else if (reminderId == 73) return config.reminder73ItemIds();
		else if (reminderId == 74) return config.reminder74ItemIds();
		else if (reminderId == 75) return config.reminder75ItemIds();
		else if (reminderId == 76) return config.reminder76ItemIds();
		else if (reminderId == 77) return config.reminder77ItemIds();
		else if (reminderId == 78) return config.reminder78ItemIds();
		else if (reminderId == 79) return config.reminder79ItemIds();
		else if (reminderId == 80) return config.reminder80ItemIds();
		else if (reminderId == 81) return config.reminder81ItemIds();
		else if (reminderId == 82) return config.reminder82ItemIds();
		else if (reminderId == 83) return config.reminder83ItemIds();
		else if (reminderId == 84) return config.reminder84ItemIds();
		else if (reminderId == 85) return config.reminder85ItemIds();
		else if (reminderId == 86) return config.reminder86ItemIds();
		else if (reminderId == 87) return config.reminder87ItemIds();
		else if (reminderId == 88) return config.reminder88ItemIds();
		else if (reminderId == 89) return config.reminder89ItemIds();
		else if (reminderId == 90) return config.reminder90ItemIds();
		else if (reminderId == 91) return config.reminder91ItemIds();
		else if (reminderId == 92) return config.reminder92ItemIds();
		else if (reminderId == 93) return config.reminder93ItemIds();
		else if (reminderId == 94) return config.reminder94ItemIds();
		else if (reminderId == 95) return config.reminder95ItemIds();
		else if (reminderId == 96) return config.reminder96ItemIds();
		else if (reminderId == 97) return config.reminder97ItemIds();
		else if (reminderId == 98) return config.reminder98ItemIds();
		else if (reminderId == 99) return config.reminder99ItemIds();
		else if (reminderId == 100) return config.reminder100ItemIds();
		else return "";
	}
}