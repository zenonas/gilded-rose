package com.gildedrose;

public class Brie extends Item {
    public void tick() {
        if (daysRemaining <= 0) {
            quality +=1;
        }
        daysRemaining -= 1;
        quality +=1;
        if (getQuality() > 50) {
            quality = 50L;
        }
    }
}
