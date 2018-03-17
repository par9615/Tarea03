package com.iteso.pdm18_scrollabletabs.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.Category;

import java.util.ArrayList;

/**
 * Created by par9615 on 16/03/18.
 */

public class CategoryControl {
    ArrayList<Category> getCategories(DataBaseHandler dh) {
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<Category> categories  = new ArrayList<>();
        String select = "SELECT id, name FROM Category";
        Cursor cursor = db.rawQuery(select, null);

        while(cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getInt(0));
            category.setName(cursor.getString(1));
            categories.add(category);
        }

        try{
            cursor.close();
            db.close();
        }catch (Exception e) {
        }

        db = null;
        cursor = null;
        return categories;
    }
}
