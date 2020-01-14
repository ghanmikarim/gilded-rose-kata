package com.gildedrose;

public class Item {
    public static final String AGED_BRIE_ITEM_NAME = "Aged Brie";
    public static final String BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_ITEM_NAME = "Conjured Mana Cake";
    public static final String SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    public static final int SULFURAS_HIGHEST_QUALITY_VALUE = 80;
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
