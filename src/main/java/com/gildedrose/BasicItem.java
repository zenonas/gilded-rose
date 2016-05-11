package com.gildedrose;

public class BasicItem implements Item {

	protected Long quality;
	protected Long daysRemaining;

	public Long getQuality() {
		return quality;
	}

	public Long getDaysRemaining() {
		return daysRemaining;
	}

	public void setQuality(Long quality) {
		this.quality = quality;
	}

	public void setDaysRemaining(Long daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public void tick() {
	}
}
