package com.gildedrose;

public abstract class BasicItem implements Item {
	private long quality;
	private long daysRemaining;

	public BasicItem(long quality, long daysRemaining) {
		this.quality = quality;
		this.daysRemaining = daysRemaining;
	}

	public long getQuality() {
		return quality;
	}

	public long getDaysRemaining() {
		return daysRemaining;
	}

	public void setQuality(long quality) {
		this.quality = quality;
	}

	public void increaseQuality(long amount) {
		quality += amount;
	}

	@Override
	public void tick() {
		daysRemaining -= 1;
		if (shouldSkip()) {
			return;
		}
		onTick();
	}

	protected abstract void onTick();
	protected abstract boolean shouldSkip();
}
