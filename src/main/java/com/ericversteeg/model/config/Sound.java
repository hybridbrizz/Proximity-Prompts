package com.ericversteeg.model.config;

public enum Sound {
    NONE(0),
    UI_BOOP(2266),
    GE_INCREMENT_PLOP(3929),
    GE_DECREMENT_PLOP(3930),
    GE_ADD_OFFER_DINGALING(3925),
    GE_COLLECT_BLOOP(3928),
    GE_COIN_TINKLE(3924),
    CLOSE_DOOR(60),
    OPEN_DOOR(62),
    ITEM_DROP(2739),
    ITEM_PICKUP(2582),
    PICK_PLANT_BLOOP(2581);

    private int id;

    Sound(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}
