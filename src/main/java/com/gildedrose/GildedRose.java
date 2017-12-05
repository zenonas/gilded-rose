package com.gildedrose;

public class GildedRose {

    private Item item;

    public Long getQuality() {
    		return item.getQuality();
    }

    public Long getDaysRemaining() {
			return item.getDaysRemaining();
    }


	public GildedRose(String name, Long quality, Long daysRemaining) {
		this.item = ItemFactory.create(name, quality, daysRemaining);
	}

	public void tick() {
    	item.tick();
	}
}