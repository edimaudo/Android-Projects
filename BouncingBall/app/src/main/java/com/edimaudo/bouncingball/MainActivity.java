package com.edimaudo.bouncingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView circleBall,rectangleBorder;
  private int level = 1;
  private int duration = 5000;
  private int repeatCount = 10000;
  private float yPosition = 1650.0f;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    circleBall = (ImageView) findViewById(R.id.circleBall);
    rectangleBorder = (ImageView) findViewById(R.id.rectangleBorder);
    playGame();

    circleBall.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
          case MotionEvent.ACTION_DOWN:
            circleBall.clearAnimation();


        }


        return true;
      }
    });



  }

  public void playGame(){

    Animation downAnimation = new TranslateAnimation(0.0f, 0.0f, 100.0f, yPosition);//TranslateAnimation(xFrom,xTo, yFrom,yTo)
    downAnimation.setDuration(duration);  // animation duration
    downAnimation.setRepeatCount(repeatCount);  // animation repeat count
    downAnimation.setRepeatMode(2);   // repeat animation (left to right, right to left )
    downAnimation.setFillEnabled(true);
    //downAnimation.setFillBefore(true);
    downAnimation.setFillAfter(true);
    //downAnimation.setInterpolator(BounceInterpolator());




    downAnimation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {

      }

      @Override
      public void onAnimationEnd(Animation animation) {
        circleBall.clearAnimation();
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });
    circleBall.startAnimation(downAnimation);

  }

  public void gameReset(){
    duration = 5000;
    repeatCount = 10000;
    yPosition = 1650.0f;
  }

  public String nextLevelBlurb(int levelInfo){
    StringBuilder stringInfo = new StringBuilder();
    switch(levelInfo){
      case 1:
        stringInfo.append("Nice job! The next level is: ");

      case 2:
        stringInfo.append("Excellent tap! The next level is: " );
        break;
      case 3:
        stringInfo.append("That was awesome! The next level is: ");
        break;
      case 4:
        stringInfo.append("You are good! The next level is: ");
        break;
      case 5:
        stringInfo.append("Boom! The next level is: ");
        break;
      case 6:
        stringInfo.append("You are a pro! The next level is: ");
        break;
      case 7:
        stringInfo.append("Unbelievable! The next level is: ");
        break;
      case 8:
        stringInfo.append("Insanity! The next level is: ");
        break;
      case 9:
        stringInfo.append("You are on fire! The next level is: ");
        break;
      case 10:
        stringInfo.append("That was crazy! The next level is: ");
        break;
      case 11:
        stringInfo.append("You are on blowing my mind! The next level is: ");
        break;
    }
    stringInfo.append(levelInfo + 1);
    return stringInfo.toString();
  }

}

/*

circleBall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.i("clicked","clicked");
        circleBall.clearAnimation();
        circleBall.setAnimation(null);

        if (level != 12){

          AlertDialog.Builder winBuild = new AlertDialog.Builder(getApplicationContext());
          winBuild.setTitle("Winner!");
          winBuild.setMessage("Oh wow, you won the whole freaking thing");
          winBuild.setPositiveButton("Replay",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      gameReset();
                      playGame();
                    }
                  });
          winBuild.setNegativeButton("Exit",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      MainActivity.this.finish();
                    }
                  });
          winBuild.show();
        } else {
          AlertDialog.Builder winBuild = new AlertDialog.Builder(getApplicationContext());
          winBuild.setTitle("Yay!");
          winBuild.setMessage(nextLevelBlurb(level));
          winBuild.setPositiveButton("Continue",
                  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                      level++;
                      duration-=500;
                      yPosition-=50;
                      playGame();
                    }
                  });
          winBuild.show();
        }
      }

    });
 */


