package com.gildedrose;

public class Backstage extends BasicItem {

	public Backstage(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void tick() {
		setDaysRemaining(getDaysRemaining() - 1);
		if (getQuality() >= 50) return;
		if (getDaysRemaining() < 0) {
			setQuality(0L);
			return;
		}

		setQuality(getQuality() + 1);
		if (getDaysRemaining() < 10) {
			setQuality(getQuality() + 1);
		}
		if (getDaysRemaining() < 5) {
			setQuality(getQuality() + 1);
		}
	}
}
