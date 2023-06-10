package com.ericversteeg.config;

public enum TimeUnit {
    SECONDS(0),
    MINUTES(1);

    private int type;

    TimeUnit(int type) {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }
}
