package com.edimaudo.timezoneconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  SeekBar seekBar = findViewById(R.id.seekBar);
  TextView userTime = findViewById(R.id.userTime);

  


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
