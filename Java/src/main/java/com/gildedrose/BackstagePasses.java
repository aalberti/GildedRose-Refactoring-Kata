package com.gildedrose;

class BackstagePasses extends Item {
    BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void ageByOneDay() {
        upgrade();
        if (this.sellIn < 11) {
            upgrade();
        }
        if (this.sellIn < 6) {
            upgrade();
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}
