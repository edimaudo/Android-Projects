package com.edimaudo.pulltorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private ListView listView;
  private ArrayList<String> items = new ArrayList<>();
  private ArrayAdapter itemAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final SwipeRefreshLayout swipeView = (SwipeRefreshLayout) findViewById(R.id.swipe);
    swipeView.setEnabled(false);

    listView = (ListView) findViewById(R.id.listView);
    items.add("Milk");
    items.add("Apples");
    items.add("Ham");
    items.add("Eggs");

    itemAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
    listView.setAdapter(itemAdapter);

    swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        swipeView.setRefreshing(true);
        ( new Handler()).postDelayed(new Runnable() {
          @Override
          public void run() {
            newItems();
            swipeView.setRefreshing(false);
          }
        }, 100);

      }
    });

    listView.setOnScrollListener(new AbsListView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(AbsListView absListView, int i) {

      }

      @Override
      public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (firstVisibleItem == 0)
          swipeView.setEnabled(true);
        else
          swipeView.setEnabled(false);

      }
    });

  }


  public void newItems(){
    items.add("Fish");
    items.add("Carrot");
    items.add("Bread");
    items.add("Chicken");
    items.add("Water");
    itemAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
    listView.setAdapter(itemAdapter);
  }
}
