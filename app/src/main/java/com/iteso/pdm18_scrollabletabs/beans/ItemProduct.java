package com.iteso.pdm18_scrollabletabs.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct implements Parcelable{
    private String title;
    private String store;
    private String location;
    private String phone;
    private int image;
    private int code;

    public ItemProduct(String title, String store, String location, String phone, int image, int code) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.image = image;
        this.code = code;
    }

    public ItemProduct(Parcel in)
    {
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        image = in.readInt();
        code = in.readInt();
    }


    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(store);
        parcel.writeString(location);
        parcel.writeString(phone);
        parcel.writeInt(image);
        parcel.writeInt(code);
    }
}
