package com.ericversteeg.reminder;

import com.google.gson.annotations.SerializedName;

import java.awt.*;

public class Reminder {

    public static int TIME_UNIT_SECONDS = 0;
    public static int TIME_UNIT_MINUTES = 1;

    public int id;

    public long posted = 0L;

    @SerializedName("enable")
    public boolean enable = false;

    @SerializedName("force_show")
    public boolean forceShow = false;

    @SerializedName("duration")
    public int duration = 0;

    @SerializedName("cooldown")
    public int cooldown = 0;

    @SerializedName("timeunit")
    public int timeUnit = 0;

    @SerializedName("notify")
    public boolean notify = false;

    public long lastNotified;

    public boolean active = true;

    @SerializedName("text")
    public String text = "";

    @SerializedName("color")
    public String colorStr = "";

    public Color colur;

    @SerializedName("times")
    public String times = "";

    @SerializedName("days_of_week")
    public String daysOfWeek = "";

    @SerializedName("dates")
    public String dates = "";

    @SerializedName("coordinates")
    public String coordinates = "";

    @SerializedName("radius")
    public int radius = 0;

    @SerializedName("geofences")
    public String geoFences = "";

    @SerializedName("region_ids")
    public String regionIds = "";

    @SerializedName("npc_ids")
    public String npcIds = "";

    @SerializedName("item_ids")
    public String itemIds = "";

    @SerializedName("chat_patterns")
    public String chatPatterns = "";

    public int savedCount = 0;

    public long getDurationMillis() {
        if (timeUnit == TIME_UNIT_SECONDS)
        {
            return duration * 1000L;
        }
        else if (timeUnit == TIME_UNIT_MINUTES)
        {
            return duration * 60 * 1000L;
        }
        else
        {
            return 0L;
        }
    }

    public long getCooldownMillis() {
        if (timeUnit == TIME_UNIT_SECONDS)
        {
            return cooldown * 1000L;
        }
        else if (timeUnit == TIME_UNIT_MINUTES)
        {
            return cooldown * 60 * 1000L;
        }
        else
        {
            return 0L;
        }
    }
}
