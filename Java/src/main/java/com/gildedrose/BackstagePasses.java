package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int value) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, value);
    }

    @Override
    void nextDay() {
        if (getValue() < 50) {
            setValue(getValue() + 1);

            if (this.getSellIn() < 11 && getValue() < 50) {
                setValue(getValue() + 1);
            }

            if (this.getSellIn() < 6 && getValue() < 50) {
                setValue(getValue() + 1);
            }
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            setValue(0);
        }
    }

}
