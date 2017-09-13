package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            String itemName = item.name;

            switch (itemName) {
                case "Aged Brie":
                    AgedBrie agedBrie = new AgedBrie();
                    agedBrie.updateQuality(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    Backstage backstage = new Backstage();
                    backstage.updateQuality(item);
                    break;
                case "Conjured":
                    Conjured conjured = new Conjured();
                    conjured.updateQuality(item);
                    break;
                default:
                    Normal normal = new Normal();
                    normal.updateQuality(item);
                    break;
            }
        }
    }
}