package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void onceSellDateIsPassed_QualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Normal("Normal", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Normal", app.items[0].getName());
        assertEquals(items[0].getDate(), -2);
        assertEquals(items[0].getQuality(), 3);

    }

    @Test
    public void qualityCannotBeNegative() {
        Item[] items = new Item[]{new Normal("Normal", 3, 0), new Conjured("Conjured", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(items[0].getQuality(), 0);

        assertEquals(items[1].getDate(), -2);
        assertEquals(items[1].getQuality(), 20);
    }


    @Test
    public void agedBrieIncreasesQualityWhenItGetsOlder() {
        Item[] items = new Item[]{new AgedBrie("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(items[0].getDate(), 1);
        assertEquals(items[0].getQuality(), 1);


        app.updateQuality();
        assertEquals(items[0].getDate(), 0);
        assertEquals(items[0].getQuality(), 2);
    }

    @Test
    public void agedBrieIncreasesDoubleWhenSellInDateIsPassed() {
        Item[] items = new Item[]{new AgedBrie("Aged Brie", 0, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(items[0].getDate(), -1);
        assertEquals(items[0].getQuality(), 3);
    }

    @Test
    public void qualityOfItemIsNeverGreaterThan50() {
        Item[] items = new Item[]{new AgedBrie("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals(items[0].getQuality(), 50);
    }

    @Test
    public void sulfurasSellInDateAndQualityRemainTheSame() {
        Item[] items = new Item[]{new Sulfuras("Sulfuras", 2, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(items[0].getDate(), -1);
        assertEquals(items[0].getQuality(), 16);
    }

    @Test
    public void backstagePassesQualityIncreaseByOneIfConcertIsMoreThan10DaysAway() {
        Item[] items = new Item[]{new Backstage("Backstage", 2, 20), new Normal("Normal", 0, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(items[0].getDate(), -1);
        assertEquals(items[0].getQuality(), 0);

        assertEquals(items[1].getDate(), -3);
        assertEquals(items[1].getQuality(), 44);
    }

    @Test
    public void backstagePassesQualityIncreaseByTwoIfConcertIsLessThan10DaysAwayAndMoreThan5DaysAway() {
        Item[] items = new Item[]{new Backstage("Backstage", 7, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].getDate(), 6);
        assertEquals(items[0].getQuality(), 22);
    }

    @Test
    public void backstagePassesQualityIncreaseByThreeIfConcertIsLessThan5DaysAwayAndMoreThan0DaysAway() {
        Item[] items = new Item[]{new Backstage("Backstage", 3, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].getDate(), 2);
        assertEquals(items[0].getQuality(), 23);
    }

    @Test
    public void backstagePassesQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[]{new Backstage("Backstage", 0, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].getDate(), -1);
        assertEquals(items[0].getQuality(), 0);
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFastAsNormalItems() {
        Item[] items = new Item[]{new Conjured("Conjured", 5, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].getDate(), 4);
        assertEquals(items[0].getQuality(), 22);
    }

    @Test
    public void conjuredItemsDegradeTwiceByTwiceAsFastAsNormalItemsAfterSellByDate() {
        Item[] items = new Item[]{new Conjured("Conjured", 0, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].getDate(), -1);
        assertEquals(items[0].getQuality(), 24);
    }
}
