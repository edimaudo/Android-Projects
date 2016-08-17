package com.edimaudo.tapholdcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
  private Button reset, tapHold;
  private TextView counter;
  int count = 0;
  boolean longCheck = false;


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
        longCheck = true;
        reset();
        break;
      case R.id.tapHold:
        addCount();
        longCheck = true;
        break;
    }
    showOutput();
  }


  @Override
  public boolean onLongClick(View view) {
    Thread t = new Thread() {

      @Override
      public void run() {
        try {
          while (!longCheck) {
            Thread.sleep(100);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                addCount();
                showOutput();

              }
            });
          }
        } catch (InterruptedException e) {
        }
      }
    };
    longCheck = false;
    t.start();

    return false;
  }
}
