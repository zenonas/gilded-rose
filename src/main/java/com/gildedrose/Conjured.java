package com.gildedrose;

public class Conjured extends BasicItem {
	public Conjured(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		if (getQuality() == 0) return;

		increaseQuality(-2);
		if (getDaysRemaining() <= 0) {
			increaseQuality(-2);
		}
	}
}