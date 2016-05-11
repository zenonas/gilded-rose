package com.gildedrose;

public interface Item {

	void tick();
	Long getQuality();
	Long getDaysRemaining();
	void setQuality(Long quality);
	void setDaysRemaining(Long daysRemaining);
}