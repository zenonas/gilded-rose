package com.gildedrose;

public interface Item {
	void tick();
	long getQuality();
	long getDaysRemaining();

	@FunctionalInterface
	interface Factory<T extends Item> {
		T create(long quality, long daysRemaining);
	}
}