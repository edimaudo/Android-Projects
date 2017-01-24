package com.edimaudo.seeingspots;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity implements View.OnClickListener {

  private TextView averageScore, roundInfo;
  private Button button1, button2, button3, button4, button5, button6, button7,
          button8, button9, button10;
  public int round = 10;
  public int average = 0;
  public int num = 0;
  ValueAnimator animator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    averageScore = (TextView) findViewById(R.id.averageScore);
    roundInfo = (TextView) findViewById(R.id.roundInfo);

    button1 = (Button) findViewById(R.id.button1);
    button2 = (Button) findViewById(R.id.button2);
    button3 = (Button) findViewById(R.id.button3);
    button4 = (Button) findViewById(R.id.button4);
    button5 = (Button) findViewById(R.id.button5);
    button6 = (Button) findViewById(R.id.button6);
    button7 = (Button) findViewById(R.id.button7);
    button8 = (Button) findViewById(R.id.button8);
    button9 = (Button) findViewById(R.id.button9);
    button10 = (Button) findViewById(R.id.button10);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    button5.setOnClickListener(this);
    button6.setOnClickListener(this);
    button7.setOnClickListener(this);
    button8.setOnClickListener(this);
    button9.setOnClickListener(this);
    button10.setOnClickListener(this);

    playGame();
  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.button1:
        num = 1;
        break;
      case R.id.button2:
        num = 2;
        break;
      case R.id.button3:
        num = 3;
        break;
      case R.id.button4:
        num = 4;
        break;
      case R.id.button5:
        num = 5;
        break;
      case R.id.button6:
        num = 6;
        break;
      case R.id.button7:
        num = 7;
        break;
      case R.id.button8:
        num = 8;
        break;
      case R.id.button9:
        num = 9;
        break;
      case R.id.button10:
        num = 10;
        break;
    }
  }

  public void playGame(){
    if (round == 0){
      AlertDialog.Builder winBuild = new AlertDialog.Builder(Game.this,R.style.MyDialogTheme);
      winBuild.setTitle("Game Over!");
      winBuild.setPositiveButton("Replay?",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  //generateAnimation();
                }
              });
      winBuild.setNegativeButton("Exit",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  Game.this.finish();
                }
              });
      AlertDialog dialog = winBuild.create();
      dialog.show();
    } else {
      int userInput = num;
      round = round - 1;
    }
  }
  public void generateAnimation(){
    Random random = new Random();
    int circle = random.nextInt(9) + 1;

    DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    int height = displaymetrics.heightPixels;
    int width = displaymetrics.widthPixels;


  }
  public void updateGameInfo(){
    //averageScore,
    //        roundInfo;
  }

}
