package com.gildedrose;

public class AgedBrie extends Item {

    protected void updateQuality(Item item) {

        if (item.sellIn < 0) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }

        item.checkQuality(item);
    }
}
