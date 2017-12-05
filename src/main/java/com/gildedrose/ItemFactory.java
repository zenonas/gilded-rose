package com.gildedrose;

public class ItemFactory {
    public static Item create(String name, Long quality, Long daysRemaining) {
        Item item;
        switch (name) {
            case "normal":
                item = new Normal();
                break;
            case "Aged Brie":
                item = new Brie();
                break;
            case "Sulfuras, Hand of Ragnaros":
                item = new Item();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item = new Backstage();
                break;
            default:
                throw new IllegalArgumentException("I don't know this item");

        }
        item.setQuality(quality);
        item.setDaysRemaining(daysRemaining);
        return item;
    }
}
