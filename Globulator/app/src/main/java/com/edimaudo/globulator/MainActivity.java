package com.edimaudo.globulator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private RelativeLayout relativeLayout;
  private TextView info;
  Paint paint;
  Canvas canvas;
  Bitmap bg;
  int width = 0;
  int height = 0;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    info = (TextView) findViewById(R.id.info);
    relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

    bg = Bitmap.createBitmap(getWindowManager().getDefaultDisplay().getWidth(),
            getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
    canvas = new Canvas(bg);
    paint = new Paint();
    canvas.drawPaint(paint);

    relativeLayout.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        info.setVisibility(View.INVISIBLE);
        width = (int) motionEvent.getX();
        height = (int) motionEvent.getY();
        generateCircle();
        return false;
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        width = (int)event.getX();
        height = (int)event.getY();
        break;
    }

    return true;
  }

  public void generateCircle(){

    Random random = new Random();

    final int RADIUS = 145;
    final String [] colorArray = {"#CD5C5C","#F22613","#BF55EC","#3498DB","#87D37C","#F89406",
            "#F9BF3B","#D2527F"};

    int radius = random.nextInt(RADIUS) + 100;

    paint.setColor(Color.parseColor(colorArray[random.nextInt(colorArray.length)]));

    canvas.drawCircle(width, height, radius, paint);

    relativeLayout.setBackground(new BitmapDrawable(bg));
  }
}
