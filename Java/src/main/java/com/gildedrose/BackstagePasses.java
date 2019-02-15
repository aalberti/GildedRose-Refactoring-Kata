package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int value) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, value);
    }

    @Override
    void nextDay() {
        if (this.value < 50) {
            this.value = this.value + 1;

            if (this.sellIn < 11 && this.value < 50) {
                this.value = this.value + 1;
            }

            if (this.sellIn < 6 && this.value < 50) {
                this.value = this.value + 1;
            }
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            this.value = 0;
        }
    }

}
