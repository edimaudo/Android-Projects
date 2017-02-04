package com.edimaudo.simon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class game extends AppCompatActivity implements View.OnClickListener {
  private TextView yellowColor, blueColor, redColor, greenColor, level;
  int levelNo = 1;
  boolean correctSequence = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    level = (TextView) findViewById(R.id.level);
    yellowColor = (TextView) findViewById(R.id.yellowColor);
    blueColor = (TextView) findViewById(R.id.blueColor);
    greenColor = (TextView) findViewById(R.id.greenColor);
    redColor = (TextView) findViewById(R.id.redColor);

    yellowColor.setOnClickListener(this);
    blueColor.setOnClickListener(this);
    greenColor.setOnClickListener(this);
    redColor.setOnClickListener(this);

    playGame();

  }

  public void playGame(){
    if (levelNo == 11){
      AlertDialog.Builder winBuild = new AlertDialog.Builder(game.this);
      winBuild.setTitle("Yay!");
      winBuild.setPositiveButton("Replay",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  levelNo = 1;
                  playGame();
                }
              });
      winBuild.setNegativeButton("Exit",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  game.this.finish();
                }
              });
      AlertDialog dialog = winBuild.create();
      dialog.show();
    } else {

    }
  }

  public void generateSequence(){

  }

  @Override
  public void onClick(View v) {
    int choice = v.getId();
    switch (choice){
      case R.id.yellowColor:
        break;
      case R.id.redColor:
        break;
      case R.id.blueColor:
        break;
      case R.id.greenColor:
        break;
    }
  }
}
