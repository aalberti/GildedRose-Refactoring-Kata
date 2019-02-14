package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int quality) {
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
            wearOutBy(value());
        }
    }
}
