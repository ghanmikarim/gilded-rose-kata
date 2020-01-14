package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;

class ItemServiceUtils {

    public static void denoteItemForOneDay(Item item) {

            ItemFactory.getItemService(item).updateQuality(item);
    }

    public static void denoteItemsForOneDays(Item[] items) {
        if (items != null) {
            for (Item item : items) {
                denoteItemForOneDay(item);
            }
        }
    }

    public static void denoteItemFor10Days(Item item) {

        for (int i = 0; i < 10; i++) {
            ItemFactory.getItemService(item).updateQuality(item);
        }
    }

    public static void denoteItemsFor10Days(Item[] items) {
        if (items != null) {
            for (Item item : items) {
                denoteItemFor10Days(item);
            }
        }
    }
}