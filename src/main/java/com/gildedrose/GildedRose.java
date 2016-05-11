package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {

	private static final Map<String, Class> itemTypes = new HashMap<String, Class>() {
		{
			put("normal", Normal.class);
			put("Aged Brie", Brie.class);
			put("Backstage passes to a TAFKAL80ETC concert", Backstage.class);
			put("Sulfuras, Hand of Ragnaros", BasicItem.class);
			put("Conjured Mana Cake", Conjured.class);
		}
	};

	public static Item createItem(String name, Long quality, Long daysRemaining) {
		Class klass = (itemTypes.get(name) != null) ? itemTypes.get(name) : BasicItem.class;
		try {
			Item item = (Item) klass.newInstance();
			item.setDaysRemaining(daysRemaining);
			item.setQuality(quality);
			return item;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}