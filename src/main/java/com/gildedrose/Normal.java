package com.gildedrose;

public class Normal  extends  BasicItem{

	@Override
	public void tick() {
		daysRemaining -= 1;
		if (quality == 0) return;

		quality -= 1;
		if (daysRemaining <= 0) quality -= 1;
	}
}