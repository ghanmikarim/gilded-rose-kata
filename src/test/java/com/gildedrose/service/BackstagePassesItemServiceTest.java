package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesItemServiceTest {
    @Test
    void calculateNewQuality() {
        Item[] items = new Item[]{
                ItemFactory.getNewInstanceBackstagePassesItem(10, 20),
                ItemFactory.getNewInstanceBackstagePassesItem(5, 20),
                ItemFactory.getNewInstanceBackstagePassesItem(5, 49),
                ItemFactory.getNewInstanceBackstagePassesItem(0, 20)
        };
        ItemServiceUtils.denoteItemsForOneDays(items);

        assertEquals(Item.BACKSTAGE_PASSES_ITEM_NAME, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);

        assertEquals(Item.BACKSTAGE_PASSES_ITEM_NAME, items[1].name);
        assertEquals(4, items[1].sellIn);
        assertEquals(23, items[1].quality);

        assertEquals(Item.BACKSTAGE_PASSES_ITEM_NAME, items[2].name);
        assertEquals(4, items[2].sellIn);
        assertEquals(50, items[2].quality);

        assertEquals(Item.BACKSTAGE_PASSES_ITEM_NAME, items[3].name);
        assertEquals(-1, items[3].sellIn);
        assertEquals(0, items[3].quality);

    }
}