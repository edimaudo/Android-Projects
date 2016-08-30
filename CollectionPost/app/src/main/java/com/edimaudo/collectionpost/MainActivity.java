package com.edimaudo.collectionpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
  GridView gridView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.grid_layout);

    gridView = (GridView) findViewById(R.id.grid_view);
    gridView.setAdapter(new ImageAdapter(this));

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent itemIntent = new Intent(getApplicationContext(),FullImage.class);
        itemIntent.putExtra("id", i);
        startActivity(itemIntent);
      }
    });


  }
}
