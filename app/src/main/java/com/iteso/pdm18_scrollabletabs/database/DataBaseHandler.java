package com.iteso.pdm18_scrollabletabs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by par9615 on 16/03/18.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    private static DataBaseHandler dataBaseHandler;

    private DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null)
            dataBaseHandler = new DataBaseHandler(context);
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String []categories = {"Technology", "Home", "Electronics"};
        String []cities = {"Guadalajara", "Ciudad de México", "Monterrey", "Zacatecas", "Morelia"};
        String []tables = new String[5];

        tables[0] =
                "CREATE TABLE City (" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT" +
                ")";

        tables[1] =
                "CREATE TABLE Category (" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT" +
                ")";

        tables[2] =
                "CREATE TABLE Store (" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT," +
                        "phone TEXT," +
                        "idcity INTEGER," +
                        "thumbnail INTEGER," +
                        "latitude DOUBLE," +
                        "longitude DOUBLE" +
                ")";

        tables[3] =
                "CREATE TABLE Product (" +
                        "idproduct INTEGER PRIMARY KEY, " +
                        "title TEXT," +
                        "image INTEGER," +
                        "idcategory INTEGER" +
                        ")";

        tables[4] =
                "CREATE TABLE StoreProduct (" +
                        "id INTEGER PRIMARY KEY," +
                        "idproduct INTEGER," +
                        "idstore INTEGER" +
                ")";


        for (String table : tables)
            db.execSQL(table);


        for(int i = 0; i < categories.length; i++)
            db.execSQL("INSERT INTO Category (id, name) VALUES (" + (i) + "," + "'" + categories[i] + "'" + ")");

        for(int i = 0; i < cities.length; i++)
            db.execSQL("INSERT INTO City (id, name) VALUES (" + (i) + "," + "'" + cities[i] + "'" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
