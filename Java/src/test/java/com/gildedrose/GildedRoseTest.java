package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void updateQuality_decrementsItemsQualityAndSellInBy1() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("foo");
        assertEquals("foo", item.getName());
        assertEquals(0, item.getValue());
        assertEquals(0, item.getSellIn());
    }

    @Test
    public void onceTheSellByDateHasPassed_QualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("bar", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("bar");
        assertEquals("bar", item.getName());
        assertEquals(0, item.getValue());
        assertEquals(-2, item.getSellIn());
    }

    @Test
    public void qualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        app.nextDay();
        app.nextDay();
        Item item = app.getItem("foo");
        assertEquals("foo", item.getName());
        assertEquals(0, item.getValue());
        assertEquals(-1, item.getSellIn());
    }

    @Test
    public void theQualityOfAnItemIsNeverMoreThan50() {
        Item[] items = new Item[] {new AgedBrie(-1, 50), new BackstagePasses(3, 49) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Aged Brie");
        assertEquals("Aged Brie", item.getName());
        assertEquals(50, item.getValue());
        assertEquals(-2, item.getSellIn());

        Item item2 = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item2.getName());
        assertEquals(50, item2.getValue());
        assertEquals(2, item2.getSellIn());
    }

    @Test
    public void briesQualityIncrementsByOneForEachDayPastItsSellByDate() {
        Item[] items = new Item[] {new AgedBrie(-1, 1)};
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Aged Brie");
        assertEquals("Aged Brie", item.getName());
        assertEquals(3, item.getValue());
        assertEquals(-2, item.getSellIn());
    }

    @Test
    public void SulfurasBeingALegendaryItemNeverHasToBeSoldOrDecreasesInQuality() {
        Item[] items = new Item[] { new Sulfuras(-1, 80) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Sulfuras, Hand of Ragnaros");
        assertEquals("Sulfuras, Hand of Ragnaros", item.getName());
        assertEquals(80, item.getValue());
        assertEquals(-1, item.getSellIn());
    }

    @Test
    public void backstagePassesQualityIncrementsByOneWithEachDayPassing() {
        Item[] items = new Item[] { new BackstagePasses(11, 30) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.getName());
        assertEquals(31, item.getValue());
        assertEquals(10, item.getSellIn());
    }

    @Test
    public void backstagePassesIncreaseInQualityBy2WhenThereAre10DaysOrLessRemaining() {
        Item[] items = new Item[] { new BackstagePasses(10, 30) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.getName());
        assertEquals(32, item.getValue());
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void backstagePassesIncreaseInQualityBy3WhenThereAre5DaysOrLessRemaining() {
        Item[] items = new Item[] { new BackstagePasses(5, 33) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.getName());
        assertEquals(36, item.getValue());
        assertEquals(4, item.getSellIn());
    }

    @Test
    public void backstagePassesQualityDropsTo0AfterTheConcert() {
        Item[] items = new Item[] { new BackstagePasses(-1, 30) };
        GildedRose app = new GildedRose(items);
        app.nextDay();
        Item item = app.getItem("Backstage passes to a TAFKAL80ETC concert");
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.getName());
        assertEquals(0, item.getValue());
        assertEquals(-2, item.getSellIn());
    }

    @Test(expected=RuntimeException.class)
    public void getItem_throwsRuntimeExceptionIfRequestedItemDoesntExist() {
        GildedRose app = new GildedRose(new Item[0]);
        app.getItem("foobar");
    }
}