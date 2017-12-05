package com.gildedrose;

public class Item {
    public Item(Long quality, Long daysRemaining) {
        this.quality = quality;
        this.daysRemaining = daysRemaining;
    }

    public Long getQuality() {
        return quality;
    }

    public Long getDaysRemaining() {
        return daysRemaining;
    }

    public void tick() {
    }

    protected Long quality;
    protected Long daysRemaining;

}
