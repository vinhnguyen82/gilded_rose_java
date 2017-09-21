package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).filter(item -> null != item).forEach(this::doStuff);
//                switch (itemName) {
//                    case "Aged Brie":
//                        AgedBrie agedBrie = new AgedBrie();
//                        agedBrie.updateDate(item);
//                        agedBrie.updateQuality(item);
//                        break;
//                    case "Sulfuras":
//                        break;
//                    case "Backstage":
//                        Backstage backstage = new Backstage();
//                        backstage.updateDate(item);
//                        backstage.updateQuality(item);
//                        break;
//                    case "Conjured":
//                        Conjured conjured = new Conjured();
//                        conjured.updateDate(item);
//                        conjured.updateQuality(item);
//                        break;
//                    default:
//                        Normal normal = new Normal();
//                        normal.updateDate(item);
//                        normal.updateQuality(item);
//                        break;
//                }
//        }
    }

    public void doStuff(Item item) {

        item.updateDate(item);
        item.updateQuality(item);

//        String name = item.getName();
//        String className = "com.gildedrose." + name;
//        int sellIn = item.getDate();
//        int quality = item.getQuality();
//        try {
//            Class<?> clazz = Class.forName(className);
//            Constructor<?> ctor = clazz.getConstructor(String.class, int.class, int.class);
//            Object object = ctor.newInstance(name, sellIn, quality);
//
//
//            Method[] methods = clazz.getDeclaredMethods();
//
//            Arrays.stream(methods).filter(method -> null != method ).forEach(System.out::println);
//            for (Method method : methods) {
//                if (method.getName() == "updateDate") {
//                    System.out.println(item.toString());
//                    item.updateDate(item);
//                    System.out.println(item.toString());
//                }
//                System.out.println(method.getName());
//            }
//
//            System.out.println(object.toString());
//
//        } catch (Exception e) {
//            System.out.println("Exception occurs: " + e);
//        }
    }
}