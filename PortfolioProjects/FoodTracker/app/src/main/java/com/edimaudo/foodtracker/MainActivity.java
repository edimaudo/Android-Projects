package com.edimaudo.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

  private ListView mainListView;
  private FloatingActionButton addFood;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainListView = (ListView) findViewById(R.id.mainListView);
    addFood = (FloatingActionButton) findViewById(R.id.addFood);

    addFood.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent addFoodIntent = new Intent(MainActivity.this, FoodAdd.class);
        startActivity(addFoodIntent);
      }
    });

    final FoodDB foodDB = new FoodDB(this);
    mainListView.setAdapter(new FoodListAdapter(this,foodDB.findAll()));

    mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Food food = foodDB.findAll().get(i);
        Intent detailIntent = new Intent(MainActivity.this, FoodDetails.class);
        detailIntent.putExtra("food",food);
        startActivity(detailIntent);
      }
    });



  }
}
