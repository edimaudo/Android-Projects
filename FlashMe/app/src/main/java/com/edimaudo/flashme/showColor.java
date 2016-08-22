package com.edimaudo.flashme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class showColor extends AppCompatActivity {

  private RelativeLayout colorLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_color);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);

    colorLayout = (RelativeLayout) findViewById(R.id.colorLayout);

    Intent in = getIntent();
    String message = in.getStringExtra(MainActivity.EXTRA_MESSAGE);
    switch(message){
      case "firstColor":
        colorLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorFirst));
        break;
      case "secondColor":
        colorLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSecond));
        break;
      case "thirdColor":
        colorLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorThird));
        break;
      case "fourthColor":
        colorLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorFourth));
        break;
      case "fifthColor":
        colorLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorFifth));
        break;
    }

    Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
    animation.setDuration(100); // duration - half a second
    animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
    animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
    animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the layout will ade back in
    colorLayout.startAnimation(animation);



  }
}
