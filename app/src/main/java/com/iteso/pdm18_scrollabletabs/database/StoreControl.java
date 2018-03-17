package com.iteso.pdm18_scrollabletabs.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.City;
import com.iteso.pdm18_scrollabletabs.beans.Store;

import java.util.ArrayList;

/**
 * Created by par9615 on 16/03/18.
 */

public class StoreControl {

    void addStore(Store store, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", store.getId());
        values.put("name", store.getName());
        values.put("phone", store.getPhone());
        values.put("idcity", store.getCity().getId());
        values.put("thumbnail", store.getThumbnail());
        values.put("latitude", store.getLatitude());
        values.put("longitude", store.getLongitude());
        db.insert("Category", null, values);

        try {
            db.close();
        }catch (Exception e) {
        }
        db = null;
        values = null;

    }

    ArrayList<Store> getStores(DataBaseHandler dh) {
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<Store> stores = new ArrayList<>();
        String select = "SELECT id, name, phone, idcity, thumbnail, latitude, longitude, City.id, City.name FROM Store INNER JOIN City ON Store.idcity = City.id";
        Cursor cursor = db.rawQuery(select, null);

        while(cursor.moveToNext())
        {
            Store store = new Store();
            City city = new City();

            city.setId(cursor.getInt(7));
            city.setName(cursor.getString(8));

            store.setId(cursor.getInt(0));
            store.setName(cursor.getString(1));
            store.setPhone(cursor.getString(2));
            store.setThumbnail(cursor.getInt(4));
            store.setLatitude(cursor.getDouble(5));
            store.setLongitude(cursor.getDouble(6));
            store.setCity(city);

            stores.add(store);
        }

        try {
            cursor.close();
            db.close();
        }catch (Exception e){
        }

        cursor = null;
        db = null;
        return stores;
    }

    Store getStoreById(int idStore, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getReadableDatabase();
        Store store = null;
        City city = null;
        String select = "SELECT id, name, phone, idcity, thumbnail, latitude, longitude, City.id, City.name FROM Store INNER JOIN City ON Store.idcity = City.id " +
                "WHERE Store.id = " + idStore;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor != null) {
            cursor.moveToFirst();

            store = new Store();
            city = new City();

            city.setId(cursor.getInt(7));
            city.setName(cursor.getString(8));

            store.setId(cursor.getInt(0));
            store.setName(cursor.getString(1));
            store.setPhone(cursor.getString(2));
            store.setThumbnail(cursor.getInt(4));
            store.setLatitude(cursor.getDouble(5));
            store.setLongitude(cursor.getDouble(6));
        }

        try {
            cursor.close();
            db.close();
        }catch (Exception e) {
        }

        cursor = null;
        db = null;

        return store;
    }
}
