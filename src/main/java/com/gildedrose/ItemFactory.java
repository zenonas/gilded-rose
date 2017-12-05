package com.gildedrose;

public class ItemFactory {
    public static Item create(String name, Long quality, Long daysRemaining) {
        switch (name) {
            case "normal":
                return new Normal(quality, daysRemaining);
            case "Aged Brie":
                return new Brie(quality, daysRemaining);
            case "Sulfuras, Hand of Ragnaros":
                return new Item(quality, daysRemaining);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage(quality, daysRemaining);
                default:
                    throw new IllegalArgumentException("I don't know this item");
        }
    }
}
