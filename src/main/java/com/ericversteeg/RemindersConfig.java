package com.ericversteeg;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;

@ConfigGroup(RemindersConfig.GROUP)
public interface RemindersConfig extends Config
{
	String GROUP = "reminders";
}