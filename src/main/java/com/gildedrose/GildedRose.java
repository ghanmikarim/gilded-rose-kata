package com.gildedrose;

import com.gildedrose.factory.ItemFactory;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items != null && items.length > 0) {
            Stream.of(items)
                    .filter(item -> item != null && !Item.SULFURAS_ITEM_NAME.equals(item.name)).forEach(item -> ItemFactory.getItemService(item).updateQuality(item));
        }
    }
}