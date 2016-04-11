package com.example.cher.actorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Actor> arrayList = new ArrayList<>();
        arrayList.add(new Actor("Leonardo Dicapiro","Nov 11, 1974","1"));
        arrayList.add(new Actor("Matt Damon","Oct 8, 1970","1"));
        arrayList.add(new Actor("Jennifer Lawrence","August 15, 1990","1"));
        listView = (ListView)findViewById(R.id.listView_id);
        customAdapter = new CustomAdapter(MainActivity.this,arrayList);
        listView.setAdapter(customAdapter);


    }
}
