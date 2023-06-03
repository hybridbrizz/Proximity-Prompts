package com.ericversteeg;

import com.google.gson.Gson;
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
import java.util.*;
import java.util.List;

@PluginDescriptor(
	name = "Reminders",
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

	List<Integer> activeReminders = new LinkedList<>();

	ZoneOffset zoneOffset = ZoneId.systemDefault()
			.getRules()
			.getOffset(
					LocalDate.now()
							.atStartOfDay()
			);

	LocalDateTime lastDateTime = null;

	int regionId = 0;
	int lastRegionId = 0;

	List<NPC> npcs = new ArrayList<>();

	List<ItemComposition> inventoryItems = new ArrayList<>();

	WorldPoint worldPos = new WorldPoint(0, 0, 0);
	LocalPoint tempLocalPoint = new LocalPoint(0, 0);

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
		activeReminders = getActiveReminders();

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

	private List<Integer> getActiveReminders()
	{
		long start = Instant.now().toEpochMilli();

		List<Integer> activeList = new LinkedList<>();

		for (int i = 1; i <= 100; i++)
		{
			if (isEnable(i))
			{
				if (checkRadius(i) && !isWithinRadiusOfLocation(i))
				{
					continue;
				}

				if (checkRegion(i) && !isInRegion(i))
				{
					continue;
				}

				if (checkNpcIds(i) && !matchesNpcIds(i))
				{
					continue;
				}

				if (checkItemIds(i) && !matchesItemIds(i))
				{
					continue;
				}

				activeList.add(i);
			}
		}

		System.out.println("Active list took " + (Instant.now().toEpochMilli() - start) + "ms");

		return activeList;
	}

	private boolean checkRadius(int noteId)
	{
		return getLocationX(noteId) > 0 || getLocationY(noteId) > 0;
	}

	private boolean isWithinRadiusOfLocation(int noteId)
	{
		int x = getLocationX(noteId);
		int y = getLocationY(noteId);

		double distance = Math.sqrt(
				Math.pow(x - worldPos.getX(), 2) +
				Math.pow(y - worldPos.getY(), 2)
		);

		return distance <= getRadius(noteId);
	}

	private boolean checkRegion(int noteId)
	{
		return getRegionId(noteId) > 0;
	}

	private boolean isInRegion(int noteId)
	{
		return getRegionId(noteId) == regionId;
	}

	private boolean checkNpcIds(int noteId)
	{
		return !getNpcIds(noteId).isEmpty();
	}

	private boolean matchesNpcIds(int noteId)
	{
		try {
			String [] npcIds = getNpcIds(noteId).split(",");

			boolean matchesAll = true;
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

				if (!matches)
				{
					matchesAll = false;
					break;
				}
			}

			return matchesAll;
		}
		catch (Exception exception)
		{
			return false;
		}
	}

	private boolean checkItemIds(int noteId)
	{
		return !getItemIds(noteId).isEmpty();
	}

	private boolean matchesItemIds(int noteId)
	{
		try {
			String [] itemIds = getItemIds(noteId).split(",");

			boolean matchesAll = true;
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

				if (!matches)
				{
					matchesAll = false;
					break;
				}
			}

			return matchesAll;
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

	String getTime(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Time();
		else if (reminderId == 2) return config.reminder2Time();
		else if (reminderId == 3) return config.reminder3Time();
		else if (reminderId == 4) return config.reminder4Time();
		else if (reminderId == 5) return config.reminder5Time();
		else if (reminderId == 6) return config.reminder6Time();
		else if (reminderId == 7) return config.reminder7Time();
		else if (reminderId == 8) return config.reminder8Time();
		else if (reminderId == 9) return config.reminder9Time();
		else if (reminderId == 10) return config.reminder10Time();
		else if (reminderId == 11) return config.reminder11Time();
		else if (reminderId == 12) return config.reminder12Time();
		else if (reminderId == 13) return config.reminder13Time();
		else if (reminderId == 14) return config.reminder14Time();
		else if (reminderId == 15) return config.reminder15Time();
		else if (reminderId == 16) return config.reminder16Time();
		else if (reminderId == 17) return config.reminder17Time();
		else if (reminderId == 18) return config.reminder18Time();
		else if (reminderId == 19) return config.reminder19Time();
		else if (reminderId == 20) return config.reminder20Time();
		else if (reminderId == 21) return config.reminder21Time();
		else if (reminderId == 22) return config.reminder22Time();
		else if (reminderId == 23) return config.reminder23Time();
		else if (reminderId == 24) return config.reminder24Time();
		else if (reminderId == 25) return config.reminder25Time();
		else if (reminderId == 26) return config.reminder26Time();
		else if (reminderId == 27) return config.reminder27Time();
		else if (reminderId == 28) return config.reminder28Time();
		else if (reminderId == 29) return config.reminder29Time();
		else if (reminderId == 30) return config.reminder30Time();
		else if (reminderId == 31) return config.reminder31Time();
		else if (reminderId == 32) return config.reminder32Time();
		else if (reminderId == 33) return config.reminder33Time();
		else if (reminderId == 34) return config.reminder34Time();
		else if (reminderId == 35) return config.reminder35Time();
		else if (reminderId == 36) return config.reminder36Time();
		else if (reminderId == 37) return config.reminder37Time();
		else if (reminderId == 38) return config.reminder38Time();
		else if (reminderId == 39) return config.reminder39Time();
		else if (reminderId == 40) return config.reminder40Time();
		else if (reminderId == 41) return config.reminder41Time();
		else if (reminderId == 42) return config.reminder42Time();
		else if (reminderId == 43) return config.reminder43Time();
		else if (reminderId == 44) return config.reminder44Time();
		else if (reminderId == 45) return config.reminder45Time();
		else if (reminderId == 46) return config.reminder46Time();
		else if (reminderId == 47) return config.reminder47Time();
		else if (reminderId == 48) return config.reminder48Time();
		else if (reminderId == 49) return config.reminder49Time();
		else if (reminderId == 50) return config.reminder50Time();
		else if (reminderId == 51) return config.reminder51Time();
		else if (reminderId == 52) return config.reminder52Time();
		else if (reminderId == 53) return config.reminder53Time();
		else if (reminderId == 54) return config.reminder54Time();
		else if (reminderId == 55) return config.reminder55Time();
		else if (reminderId == 56) return config.reminder56Time();
		else if (reminderId == 57) return config.reminder57Time();
		else if (reminderId == 58) return config.reminder58Time();
		else if (reminderId == 59) return config.reminder59Time();
		else if (reminderId == 60) return config.reminder60Time();
		else if (reminderId == 61) return config.reminder61Time();
		else if (reminderId == 62) return config.reminder62Time();
		else if (reminderId == 63) return config.reminder63Time();
		else if (reminderId == 64) return config.reminder64Time();
		else if (reminderId == 65) return config.reminder65Time();
		else if (reminderId == 66) return config.reminder66Time();
		else if (reminderId == 67) return config.reminder67Time();
		else if (reminderId == 68) return config.reminder68Time();
		else if (reminderId == 69) return config.reminder69Time();
		else if (reminderId == 70) return config.reminder70Time();
		else if (reminderId == 71) return config.reminder71Time();
		else if (reminderId == 72) return config.reminder72Time();
		else if (reminderId == 73) return config.reminder73Time();
		else if (reminderId == 74) return config.reminder74Time();
		else if (reminderId == 75) return config.reminder75Time();
		else if (reminderId == 76) return config.reminder76Time();
		else if (reminderId == 77) return config.reminder77Time();
		else if (reminderId == 78) return config.reminder78Time();
		else if (reminderId == 79) return config.reminder79Time();
		else if (reminderId == 80) return config.reminder80Time();
		else if (reminderId == 81) return config.reminder81Time();
		else if (reminderId == 82) return config.reminder82Time();
		else if (reminderId == 83) return config.reminder83Time();
		else if (reminderId == 84) return config.reminder84Time();
		else if (reminderId == 85) return config.reminder85Time();
		else if (reminderId == 86) return config.reminder86Time();
		else if (reminderId == 87) return config.reminder87Time();
		else if (reminderId == 88) return config.reminder88Time();
		else if (reminderId == 89) return config.reminder89Time();
		else if (reminderId == 90) return config.reminder90Time();
		else if (reminderId == 91) return config.reminder91Time();
		else if (reminderId == 92) return config.reminder92Time();
		else if (reminderId == 93) return config.reminder93Time();
		else if (reminderId == 94) return config.reminder94Time();
		else if (reminderId == 95) return config.reminder95Time();
		else if (reminderId == 96) return config.reminder96Time();
		else if (reminderId == 97) return config.reminder97Time();
		else if (reminderId == 98) return config.reminder98Time();
		else if (reminderId == 99) return config.reminder99Time();
		else if (reminderId == 100) return config.reminder100Time();
		else return "";
	}

	boolean isMonday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Monday();
		else if (reminderId == 2) return config.reminder2Monday();
		else if (reminderId == 3) return config.reminder3Monday();
		else if (reminderId == 4) return config.reminder4Monday();
		else if (reminderId == 5) return config.reminder5Monday();
		else if (reminderId == 6) return config.reminder6Monday();
		else if (reminderId == 7) return config.reminder7Monday();
		else if (reminderId == 8) return config.reminder8Monday();
		else if (reminderId == 9) return config.reminder9Monday();
		else if (reminderId == 10) return config.reminder10Monday();
		else if (reminderId == 11) return config.reminder11Monday();
		else if (reminderId == 12) return config.reminder12Monday();
		else if (reminderId == 13) return config.reminder13Monday();
		else if (reminderId == 14) return config.reminder14Monday();
		else if (reminderId == 15) return config.reminder15Monday();
		else if (reminderId == 16) return config.reminder16Monday();
		else if (reminderId == 17) return config.reminder17Monday();
		else if (reminderId == 18) return config.reminder18Monday();
		else if (reminderId == 19) return config.reminder19Monday();
		else if (reminderId == 20) return config.reminder20Monday();
		else if (reminderId == 21) return config.reminder21Monday();
		else if (reminderId == 22) return config.reminder22Monday();
		else if (reminderId == 23) return config.reminder23Monday();
		else if (reminderId == 24) return config.reminder24Monday();
		else if (reminderId == 25) return config.reminder25Monday();
		else if (reminderId == 26) return config.reminder26Monday();
		else if (reminderId == 27) return config.reminder27Monday();
		else if (reminderId == 28) return config.reminder28Monday();
		else if (reminderId == 29) return config.reminder29Monday();
		else if (reminderId == 30) return config.reminder30Monday();
		else if (reminderId == 31) return config.reminder31Monday();
		else if (reminderId == 32) return config.reminder32Monday();
		else if (reminderId == 33) return config.reminder33Monday();
		else if (reminderId == 34) return config.reminder34Monday();
		else if (reminderId == 35) return config.reminder35Monday();
		else if (reminderId == 36) return config.reminder36Monday();
		else if (reminderId == 37) return config.reminder37Monday();
		else if (reminderId == 38) return config.reminder38Monday();
		else if (reminderId == 39) return config.reminder39Monday();
		else if (reminderId == 40) return config.reminder40Monday();
		else if (reminderId == 41) return config.reminder41Monday();
		else if (reminderId == 42) return config.reminder42Monday();
		else if (reminderId == 43) return config.reminder43Monday();
		else if (reminderId == 44) return config.reminder44Monday();
		else if (reminderId == 45) return config.reminder45Monday();
		else if (reminderId == 46) return config.reminder46Monday();
		else if (reminderId == 47) return config.reminder47Monday();
		else if (reminderId == 48) return config.reminder48Monday();
		else if (reminderId == 49) return config.reminder49Monday();
		else if (reminderId == 50) return config.reminder50Monday();
		else if (reminderId == 51) return config.reminder51Monday();
		else if (reminderId == 52) return config.reminder52Monday();
		else if (reminderId == 53) return config.reminder53Monday();
		else if (reminderId == 54) return config.reminder54Monday();
		else if (reminderId == 55) return config.reminder55Monday();
		else if (reminderId == 56) return config.reminder56Monday();
		else if (reminderId == 57) return config.reminder57Monday();
		else if (reminderId == 58) return config.reminder58Monday();
		else if (reminderId == 59) return config.reminder59Monday();
		else if (reminderId == 60) return config.reminder60Monday();
		else if (reminderId == 61) return config.reminder61Monday();
		else if (reminderId == 62) return config.reminder62Monday();
		else if (reminderId == 63) return config.reminder63Monday();
		else if (reminderId == 64) return config.reminder64Monday();
		else if (reminderId == 65) return config.reminder65Monday();
		else if (reminderId == 66) return config.reminder66Monday();
		else if (reminderId == 67) return config.reminder67Monday();
		else if (reminderId == 68) return config.reminder68Monday();
		else if (reminderId == 69) return config.reminder69Monday();
		else if (reminderId == 70) return config.reminder70Monday();
		else if (reminderId == 71) return config.reminder71Monday();
		else if (reminderId == 72) return config.reminder72Monday();
		else if (reminderId == 73) return config.reminder73Monday();
		else if (reminderId == 74) return config.reminder74Monday();
		else if (reminderId == 75) return config.reminder75Monday();
		else if (reminderId == 76) return config.reminder76Monday();
		else if (reminderId == 77) return config.reminder77Monday();
		else if (reminderId == 78) return config.reminder78Monday();
		else if (reminderId == 79) return config.reminder79Monday();
		else if (reminderId == 80) return config.reminder80Monday();
		else if (reminderId == 81) return config.reminder81Monday();
		else if (reminderId == 82) return config.reminder82Monday();
		else if (reminderId == 83) return config.reminder83Monday();
		else if (reminderId == 84) return config.reminder84Monday();
		else if (reminderId == 85) return config.reminder85Monday();
		else if (reminderId == 86) return config.reminder86Monday();
		else if (reminderId == 87) return config.reminder87Monday();
		else if (reminderId == 88) return config.reminder88Monday();
		else if (reminderId == 89) return config.reminder89Monday();
		else if (reminderId == 90) return config.reminder90Monday();
		else if (reminderId == 91) return config.reminder91Monday();
		else if (reminderId == 92) return config.reminder92Monday();
		else if (reminderId == 93) return config.reminder93Monday();
		else if (reminderId == 94) return config.reminder94Monday();
		else if (reminderId == 95) return config.reminder95Monday();
		else if (reminderId == 96) return config.reminder96Monday();
		else if (reminderId == 97) return config.reminder97Monday();
		else if (reminderId == 98) return config.reminder98Monday();
		else if (reminderId == 99) return config.reminder99Monday();
		else if (reminderId == 100) return config.reminder100Monday();
		else return false;
	}

	boolean isTuesday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Tuesday();
		else if (reminderId == 2) return config.reminder2Tuesday();
		else if (reminderId == 3) return config.reminder3Tuesday();
		else if (reminderId == 4) return config.reminder4Tuesday();
		else if (reminderId == 5) return config.reminder5Tuesday();
		else if (reminderId == 6) return config.reminder6Tuesday();
		else if (reminderId == 7) return config.reminder7Tuesday();
		else if (reminderId == 8) return config.reminder8Tuesday();
		else if (reminderId == 9) return config.reminder9Tuesday();
		else if (reminderId == 10) return config.reminder10Tuesday();
		else if (reminderId == 11) return config.reminder11Tuesday();
		else if (reminderId == 12) return config.reminder12Tuesday();
		else if (reminderId == 13) return config.reminder13Tuesday();
		else if (reminderId == 14) return config.reminder14Tuesday();
		else if (reminderId == 15) return config.reminder15Tuesday();
		else if (reminderId == 16) return config.reminder16Tuesday();
		else if (reminderId == 17) return config.reminder17Tuesday();
		else if (reminderId == 18) return config.reminder18Tuesday();
		else if (reminderId == 19) return config.reminder19Tuesday();
		else if (reminderId == 20) return config.reminder20Tuesday();
		else if (reminderId == 21) return config.reminder21Tuesday();
		else if (reminderId == 22) return config.reminder22Tuesday();
		else if (reminderId == 23) return config.reminder23Tuesday();
		else if (reminderId == 24) return config.reminder24Tuesday();
		else if (reminderId == 25) return config.reminder25Tuesday();
		else if (reminderId == 26) return config.reminder26Tuesday();
		else if (reminderId == 27) return config.reminder27Tuesday();
		else if (reminderId == 28) return config.reminder28Tuesday();
		else if (reminderId == 29) return config.reminder29Tuesday();
		else if (reminderId == 30) return config.reminder30Tuesday();
		else if (reminderId == 31) return config.reminder31Tuesday();
		else if (reminderId == 32) return config.reminder32Tuesday();
		else if (reminderId == 33) return config.reminder33Tuesday();
		else if (reminderId == 34) return config.reminder34Tuesday();
		else if (reminderId == 35) return config.reminder35Tuesday();
		else if (reminderId == 36) return config.reminder36Tuesday();
		else if (reminderId == 37) return config.reminder37Tuesday();
		else if (reminderId == 38) return config.reminder38Tuesday();
		else if (reminderId == 39) return config.reminder39Tuesday();
		else if (reminderId == 40) return config.reminder40Tuesday();
		else if (reminderId == 41) return config.reminder41Tuesday();
		else if (reminderId == 42) return config.reminder42Tuesday();
		else if (reminderId == 43) return config.reminder43Tuesday();
		else if (reminderId == 44) return config.reminder44Tuesday();
		else if (reminderId == 45) return config.reminder45Tuesday();
		else if (reminderId == 46) return config.reminder46Tuesday();
		else if (reminderId == 47) return config.reminder47Tuesday();
		else if (reminderId == 48) return config.reminder48Tuesday();
		else if (reminderId == 49) return config.reminder49Tuesday();
		else if (reminderId == 50) return config.reminder50Tuesday();
		else if (reminderId == 51) return config.reminder51Tuesday();
		else if (reminderId == 52) return config.reminder52Tuesday();
		else if (reminderId == 53) return config.reminder53Tuesday();
		else if (reminderId == 54) return config.reminder54Tuesday();
		else if (reminderId == 55) return config.reminder55Tuesday();
		else if (reminderId == 56) return config.reminder56Tuesday();
		else if (reminderId == 57) return config.reminder57Tuesday();
		else if (reminderId == 58) return config.reminder58Tuesday();
		else if (reminderId == 59) return config.reminder59Tuesday();
		else if (reminderId == 60) return config.reminder60Tuesday();
		else if (reminderId == 61) return config.reminder61Tuesday();
		else if (reminderId == 62) return config.reminder62Tuesday();
		else if (reminderId == 63) return config.reminder63Tuesday();
		else if (reminderId == 64) return config.reminder64Tuesday();
		else if (reminderId == 65) return config.reminder65Tuesday();
		else if (reminderId == 66) return config.reminder66Tuesday();
		else if (reminderId == 67) return config.reminder67Tuesday();
		else if (reminderId == 68) return config.reminder68Tuesday();
		else if (reminderId == 69) return config.reminder69Tuesday();
		else if (reminderId == 70) return config.reminder70Tuesday();
		else if (reminderId == 71) return config.reminder71Tuesday();
		else if (reminderId == 72) return config.reminder72Tuesday();
		else if (reminderId == 73) return config.reminder73Tuesday();
		else if (reminderId == 74) return config.reminder74Tuesday();
		else if (reminderId == 75) return config.reminder75Tuesday();
		else if (reminderId == 76) return config.reminder76Tuesday();
		else if (reminderId == 77) return config.reminder77Tuesday();
		else if (reminderId == 78) return config.reminder78Tuesday();
		else if (reminderId == 79) return config.reminder79Tuesday();
		else if (reminderId == 80) return config.reminder80Tuesday();
		else if (reminderId == 81) return config.reminder81Tuesday();
		else if (reminderId == 82) return config.reminder82Tuesday();
		else if (reminderId == 83) return config.reminder83Tuesday();
		else if (reminderId == 84) return config.reminder84Tuesday();
		else if (reminderId == 85) return config.reminder85Tuesday();
		else if (reminderId == 86) return config.reminder86Tuesday();
		else if (reminderId == 87) return config.reminder87Tuesday();
		else if (reminderId == 88) return config.reminder88Tuesday();
		else if (reminderId == 89) return config.reminder89Tuesday();
		else if (reminderId == 90) return config.reminder90Tuesday();
		else if (reminderId == 91) return config.reminder91Tuesday();
		else if (reminderId == 92) return config.reminder92Tuesday();
		else if (reminderId == 93) return config.reminder93Tuesday();
		else if (reminderId == 94) return config.reminder94Tuesday();
		else if (reminderId == 95) return config.reminder95Tuesday();
		else if (reminderId == 96) return config.reminder96Tuesday();
		else if (reminderId == 97) return config.reminder97Tuesday();
		else if (reminderId == 98) return config.reminder98Tuesday();
		else if (reminderId == 99) return config.reminder99Tuesday();
		else if (reminderId == 100) return config.reminder100Tuesday();
		else return false;
	}

	boolean isWednesday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Wednesday();
		else if (reminderId == 2) return config.reminder2Wednesday();
		else if (reminderId == 3) return config.reminder3Wednesday();
		else if (reminderId == 4) return config.reminder4Wednesday();
		else if (reminderId == 5) return config.reminder5Wednesday();
		else if (reminderId == 6) return config.reminder6Wednesday();
		else if (reminderId == 7) return config.reminder7Wednesday();
		else if (reminderId == 8) return config.reminder8Wednesday();
		else if (reminderId == 9) return config.reminder9Wednesday();
		else if (reminderId == 10) return config.reminder10Wednesday();
		else if (reminderId == 11) return config.reminder11Wednesday();
		else if (reminderId == 12) return config.reminder12Wednesday();
		else if (reminderId == 13) return config.reminder13Wednesday();
		else if (reminderId == 14) return config.reminder14Wednesday();
		else if (reminderId == 15) return config.reminder15Wednesday();
		else if (reminderId == 16) return config.reminder16Wednesday();
		else if (reminderId == 17) return config.reminder17Wednesday();
		else if (reminderId == 18) return config.reminder18Wednesday();
		else if (reminderId == 19) return config.reminder19Wednesday();
		else if (reminderId == 20) return config.reminder20Wednesday();
		else if (reminderId == 21) return config.reminder21Wednesday();
		else if (reminderId == 22) return config.reminder22Wednesday();
		else if (reminderId == 23) return config.reminder23Wednesday();
		else if (reminderId == 24) return config.reminder24Wednesday();
		else if (reminderId == 25) return config.reminder25Wednesday();
		else if (reminderId == 26) return config.reminder26Wednesday();
		else if (reminderId == 27) return config.reminder27Wednesday();
		else if (reminderId == 28) return config.reminder28Wednesday();
		else if (reminderId == 29) return config.reminder29Wednesday();
		else if (reminderId == 30) return config.reminder30Wednesday();
		else if (reminderId == 31) return config.reminder31Wednesday();
		else if (reminderId == 32) return config.reminder32Wednesday();
		else if (reminderId == 33) return config.reminder33Wednesday();
		else if (reminderId == 34) return config.reminder34Wednesday();
		else if (reminderId == 35) return config.reminder35Wednesday();
		else if (reminderId == 36) return config.reminder36Wednesday();
		else if (reminderId == 37) return config.reminder37Wednesday();
		else if (reminderId == 38) return config.reminder38Wednesday();
		else if (reminderId == 39) return config.reminder39Wednesday();
		else if (reminderId == 40) return config.reminder40Wednesday();
		else if (reminderId == 41) return config.reminder41Wednesday();
		else if (reminderId == 42) return config.reminder42Wednesday();
		else if (reminderId == 43) return config.reminder43Wednesday();
		else if (reminderId == 44) return config.reminder44Wednesday();
		else if (reminderId == 45) return config.reminder45Wednesday();
		else if (reminderId == 46) return config.reminder46Wednesday();
		else if (reminderId == 47) return config.reminder47Wednesday();
		else if (reminderId == 48) return config.reminder48Wednesday();
		else if (reminderId == 49) return config.reminder49Wednesday();
		else if (reminderId == 50) return config.reminder50Wednesday();
		else if (reminderId == 51) return config.reminder51Wednesday();
		else if (reminderId == 52) return config.reminder52Wednesday();
		else if (reminderId == 53) return config.reminder53Wednesday();
		else if (reminderId == 54) return config.reminder54Wednesday();
		else if (reminderId == 55) return config.reminder55Wednesday();
		else if (reminderId == 56) return config.reminder56Wednesday();
		else if (reminderId == 57) return config.reminder57Wednesday();
		else if (reminderId == 58) return config.reminder58Wednesday();
		else if (reminderId == 59) return config.reminder59Wednesday();
		else if (reminderId == 60) return config.reminder60Wednesday();
		else if (reminderId == 61) return config.reminder61Wednesday();
		else if (reminderId == 62) return config.reminder62Wednesday();
		else if (reminderId == 63) return config.reminder63Wednesday();
		else if (reminderId == 64) return config.reminder64Wednesday();
		else if (reminderId == 65) return config.reminder65Wednesday();
		else if (reminderId == 66) return config.reminder66Wednesday();
		else if (reminderId == 67) return config.reminder67Wednesday();
		else if (reminderId == 68) return config.reminder68Wednesday();
		else if (reminderId == 69) return config.reminder69Wednesday();
		else if (reminderId == 70) return config.reminder70Wednesday();
		else if (reminderId == 71) return config.reminder71Wednesday();
		else if (reminderId == 72) return config.reminder72Wednesday();
		else if (reminderId == 73) return config.reminder73Wednesday();
		else if (reminderId == 74) return config.reminder74Wednesday();
		else if (reminderId == 75) return config.reminder75Wednesday();
		else if (reminderId == 76) return config.reminder76Wednesday();
		else if (reminderId == 77) return config.reminder77Wednesday();
		else if (reminderId == 78) return config.reminder78Wednesday();
		else if (reminderId == 79) return config.reminder79Wednesday();
		else if (reminderId == 80) return config.reminder80Wednesday();
		else if (reminderId == 81) return config.reminder81Wednesday();
		else if (reminderId == 82) return config.reminder82Wednesday();
		else if (reminderId == 83) return config.reminder83Wednesday();
		else if (reminderId == 84) return config.reminder84Wednesday();
		else if (reminderId == 85) return config.reminder85Wednesday();
		else if (reminderId == 86) return config.reminder86Wednesday();
		else if (reminderId == 87) return config.reminder87Wednesday();
		else if (reminderId == 88) return config.reminder88Wednesday();
		else if (reminderId == 89) return config.reminder89Wednesday();
		else if (reminderId == 90) return config.reminder90Wednesday();
		else if (reminderId == 91) return config.reminder91Wednesday();
		else if (reminderId == 92) return config.reminder92Wednesday();
		else if (reminderId == 93) return config.reminder93Wednesday();
		else if (reminderId == 94) return config.reminder94Wednesday();
		else if (reminderId == 95) return config.reminder95Wednesday();
		else if (reminderId == 96) return config.reminder96Wednesday();
		else if (reminderId == 97) return config.reminder97Wednesday();
		else if (reminderId == 98) return config.reminder98Wednesday();
		else if (reminderId == 99) return config.reminder99Wednesday();
		else if (reminderId == 100) return config.reminder100Wednesday();
		else return false;
	}

	boolean isThursday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Thursday();
		else if (reminderId == 2) return config.reminder2Thursday();
		else if (reminderId == 3) return config.reminder3Thursday();
		else if (reminderId == 4) return config.reminder4Thursday();
		else if (reminderId == 5) return config.reminder5Thursday();
		else if (reminderId == 6) return config.reminder6Thursday();
		else if (reminderId == 7) return config.reminder7Thursday();
		else if (reminderId == 8) return config.reminder8Thursday();
		else if (reminderId == 9) return config.reminder9Thursday();
		else if (reminderId == 10) return config.reminder10Thursday();
		else if (reminderId == 11) return config.reminder11Thursday();
		else if (reminderId == 12) return config.reminder12Thursday();
		else if (reminderId == 13) return config.reminder13Thursday();
		else if (reminderId == 14) return config.reminder14Thursday();
		else if (reminderId == 15) return config.reminder15Thursday();
		else if (reminderId == 16) return config.reminder16Thursday();
		else if (reminderId == 17) return config.reminder17Thursday();
		else if (reminderId == 18) return config.reminder18Thursday();
		else if (reminderId == 19) return config.reminder19Thursday();
		else if (reminderId == 20) return config.reminder20Thursday();
		else if (reminderId == 21) return config.reminder21Thursday();
		else if (reminderId == 22) return config.reminder22Thursday();
		else if (reminderId == 23) return config.reminder23Thursday();
		else if (reminderId == 24) return config.reminder24Thursday();
		else if (reminderId == 25) return config.reminder25Thursday();
		else if (reminderId == 26) return config.reminder26Thursday();
		else if (reminderId == 27) return config.reminder27Thursday();
		else if (reminderId == 28) return config.reminder28Thursday();
		else if (reminderId == 29) return config.reminder29Thursday();
		else if (reminderId == 30) return config.reminder30Thursday();
		else if (reminderId == 31) return config.reminder31Thursday();
		else if (reminderId == 32) return config.reminder32Thursday();
		else if (reminderId == 33) return config.reminder33Thursday();
		else if (reminderId == 34) return config.reminder34Thursday();
		else if (reminderId == 35) return config.reminder35Thursday();
		else if (reminderId == 36) return config.reminder36Thursday();
		else if (reminderId == 37) return config.reminder37Thursday();
		else if (reminderId == 38) return config.reminder38Thursday();
		else if (reminderId == 39) return config.reminder39Thursday();
		else if (reminderId == 40) return config.reminder40Thursday();
		else if (reminderId == 41) return config.reminder41Thursday();
		else if (reminderId == 42) return config.reminder42Thursday();
		else if (reminderId == 43) return config.reminder43Thursday();
		else if (reminderId == 44) return config.reminder44Thursday();
		else if (reminderId == 45) return config.reminder45Thursday();
		else if (reminderId == 46) return config.reminder46Thursday();
		else if (reminderId == 47) return config.reminder47Thursday();
		else if (reminderId == 48) return config.reminder48Thursday();
		else if (reminderId == 49) return config.reminder49Thursday();
		else if (reminderId == 50) return config.reminder50Thursday();
		else if (reminderId == 51) return config.reminder51Thursday();
		else if (reminderId == 52) return config.reminder52Thursday();
		else if (reminderId == 53) return config.reminder53Thursday();
		else if (reminderId == 54) return config.reminder54Thursday();
		else if (reminderId == 55) return config.reminder55Thursday();
		else if (reminderId == 56) return config.reminder56Thursday();
		else if (reminderId == 57) return config.reminder57Thursday();
		else if (reminderId == 58) return config.reminder58Thursday();
		else if (reminderId == 59) return config.reminder59Thursday();
		else if (reminderId == 60) return config.reminder60Thursday();
		else if (reminderId == 61) return config.reminder61Thursday();
		else if (reminderId == 62) return config.reminder62Thursday();
		else if (reminderId == 63) return config.reminder63Thursday();
		else if (reminderId == 64) return config.reminder64Thursday();
		else if (reminderId == 65) return config.reminder65Thursday();
		else if (reminderId == 66) return config.reminder66Thursday();
		else if (reminderId == 67) return config.reminder67Thursday();
		else if (reminderId == 68) return config.reminder68Thursday();
		else if (reminderId == 69) return config.reminder69Thursday();
		else if (reminderId == 70) return config.reminder70Thursday();
		else if (reminderId == 71) return config.reminder71Thursday();
		else if (reminderId == 72) return config.reminder72Thursday();
		else if (reminderId == 73) return config.reminder73Thursday();
		else if (reminderId == 74) return config.reminder74Thursday();
		else if (reminderId == 75) return config.reminder75Thursday();
		else if (reminderId == 76) return config.reminder76Thursday();
		else if (reminderId == 77) return config.reminder77Thursday();
		else if (reminderId == 78) return config.reminder78Thursday();
		else if (reminderId == 79) return config.reminder79Thursday();
		else if (reminderId == 80) return config.reminder80Thursday();
		else if (reminderId == 81) return config.reminder81Thursday();
		else if (reminderId == 82) return config.reminder82Thursday();
		else if (reminderId == 83) return config.reminder83Thursday();
		else if (reminderId == 84) return config.reminder84Thursday();
		else if (reminderId == 85) return config.reminder85Thursday();
		else if (reminderId == 86) return config.reminder86Thursday();
		else if (reminderId == 87) return config.reminder87Thursday();
		else if (reminderId == 88) return config.reminder88Thursday();
		else if (reminderId == 89) return config.reminder89Thursday();
		else if (reminderId == 90) return config.reminder90Thursday();
		else if (reminderId == 91) return config.reminder91Thursday();
		else if (reminderId == 92) return config.reminder92Thursday();
		else if (reminderId == 93) return config.reminder93Thursday();
		else if (reminderId == 94) return config.reminder94Thursday();
		else if (reminderId == 95) return config.reminder95Thursday();
		else if (reminderId == 96) return config.reminder96Thursday();
		else if (reminderId == 97) return config.reminder97Thursday();
		else if (reminderId == 98) return config.reminder98Thursday();
		else if (reminderId == 99) return config.reminder99Thursday();
		else if (reminderId == 100) return config.reminder100Thursday();
		else return false;
	}

	boolean isFriday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Friday();
		else if (reminderId == 2) return config.reminder2Friday();
		else if (reminderId == 3) return config.reminder3Friday();
		else if (reminderId == 4) return config.reminder4Friday();
		else if (reminderId == 5) return config.reminder5Friday();
		else if (reminderId == 6) return config.reminder6Friday();
		else if (reminderId == 7) return config.reminder7Friday();
		else if (reminderId == 8) return config.reminder8Friday();
		else if (reminderId == 9) return config.reminder9Friday();
		else if (reminderId == 10) return config.reminder10Friday();
		else if (reminderId == 11) return config.reminder11Friday();
		else if (reminderId == 12) return config.reminder12Friday();
		else if (reminderId == 13) return config.reminder13Friday();
		else if (reminderId == 14) return config.reminder14Friday();
		else if (reminderId == 15) return config.reminder15Friday();
		else if (reminderId == 16) return config.reminder16Friday();
		else if (reminderId == 17) return config.reminder17Friday();
		else if (reminderId == 18) return config.reminder18Friday();
		else if (reminderId == 19) return config.reminder19Friday();
		else if (reminderId == 20) return config.reminder20Friday();
		else if (reminderId == 21) return config.reminder21Friday();
		else if (reminderId == 22) return config.reminder22Friday();
		else if (reminderId == 23) return config.reminder23Friday();
		else if (reminderId == 24) return config.reminder24Friday();
		else if (reminderId == 25) return config.reminder25Friday();
		else if (reminderId == 26) return config.reminder26Friday();
		else if (reminderId == 27) return config.reminder27Friday();
		else if (reminderId == 28) return config.reminder28Friday();
		else if (reminderId == 29) return config.reminder29Friday();
		else if (reminderId == 30) return config.reminder30Friday();
		else if (reminderId == 31) return config.reminder31Friday();
		else if (reminderId == 32) return config.reminder32Friday();
		else if (reminderId == 33) return config.reminder33Friday();
		else if (reminderId == 34) return config.reminder34Friday();
		else if (reminderId == 35) return config.reminder35Friday();
		else if (reminderId == 36) return config.reminder36Friday();
		else if (reminderId == 37) return config.reminder37Friday();
		else if (reminderId == 38) return config.reminder38Friday();
		else if (reminderId == 39) return config.reminder39Friday();
		else if (reminderId == 40) return config.reminder40Friday();
		else if (reminderId == 41) return config.reminder41Friday();
		else if (reminderId == 42) return config.reminder42Friday();
		else if (reminderId == 43) return config.reminder43Friday();
		else if (reminderId == 44) return config.reminder44Friday();
		else if (reminderId == 45) return config.reminder45Friday();
		else if (reminderId == 46) return config.reminder46Friday();
		else if (reminderId == 47) return config.reminder47Friday();
		else if (reminderId == 48) return config.reminder48Friday();
		else if (reminderId == 49) return config.reminder49Friday();
		else if (reminderId == 50) return config.reminder50Friday();
		else if (reminderId == 51) return config.reminder51Friday();
		else if (reminderId == 52) return config.reminder52Friday();
		else if (reminderId == 53) return config.reminder53Friday();
		else if (reminderId == 54) return config.reminder54Friday();
		else if (reminderId == 55) return config.reminder55Friday();
		else if (reminderId == 56) return config.reminder56Friday();
		else if (reminderId == 57) return config.reminder57Friday();
		else if (reminderId == 58) return config.reminder58Friday();
		else if (reminderId == 59) return config.reminder59Friday();
		else if (reminderId == 60) return config.reminder60Friday();
		else if (reminderId == 61) return config.reminder61Friday();
		else if (reminderId == 62) return config.reminder62Friday();
		else if (reminderId == 63) return config.reminder63Friday();
		else if (reminderId == 64) return config.reminder64Friday();
		else if (reminderId == 65) return config.reminder65Friday();
		else if (reminderId == 66) return config.reminder66Friday();
		else if (reminderId == 67) return config.reminder67Friday();
		else if (reminderId == 68) return config.reminder68Friday();
		else if (reminderId == 69) return config.reminder69Friday();
		else if (reminderId == 70) return config.reminder70Friday();
		else if (reminderId == 71) return config.reminder71Friday();
		else if (reminderId == 72) return config.reminder72Friday();
		else if (reminderId == 73) return config.reminder73Friday();
		else if (reminderId == 74) return config.reminder74Friday();
		else if (reminderId == 75) return config.reminder75Friday();
		else if (reminderId == 76) return config.reminder76Friday();
		else if (reminderId == 77) return config.reminder77Friday();
		else if (reminderId == 78) return config.reminder78Friday();
		else if (reminderId == 79) return config.reminder79Friday();
		else if (reminderId == 80) return config.reminder80Friday();
		else if (reminderId == 81) return config.reminder81Friday();
		else if (reminderId == 82) return config.reminder82Friday();
		else if (reminderId == 83) return config.reminder83Friday();
		else if (reminderId == 84) return config.reminder84Friday();
		else if (reminderId == 85) return config.reminder85Friday();
		else if (reminderId == 86) return config.reminder86Friday();
		else if (reminderId == 87) return config.reminder87Friday();
		else if (reminderId == 88) return config.reminder88Friday();
		else if (reminderId == 89) return config.reminder89Friday();
		else if (reminderId == 90) return config.reminder90Friday();
		else if (reminderId == 91) return config.reminder91Friday();
		else if (reminderId == 92) return config.reminder92Friday();
		else if (reminderId == 93) return config.reminder93Friday();
		else if (reminderId == 94) return config.reminder94Friday();
		else if (reminderId == 95) return config.reminder95Friday();
		else if (reminderId == 96) return config.reminder96Friday();
		else if (reminderId == 97) return config.reminder97Friday();
		else if (reminderId == 98) return config.reminder98Friday();
		else if (reminderId == 99) return config.reminder99Friday();
		else if (reminderId == 100) return config.reminder100Friday();
		else return false;
	}

	boolean isSaturday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Saturday();
		else if (reminderId == 2) return config.reminder2Saturday();
		else if (reminderId == 3) return config.reminder3Saturday();
		else if (reminderId == 4) return config.reminder4Saturday();
		else if (reminderId == 5) return config.reminder5Saturday();
		else if (reminderId == 6) return config.reminder6Saturday();
		else if (reminderId == 7) return config.reminder7Saturday();
		else if (reminderId == 8) return config.reminder8Saturday();
		else if (reminderId == 9) return config.reminder9Saturday();
		else if (reminderId == 10) return config.reminder10Saturday();
		else if (reminderId == 11) return config.reminder11Saturday();
		else if (reminderId == 12) return config.reminder12Saturday();
		else if (reminderId == 13) return config.reminder13Saturday();
		else if (reminderId == 14) return config.reminder14Saturday();
		else if (reminderId == 15) return config.reminder15Saturday();
		else if (reminderId == 16) return config.reminder16Saturday();
		else if (reminderId == 17) return config.reminder17Saturday();
		else if (reminderId == 18) return config.reminder18Saturday();
		else if (reminderId == 19) return config.reminder19Saturday();
		else if (reminderId == 20) return config.reminder20Saturday();
		else if (reminderId == 21) return config.reminder21Saturday();
		else if (reminderId == 22) return config.reminder22Saturday();
		else if (reminderId == 23) return config.reminder23Saturday();
		else if (reminderId == 24) return config.reminder24Saturday();
		else if (reminderId == 25) return config.reminder25Saturday();
		else if (reminderId == 26) return config.reminder26Saturday();
		else if (reminderId == 27) return config.reminder27Saturday();
		else if (reminderId == 28) return config.reminder28Saturday();
		else if (reminderId == 29) return config.reminder29Saturday();
		else if (reminderId == 30) return config.reminder30Saturday();
		else if (reminderId == 31) return config.reminder31Saturday();
		else if (reminderId == 32) return config.reminder32Saturday();
		else if (reminderId == 33) return config.reminder33Saturday();
		else if (reminderId == 34) return config.reminder34Saturday();
		else if (reminderId == 35) return config.reminder35Saturday();
		else if (reminderId == 36) return config.reminder36Saturday();
		else if (reminderId == 37) return config.reminder37Saturday();
		else if (reminderId == 38) return config.reminder38Saturday();
		else if (reminderId == 39) return config.reminder39Saturday();
		else if (reminderId == 40) return config.reminder40Saturday();
		else if (reminderId == 41) return config.reminder41Saturday();
		else if (reminderId == 42) return config.reminder42Saturday();
		else if (reminderId == 43) return config.reminder43Saturday();
		else if (reminderId == 44) return config.reminder44Saturday();
		else if (reminderId == 45) return config.reminder45Saturday();
		else if (reminderId == 46) return config.reminder46Saturday();
		else if (reminderId == 47) return config.reminder47Saturday();
		else if (reminderId == 48) return config.reminder48Saturday();
		else if (reminderId == 49) return config.reminder49Saturday();
		else if (reminderId == 50) return config.reminder50Saturday();
		else if (reminderId == 51) return config.reminder51Saturday();
		else if (reminderId == 52) return config.reminder52Saturday();
		else if (reminderId == 53) return config.reminder53Saturday();
		else if (reminderId == 54) return config.reminder54Saturday();
		else if (reminderId == 55) return config.reminder55Saturday();
		else if (reminderId == 56) return config.reminder56Saturday();
		else if (reminderId == 57) return config.reminder57Saturday();
		else if (reminderId == 58) return config.reminder58Saturday();
		else if (reminderId == 59) return config.reminder59Saturday();
		else if (reminderId == 60) return config.reminder60Saturday();
		else if (reminderId == 61) return config.reminder61Saturday();
		else if (reminderId == 62) return config.reminder62Saturday();
		else if (reminderId == 63) return config.reminder63Saturday();
		else if (reminderId == 64) return config.reminder64Saturday();
		else if (reminderId == 65) return config.reminder65Saturday();
		else if (reminderId == 66) return config.reminder66Saturday();
		else if (reminderId == 67) return config.reminder67Saturday();
		else if (reminderId == 68) return config.reminder68Saturday();
		else if (reminderId == 69) return config.reminder69Saturday();
		else if (reminderId == 70) return config.reminder70Saturday();
		else if (reminderId == 71) return config.reminder71Saturday();
		else if (reminderId == 72) return config.reminder72Saturday();
		else if (reminderId == 73) return config.reminder73Saturday();
		else if (reminderId == 74) return config.reminder74Saturday();
		else if (reminderId == 75) return config.reminder75Saturday();
		else if (reminderId == 76) return config.reminder76Saturday();
		else if (reminderId == 77) return config.reminder77Saturday();
		else if (reminderId == 78) return config.reminder78Saturday();
		else if (reminderId == 79) return config.reminder79Saturday();
		else if (reminderId == 80) return config.reminder80Saturday();
		else if (reminderId == 81) return config.reminder81Saturday();
		else if (reminderId == 82) return config.reminder82Saturday();
		else if (reminderId == 83) return config.reminder83Saturday();
		else if (reminderId == 84) return config.reminder84Saturday();
		else if (reminderId == 85) return config.reminder85Saturday();
		else if (reminderId == 86) return config.reminder86Saturday();
		else if (reminderId == 87) return config.reminder87Saturday();
		else if (reminderId == 88) return config.reminder88Saturday();
		else if (reminderId == 89) return config.reminder89Saturday();
		else if (reminderId == 90) return config.reminder90Saturday();
		else if (reminderId == 91) return config.reminder91Saturday();
		else if (reminderId == 92) return config.reminder92Saturday();
		else if (reminderId == 93) return config.reminder93Saturday();
		else if (reminderId == 94) return config.reminder94Saturday();
		else if (reminderId == 95) return config.reminder95Saturday();
		else if (reminderId == 96) return config.reminder96Saturday();
		else if (reminderId == 97) return config.reminder97Saturday();
		else if (reminderId == 98) return config.reminder98Saturday();
		else if (reminderId == 99) return config.reminder99Saturday();
		else if (reminderId == 100) return config.reminder100Saturday();
		else return false;
	}

	boolean isSunday(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Sunday();
		else if (reminderId == 2) return config.reminder2Sunday();
		else if (reminderId == 3) return config.reminder3Sunday();
		else if (reminderId == 4) return config.reminder4Sunday();
		else if (reminderId == 5) return config.reminder5Sunday();
		else if (reminderId == 6) return config.reminder6Sunday();
		else if (reminderId == 7) return config.reminder7Sunday();
		else if (reminderId == 8) return config.reminder8Sunday();
		else if (reminderId == 9) return config.reminder9Sunday();
		else if (reminderId == 10) return config.reminder10Sunday();
		else if (reminderId == 11) return config.reminder11Sunday();
		else if (reminderId == 12) return config.reminder12Sunday();
		else if (reminderId == 13) return config.reminder13Sunday();
		else if (reminderId == 14) return config.reminder14Sunday();
		else if (reminderId == 15) return config.reminder15Sunday();
		else if (reminderId == 16) return config.reminder16Sunday();
		else if (reminderId == 17) return config.reminder17Sunday();
		else if (reminderId == 18) return config.reminder18Sunday();
		else if (reminderId == 19) return config.reminder19Sunday();
		else if (reminderId == 20) return config.reminder20Sunday();
		else if (reminderId == 21) return config.reminder21Sunday();
		else if (reminderId == 22) return config.reminder22Sunday();
		else if (reminderId == 23) return config.reminder23Sunday();
		else if (reminderId == 24) return config.reminder24Sunday();
		else if (reminderId == 25) return config.reminder25Sunday();
		else if (reminderId == 26) return config.reminder26Sunday();
		else if (reminderId == 27) return config.reminder27Sunday();
		else if (reminderId == 28) return config.reminder28Sunday();
		else if (reminderId == 29) return config.reminder29Sunday();
		else if (reminderId == 30) return config.reminder30Sunday();
		else if (reminderId == 31) return config.reminder31Sunday();
		else if (reminderId == 32) return config.reminder32Sunday();
		else if (reminderId == 33) return config.reminder33Sunday();
		else if (reminderId == 34) return config.reminder34Sunday();
		else if (reminderId == 35) return config.reminder35Sunday();
		else if (reminderId == 36) return config.reminder36Sunday();
		else if (reminderId == 37) return config.reminder37Sunday();
		else if (reminderId == 38) return config.reminder38Sunday();
		else if (reminderId == 39) return config.reminder39Sunday();
		else if (reminderId == 40) return config.reminder40Sunday();
		else if (reminderId == 41) return config.reminder41Sunday();
		else if (reminderId == 42) return config.reminder42Sunday();
		else if (reminderId == 43) return config.reminder43Sunday();
		else if (reminderId == 44) return config.reminder44Sunday();
		else if (reminderId == 45) return config.reminder45Sunday();
		else if (reminderId == 46) return config.reminder46Sunday();
		else if (reminderId == 47) return config.reminder47Sunday();
		else if (reminderId == 48) return config.reminder48Sunday();
		else if (reminderId == 49) return config.reminder49Sunday();
		else if (reminderId == 50) return config.reminder50Sunday();
		else if (reminderId == 51) return config.reminder51Sunday();
		else if (reminderId == 52) return config.reminder52Sunday();
		else if (reminderId == 53) return config.reminder53Sunday();
		else if (reminderId == 54) return config.reminder54Sunday();
		else if (reminderId == 55) return config.reminder55Sunday();
		else if (reminderId == 56) return config.reminder56Sunday();
		else if (reminderId == 57) return config.reminder57Sunday();
		else if (reminderId == 58) return config.reminder58Sunday();
		else if (reminderId == 59) return config.reminder59Sunday();
		else if (reminderId == 60) return config.reminder60Sunday();
		else if (reminderId == 61) return config.reminder61Sunday();
		else if (reminderId == 62) return config.reminder62Sunday();
		else if (reminderId == 63) return config.reminder63Sunday();
		else if (reminderId == 64) return config.reminder64Sunday();
		else if (reminderId == 65) return config.reminder65Sunday();
		else if (reminderId == 66) return config.reminder66Sunday();
		else if (reminderId == 67) return config.reminder67Sunday();
		else if (reminderId == 68) return config.reminder68Sunday();
		else if (reminderId == 69) return config.reminder69Sunday();
		else if (reminderId == 70) return config.reminder70Sunday();
		else if (reminderId == 71) return config.reminder71Sunday();
		else if (reminderId == 72) return config.reminder72Sunday();
		else if (reminderId == 73) return config.reminder73Sunday();
		else if (reminderId == 74) return config.reminder74Sunday();
		else if (reminderId == 75) return config.reminder75Sunday();
		else if (reminderId == 76) return config.reminder76Sunday();
		else if (reminderId == 77) return config.reminder77Sunday();
		else if (reminderId == 78) return config.reminder78Sunday();
		else if (reminderId == 79) return config.reminder79Sunday();
		else if (reminderId == 80) return config.reminder80Sunday();
		else if (reminderId == 81) return config.reminder81Sunday();
		else if (reminderId == 82) return config.reminder82Sunday();
		else if (reminderId == 83) return config.reminder83Sunday();
		else if (reminderId == 84) return config.reminder84Sunday();
		else if (reminderId == 85) return config.reminder85Sunday();
		else if (reminderId == 86) return config.reminder86Sunday();
		else if (reminderId == 87) return config.reminder87Sunday();
		else if (reminderId == 88) return config.reminder88Sunday();
		else if (reminderId == 89) return config.reminder89Sunday();
		else if (reminderId == 90) return config.reminder90Sunday();
		else if (reminderId == 91) return config.reminder91Sunday();
		else if (reminderId == 92) return config.reminder92Sunday();
		else if (reminderId == 93) return config.reminder93Sunday();
		else if (reminderId == 94) return config.reminder94Sunday();
		else if (reminderId == 95) return config.reminder95Sunday();
		else if (reminderId == 96) return config.reminder96Sunday();
		else if (reminderId == 97) return config.reminder97Sunday();
		else if (reminderId == 98) return config.reminder98Sunday();
		else if (reminderId == 99) return config.reminder99Sunday();
		else if (reminderId == 100) return config.reminder100Sunday();
		else return false;
	}

	String getDate(int reminderId)
	{
		if (reminderId == 1) return config.reminder1Date();
		else if (reminderId == 2) return config.reminder2Date();
		else if (reminderId == 3) return config.reminder3Date();
		else if (reminderId == 4) return config.reminder4Date();
		else if (reminderId == 5) return config.reminder5Date();
		else if (reminderId == 6) return config.reminder6Date();
		else if (reminderId == 7) return config.reminder7Date();
		else if (reminderId == 8) return config.reminder8Date();
		else if (reminderId == 9) return config.reminder9Date();
		else if (reminderId == 10) return config.reminder10Date();
		else if (reminderId == 11) return config.reminder11Date();
		else if (reminderId == 12) return config.reminder12Date();
		else if (reminderId == 13) return config.reminder13Date();
		else if (reminderId == 14) return config.reminder14Date();
		else if (reminderId == 15) return config.reminder15Date();
		else if (reminderId == 16) return config.reminder16Date();
		else if (reminderId == 17) return config.reminder17Date();
		else if (reminderId == 18) return config.reminder18Date();
		else if (reminderId == 19) return config.reminder19Date();
		else if (reminderId == 20) return config.reminder20Date();
		else if (reminderId == 21) return config.reminder21Date();
		else if (reminderId == 22) return config.reminder22Date();
		else if (reminderId == 23) return config.reminder23Date();
		else if (reminderId == 24) return config.reminder24Date();
		else if (reminderId == 25) return config.reminder25Date();
		else if (reminderId == 26) return config.reminder26Date();
		else if (reminderId == 27) return config.reminder27Date();
		else if (reminderId == 28) return config.reminder28Date();
		else if (reminderId == 29) return config.reminder29Date();
		else if (reminderId == 30) return config.reminder30Date();
		else if (reminderId == 31) return config.reminder31Date();
		else if (reminderId == 32) return config.reminder32Date();
		else if (reminderId == 33) return config.reminder33Date();
		else if (reminderId == 34) return config.reminder34Date();
		else if (reminderId == 35) return config.reminder35Date();
		else if (reminderId == 36) return config.reminder36Date();
		else if (reminderId == 37) return config.reminder37Date();
		else if (reminderId == 38) return config.reminder38Date();
		else if (reminderId == 39) return config.reminder39Date();
		else if (reminderId == 40) return config.reminder40Date();
		else if (reminderId == 41) return config.reminder41Date();
		else if (reminderId == 42) return config.reminder42Date();
		else if (reminderId == 43) return config.reminder43Date();
		else if (reminderId == 44) return config.reminder44Date();
		else if (reminderId == 45) return config.reminder45Date();
		else if (reminderId == 46) return config.reminder46Date();
		else if (reminderId == 47) return config.reminder47Date();
		else if (reminderId == 48) return config.reminder48Date();
		else if (reminderId == 49) return config.reminder49Date();
		else if (reminderId == 50) return config.reminder50Date();
		else if (reminderId == 51) return config.reminder51Date();
		else if (reminderId == 52) return config.reminder52Date();
		else if (reminderId == 53) return config.reminder53Date();
		else if (reminderId == 54) return config.reminder54Date();
		else if (reminderId == 55) return config.reminder55Date();
		else if (reminderId == 56) return config.reminder56Date();
		else if (reminderId == 57) return config.reminder57Date();
		else if (reminderId == 58) return config.reminder58Date();
		else if (reminderId == 59) return config.reminder59Date();
		else if (reminderId == 60) return config.reminder60Date();
		else if (reminderId == 61) return config.reminder61Date();
		else if (reminderId == 62) return config.reminder62Date();
		else if (reminderId == 63) return config.reminder63Date();
		else if (reminderId == 64) return config.reminder64Date();
		else if (reminderId == 65) return config.reminder65Date();
		else if (reminderId == 66) return config.reminder66Date();
		else if (reminderId == 67) return config.reminder67Date();
		else if (reminderId == 68) return config.reminder68Date();
		else if (reminderId == 69) return config.reminder69Date();
		else if (reminderId == 70) return config.reminder70Date();
		else if (reminderId == 71) return config.reminder71Date();
		else if (reminderId == 72) return config.reminder72Date();
		else if (reminderId == 73) return config.reminder73Date();
		else if (reminderId == 74) return config.reminder74Date();
		else if (reminderId == 75) return config.reminder75Date();
		else if (reminderId == 76) return config.reminder76Date();
		else if (reminderId == 77) return config.reminder77Date();
		else if (reminderId == 78) return config.reminder78Date();
		else if (reminderId == 79) return config.reminder79Date();
		else if (reminderId == 80) return config.reminder80Date();
		else if (reminderId == 81) return config.reminder81Date();
		else if (reminderId == 82) return config.reminder82Date();
		else if (reminderId == 83) return config.reminder83Date();
		else if (reminderId == 84) return config.reminder84Date();
		else if (reminderId == 85) return config.reminder85Date();
		else if (reminderId == 86) return config.reminder86Date();
		else if (reminderId == 87) return config.reminder87Date();
		else if (reminderId == 88) return config.reminder88Date();
		else if (reminderId == 89) return config.reminder89Date();
		else if (reminderId == 90) return config.reminder90Date();
		else if (reminderId == 91) return config.reminder91Date();
		else if (reminderId == 92) return config.reminder92Date();
		else if (reminderId == 93) return config.reminder93Date();
		else if (reminderId == 94) return config.reminder94Date();
		else if (reminderId == 95) return config.reminder95Date();
		else if (reminderId == 96) return config.reminder96Date();
		else if (reminderId == 97) return config.reminder97Date();
		else if (reminderId == 98) return config.reminder98Date();
		else if (reminderId == 99) return config.reminder99Date();
		else if (reminderId == 100) return config.reminder100Date();
		else return "";
	}

	int getLocationX(int reminderId)
	{
		if (reminderId == 1) return config.reminder1LocationX();
		else if (reminderId == 2) return config.reminder2LocationX();
		else if (reminderId == 3) return config.reminder3LocationX();
		else if (reminderId == 4) return config.reminder4LocationX();
		else if (reminderId == 5) return config.reminder5LocationX();
		else if (reminderId == 6) return config.reminder6LocationX();
		else if (reminderId == 7) return config.reminder7LocationX();
		else if (reminderId == 8) return config.reminder8LocationX();
		else if (reminderId == 9) return config.reminder9LocationX();
		else if (reminderId == 10) return config.reminder10LocationX();
		else if (reminderId == 11) return config.reminder11LocationX();
		else if (reminderId == 12) return config.reminder12LocationX();
		else if (reminderId == 13) return config.reminder13LocationX();
		else if (reminderId == 14) return config.reminder14LocationX();
		else if (reminderId == 15) return config.reminder15LocationX();
		else if (reminderId == 16) return config.reminder16LocationX();
		else if (reminderId == 17) return config.reminder17LocationX();
		else if (reminderId == 18) return config.reminder18LocationX();
		else if (reminderId == 19) return config.reminder19LocationX();
		else if (reminderId == 20) return config.reminder20LocationX();
		else if (reminderId == 21) return config.reminder21LocationX();
		else if (reminderId == 22) return config.reminder22LocationX();
		else if (reminderId == 23) return config.reminder23LocationX();
		else if (reminderId == 24) return config.reminder24LocationX();
		else if (reminderId == 25) return config.reminder25LocationX();
		else if (reminderId == 26) return config.reminder26LocationX();
		else if (reminderId == 27) return config.reminder27LocationX();
		else if (reminderId == 28) return config.reminder28LocationX();
		else if (reminderId == 29) return config.reminder29LocationX();
		else if (reminderId == 30) return config.reminder30LocationX();
		else if (reminderId == 31) return config.reminder31LocationX();
		else if (reminderId == 32) return config.reminder32LocationX();
		else if (reminderId == 33) return config.reminder33LocationX();
		else if (reminderId == 34) return config.reminder34LocationX();
		else if (reminderId == 35) return config.reminder35LocationX();
		else if (reminderId == 36) return config.reminder36LocationX();
		else if (reminderId == 37) return config.reminder37LocationX();
		else if (reminderId == 38) return config.reminder38LocationX();
		else if (reminderId == 39) return config.reminder39LocationX();
		else if (reminderId == 40) return config.reminder40LocationX();
		else if (reminderId == 41) return config.reminder41LocationX();
		else if (reminderId == 42) return config.reminder42LocationX();
		else if (reminderId == 43) return config.reminder43LocationX();
		else if (reminderId == 44) return config.reminder44LocationX();
		else if (reminderId == 45) return config.reminder45LocationX();
		else if (reminderId == 46) return config.reminder46LocationX();
		else if (reminderId == 47) return config.reminder47LocationX();
		else if (reminderId == 48) return config.reminder48LocationX();
		else if (reminderId == 49) return config.reminder49LocationX();
		else if (reminderId == 50) return config.reminder50LocationX();
		else if (reminderId == 51) return config.reminder51LocationX();
		else if (reminderId == 52) return config.reminder52LocationX();
		else if (reminderId == 53) return config.reminder53LocationX();
		else if (reminderId == 54) return config.reminder54LocationX();
		else if (reminderId == 55) return config.reminder55LocationX();
		else if (reminderId == 56) return config.reminder56LocationX();
		else if (reminderId == 57) return config.reminder57LocationX();
		else if (reminderId == 58) return config.reminder58LocationX();
		else if (reminderId == 59) return config.reminder59LocationX();
		else if (reminderId == 60) return config.reminder60LocationX();
		else if (reminderId == 61) return config.reminder61LocationX();
		else if (reminderId == 62) return config.reminder62LocationX();
		else if (reminderId == 63) return config.reminder63LocationX();
		else if (reminderId == 64) return config.reminder64LocationX();
		else if (reminderId == 65) return config.reminder65LocationX();
		else if (reminderId == 66) return config.reminder66LocationX();
		else if (reminderId == 67) return config.reminder67LocationX();
		else if (reminderId == 68) return config.reminder68LocationX();
		else if (reminderId == 69) return config.reminder69LocationX();
		else if (reminderId == 70) return config.reminder70LocationX();
		else if (reminderId == 71) return config.reminder71LocationX();
		else if (reminderId == 72) return config.reminder72LocationX();
		else if (reminderId == 73) return config.reminder73LocationX();
		else if (reminderId == 74) return config.reminder74LocationX();
		else if (reminderId == 75) return config.reminder75LocationX();
		else if (reminderId == 76) return config.reminder76LocationX();
		else if (reminderId == 77) return config.reminder77LocationX();
		else if (reminderId == 78) return config.reminder78LocationX();
		else if (reminderId == 79) return config.reminder79LocationX();
		else if (reminderId == 80) return config.reminder80LocationX();
		else if (reminderId == 81) return config.reminder81LocationX();
		else if (reminderId == 82) return config.reminder82LocationX();
		else if (reminderId == 83) return config.reminder83LocationX();
		else if (reminderId == 84) return config.reminder84LocationX();
		else if (reminderId == 85) return config.reminder85LocationX();
		else if (reminderId == 86) return config.reminder86LocationX();
		else if (reminderId == 87) return config.reminder87LocationX();
		else if (reminderId == 88) return config.reminder88LocationX();
		else if (reminderId == 89) return config.reminder89LocationX();
		else if (reminderId == 90) return config.reminder90LocationX();
		else if (reminderId == 91) return config.reminder91LocationX();
		else if (reminderId == 92) return config.reminder92LocationX();
		else if (reminderId == 93) return config.reminder93LocationX();
		else if (reminderId == 94) return config.reminder94LocationX();
		else if (reminderId == 95) return config.reminder95LocationX();
		else if (reminderId == 96) return config.reminder96LocationX();
		else if (reminderId == 97) return config.reminder97LocationX();
		else if (reminderId == 98) return config.reminder98LocationX();
		else if (reminderId == 99) return config.reminder99LocationX();
		else if (reminderId == 100) return config.reminder100LocationX();
		else return 0;
	}

	int getLocationY(int reminderId)
	{
		if (reminderId == 1) return config.reminder1LocationY();
		else if (reminderId == 2) return config.reminder2LocationY();
		else if (reminderId == 3) return config.reminder3LocationY();
		else if (reminderId == 4) return config.reminder4LocationY();
		else if (reminderId == 5) return config.reminder5LocationY();
		else if (reminderId == 6) return config.reminder6LocationY();
		else if (reminderId == 7) return config.reminder7LocationY();
		else if (reminderId == 8) return config.reminder8LocationY();
		else if (reminderId == 9) return config.reminder9LocationY();
		else if (reminderId == 10) return config.reminder10LocationY();
		else if (reminderId == 11) return config.reminder11LocationY();
		else if (reminderId == 12) return config.reminder12LocationY();
		else if (reminderId == 13) return config.reminder13LocationY();
		else if (reminderId == 14) return config.reminder14LocationY();
		else if (reminderId == 15) return config.reminder15LocationY();
		else if (reminderId == 16) return config.reminder16LocationY();
		else if (reminderId == 17) return config.reminder17LocationY();
		else if (reminderId == 18) return config.reminder18LocationY();
		else if (reminderId == 19) return config.reminder19LocationY();
		else if (reminderId == 20) return config.reminder20LocationY();
		else if (reminderId == 21) return config.reminder21LocationY();
		else if (reminderId == 22) return config.reminder22LocationY();
		else if (reminderId == 23) return config.reminder23LocationY();
		else if (reminderId == 24) return config.reminder24LocationY();
		else if (reminderId == 25) return config.reminder25LocationY();
		else if (reminderId == 26) return config.reminder26LocationY();
		else if (reminderId == 27) return config.reminder27LocationY();
		else if (reminderId == 28) return config.reminder28LocationY();
		else if (reminderId == 29) return config.reminder29LocationY();
		else if (reminderId == 30) return config.reminder30LocationY();
		else if (reminderId == 31) return config.reminder31LocationY();
		else if (reminderId == 32) return config.reminder32LocationY();
		else if (reminderId == 33) return config.reminder33LocationY();
		else if (reminderId == 34) return config.reminder34LocationY();
		else if (reminderId == 35) return config.reminder35LocationY();
		else if (reminderId == 36) return config.reminder36LocationY();
		else if (reminderId == 37) return config.reminder37LocationY();
		else if (reminderId == 38) return config.reminder38LocationY();
		else if (reminderId == 39) return config.reminder39LocationY();
		else if (reminderId == 40) return config.reminder40LocationY();
		else if (reminderId == 41) return config.reminder41LocationY();
		else if (reminderId == 42) return config.reminder42LocationY();
		else if (reminderId == 43) return config.reminder43LocationY();
		else if (reminderId == 44) return config.reminder44LocationY();
		else if (reminderId == 45) return config.reminder45LocationY();
		else if (reminderId == 46) return config.reminder46LocationY();
		else if (reminderId == 47) return config.reminder47LocationY();
		else if (reminderId == 48) return config.reminder48LocationY();
		else if (reminderId == 49) return config.reminder49LocationY();
		else if (reminderId == 50) return config.reminder50LocationY();
		else if (reminderId == 51) return config.reminder51LocationY();
		else if (reminderId == 52) return config.reminder52LocationY();
		else if (reminderId == 53) return config.reminder53LocationY();
		else if (reminderId == 54) return config.reminder54LocationY();
		else if (reminderId == 55) return config.reminder55LocationY();
		else if (reminderId == 56) return config.reminder56LocationY();
		else if (reminderId == 57) return config.reminder57LocationY();
		else if (reminderId == 58) return config.reminder58LocationY();
		else if (reminderId == 59) return config.reminder59LocationY();
		else if (reminderId == 60) return config.reminder60LocationY();
		else if (reminderId == 61) return config.reminder61LocationY();
		else if (reminderId == 62) return config.reminder62LocationY();
		else if (reminderId == 63) return config.reminder63LocationY();
		else if (reminderId == 64) return config.reminder64LocationY();
		else if (reminderId == 65) return config.reminder65LocationY();
		else if (reminderId == 66) return config.reminder66LocationY();
		else if (reminderId == 67) return config.reminder67LocationY();
		else if (reminderId == 68) return config.reminder68LocationY();
		else if (reminderId == 69) return config.reminder69LocationY();
		else if (reminderId == 70) return config.reminder70LocationY();
		else if (reminderId == 71) return config.reminder71LocationY();
		else if (reminderId == 72) return config.reminder72LocationY();
		else if (reminderId == 73) return config.reminder73LocationY();
		else if (reminderId == 74) return config.reminder74LocationY();
		else if (reminderId == 75) return config.reminder75LocationY();
		else if (reminderId == 76) return config.reminder76LocationY();
		else if (reminderId == 77) return config.reminder77LocationY();
		else if (reminderId == 78) return config.reminder78LocationY();
		else if (reminderId == 79) return config.reminder79LocationY();
		else if (reminderId == 80) return config.reminder80LocationY();
		else if (reminderId == 81) return config.reminder81LocationY();
		else if (reminderId == 82) return config.reminder82LocationY();
		else if (reminderId == 83) return config.reminder83LocationY();
		else if (reminderId == 84) return config.reminder84LocationY();
		else if (reminderId == 85) return config.reminder85LocationY();
		else if (reminderId == 86) return config.reminder86LocationY();
		else if (reminderId == 87) return config.reminder87LocationY();
		else if (reminderId == 88) return config.reminder88LocationY();
		else if (reminderId == 89) return config.reminder89LocationY();
		else if (reminderId == 90) return config.reminder90LocationY();
		else if (reminderId == 91) return config.reminder91LocationY();
		else if (reminderId == 92) return config.reminder92LocationY();
		else if (reminderId == 93) return config.reminder93LocationY();
		else if (reminderId == 94) return config.reminder94LocationY();
		else if (reminderId == 95) return config.reminder95LocationY();
		else if (reminderId == 96) return config.reminder96LocationY();
		else if (reminderId == 97) return config.reminder97LocationY();
		else if (reminderId == 98) return config.reminder98LocationY();
		else if (reminderId == 99) return config.reminder99LocationY();
		else if (reminderId == 100) return config.reminder100LocationY();
		else return 0;
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

	int getRegionId(int reminderId)
	{
		if (reminderId == 1) return config.reminder1RegionId();
		else if (reminderId == 2) return config.reminder2RegionId();
		else if (reminderId == 3) return config.reminder3RegionId();
		else if (reminderId == 4) return config.reminder4RegionId();
		else if (reminderId == 5) return config.reminder5RegionId();
		else if (reminderId == 6) return config.reminder6RegionId();
		else if (reminderId == 7) return config.reminder7RegionId();
		else if (reminderId == 8) return config.reminder8RegionId();
		else if (reminderId == 9) return config.reminder9RegionId();
		else if (reminderId == 10) return config.reminder10RegionId();
		else if (reminderId == 11) return config.reminder11RegionId();
		else if (reminderId == 12) return config.reminder12RegionId();
		else if (reminderId == 13) return config.reminder13RegionId();
		else if (reminderId == 14) return config.reminder14RegionId();
		else if (reminderId == 15) return config.reminder15RegionId();
		else if (reminderId == 16) return config.reminder16RegionId();
		else if (reminderId == 17) return config.reminder17RegionId();
		else if (reminderId == 18) return config.reminder18RegionId();
		else if (reminderId == 19) return config.reminder19RegionId();
		else if (reminderId == 20) return config.reminder20RegionId();
		else if (reminderId == 21) return config.reminder21RegionId();
		else if (reminderId == 22) return config.reminder22RegionId();
		else if (reminderId == 23) return config.reminder23RegionId();
		else if (reminderId == 24) return config.reminder24RegionId();
		else if (reminderId == 25) return config.reminder25RegionId();
		else if (reminderId == 26) return config.reminder26RegionId();
		else if (reminderId == 27) return config.reminder27RegionId();
		else if (reminderId == 28) return config.reminder28RegionId();
		else if (reminderId == 29) return config.reminder29RegionId();
		else if (reminderId == 30) return config.reminder30RegionId();
		else if (reminderId == 31) return config.reminder31RegionId();
		else if (reminderId == 32) return config.reminder32RegionId();
		else if (reminderId == 33) return config.reminder33RegionId();
		else if (reminderId == 34) return config.reminder34RegionId();
		else if (reminderId == 35) return config.reminder35RegionId();
		else if (reminderId == 36) return config.reminder36RegionId();
		else if (reminderId == 37) return config.reminder37RegionId();
		else if (reminderId == 38) return config.reminder38RegionId();
		else if (reminderId == 39) return config.reminder39RegionId();
		else if (reminderId == 40) return config.reminder40RegionId();
		else if (reminderId == 41) return config.reminder41RegionId();
		else if (reminderId == 42) return config.reminder42RegionId();
		else if (reminderId == 43) return config.reminder43RegionId();
		else if (reminderId == 44) return config.reminder44RegionId();
		else if (reminderId == 45) return config.reminder45RegionId();
		else if (reminderId == 46) return config.reminder46RegionId();
		else if (reminderId == 47) return config.reminder47RegionId();
		else if (reminderId == 48) return config.reminder48RegionId();
		else if (reminderId == 49) return config.reminder49RegionId();
		else if (reminderId == 50) return config.reminder50RegionId();
		else if (reminderId == 51) return config.reminder51RegionId();
		else if (reminderId == 52) return config.reminder52RegionId();
		else if (reminderId == 53) return config.reminder53RegionId();
		else if (reminderId == 54) return config.reminder54RegionId();
		else if (reminderId == 55) return config.reminder55RegionId();
		else if (reminderId == 56) return config.reminder56RegionId();
		else if (reminderId == 57) return config.reminder57RegionId();
		else if (reminderId == 58) return config.reminder58RegionId();
		else if (reminderId == 59) return config.reminder59RegionId();
		else if (reminderId == 60) return config.reminder60RegionId();
		else if (reminderId == 61) return config.reminder61RegionId();
		else if (reminderId == 62) return config.reminder62RegionId();
		else if (reminderId == 63) return config.reminder63RegionId();
		else if (reminderId == 64) return config.reminder64RegionId();
		else if (reminderId == 65) return config.reminder65RegionId();
		else if (reminderId == 66) return config.reminder66RegionId();
		else if (reminderId == 67) return config.reminder67RegionId();
		else if (reminderId == 68) return config.reminder68RegionId();
		else if (reminderId == 69) return config.reminder69RegionId();
		else if (reminderId == 70) return config.reminder70RegionId();
		else if (reminderId == 71) return config.reminder71RegionId();
		else if (reminderId == 72) return config.reminder72RegionId();
		else if (reminderId == 73) return config.reminder73RegionId();
		else if (reminderId == 74) return config.reminder74RegionId();
		else if (reminderId == 75) return config.reminder75RegionId();
		else if (reminderId == 76) return config.reminder76RegionId();
		else if (reminderId == 77) return config.reminder77RegionId();
		else if (reminderId == 78) return config.reminder78RegionId();
		else if (reminderId == 79) return config.reminder79RegionId();
		else if (reminderId == 80) return config.reminder80RegionId();
		else if (reminderId == 81) return config.reminder81RegionId();
		else if (reminderId == 82) return config.reminder82RegionId();
		else if (reminderId == 83) return config.reminder83RegionId();
		else if (reminderId == 84) return config.reminder84RegionId();
		else if (reminderId == 85) return config.reminder85RegionId();
		else if (reminderId == 86) return config.reminder86RegionId();
		else if (reminderId == 87) return config.reminder87RegionId();
		else if (reminderId == 88) return config.reminder88RegionId();
		else if (reminderId == 89) return config.reminder89RegionId();
		else if (reminderId == 90) return config.reminder90RegionId();
		else if (reminderId == 91) return config.reminder91RegionId();
		else if (reminderId == 92) return config.reminder92RegionId();
		else if (reminderId == 93) return config.reminder93RegionId();
		else if (reminderId == 94) return config.reminder94RegionId();
		else if (reminderId == 95) return config.reminder95RegionId();
		else if (reminderId == 96) return config.reminder96RegionId();
		else if (reminderId == 97) return config.reminder97RegionId();
		else if (reminderId == 98) return config.reminder98RegionId();
		else if (reminderId == 99) return config.reminder99RegionId();
		else if (reminderId == 100) return config.reminder100RegionId();
		else return 0;
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
}