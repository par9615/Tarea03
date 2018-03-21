package com.iteso.pdm18_scrollabletabs.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.AdapterProduct;
import com.iteso.pdm18_scrollabletabs.Constants;
import com.iteso.pdm18_scrollabletabs.R;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.beans.Store;
import com.iteso.pdm18_scrollabletabs.database.DataBaseHandler;
import com.iteso.pdm18_scrollabletabs.database.ItemProductControl;
import com.iteso.pdm18_scrollabletabs.database.StoreControl;

import java.util.ArrayList;

import static com.iteso.pdm18_scrollabletabs.Constants.FRAGMENT_ELECTRONICS;

/**
 * Created by Cursos on 28/02/2018.
 */

public class FragmentElectronics extends android.support.v4.app.Fragment {
    private AdapterProduct adapterProduct;
    private ArrayList<ItemProduct> products;
    private DataBaseHandler dataBaseHandler;
    private ItemProductControl itemProductControl;


    public FragmentElectronics(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technology, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        dataBaseHandler = DataBaseHandler.getInstance(getContext());
        itemProductControl = new ItemProductControl();

        products = itemProductControl.getItemProductsByCategory(2, dataBaseHandler);

        adapterProduct = new AdapterProduct(products, this.getContext(), FRAGMENT_ELECTRONICS);
        recyclerView.setAdapter(adapterProduct);

        return rootView;
    }

    public void changeProduct(ItemProduct itemProduct)
    {
        int len = this.products.size();
        for(int i = 0; i < len; i++)
            if(this.products.get(i).getCode() == itemProduct.getCode())
            {
                this.products.set(i, itemProduct);
                adapterProduct.notifyDataSetChanged();
                break;
            }
    }
}

