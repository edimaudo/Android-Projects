package com.edimaudo.swapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SearchActivity extends AppCompatActivity {

  private String searchItem;
  private String spinnerItem;
  RequestQueue requestQueue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    Bundle bundle = getIntent().getExtras();
    if (bundle != null){
      searchItem = bundle.getString("searchTerm");
      spinnerItem = bundle.getString("spinnerTerm");
    }

    requestQueue = Volley.newRequestQueue(this);


  }

  String url = getResources().getString(R.string.api_url);

}
