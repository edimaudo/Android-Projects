package com.edimaudo.seeingspots;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class game extends AppCompatActivity {

  private TextView roundInfo, winInfo, gameResult;
  private EditText userInput;
  private Button submitButton;
  private RelativeLayout relativeLayout;

  int roundsLeft = 10;
  int winCount = 0;

  Paint paint;
  Canvas canvas;
  Bitmap bg;
  int width = 0;
  int height = 0;

  int MAX_X_VALUE = 2000;
  int MAX_Y_VALUE = 2000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);


    roundInfo = (TextView) findViewById(R.id.roundInfo);
    winInfo = (TextView) findViewById(R.id.winInfo);
    gameResult = (TextView) findViewById(R.id.gameResult);
    userInput = (EditText) findViewById(R.id.userInput);
    submitButton = (Button) findViewById(R.id.submitButton);
    relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);



    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       
      }
    });

  }



  public void resetGame(){
    roundsLeft = 10;
    winCount = 0;
    roundInfo.setText("Rounds left: 10");
    winInfo.setText("Wins: 0");
    playGame();
  }

  public void playGame(){
    if(roundsLeft == 0){
      AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
      winBuild.setTitle("Yay!");
      winBuild.setMessage("Congrats! you won!");
      winBuild.setPositiveButton("Play Again?",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  resetGame();
                }
              });
      winBuild.setNegativeButton("Exit",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  game.this.finish();
                }
              });
      winBuild.show();
    } else {

    }
  }
}
