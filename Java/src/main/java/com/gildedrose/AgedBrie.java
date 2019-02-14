package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    void update() {
        getOlder();

        increaseValue();
        if (isExpired()) {
            increaseValue();
        }
    }
}
