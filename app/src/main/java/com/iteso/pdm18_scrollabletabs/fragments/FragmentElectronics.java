package com.iteso.pdm18_scrollabletabs.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.AdapterProduct;
import com.iteso.pdm18_scrollabletabs.R;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by Cursos on 28/02/2018.
 */

public class FragmentElectronics extends android.support.v4.app.Fragment {
    public FragmentElectronics(){};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technology, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct("Mac E", "BestBuy", "Av. Patria", "123456789", R.drawable.mac));
        products.add(new ItemProduct("Alienware E", "DELL", "Av. López Mateos", "9876554321", R.drawable.alienware));
        products.add(new ItemProduct("Lanix E", "Saint Jhonny", "Taiwan de Dios", "1213141516", R.drawable.mac));

        AdapterProduct adapterProduct = new AdapterProduct(products, this.getContext());
        recyclerView.setAdapter(adapterProduct);

        return rootView;
    }
}

