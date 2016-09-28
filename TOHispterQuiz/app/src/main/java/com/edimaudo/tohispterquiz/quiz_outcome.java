package com.edimaudo.tohispterquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class quiz_outcome extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz_outcome);


    Intent in = getIntent();
    String message = in.getStringExtra(MainActivity.EXTRA_MESSAGE);
  }
}
