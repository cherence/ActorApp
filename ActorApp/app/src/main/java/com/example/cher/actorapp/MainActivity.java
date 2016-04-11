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
        ArrayList<Actor> mActorArrayList = new ArrayList<>();
        mActorArrayList.add(new Actor("Brad Pitt", "Nov 11, 1974", "2"));
        mActorArrayList.add(new Actor("Seth Rogen", "Oct 8, 1970", "1"));
        mActorArrayList.add(new Actor("Jennifer Aniston", "August 15, 1990", "1"));
        listView = (ListView)findViewById(R.id.listView_id);
        customAdapter = new CustomAdapter(MainActivity.this,mActorArrayList);
        listView.setAdapter(customAdapter);


    }
}