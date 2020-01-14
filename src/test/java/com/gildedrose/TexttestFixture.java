package com.gildedrose;

import com.gildedrose.factory.ItemFactory;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
                ItemFactory.getNewInstanceNormalItem("+5 Dexterity Vest", 10, 20), //
                ItemFactory.getNewInstanceAgedBrieItem(2, 0), //
                ItemFactory.getNewInstanceNormalItem("Elixir of the Mongoose", 5, 7), //
                ItemFactory.getNewInstanceSulfurasItem(0), //
                ItemFactory.getNewInstanceSulfurasItem(-1),
                ItemFactory.getNewInstanceBackstagePassesItem(15, 20),
                ItemFactory.getNewInstanceBackstagePassesItem(10, 49),
                ItemFactory.getNewInstanceBackstagePassesItem(5, 49),
                // this conjured item does not work properly yet
                ItemFactory.getNewInstanceConjuredItem(3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
