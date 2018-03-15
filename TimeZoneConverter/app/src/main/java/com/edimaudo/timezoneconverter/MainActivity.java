package com.edimaudo.timezoneconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  SeekBar seekBar = findViewById(R.id.seekBar);
  final TextView userTime = findViewById(R.id.userTime);






  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
        userTime.setText((seekBar.getProgress() < 10 ? "0"
                + Integer.toString(seekBar.getProgress()) : Integer.toString(seekBar.getProgress())) + ":00");
        //userTime.setText(Integer.toString(seekBar.getProgress()));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
  }
}
