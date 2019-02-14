package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateValue() {
        if (isExpired())
            wearOutBy(value());
        else if (expiresWithin(5))
            improveBy(3);
        else if (expiresWithin(10))
            improveBy(2);
        else
            improveBy(1);
    }
}
