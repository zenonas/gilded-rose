package com.gildedrose;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GildedRose {
	private enum Types {
		NORMAL("normal", Normal::new),
		AGED_BRIE("Aged Brie", Brie::new),
		CONCERT_PASSES("Backstage passes to a TAFKAL80ETC concert", Backstage::new),
		SULFURAS("Sulfuras, Hand of Ragnaros", BasicItem::new),
		MANA_CAKE("Conjured Mana Cake", Conjured::new);

		private final String name;
		private final Supplier<Item> factory;

		Types(String name, Supplier<Item> factory) {
			this.name = name;
			this.factory = factory;
		}

		static Optional<Item> createByName(String name) {
			return Arrays.stream(values())
					.filter(type -> type.name.equals(name))
					.findAny()
					.map(type -> type.factory.get());
		}
	}

	public static Item createItem(String name, Long quality, Long daysRemaining) {
		return Types.createByName(name).map(item -> {
			item.setDaysRemaining(daysRemaining);
			item.setQuality(quality);
			return item;
		}).orElse(null);
	}
}