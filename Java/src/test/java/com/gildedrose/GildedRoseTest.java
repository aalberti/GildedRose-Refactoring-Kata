package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void updateQuality_decrementsItemsQualityAndSellInBy1() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("foo");
        assertEquals("foo", item.name);
        assertEquals(0, item.value);
        assertEquals(0, item.sellIn);
    }

    @Test
    public void onceTheSellByDateHasPassed_QualityDegradesTwiceAsFast() throws Exception {
        Item[] items = new Item[] { new Item("bar", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("bar");
        assertEquals("bar", item.name);
        assertEquals(0, item.value);
        assertEquals(-2, item.sellIn);
    }

    @Test
    public void qualityOfAnItemIsNeverNegative() throws Exception {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        Item item = app.getItem("foo");
        assertEquals("foo", item.name);
        assertEquals(0, item.value);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void theQualityOfAnItemIsNeverMoreThan50() throws Exception {
        Item[] items = new Item[] {new AgedBrie(-1, 50), new BackstagePasses(3, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Aged Brie");
        assertEquals("Aged Brie", item.name);
        assertEquals(50, item.value);
        assertEquals(-2, item.sellIn);

        Item item2 = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item2.name);
        assertEquals(50, item2.value);
        assertEquals(2, item2.sellIn);
    }

    @Test
    public void briesQualityIncrementsByOneForEachDayPastItsSellByDate() throws Exception {
        Item[] items = new Item[] { new AgedBrie(-1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Aged Brie");
        assertEquals("Aged Brie", item.name);
        assertEquals(3, item.value);
        assertEquals(-2, item.sellIn);
    }

    @Test
    public void SulfurasBeingALegendaryItemNeverHasToBeSoldOrDecreasesInQuality() throws Exception {
        Item[] items = new Item[] {new Sulfuras(-1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Sulfuras, Hand of Ragnaros");
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
        assertEquals(80, item.value);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void backstagePassesQualityIncrementsByOneWithEachDayPassing() throws Exception {
        Item[] items = new Item[] {new BackstagePasses(11, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(31, item.value);
        assertEquals(10, item.sellIn);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy2WhenThereAre10DaysOrLessRemaining() throws Exception {
        Item[] items = new Item[] {new BackstagePasses(10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(32, item.value);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy3WhenThereAre5DaysOrLessRemaining() throws Exception {
        Item[] items = new Item[] {new BackstagePasses(5, 33)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(36, item.value);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void backstagePassesQualityDropsTo0AfterTheConcert() throws Exception {
        Item[] items = new Item[] {new BackstagePasses(-1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
        assertEquals(0, item.value);
        assertEquals(-2, item.sellIn);
    }

    @Test(expected=RuntimeException.class)
    public void getItem_throwsRuntimeExceptionIfRequestedItemDoesntExist() throws Exception {
        GildedRose app = new GildedRose(new Item[0]);
        app.getItem("foobar");
    }
}