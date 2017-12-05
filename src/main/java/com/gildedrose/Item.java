package com.gildedrose;

public class Item {
    public Item() {

    }
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

    void setQuality(Long quality) {
        this.quality = quality;
    }

    void setDaysRemaining(Long daysRemaining) {
        this.daysRemaining = daysRemaining;
    }

    protected Long quality;
    protected Long daysRemaining;

}
