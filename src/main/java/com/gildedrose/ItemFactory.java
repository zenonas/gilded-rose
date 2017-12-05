package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private static Map<String, String> classMap = new HashMap<>();

    static {
        classMap.put("normal", "com.gildedrose.Normal");
        classMap.put("Aged Brie", "com.gildedrose.Brie");
        classMap.put("Sulfuras, Hand of Ragnaros", "com.gildedrose.Item");
        classMap.put("Backstage passes to a TAFKAL80ETC concert", "com.gildedrose.Backstage");
    }

    public static Item create(String name, Long quality, Long daysRemaining) {
        Item item;
        try {
            item = (Item) Class.forName(classMap.get(name)).newInstance();
            item.setQuality(quality);
            item.setDaysRemaining(daysRemaining);

        } catch (InstantiationException e) {
            throw new IllegalArgumentException("I don't know this item");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("I don't know this item");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Class not implemented");
        }
        return item;
    }
}
