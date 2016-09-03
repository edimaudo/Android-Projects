package com.edimaudo.bouncingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView circleBall,rectangleBorder;
  private int level = 1;
  private float speed = 0.0f;
  private int duration = 0;
  private int repeatCount = 10000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    circleBall = (ImageView) findViewById(R.id.circleBall);
    rectangleBorder = (ImageView) findViewById(R.id.rectangleBorder);
    playGame();

    circleBall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        level++;
        nextLevelBlurb(level);
      }
    });


  }

  public void playGame(){
    //float distance = getWindowManager().getDefaultDisplay().getHeight();

    Animation downAnimation = new TranslateAnimation(0.0f, 0.0f, 100.0f, 1650.0f);//TranslateAnimation(xFrom,xTo, yFrom,yTo)

    downAnimation.setDuration(5000);  // animation duration
    downAnimation.setRepeatCount(5);  // animation repeat count
    downAnimation.setRepeatMode(2);   // repeat animation (left to right, right to left )
    downAnimation.setFillAfter(true);

    circleBall.startAnimation(downAnimation);
    downAnimation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {

      }

      @Override
      public void onAnimationEnd(Animation animation) {
        //Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });
  }

  public void gameReset(){

  }

  public String nextLevelBlurb(int levelInfo){
    String output = "";
    switch(levelInfo){
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        break;
      case 7:
        break;
      case 8:
        break;
      case 9:
        break;
      case 10:
        break;
    }
    return output;
  }

  /*
  AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
        winBuild.setTitle("Yay!");
        winBuild.setMessage("You win!\n\nThe answer was:\n\n" + currWord);
        winBuild.setPositiveButton("Play Again",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                    MainActivity.this.playGame();
                  }
                });

        winBuild.setNegativeButton("Exit",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                    MainActivity.this.finish();
                  }
                });

        winBuild.show();
      }
   */
}
