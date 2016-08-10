package com.edimaudo.fizzbuzzer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button startButton, enterButton;
  private LinearLayout intro,game;
  private TextView gameMiss, gameScore, gameGoal, fizzBuzzNum;
  private EditText userInput;
  private int score = 0;
  private int miss = 0;
  private int choice = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    intro = (LinearLayout) findViewById(R.id.intro);
    game = (LinearLayout) findViewById(R.id.game);

    fizzBuzzNum = (TextView) findViewById(R.id.fizzBuzzNum);
    gameGoal = (TextView) findViewById(R.id.gameGoal);
    gameScore = (TextView) findViewById(R.id.gameScore);
    gameMiss = (TextView) findViewById(R.id.gameMiss);
    userInput = (EditText) findViewById(R.id.userInput);
    startButton = (Button) findViewById(R.id.startButton);
    enterButton = (Button) findViewById(R.id.enterButton);

    startButton.setOnClickListener(this);
    enterButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.startButton:
        intro.setVisibility(View.INVISIBLE);
        game.setVisibility(View.VISIBLE);
        generateNumber();
        break;
      case  R.id.enterButton:
        checkUserInput();
        break;

    }
  }

  public void generateNumber(){
    int goal = 10;
    String winText = "Congrats you won!";
    Random rand = new Random();
    choice = rand.nextInt(1000);
    if(score == goal){
      fizzBuzzNum.setText(winText);
      AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
      newDialog.setTitle("Fizz Buzzer Game");
      newDialog.setMessage("Start new game)?");
      newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int which){
          resetGame();
          dialog.dismiss();
        }
      });
      newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int which){
          dialog.cancel();
        }
      });
      newDialog.show();

    } else {
      fizzBuzzNum.setText(String.valueOf(choice));
    }
  }

  public void checkUserInput(){
    String input = userInput.getText().toString();
    if (input.equals("")){
      Toast.makeText(MainActivity.this, "Please enter either fizz, buzz, fizz buzz or not fizz buzz", Toast.LENGTH_SHORT).show();
    } else {
      if(input.equals(validateInput(choice))){
        score++;
        gameScore.setText(String.valueOf("Score:" + score));
      } else {
        miss++;
        gameMiss.setText(String.valueOf("Missing: " + miss));
      }
      Log.i("choice",String.valueOf(choice));
      Log.i("choice",validateInput(choice));
      userInput.setText("");
      generateNumber();
    }
  }

  public String validateInput(int value){
    StringBuilder stringInfo = new StringBuilder();
    if (choice % 15 == 0){
      stringInfo.append("fizz buzz");
    } else if (choice % 3 == 0){
      stringInfo.append("fizz");
    } else if (choice % 5 == 0){
      stringInfo.append("buzz");
    } else {
      stringInfo.append("not fizz buzz");
    }
    return stringInfo.toString();
  }

  public void resetGame(){
    score = 0;
    miss = 0;
    gameScore.setText(String.valueOf("Score:" + score));
    gameMiss.setText(String.valueOf("Missing: " + miss));
    generateNumber();
  }
}
