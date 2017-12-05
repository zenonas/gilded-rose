package com.gildedrose;

public class Conjured extends Item {
    public void tick() {
        quality -= 2;
        if (daysRemaining <= 0) {
            quality -= 2;
        }
        daysRemaining -=1;
        if (quality < 0) {
            quality = 0L;
        }
    }
}
