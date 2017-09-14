package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void onceSellDateIsPassed_QualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("normal", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("normal", app.items[0].name);
        assertEquals(items[0].sellIn, -2);
        assertEquals(items[0].quality, 3);
    }

    @Test
    public void qualityCannotBeNegative() {
        Item[] items = new Item[] { new Item("normal", 3, 0), new Item("Conjured", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(items[0].quality, 0);

        assertEquals(items[1].sellIn, -2);
        assertEquals(items[1].quality, 20);
    }


    @Test
    public void agedBrieIncreasesQualityWhenItGetsOlder() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(items[0].sellIn, 1);
        assertEquals(items[0].quality, 1);

        app.updateQuality();
        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 2);
    }

    @Test
    public void agedBrieIncreasesDoubleWhenSellInDateIsPassed() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 3);
    }

    @Test
    public void qualityOfItemIsNeverGreaterThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals(items[0].quality, 50);
    }

    @Test
    public void sulfurasSellInDateAndQualityRemainTheSame() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(items[0].sellIn, 2);
        assertEquals(items[0].quality, 20);
    }

    @Test
    public void backstagePassesQualityIncreaseByOneIfConcertIsMoreThan10DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 14);
        assertEquals(items[0].quality, 21);
    }

    @Test
    public void backstagePassesQualityIncreaseByTwoIfConcertIsLessThan10DaysAwayAndMoreThan5DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 6);
        assertEquals(items[0].quality, 22);
    }

    @Test
    public void backstagePassesQualityIncreaseByThreeIfConcertIsLessThan5DaysAwayAndMoreThan0DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 2);
        assertEquals(items[0].quality, 23);
    }

    @Test
    public void backstagePassesQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 0);
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFastAsNormalItems() {
        Item[] items = new Item[]{new Item("Conjured", 5, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 4);
        assertEquals(items[0].quality, 22);
    }

    @Test
    public void conjuredItemsDegradeTwiceByTwiceAsFastAsNormalItemsAfterSellByDate() {
        Item[] items = new Item[] { new Item("Conjured", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 24);
    }
}
