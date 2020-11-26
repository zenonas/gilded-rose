package com.gildedrose;

public class Backstage extends BasicItem {

	public Backstage(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void onTick() {
		if (getDaysRemaining() < 0) {
			setQuality(0L);
			return;
		}

		increaseQuality(1);
		if (getDaysRemaining() < 10) {
			increaseQuality(1);
		}
		if (getDaysRemaining() < 5) {
			increaseQuality(1);
		}
	}

	@Override
	protected boolean shouldSkip() {
		return getQuality() >= 50;
	}
}
