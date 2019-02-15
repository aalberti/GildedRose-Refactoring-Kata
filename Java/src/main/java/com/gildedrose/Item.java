package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private Value value;

    public Item(String name, int sellIn, int value) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.value = new Value(value);
    }

    void nextDay() {
        this.value.decrease();

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            this.value.decrease();
        }
    }

    public int getValue() {
        return value.value();
    }

    public void setValue(int value) {
        this.value = new Value(value);
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getSellIn() + ", " + getValue();
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
