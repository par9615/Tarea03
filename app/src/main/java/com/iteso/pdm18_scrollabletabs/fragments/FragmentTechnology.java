package com.iteso.pdm18_scrollabletabs.fragments;

import android.app.Fragment;
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

public class FragmentTechnology extends android.support.v4.app.Fragment {
    private AdapterProduct adapterProduct;
    private ArrayList<ItemProduct> products;
    private static final int FRAGMENT_TECHNOLOGY = 0;
    public FragmentTechnology(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technology, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_recycler_view);

        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<>();
        products.add(new ItemProduct("Mac T", "BestBuy", "Av. Patria", "123456789", R.drawable.mac, 7));
        products.add(new ItemProduct("Alienware T", "DELL", "Av. López Mateos", "9876554321", R.drawable.alienware, 8));
        products.add(new ItemProduct("Lanix T", "Saint Jhonny", "Taiwan de Dios", "1213141516", R.drawable.mac, 9));

        adapterProduct = new AdapterProduct(products, this.getContext(), FRAGMENT_TECHNOLOGY);
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

