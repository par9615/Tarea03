package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.pdm18_scrollabletabs.beans.User;

import static com.iteso.pdm18_scrollabletabs.Constants.USER_PREFERENCES;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText username, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.activity_login_user);
        password = findViewById(R.id.activity_login_password);
        login = findViewById(R.id.activity_login_login_button);
        login.setOnClickListener(this);
    }

    void savePreferences(){
        User user = new User();
        user.setName(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setLogged(true);

        SharedPreferences sharedPreferences = getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(getString(R.string.USERNAME_PREFERENCE), user.getName());
        editor.putString(getString(R.string.PASSWORD_PREFERENCE), user.getPassword());
        editor.putBoolean(getString(R.string.LOGGED_PREFERENCE), user.isLogged());
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_login_login_button:
                savePreferences();
                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                break;
        }
    }
}
