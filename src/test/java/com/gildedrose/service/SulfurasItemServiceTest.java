package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemServiceTest {

    @Test
    void calculateNewQuality() {
        Item[] items = new Item[]{
                ItemFactory.getNewInstanceSulfurasItem(10), //
                ItemFactory.getNewInstanceSulfurasItem(-1)};

        ItemServiceUtils.denoteItemsFor10Days(items);

        assertEquals(Item.SULFURAS_ITEM_NAME, items[0].name);
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);

        assertEquals(Item.SULFURAS_ITEM_NAME, items[1].name);
        assertEquals(-1, items[1].sellIn);
        assertEquals(80, items[1].quality);
    }
}