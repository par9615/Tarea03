package com.iteso.pdm18_scrollabletabs;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.iteso.pdm18_scrollabletabs.beans.Category;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.beans.Store;
import com.iteso.pdm18_scrollabletabs.database.CategoryControl;
import com.iteso.pdm18_scrollabletabs.database.DataBaseHandler;
import com.iteso.pdm18_scrollabletabs.database.ItemProductControl;
import com.iteso.pdm18_scrollabletabs.database.StoreControl;
import com.iteso.pdm18_scrollabletabs.fragments.FragmentElectronics;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static com.iteso.pdm18_scrollabletabs.Constants.ELECTRONICS;
import static com.iteso.pdm18_scrollabletabs.Constants.HOME;
import static com.iteso.pdm18_scrollabletabs.Constants.TECHNOLOGY;

public class ActivityItem extends AppCompatActivity {
    private Spinner image, category, store;
    private EditText title;
    private Button save;

    private DataBaseHandler dataBaseHandler;
    private StoreControl storeControl;
    private ItemProductControl itemProductControl;
    private CategoryControl categoryControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        image = findViewById(R.id.activity_item_image);
        title = findViewById(R.id.activity_item_title);
        category = findViewById(R.id.activity_item_category);
        store = findViewById(R.id.activity_item_store);
        save = findViewById(R.id.activity_item_save);

        dataBaseHandler = DataBaseHandler.getInstance(getApplicationContext());
        storeControl = new StoreControl();
        itemProductControl = new ItemProductControl();
        categoryControl = new CategoryControl();

        ArrayList<Store> stores = storeControl.getStores(dataBaseHandler);
        ArrayList<Category> categories = categoryControl.getCategories(dataBaseHandler);
        String []images = {"alienware", "mac"};

        ArrayAdapter<Store> adapterStore = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, stores);
        ArrayAdapter<Category> adapterCategory = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, categories);
        ArrayAdapter<String> adapterImage = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, images);

        category.setAdapter(adapterCategory);
        store.setAdapter(adapterStore);
        image.setAdapter(adapterImage);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct item = new ItemProduct();
                Fragment fragment;

                item.setCode(item.hashCode());
                item.setImage(getResources().getIdentifier(image.getSelectedItem().toString(), "drawable", getPackageName()));
                item.setTitle(title.getText().toString());
                item.setStore((Store) store.getSelectedItem());
                item.setCategory((Category) category.getSelectedItem());

                itemProductControl.addItemProduct(item, dataBaseHandler);


                finish();
            }
        });

    }

}
