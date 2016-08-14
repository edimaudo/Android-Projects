package com.edimaudo.listviewsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

  private ListView listView;
  private EditText inputSearch;
  private TextView productName;
  ArrayAdapter<String> adapter;
  ArrayList<HashMap<String, String>> productList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);
    inputSearch = (EditText) findViewById(R.id.inputSearch);

    String products[] =
            {"Dell Inspiron", "HTC 10", "HP Spectre",
            "iPhone 6S", "Samsung Galaxy Note7", "Samsung Galaxy S7",
                    "MacBook Air", "Mac Mini", "MacBook Pro"};

    adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.productName, products);
    listView.setAdapter(adapter);

    inputSearch.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        MainActivity.this.adapter.getFilter().filter(charSequence);
      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    });
  }
}
