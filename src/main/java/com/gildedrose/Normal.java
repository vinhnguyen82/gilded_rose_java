package com.gildedrose;

final class Normal extends  Item {

    public void updateQuality(Item item) {
        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality -= 2;
        } else {
            item.quality -= 1;
        }
        item.checkQuality(item);
    }
}