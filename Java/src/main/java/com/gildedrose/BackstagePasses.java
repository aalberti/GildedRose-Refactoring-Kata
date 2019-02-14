package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void update() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;

            if (this.sellIn < 11 && this.quality < 50) {
                this.quality = this.quality + 1;
            }

            if (this.sellIn < 6 && this.quality < 50) {
                this.quality = this.quality + 1;
            }
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}
