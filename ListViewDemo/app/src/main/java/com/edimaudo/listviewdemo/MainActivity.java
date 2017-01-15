package com.edimaudo.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myFriend = (ListView) findViewById(R.id.friendListView);//get friend list view
        final ArrayList<String> friendList = new ArrayList<String>();//create friend arraylist
        //add data to friendlist
        friendList.add("John");
        friendList.add("Micheal");
        friendList.add("Kay");

        //array adapter for friendlist
        ArrayAdapter<String> friendAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friendList);

        //join listview to arrayadapter
        myFriend.setAdapter(friendAdapter);

        //on click functionality
        myFriend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = "Hello ";
                Toast.makeText(getApplicationContext(), message + friendList.get(i) , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
