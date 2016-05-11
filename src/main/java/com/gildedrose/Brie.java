package com.gildedrose;

public class Brie extends BasicItem {

	@Override
	public void tick() {
		daysRemaining -= 1;
		if (quality >= 50) return;

		quality += 1;
		if (daysRemaining <= 0) quality += 1;
	}
}
