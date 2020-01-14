package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemServiceTest {

    public static final String DEXTERITY_VEST_5 = "+5 Dexterity Vest";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";

    @Test
    void calculateNewQuality() {
        Item[] items = new Item[]{
                ItemFactory.getNewInstanceNormalItem(DEXTERITY_VEST_5, 10, 10),
                ItemFactory.getNewInstanceNormalItem(DEXTERITY_VEST_5, -1, 10),
                ItemFactory.getNewInstanceNormalItem(ELIXIR_OF_THE_MONGOOSE, 10, 0),
                ItemFactory.getNewInstanceNormalItem(ELIXIR_OF_THE_MONGOOSE, -1, 1)
        };
        ItemServiceUtils.denoteItemsForOneDays(items);
        assertEquals(DEXTERITY_VEST_5, items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(9, items[0].quality);

        assertEquals(DEXTERITY_VEST_5, items[1].name);
        assertEquals(-2, items[1].sellIn);
        assertEquals(8, items[1].quality);

        assertEquals(ELIXIR_OF_THE_MONGOOSE, items[2].name);
        assertEquals(9, items[2].sellIn);
        assertEquals(0, items[2].quality);

        assertEquals(ELIXIR_OF_THE_MONGOOSE, items[3].name);
        assertEquals(-2, items[3].sellIn);
        assertEquals(0, items[3].quality);
    }
}