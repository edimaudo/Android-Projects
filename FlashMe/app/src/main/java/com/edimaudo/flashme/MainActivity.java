package com.edimaudo.flashme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private TextView firstColor, secondColor, thirdColor, fourthColor, fifthColor;
  public final static String EXTRA_MESSAGE = "com.edimaudo.flashme.MESSAGE";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    firstColor = (TextView) findViewById(R.id.firstColor);
    secondColor = (TextView) findViewById(R.id.secondColor);
    thirdColor = (TextView) findViewById(R.id.thirdColor);
    fourthColor = (TextView) findViewById(R.id.fourthColor);
    fifthColor = (TextView) findViewById(R.id.fifthColor);

    firstColor.setOnClickListener(this);
    secondColor.setOnClickListener(this);
    thirdColor.setOnClickListener(this);
    fourthColor.setOnClickListener(this);
    fifthColor.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    StringBuilder colorOption = new StringBuilder();
    switch (view.getId()){
      case R.id.firstColor:
        colorOption.append("firstColor");
        break;
      case R.id.secondColor:
        colorOption.append("secondColor");
        break;
      case R.id.thirdColor:
        colorOption.append("thirdColor");
        break;
      case R.id.fourthColor:
        colorOption.append("fourthColor");
        break;
      case R.id.fifthColor:
        colorOption.append("fifthColor");
        break;
    }

    Intent selectColor = new Intent(this,showColor.class);
    selectColor.putExtra(EXTRA_MESSAGE,colorOption.toString());
    startActivity(selectColor);

  }
}
