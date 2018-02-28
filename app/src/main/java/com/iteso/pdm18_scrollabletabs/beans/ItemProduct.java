package com.iteso.pdm18_scrollabletabs.beans;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct {
    private String title;
    private String store;
    private String location;
    private String phone;

    public ItemProduct(String title, String store, String location, String phone) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
