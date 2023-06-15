package com.ericversteeg;

import com.ericversteeg.config.ColorAnimationType;
import com.ericversteeg.config.Location;
import com.ericversteeg.config.TimeUnit;
import com.ericversteeg.reminder.Reminder;
import com.ericversteeg.reminder.Reminders;
import com.ericversteeg.views.RSAnchorType;
import com.ericversteeg.views.RSViewGroup;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(
	name = "Easy Reminder",
	description = "Set reminders."
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
	@Inject
	private Notifier notifier;

	List<Reminder> reminders = new ArrayList<>();
	List<Reminder> activeReminders = new ArrayList<>();
	List<Reminder> inactiveReminders = new ArrayList<>();
	Map<Integer, Integer> savedCounts = new HashMap<>();

	LocalDateTime dateTime = LocalDateTime.now(ZoneId.systemDefault());

	int regionId = 0;
	int lastRegionId = 0;

	List<NPC> npcs = new ArrayList<>();

	List<ChatMessage> chatMessages = new ArrayList<>();

	List<ItemComposition> inventoryItems = new ArrayList<>();

	WorldPoint worldPos = new WorldPoint(0, 0, 0);

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(overlay);

		reminders = getAllReminders();
		activeReminders = getActiveReminders(reminders);
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
		if (config.getGroup().equals(RemindersConfig.GROUP))
		{
			reminders = getAllReminders();
			activeReminders = getActiveReminders(reminders);
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick) {
		dateTime = LocalDateTime.now(ZoneId.systemDefault());

		activeReminders = getActiveReminders(reminders);

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

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		chatMessages.add(chatMessage);
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

	private List<Reminder> getAllReminders()
	{
		long start = Instant.now().toEpochMilli();

		List<Reminder> reminders = new ArrayList<>();

		Pattern colorPattern = Pattern.compile("\\^\\w");

		for (int i = 1; i <= 100; i++) {
			Reminder reminder = new Reminder();

			reminder.id = i;
			reminder.enable = isEnable(i);
			reminder.forceShow = isForceShow(i);
			reminder.text = getText(i);
			reminder.colur = getColor(i);
			reminder.duration = getDuration(i);
			reminder.cooldown = getCooldown(i);
			reminder.timeUnit = getTimeUnit(i).getType();
			reminder.notify = isNotify(i);
			reminder.times = getTimes(i);
			reminder.daysOfWeek = getDaysOfWeek(i);
			reminder.dates = getDates(i);
			reminder.coordinates = getCoordinates(i);
			reminder.radius = getRadius(i);
			reminder.geoFences = getGeofences(i);
			reminder.regionIds = getRegionIds(i);
			reminder.npcIds = getNpcIds(i);
			reminder.itemIds = getItemIds(i);
			reminder.chatPatterns = getChatPatterns(i);

			Integer savedCount = savedCounts.get(i);
			if (savedCount != null)
			{
				reminder.savedCount = savedCount;
			}

			reminders.add(reminder);
		}

		try {
			JsonArray jsonArray = gson.fromJson(config.customReminders(), JsonArray.class);

			int i = 1;
			for (JsonElement jsonElement: jsonArray)
			{
				JsonObject jsonObject = jsonElement.getAsJsonObject();

				Reminder reminder = new Reminder();

				reminder.id = 100 + i;

				if (jsonObject.has("enable"))
				{
					reminder.enable = jsonObject.get("enable").getAsBoolean();
				}

				if (jsonObject.has("force_show"))
				{
					reminder.enable = jsonObject.get("force_show").getAsBoolean();
				}

				if (jsonObject.has("text"))
				{
					reminder.text = jsonObject.get("text").getAsString();
				}

				if (jsonObject.has("color"))
				{
					reminder.colorStr = jsonObject.get("color").getAsString();
				}

				if (jsonObject.has("duration"))
				{
					reminder.duration = jsonObject.get("duration").getAsInt();
				}

				if (jsonObject.has("cooldown"))
				{
					reminder.cooldown = jsonObject.get("cooldown").getAsInt();
				}

				if (jsonObject.has("time_unit"))
				{
					reminder.timeUnit = jsonObject.get("time_unit").getAsInt();
				}

				if (jsonObject.has("notify"))
				{
					reminder.notify = jsonObject.get("notify").getAsBoolean();
				}

				if (jsonObject.has("times"))
				{
					reminder.times = toCsv(jsonObject.get("times").getAsJsonArray());
				}

				if (jsonObject.has("days_of_week"))
				{
					reminder.daysOfWeek = toCsv(jsonObject.get("days_of_week").getAsJsonArray());
				}

				if (jsonObject.has("dates"))
				{
					reminder.dates = toCsv(jsonObject.get("dates").getAsJsonArray());
				}

				if (jsonObject.has("coordinates"))
				{
					reminder.coordinates = toCsv(jsonObject.get("coordinates").getAsJsonArray());
				}

				if (jsonObject.has("radius"))
				{
					reminder.radius = jsonObject.get("radius").getAsInt();
				}

				if (jsonObject.has("geofences"))
				{
					reminder.geoFences = toCsv(jsonObject.get("geofences").getAsJsonArray());
				}

				if (jsonObject.has("region_ids"))
				{
					reminder.regionIds = toCsv(jsonObject.get("region_ids").getAsJsonArray());
				}

				if (jsonObject.has("npc_ids"))
				{
					reminder.npcIds = toCsv(jsonObject.get("npc_ids").getAsJsonArray());
				}

				if (jsonObject.has("item_ids"))
				{
					reminder.itemIds = toCsv(jsonObject.get("item_ids").getAsJsonArray());
				}

				if (jsonObject.has("chat_patterns"))
				{
					reminder.chatPatterns = toCsv(jsonObject.get("chat_patterns").getAsJsonArray());
				}

				Integer savedCount = savedCounts.get(i);
				if (savedCount != null)
				{
					reminder.savedCount = savedCount;
				}

				reminders.add(reminder);

				i++;
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
			return reminders;
		}


		System.out.println("Get reminders took " + (Instant.now().toEpochMilli() - start) + "ms");

		return reminders;
	}

	private List<Reminder> getActiveReminders(List<Reminder> reminders)
	{
		long start = Instant.now().toEpochMilli();

		List<Reminder> activeList = new ArrayList<>();

		activeReminders.addAll(inactiveReminders);
		inactiveReminders.clear();

		for (Reminder reminder: reminders)
		{
			if (reminder.forceShow)
			{
				activeList.add(reminder);
			}
		}

		for (Reminder reminder: reminders)
		{
			if (reminder.enable && !reminder.forceShow)
			{
				if (!((checkTimes(reminder.times) && !matchesTimes(reminder.times)) ||
					(checkDaysOfWeek(reminder.daysOfWeek) && !matchesDaysOfWeek(reminder.daysOfWeek)) ||
					(checkDates(reminder.dates) && !matchesDates(reminder.dates)) ||
					(checkCoordinates(reminder.coordinates) && !matchesCoordinates(reminder.coordinates, reminder.radius)) ||
					(checkGeoFences(reminder.geoFences) && !matchesGeoFences(reminder.geoFences)) ||
					(checkRegions(reminder.regionIds) && !matchesRegions(reminder.regionIds)) ||
					(checkNpcIds(reminder.npcIds) && !matchesNpcIds(reminder.npcIds)) ||
					(checkItemIds(reminder.itemIds) && !matchesItemIds(reminder.itemIds)) ||
					(checkChatPatterns(reminder.chatPatterns) && !matchesChatPatterns(reminder.chatPatterns)))
				)
				{
					Reminder currentActive = currentActiveReminder(reminder.id);
					if (currentActive != null)
					{
						reminder.posted = currentActive.posted;
						reminder.active = currentActive.active;
					}
					else
					{
						reminder.posted = Instant.now().toEpochMilli();
						reminder.active = true;

						if (reminder.notify && reminder.lastNotified <= Instant.now().toEpochMilli() - 30000)
						{
							notifier.notify(reminder.text);
							reminder.lastNotified = Instant.now().toEpochMilli();
						}
					}

					if (Instant.now().toEpochMilli() >= reminder.posted
							+ reminder.getDurationMillis() + reminder.getCooldownMillis())
					{
						reminder.active = true;
						reminder.posted = Instant.now().toEpochMilli();

						if (reminder.notify && reminder.lastNotified <= Instant.now().toEpochMilli() - 30000)
						{
							notifier.notify(reminder.text);
							reminder.lastNotified = Instant.now().toEpochMilli();
						}

						activeList.add(reminder);
						continue;
					}
				}

				if (reminder.posted > 0)
				{
					if (Instant.now().toEpochMilli() >= reminder.posted
							+ reminder.getDurationMillis() + reminder.getCooldownMillis())
					{
						continue;
					}

					reminder.active = Instant.now().toEpochMilli() < reminder.posted
							+ reminder.getDurationMillis();

					if (reminder.active)
					{
						activeList.add(reminder);
					}
					else
					{
						inactiveReminders.add(reminder);
					}
				}
			}
		}

		chatMessages.clear();

		System.out.println("Get active took " + (Instant.now().toEpochMilli() - start) + "ms");

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

	private boolean checkChatPatterns(String chatPatterns)
	{
		return !chatPatterns.isEmpty();
	}

	private boolean matchesChatPatterns(String chatPatternsStr)
	{
		try {
			String [] chatPatterns = chatPatternsStr.split(",");

			for (String chatPattern: chatPatterns)
			{
				chatPattern = chatPattern.trim();

				for (ChatMessage chatMessage: chatMessages)
				{
					Matcher matcher = Pattern.compile(chatPattern)
							.matcher(chatMessage.getMessage());

					if (matcher.find()) {
						return true;
					}
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

	int getDuration(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Duration();
		else if (reminderId == 2) return config.reminder2Duration();
		else if (reminderId == 3) return config.reminder3Duration();
		else if (reminderId == 4) return config.reminder4Duration();
		else if (reminderId == 5) return config.reminder5Duration();
		else if (reminderId == 6) return config.reminder6Duration();
		else if (reminderId == 7) return config.reminder7Duration();
		else if (reminderId == 8) return config.reminder8Duration();
		else if (reminderId == 9) return config.reminder9Duration();
		else if (reminderId == 10) return config.reminder10Duration();
		else if (reminderId == 11) return config.reminder11Duration();
		else if (reminderId == 12) return config.reminder12Duration();
		else if (reminderId == 13) return config.reminder13Duration();
		else if (reminderId == 14) return config.reminder14Duration();
		else if (reminderId == 15) return config.reminder15Duration();
		else if (reminderId == 16) return config.reminder16Duration();
		else if (reminderId == 17) return config.reminder17Duration();
		else if (reminderId == 18) return config.reminder18Duration();
		else if (reminderId == 19) return config.reminder19Duration();
		else if (reminderId == 20) return config.reminder20Duration();
		else if (reminderId == 21) return config.reminder21Duration();
		else if (reminderId == 22) return config.reminder22Duration();
		else if (reminderId == 23) return config.reminder23Duration();
		else if (reminderId == 24) return config.reminder24Duration();
		else if (reminderId == 25) return config.reminder25Duration();
		else if (reminderId == 26) return config.reminder26Duration();
		else if (reminderId == 27) return config.reminder27Duration();
		else if (reminderId == 28) return config.reminder28Duration();
		else if (reminderId == 29) return config.reminder29Duration();
		else if (reminderId == 30) return config.reminder30Duration();
		else if (reminderId == 31) return config.reminder31Duration();
		else if (reminderId == 32) return config.reminder32Duration();
		else if (reminderId == 33) return config.reminder33Duration();
		else if (reminderId == 34) return config.reminder34Duration();
		else if (reminderId == 35) return config.reminder35Duration();
		else if (reminderId == 36) return config.reminder36Duration();
		else if (reminderId == 37) return config.reminder37Duration();
		else if (reminderId == 38) return config.reminder38Duration();
		else if (reminderId == 39) return config.reminder39Duration();
		else if (reminderId == 40) return config.reminder40Duration();
		else if (reminderId == 41) return config.reminder41Duration();
		else if (reminderId == 42) return config.reminder42Duration();
		else if (reminderId == 43) return config.reminder43Duration();
		else if (reminderId == 44) return config.reminder44Duration();
		else if (reminderId == 45) return config.reminder45Duration();
		else if (reminderId == 46) return config.reminder46Duration();
		else if (reminderId == 47) return config.reminder47Duration();
		else if (reminderId == 48) return config.reminder48Duration();
		else if (reminderId == 49) return config.reminder49Duration();
		else if (reminderId == 50) return config.reminder50Duration();
		else if (reminderId == 51) return config.reminder51Duration();
		else if (reminderId == 52) return config.reminder52Duration();
		else if (reminderId == 53) return config.reminder53Duration();
		else if (reminderId == 54) return config.reminder54Duration();
		else if (reminderId == 55) return config.reminder55Duration();
		else if (reminderId == 56) return config.reminder56Duration();
		else if (reminderId == 57) return config.reminder57Duration();
		else if (reminderId == 58) return config.reminder58Duration();
		else if (reminderId == 59) return config.reminder59Duration();
		else if (reminderId == 60) return config.reminder60Duration();
		else if (reminderId == 61) return config.reminder61Duration();
		else if (reminderId == 62) return config.reminder62Duration();
		else if (reminderId == 63) return config.reminder63Duration();
		else if (reminderId == 64) return config.reminder64Duration();
		else if (reminderId == 65) return config.reminder65Duration();
		else if (reminderId == 66) return config.reminder66Duration();
		else if (reminderId == 67) return config.reminder67Duration();
		else if (reminderId == 68) return config.reminder68Duration();
		else if (reminderId == 69) return config.reminder69Duration();
		else if (reminderId == 70) return config.reminder70Duration();
		else if (reminderId == 71) return config.reminder71Duration();
		else if (reminderId == 72) return config.reminder72Duration();
		else if (reminderId == 73) return config.reminder73Duration();
		else if (reminderId == 74) return config.reminder74Duration();
		else if (reminderId == 75) return config.reminder75Duration();
		else if (reminderId == 76) return config.reminder76Duration();
		else if (reminderId == 77) return config.reminder77Duration();
		else if (reminderId == 78) return config.reminder78Duration();
		else if (reminderId == 79) return config.reminder79Duration();
		else if (reminderId == 80) return config.reminder80Duration();
		else if (reminderId == 81) return config.reminder81Duration();
		else if (reminderId == 82) return config.reminder82Duration();
		else if (reminderId == 83) return config.reminder83Duration();
		else if (reminderId == 84) return config.reminder84Duration();
		else if (reminderId == 85) return config.reminder85Duration();
		else if (reminderId == 86) return config.reminder86Duration();
		else if (reminderId == 87) return config.reminder87Duration();
		else if (reminderId == 88) return config.reminder88Duration();
		else if (reminderId == 89) return config.reminder89Duration();
		else if (reminderId == 90) return config.reminder90Duration();
		else if (reminderId == 91) return config.reminder91Duration();
		else if (reminderId == 92) return config.reminder92Duration();
		else if (reminderId == 93) return config.reminder93Duration();
		else if (reminderId == 94) return config.reminder94Duration();
		else if (reminderId == 95) return config.reminder95Duration();
		else if (reminderId == 96) return config.reminder96Duration();
		else if (reminderId == 97) return config.reminder97Duration();
		else if (reminderId == 98) return config.reminder98Duration();
		else if (reminderId == 99) return config.reminder99Duration();
		else if (reminderId == 100) return config.reminder100Duration();
		else return 0;
	}

	int getCooldown(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Cooldown();
		else if (reminderId == 2) return config.reminder2Cooldown();
		else if (reminderId == 3) return config.reminder3Cooldown();
		else if (reminderId == 4) return config.reminder4Cooldown();
		else if (reminderId == 5) return config.reminder5Cooldown();
		else if (reminderId == 6) return config.reminder6Cooldown();
		else if (reminderId == 7) return config.reminder7Cooldown();
		else if (reminderId == 8) return config.reminder8Cooldown();
		else if (reminderId == 9) return config.reminder9Cooldown();
		else if (reminderId == 10) return config.reminder10Cooldown();
		else if (reminderId == 11) return config.reminder11Cooldown();
		else if (reminderId == 12) return config.reminder12Cooldown();
		else if (reminderId == 13) return config.reminder13Cooldown();
		else if (reminderId == 14) return config.reminder14Cooldown();
		else if (reminderId == 15) return config.reminder15Cooldown();
		else if (reminderId == 16) return config.reminder16Cooldown();
		else if (reminderId == 17) return config.reminder17Cooldown();
		else if (reminderId == 18) return config.reminder18Cooldown();
		else if (reminderId == 19) return config.reminder19Cooldown();
		else if (reminderId == 20) return config.reminder20Cooldown();
		else if (reminderId == 21) return config.reminder21Cooldown();
		else if (reminderId == 22) return config.reminder22Cooldown();
		else if (reminderId == 23) return config.reminder23Cooldown();
		else if (reminderId == 24) return config.reminder24Cooldown();
		else if (reminderId == 25) return config.reminder25Cooldown();
		else if (reminderId == 26) return config.reminder26Cooldown();
		else if (reminderId == 27) return config.reminder27Cooldown();
		else if (reminderId == 28) return config.reminder28Cooldown();
		else if (reminderId == 29) return config.reminder29Cooldown();
		else if (reminderId == 30) return config.reminder30Cooldown();
		else if (reminderId == 31) return config.reminder31Cooldown();
		else if (reminderId == 32) return config.reminder32Cooldown();
		else if (reminderId == 33) return config.reminder33Cooldown();
		else if (reminderId == 34) return config.reminder34Cooldown();
		else if (reminderId == 35) return config.reminder35Cooldown();
		else if (reminderId == 36) return config.reminder36Cooldown();
		else if (reminderId == 37) return config.reminder37Cooldown();
		else if (reminderId == 38) return config.reminder38Cooldown();
		else if (reminderId == 39) return config.reminder39Cooldown();
		else if (reminderId == 40) return config.reminder40Cooldown();
		else if (reminderId == 41) return config.reminder41Cooldown();
		else if (reminderId == 42) return config.reminder42Cooldown();
		else if (reminderId == 43) return config.reminder43Cooldown();
		else if (reminderId == 44) return config.reminder44Cooldown();
		else if (reminderId == 45) return config.reminder45Cooldown();
		else if (reminderId == 46) return config.reminder46Cooldown();
		else if (reminderId == 47) return config.reminder47Cooldown();
		else if (reminderId == 48) return config.reminder48Cooldown();
		else if (reminderId == 49) return config.reminder49Cooldown();
		else if (reminderId == 50) return config.reminder50Cooldown();
		else if (reminderId == 51) return config.reminder51Cooldown();
		else if (reminderId == 52) return config.reminder52Cooldown();
		else if (reminderId == 53) return config.reminder53Cooldown();
		else if (reminderId == 54) return config.reminder54Cooldown();
		else if (reminderId == 55) return config.reminder55Cooldown();
		else if (reminderId == 56) return config.reminder56Cooldown();
		else if (reminderId == 57) return config.reminder57Cooldown();
		else if (reminderId == 58) return config.reminder58Cooldown();
		else if (reminderId == 59) return config.reminder59Cooldown();
		else if (reminderId == 60) return config.reminder60Cooldown();
		else if (reminderId == 61) return config.reminder61Cooldown();
		else if (reminderId == 62) return config.reminder62Cooldown();
		else if (reminderId == 63) return config.reminder63Cooldown();
		else if (reminderId == 64) return config.reminder64Cooldown();
		else if (reminderId == 65) return config.reminder65Cooldown();
		else if (reminderId == 66) return config.reminder66Cooldown();
		else if (reminderId == 67) return config.reminder67Cooldown();
		else if (reminderId == 68) return config.reminder68Cooldown();
		else if (reminderId == 69) return config.reminder69Cooldown();
		else if (reminderId == 70) return config.reminder70Cooldown();
		else if (reminderId == 71) return config.reminder71Cooldown();
		else if (reminderId == 72) return config.reminder72Cooldown();
		else if (reminderId == 73) return config.reminder73Cooldown();
		else if (reminderId == 74) return config.reminder74Cooldown();
		else if (reminderId == 75) return config.reminder75Cooldown();
		else if (reminderId == 76) return config.reminder76Cooldown();
		else if (reminderId == 77) return config.reminder77Cooldown();
		else if (reminderId == 78) return config.reminder78Cooldown();
		else if (reminderId == 79) return config.reminder79Cooldown();
		else if (reminderId == 80) return config.reminder80Cooldown();
		else if (reminderId == 81) return config.reminder81Cooldown();
		else if (reminderId == 82) return config.reminder82Cooldown();
		else if (reminderId == 83) return config.reminder83Cooldown();
		else if (reminderId == 84) return config.reminder84Cooldown();
		else if (reminderId == 85) return config.reminder85Cooldown();
		else if (reminderId == 86) return config.reminder86Cooldown();
		else if (reminderId == 87) return config.reminder87Cooldown();
		else if (reminderId == 88) return config.reminder88Cooldown();
		else if (reminderId == 89) return config.reminder89Cooldown();
		else if (reminderId == 90) return config.reminder90Cooldown();
		else if (reminderId == 91) return config.reminder91Cooldown();
		else if (reminderId == 92) return config.reminder92Cooldown();
		else if (reminderId == 93) return config.reminder93Cooldown();
		else if (reminderId == 94) return config.reminder94Cooldown();
		else if (reminderId == 95) return config.reminder95Cooldown();
		else if (reminderId == 96) return config.reminder96Cooldown();
		else if (reminderId == 97) return config.reminder97Cooldown();
		else if (reminderId == 98) return config.reminder98Cooldown();
		else if (reminderId == 99) return config.reminder99Cooldown();
		else if (reminderId == 100) return config.reminder100Cooldown();
		else return 0;
	}

	TimeUnit getTimeUnit(int reminderId)
	{
		if (reminderId == 1) return config.reminder1TimeUnit();
		else if (reminderId == 2) return config.reminder2TimeUnit();
		else if (reminderId == 3) return config.reminder3TimeUnit();
		else if (reminderId == 4) return config.reminder4TimeUnit();
		else if (reminderId == 5) return config.reminder5TimeUnit();
		else if (reminderId == 6) return config.reminder6TimeUnit();
		else if (reminderId == 7) return config.reminder7TimeUnit();
		else if (reminderId == 8) return config.reminder8TimeUnit();
		else if (reminderId == 9) return config.reminder9TimeUnit();
		else if (reminderId == 10) return config.reminder10TimeUnit();
		else if (reminderId == 11) return config.reminder11TimeUnit();
		else if (reminderId == 12) return config.reminder12TimeUnit();
		else if (reminderId == 13) return config.reminder13TimeUnit();
		else if (reminderId == 14) return config.reminder14TimeUnit();
		else if (reminderId == 15) return config.reminder15TimeUnit();
		else if (reminderId == 16) return config.reminder16TimeUnit();
		else if (reminderId == 17) return config.reminder17TimeUnit();
		else if (reminderId == 18) return config.reminder18TimeUnit();
		else if (reminderId == 19) return config.reminder19TimeUnit();
		else if (reminderId == 20) return config.reminder20TimeUnit();
		else if (reminderId == 21) return config.reminder21TimeUnit();
		else if (reminderId == 22) return config.reminder22TimeUnit();
		else if (reminderId == 23) return config.reminder23TimeUnit();
		else if (reminderId == 24) return config.reminder24TimeUnit();
		else if (reminderId == 25) return config.reminder25TimeUnit();
		else if (reminderId == 26) return config.reminder26TimeUnit();
		else if (reminderId == 27) return config.reminder27TimeUnit();
		else if (reminderId == 28) return config.reminder28TimeUnit();
		else if (reminderId == 29) return config.reminder29TimeUnit();
		else if (reminderId == 30) return config.reminder30TimeUnit();
		else if (reminderId == 31) return config.reminder31TimeUnit();
		else if (reminderId == 32) return config.reminder32TimeUnit();
		else if (reminderId == 33) return config.reminder33TimeUnit();
		else if (reminderId == 34) return config.reminder34TimeUnit();
		else if (reminderId == 35) return config.reminder35TimeUnit();
		else if (reminderId == 36) return config.reminder36TimeUnit();
		else if (reminderId == 37) return config.reminder37TimeUnit();
		else if (reminderId == 38) return config.reminder38TimeUnit();
		else if (reminderId == 39) return config.reminder39TimeUnit();
		else if (reminderId == 40) return config.reminder40TimeUnit();
		else if (reminderId == 41) return config.reminder41TimeUnit();
		else if (reminderId == 42) return config.reminder42TimeUnit();
		else if (reminderId == 43) return config.reminder43TimeUnit();
		else if (reminderId == 44) return config.reminder44TimeUnit();
		else if (reminderId == 45) return config.reminder45TimeUnit();
		else if (reminderId == 46) return config.reminder46TimeUnit();
		else if (reminderId == 47) return config.reminder47TimeUnit();
		else if (reminderId == 48) return config.reminder48TimeUnit();
		else if (reminderId == 49) return config.reminder49TimeUnit();
		else if (reminderId == 50) return config.reminder50TimeUnit();
		else if (reminderId == 51) return config.reminder51TimeUnit();
		else if (reminderId == 52) return config.reminder52TimeUnit();
		else if (reminderId == 53) return config.reminder53TimeUnit();
		else if (reminderId == 54) return config.reminder54TimeUnit();
		else if (reminderId == 55) return config.reminder55TimeUnit();
		else if (reminderId == 56) return config.reminder56TimeUnit();
		else if (reminderId == 57) return config.reminder57TimeUnit();
		else if (reminderId == 58) return config.reminder58TimeUnit();
		else if (reminderId == 59) return config.reminder59TimeUnit();
		else if (reminderId == 60) return config.reminder60TimeUnit();
		else if (reminderId == 61) return config.reminder61TimeUnit();
		else if (reminderId == 62) return config.reminder62TimeUnit();
		else if (reminderId == 63) return config.reminder63TimeUnit();
		else if (reminderId == 64) return config.reminder64TimeUnit();
		else if (reminderId == 65) return config.reminder65TimeUnit();
		else if (reminderId == 66) return config.reminder66TimeUnit();
		else if (reminderId == 67) return config.reminder67TimeUnit();
		else if (reminderId == 68) return config.reminder68TimeUnit();
		else if (reminderId == 69) return config.reminder69TimeUnit();
		else if (reminderId == 70) return config.reminder70TimeUnit();
		else if (reminderId == 71) return config.reminder71TimeUnit();
		else if (reminderId == 72) return config.reminder72TimeUnit();
		else if (reminderId == 73) return config.reminder73TimeUnit();
		else if (reminderId == 74) return config.reminder74TimeUnit();
		else if (reminderId == 75) return config.reminder75TimeUnit();
		else if (reminderId == 76) return config.reminder76TimeUnit();
		else if (reminderId == 77) return config.reminder77TimeUnit();
		else if (reminderId == 78) return config.reminder78TimeUnit();
		else if (reminderId == 79) return config.reminder79TimeUnit();
		else if (reminderId == 80) return config.reminder80TimeUnit();
		else if (reminderId == 81) return config.reminder81TimeUnit();
		else if (reminderId == 82) return config.reminder82TimeUnit();
		else if (reminderId == 83) return config.reminder83TimeUnit();
		else if (reminderId == 84) return config.reminder84TimeUnit();
		else if (reminderId == 85) return config.reminder85TimeUnit();
		else if (reminderId == 86) return config.reminder86TimeUnit();
		else if (reminderId == 87) return config.reminder87TimeUnit();
		else if (reminderId == 88) return config.reminder88TimeUnit();
		else if (reminderId == 89) return config.reminder89TimeUnit();
		else if (reminderId == 90) return config.reminder90TimeUnit();
		else if (reminderId == 91) return config.reminder91TimeUnit();
		else if (reminderId == 92) return config.reminder92TimeUnit();
		else if (reminderId == 93) return config.reminder93TimeUnit();
		else if (reminderId == 94) return config.reminder94TimeUnit();
		else if (reminderId == 95) return config.reminder95TimeUnit();
		else if (reminderId == 96) return config.reminder96TimeUnit();
		else if (reminderId == 97) return config.reminder97TimeUnit();
		else if (reminderId == 98) return config.reminder98TimeUnit();
		else if (reminderId == 99) return config.reminder99TimeUnit();
		else if (reminderId == 100) return config.reminder100TimeUnit();
		else return TimeUnit.SECONDS;
	}

	boolean isNotify(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Notify();
		else if (reminderId == 2) return config.reminder2Notify();
		else if (reminderId == 3) return config.reminder3Notify();
		else if (reminderId == 4) return config.reminder4Notify();
		else if (reminderId == 5) return config.reminder5Notify();
		else if (reminderId == 6) return config.reminder6Notify();
		else if (reminderId == 7) return config.reminder7Notify();
		else if (reminderId == 8) return config.reminder8Notify();
		else if (reminderId == 9) return config.reminder9Notify();
		else if (reminderId == 10) return config.reminder10Notify();
		else if (reminderId == 11) return config.reminder11Notify();
		else if (reminderId == 12) return config.reminder12Notify();
		else if (reminderId == 13) return config.reminder13Notify();
		else if (reminderId == 14) return config.reminder14Notify();
		else if (reminderId == 15) return config.reminder15Notify();
		else if (reminderId == 16) return config.reminder16Notify();
		else if (reminderId == 17) return config.reminder17Notify();
		else if (reminderId == 18) return config.reminder18Notify();
		else if (reminderId == 19) return config.reminder19Notify();
		else if (reminderId == 20) return config.reminder20Notify();
		else if (reminderId == 21) return config.reminder21Notify();
		else if (reminderId == 22) return config.reminder22Notify();
		else if (reminderId == 23) return config.reminder23Notify();
		else if (reminderId == 24) return config.reminder24Notify();
		else if (reminderId == 25) return config.reminder25Notify();
		else if (reminderId == 26) return config.reminder26Notify();
		else if (reminderId == 27) return config.reminder27Notify();
		else if (reminderId == 28) return config.reminder28Notify();
		else if (reminderId == 29) return config.reminder29Notify();
		else if (reminderId == 30) return config.reminder30Notify();
		else if (reminderId == 31) return config.reminder31Notify();
		else if (reminderId == 32) return config.reminder32Notify();
		else if (reminderId == 33) return config.reminder33Notify();
		else if (reminderId == 34) return config.reminder34Notify();
		else if (reminderId == 35) return config.reminder35Notify();
		else if (reminderId == 36) return config.reminder36Notify();
		else if (reminderId == 37) return config.reminder37Notify();
		else if (reminderId == 38) return config.reminder38Notify();
		else if (reminderId == 39) return config.reminder39Notify();
		else if (reminderId == 40) return config.reminder40Notify();
		else if (reminderId == 41) return config.reminder41Notify();
		else if (reminderId == 42) return config.reminder42Notify();
		else if (reminderId == 43) return config.reminder43Notify();
		else if (reminderId == 44) return config.reminder44Notify();
		else if (reminderId == 45) return config.reminder45Notify();
		else if (reminderId == 46) return config.reminder46Notify();
		else if (reminderId == 47) return config.reminder47Notify();
		else if (reminderId == 48) return config.reminder48Notify();
		else if (reminderId == 49) return config.reminder49Notify();
		else if (reminderId == 50) return config.reminder50Notify();
		else if (reminderId == 51) return config.reminder51Notify();
		else if (reminderId == 52) return config.reminder52Notify();
		else if (reminderId == 53) return config.reminder53Notify();
		else if (reminderId == 54) return config.reminder54Notify();
		else if (reminderId == 55) return config.reminder55Notify();
		else if (reminderId == 56) return config.reminder56Notify();
		else if (reminderId == 57) return config.reminder57Notify();
		else if (reminderId == 58) return config.reminder58Notify();
		else if (reminderId == 59) return config.reminder59Notify();
		else if (reminderId == 60) return config.reminder60Notify();
		else if (reminderId == 61) return config.reminder61Notify();
		else if (reminderId == 62) return config.reminder62Notify();
		else if (reminderId == 63) return config.reminder63Notify();
		else if (reminderId == 64) return config.reminder64Notify();
		else if (reminderId == 65) return config.reminder65Notify();
		else if (reminderId == 66) return config.reminder66Notify();
		else if (reminderId == 67) return config.reminder67Notify();
		else if (reminderId == 68) return config.reminder68Notify();
		else if (reminderId == 69) return config.reminder69Notify();
		else if (reminderId == 70) return config.reminder70Notify();
		else if (reminderId == 71) return config.reminder71Notify();
		else if (reminderId == 72) return config.reminder72Notify();
		else if (reminderId == 73) return config.reminder73Notify();
		else if (reminderId == 74) return config.reminder74Notify();
		else if (reminderId == 75) return config.reminder75Notify();
		else if (reminderId == 76) return config.reminder76Notify();
		else if (reminderId == 77) return config.reminder77Notify();
		else if (reminderId == 78) return config.reminder78Notify();
		else if (reminderId == 79) return config.reminder79Notify();
		else if (reminderId == 80) return config.reminder80Notify();
		else if (reminderId == 81) return config.reminder81Notify();
		else if (reminderId == 82) return config.reminder82Notify();
		else if (reminderId == 83) return config.reminder83Notify();
		else if (reminderId == 84) return config.reminder84Notify();
		else if (reminderId == 85) return config.reminder85Notify();
		else if (reminderId == 86) return config.reminder86Notify();
		else if (reminderId == 87) return config.reminder87Notify();
		else if (reminderId == 88) return config.reminder88Notify();
		else if (reminderId == 89) return config.reminder89Notify();
		else if (reminderId == 90) return config.reminder90Notify();
		else if (reminderId == 91) return config.reminder91Notify();
		else if (reminderId == 92) return config.reminder92Notify();
		else if (reminderId == 93) return config.reminder93Notify();
		else if (reminderId == 94) return config.reminder94Notify();
		else if (reminderId == 95) return config.reminder95Notify();
		else if (reminderId == 96) return config.reminder96Notify();
		else if (reminderId == 97) return config.reminder97Notify();
		else if (reminderId == 98) return config.reminder98Notify();
		else if (reminderId == 99) return config.reminder99Notify();
		else if (reminderId == 100) return config.reminder100Notify();
		else return false;
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

	String getChatPatterns(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ChatPatterns();
		else if (reminderId == 2) return config.reminder2ChatPatterns();
		else if (reminderId == 3) return config.reminder3ChatPatterns();
		else if (reminderId == 4) return config.reminder4ChatPatterns();
		else if (reminderId == 5) return config.reminder5ChatPatterns();
		else if (reminderId == 6) return config.reminder6ChatPatterns();
		else if (reminderId == 7) return config.reminder7ChatPatterns();
		else if (reminderId == 8) return config.reminder8ChatPatterns();
		else if (reminderId == 9) return config.reminder9ChatPatterns();
		else if (reminderId == 10) return config.reminder10ChatPatterns();
		else if (reminderId == 11) return config.reminder11ChatPatterns();
		else if (reminderId == 12) return config.reminder12ChatPatterns();
		else if (reminderId == 13) return config.reminder13ChatPatterns();
		else if (reminderId == 14) return config.reminder14ChatPatterns();
		else if (reminderId == 15) return config.reminder15ChatPatterns();
		else if (reminderId == 16) return config.reminder16ChatPatterns();
		else if (reminderId == 17) return config.reminder17ChatPatterns();
		else if (reminderId == 18) return config.reminder18ChatPatterns();
		else if (reminderId == 19) return config.reminder19ChatPatterns();
		else if (reminderId == 20) return config.reminder20ChatPatterns();
		else if (reminderId == 21) return config.reminder21ChatPatterns();
		else if (reminderId == 22) return config.reminder22ChatPatterns();
		else if (reminderId == 23) return config.reminder23ChatPatterns();
		else if (reminderId == 24) return config.reminder24ChatPatterns();
		else if (reminderId == 25) return config.reminder25ChatPatterns();
		else if (reminderId == 26) return config.reminder26ChatPatterns();
		else if (reminderId == 27) return config.reminder27ChatPatterns();
		else if (reminderId == 28) return config.reminder28ChatPatterns();
		else if (reminderId == 29) return config.reminder29ChatPatterns();
		else if (reminderId == 30) return config.reminder30ChatPatterns();
		else if (reminderId == 31) return config.reminder31ChatPatterns();
		else if (reminderId == 32) return config.reminder32ChatPatterns();
		else if (reminderId == 33) return config.reminder33ChatPatterns();
		else if (reminderId == 34) return config.reminder34ChatPatterns();
		else if (reminderId == 35) return config.reminder35ChatPatterns();
		else if (reminderId == 36) return config.reminder36ChatPatterns();
		else if (reminderId == 37) return config.reminder37ChatPatterns();
		else if (reminderId == 38) return config.reminder38ChatPatterns();
		else if (reminderId == 39) return config.reminder39ChatPatterns();
		else if (reminderId == 40) return config.reminder40ChatPatterns();
		else if (reminderId == 41) return config.reminder41ChatPatterns();
		else if (reminderId == 42) return config.reminder42ChatPatterns();
		else if (reminderId == 43) return config.reminder43ChatPatterns();
		else if (reminderId == 44) return config.reminder44ChatPatterns();
		else if (reminderId == 45) return config.reminder45ChatPatterns();
		else if (reminderId == 46) return config.reminder46ChatPatterns();
		else if (reminderId == 47) return config.reminder47ChatPatterns();
		else if (reminderId == 48) return config.reminder48ChatPatterns();
		else if (reminderId == 49) return config.reminder49ChatPatterns();
		else if (reminderId == 50) return config.reminder50ChatPatterns();
		else if (reminderId == 51) return config.reminder51ChatPatterns();
		else if (reminderId == 52) return config.reminder52ChatPatterns();
		else if (reminderId == 53) return config.reminder53ChatPatterns();
		else if (reminderId == 54) return config.reminder54ChatPatterns();
		else if (reminderId == 55) return config.reminder55ChatPatterns();
		else if (reminderId == 56) return config.reminder56ChatPatterns();
		else if (reminderId == 57) return config.reminder57ChatPatterns();
		else if (reminderId == 58) return config.reminder58ChatPatterns();
		else if (reminderId == 59) return config.reminder59ChatPatterns();
		else if (reminderId == 60) return config.reminder60ChatPatterns();
		else if (reminderId == 61) return config.reminder61ChatPatterns();
		else if (reminderId == 62) return config.reminder62ChatPatterns();
		else if (reminderId == 63) return config.reminder63ChatPatterns();
		else if (reminderId == 64) return config.reminder64ChatPatterns();
		else if (reminderId == 65) return config.reminder65ChatPatterns();
		else if (reminderId == 66) return config.reminder66ChatPatterns();
		else if (reminderId == 67) return config.reminder67ChatPatterns();
		else if (reminderId == 68) return config.reminder68ChatPatterns();
		else if (reminderId == 69) return config.reminder69ChatPatterns();
		else if (reminderId == 70) return config.reminder70ChatPatterns();
		else if (reminderId == 71) return config.reminder71ChatPatterns();
		else if (reminderId == 72) return config.reminder72ChatPatterns();
		else if (reminderId == 73) return config.reminder73ChatPatterns();
		else if (reminderId == 74) return config.reminder74ChatPatterns();
		else if (reminderId == 75) return config.reminder75ChatPatterns();
		else if (reminderId == 76) return config.reminder76ChatPatterns();
		else if (reminderId == 77) return config.reminder77ChatPatterns();
		else if (reminderId == 78) return config.reminder78ChatPatterns();
		else if (reminderId == 79) return config.reminder79ChatPatterns();
		else if (reminderId == 80) return config.reminder80ChatPatterns();
		else if (reminderId == 81) return config.reminder81ChatPatterns();
		else if (reminderId == 82) return config.reminder82ChatPatterns();
		else if (reminderId == 83) return config.reminder83ChatPatterns();
		else if (reminderId == 84) return config.reminder84ChatPatterns();
		else if (reminderId == 85) return config.reminder85ChatPatterns();
		else if (reminderId == 86) return config.reminder86ChatPatterns();
		else if (reminderId == 87) return config.reminder87ChatPatterns();
		else if (reminderId == 88) return config.reminder88ChatPatterns();
		else if (reminderId == 89) return config.reminder89ChatPatterns();
		else if (reminderId == 90) return config.reminder90ChatPatterns();
		else if (reminderId == 91) return config.reminder91ChatPatterns();
		else if (reminderId == 92) return config.reminder92ChatPatterns();
		else if (reminderId == 93) return config.reminder93ChatPatterns();
		else if (reminderId == 94) return config.reminder94ChatPatterns();
		else if (reminderId == 95) return config.reminder95ChatPatterns();
		else if (reminderId == 96) return config.reminder96ChatPatterns();
		else if (reminderId == 97) return config.reminder97ChatPatterns();
		else if (reminderId == 98) return config.reminder98ChatPatterns();
		else if (reminderId == 99) return config.reminder99ChatPatterns();
		else if (reminderId == 100) return config.reminder100ChatPatterns();
		else return "";
	}

	Location getLocation(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Location();
		else if (reminderId == 2) return config.reminder2Location();
		else if (reminderId == 3) return config.reminder3Location();
		else if (reminderId == 4) return config.reminder4Location();
		else if (reminderId == 5) return config.reminder5Location();
		else if (reminderId == 6) return config.reminder6Location();
		else if (reminderId == 7) return config.reminder7Location();
		else if (reminderId == 8) return config.reminder8Location();
		else if (reminderId == 9) return config.reminder9Location();
		else if (reminderId == 10) return config.reminder10Location();
		else if (reminderId == 11) return config.reminder11Location();
		else if (reminderId == 12) return config.reminder12Location();
		else if (reminderId == 13) return config.reminder13Location();
		else if (reminderId == 14) return config.reminder14Location();
		else if (reminderId == 15) return config.reminder15Location();
		else if (reminderId == 16) return config.reminder16Location();
		else if (reminderId == 17) return config.reminder17Location();
		else if (reminderId == 18) return config.reminder18Location();
		else if (reminderId == 19) return config.reminder19Location();
		else if (reminderId == 20) return config.reminder20Location();
		else if (reminderId == 21) return config.reminder21Location();
		else if (reminderId == 22) return config.reminder22Location();
		else if (reminderId == 23) return config.reminder23Location();
		else if (reminderId == 24) return config.reminder24Location();
		else if (reminderId == 25) return config.reminder25Location();
		else if (reminderId == 26) return config.reminder26Location();
		else if (reminderId == 27) return config.reminder27Location();
		else if (reminderId == 28) return config.reminder28Location();
		else if (reminderId == 29) return config.reminder29Location();
		else if (reminderId == 30) return config.reminder30Location();
		else if (reminderId == 31) return config.reminder31Location();
		else if (reminderId == 32) return config.reminder32Location();
		else if (reminderId == 33) return config.reminder33Location();
		else if (reminderId == 34) return config.reminder34Location();
		else if (reminderId == 35) return config.reminder35Location();
		else if (reminderId == 36) return config.reminder36Location();
		else if (reminderId == 37) return config.reminder37Location();
		else if (reminderId == 38) return config.reminder38Location();
		else if (reminderId == 39) return config.reminder39Location();
		else if (reminderId == 40) return config.reminder40Location();
		else if (reminderId == 41) return config.reminder41Location();
		else if (reminderId == 42) return config.reminder42Location();
		else if (reminderId == 43) return config.reminder43Location();
		else if (reminderId == 44) return config.reminder44Location();
		else if (reminderId == 45) return config.reminder45Location();
		else if (reminderId == 46) return config.reminder46Location();
		else if (reminderId == 47) return config.reminder47Location();
		else if (reminderId == 48) return config.reminder48Location();
		else if (reminderId == 49) return config.reminder49Location();
		else if (reminderId == 50) return config.reminder50Location();
		else if (reminderId == 51) return config.reminder51Location();
		else if (reminderId == 52) return config.reminder52Location();
		else if (reminderId == 53) return config.reminder53Location();
		else if (reminderId == 54) return config.reminder54Location();
		else if (reminderId == 55) return config.reminder55Location();
		else if (reminderId == 56) return config.reminder56Location();
		else if (reminderId == 57) return config.reminder57Location();
		else if (reminderId == 58) return config.reminder58Location();
		else if (reminderId == 59) return config.reminder59Location();
		else if (reminderId == 60) return config.reminder60Location();
		else if (reminderId == 61) return config.reminder61Location();
		else if (reminderId == 62) return config.reminder62Location();
		else if (reminderId == 63) return config.reminder63Location();
		else if (reminderId == 64) return config.reminder64Location();
		else if (reminderId == 65) return config.reminder65Location();
		else if (reminderId == 66) return config.reminder66Location();
		else if (reminderId == 67) return config.reminder67Location();
		else if (reminderId == 68) return config.reminder68Location();
		else if (reminderId == 69) return config.reminder69Location();
		else if (reminderId == 70) return config.reminder70Location();
		else if (reminderId == 71) return config.reminder71Location();
		else if (reminderId == 72) return config.reminder72Location();
		else if (reminderId == 73) return config.reminder73Location();
		else if (reminderId == 74) return config.reminder74Location();
		else if (reminderId == 75) return config.reminder75Location();
		else if (reminderId == 76) return config.reminder76Location();
		else if (reminderId == 77) return config.reminder77Location();
		else if (reminderId == 78) return config.reminder78Location();
		else if (reminderId == 79) return config.reminder79Location();
		else if (reminderId == 80) return config.reminder80Location();
		else if (reminderId == 81) return config.reminder81Location();
		else if (reminderId == 82) return config.reminder82Location();
		else if (reminderId == 83) return config.reminder83Location();
		else if (reminderId == 84) return config.reminder84Location();
		else if (reminderId == 85) return config.reminder85Location();
		else if (reminderId == 86) return config.reminder86Location();
		else if (reminderId == 87) return config.reminder87Location();
		else if (reminderId == 88) return config.reminder88Location();
		else if (reminderId == 89) return config.reminder89Location();
		else if (reminderId == 90) return config.reminder90Location();
		else if (reminderId == 91) return config.reminder91Location();
		else if (reminderId == 92) return config.reminder92Location();
		else if (reminderId == 93) return config.reminder93Location();
		else if (reminderId == 94) return config.reminder94Location();
		else if (reminderId == 95) return config.reminder95Location();
		else if (reminderId == 96) return config.reminder96Location();
		else if (reminderId == 97) return config.reminder97Location();
		else if (reminderId == 98) return config.reminder98Location();
		else if (reminderId == 99) return config.reminder99Location();
		else if (reminderId == 100) return config.reminder100Location();
		else return Location.IN_LIST;
	}

	RSAnchorType getPanelAnchorType(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelAnchorType();
		else if (reminderId == 2) return config.reminder2PanelAnchorType();
		else if (reminderId == 3) return config.reminder3PanelAnchorType();
		else if (reminderId == 4) return config.reminder4PanelAnchorType();
		else if (reminderId == 5) return config.reminder5PanelAnchorType();
		else if (reminderId == 6) return config.reminder6PanelAnchorType();
		else if (reminderId == 7) return config.reminder7PanelAnchorType();
		else if (reminderId == 8) return config.reminder8PanelAnchorType();
		else if (reminderId == 9) return config.reminder9PanelAnchorType();
		else if (reminderId == 10) return config.reminder10PanelAnchorType();
		else if (reminderId == 11) return config.reminder11PanelAnchorType();
		else if (reminderId == 12) return config.reminder12PanelAnchorType();
		else if (reminderId == 13) return config.reminder13PanelAnchorType();
		else if (reminderId == 14) return config.reminder14PanelAnchorType();
		else if (reminderId == 15) return config.reminder15PanelAnchorType();
		else if (reminderId == 16) return config.reminder16PanelAnchorType();
		else if (reminderId == 17) return config.reminder17PanelAnchorType();
		else if (reminderId == 18) return config.reminder18PanelAnchorType();
		else if (reminderId == 19) return config.reminder19PanelAnchorType();
		else if (reminderId == 20) return config.reminder20PanelAnchorType();
		else if (reminderId == 21) return config.reminder21PanelAnchorType();
		else if (reminderId == 22) return config.reminder22PanelAnchorType();
		else if (reminderId == 23) return config.reminder23PanelAnchorType();
		else if (reminderId == 24) return config.reminder24PanelAnchorType();
		else if (reminderId == 25) return config.reminder25PanelAnchorType();
		else if (reminderId == 26) return config.reminder26PanelAnchorType();
		else if (reminderId == 27) return config.reminder27PanelAnchorType();
		else if (reminderId == 28) return config.reminder28PanelAnchorType();
		else if (reminderId == 29) return config.reminder29PanelAnchorType();
		else if (reminderId == 30) return config.reminder30PanelAnchorType();
		else if (reminderId == 31) return config.reminder31PanelAnchorType();
		else if (reminderId == 32) return config.reminder32PanelAnchorType();
		else if (reminderId == 33) return config.reminder33PanelAnchorType();
		else if (reminderId == 34) return config.reminder34PanelAnchorType();
		else if (reminderId == 35) return config.reminder35PanelAnchorType();
		else if (reminderId == 36) return config.reminder36PanelAnchorType();
		else if (reminderId == 37) return config.reminder37PanelAnchorType();
		else if (reminderId == 38) return config.reminder38PanelAnchorType();
		else if (reminderId == 39) return config.reminder39PanelAnchorType();
		else if (reminderId == 40) return config.reminder40PanelAnchorType();
		else if (reminderId == 41) return config.reminder41PanelAnchorType();
		else if (reminderId == 42) return config.reminder42PanelAnchorType();
		else if (reminderId == 43) return config.reminder43PanelAnchorType();
		else if (reminderId == 44) return config.reminder44PanelAnchorType();
		else if (reminderId == 45) return config.reminder45PanelAnchorType();
		else if (reminderId == 46) return config.reminder46PanelAnchorType();
		else if (reminderId == 47) return config.reminder47PanelAnchorType();
		else if (reminderId == 48) return config.reminder48PanelAnchorType();
		else if (reminderId == 49) return config.reminder49PanelAnchorType();
		else if (reminderId == 50) return config.reminder50PanelAnchorType();
		else if (reminderId == 51) return config.reminder51PanelAnchorType();
		else if (reminderId == 52) return config.reminder52PanelAnchorType();
		else if (reminderId == 53) return config.reminder53PanelAnchorType();
		else if (reminderId == 54) return config.reminder54PanelAnchorType();
		else if (reminderId == 55) return config.reminder55PanelAnchorType();
		else if (reminderId == 56) return config.reminder56PanelAnchorType();
		else if (reminderId == 57) return config.reminder57PanelAnchorType();
		else if (reminderId == 58) return config.reminder58PanelAnchorType();
		else if (reminderId == 59) return config.reminder59PanelAnchorType();
		else if (reminderId == 60) return config.reminder60PanelAnchorType();
		else if (reminderId == 61) return config.reminder61PanelAnchorType();
		else if (reminderId == 62) return config.reminder62PanelAnchorType();
		else if (reminderId == 63) return config.reminder63PanelAnchorType();
		else if (reminderId == 64) return config.reminder64PanelAnchorType();
		else if (reminderId == 65) return config.reminder65PanelAnchorType();
		else if (reminderId == 66) return config.reminder66PanelAnchorType();
		else if (reminderId == 67) return config.reminder67PanelAnchorType();
		else if (reminderId == 68) return config.reminder68PanelAnchorType();
		else if (reminderId == 69) return config.reminder69PanelAnchorType();
		else if (reminderId == 70) return config.reminder70PanelAnchorType();
		else if (reminderId == 71) return config.reminder71PanelAnchorType();
		else if (reminderId == 72) return config.reminder72PanelAnchorType();
		else if (reminderId == 73) return config.reminder73PanelAnchorType();
		else if (reminderId == 74) return config.reminder74PanelAnchorType();
		else if (reminderId == 75) return config.reminder75PanelAnchorType();
		else if (reminderId == 76) return config.reminder76PanelAnchorType();
		else if (reminderId == 77) return config.reminder77PanelAnchorType();
		else if (reminderId == 78) return config.reminder78PanelAnchorType();
		else if (reminderId == 79) return config.reminder79PanelAnchorType();
		else if (reminderId == 80) return config.reminder80PanelAnchorType();
		else if (reminderId == 81) return config.reminder81PanelAnchorType();
		else if (reminderId == 82) return config.reminder82PanelAnchorType();
		else if (reminderId == 83) return config.reminder83PanelAnchorType();
		else if (reminderId == 84) return config.reminder84PanelAnchorType();
		else if (reminderId == 85) return config.reminder85PanelAnchorType();
		else if (reminderId == 86) return config.reminder86PanelAnchorType();
		else if (reminderId == 87) return config.reminder87PanelAnchorType();
		else if (reminderId == 88) return config.reminder88PanelAnchorType();
		else if (reminderId == 89) return config.reminder89PanelAnchorType();
		else if (reminderId == 90) return config.reminder90PanelAnchorType();
		else if (reminderId == 91) return config.reminder91PanelAnchorType();
		else if (reminderId == 92) return config.reminder92PanelAnchorType();
		else if (reminderId == 93) return config.reminder93PanelAnchorType();
		else if (reminderId == 94) return config.reminder94PanelAnchorType();
		else if (reminderId == 95) return config.reminder95PanelAnchorType();
		else if (reminderId == 96) return config.reminder96PanelAnchorType();
		else if (reminderId == 97) return config.reminder97PanelAnchorType();
		else if (reminderId == 98) return config.reminder98PanelAnchorType();
		else if (reminderId == 99) return config.reminder99PanelAnchorType();
		else if (reminderId == 100) return config.reminder100PanelAnchorType();
		else return RSAnchorType.TOP_LEFT;
	}

	int getPanelAnchorX(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelAnchorX();
		else if (reminderId == 2) return config.reminder2PanelAnchorX();
		else if (reminderId == 3) return config.reminder3PanelAnchorX();
		else if (reminderId == 4) return config.reminder4PanelAnchorX();
		else if (reminderId == 5) return config.reminder5PanelAnchorX();
		else if (reminderId == 6) return config.reminder6PanelAnchorX();
		else if (reminderId == 7) return config.reminder7PanelAnchorX();
		else if (reminderId == 8) return config.reminder8PanelAnchorX();
		else if (reminderId == 9) return config.reminder9PanelAnchorX();
		else if (reminderId == 10) return config.reminder10PanelAnchorX();
		else if (reminderId == 11) return config.reminder11PanelAnchorX();
		else if (reminderId == 12) return config.reminder12PanelAnchorX();
		else if (reminderId == 13) return config.reminder13PanelAnchorX();
		else if (reminderId == 14) return config.reminder14PanelAnchorX();
		else if (reminderId == 15) return config.reminder15PanelAnchorX();
		else if (reminderId == 16) return config.reminder16PanelAnchorX();
		else if (reminderId == 17) return config.reminder17PanelAnchorX();
		else if (reminderId == 18) return config.reminder18PanelAnchorX();
		else if (reminderId == 19) return config.reminder19PanelAnchorX();
		else if (reminderId == 20) return config.reminder20PanelAnchorX();
		else if (reminderId == 21) return config.reminder21PanelAnchorX();
		else if (reminderId == 22) return config.reminder22PanelAnchorX();
		else if (reminderId == 23) return config.reminder23PanelAnchorX();
		else if (reminderId == 24) return config.reminder24PanelAnchorX();
		else if (reminderId == 25) return config.reminder25PanelAnchorX();
		else if (reminderId == 26) return config.reminder26PanelAnchorX();
		else if (reminderId == 27) return config.reminder27PanelAnchorX();
		else if (reminderId == 28) return config.reminder28PanelAnchorX();
		else if (reminderId == 29) return config.reminder29PanelAnchorX();
		else if (reminderId == 30) return config.reminder30PanelAnchorX();
		else if (reminderId == 31) return config.reminder31PanelAnchorX();
		else if (reminderId == 32) return config.reminder32PanelAnchorX();
		else if (reminderId == 33) return config.reminder33PanelAnchorX();
		else if (reminderId == 34) return config.reminder34PanelAnchorX();
		else if (reminderId == 35) return config.reminder35PanelAnchorX();
		else if (reminderId == 36) return config.reminder36PanelAnchorX();
		else if (reminderId == 37) return config.reminder37PanelAnchorX();
		else if (reminderId == 38) return config.reminder38PanelAnchorX();
		else if (reminderId == 39) return config.reminder39PanelAnchorX();
		else if (reminderId == 40) return config.reminder40PanelAnchorX();
		else if (reminderId == 41) return config.reminder41PanelAnchorX();
		else if (reminderId == 42) return config.reminder42PanelAnchorX();
		else if (reminderId == 43) return config.reminder43PanelAnchorX();
		else if (reminderId == 44) return config.reminder44PanelAnchorX();
		else if (reminderId == 45) return config.reminder45PanelAnchorX();
		else if (reminderId == 46) return config.reminder46PanelAnchorX();
		else if (reminderId == 47) return config.reminder47PanelAnchorX();
		else if (reminderId == 48) return config.reminder48PanelAnchorX();
		else if (reminderId == 49) return config.reminder49PanelAnchorX();
		else if (reminderId == 50) return config.reminder50PanelAnchorX();
		else if (reminderId == 51) return config.reminder51PanelAnchorX();
		else if (reminderId == 52) return config.reminder52PanelAnchorX();
		else if (reminderId == 53) return config.reminder53PanelAnchorX();
		else if (reminderId == 54) return config.reminder54PanelAnchorX();
		else if (reminderId == 55) return config.reminder55PanelAnchorX();
		else if (reminderId == 56) return config.reminder56PanelAnchorX();
		else if (reminderId == 57) return config.reminder57PanelAnchorX();
		else if (reminderId == 58) return config.reminder58PanelAnchorX();
		else if (reminderId == 59) return config.reminder59PanelAnchorX();
		else if (reminderId == 60) return config.reminder60PanelAnchorX();
		else if (reminderId == 61) return config.reminder61PanelAnchorX();
		else if (reminderId == 62) return config.reminder62PanelAnchorX();
		else if (reminderId == 63) return config.reminder63PanelAnchorX();
		else if (reminderId == 64) return config.reminder64PanelAnchorX();
		else if (reminderId == 65) return config.reminder65PanelAnchorX();
		else if (reminderId == 66) return config.reminder66PanelAnchorX();
		else if (reminderId == 67) return config.reminder67PanelAnchorX();
		else if (reminderId == 68) return config.reminder68PanelAnchorX();
		else if (reminderId == 69) return config.reminder69PanelAnchorX();
		else if (reminderId == 70) return config.reminder70PanelAnchorX();
		else if (reminderId == 71) return config.reminder71PanelAnchorX();
		else if (reminderId == 72) return config.reminder72PanelAnchorX();
		else if (reminderId == 73) return config.reminder73PanelAnchorX();
		else if (reminderId == 74) return config.reminder74PanelAnchorX();
		else if (reminderId == 75) return config.reminder75PanelAnchorX();
		else if (reminderId == 76) return config.reminder76PanelAnchorX();
		else if (reminderId == 77) return config.reminder77PanelAnchorX();
		else if (reminderId == 78) return config.reminder78PanelAnchorX();
		else if (reminderId == 79) return config.reminder79PanelAnchorX();
		else if (reminderId == 80) return config.reminder80PanelAnchorX();
		else if (reminderId == 81) return config.reminder81PanelAnchorX();
		else if (reminderId == 82) return config.reminder82PanelAnchorX();
		else if (reminderId == 83) return config.reminder83PanelAnchorX();
		else if (reminderId == 84) return config.reminder84PanelAnchorX();
		else if (reminderId == 85) return config.reminder85PanelAnchorX();
		else if (reminderId == 86) return config.reminder86PanelAnchorX();
		else if (reminderId == 87) return config.reminder87PanelAnchorX();
		else if (reminderId == 88) return config.reminder88PanelAnchorX();
		else if (reminderId == 89) return config.reminder89PanelAnchorX();
		else if (reminderId == 90) return config.reminder90PanelAnchorX();
		else if (reminderId == 91) return config.reminder91PanelAnchorX();
		else if (reminderId == 92) return config.reminder92PanelAnchorX();
		else if (reminderId == 93) return config.reminder93PanelAnchorX();
		else if (reminderId == 94) return config.reminder94PanelAnchorX();
		else if (reminderId == 95) return config.reminder95PanelAnchorX();
		else if (reminderId == 96) return config.reminder96PanelAnchorX();
		else if (reminderId == 97) return config.reminder97PanelAnchorX();
		else if (reminderId == 98) return config.reminder98PanelAnchorX();
		else if (reminderId == 99) return config.reminder99PanelAnchorX();
		else if (reminderId == 100) return config.reminder100PanelAnchorX();
		else return 0;
	}

	int getPanelAnchorY(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelAnchorY();
		else if (reminderId == 2) return config.reminder2PanelAnchorY();
		else if (reminderId == 3) return config.reminder3PanelAnchorY();
		else if (reminderId == 4) return config.reminder4PanelAnchorY();
		else if (reminderId == 5) return config.reminder5PanelAnchorY();
		else if (reminderId == 6) return config.reminder6PanelAnchorY();
		else if (reminderId == 7) return config.reminder7PanelAnchorY();
		else if (reminderId == 8) return config.reminder8PanelAnchorY();
		else if (reminderId == 9) return config.reminder9PanelAnchorY();
		else if (reminderId == 10) return config.reminder10PanelAnchorY();
		else if (reminderId == 11) return config.reminder11PanelAnchorY();
		else if (reminderId == 12) return config.reminder12PanelAnchorY();
		else if (reminderId == 13) return config.reminder13PanelAnchorY();
		else if (reminderId == 14) return config.reminder14PanelAnchorY();
		else if (reminderId == 15) return config.reminder15PanelAnchorY();
		else if (reminderId == 16) return config.reminder16PanelAnchorY();
		else if (reminderId == 17) return config.reminder17PanelAnchorY();
		else if (reminderId == 18) return config.reminder18PanelAnchorY();
		else if (reminderId == 19) return config.reminder19PanelAnchorY();
		else if (reminderId == 20) return config.reminder20PanelAnchorY();
		else if (reminderId == 21) return config.reminder21PanelAnchorY();
		else if (reminderId == 22) return config.reminder22PanelAnchorY();
		else if (reminderId == 23) return config.reminder23PanelAnchorY();
		else if (reminderId == 24) return config.reminder24PanelAnchorY();
		else if (reminderId == 25) return config.reminder25PanelAnchorY();
		else if (reminderId == 26) return config.reminder26PanelAnchorY();
		else if (reminderId == 27) return config.reminder27PanelAnchorY();
		else if (reminderId == 28) return config.reminder28PanelAnchorY();
		else if (reminderId == 29) return config.reminder29PanelAnchorY();
		else if (reminderId == 30) return config.reminder30PanelAnchorY();
		else if (reminderId == 31) return config.reminder31PanelAnchorY();
		else if (reminderId == 32) return config.reminder32PanelAnchorY();
		else if (reminderId == 33) return config.reminder33PanelAnchorY();
		else if (reminderId == 34) return config.reminder34PanelAnchorY();
		else if (reminderId == 35) return config.reminder35PanelAnchorY();
		else if (reminderId == 36) return config.reminder36PanelAnchorY();
		else if (reminderId == 37) return config.reminder37PanelAnchorY();
		else if (reminderId == 38) return config.reminder38PanelAnchorY();
		else if (reminderId == 39) return config.reminder39PanelAnchorY();
		else if (reminderId == 40) return config.reminder40PanelAnchorY();
		else if (reminderId == 41) return config.reminder41PanelAnchorY();
		else if (reminderId == 42) return config.reminder42PanelAnchorY();
		else if (reminderId == 43) return config.reminder43PanelAnchorY();
		else if (reminderId == 44) return config.reminder44PanelAnchorY();
		else if (reminderId == 45) return config.reminder45PanelAnchorY();
		else if (reminderId == 46) return config.reminder46PanelAnchorY();
		else if (reminderId == 47) return config.reminder47PanelAnchorY();
		else if (reminderId == 48) return config.reminder48PanelAnchorY();
		else if (reminderId == 49) return config.reminder49PanelAnchorY();
		else if (reminderId == 50) return config.reminder50PanelAnchorY();
		else if (reminderId == 51) return config.reminder51PanelAnchorY();
		else if (reminderId == 52) return config.reminder52PanelAnchorY();
		else if (reminderId == 53) return config.reminder53PanelAnchorY();
		else if (reminderId == 54) return config.reminder54PanelAnchorY();
		else if (reminderId == 55) return config.reminder55PanelAnchorY();
		else if (reminderId == 56) return config.reminder56PanelAnchorY();
		else if (reminderId == 57) return config.reminder57PanelAnchorY();
		else if (reminderId == 58) return config.reminder58PanelAnchorY();
		else if (reminderId == 59) return config.reminder59PanelAnchorY();
		else if (reminderId == 60) return config.reminder60PanelAnchorY();
		else if (reminderId == 61) return config.reminder61PanelAnchorY();
		else if (reminderId == 62) return config.reminder62PanelAnchorY();
		else if (reminderId == 63) return config.reminder63PanelAnchorY();
		else if (reminderId == 64) return config.reminder64PanelAnchorY();
		else if (reminderId == 65) return config.reminder65PanelAnchorY();
		else if (reminderId == 66) return config.reminder66PanelAnchorY();
		else if (reminderId == 67) return config.reminder67PanelAnchorY();
		else if (reminderId == 68) return config.reminder68PanelAnchorY();
		else if (reminderId == 69) return config.reminder69PanelAnchorY();
		else if (reminderId == 70) return config.reminder70PanelAnchorY();
		else if (reminderId == 71) return config.reminder71PanelAnchorY();
		else if (reminderId == 72) return config.reminder72PanelAnchorY();
		else if (reminderId == 73) return config.reminder73PanelAnchorY();
		else if (reminderId == 74) return config.reminder74PanelAnchorY();
		else if (reminderId == 75) return config.reminder75PanelAnchorY();
		else if (reminderId == 76) return config.reminder76PanelAnchorY();
		else if (reminderId == 77) return config.reminder77PanelAnchorY();
		else if (reminderId == 78) return config.reminder78PanelAnchorY();
		else if (reminderId == 79) return config.reminder79PanelAnchorY();
		else if (reminderId == 80) return config.reminder80PanelAnchorY();
		else if (reminderId == 81) return config.reminder81PanelAnchorY();
		else if (reminderId == 82) return config.reminder82PanelAnchorY();
		else if (reminderId == 83) return config.reminder83PanelAnchorY();
		else if (reminderId == 84) return config.reminder84PanelAnchorY();
		else if (reminderId == 85) return config.reminder85PanelAnchorY();
		else if (reminderId == 86) return config.reminder86PanelAnchorY();
		else if (reminderId == 87) return config.reminder87PanelAnchorY();
		else if (reminderId == 88) return config.reminder88PanelAnchorY();
		else if (reminderId == 89) return config.reminder89PanelAnchorY();
		else if (reminderId == 90) return config.reminder90PanelAnchorY();
		else if (reminderId == 91) return config.reminder91PanelAnchorY();
		else if (reminderId == 92) return config.reminder92PanelAnchorY();
		else if (reminderId == 93) return config.reminder93PanelAnchorY();
		else if (reminderId == 94) return config.reminder94PanelAnchorY();
		else if (reminderId == 95) return config.reminder95PanelAnchorY();
		else if (reminderId == 96) return config.reminder96PanelAnchorY();
		else if (reminderId == 97) return config.reminder97PanelAnchorY();
		else if (reminderId == 98) return config.reminder98PanelAnchorY();
		else if (reminderId == 99) return config.reminder99PanelAnchorY();
		else if (reminderId == 100) return config.reminder100PanelAnchorY();
		else return 0;
	}

	boolean isImage(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Image();
		else if (reminderId == 2) return config.reminder2Image();
		else if (reminderId == 3) return config.reminder3Image();
		else if (reminderId == 4) return config.reminder4Image();
		else if (reminderId == 5) return config.reminder5Image();
		else if (reminderId == 6) return config.reminder6Image();
		else if (reminderId == 7) return config.reminder7Image();
		else if (reminderId == 8) return config.reminder8Image();
		else if (reminderId == 9) return config.reminder9Image();
		else if (reminderId == 10) return config.reminder10Image();
		else if (reminderId == 11) return config.reminder11Image();
		else if (reminderId == 12) return config.reminder12Image();
		else if (reminderId == 13) return config.reminder13Image();
		else if (reminderId == 14) return config.reminder14Image();
		else if (reminderId == 15) return config.reminder15Image();
		else if (reminderId == 16) return config.reminder16Image();
		else if (reminderId == 17) return config.reminder17Image();
		else if (reminderId == 18) return config.reminder18Image();
		else if (reminderId == 19) return config.reminder19Image();
		else if (reminderId == 20) return config.reminder20Image();
		else if (reminderId == 21) return config.reminder21Image();
		else if (reminderId == 22) return config.reminder22Image();
		else if (reminderId == 23) return config.reminder23Image();
		else if (reminderId == 24) return config.reminder24Image();
		else if (reminderId == 25) return config.reminder25Image();
		else if (reminderId == 26) return config.reminder26Image();
		else if (reminderId == 27) return config.reminder27Image();
		else if (reminderId == 28) return config.reminder28Image();
		else if (reminderId == 29) return config.reminder29Image();
		else if (reminderId == 30) return config.reminder30Image();
		else if (reminderId == 31) return config.reminder31Image();
		else if (reminderId == 32) return config.reminder32Image();
		else if (reminderId == 33) return config.reminder33Image();
		else if (reminderId == 34) return config.reminder34Image();
		else if (reminderId == 35) return config.reminder35Image();
		else if (reminderId == 36) return config.reminder36Image();
		else if (reminderId == 37) return config.reminder37Image();
		else if (reminderId == 38) return config.reminder38Image();
		else if (reminderId == 39) return config.reminder39Image();
		else if (reminderId == 40) return config.reminder40Image();
		else if (reminderId == 41) return config.reminder41Image();
		else if (reminderId == 42) return config.reminder42Image();
		else if (reminderId == 43) return config.reminder43Image();
		else if (reminderId == 44) return config.reminder44Image();
		else if (reminderId == 45) return config.reminder45Image();
		else if (reminderId == 46) return config.reminder46Image();
		else if (reminderId == 47) return config.reminder47Image();
		else if (reminderId == 48) return config.reminder48Image();
		else if (reminderId == 49) return config.reminder49Image();
		else if (reminderId == 50) return config.reminder50Image();
		else if (reminderId == 51) return config.reminder51Image();
		else if (reminderId == 52) return config.reminder52Image();
		else if (reminderId == 53) return config.reminder53Image();
		else if (reminderId == 54) return config.reminder54Image();
		else if (reminderId == 55) return config.reminder55Image();
		else if (reminderId == 56) return config.reminder56Image();
		else if (reminderId == 57) return config.reminder57Image();
		else if (reminderId == 58) return config.reminder58Image();
		else if (reminderId == 59) return config.reminder59Image();
		else if (reminderId == 60) return config.reminder60Image();
		else if (reminderId == 61) return config.reminder61Image();
		else if (reminderId == 62) return config.reminder62Image();
		else if (reminderId == 63) return config.reminder63Image();
		else if (reminderId == 64) return config.reminder64Image();
		else if (reminderId == 65) return config.reminder65Image();
		else if (reminderId == 66) return config.reminder66Image();
		else if (reminderId == 67) return config.reminder67Image();
		else if (reminderId == 68) return config.reminder68Image();
		else if (reminderId == 69) return config.reminder69Image();
		else if (reminderId == 70) return config.reminder70Image();
		else if (reminderId == 71) return config.reminder71Image();
		else if (reminderId == 72) return config.reminder72Image();
		else if (reminderId == 73) return config.reminder73Image();
		else if (reminderId == 74) return config.reminder74Image();
		else if (reminderId == 75) return config.reminder75Image();
		else if (reminderId == 76) return config.reminder76Image();
		else if (reminderId == 77) return config.reminder77Image();
		else if (reminderId == 78) return config.reminder78Image();
		else if (reminderId == 79) return config.reminder79Image();
		else if (reminderId == 80) return config.reminder80Image();
		else if (reminderId == 81) return config.reminder81Image();
		else if (reminderId == 82) return config.reminder82Image();
		else if (reminderId == 83) return config.reminder83Image();
		else if (reminderId == 84) return config.reminder84Image();
		else if (reminderId == 85) return config.reminder85Image();
		else if (reminderId == 86) return config.reminder86Image();
		else if (reminderId == 87) return config.reminder87Image();
		else if (reminderId == 88) return config.reminder88Image();
		else if (reminderId == 89) return config.reminder89Image();
		else if (reminderId == 90) return config.reminder90Image();
		else if (reminderId == 91) return config.reminder91Image();
		else if (reminderId == 92) return config.reminder92Image();
		else if (reminderId == 93) return config.reminder93Image();
		else if (reminderId == 94) return config.reminder94Image();
		else if (reminderId == 95) return config.reminder95Image();
		else if (reminderId == 96) return config.reminder96Image();
		else if (reminderId == 97) return config.reminder97Image();
		else if (reminderId == 98) return config.reminder98Image();
		else if (reminderId == 99) return config.reminder99Image();
		else if (reminderId == 100) return config.reminder100Image();
		else return false;
	}

	int getImageId(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ImageId();
		else if (reminderId == 2) return config.reminder2ImageId();
		else if (reminderId == 3) return config.reminder3ImageId();
		else if (reminderId == 4) return config.reminder4ImageId();
		else if (reminderId == 5) return config.reminder5ImageId();
		else if (reminderId == 6) return config.reminder6ImageId();
		else if (reminderId == 7) return config.reminder7ImageId();
		else if (reminderId == 8) return config.reminder8ImageId();
		else if (reminderId == 9) return config.reminder9ImageId();
		else if (reminderId == 10) return config.reminder10ImageId();
		else if (reminderId == 11) return config.reminder11ImageId();
		else if (reminderId == 12) return config.reminder12ImageId();
		else if (reminderId == 13) return config.reminder13ImageId();
		else if (reminderId == 14) return config.reminder14ImageId();
		else if (reminderId == 15) return config.reminder15ImageId();
		else if (reminderId == 16) return config.reminder16ImageId();
		else if (reminderId == 17) return config.reminder17ImageId();
		else if (reminderId == 18) return config.reminder18ImageId();
		else if (reminderId == 19) return config.reminder19ImageId();
		else if (reminderId == 20) return config.reminder20ImageId();
		else if (reminderId == 21) return config.reminder21ImageId();
		else if (reminderId == 22) return config.reminder22ImageId();
		else if (reminderId == 23) return config.reminder23ImageId();
		else if (reminderId == 24) return config.reminder24ImageId();
		else if (reminderId == 25) return config.reminder25ImageId();
		else if (reminderId == 26) return config.reminder26ImageId();
		else if (reminderId == 27) return config.reminder27ImageId();
		else if (reminderId == 28) return config.reminder28ImageId();
		else if (reminderId == 29) return config.reminder29ImageId();
		else if (reminderId == 30) return config.reminder30ImageId();
		else if (reminderId == 31) return config.reminder31ImageId();
		else if (reminderId == 32) return config.reminder32ImageId();
		else if (reminderId == 33) return config.reminder33ImageId();
		else if (reminderId == 34) return config.reminder34ImageId();
		else if (reminderId == 35) return config.reminder35ImageId();
		else if (reminderId == 36) return config.reminder36ImageId();
		else if (reminderId == 37) return config.reminder37ImageId();
		else if (reminderId == 38) return config.reminder38ImageId();
		else if (reminderId == 39) return config.reminder39ImageId();
		else if (reminderId == 40) return config.reminder40ImageId();
		else if (reminderId == 41) return config.reminder41ImageId();
		else if (reminderId == 42) return config.reminder42ImageId();
		else if (reminderId == 43) return config.reminder43ImageId();
		else if (reminderId == 44) return config.reminder44ImageId();
		else if (reminderId == 45) return config.reminder45ImageId();
		else if (reminderId == 46) return config.reminder46ImageId();
		else if (reminderId == 47) return config.reminder47ImageId();
		else if (reminderId == 48) return config.reminder48ImageId();
		else if (reminderId == 49) return config.reminder49ImageId();
		else if (reminderId == 50) return config.reminder50ImageId();
		else if (reminderId == 51) return config.reminder51ImageId();
		else if (reminderId == 52) return config.reminder52ImageId();
		else if (reminderId == 53) return config.reminder53ImageId();
		else if (reminderId == 54) return config.reminder54ImageId();
		else if (reminderId == 55) return config.reminder55ImageId();
		else if (reminderId == 56) return config.reminder56ImageId();
		else if (reminderId == 57) return config.reminder57ImageId();
		else if (reminderId == 58) return config.reminder58ImageId();
		else if (reminderId == 59) return config.reminder59ImageId();
		else if (reminderId == 60) return config.reminder60ImageId();
		else if (reminderId == 61) return config.reminder61ImageId();
		else if (reminderId == 62) return config.reminder62ImageId();
		else if (reminderId == 63) return config.reminder63ImageId();
		else if (reminderId == 64) return config.reminder64ImageId();
		else if (reminderId == 65) return config.reminder65ImageId();
		else if (reminderId == 66) return config.reminder66ImageId();
		else if (reminderId == 67) return config.reminder67ImageId();
		else if (reminderId == 68) return config.reminder68ImageId();
		else if (reminderId == 69) return config.reminder69ImageId();
		else if (reminderId == 70) return config.reminder70ImageId();
		else if (reminderId == 71) return config.reminder71ImageId();
		else if (reminderId == 72) return config.reminder72ImageId();
		else if (reminderId == 73) return config.reminder73ImageId();
		else if (reminderId == 74) return config.reminder74ImageId();
		else if (reminderId == 75) return config.reminder75ImageId();
		else if (reminderId == 76) return config.reminder76ImageId();
		else if (reminderId == 77) return config.reminder77ImageId();
		else if (reminderId == 78) return config.reminder78ImageId();
		else if (reminderId == 79) return config.reminder79ImageId();
		else if (reminderId == 80) return config.reminder80ImageId();
		else if (reminderId == 81) return config.reminder81ImageId();
		else if (reminderId == 82) return config.reminder82ImageId();
		else if (reminderId == 83) return config.reminder83ImageId();
		else if (reminderId == 84) return config.reminder84ImageId();
		else if (reminderId == 85) return config.reminder85ImageId();
		else if (reminderId == 86) return config.reminder86ImageId();
		else if (reminderId == 87) return config.reminder87ImageId();
		else if (reminderId == 88) return config.reminder88ImageId();
		else if (reminderId == 89) return config.reminder89ImageId();
		else if (reminderId == 90) return config.reminder90ImageId();
		else if (reminderId == 91) return config.reminder91ImageId();
		else if (reminderId == 92) return config.reminder92ImageId();
		else if (reminderId == 93) return config.reminder93ImageId();
		else if (reminderId == 94) return config.reminder94ImageId();
		else if (reminderId == 95) return config.reminder95ImageId();
		else if (reminderId == 96) return config.reminder96ImageId();
		else if (reminderId == 97) return config.reminder97ImageId();
		else if (reminderId == 98) return config.reminder98ImageId();
		else if (reminderId == 99) return config.reminder99ImageId();
		else if (reminderId == 100) return config.reminder100ImageId();
		else return 0;
	}

	int getPanelWidth(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelWidth();
		else if (reminderId == 2) return config.reminder2PanelWidth();
		else if (reminderId == 3) return config.reminder3PanelWidth();
		else if (reminderId == 4) return config.reminder4PanelWidth();
		else if (reminderId == 5) return config.reminder5PanelWidth();
		else if (reminderId == 6) return config.reminder6PanelWidth();
		else if (reminderId == 7) return config.reminder7PanelWidth();
		else if (reminderId == 8) return config.reminder8PanelWidth();
		else if (reminderId == 9) return config.reminder9PanelWidth();
		else if (reminderId == 10) return config.reminder10PanelWidth();
		else if (reminderId == 11) return config.reminder11PanelWidth();
		else if (reminderId == 12) return config.reminder12PanelWidth();
		else if (reminderId == 13) return config.reminder13PanelWidth();
		else if (reminderId == 14) return config.reminder14PanelWidth();
		else if (reminderId == 15) return config.reminder15PanelWidth();
		else if (reminderId == 16) return config.reminder16PanelWidth();
		else if (reminderId == 17) return config.reminder17PanelWidth();
		else if (reminderId == 18) return config.reminder18PanelWidth();
		else if (reminderId == 19) return config.reminder19PanelWidth();
		else if (reminderId == 20) return config.reminder20PanelWidth();
		else if (reminderId == 21) return config.reminder21PanelWidth();
		else if (reminderId == 22) return config.reminder22PanelWidth();
		else if (reminderId == 23) return config.reminder23PanelWidth();
		else if (reminderId == 24) return config.reminder24PanelWidth();
		else if (reminderId == 25) return config.reminder25PanelWidth();
		else if (reminderId == 26) return config.reminder26PanelWidth();
		else if (reminderId == 27) return config.reminder27PanelWidth();
		else if (reminderId == 28) return config.reminder28PanelWidth();
		else if (reminderId == 29) return config.reminder29PanelWidth();
		else if (reminderId == 30) return config.reminder30PanelWidth();
		else if (reminderId == 31) return config.reminder31PanelWidth();
		else if (reminderId == 32) return config.reminder32PanelWidth();
		else if (reminderId == 33) return config.reminder33PanelWidth();
		else if (reminderId == 34) return config.reminder34PanelWidth();
		else if (reminderId == 35) return config.reminder35PanelWidth();
		else if (reminderId == 36) return config.reminder36PanelWidth();
		else if (reminderId == 37) return config.reminder37PanelWidth();
		else if (reminderId == 38) return config.reminder38PanelWidth();
		else if (reminderId == 39) return config.reminder39PanelWidth();
		else if (reminderId == 40) return config.reminder40PanelWidth();
		else if (reminderId == 41) return config.reminder41PanelWidth();
		else if (reminderId == 42) return config.reminder42PanelWidth();
		else if (reminderId == 43) return config.reminder43PanelWidth();
		else if (reminderId == 44) return config.reminder44PanelWidth();
		else if (reminderId == 45) return config.reminder45PanelWidth();
		else if (reminderId == 46) return config.reminder46PanelWidth();
		else if (reminderId == 47) return config.reminder47PanelWidth();
		else if (reminderId == 48) return config.reminder48PanelWidth();
		else if (reminderId == 49) return config.reminder49PanelWidth();
		else if (reminderId == 50) return config.reminder50PanelWidth();
		else if (reminderId == 51) return config.reminder51PanelWidth();
		else if (reminderId == 52) return config.reminder52PanelWidth();
		else if (reminderId == 53) return config.reminder53PanelWidth();
		else if (reminderId == 54) return config.reminder54PanelWidth();
		else if (reminderId == 55) return config.reminder55PanelWidth();
		else if (reminderId == 56) return config.reminder56PanelWidth();
		else if (reminderId == 57) return config.reminder57PanelWidth();
		else if (reminderId == 58) return config.reminder58PanelWidth();
		else if (reminderId == 59) return config.reminder59PanelWidth();
		else if (reminderId == 60) return config.reminder60PanelWidth();
		else if (reminderId == 61) return config.reminder61PanelWidth();
		else if (reminderId == 62) return config.reminder62PanelWidth();
		else if (reminderId == 63) return config.reminder63PanelWidth();
		else if (reminderId == 64) return config.reminder64PanelWidth();
		else if (reminderId == 65) return config.reminder65PanelWidth();
		else if (reminderId == 66) return config.reminder66PanelWidth();
		else if (reminderId == 67) return config.reminder67PanelWidth();
		else if (reminderId == 68) return config.reminder68PanelWidth();
		else if (reminderId == 69) return config.reminder69PanelWidth();
		else if (reminderId == 70) return config.reminder70PanelWidth();
		else if (reminderId == 71) return config.reminder71PanelWidth();
		else if (reminderId == 72) return config.reminder72PanelWidth();
		else if (reminderId == 73) return config.reminder73PanelWidth();
		else if (reminderId == 74) return config.reminder74PanelWidth();
		else if (reminderId == 75) return config.reminder75PanelWidth();
		else if (reminderId == 76) return config.reminder76PanelWidth();
		else if (reminderId == 77) return config.reminder77PanelWidth();
		else if (reminderId == 78) return config.reminder78PanelWidth();
		else if (reminderId == 79) return config.reminder79PanelWidth();
		else if (reminderId == 80) return config.reminder80PanelWidth();
		else if (reminderId == 81) return config.reminder81PanelWidth();
		else if (reminderId == 82) return config.reminder82PanelWidth();
		else if (reminderId == 83) return config.reminder83PanelWidth();
		else if (reminderId == 84) return config.reminder84PanelWidth();
		else if (reminderId == 85) return config.reminder85PanelWidth();
		else if (reminderId == 86) return config.reminder86PanelWidth();
		else if (reminderId == 87) return config.reminder87PanelWidth();
		else if (reminderId == 88) return config.reminder88PanelWidth();
		else if (reminderId == 89) return config.reminder89PanelWidth();
		else if (reminderId == 90) return config.reminder90PanelWidth();
		else if (reminderId == 91) return config.reminder91PanelWidth();
		else if (reminderId == 92) return config.reminder92PanelWidth();
		else if (reminderId == 93) return config.reminder93PanelWidth();
		else if (reminderId == 94) return config.reminder94PanelWidth();
		else if (reminderId == 95) return config.reminder95PanelWidth();
		else if (reminderId == 96) return config.reminder96PanelWidth();
		else if (reminderId == 97) return config.reminder97PanelWidth();
		else if (reminderId == 98) return config.reminder98PanelWidth();
		else if (reminderId == 99) return config.reminder99PanelWidth();
		else if (reminderId == 100) return config.reminder100PanelWidth();
		else return 0;
	}

	TextSize getPanelTextSize(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelTextSize();
		else if (reminderId == 2) return config.reminder2PanelTextSize();
		else if (reminderId == 3) return config.reminder3PanelTextSize();
		else if (reminderId == 4) return config.reminder4PanelTextSize();
		else if (reminderId == 5) return config.reminder5PanelTextSize();
		else if (reminderId == 6) return config.reminder6PanelTextSize();
		else if (reminderId == 7) return config.reminder7PanelTextSize();
		else if (reminderId == 8) return config.reminder8PanelTextSize();
		else if (reminderId == 9) return config.reminder9PanelTextSize();
		else if (reminderId == 10) return config.reminder10PanelTextSize();
		else if (reminderId == 11) return config.reminder11PanelTextSize();
		else if (reminderId == 12) return config.reminder12PanelTextSize();
		else if (reminderId == 13) return config.reminder13PanelTextSize();
		else if (reminderId == 14) return config.reminder14PanelTextSize();
		else if (reminderId == 15) return config.reminder15PanelTextSize();
		else if (reminderId == 16) return config.reminder16PanelTextSize();
		else if (reminderId == 17) return config.reminder17PanelTextSize();
		else if (reminderId == 18) return config.reminder18PanelTextSize();
		else if (reminderId == 19) return config.reminder19PanelTextSize();
		else if (reminderId == 20) return config.reminder20PanelTextSize();
		else if (reminderId == 21) return config.reminder21PanelTextSize();
		else if (reminderId == 22) return config.reminder22PanelTextSize();
		else if (reminderId == 23) return config.reminder23PanelTextSize();
		else if (reminderId == 24) return config.reminder24PanelTextSize();
		else if (reminderId == 25) return config.reminder25PanelTextSize();
		else if (reminderId == 26) return config.reminder26PanelTextSize();
		else if (reminderId == 27) return config.reminder27PanelTextSize();
		else if (reminderId == 28) return config.reminder28PanelTextSize();
		else if (reminderId == 29) return config.reminder29PanelTextSize();
		else if (reminderId == 30) return config.reminder30PanelTextSize();
		else if (reminderId == 31) return config.reminder31PanelTextSize();
		else if (reminderId == 32) return config.reminder32PanelTextSize();
		else if (reminderId == 33) return config.reminder33PanelTextSize();
		else if (reminderId == 34) return config.reminder34PanelTextSize();
		else if (reminderId == 35) return config.reminder35PanelTextSize();
		else if (reminderId == 36) return config.reminder36PanelTextSize();
		else if (reminderId == 37) return config.reminder37PanelTextSize();
		else if (reminderId == 38) return config.reminder38PanelTextSize();
		else if (reminderId == 39) return config.reminder39PanelTextSize();
		else if (reminderId == 40) return config.reminder40PanelTextSize();
		else if (reminderId == 41) return config.reminder41PanelTextSize();
		else if (reminderId == 42) return config.reminder42PanelTextSize();
		else if (reminderId == 43) return config.reminder43PanelTextSize();
		else if (reminderId == 44) return config.reminder44PanelTextSize();
		else if (reminderId == 45) return config.reminder45PanelTextSize();
		else if (reminderId == 46) return config.reminder46PanelTextSize();
		else if (reminderId == 47) return config.reminder47PanelTextSize();
		else if (reminderId == 48) return config.reminder48PanelTextSize();
		else if (reminderId == 49) return config.reminder49PanelTextSize();
		else if (reminderId == 50) return config.reminder50PanelTextSize();
		else if (reminderId == 51) return config.reminder51PanelTextSize();
		else if (reminderId == 52) return config.reminder52PanelTextSize();
		else if (reminderId == 53) return config.reminder53PanelTextSize();
		else if (reminderId == 54) return config.reminder54PanelTextSize();
		else if (reminderId == 55) return config.reminder55PanelTextSize();
		else if (reminderId == 56) return config.reminder56PanelTextSize();
		else if (reminderId == 57) return config.reminder57PanelTextSize();
		else if (reminderId == 58) return config.reminder58PanelTextSize();
		else if (reminderId == 59) return config.reminder59PanelTextSize();
		else if (reminderId == 60) return config.reminder60PanelTextSize();
		else if (reminderId == 61) return config.reminder61PanelTextSize();
		else if (reminderId == 62) return config.reminder62PanelTextSize();
		else if (reminderId == 63) return config.reminder63PanelTextSize();
		else if (reminderId == 64) return config.reminder64PanelTextSize();
		else if (reminderId == 65) return config.reminder65PanelTextSize();
		else if (reminderId == 66) return config.reminder66PanelTextSize();
		else if (reminderId == 67) return config.reminder67PanelTextSize();
		else if (reminderId == 68) return config.reminder68PanelTextSize();
		else if (reminderId == 69) return config.reminder69PanelTextSize();
		else if (reminderId == 70) return config.reminder70PanelTextSize();
		else if (reminderId == 71) return config.reminder71PanelTextSize();
		else if (reminderId == 72) return config.reminder72PanelTextSize();
		else if (reminderId == 73) return config.reminder73PanelTextSize();
		else if (reminderId == 74) return config.reminder74PanelTextSize();
		else if (reminderId == 75) return config.reminder75PanelTextSize();
		else if (reminderId == 76) return config.reminder76PanelTextSize();
		else if (reminderId == 77) return config.reminder77PanelTextSize();
		else if (reminderId == 78) return config.reminder78PanelTextSize();
		else if (reminderId == 79) return config.reminder79PanelTextSize();
		else if (reminderId == 80) return config.reminder80PanelTextSize();
		else if (reminderId == 81) return config.reminder81PanelTextSize();
		else if (reminderId == 82) return config.reminder82PanelTextSize();
		else if (reminderId == 83) return config.reminder83PanelTextSize();
		else if (reminderId == 84) return config.reminder84PanelTextSize();
		else if (reminderId == 85) return config.reminder85PanelTextSize();
		else if (reminderId == 86) return config.reminder86PanelTextSize();
		else if (reminderId == 87) return config.reminder87PanelTextSize();
		else if (reminderId == 88) return config.reminder88PanelTextSize();
		else if (reminderId == 89) return config.reminder89PanelTextSize();
		else if (reminderId == 90) return config.reminder90PanelTextSize();
		else if (reminderId == 91) return config.reminder91PanelTextSize();
		else if (reminderId == 92) return config.reminder92PanelTextSize();
		else if (reminderId == 93) return config.reminder93PanelTextSize();
		else if (reminderId == 94) return config.reminder94PanelTextSize();
		else if (reminderId == 95) return config.reminder95PanelTextSize();
		else if (reminderId == 96) return config.reminder96PanelTextSize();
		else if (reminderId == 97) return config.reminder97PanelTextSize();
		else if (reminderId == 98) return config.reminder98PanelTextSize();
		else if (reminderId == 99) return config.reminder99PanelTextSize();
		else if (reminderId == 100) return config.reminder100PanelTextSize();
		else return TextSize.SMALL;
	}

	Color getPanelColor(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelColor();
		else if (reminderId == 2) return config.reminder2PanelColor();
		else if (reminderId == 3) return config.reminder3PanelColor();
		else if (reminderId == 4) return config.reminder4PanelColor();
		else if (reminderId == 5) return config.reminder5PanelColor();
		else if (reminderId == 6) return config.reminder6PanelColor();
		else if (reminderId == 7) return config.reminder7PanelColor();
		else if (reminderId == 8) return config.reminder8PanelColor();
		else if (reminderId == 9) return config.reminder9PanelColor();
		else if (reminderId == 10) return config.reminder10PanelColor();
		else if (reminderId == 11) return config.reminder11PanelColor();
		else if (reminderId == 12) return config.reminder12PanelColor();
		else if (reminderId == 13) return config.reminder13PanelColor();
		else if (reminderId == 14) return config.reminder14PanelColor();
		else if (reminderId == 15) return config.reminder15PanelColor();
		else if (reminderId == 16) return config.reminder16PanelColor();
		else if (reminderId == 17) return config.reminder17PanelColor();
		else if (reminderId == 18) return config.reminder18PanelColor();
		else if (reminderId == 19) return config.reminder19PanelColor();
		else if (reminderId == 20) return config.reminder20PanelColor();
		else if (reminderId == 21) return config.reminder21PanelColor();
		else if (reminderId == 22) return config.reminder22PanelColor();
		else if (reminderId == 23) return config.reminder23PanelColor();
		else if (reminderId == 24) return config.reminder24PanelColor();
		else if (reminderId == 25) return config.reminder25PanelColor();
		else if (reminderId == 26) return config.reminder26PanelColor();
		else if (reminderId == 27) return config.reminder27PanelColor();
		else if (reminderId == 28) return config.reminder28PanelColor();
		else if (reminderId == 29) return config.reminder29PanelColor();
		else if (reminderId == 30) return config.reminder30PanelColor();
		else if (reminderId == 31) return config.reminder31PanelColor();
		else if (reminderId == 32) return config.reminder32PanelColor();
		else if (reminderId == 33) return config.reminder33PanelColor();
		else if (reminderId == 34) return config.reminder34PanelColor();
		else if (reminderId == 35) return config.reminder35PanelColor();
		else if (reminderId == 36) return config.reminder36PanelColor();
		else if (reminderId == 37) return config.reminder37PanelColor();
		else if (reminderId == 38) return config.reminder38PanelColor();
		else if (reminderId == 39) return config.reminder39PanelColor();
		else if (reminderId == 40) return config.reminder40PanelColor();
		else if (reminderId == 41) return config.reminder41PanelColor();
		else if (reminderId == 42) return config.reminder42PanelColor();
		else if (reminderId == 43) return config.reminder43PanelColor();
		else if (reminderId == 44) return config.reminder44PanelColor();
		else if (reminderId == 45) return config.reminder45PanelColor();
		else if (reminderId == 46) return config.reminder46PanelColor();
		else if (reminderId == 47) return config.reminder47PanelColor();
		else if (reminderId == 48) return config.reminder48PanelColor();
		else if (reminderId == 49) return config.reminder49PanelColor();
		else if (reminderId == 50) return config.reminder50PanelColor();
		else if (reminderId == 51) return config.reminder51PanelColor();
		else if (reminderId == 52) return config.reminder52PanelColor();
		else if (reminderId == 53) return config.reminder53PanelColor();
		else if (reminderId == 54) return config.reminder54PanelColor();
		else if (reminderId == 55) return config.reminder55PanelColor();
		else if (reminderId == 56) return config.reminder56PanelColor();
		else if (reminderId == 57) return config.reminder57PanelColor();
		else if (reminderId == 58) return config.reminder58PanelColor();
		else if (reminderId == 59) return config.reminder59PanelColor();
		else if (reminderId == 60) return config.reminder60PanelColor();
		else if (reminderId == 61) return config.reminder61PanelColor();
		else if (reminderId == 62) return config.reminder62PanelColor();
		else if (reminderId == 63) return config.reminder63PanelColor();
		else if (reminderId == 64) return config.reminder64PanelColor();
		else if (reminderId == 65) return config.reminder65PanelColor();
		else if (reminderId == 66) return config.reminder66PanelColor();
		else if (reminderId == 67) return config.reminder67PanelColor();
		else if (reminderId == 68) return config.reminder68PanelColor();
		else if (reminderId == 69) return config.reminder69PanelColor();
		else if (reminderId == 70) return config.reminder70PanelColor();
		else if (reminderId == 71) return config.reminder71PanelColor();
		else if (reminderId == 72) return config.reminder72PanelColor();
		else if (reminderId == 73) return config.reminder73PanelColor();
		else if (reminderId == 74) return config.reminder74PanelColor();
		else if (reminderId == 75) return config.reminder75PanelColor();
		else if (reminderId == 76) return config.reminder76PanelColor();
		else if (reminderId == 77) return config.reminder77PanelColor();
		else if (reminderId == 78) return config.reminder78PanelColor();
		else if (reminderId == 79) return config.reminder79PanelColor();
		else if (reminderId == 80) return config.reminder80PanelColor();
		else if (reminderId == 81) return config.reminder81PanelColor();
		else if (reminderId == 82) return config.reminder82PanelColor();
		else if (reminderId == 83) return config.reminder83PanelColor();
		else if (reminderId == 84) return config.reminder84PanelColor();
		else if (reminderId == 85) return config.reminder85PanelColor();
		else if (reminderId == 86) return config.reminder86PanelColor();
		else if (reminderId == 87) return config.reminder87PanelColor();
		else if (reminderId == 88) return config.reminder88PanelColor();
		else if (reminderId == 89) return config.reminder89PanelColor();
		else if (reminderId == 90) return config.reminder90PanelColor();
		else if (reminderId == 91) return config.reminder91PanelColor();
		else if (reminderId == 92) return config.reminder92PanelColor();
		else if (reminderId == 93) return config.reminder93PanelColor();
		else if (reminderId == 94) return config.reminder94PanelColor();
		else if (reminderId == 95) return config.reminder95PanelColor();
		else if (reminderId == 96) return config.reminder96PanelColor();
		else if (reminderId == 97) return config.reminder97PanelColor();
		else if (reminderId == 98) return config.reminder98PanelColor();
		else if (reminderId == 99) return config.reminder99PanelColor();
		else if (reminderId == 100) return config.reminder100PanelColor();
		else return Color.WHITE;
	}

	boolean isPanelBorder(int reminderId)
	{
		if (reminderId == 1) return config.reminder1PanelBorder();
		else if (reminderId == 2) return config.reminder2PanelBorder();
		else if (reminderId == 3) return config.reminder3PanelBorder();
		else if (reminderId == 4) return config.reminder4PanelBorder();
		else if (reminderId == 5) return config.reminder5PanelBorder();
		else if (reminderId == 6) return config.reminder6PanelBorder();
		else if (reminderId == 7) return config.reminder7PanelBorder();
		else if (reminderId == 8) return config.reminder8PanelBorder();
		else if (reminderId == 9) return config.reminder9PanelBorder();
		else if (reminderId == 10) return config.reminder10PanelBorder();
		else if (reminderId == 11) return config.reminder11PanelBorder();
		else if (reminderId == 12) return config.reminder12PanelBorder();
		else if (reminderId == 13) return config.reminder13PanelBorder();
		else if (reminderId == 14) return config.reminder14PanelBorder();
		else if (reminderId == 15) return config.reminder15PanelBorder();
		else if (reminderId == 16) return config.reminder16PanelBorder();
		else if (reminderId == 17) return config.reminder17PanelBorder();
		else if (reminderId == 18) return config.reminder18PanelBorder();
		else if (reminderId == 19) return config.reminder19PanelBorder();
		else if (reminderId == 20) return config.reminder20PanelBorder();
		else if (reminderId == 21) return config.reminder21PanelBorder();
		else if (reminderId == 22) return config.reminder22PanelBorder();
		else if (reminderId == 23) return config.reminder23PanelBorder();
		else if (reminderId == 24) return config.reminder24PanelBorder();
		else if (reminderId == 25) return config.reminder25PanelBorder();
		else if (reminderId == 26) return config.reminder26PanelBorder();
		else if (reminderId == 27) return config.reminder27PanelBorder();
		else if (reminderId == 28) return config.reminder28PanelBorder();
		else if (reminderId == 29) return config.reminder29PanelBorder();
		else if (reminderId == 30) return config.reminder30PanelBorder();
		else if (reminderId == 31) return config.reminder31PanelBorder();
		else if (reminderId == 32) return config.reminder32PanelBorder();
		else if (reminderId == 33) return config.reminder33PanelBorder();
		else if (reminderId == 34) return config.reminder34PanelBorder();
		else if (reminderId == 35) return config.reminder35PanelBorder();
		else if (reminderId == 36) return config.reminder36PanelBorder();
		else if (reminderId == 37) return config.reminder37PanelBorder();
		else if (reminderId == 38) return config.reminder38PanelBorder();
		else if (reminderId == 39) return config.reminder39PanelBorder();
		else if (reminderId == 40) return config.reminder40PanelBorder();
		else if (reminderId == 41) return config.reminder41PanelBorder();
		else if (reminderId == 42) return config.reminder42PanelBorder();
		else if (reminderId == 43) return config.reminder43PanelBorder();
		else if (reminderId == 44) return config.reminder44PanelBorder();
		else if (reminderId == 45) return config.reminder45PanelBorder();
		else if (reminderId == 46) return config.reminder46PanelBorder();
		else if (reminderId == 47) return config.reminder47PanelBorder();
		else if (reminderId == 48) return config.reminder48PanelBorder();
		else if (reminderId == 49) return config.reminder49PanelBorder();
		else if (reminderId == 50) return config.reminder50PanelBorder();
		else if (reminderId == 51) return config.reminder51PanelBorder();
		else if (reminderId == 52) return config.reminder52PanelBorder();
		else if (reminderId == 53) return config.reminder53PanelBorder();
		else if (reminderId == 54) return config.reminder54PanelBorder();
		else if (reminderId == 55) return config.reminder55PanelBorder();
		else if (reminderId == 56) return config.reminder56PanelBorder();
		else if (reminderId == 57) return config.reminder57PanelBorder();
		else if (reminderId == 58) return config.reminder58PanelBorder();
		else if (reminderId == 59) return config.reminder59PanelBorder();
		else if (reminderId == 60) return config.reminder60PanelBorder();
		else if (reminderId == 61) return config.reminder61PanelBorder();
		else if (reminderId == 62) return config.reminder62PanelBorder();
		else if (reminderId == 63) return config.reminder63PanelBorder();
		else if (reminderId == 64) return config.reminder64PanelBorder();
		else if (reminderId == 65) return config.reminder65PanelBorder();
		else if (reminderId == 66) return config.reminder66PanelBorder();
		else if (reminderId == 67) return config.reminder67PanelBorder();
		else if (reminderId == 68) return config.reminder68PanelBorder();
		else if (reminderId == 69) return config.reminder69PanelBorder();
		else if (reminderId == 70) return config.reminder70PanelBorder();
		else if (reminderId == 71) return config.reminder71PanelBorder();
		else if (reminderId == 72) return config.reminder72PanelBorder();
		else if (reminderId == 73) return config.reminder73PanelBorder();
		else if (reminderId == 74) return config.reminder74PanelBorder();
		else if (reminderId == 75) return config.reminder75PanelBorder();
		else if (reminderId == 76) return config.reminder76PanelBorder();
		else if (reminderId == 77) return config.reminder77PanelBorder();
		else if (reminderId == 78) return config.reminder78PanelBorder();
		else if (reminderId == 79) return config.reminder79PanelBorder();
		else if (reminderId == 80) return config.reminder80PanelBorder();
		else if (reminderId == 81) return config.reminder81PanelBorder();
		else if (reminderId == 82) return config.reminder82PanelBorder();
		else if (reminderId == 83) return config.reminder83PanelBorder();
		else if (reminderId == 84) return config.reminder84PanelBorder();
		else if (reminderId == 85) return config.reminder85PanelBorder();
		else if (reminderId == 86) return config.reminder86PanelBorder();
		else if (reminderId == 87) return config.reminder87PanelBorder();
		else if (reminderId == 88) return config.reminder88PanelBorder();
		else if (reminderId == 89) return config.reminder89PanelBorder();
		else if (reminderId == 90) return config.reminder90PanelBorder();
		else if (reminderId == 91) return config.reminder91PanelBorder();
		else if (reminderId == 92) return config.reminder92PanelBorder();
		else if (reminderId == 93) return config.reminder93PanelBorder();
		else if (reminderId == 94) return config.reminder94PanelBorder();
		else if (reminderId == 95) return config.reminder95PanelBorder();
		else if (reminderId == 96) return config.reminder96PanelBorder();
		else if (reminderId == 97) return config.reminder97PanelBorder();
		else if (reminderId == 98) return config.reminder98PanelBorder();
		else if (reminderId == 99) return config.reminder99PanelBorder();
		else if (reminderId == 100) return config.reminder100PanelBorder();
		else return false;
	}

	boolean isForceShow(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ForceShow();
		else if (reminderId == 2) return config.reminder2ForceShow();
		else if (reminderId == 3) return config.reminder3ForceShow();
		else if (reminderId == 4) return config.reminder4ForceShow();
		else if (reminderId == 5) return config.reminder5ForceShow();
		else if (reminderId == 6) return config.reminder6ForceShow();
		else if (reminderId == 7) return config.reminder7ForceShow();
		else if (reminderId == 8) return config.reminder8ForceShow();
		else if (reminderId == 9) return config.reminder9ForceShow();
		else if (reminderId == 10) return config.reminder10ForceShow();
		else if (reminderId == 11) return config.reminder11ForceShow();
		else if (reminderId == 12) return config.reminder12ForceShow();
		else if (reminderId == 13) return config.reminder13ForceShow();
		else if (reminderId == 14) return config.reminder14ForceShow();
		else if (reminderId == 15) return config.reminder15ForceShow();
		else if (reminderId == 16) return config.reminder16ForceShow();
		else if (reminderId == 17) return config.reminder17ForceShow();
		else if (reminderId == 18) return config.reminder18ForceShow();
		else if (reminderId == 19) return config.reminder19ForceShow();
		else if (reminderId == 20) return config.reminder20ForceShow();
		else if (reminderId == 21) return config.reminder21ForceShow();
		else if (reminderId == 22) return config.reminder22ForceShow();
		else if (reminderId == 23) return config.reminder23ForceShow();
		else if (reminderId == 24) return config.reminder24ForceShow();
		else if (reminderId == 25) return config.reminder25ForceShow();
		else if (reminderId == 26) return config.reminder26ForceShow();
		else if (reminderId == 27) return config.reminder27ForceShow();
		else if (reminderId == 28) return config.reminder28ForceShow();
		else if (reminderId == 29) return config.reminder29ForceShow();
		else if (reminderId == 30) return config.reminder30ForceShow();
		else if (reminderId == 31) return config.reminder31ForceShow();
		else if (reminderId == 32) return config.reminder32ForceShow();
		else if (reminderId == 33) return config.reminder33ForceShow();
		else if (reminderId == 34) return config.reminder34ForceShow();
		else if (reminderId == 35) return config.reminder35ForceShow();
		else if (reminderId == 36) return config.reminder36ForceShow();
		else if (reminderId == 37) return config.reminder37ForceShow();
		else if (reminderId == 38) return config.reminder38ForceShow();
		else if (reminderId == 39) return config.reminder39ForceShow();
		else if (reminderId == 40) return config.reminder40ForceShow();
		else if (reminderId == 41) return config.reminder41ForceShow();
		else if (reminderId == 42) return config.reminder42ForceShow();
		else if (reminderId == 43) return config.reminder43ForceShow();
		else if (reminderId == 44) return config.reminder44ForceShow();
		else if (reminderId == 45) return config.reminder45ForceShow();
		else if (reminderId == 46) return config.reminder46ForceShow();
		else if (reminderId == 47) return config.reminder47ForceShow();
		else if (reminderId == 48) return config.reminder48ForceShow();
		else if (reminderId == 49) return config.reminder49ForceShow();
		else if (reminderId == 50) return config.reminder50ForceShow();
		else if (reminderId == 51) return config.reminder51ForceShow();
		else if (reminderId == 52) return config.reminder52ForceShow();
		else if (reminderId == 53) return config.reminder53ForceShow();
		else if (reminderId == 54) return config.reminder54ForceShow();
		else if (reminderId == 55) return config.reminder55ForceShow();
		else if (reminderId == 56) return config.reminder56ForceShow();
		else if (reminderId == 57) return config.reminder57ForceShow();
		else if (reminderId == 58) return config.reminder58ForceShow();
		else if (reminderId == 59) return config.reminder59ForceShow();
		else if (reminderId == 60) return config.reminder60ForceShow();
		else if (reminderId == 61) return config.reminder61ForceShow();
		else if (reminderId == 62) return config.reminder62ForceShow();
		else if (reminderId == 63) return config.reminder63ForceShow();
		else if (reminderId == 64) return config.reminder64ForceShow();
		else if (reminderId == 65) return config.reminder65ForceShow();
		else if (reminderId == 66) return config.reminder66ForceShow();
		else if (reminderId == 67) return config.reminder67ForceShow();
		else if (reminderId == 68) return config.reminder68ForceShow();
		else if (reminderId == 69) return config.reminder69ForceShow();
		else if (reminderId == 70) return config.reminder70ForceShow();
		else if (reminderId == 71) return config.reminder71ForceShow();
		else if (reminderId == 72) return config.reminder72ForceShow();
		else if (reminderId == 73) return config.reminder73ForceShow();
		else if (reminderId == 74) return config.reminder74ForceShow();
		else if (reminderId == 75) return config.reminder75ForceShow();
		else if (reminderId == 76) return config.reminder76ForceShow();
		else if (reminderId == 77) return config.reminder77ForceShow();
		else if (reminderId == 78) return config.reminder78ForceShow();
		else if (reminderId == 79) return config.reminder79ForceShow();
		else if (reminderId == 80) return config.reminder80ForceShow();
		else if (reminderId == 81) return config.reminder81ForceShow();
		else if (reminderId == 82) return config.reminder82ForceShow();
		else if (reminderId == 83) return config.reminder83ForceShow();
		else if (reminderId == 84) return config.reminder84ForceShow();
		else if (reminderId == 85) return config.reminder85ForceShow();
		else if (reminderId == 86) return config.reminder86ForceShow();
		else if (reminderId == 87) return config.reminder87ForceShow();
		else if (reminderId == 88) return config.reminder88ForceShow();
		else if (reminderId == 89) return config.reminder89ForceShow();
		else if (reminderId == 90) return config.reminder90ForceShow();
		else if (reminderId == 91) return config.reminder91ForceShow();
		else if (reminderId == 92) return config.reminder92ForceShow();
		else if (reminderId == 93) return config.reminder93ForceShow();
		else if (reminderId == 94) return config.reminder94ForceShow();
		else if (reminderId == 95) return config.reminder95ForceShow();
		else if (reminderId == 96) return config.reminder96ForceShow();
		else if (reminderId == 97) return config.reminder97ForceShow();
		else if (reminderId == 98) return config.reminder98ForceShow();
		else if (reminderId == 99) return config.reminder99ForceShow();
		else if (reminderId == 100) return config.reminder100ForceShow();
		else return false;
	}

	int getImageOffset(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ImageOffset();
		else if (reminderId == 2) return config.reminder2ImageOffset();
		else if (reminderId == 3) return config.reminder3ImageOffset();
		else if (reminderId == 4) return config.reminder4ImageOffset();
		else if (reminderId == 5) return config.reminder5ImageOffset();
		else if (reminderId == 6) return config.reminder6ImageOffset();
		else if (reminderId == 7) return config.reminder7ImageOffset();
		else if (reminderId == 8) return config.reminder8ImageOffset();
		else if (reminderId == 9) return config.reminder9ImageOffset();
		else if (reminderId == 10) return config.reminder10ImageOffset();
		else if (reminderId == 11) return config.reminder11ImageOffset();
		else if (reminderId == 12) return config.reminder12ImageOffset();
		else if (reminderId == 13) return config.reminder13ImageOffset();
		else if (reminderId == 14) return config.reminder14ImageOffset();
		else if (reminderId == 15) return config.reminder15ImageOffset();
		else if (reminderId == 16) return config.reminder16ImageOffset();
		else if (reminderId == 17) return config.reminder17ImageOffset();
		else if (reminderId == 18) return config.reminder18ImageOffset();
		else if (reminderId == 19) return config.reminder19ImageOffset();
		else if (reminderId == 20) return config.reminder20ImageOffset();
		else if (reminderId == 21) return config.reminder21ImageOffset();
		else if (reminderId == 22) return config.reminder22ImageOffset();
		else if (reminderId == 23) return config.reminder23ImageOffset();
		else if (reminderId == 24) return config.reminder24ImageOffset();
		else if (reminderId == 25) return config.reminder25ImageOffset();
		else if (reminderId == 26) return config.reminder26ImageOffset();
		else if (reminderId == 27) return config.reminder27ImageOffset();
		else if (reminderId == 28) return config.reminder28ImageOffset();
		else if (reminderId == 29) return config.reminder29ImageOffset();
		else if (reminderId == 30) return config.reminder30ImageOffset();
		else if (reminderId == 31) return config.reminder31ImageOffset();
		else if (reminderId == 32) return config.reminder32ImageOffset();
		else if (reminderId == 33) return config.reminder33ImageOffset();
		else if (reminderId == 34) return config.reminder34ImageOffset();
		else if (reminderId == 35) return config.reminder35ImageOffset();
		else if (reminderId == 36) return config.reminder36ImageOffset();
		else if (reminderId == 37) return config.reminder37ImageOffset();
		else if (reminderId == 38) return config.reminder38ImageOffset();
		else if (reminderId == 39) return config.reminder39ImageOffset();
		else if (reminderId == 40) return config.reminder40ImageOffset();
		else if (reminderId == 41) return config.reminder41ImageOffset();
		else if (reminderId == 42) return config.reminder42ImageOffset();
		else if (reminderId == 43) return config.reminder43ImageOffset();
		else if (reminderId == 44) return config.reminder44ImageOffset();
		else if (reminderId == 45) return config.reminder45ImageOffset();
		else if (reminderId == 46) return config.reminder46ImageOffset();
		else if (reminderId == 47) return config.reminder47ImageOffset();
		else if (reminderId == 48) return config.reminder48ImageOffset();
		else if (reminderId == 49) return config.reminder49ImageOffset();
		else if (reminderId == 50) return config.reminder50ImageOffset();
		else if (reminderId == 51) return config.reminder51ImageOffset();
		else if (reminderId == 52) return config.reminder52ImageOffset();
		else if (reminderId == 53) return config.reminder53ImageOffset();
		else if (reminderId == 54) return config.reminder54ImageOffset();
		else if (reminderId == 55) return config.reminder55ImageOffset();
		else if (reminderId == 56) return config.reminder56ImageOffset();
		else if (reminderId == 57) return config.reminder57ImageOffset();
		else if (reminderId == 58) return config.reminder58ImageOffset();
		else if (reminderId == 59) return config.reminder59ImageOffset();
		else if (reminderId == 60) return config.reminder60ImageOffset();
		else if (reminderId == 61) return config.reminder61ImageOffset();
		else if (reminderId == 62) return config.reminder62ImageOffset();
		else if (reminderId == 63) return config.reminder63ImageOffset();
		else if (reminderId == 64) return config.reminder64ImageOffset();
		else if (reminderId == 65) return config.reminder65ImageOffset();
		else if (reminderId == 66) return config.reminder66ImageOffset();
		else if (reminderId == 67) return config.reminder67ImageOffset();
		else if (reminderId == 68) return config.reminder68ImageOffset();
		else if (reminderId == 69) return config.reminder69ImageOffset();
		else if (reminderId == 70) return config.reminder70ImageOffset();
		else if (reminderId == 71) return config.reminder71ImageOffset();
		else if (reminderId == 72) return config.reminder72ImageOffset();
		else if (reminderId == 73) return config.reminder73ImageOffset();
		else if (reminderId == 74) return config.reminder74ImageOffset();
		else if (reminderId == 75) return config.reminder75ImageOffset();
		else if (reminderId == 76) return config.reminder76ImageOffset();
		else if (reminderId == 77) return config.reminder77ImageOffset();
		else if (reminderId == 78) return config.reminder78ImageOffset();
		else if (reminderId == 79) return config.reminder79ImageOffset();
		else if (reminderId == 80) return config.reminder80ImageOffset();
		else if (reminderId == 81) return config.reminder81ImageOffset();
		else if (reminderId == 82) return config.reminder82ImageOffset();
		else if (reminderId == 83) return config.reminder83ImageOffset();
		else if (reminderId == 84) return config.reminder84ImageOffset();
		else if (reminderId == 85) return config.reminder85ImageOffset();
		else if (reminderId == 86) return config.reminder86ImageOffset();
		else if (reminderId == 87) return config.reminder87ImageOffset();
		else if (reminderId == 88) return config.reminder88ImageOffset();
		else if (reminderId == 89) return config.reminder89ImageOffset();
		else if (reminderId == 90) return config.reminder90ImageOffset();
		else if (reminderId == 91) return config.reminder91ImageOffset();
		else if (reminderId == 92) return config.reminder92ImageOffset();
		else if (reminderId == 93) return config.reminder93ImageOffset();
		else if (reminderId == 94) return config.reminder94ImageOffset();
		else if (reminderId == 95) return config.reminder95ImageOffset();
		else if (reminderId == 96) return config.reminder96ImageOffset();
		else if (reminderId == 97) return config.reminder97ImageOffset();
		else if (reminderId == 98) return config.reminder98ImageOffset();
		else if (reminderId == 99) return config.reminder99ImageOffset();
		else if (reminderId == 100) return config.reminder100ImageOffset();
		else return 0;
	}

	boolean isImageOffsetNegative(int reminderId)
	{
		if (reminderId == 1) return config.reminder1ImageOffsetNegative();
		else if (reminderId == 2) return config.reminder2ImageOffsetNegative();
		else if (reminderId == 3) return config.reminder3ImageOffsetNegative();
		else if (reminderId == 4) return config.reminder4ImageOffsetNegative();
		else if (reminderId == 5) return config.reminder5ImageOffsetNegative();
		else if (reminderId == 6) return config.reminder6ImageOffsetNegative();
		else if (reminderId == 7) return config.reminder7ImageOffsetNegative();
		else if (reminderId == 8) return config.reminder8ImageOffsetNegative();
		else if (reminderId == 9) return config.reminder9ImageOffsetNegative();
		else if (reminderId == 10) return config.reminder10ImageOffsetNegative();
		else if (reminderId == 11) return config.reminder11ImageOffsetNegative();
		else if (reminderId == 12) return config.reminder12ImageOffsetNegative();
		else if (reminderId == 13) return config.reminder13ImageOffsetNegative();
		else if (reminderId == 14) return config.reminder14ImageOffsetNegative();
		else if (reminderId == 15) return config.reminder15ImageOffsetNegative();
		else if (reminderId == 16) return config.reminder16ImageOffsetNegative();
		else if (reminderId == 17) return config.reminder17ImageOffsetNegative();
		else if (reminderId == 18) return config.reminder18ImageOffsetNegative();
		else if (reminderId == 19) return config.reminder19ImageOffsetNegative();
		else if (reminderId == 20) return config.reminder20ImageOffsetNegative();
		else if (reminderId == 21) return config.reminder21ImageOffsetNegative();
		else if (reminderId == 22) return config.reminder22ImageOffsetNegative();
		else if (reminderId == 23) return config.reminder23ImageOffsetNegative();
		else if (reminderId == 24) return config.reminder24ImageOffsetNegative();
		else if (reminderId == 25) return config.reminder25ImageOffsetNegative();
		else if (reminderId == 26) return config.reminder26ImageOffsetNegative();
		else if (reminderId == 27) return config.reminder27ImageOffsetNegative();
		else if (reminderId == 28) return config.reminder28ImageOffsetNegative();
		else if (reminderId == 29) return config.reminder29ImageOffsetNegative();
		else if (reminderId == 30) return config.reminder30ImageOffsetNegative();
		else if (reminderId == 31) return config.reminder31ImageOffsetNegative();
		else if (reminderId == 32) return config.reminder32ImageOffsetNegative();
		else if (reminderId == 33) return config.reminder33ImageOffsetNegative();
		else if (reminderId == 34) return config.reminder34ImageOffsetNegative();
		else if (reminderId == 35) return config.reminder35ImageOffsetNegative();
		else if (reminderId == 36) return config.reminder36ImageOffsetNegative();
		else if (reminderId == 37) return config.reminder37ImageOffsetNegative();
		else if (reminderId == 38) return config.reminder38ImageOffsetNegative();
		else if (reminderId == 39) return config.reminder39ImageOffsetNegative();
		else if (reminderId == 40) return config.reminder40ImageOffsetNegative();
		else if (reminderId == 41) return config.reminder41ImageOffsetNegative();
		else if (reminderId == 42) return config.reminder42ImageOffsetNegative();
		else if (reminderId == 43) return config.reminder43ImageOffsetNegative();
		else if (reminderId == 44) return config.reminder44ImageOffsetNegative();
		else if (reminderId == 45) return config.reminder45ImageOffsetNegative();
		else if (reminderId == 46) return config.reminder46ImageOffsetNegative();
		else if (reminderId == 47) return config.reminder47ImageOffsetNegative();
		else if (reminderId == 48) return config.reminder48ImageOffsetNegative();
		else if (reminderId == 49) return config.reminder49ImageOffsetNegative();
		else if (reminderId == 50) return config.reminder50ImageOffsetNegative();
		else if (reminderId == 51) return config.reminder51ImageOffsetNegative();
		else if (reminderId == 52) return config.reminder52ImageOffsetNegative();
		else if (reminderId == 53) return config.reminder53ImageOffsetNegative();
		else if (reminderId == 54) return config.reminder54ImageOffsetNegative();
		else if (reminderId == 55) return config.reminder55ImageOffsetNegative();
		else if (reminderId == 56) return config.reminder56ImageOffsetNegative();
		else if (reminderId == 57) return config.reminder57ImageOffsetNegative();
		else if (reminderId == 58) return config.reminder58ImageOffsetNegative();
		else if (reminderId == 59) return config.reminder59ImageOffsetNegative();
		else if (reminderId == 60) return config.reminder60ImageOffsetNegative();
		else if (reminderId == 61) return config.reminder61ImageOffsetNegative();
		else if (reminderId == 62) return config.reminder62ImageOffsetNegative();
		else if (reminderId == 63) return config.reminder63ImageOffsetNegative();
		else if (reminderId == 64) return config.reminder64ImageOffsetNegative();
		else if (reminderId == 65) return config.reminder65ImageOffsetNegative();
		else if (reminderId == 66) return config.reminder66ImageOffsetNegative();
		else if (reminderId == 67) return config.reminder67ImageOffsetNegative();
		else if (reminderId == 68) return config.reminder68ImageOffsetNegative();
		else if (reminderId == 69) return config.reminder69ImageOffsetNegative();
		else if (reminderId == 70) return config.reminder70ImageOffsetNegative();
		else if (reminderId == 71) return config.reminder71ImageOffsetNegative();
		else if (reminderId == 72) return config.reminder72ImageOffsetNegative();
		else if (reminderId == 73) return config.reminder73ImageOffsetNegative();
		else if (reminderId == 74) return config.reminder74ImageOffsetNegative();
		else if (reminderId == 75) return config.reminder75ImageOffsetNegative();
		else if (reminderId == 76) return config.reminder76ImageOffsetNegative();
		else if (reminderId == 77) return config.reminder77ImageOffsetNegative();
		else if (reminderId == 78) return config.reminder78ImageOffsetNegative();
		else if (reminderId == 79) return config.reminder79ImageOffsetNegative();
		else if (reminderId == 80) return config.reminder80ImageOffsetNegative();
		else if (reminderId == 81) return config.reminder81ImageOffsetNegative();
		else if (reminderId == 82) return config.reminder82ImageOffsetNegative();
		else if (reminderId == 83) return config.reminder83ImageOffsetNegative();
		else if (reminderId == 84) return config.reminder84ImageOffsetNegative();
		else if (reminderId == 85) return config.reminder85ImageOffsetNegative();
		else if (reminderId == 86) return config.reminder86ImageOffsetNegative();
		else if (reminderId == 87) return config.reminder87ImageOffsetNegative();
		else if (reminderId == 88) return config.reminder88ImageOffsetNegative();
		else if (reminderId == 89) return config.reminder89ImageOffsetNegative();
		else if (reminderId == 90) return config.reminder90ImageOffsetNegative();
		else if (reminderId == 91) return config.reminder91ImageOffsetNegative();
		else if (reminderId == 92) return config.reminder92ImageOffsetNegative();
		else if (reminderId == 93) return config.reminder93ImageOffsetNegative();
		else if (reminderId == 94) return config.reminder94ImageOffsetNegative();
		else if (reminderId == 95) return config.reminder95ImageOffsetNegative();
		else if (reminderId == 96) return config.reminder96ImageOffsetNegative();
		else if (reminderId == 97) return config.reminder97ImageOffsetNegative();
		else if (reminderId == 98) return config.reminder98ImageOffsetNegative();
		else if (reminderId == 99) return config.reminder99ImageOffsetNegative();
		else if (reminderId == 100) return config.reminder100ImageOffsetNegative();
		else return false;
	}
}