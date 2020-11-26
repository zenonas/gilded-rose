package com.gildedrose;

public class Conjured extends BasicItem {
	public Conjured(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void tick() {
		setDaysRemaining(getDaysRemaining() - 1);
		if (getQuality() == 0) return;

		setQuality(getQuality() - 2);
		if (getDaysRemaining() <= 0) {
			setQuality(getQuality() - 2);
		}
	}
}