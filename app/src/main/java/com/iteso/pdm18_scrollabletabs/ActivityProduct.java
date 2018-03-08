package com.iteso.pdm18_scrollabletabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

/**
 * Created by Cursos on 06/03/2018.
 */

public class ActivityProduct extends AppCompatActivity implements View.OnClickListener {
    private static ItemProduct itemProduct;
    private TextInputEditText title, store, location, phone;
    private ImageView image;
    private Button save, cancel;
    private int fragmentId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //ItemProduct initialization
        if(getIntent() != null)
            if(getIntent().getExtras() != null) {
                itemProduct = getIntent().getParcelableExtra("ITEM");
                fragmentId = getIntent().getExtras().getInt("FRAGMENT");
            }

        //Initialization
        image = findViewById(R.id.activity_product_image);
        title = findViewById(R.id.activity_product_title);
        store = findViewById(R.id.activity_product_store);
        location = findViewById(R.id.activity_product_location);
        phone = findViewById(R.id.activity_product_phone);
        save = findViewById(R.id.activity_product_save);
        cancel = findViewById(R.id.activity_product_cancel);

        image.setImageResource(itemProduct.getImage());
        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore());
        location.setText(itemProduct.getLocation());
        phone.setText(itemProduct.getPhone());
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.activity_product_save:
                Intent intent = new Intent();
                ItemProduct itemProductUpdated = new ItemProduct(
                        title.getText().toString(),
                        store.getText().toString(),
                        location.getText().toString(),
                        phone.getText().toString(),
                        itemProduct.getImage(),
                        itemProduct.getCode()
                );
                intent.putExtra("ITEM", itemProductUpdated);
                intent.putExtra("FRAGMENT", fragmentId);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;

            case R.id.activity_product_cancel:
                setResult(Activity.RESULT_CANCELED);
                finish();
                break;

        }
    }



}
