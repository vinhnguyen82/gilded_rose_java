package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

class Sulfuras implements Item {
    String name;
    int sellIn;
    int quality;

    public Sulfuras (String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality(Item item) {

        if (sellIn < 0) {
            quality -= 2;
        } else {
            quality -= 1;
        }
        item.checkQuality(item);
    }

    public void updateDate(Item item) {
        sellIn -= 1;
    }

    public void checkQuality(Item item) {
        quality = min(50, quality);
        quality = max(0, quality);
    }

    public String getName() {
        return this.name;
    }

    public int getDate() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int sellInDate) {
        this.sellIn = sellInDate;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
