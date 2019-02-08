package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateBeforeSellByDate() {
        upgrade();
        if (this.sellIn < 11) {
            upgrade();
        }
        if (this.sellIn < 6) {
            upgrade();
        }
    }

    @Override
    void furtherUpdateAfterSellByDate() {
        quality = 0;
    }
}
