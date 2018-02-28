package com.iteso.pdm18_scrollabletabs.beans;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct {
    private String title;
    private String store;

    public ItemProduct(String title, String store) {
        this.title = title;
        this.store = store;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                '}';
    }
}
