package com.gildedrose.service;

import com.gildedrose.Item;

public class ConjuredItemService extends ItemService {

    private static ConjuredItemService instance;

    private ConjuredItemService() {
    }

    /**
     * Lazy initialization method to implement Singleton pattern creates the instance in the global access method
     *
     * @return Singleton
     */
    public static ConjuredItemService getInstance() {
        if (instance == null) {
            instance = new ConjuredItemService();
        }
        return instance;
    }

    /**
     * this method calculate the new Quality for Conjured item
     *
     * @param item that will be used for the calculation of the new quality value  of the Conjured Item
     * @return the new quality value of the Conjured Item
     */
    @Override
    protected int calculateNewQuality(Item item) {
        int qualityAdjustment = -2;
        if (item.sellIn < 0) {
            qualityAdjustment -= 2;
        }
        return item.quality + qualityAdjustment;
    }
}
