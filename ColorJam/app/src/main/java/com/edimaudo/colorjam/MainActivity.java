package com.edimaudo.colorjam;

import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.media.MediaPlayer.OnCompletionListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private ImageView redColor, grayColor, blueColor, orangeColor, yellowColor, pinkColor,
                    greenColor,purpleColor;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    redColor = (ImageView) findViewById(R.id.redColor);
    grayColor = (ImageView) findViewById(R.id.grayColor);
    blueColor = (ImageView) findViewById(R.id.blueColor);
    orangeColor = (ImageView) findViewById(R.id.orangeColor);
    yellowColor = (ImageView) findViewById(R.id.yellowColor);
    pinkColor = (ImageView) findViewById(R.id.pinkColor);
    greenColor = (ImageView) findViewById(R.id.greenColor);
    purpleColor = (ImageView) findViewById(R.id.purpleColor);

    //set color due to bug in API 21 and higher
    ((GradientDrawable)redColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
    ((GradientDrawable)blueColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBlue));
    ((GradientDrawable)greenColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGreen));
    ((GradientDrawable)orangeColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOrange));
    ((GradientDrawable)yellowColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorYellow));
    ((GradientDrawable)pinkColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPink));
    ((GradientDrawable)purpleColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPurple));
    ((GradientDrawable)grayColor.getDrawable()).setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGray));


    redColor.setOnClickListener(this);
    blueColor.setOnClickListener(this);
    greenColor.setOnClickListener(this);
    orangeColor.setOnClickListener(this);
    yellowColor.setOnClickListener(this);
    pinkColor.setOnClickListener(this);
    purpleColor.setOnClickListener(this);
    grayColor.setOnClickListener(this);


  }

  @Override
  public void onClick(View view) {
    MediaPlayer mp = null;
    switch (view.getId()){
      case R.id.redColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.a_note);
        break;
      case R.id.pinkColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.b_note);
        break;
      case R.id.blueColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.c_note);
        break;
      case R.id.greenColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.d_note);
        break;
      case R.id.orangeColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.e_note);
        break;
      case R.id.purpleColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.f_note);
        break;
      case R.id.grayColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.g_note);
        break;
      case R.id.yellowColor:
        mp = MediaPlayer.create(getApplicationContext(), R.raw.tin);
        break;
    }

    if (mp != null){
      mp.setOnCompletionListener(new OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {

          mp.reset();
          mp.release();
          mp=null;
        }

      });
      mp.start();
    }

  }
}
