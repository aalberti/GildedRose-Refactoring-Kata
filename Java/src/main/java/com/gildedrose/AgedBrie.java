package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void update() {
        increaseValue();

        this.sellIn = this.sellIn - 1;

        if (isExpired()) {
            increaseValue();
        }
    }
}
