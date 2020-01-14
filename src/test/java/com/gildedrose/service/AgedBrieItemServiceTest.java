package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieItemServiceTest {

    @Test
    void calculateNewQuality() {
        Item[] items = new Item[]{
                ItemFactory.getNewInstanceAgedBrieItem(20, 10),
                ItemFactory.getNewInstanceAgedBrieItem(20, 50)};

        ItemServiceUtils.denoteItemsForOneDays(items);
        assertEquals(Item.AGED_BRIE_ITEM_NAME, items[0].name);
        assertEquals(19, items[0].sellIn);
        assertEquals(11, items[0].quality);

        assertEquals(Item.AGED_BRIE_ITEM_NAME, items[1].name);
        assertEquals(19, items[1].sellIn);
        assertEquals(50, items[1].quality);
    }
}