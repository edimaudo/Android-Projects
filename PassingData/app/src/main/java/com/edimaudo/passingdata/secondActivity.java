package com.edimaudo.passingdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
  private TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    textView = (TextView) findViewById(R.id.textView);
    Intent in = getIntent();
    String message = in.getStringExtra(MainActivity.EXTRA_MESSAGE);
    textView.setText(message);

    ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_18dp);
    ab.setDisplayHomeAsUpEnabled(true);
  }

}
