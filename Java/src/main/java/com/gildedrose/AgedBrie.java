package com.gildedrose;

class AgedBrie extends Item {
    AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void updateBeforeSellByDate() {
        upgrade();
    }

    @Override
    void furtherUpdateAfterSellByDate() {
        upgrade();
    }
}
