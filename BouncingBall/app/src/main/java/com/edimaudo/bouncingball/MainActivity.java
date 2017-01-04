package com.edimaudo.bouncingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView ball;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ball = (ImageView) findViewById(R.id.ball);

    

    ball.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //do something
      }
    });

    ball.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
      }
    });
  }
}
