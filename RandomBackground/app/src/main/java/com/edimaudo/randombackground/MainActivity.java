package com.edimaudo.randombackground;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private Button buttonInfo;
  private RelativeLayout mainLayout;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonInfo = (Button) findViewById(R.id.buttonInfo);
    mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);

    buttonInfo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final int maxNum = 256;
        Random rand = new Random();
        int redColor = rand.nextInt(maxNum);
        int blueColor = rand.nextInt(maxNum);
        int greenColor = rand.nextInt(maxNum);
        mainLayout.setBackgroundColor(Color.rgb(redColor,greenColor,blueColor));
      }
    });
  }
}
