package com.edimaudo.simplegridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.grid_layout);

    GridView gridView = (GridView) findViewById(R.id.grid_view);

    // Instance of ImageAdapter Class
    gridView.setAdapter(new ImageAdapter(this));
  }
}
