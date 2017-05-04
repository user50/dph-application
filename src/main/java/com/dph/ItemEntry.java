package com.dph;

public class ItemEntry {

    private int itemId;
    private double weight;

    ItemEntry(int itemId, double weight) {
        this.itemId = itemId;
        this.weight = weight;
    }

    public int getItemId() {
        return itemId;
    }

    public double getWeight() {
        return weight;
    }
}
