package com.edimaudo.coffeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  Integer coffeeAmount = 0;
  TextView textView;
  Integer costAmount = 10;
  Integer finalAmount = 0;
  String outputMessage = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);
  }

  public void reduceClick(View view) {
    if (coffeeAmount < 1){
      outputMessage = "$ 0" ;
    } else {
      coffeeAmount--;
      finalAmount = costAmount * coffeeAmount;
      outputMessage = "$" + Integer.toString(finalAmount);
    }
    textView.setText(outputMessage);
  }

  public void addClick(View view) {
    coffeeAmount++;
    finalAmount = costAmount * coffeeAmount;
    outputMessage = "$" + Integer.toString(finalAmount);
    textView.setText(outputMessage);


  }
}
