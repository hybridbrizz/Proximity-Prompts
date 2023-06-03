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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

@PluginDescriptor(
	name = "Reminders",
	description = "Set reminders."
)

public class RemindersPlugin extends Plugin
{
	@Inject private RemindersOverlay overlay;
	@Inject private OverlayManager overlayManager;
	@Inject private Client client;
	@Inject private RemindersConfig config;
	@Inject private ConfigManager configManager;
	@Inject private Gson gson;

	@Inject private ItemManager itemManager;

	ZoneOffset zoneOffset = ZoneId.systemDefault()
		.getRules()
		.getOffset(
			LocalDate.now()
				.atStartOfDay()
		);

	LocalDateTime lastDateTime = null;

	int regionId = 0;
	int lastRegionId = 0;

	Set<NPC> npcs = new HashSet<>();

	List<ItemComposition> inventoryItems = new LinkedList<>();

	LocalPoint localPos = new LocalPoint(0, 0);

	boolean progressUpdated = false;

	// so the first hit after a reset is tracked
	private Map<Integer, Integer> skillsXp = new HashMap<>();

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Provides
	RemindersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RemindersConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{

	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		inventoryItems.clear();

		regionId = WorldPoint.fromLocalInstance(
				client,
				client.getLocalPlayer().getLocalLocation()
		).getRegionID();

		lastRegionId = regionId;

		localPos = client.getLocalPlayer().getLocalLocation();

		final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer == null)
		{
			return;
		}

		final Item[] items = itemContainer.getItems();
		for (Item item: items)
		{
			ItemComposition itemComposition = itemManager.getItemComposition(item.getId());

			if (!itemsContainsName(itemComposition.getName())) {
				inventoryItems.add(itemComposition);
			}
		}
	}

	@Subscribe(priority = -1)
	private void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		System.out.println(npc.getName());

		if (!npcsContainsName(npc.getName())) {
			npcs.add(npc);
		}
	}

	@Subscribe(priority = -1)
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();
		System.out.println(npc.getName());

		npcs.remove(npc);
	}


	private boolean npcsContainsName(String name)
	{
		for (NPC npc: npcs)
		{
			if (name.equals(npc.getName()))
			{
				return true;
			}
		}
		return false;
	}

	private boolean itemsContainsName(String name)
	{
		for (ItemComposition item: inventoryItems)
		{
			if (name.equals(item.getName()))
			{
				return true;
			}
		}
		return false;
	}
}
