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
        ArrayList<Actor> mActorsList = new ArrayList<>();
        mActorsList.add(new Actor("Ben Stiller", "Nov 30, 1965", "1"));
        mActorsList.add(new Actor("Owen Wilson", "Nov 18, 1968", "1"));
        mActorsList.add(new Actor("Will Ferrell", "July 16, 1967", "1"));
        listView = (ListView)findViewById(R.id.listView_id);
        customAdapter = new CustomAdapter(MainActivity.this,mActorsList);
        listView.setAdapter(customAdapter);
    }
}