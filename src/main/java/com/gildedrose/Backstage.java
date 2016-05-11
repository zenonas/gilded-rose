package com.gildedrose;

public class Backstage extends BasicItem {

	@Override
	public void tick() {
		daysRemaining -= 1;
		if (quality >= 50) return;
		if (daysRemaining < 0) { quality = 0L; return; }

		quality += 1;
		if (daysRemaining < 10) quality += 1;
		if (daysRemaining < 5) quality += 1;
	}
}
