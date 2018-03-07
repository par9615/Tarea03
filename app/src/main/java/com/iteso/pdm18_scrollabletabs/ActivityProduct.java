package com.iteso.pdm18_scrollabletabs;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

/**
 * Created by Cursos on 06/03/2018.
 */

public class ActivityProduct extends AppCompatActivity {
    private ItemProduct itemProduct;
    private TextInputEditText title, store, location, phone;
    private ImageView image;
    private Button save, cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //ItemProduct initialization
        if(getIntent() != null)
            if(getIntent().getExtras().getParcelable("ITEM") != null)
                itemProduct = getIntent().getExtras().getParcelable("ITEM");

        //Initialization
        image = findViewById(R.id.activity_product_image);
        title = findViewById(R.id.activity_product_title);
        store = findViewById(R.id.activity_product_store);
        location = findViewById(R.id.activity_product_location);
        phone = findViewById(R.id.activity_product_phone);

        image.setImageResource(itemProduct.getImage());
        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());


    }
}
