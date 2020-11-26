package com.gildedrose;

public interface Item {
	void tick();
	Long getQuality();
	Long getDaysRemaining();

	@FunctionalInterface
	interface Factory<T extends Item> {
		T create(Long quality, Long daysRemaining);
	}
}