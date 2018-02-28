package com.iteso.pdm18_scrollabletabs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    public AdapterProduct(ArrayList<ItemProduct> products){
        this.products = products;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public ViewHolder(View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mStore.setText(products.get(position).getStore());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
