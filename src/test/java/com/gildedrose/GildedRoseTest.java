package com.gildedrose;

import org.junit.*;

import static com.gildedrose.GildedRose.createItem;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

	@Test
	public void testWithNormalItemBeforeSellBuyDate() {
		Item item = createItem("normal", 10L, 5L);
		item.tick();
		assertEquals(9, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemOnSellDate() {
		Item item = createItem("normal", 10L, 0L);
		item.tick();
		assertEquals(8, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemPastSellDate() {
		Item item = createItem("normal", 10L, -1L);
		item.tick();
		assertEquals(8, item.getQuality());
		assertEquals(-2, item.getDaysRemaining());
	}

	@Test
	public void testWithNormalItemQualityOfZero() {
		Item item = createItem("normal", 0L, 5L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieBeforeSellDate() {
		Item item = createItem("Aged Brie", 10L, 5L);
		item.tick();
		assertEquals(11, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieBeforeSellDateWithMaxQuality() {
		Item item = createItem("Aged Brie", 50L, 5L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieOnSellDate() {
		Item item = createItem("Aged Brie", 10L, 0L);
		item.tick();
		assertEquals(12, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBrieOnSellDateWithMaxQuality() {
		Item item = createItem("Aged Brie", 50L, 0L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBriePastSellDate() {
		Item item = createItem("Aged Brie", 10L, -1L);
		item.tick();
		assertEquals(12, item.getQuality());
		assertEquals(-2, item.getDaysRemaining());
	}

	@Test
	public void testWithAgedBriePastSellDateWithMaxQuality() {
		Item item = createItem("Aged Brie", 50L, -1L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(-2, item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasBeforeSellDate() {
		Item item = createItem("Sulfuras, Hand of Ragnaros", 80L, 5L);
		item.tick();
		assertEquals(80, item.getQuality());
		assertEquals(5, item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasOnSellDate() {
		Item item = createItem("Sulfuras, Hand of Ragnaros", 80L, 0L);
		item.tick();
		assertEquals(80, item.getQuality());
		assertEquals(0, item.getDaysRemaining());
	}

	@Test
	public void testWithSulfurasAfterSellDate() {
		Item item = createItem("Sulfuras, Hand of Ragnaros", 80L, -1L);
		item.tick();
		assertEquals(80, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDate() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 11L);
		item.tick();
		assertEquals(11, item.getQuality());
		assertEquals(10, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_LongBeforeSellDateWithMaxQuality() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 11L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(10, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumCloseToCloseToSellDate() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 10L);
		item.tick();
		assertEquals(12, item.getQuality());
		assertEquals(9, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellDateWithMaxQuality() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 10L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(9, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBound() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 6L);
		item.tick();
		assertEquals(12, item.getQuality());
		assertEquals(5, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_MediumToCloseSellLowerBoundMaxQuality() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 6L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(5, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDate() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 5L);
		item.tick();
		assertEquals(13, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateMaxQuality() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 5L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBound() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 1L);
		item.tick();
		assertEquals(13, item.getQuality());
		assertEquals(0, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_VeryCloseToSellDateLowerBoundMaxQuality() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 50L, 1L);
		item.tick();
		assertEquals(50, item.getQuality());
		assertEquals(0, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_OnSellDate() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, 0L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithBackStagePasses_PastSellDate() {
		Item item = createItem("Backstage passes to a TAFKAL80ETC concert", 10L, -1L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(-2, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_BeforeSellDate() {
		Item item = createItem("Conjured Mana Cake", 10L, 5L);
		item.tick();
		assertEquals(8, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_BeforeSellDateWithZeroQuality() {
		Item item = createItem("Conjured Mana Cake", 0L, 5L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(4, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_OnSellDate() {
		Item item = createItem("Conjured Mana Cake", 10L, 0L);
		item.tick();
		assertEquals(6, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_OnSellDateAtZeroQuality() {
		Item item = createItem("Conjured Mana Cake", 0L, 0L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(-1, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_AfterSellDate() {
		Item item = createItem("Conjured Mana Cake", 10L, -10L);
		item.tick();
		assertEquals(6, item.getQuality());
		assertEquals(-11, item.getDaysRemaining());
	}

	@Test
	public void testWithConjured_AfterSellDateWithZeroQuality() {
		Item item = createItem("Conjured Mana Cake", 0L, -10L);
		item.tick();
		assertEquals(0, item.getQuality());
		assertEquals(-11, item.getDaysRemaining());
	}

}
