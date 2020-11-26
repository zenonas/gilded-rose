package com.gildedrose;

public class GildedRose {
	public static Item createItem(String name, long quality, long daysRemaining) {
		return ItemTypes.createByName(name)
				.map(factory -> factory.create(quality, daysRemaining))
				.orElse(null);
	}
}