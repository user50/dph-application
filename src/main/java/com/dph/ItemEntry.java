package com.dph;

public class ItemEntry {

    private int itemId;
    private double weight;
    private String link;

    public ItemEntry(int itemId, double weight, String link) {
        this.itemId = itemId;
        this.weight = weight;
        this.link = link;
    }

    public int getItemId() {
        return itemId;
    }

    public double getWeight() {
        return weight;
    }

    public String getLink() {
        return link;
    }
}
