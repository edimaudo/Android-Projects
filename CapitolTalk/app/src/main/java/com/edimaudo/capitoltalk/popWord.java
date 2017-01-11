package com.edimaudo.capitoltalk;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;

public class popWord extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pop_word);

    SearchView searchView = (SearchView) findViewById(R.id.search);
    SearchManager searchManager =
            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    searchView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        //searchFor(query);
        //Intent intent = getIntent();
        //if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
        //  String query = intent.getStringExtra(SearchManager.QUERY);
        //  doMySearch(query);
        //}
        return true;
      }

      @Override
      public boolean onQueryTextChange(String query) {
        //filterSearchFor(query);
        return true;
      }
    });
  }
}
