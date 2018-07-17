package com.example.android.goldenshoe;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoesAdapter extends ArrayAdapter<Shoes> {

    public ShoesAdapter(Activity context, ArrayList<Shoes> shoez) {

        super(context, 0, shoez);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView; //all views (grouped)
        if(convertView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // Get the object located at this position in the list
        Shoes currentShoes = getItem(position);

        ImageView pictureView = (ImageView) listItemView.findViewById(R.id.pic);
        pictureView.setImageResource(currentShoes.getMainImage());


        TextView descView = (TextView) listItemView.findViewById(R.id.name);
        descView.setText(currentShoes.getName());

        TextView priceView = (TextView) listItemView.findViewById(R.id.price);
        priceView.setText("£" + currentShoes.getPrice());

        ImageView heartView = (ImageView) listItemView.findViewById(R.id.heart);



        return listItemView;
    }


}
