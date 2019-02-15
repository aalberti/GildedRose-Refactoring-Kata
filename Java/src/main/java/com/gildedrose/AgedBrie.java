package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void nextDay() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0 && this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

}
