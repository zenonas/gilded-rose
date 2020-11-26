package com.gildedrose;

public class Brie extends BasicItem {

	public Brie(Long quality, Long daysRemaining) {
		super(quality, daysRemaining);
	}

	@Override
	public void tick() {
		setDaysRemaining(getDaysRemaining() - 1);
		if (getQuality() >= 50) return;

		setQuality(getQuality() + 1);
		if (getDaysRemaining() <= 0) {
			setQuality(getQuality() + 1);
		}
	}
}
