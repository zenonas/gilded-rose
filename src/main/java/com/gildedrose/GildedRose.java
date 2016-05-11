package com.gildedrose;

public class GildedRose {

	public String name;
	public Long quality;
	public Long daysRemaining;

	public GildedRose(String name, Long quality, Long daysRemaining) {
		this.name = name;
		this.quality = quality;
		this.daysRemaining = daysRemaining;
	}

	public void tick() {
		if ((name != "Aged Brie") && (name != "Backstage passes to a TAFKAL80ETC concert")) {
			if (quality > 0) {
				if (name != "Sulfuras, Hand of Ragnaros") {
					quality -= 1;
				}
			}
		}
		else {
			if (quality < 50) {
				quality += 1;
				if (name == "Backstage passes to a TAFKAL80ETC concert") {
					if (daysRemaining < 11) {
						if (quality < 50) {
							quality += 1;
						}
					}
					if (daysRemaining < 6) {
						if (quality < 50) {
							quality += 1;
						}
					}
				}
			}
		}
		if (name != "Sulfuras, Hand of Ragnaros") {
			daysRemaining -= 1;
		}
		if (daysRemaining < 0) {
			if (name != "Aged Brie") {
				if (name != "Backstage passes to a TAFKAL80ETC concert") {
					if (quality > 0) {
						if (name != "Sulfuras, Hand of Ragnaros") {
							quality -= 1;
						}
					}
				}
				else {
					quality = quality - quality;
				}
			}
			else {
				if (quality < 50) {
					quality += 1;
				}
			}
		}
	}
}