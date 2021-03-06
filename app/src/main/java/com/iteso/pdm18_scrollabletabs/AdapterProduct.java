package com.iteso.pdm18_scrollabletabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{
    ArrayList<ItemProduct> products;
    private static int fragmentId;
    static Context context;
    private static final int FRAGMENT = 0;

    public AdapterProduct(ArrayList<ItemProduct> products, Context context, int fragmentId){
        this.products = products;
        this.context = context;
        this.fragmentId = fragmentId;
        System.out.println("Se asigna el adapter del fragmento" + fragmentId);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTitle;
        public TextView mStore;
        public TextView mLocation;
        public TextView mPhone;
        public ImageView mImage;
        public ItemProduct itemProduct;

        public ViewHolder(final View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mLocation = v.findViewById(R.id.item_product_location);
            mPhone = v.findViewById(R.id.item_product_phone);
            mImage = v.findViewById(R.id.item_product_image);

            v.setOnClickListener(this);
            mPhone.setOnClickListener(new OnClickPhone());


        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(view.getContext(), itemProduct.toString(), Toast.LENGTH_LONG).show();
            Intent intent  = new Intent(context, ActivityProduct.class);
            intent.putExtra("ITEM", itemProduct);
            intent.putExtra("FRAGMENT", FRAGMENT);
            ((ActivityMain)context).startActivityForResult(intent, 1);

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
        holder.itemProduct = products.get(position);
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mStore.setText(products.get(position).getStore().getName());
        holder.mLocation.setText(products.get(position).getStore().getCity().getName());
        holder.mPhone.setText(products.get(position).getStore().getPhone());
        holder.mImage.setImageResource(products.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class OnClickPhone implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Uri phoneNumber = Uri.parse("tel:" + ((TextView)view).getText());
            Intent callIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);
            view.getContext().startActivity(callIntent);
        }
    }

}
