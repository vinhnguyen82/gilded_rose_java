package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item() {
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item checkQuality(Item item) {

        item.quality = min(50, item.quality);
        item.quality = max(0, item.quality);

        return item;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
