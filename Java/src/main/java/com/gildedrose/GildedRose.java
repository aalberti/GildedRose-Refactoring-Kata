package com.gildedrose;

import static java.lang.String.format;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void ageByOneDay() {
        for (Item item : items) {
            item.ageByOneDay();
        }
    }

    public Item getItem(String name) {
        Item[] clone = items.clone();
        for (Item item : clone) {
            if (name.equalsIgnoreCase(item.name)) {
                return item;
            }
        }

        throw new RuntimeException(format("Item '%s' not found", name));
    }
}