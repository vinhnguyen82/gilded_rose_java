package com.gildedrose;

interface Item {

    void updateDate(Item item);

    void updateQuality(Item item);

    void checkQuality(Item item);

    String getName();

    int getDate();

    int getQuality();

    void setName(String name);

    void setDate(int sellInDate);

    void setQuality(int quality);
}
