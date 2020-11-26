package com.gildedrose;

public abstract class BasicItem implements Item {
	private Long quality;
	private Long daysRemaining;

	public BasicItem(Long quality, Long daysRemaining) {
		this.quality = quality;
		this.daysRemaining = daysRemaining;
	}

	public Long getQuality() {
		return quality;
	}

	public Long getDaysRemaining() {
		return daysRemaining;
	}

	public void setQuality(Long quality) {
		this.quality = quality;
	}

	@Override
	public void tick() {
		daysRemaining -= 1;
		onTick();
	}

	protected abstract void onTick();
}
