package com.edimaudo.paintamondrian;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private TextView textView1,textView2,textView3,textView4, textView5, textView6, textView7,
  textView8, textView9;

  private Button redButton, blueButton, yellowButton, whiteButton;
  String currentColor = "white";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView1 = (TextView) findViewById(R.id.textView1);
    textView2 = (TextView) findViewById(R.id.textView2);
    textView3 = (TextView) findViewById(R.id.textView3);
    textView4 = (TextView) findViewById(R.id.textView4);
    textView5 = (TextView) findViewById(R.id.textView5);
    textView6 = (TextView) findViewById(R.id.textView6);
    textView7 = (TextView) findViewById(R.id.textView7);
    textView8 = (TextView) findViewById(R.id.textView8);
    textView9 = (TextView) findViewById(R.id.textView9);

    redButton = (Button) findViewById(R.id.redButton);
    blueButton = (Button) findViewById(R.id.blueButton);
    yellowButton = (Button) findViewById(R.id.yellowButton);
    whiteButton = (Button) findViewById(R.id.whiteButton);

    redButton.setOnClickListener(this);
    blueButton.setOnClickListener(this);
    yellowButton.setOnClickListener(this);
    whiteButton.setOnClickListener(this);

    textView1.setOnClickListener(this);
    textView2.setOnClickListener(this);
    textView3.setOnClickListener(this);
    textView4.setOnClickListener(this);
    textView5.setOnClickListener(this);
    textView6.setOnClickListener(this);
    textView7.setOnClickListener(this);
    textView8.setOnClickListener(this);
    textView9.setOnClickListener(this);
  }



  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.redButton:
        currentColor = "red";
        break;
      case R.id.blueButton:
        currentColor = "blue";
        break;
      case R.id.yellowButton:
        currentColor = "yellow";
        break;
      case R.id.whiteButton:
        currentColor = "white";
        break;
      case R.id.textView1:
        updateViewColor(textView1);
        break;
      case R.id.textView2:
        updateViewColor(textView2);
        break;
      case R.id.textView3:
        updateViewColor(textView3);
        break;
      case R.id.textView4:
        updateViewColor(textView4);
        break;
      case R.id.textView5:
        updateViewColor(textView5);
        break;
      case R.id.textView6:
        updateViewColor(textView6);
        break;
      case R.id.textView7:
        updateViewColor(textView7);
        break;
      case R.id.textView8:
        updateViewColor(textView8);
        break;
      case R.id.textView9:
        updateViewColor(textView9);
        break;
    }
  }


  public void updateViewColor(View view){
    if(currentColor.equals("red")){
      view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorRed));
    } else if (currentColor.equals("blue")){
      view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
    } else if (currentColor.equals("yellow")){
      view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorYellow));
    } else {
      view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorWhite));
    }


  }
}
