package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.service.*;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private final static Map<Class<Item>, ItemService>
            ITEM_SERVICES = new HashMap() {
        {
            put(Item.AGED_BRIE_ITEM_NAME, AgedBrieItemService.getInstance());
            put(Item.BACKSTAGE_PASSES_ITEM_NAME, BackstagePassesItemService.getInstance());
            put(Item.CONJURED_ITEM_NAME, ConjuredItemService.getInstance());
        }
    };

    public final static ItemService getItemService(Item item) {
        ItemService itemService = null;
        if (item != null) {
            itemService = ITEM_SERVICES.get(item.name);
        }
        if (itemService == null) {
            itemService = NormalItemService.getInstance();
        }
        return itemService;
    }

    public final static Item getNewInstanceNormalItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    public final static Item getNewInstanceAgedBrieItem(int sellIn, int quality) {
        return new Item(Item.AGED_BRIE_ITEM_NAME, sellIn, quality);
    }
    public final static Item getNewInstanceBackstagePassesItem(int sellIn, int quality) {
        return new Item(Item.BACKSTAGE_PASSES_ITEM_NAME, sellIn, quality);
    }

    public final static Item getNewInstanceConjuredItem(int sellIn, int quality) {
        return new Item(Item.CONJURED_ITEM_NAME, sellIn, quality);
    }

    public final static Item getNewInstanceSulfurasItem(int sellIn) {
        return new Item(Item.SULFURAS_ITEM_NAME, sellIn, Item.SULFURAS_HIGHEST_QUALITY_VALUE);
    }
}
