package com.edimaudo.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    static Set<String> set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.edimaudo.notes", Context.MODE_PRIVATE);
        set = sharedPreferences.getStringSet("notes",null);
        notes.clear();

        if (set != null){
            notes.addAll(set);
        } else {
            set = new HashSet<String>();
            notes.add("Example note");
            set.addAll(notes);
            sharedPreferences.edit().putStringSet("notes",set).apply();
        }

        notes.add("Example note");

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,notes);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getApplicationContext(),EditYourNote.class);
                in.putExtra("noteId",i);
                startActivity(in);
            }
        });


    }
}
