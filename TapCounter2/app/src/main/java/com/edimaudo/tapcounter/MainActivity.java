package com.edimaudo.tapcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

  public int count = 0;
  public TextView countText;
  public ImageButton add, subtract, reset;
  boolean longCheck = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    countText = (TextView) findViewById(R.id.countText);
    add = (ImageButton) findViewById(R.id.add);
    subtract = (ImageButton) findViewById(R.id.subtract);
    reset = (ImageButton) findViewById(R.id.reset);

    reset.setOnClickListener(this);
    add.setOnClickListener(this);
    subtract.setOnClickListener(this);
    add.setOnLongClickListener(this);
    subtract.setOnLongClickListener(this);

  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.reset:
        longCheck = true;
        reset();
        break;
      case R.id.add:
        longCheck = true;
        addCount();
        break;
      case R.id.subtract:
        longCheck = true;
        subtractCount();
        break;
    }
    showOutput();

  }

  @Override
  public boolean onLongClick(View view) {
    final int  choice = view.getId();

    Thread t = new Thread() {
      @Override
      public void run() {
        try {
          while (!longCheck) {
            Thread.sleep(100);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                switch (choice){
                  case R.id.add:
                    addCount();
                    showOutput();
                    break;
                  case R.id.subtract:
                    subtractCount();
                    showOutput();
                    break;
                }
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

  public void reset(){
    count = 0;
  }

  public void addCount(){
    count++;
  }

  public void subtractCount(){
    count--;
  }

  public void showOutput(){
    countText.setText(String.valueOf(count));
  }

}

