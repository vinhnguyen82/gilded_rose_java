package com.gildedrose;

final class Conjured extends Item {

    public Item updateQuality(Item item) {

        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality += 4;
        } else {
            item.quality += 2;
        }

        item.checkQuality(item);

        return item;

    }
}
