package com.gildedrose;

class AgedBrie extends Item {
    AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void updateValue() {
        if (isExpired())
            improveBy(2);
        else
            improveBy(1);
    }
}
