package com.edimaudo.rockpaperscissors;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private ImageView playerImage, computerImage;
  private TextView gameBlurb;
  private Button rockButton, scissorsButton, paperButton;
  Animation anim;
  String userSelection = "";
  String computerSelection = "";
  String chosenOutcome = "";
  boolean isInterrupted = false;
  private Thread thread;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    computerImage = (ImageView) findViewById(R.id.computerImage);
    playerImage = (ImageView) findViewById(R.id.playerImage);
    gameBlurb = (TextView) findViewById(R.id.gameBlurb);
    rockButton = (Button) findViewById(R.id.rockButton);
    scissorsButton = (Button) findViewById(R.id.scissorsButton);
    paperButton = (Button) findViewById(R.id.paperButton);

    rockButton.setOnClickListener(this);
    scissorsButton.setOnClickListener(this);
    paperButton.setOnClickListener(this);



  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.paperButton:
        userSelection = "paper";
        break;
      case R.id.scissorsButton:
        userSelection = "scissors";
        break;
      case R.id.rockButton:
        userSelection = "rock";
        break;
    }
    playGame();
  }

  public void playGame(){
    computerImage.setImageDrawable(getResources().getDrawable(R.drawable.left_fist, getApplicationContext().getTheme()));
    playerImage.setImageDrawable(getResources().getDrawable(R.drawable.right_fist, getApplicationContext().getTheme()));
    anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up_down);
    computerImage.setAnimation(anim);
    playerImage.setAnimation(anim);

    Random rand = new Random();
    String [] gameItems = {"rock","paper","scissors"};
    computerSelection = gameItems[rand.nextInt(gameItems.length)];
    chosenOutcome = gameOutcome(userSelection,computerSelection);

    new CountDownTimer(100,1000){

      @Override
      public void onTick(long miliseconds){}

      @Override
      public void onFinish(){
        showOutcome();
      }
    }.start();


  }

  public void showOutcome(){
    showImage(userSelection,playerImage);
    showImage(computerSelection,computerImage);
    gameBlurb.setText(chosenOutcome);

  }

  public String gameOutcome(String userOption, String computerOption){
    String outcome = "";
    if(userOption.equals(computerOption)){
      outcome = "Tie";
    } else if (computerOption.equals("rock") && userOption.equals("scissors") ||
            computerOption.equals("scissors") && userOption.equals("paper") ||
            computerOption.equals("paper") && userOption.equals("rock")){
      outcome = "Computer wins";
    } else {
      outcome = "You win";
    }
    return outcome;
  }

  public void showImage(String option,ImageView view){
    switch(option){
      case "rock":
        view.setImageDrawable(getResources().getDrawable(R.drawable.rock, getApplicationContext().getTheme()));
        break;
      case "paper":
        view.setImageDrawable(getResources().getDrawable(R.drawable.paper, getApplicationContext().getTheme()));
        break;
      case "scissors":
        view.setImageDrawable(getResources().getDrawable(R.drawable.scissors, getApplicationContext().getTheme()));
        break;
    }
  }
}
