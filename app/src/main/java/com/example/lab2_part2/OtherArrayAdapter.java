package com.example.lab2_part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class OtherArrayAdapter extends ArrayAdapter<String> {
    public OtherArrayAdapter(Context context, ArrayList<String> arrayList){
        super(context,0,arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String string = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
        // Lookup view for data population
//                TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//                TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        //        tvName.setText(user.name);
        //        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
