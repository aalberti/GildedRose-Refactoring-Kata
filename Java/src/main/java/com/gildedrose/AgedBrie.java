package com.gildedrose;

class AgedBrie extends Item {
    AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void ageByOneDay() {
        upgrade();
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0) {
            upgrade();
        }
    }
}
