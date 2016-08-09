package com.edimaudo.stopwatch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private TextView stopWatchText;
  private Button startButton, pauseButton, resetButton;
  private Handler customHandler = new Handler();
  private long startTime = 0L;
  long timeInMilliseconds = 0L;
  long timeSwapBuff = 0L;
  long updatedTime = 0L;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/digital-7.ttf");
    stopWatchText = (TextView) findViewById(R.id.stopWatchText);
    startButton = (Button) findViewById(R.id.startButton);
    pauseButton = (Button) findViewById(R.id.pauseButton);
    resetButton = (Button) findViewById(R.id.resetButton);

    stopWatchText.setTypeface(font);
    startButton.setTypeface(font);
    resetButton.setTypeface(font);
    pauseButton.setTypeface(font);

    startButton.setOnClickListener(this);
    pauseButton.setOnClickListener(this);
    resetButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.startButton:
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);
        break;
      case R.id.pauseButton:
        timeSwapBuff += timeInMilliseconds;
        customHandler.removeCallbacks(updateTimerThread);
        break;
      case R.id.resetButton:
        stopWatchText.setText("00:00:00");
        break;
    }
  }

  private Runnable updateTimerThread = new Runnable() {

    public void run() {

      timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

      updatedTime = timeSwapBuff + timeInMilliseconds;

      int secs = (int) (updatedTime / 1000);
      int mins = secs / 60;
      secs = secs % 60;
      int hour = mins /60;
      stopWatchText.setText(String.format("%02d",hour) + ":" + String.format("%02d",mins)
              + ":" + String.format("%02d", secs));
      customHandler.postDelayed(this, 0);
    }

  };


}
