package com.gildedrose;

public class ImmutableItem implements Item {
    private final long quantity;
    private final long daysRemaining;

    public ImmutableItem(long quantity, long daysRemaining) {
        this.quantity = quantity;
        this.daysRemaining = daysRemaining;
    }

    @Override
    public void tick() {

    }

    @Override
    public long getQuality() {
        return quantity;
    }

    @Override
    public long getDaysRemaining() {
        return daysRemaining;
    }
}
