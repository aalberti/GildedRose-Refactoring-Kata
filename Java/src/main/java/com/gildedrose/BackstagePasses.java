package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void update() {
        increaseValue();
        if (expiresIn(11))
            increaseValue();
        if (expiresIn(6))
            increaseValue();

        this.sellIn = this.sellIn - 1;

        if (isExpired()) {
            this.value = 0;
        }
    }

    private boolean expiresIn(int i) {
        return this.sellIn < i;
    }
}
