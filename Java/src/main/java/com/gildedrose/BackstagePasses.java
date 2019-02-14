package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateValue() {
        increaseValue();
        if (expiresWithin(10))
            increaseValue();
        if (expiresWithin(5))
            increaseValue();

        if (isExpired()) {
            this.value = 0;
        }
    }

    private boolean expiresWithin(int i) {
        return this.sellIn < i;
    }
}
