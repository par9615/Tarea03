package com.iteso.pdm18_scrollabletabs;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

/**
 * Created by Cursos on 06/03/2018.
 */

public class ActivityProduct extends AppCompatActivity {
    private ItemProduct itemProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        if(getIntent() != null)
            if(getIntent().getExtras().getParcelable("ITEM") != null)
                itemProduct = getIntent().getExtras().getParcelable("ITEM");



    }
}
