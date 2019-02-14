package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int value;

    public Item(String name, int sellIn, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.value = value;
    }

    void update() {
        if (this.value > 0) {
            this.value = this.value - 1;
        }

        this.sellIn = this.sellIn - 1;

        if (isExpired() && this.value > 0) {
            this.value = this.value - 1;
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.value;
    }

    protected boolean isExpired() {
        return this.sellIn < 0;
    }

    protected void increaseValue() {
        if (this.value < 50) {
            this.value = this.value + 1;
        }
    }
}
