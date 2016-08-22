package com.edimaudo.materialdesignsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

  private ListView listView;
  private EditText inputSearch;
  ArrayAdapter<String> adapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    listView = (ListView) findViewById(R.id.listView);
    inputSearch = (EditText) findViewById(R.id.inputSearch);

    String countries[] =
            {"Algeria","United States","France", "Brazil", "Chnia", "Israel","Germany",
            "Latvia", "Russia","Liberia","Gerogia","New Zealand","New Guinea",
            "Phillipines","Greece","South Africa","Mali"};

    adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.countryName, countries);
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
