package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void nextDay() {
        if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (this.quality > 0 && !this.name.equals("Sulfuras, Hand of Ragnaros")) {
                this.quality = this.quality - 1;
            }
        } else {
            if (this.quality < 50) {
                this.quality = this.quality + 1;

                if (this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (this.sellIn < 11 && this.quality < 50) {
                        this.quality = this.quality + 1;
                    }

                    if (this.sellIn < 6 && this.quality < 50) {
                        this.quality = this.quality + 1;
                    }
                }
            }
        }

        if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (this.quality > 0 && !this.name.equals("Sulfuras, Hand of Ragnaros")) {
                    this.quality = this.quality - 1;
                }
            } else {
                this.quality = 0;
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
