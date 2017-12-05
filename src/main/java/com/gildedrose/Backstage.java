package com.gildedrose;

public class Backstage extends Item {
    public void tick() {
        quality +=1;
        if (daysRemaining <= 10) {
            quality+=1;
        }
        if (daysRemaining <= 5) {
            quality+=1;
        }
        if (daysRemaining <= 0) {
            quality=0L;
        }
        if (getQuality() > 50) {
            quality = 50L;
        }
        daysRemaining -= 1;
    }
}
