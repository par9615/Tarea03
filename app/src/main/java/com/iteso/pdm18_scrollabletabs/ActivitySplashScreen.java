package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.pdm18_scrollabletabs.beans.User;

import java.util.Timer;
import java.util.TimerTask;

import static com.iteso.pdm18_scrollabletabs.Constants.SPLASH_SCREEN_DELAY;
import static com.iteso.pdm18_scrollabletabs.Constants.USER_PREFERENCES;

public class ActivitySplashScreen extends AppCompatActivity {


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
