package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void nextDay() {
        if (getValue() < 50) {
            setValue(getValue() + 1);
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0 && getValue() < 50) {
            setValue(getValue() + 1);
        }
    }

}
