package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void nextDay() {
        if (this.value < 50) {
            this.value = this.value + 1;
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0 && this.value < 50) {
            this.value = this.value + 1;
        }
    }

}
