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
        getOlder();
        updateValue();
    }

    void updateValue() {
        decreaseValue();
        if (isExpired()) {
            decreaseValue();
        }
    }

    void getOlder() {
        this.sellIn = this.sellIn - 1;
    }

    boolean isExpired() {
        return this.sellIn < 0;
    }

    void increaseValue() {
        if (this.value < 50) {
            this.value = this.value + 1;
        }
    }

    private void decreaseValue() {
        if (this.value > 0) {
            this.value = this.value - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.value;
    }
}
