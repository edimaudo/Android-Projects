package com.edimaudo.addnewlistitem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private ListView listView;
  private ArrayAdapter listAdapter;
  ArrayList<String> listInfo = new ArrayList<>();
  public final static String EXTRA_MESSAGE = "com.edimaudo.addnewlistitem.MESSAGE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);
    listInfo.add("apples");
    listInfo.add("eggs");
    listInfo.add("ham");
    listInfo.add("milk");

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    if(bundle != null){
      listInfo.add(bundle.getString(EXTRA_MESSAGE));

    }
    listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listInfo);
    listView.setAdapter(listAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);

  }

  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_add:
        Intent in = new Intent(this, NewItem.class);
        startActivity(in);
        break;
      default:
        break;
    }

    return true;
  }

  public void updateList(){


    //listInfo.add(String.valueOf(b.get(EXTRA_MESSAGE)));
    //listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listInfo);
    //listView.setAdapter(listAdapter);
  }
}
