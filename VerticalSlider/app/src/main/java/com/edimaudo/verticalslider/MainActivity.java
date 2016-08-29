package com.edimaudo.verticalslider;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private RelativeLayout relativeLayout;
  private LinearLayout slider;
  private TextView content;
  int score = 0;
  private Animation animUp;
  private Animation animDown;
  private float startY = 0.0f;
  private float endY;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    slider = (LinearLayout) findViewById(R.id.slider);
    content = (TextView) findViewById(R.id.content);
    animUp = AnimationUtils.loadAnimation(this, R.anim.anim_up);
    animDown = AnimationUtils.loadAnimation(this, R.anim.anim_down);
    updateScreen(score);

  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        startY = event.getY();
        break;

      case MotionEvent.ACTION_UP:
        endY = event.getY();

        break;
    }
    return true;
  }

  public void updateScreen(int value){
    switch(value){
      case 0:
        relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBrown));
        content.setText("First");
        break;
      case 1:
        relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBlack));
        content.setText("Second");
        break;
      case 2:
        relativeLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
        content.setText("Third");
    }
  }
}
