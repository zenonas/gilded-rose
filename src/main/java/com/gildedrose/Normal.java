package com.gildedrose;

public class Normal extends BasicItem {
	public Normal(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		increaseQuality(-1);
		if (getDaysRemaining() <= 0) {
			increaseQuality(-1);
		}
	}

	@Override
	protected boolean shouldSkip() {
		return getQuality() == 0;
	}
}