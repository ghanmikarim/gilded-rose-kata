package com.gildedrose.service;

import com.gildedrose.Item;

public class NormalItemService extends ItemService {

    private static NormalItemService instance;

    private NormalItemService() {
    }

    /**
     * Lazy initialization method to implement Singleton pattern creates the instance in the global access method
     *
     * @return Singleton
     */
    public static NormalItemService getInstance() {
        if (instance == null) {
            instance = new NormalItemService();
        }
        return instance;
    }

    /**
     * this method calculate the new Quality for all standard items
     *
     * @param item that will be used for the calculation of the new quality value  of normal Item
     * @return the new quality value of the normal Item
     */
    protected int calculateNewQuality(Item item) {
        int qualityAdjustment = -1;
        if (item.sellIn < 0) {
            qualityAdjustment -= 1;
        }
        return item.quality + qualityAdjustment;
    }
}
