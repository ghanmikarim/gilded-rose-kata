package com.gildedrose.service;

import com.gildedrose.Item;

public class AgedBrieItemService extends ItemService {

    private static AgedBrieItemService instance;

    private AgedBrieItemService() {
    }

    /**
     * Lazy initialization method to implement Singleton pattern creates the instance in the global access method
     *
     * @return Singleton
     */
    public static AgedBrieItemService getInstance() {
        if (instance == null) {
            instance = new AgedBrieItemService();
        }
        return instance;
    }

    /**
     * this method calculate the new Quality for AgeBrie item
     * "Aged Brie"  increases in Quality the older it gets
     *
     * @param item that will be used for the calculation of the new quality value  of the AgedBrie Item
     * @return the new quality value of the AgedBrie Item
     */
    @Override
    protected int calculateNewQuality(Item item) {
        int qualityAdjustment = 1;
        if (item.sellIn < 0) {
            qualityAdjustment += 1;
        }
        return item.quality + qualityAdjustment;
    }
}
