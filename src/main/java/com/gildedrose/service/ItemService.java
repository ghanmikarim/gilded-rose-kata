package com.gildedrose.service;

import com.gildedrose.Item;

/**
 * this is an abstract class that present the service of the quality calcul
 * the method calculateNewQuality must be implemented by the specified item etc (AdgedBrie, Sulfuras, Conjured)
 *
 * @author Karim.ghanmi@gmail.com
 */
public abstract class ItemService {

    public static final int LOWEST_QUALITY_VALUE = 0;
    public static final int HIGHEST_QUALITY_VALUE = 50;


    /**
     * this is an abstract method that will be implemented for calculate the new Quality value for an item
     *
     * @param item that will be used for the calculation of the new quality value
     * @return the new quality value
     */
    abstract protected int calculateNewQuality(Item item);

    /**
     * this method is common for updating the item qualiy
     * "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.
     *
     * @param item : the item to be updated
     */
    public void updateQuality(Item item) {
        if (item != null && !Item.SULFURAS_ITEM_NAME.equals(item.name)) {
            decreaseSellIn(item);
            item.quality = newQualityWithAjustment(item);
        }
    }


    /**
     * this method decrease the sellIn of an item
     *
     * @param item : the item to be updated
     */
    protected void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }


    /**
     * this method ajust the new quality value to respect this rules :
     * the lowest quality for an item is 0
     * the highest  quality for an item is 50
     * if
     *
     * @param item
     * @return
     */
    protected int newQualityWithAjustment(Item item) {
        return Math.min(Math.max(this.calculateNewQuality(item),LOWEST_QUALITY_VALUE),HIGHEST_QUALITY_VALUE);

    }
}
