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

	public void setDaysRemaining(Long daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public static final class DoNothing extends BasicItem {
		public DoNothing(Long quality, Long daysRemaining) {
			super(quality, daysRemaining);
		}

		@Override
		public void tick() {}
	}
}
