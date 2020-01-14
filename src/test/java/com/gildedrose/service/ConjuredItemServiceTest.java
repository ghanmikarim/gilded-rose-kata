package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemServiceTest {

    @Test
    void calculateNewQuality() {
        Item[] items = new Item[]{
                ItemFactory.getNewInstanceConjuredItem(10, 20),
                ItemFactory.getNewInstanceConjuredItem(-1, 5),
                ItemFactory.getNewInstanceConjuredItem(-2, 3)
        };
        ItemServiceUtils.denoteItemsForOneDays(items);

        assertEquals(Item.CONJURED_ITEM_NAME, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(18, items[0].quality);

        assertEquals(Item.CONJURED_ITEM_NAME, items[1].name);
        assertEquals(-2, items[1].sellIn);
        assertEquals(1, items[1].quality);

        assertEquals(Item.CONJURED_ITEM_NAME, items[2].name);
        assertEquals(-3, items[2].sellIn);
        assertEquals(0, items[2].quality);
    }

}