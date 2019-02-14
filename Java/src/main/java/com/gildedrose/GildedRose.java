package com.gildedrose;

import static java.lang.String.format;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }

    Item getItem(String name) {
        Item[] clone = items.clone();
        for (Item item : clone) {
            if (name.equalsIgnoreCase(item.name())) {
                return item;
            }
        }
        throw new RuntimeException(format("Item '%s' not found", name));
    }
}