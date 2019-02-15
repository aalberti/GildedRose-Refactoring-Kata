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
        if (this.quality > 0 && !isSulfuras()) {
            this.quality = this.quality - 1;
        }

        if (!isSulfuras()) {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (this.quality > 0 && !isSulfuras()) {
                this.quality = this.quality - 1;
            }
        }
    }

    private boolean isSulfuras() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
