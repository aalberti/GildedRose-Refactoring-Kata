package com.gildedrose;

public class Item {
    private String name;
    private int sellIn;
    private int value;

    Item(String name, int sellIn, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.value = value;
    }

    void nextDay() {
        getOlder();
        updateValue();
    }

    private void getOlder() {
        this.sellIn = this.sellIn - 1;
    }

    void updateValue() {
        if (isExpired())
            wearOutBy(2);
        else
            wearOutBy(1);
    }

    void improveBy(int valueToAdd) {
        value = Math.min(value + valueToAdd, 50);
    }

    void wearOutBy(int valueToRemove) {
        this.value = Math.max(this.value - valueToRemove, 0);
    }

    boolean expiresWithin(int days) {
        return this.sellIn < days;
    }

    boolean isExpired() {
        return this.sellIn < 0;
    }

    String name() {
        return name;
    }

    int sellIn() {
        return sellIn;
    }

    int value() {
        return value;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.value;
    }
}
