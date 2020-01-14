package com.gildedrose.service;

import com.gildedrose.Item;

public class BackstagePassesItemService extends ItemService {

    private static BackstagePassesItemService instance;

    private BackstagePassesItemService() {
    }

    /**
     * Lazy initialization method to implement Singleton pattern creates the instance in the global access method
     *
     * @return Singleton
     */
    public static BackstagePassesItemService getInstance() {
        if (instance == null) {
            instance = new BackstagePassesItemService();
        }
        return instance;
    }


    /**
     * this method calculate the new Quality for BackstagePasses item
     * - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     *
     * @param item that will be used for the calculation of the new quality value  of the BackstagePasses Item
     * @return the new quality value of the BackstagePasses Item
     */
    @Override
    protected int calculateNewQuality(Item item) {
        if (item.sellIn < 0) {
            return 0;
        }
        int qualityAdjustment = 1;
        if (item.sellIn < 11) {
            qualityAdjustment += 1;
        }
        if (item.sellIn < 6) {
            qualityAdjustment += 1;
        }

        return item.quality + qualityAdjustment;
    }
}
