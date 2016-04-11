package com.example.cher.actorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adao1 on 4/11/2016.
 */
public class CustomAdapter extends ArrayAdapter {
    ArrayList<Actor> arrayList;

    public CustomAdapter(Context context,ArrayList<Actor> actorArrayList) {
        super(context, -1, actorArrayList);
        arrayList = actorArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        TextView name = (TextView)rowItem.findViewById(R.id.name_textView_id);
        TextView dob = (TextView)rowItem.findViewById(R.id.dob_textView_id);
        TextView oscars = (TextView)rowItem.findViewById(R.id.oscarsWon_textView_id);
        name.setText("Name: " +arrayList.get(position).getName());
        dob.setText("DOB: "+arrayList.get(position).getDob());
        oscars.setText("Oscars Won: "+arrayList.get(position).getOscars());
        return rowItem;
    }
}
