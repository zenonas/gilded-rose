package com.gildedrose;

public class Brie extends BasicItem {

	public Brie(long quality, long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		increaseQuality(1);
		if (getDaysRemaining() <= 0) {
			increaseQuality(1);
		}
	}

	@Override
	protected boolean shouldSkip() {
		return getQuality() >= 50;
	}
}
