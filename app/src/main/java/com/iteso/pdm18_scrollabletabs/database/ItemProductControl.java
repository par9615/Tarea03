package com.iteso.pdm18_scrollabletabs.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.Category;
import com.iteso.pdm18_scrollabletabs.beans.City;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.beans.Store;

import java.util.ArrayList;

/**
 * Created by par9615 on 17/03/18.
 */

public class ItemProductControl {

    void addItemProduct(ItemProduct itemProduct, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues productValues = new ContentValues();
        ContentValues storeProductValues = new ContentValues();

        productValues.put("idproduct", itemProduct.getCode());
        productValues.put("title", itemProduct.getTitle());
        productValues.put("image", itemProduct.getImage());
        productValues.put("idcategory", itemProduct.getCategory().getId());

        db.insert("Product", null, productValues);

        //TODO check how to insert StoreProduct.id
        storeProductValues.put("idproduct", itemProduct.getCode());
        storeProductValues.put("idstore", itemProduct.getStore().getId());

        db.insert("StoreProduct", null, storeProductValues);

        try {
            db.close();
        }catch (Exception e) {
        }
        db = null;
        productValues = null;
        storeProductValues = null;

    }

    ArrayList<ItemProduct> getItemProductsByCategory(int idCategory, DataBaseHandler dh) {
        ArrayList<ItemProduct> products = new ArrayList<>();
        SQLiteDatabase db = dh.getReadableDatabase();
        String select = "SELECT" +
                "idproduct, " +
                "title, " +
                "image, " +
                "idcategory " +
                "Category.id " +
                "Category.name " +
                "Store.id," +
                "Store.name, " +
                "Store.phone, " +
                "Store.thumbnail, " +
                "Store.latitude, " +
                "Store.longitude, " +
                "City.id, " +
                "City.name, " +
                "FROM Product " +
                "INNER JOIN Category ON Product.idcategory = Category.id " +
                "INNER JOIN StoreProduct ON Product.id = StoreProduct.idproduct" +
                "INNER JOIN Store ON Store.idstore = Store.id" +
                "INNER JOIN City ON Store.idcity = City.id" +
                "WHERE Product.idcategory = " + idCategory;

        Cursor cursor = db.rawQuery(select, null);

        while(cursor.moveToNext()) {
            ItemProduct itemProduct = new ItemProduct();
            Category category = new Category();
            Store store = new Store();
            City city = new City();

            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            store.setId(cursor.getInt(5));
            store.setName(cursor.getString(6));
            store.setPhone(cursor.getString(7));
            store.setThumbnail(cursor.getInt(8));
            store.setLatitude(cursor.getDouble(9));
            store.setLongitude(cursor.getDouble(10));
            city.setId(cursor.getInt(11));
            city.setName(cursor.getString(12));

            store.setCity(city);

            itemProduct.setStore(store);
            itemProduct.setCategory(category);

            products.add(itemProduct);

        }

        try {
            cursor.close();
            db.close();
        }catch (Exception e) {
        }

        cursor = null;
        db = null;

        return products;
    }
}
