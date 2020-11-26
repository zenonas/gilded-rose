package com.gildedrose;

public class Brie extends BasicItem {

	public Brie(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		if (getQuality() >= 50) return;

		increaseQuality(1);
		if (getDaysRemaining() <= 0) {
			increaseQuality(1);
		}
	}
}
