package com.gildedrose;

final class Backstage extends Item {

    protected void updateQuality(Item item) {

        if (item.sellIn >= 10) {
            item.quality += 1;
        } else if (item.sellIn >= 5) {
            item.quality += 2;
        } else if (item.sellIn >= 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        item.checkQuality(item);
    }
}
