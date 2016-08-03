package com.edimaudo.tapholdcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
  private Button reset, tapHold;
  private TextView counter;
  int count = 0;
  boolean isTouch = false;
  boolean isLongPress = false;
  int testcount = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    reset = (Button) findViewById(R.id.reset);
    tapHold = (Button) findViewById(R.id.tapHold);
    counter = (TextView) findViewById(R.id.counter);

    reset.setOnClickListener(this);
    tapHold.setOnClickListener(this);
    tapHold.setOnLongClickListener(this);
    //tapHold.setOnTouchListener(this);

  }


  public void reset(){
    count = 0;
  }


  public void addCount(){
    count++;
  }

  public void showOutput(){
    counter.setText(String.valueOf(count));
  }


  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.reset:
        reset();
        break;
      case R.id.tapHold:
        addCount();
        break;
    }
    showOutput();
  }


  @Override
  public boolean onLongClick(View view) {
    new Thread() {
      public void run() {
        int tempCount = 0;
        boolean isPressed = true;
        while (isPressed) {
          tempCount++;
          counter.setText(String.valueOf(tempCount + count));
        }
      }
    };
    testcount++;
    Log.i("count",String.valueOf(count));
    Log.i("testcount",String.valueOf(testcount));


    return true;
  }
}
