package com.gildedrose;

public class Item {
    String name;
    int sellIn;
    int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void ageByOneDay() {
        if (this.name.equals("Aged Brie")) {
            upgrade();
        } else if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
            downgrade();
        }

        if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (this.name.equals("Aged Brie")) {
                upgrade();
            } else if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
                downgrade();
            }
        }
    }

    void downgrade() {
        if (quality > 0) {
            this.quality = this.quality - 1;
        }
    }

    void upgrade() {
        if (quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
