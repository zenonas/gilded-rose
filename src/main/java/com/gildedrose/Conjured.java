package com.gildedrose;

public class Conjured extends BasicItem {
	public Conjured(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		increaseQuality(-2);
		if (getDaysRemaining() <= 0) {
			increaseQuality(-2);
		}
	}

	@Override
	protected boolean shouldSkip() {
		return getQuality() == 0;
	}
}