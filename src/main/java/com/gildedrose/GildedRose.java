package com.gildedrose;

public class GildedRose {

    private String name;
    private Long quality;
    private Long daysRemaining;

    public String getName() {
        return name;
    }

    public Long getQuality() {
        return quality;
    }

    public Long getDaysRemaining() {
        return daysRemaining;
    }


	public GildedRose(String name, Long quality, Long daysRemaining) {
		this.name = name;
		this.quality = quality;
		this.daysRemaining = daysRemaining;
	}

	public void tick() {
    	if (getName().equals("normal")) {
    		tick_normal();
    		return;
		}
		if (getName().equals("Aged Brie")) {
    		tick_brie();
			return;
		}
		if (getName().equals("Sulfuras, Hand of Ragnaros")) {
			return;
		}
		if (getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			tick_backstage();
			return;
		}
	}

	private void tick_backstage() {
		quality +=1;
		if (daysRemaining <= 10) {
			quality+=1;
		}
		if (daysRemaining <= 5) {
			quality+=1;
		}
		if (daysRemaining <= 0) {
			quality=0L;
		}
		if (getQuality() > 50) {
			quality = 50L;
		}
		daysRemaining -= 1;
	}

	private void tick_brie() {
    	if (daysRemaining <= 0) {
			quality +=1;
		}
		daysRemaining -= 1;
		quality +=1;
		if (getQuality() > 50) {
			quality = 50L;
		}
	}

	private void tick_normal() {
		daysRemaining -= 1;
		quality -= 1;
		if (getDaysRemaining() <= 0) {
			quality -= 1;;
		}
		if (quality < 0) {
			quality = 0L;
		}
	}
}