package com.edimaudo.technicolorboxes;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private TextView textView1,textView2,textView3,textView4;
  private TextView textView5,textView6,textView7,textView8;
  private TextView textView9,textView10,textView11,textView12;
  private TextView textView13,textView14,textView15,textView16;

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
    textView10 = (TextView) findViewById(R.id.textView10);
    textView11 = (TextView) findViewById(R.id.textView11);
    textView12 = (TextView) findViewById(R.id.textView12);
    textView13 = (TextView) findViewById(R.id.textView13);
    textView14 = (TextView) findViewById(R.id.textView14);
    textView15 = (TextView) findViewById(R.id.textView15);
    textView16 = (TextView) findViewById(R.id.textView16);

    textView1.setOnClickListener(this);
    textView2.setOnClickListener(this);
    textView3.setOnClickListener(this);
    textView4.setOnClickListener(this);
    textView5.setOnClickListener(this);
    textView6.setOnClickListener(this);
    textView7.setOnClickListener(this);
    textView8.setOnClickListener(this);
    textView9.setOnClickListener(this);
    textView10.setOnClickListener(this);
    textView11.setOnClickListener(this);
    textView12.setOnClickListener(this);
    textView13.setOnClickListener(this);
    textView14.setOnClickListener(this);
    textView15.setOnClickListener(this);
    textView16.setOnClickListener(this);

    Toast.makeText(MainActivity.this, "Tap the center", Toast.LENGTH_LONG).show();
  }

  @Override
  public void onClick(View view) {
    final int maxColor = 255;
    Random rand = new Random();
    int red = rand.nextInt(maxColor);
    int green = rand.nextInt(maxColor);
    int blue = rand.nextInt(maxColor);
    switch (view.getId()){
      case R.id.textView1:
        textView1.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView2:
        textView2.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView3:
        textView3.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView4:
        textView4.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView5:
        textView5.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView6:
        textView6.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView7:
        textView7.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView8:
        textView8.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView9:
        textView9.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView10:
        textView10.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView11:
        textView11.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView12:
        textView12.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView13:
        textView13.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView14:
        textView14.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView15:
        textView15.setBackgroundColor(Color.rgb(red,green,blue));
        break;
      case R.id.textView16:
        textView16.setBackgroundColor(Color.rgb(red,green,blue));
        break;
    }
  }

}
