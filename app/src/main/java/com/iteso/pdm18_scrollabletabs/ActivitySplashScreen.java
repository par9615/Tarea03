package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.pdm18_scrollabletabs.beans.City;
import com.iteso.pdm18_scrollabletabs.beans.Store;
import com.iteso.pdm18_scrollabletabs.beans.User;
import com.iteso.pdm18_scrollabletabs.database.DataBaseHandler;
import com.iteso.pdm18_scrollabletabs.database.StoreControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.iteso.pdm18_scrollabletabs.Constants.SPLASH_SCREEN_DELAY;
import static com.iteso.pdm18_scrollabletabs.Constants.USER_PREFERENCES;

public class ActivitySplashScreen extends AppCompatActivity {
    private DataBaseHandler dataBaseHandler;
    private ArrayList<Store> stores;
    private StoreControl storeControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                Intent mainIntent;

                if(user.isLogged())
                    mainIntent = new Intent().setClass(ActivitySplashScreen.this, ActivityMain.class);
                else
                    mainIntent = new Intent().setClass(ActivitySplashScreen.this, ActivityLogin.class);
                startActivity(mainIntent);

                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

        dataBaseHandler = DataBaseHandler.getInstance(getApplicationContext());
        storeControl = new StoreControl();
        stores = storeControl.getStores(dataBaseHandler);
        //TODO add real images of the stores
        if(stores.size() == 0)
        {

            Store store  = new Store(
                    0,
                    "Costco 2",
                    "11111",
                    R.drawable.mac,
                    1.84,
                    1.010101,
                    new City(
                            0,
                            "Guadalajara"
                    )
            );

            storeControl.addStore(store, dataBaseHandler);

            store  = new Store(
                    1,
                    "Costco",
                    "11111",
                    R.drawable.mac,
                    1.84,
                    1.010101,
                    new City(
                            1,
                            "Ciudad de México"
                    )
            );

            storeControl.addStore(store, dataBaseHandler);

            store  = new Store(
                    2,
                    "BestBuy",
                    "444444",
                    R.drawable.bestbuy,
                    9.9999,
                    123.123,
                    new City(
                            2,
                            "Monterrey"
                    )
            );

            storeControl.addStore(store, dataBaseHandler);

        }

        stores = storeControl.getStores(dataBaseHandler);


    }

    public User loadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString(getString(R.string.USERNAME_PREFERENCE), null));
        user.setPassword(sharedPreferences.getString(getString(R.string.PASSWORD_PREFERENCE), null));
        user.setLogged(sharedPreferences.getBoolean(getString(R.string.LOGGED_PREFERENCE), false));
        sharedPreferences = null;
        return user;
    }
}
