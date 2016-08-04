package com.edimaudo.basictable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
  private ListView listView;

  private String[] item = {"milk","apples","ham","eggs","pancakes","cereal"};
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);
    ArrayAdapter listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,item);
    listView.setAdapter(listAdapter);

  }
}
