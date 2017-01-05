package com.edimaudo.bouncingball;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView ball;
  ValueAnimator animator;
  Long speed = 2600L;
  int Level = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ball = (ImageView) findViewById(R.id.ball);

    generateAnimation();

    ball.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        animator.end();
        String[] winWords = {"","Nice job!","Excellent Touch!","That was awesome!",
                "You are good!","Boom!","You are a Pro!","Unbelievable!","Insanity!",
                "You are on fire!","That was crazy!","You are blowing my mind!","Winner!"};
        AlertDialog.Builder winBuild = new AlertDialog.Builder(MainActivity.this,R.style.MyDialogTheme);
        winBuild.setTitle("Yay!");
        if (Level == 12){
          Level = 1;
          speed = 2600L;
          winBuild.setPositiveButton("Replay",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      generateAnimation();
                    }
                  });
           winBuild.setNegativeButton("Exit",
                   new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                       MainActivity.this.finish();
                     }
                   });

        }
        else {
          winBuild.setMessage(winWords[Level] + "\n" + "Next level: " + Integer.toString(Level+1));
          Level+=1;
          speed-=200;
          winBuild.setPositiveButton("Continue",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      generateAnimation();
                    }
                  });
        }
        AlertDialog dialog = winBuild.create();
        dialog.show();

      }
    });

  }

  public void  generateAnimation(){
    DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    int height = displaymetrics.heightPixels;

    animator = ValueAnimator.ofFloat(0, height - 800);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {

        float value = (float) animation.getAnimatedValue();
        ball.setTranslationY(value);
      }

    });

    animator.setRepeatMode(ValueAnimator.REVERSE);
    animator.setRepeatCount(10000);
    animator.setDuration(speed);
    animator.start();


  }
}
