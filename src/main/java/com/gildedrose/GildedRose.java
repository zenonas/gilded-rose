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
		SULFURAS("Sulfuras, Hand of Ragnaros", ImmutableItem::new),
		MANA_CAKE("Conjured Mana Cake", Conjured::new);

		private final String name;
		private final ItemFactory<? extends Item> factory;

		Types(String name, ItemFactory<? extends Item> factory) {
			this.name = name;
			this.factory = factory;
		}

		static Optional<ItemFactory<? extends Item>> createByName(String name) {
			return Arrays.stream(values())
					.filter(type -> type.name.equals(name))
					.findAny()
					.map(type -> type.factory);
		}
	}

	public static Item createItem(String name, Long quality, Long daysRemaining) {
		return Types.createByName(name)
				.map(factory -> factory.create(quality, daysRemaining))
				.orElse(null);
	}

	@FunctionalInterface
	interface ItemFactory<T extends Item> {
		T create(Long quality, Long daysRemaining);
	}
}