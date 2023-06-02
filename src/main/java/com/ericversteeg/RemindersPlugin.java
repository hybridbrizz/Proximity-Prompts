package com.ericversteeg;

import com.google.gson.Gson;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

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

	ZoneOffset zoneOffset = ZoneId.systemDefault()
		.getRules()
		.getOffset(
			LocalDate.now()
				.atStartOfDay()
		);

	LocalDateTime lastDateTime = null;

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

	}
}
