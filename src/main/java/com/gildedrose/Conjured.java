package com.gildedrose;

public class Conjured extends BasicItem {

	@Override
	public void tick() {
		daysRemaining -= 1;
		if (quality == 0) return;

		quality -= 2;
		if (daysRemaining <= 0) { quality -= 2; }
	}
}