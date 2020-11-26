package com.gildedrose;

import java.util.Arrays;
import java.util.Optional;

enum ItemTypes {
    NORMAL("normal", Normal::new),
    AGED_BRIE("Aged Brie", Brie::new),
    CONCERT_PASSES("Backstage passes to a TAFKAL80ETC concert", Backstage::new),
    SULFURAS("Sulfuras, Hand of Ragnaros", ImmutableItem::new),
    MANA_CAKE("Conjured Mana Cake", Conjured::new);

    private final String name;
    private final Item.Factory<? extends Item> factory;

    ItemTypes(String name, Item.Factory<? extends Item> factory) {
        this.name = name;
        this.factory = factory;
    }

    static Optional<Item.Factory<? extends Item>> createByName(String name) {
        return Arrays.stream(values())
                .filter(type -> type.name.equals(name))
                .findAny()
                .map(type -> type.factory);
    }
}
