package com.edimaudo.bouncingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView circleBall,rectangleBorder;
  private int level = 0;
  private int speed = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    circleBall = (ImageView) findViewById(R.id.circleBall);
    rectangleBorder = (ImageView) findViewById(R.id.rectangleBorder);


    //getWindowManager().getDefaultDisplay().getHeight();
    TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
            200.0f, 2000.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
    animation.setDuration(5000);  // animation duration
    //animation.setRepeatCount(5);  // animation repeat count
    animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
    //animation.setFillAfter(true);

    circleBall.startAnimation(animation);
  }

  public void gameReset(){

  }
}
