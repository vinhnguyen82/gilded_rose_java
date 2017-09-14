package com.gildedrose;

final class Conjured extends Item {

    public void updateQuality(Item item) {
        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality += 4;
        } else {
            item.quality += 2;
        }
        item.checkQuality(item);
    }
}
