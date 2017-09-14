package com.gildedrose;

final class Conjured extends Item {

    protected void updateQuality(Item item) {

        if (item.sellIn < 0) {
            item.quality += 4;
        } else {
            item.quality += 2;
        }
        item.checkQuality(item);
    }
}
