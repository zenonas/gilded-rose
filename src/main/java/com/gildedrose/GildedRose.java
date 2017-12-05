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
		if (!getName().equals("Aged Brie") && !getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (getQuality() > 0) {
				if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
					quality -= 1;
				}
			}
		}
		else {
			if (getQuality() < 50) {
				quality += 1;
				if (getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (getDaysRemaining() < 11) {
						if (getQuality() < 50) {
							quality += 1;
						}
					}
					if (getDaysRemaining() < 6) {
						if (getQuality() < 50) {
							quality += 1;
						}
					}
				}
			}
		}
		if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
			daysRemaining -= 1;
		}
		if (getDaysRemaining() < 0) {
			if (!getName().equals("Aged Brie")) {
				if (!getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (getQuality() > 0) {
						if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
							quality -= 1;
						}
					}
				}
				else {
					quality = quality - quality;
				}
			}
			else {
				if (getQuality() < 50) {
					quality += 1;
				}
			}
		}
	}

	private void tick_normal() {
		daysRemaining -= 1;

		if (getQuality() == 0) {
			return;
		}
		quality -= 1;
		if (getDaysRemaining() <= 0) {
			if (getQuality() > 0) {
				quality -= 1;;
			}
		}
	}
}