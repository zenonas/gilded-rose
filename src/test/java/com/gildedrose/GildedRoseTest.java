package com.gildedrose;

import org.junit.*;

public class GildedRoseTest {

	@Test
	public void testWithNormalItemBeforeSellBuyDate() {
		GildedRose item = new GildedRose("normal", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(9), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithNormalItemOnSellDate() {
		GildedRose item = new GildedRose("normal", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	public void testWithNormalItemPastSellDate() {
		GildedRose item = new GildedRose("normal", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.quality);
		Assert.assertEquals(Long.valueOf(-2), item.daysRemaining);
	}

	@Test
	public void testWithNormalItemQualityOfZero() {
		GildedRose item = new GildedRose("normal", 0L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithAgedBrieBeforeSellDate() {
		GildedRose item = new GildedRose("Aged Brie", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(11), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithAgedBrieBeforeSellDateWithMaxQuality() {
		GildedRose item = new GildedRose("Aged Brie", 50L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithAgedBrieOnSellDate() {
		GildedRose item = new GildedRose("Aged Brie", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	public void testWithAgedBrieOnSellDateWithMaxQuality() {
		GildedRose item = new GildedRose("Aged Brie", 50L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	public void testWithAgedBriePastSellDate() {
		GildedRose item = new GildedRose("Aged Brie", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.quality);
		Assert.assertEquals(Long.valueOf(-2), item.daysRemaining);
	}

	@Test
	public void testWithAgedBriePastSellDateWithMaxQuality() {
		GildedRose item = new GildedRose("Aged Brie", 50L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(-2), item.daysRemaining);
	}

	@Test
	public void testWithSulfurasBeforeSellDate() {
		GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 80L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.quality);
		Assert.assertEquals(Long.valueOf(5), item.daysRemaining);
	}

	@Test
	public void testWithSulfurasOnSellDate() {
		GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 80L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.quality);
		Assert.assertEquals(Long.valueOf(0), item.daysRemaining);
	}

	@Test
	public void testWithSulfurasAfterSellDate() {
		GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 80L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDate() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 11L);
		item.tick();
		Assert.assertEquals(Long.valueOf(11), item.quality);
		Assert.assertEquals(Long.valueOf(10), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDateWithMaxQuality() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50L, 11L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(10), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_MediumCloseToCloseToSellDate() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.quality);
		Assert.assertEquals(Long.valueOf(9), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellDateWithMaxQuality() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50L, 10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(9), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBound() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 6L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.quality);
		Assert.assertEquals(Long.valueOf(5), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBoundMaxQuality() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50L, 6L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(5), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDate() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(13), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateMaxQuality() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBound() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(13), item.quality);
		Assert.assertEquals(Long.valueOf(0), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBoundMaxQuality() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50L, 1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.quality);
		Assert.assertEquals(Long.valueOf(0), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_OnSellDate() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	public void testWithBackStagePasses_PastSellDate() {
		GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(-2), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_BeforeSellDate() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_BeforeSellDateWithZeroQuality() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 0L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(4), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_OnSellDate() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(6), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_OnSellDateAtZeroQuality() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 0L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(-1), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_AfterSellDate() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 10L, -10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(6), item.quality);
		Assert.assertEquals(Long.valueOf(-11), item.daysRemaining);
	}

	@Test
	@Ignore
	public void testWithConjured_AfterSellDateWithZeroQuality() {
		GildedRose item = new GildedRose("Conjured Mana Cake", 0L, -10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.quality);
		Assert.assertEquals(Long.valueOf(-11), item.daysRemaining);
	}

}
