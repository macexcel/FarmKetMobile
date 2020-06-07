package com.example.farmket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<cart> arrayList;

    public MyAdapter(Context context, ArrayList<cart> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlist,null);
        TextView t1_item = (TextView)convertView.findViewById(R.id.colItem);
        TextView t1_name = (TextView)convertView.findViewById(R.id.colName);
        TextView t1_price = (TextView)convertView.findViewById(R.id.colPrice);
        TextView t1_amount = (TextView)convertView.findViewById(R.id.colAmount);
        TextView t1_total = (TextView)convertView.findViewById(R.id.colTotal);

        cart cart = arrayList.get(position);

        t1_item.setText(cart.getItem());
        t1_name.setText(cart.getFarmer());
        t1_price.setText(String.valueOf(cart.getPrice()) + " /"+ cart.getWeight());
        t1_amount.setText(String.valueOf(cart.getAmount()));
        t1_total.setText(String.valueOf(cart.getTotal()));

        return convertView;
    }
}
