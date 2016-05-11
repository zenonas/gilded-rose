package com.gildedrose;

import org.junit.*;

public class GildedRoseTest {

	@Test
	public void testWithNormalItemBeforeSellBuyDate() {
		Item item = GildedRose.createItem("normal", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(9), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemOnSellDate() {
		Item item = GildedRose.createItem("normal", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemPastSellDate() {
		Item item = GildedRose.createItem("normal", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.getQuality());
		Assert.assertEquals(Long.valueOf(-2), item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemQualityOfZero() {
		Item item = GildedRose.createItem("normal", 0L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieBeforeSellDate() {
		Item item = GildedRose.createItem("Aged Brie", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(11), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieBeforeSellDateWithMaxQuality() {
		Item item = GildedRose.createItem("Aged Brie", 50L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieOnSellDate() {
		Item item = GildedRose.createItem("Aged Brie", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieOnSellDateWithMaxQuality() {
		Item item = GildedRose.createItem("Aged Brie", 50L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBriePastSellDate() {
		Item item = GildedRose.createItem("Aged Brie", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.getQuality());
		Assert.assertEquals(Long.valueOf(-2), item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBriePastSellDateWithMaxQuality() {
		Item item = GildedRose.createItem("Aged Brie", 50L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(-2), item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasBeforeSellDate() {
		Item item = GildedRose.createItem("Sulfuras, Hand of Ragnaros", 80L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.getQuality());
		Assert.assertEquals(Long.valueOf(5), item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasOnSellDate() {
		Item item = GildedRose.createItem("Sulfuras, Hand of Ragnaros", 80L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.getQuality());
		Assert.assertEquals(Long.valueOf(0), item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasAfterSellDate() {
		Item item = GildedRose.createItem("Sulfuras, Hand of Ragnaros", 80L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(80), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDate() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 11L);
		item.tick();
		Assert.assertEquals(Long.valueOf(11), item.getQuality());
		Assert.assertEquals(Long.valueOf(10), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDateWithMaxQuality() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 11L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(10), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumCloseToCloseToSellDate() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.getQuality());
		Assert.assertEquals(Long.valueOf(9), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellDateWithMaxQuality() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(9), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBound() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 6L);
		item.tick();
		Assert.assertEquals(Long.valueOf(12), item.getQuality());
		Assert.assertEquals(Long.valueOf(5), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBoundMaxQuality() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 6L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(5), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDate() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(13), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateMaxQuality() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBound() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(13), item.getQuality());
		Assert.assertEquals(Long.valueOf(0), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBoundMaxQuality() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(50), item.getQuality());
		Assert.assertEquals(Long.valueOf(0), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_OnSellDate() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_PastSellDate() {
		Item item = GildedRose.createItem("Backstage passes to a TAFKAL80ETC concert", 10L, -1L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(-2), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_BeforeSellDate() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 10L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(8), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_BeforeSellDateWithZeroQuality() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 0L, 5L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(4), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_OnSellDate() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 10L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(6), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_OnSellDateAtZeroQuality() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 0L, 0L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(-1), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_AfterSellDate() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 10L, -10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(6), item.getQuality());
		Assert.assertEquals(Long.valueOf(-11), item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_AfterSellDateWithZeroQuality() {
		Item item = GildedRose.createItem("Conjured Mana Cake", 0L, -10L);
		item.tick();
		Assert.assertEquals(Long.valueOf(0), item.getQuality());
		Assert.assertEquals(Long.valueOf(-11), item.getDaysRemaining());
	}

}
