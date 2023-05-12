package com.framfresh.app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder>{
    private CartData[] cartData;

    Context context;
    // RecyclerView recyclerView;
    public MyCartAdapter(CartData[] listdata,Context context) {
        this.cartData = listdata;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.cart_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView_name.setText(cartData[position].getName());
        holder.textView_quantity.setText(cartData[position].getQuantity());
        holder.textView_price.setText(cartData[position].getPrice());


    }


    @Override
    public int getItemCount() {
        return cartData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView delete;
        public TextView textView_name,textView_quantity,textView_price;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.delete = (ImageView) itemView.findViewById(R.id.delete);
            this.textView_name = (TextView) itemView.findViewById(R.id.name);
            this.textView_quantity = (TextView) itemView.findViewById(R.id.quantity);
            this.textView_price = (TextView) itemView.findViewById(R.id.price);

            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}