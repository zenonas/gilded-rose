package com.gildedrose;

public class Normal extends Item {
    public void tick() {
        daysRemaining -= 1;
        quality -= 1;
        if (getDaysRemaining() <= 0) {
            quality -= 1;;
        }
        if (quality < 0) {
            quality = 0L;
        }
    }
}
