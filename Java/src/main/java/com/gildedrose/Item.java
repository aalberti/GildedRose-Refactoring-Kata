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

    void nextDay() {
        if (this.value > 0) {
            this.value = this.value - 1;
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0 && this.value > 0) {
            this.value = this.value - 1;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.value;
    }
}
