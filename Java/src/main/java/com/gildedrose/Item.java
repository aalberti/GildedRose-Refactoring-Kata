package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int value;

    public Item(String name, int sellIn, int value) {
        this.setName(name);
        this.setSellIn(sellIn);
        setValue(value);
    }

    void nextDay() {
        if (getValue() > 0) {
            setValue(getValue() - 1);
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0 && getValue() > 0) {
            setValue(getValue() - 1);
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
