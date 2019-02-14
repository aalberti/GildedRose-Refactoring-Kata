package com.gildedrose;

import static java.lang.String.format;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].update();
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