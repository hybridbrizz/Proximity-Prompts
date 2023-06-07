package com.ericversteeg.reminder;

import com.google.gson.annotations.SerializedName;

import java.awt.*;

public class Reminder {

    public int id;

    public long posted = 0L;

    @SerializedName("enable")
    public boolean enable = false;

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

    @SerializedName("geo_fences")
    public String geoFences = "";

    @SerializedName("region_ids")
    public String regionIds = "";

    @SerializedName("npc_ids")
    public String npcIds = "";

    @SerializedName("item_ids")
    public String itemIds = "";
}
