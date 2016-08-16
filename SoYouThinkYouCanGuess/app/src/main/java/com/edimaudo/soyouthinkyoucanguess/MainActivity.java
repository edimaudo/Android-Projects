package com.edimaudo.soyouthinkyoucanguess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  //Layout information
  private LinearLayout introLayout, gameLayout;
  private TextView easy, medium, hard, gameTypeInfo,numGuess, guessOutcome;
  private EditText userInput;
  private Button guessButton, playAgainButton, homeButton;

  //Game information
  boolean gameEnd = false;
  int min = 1;
  int max = 10;
  int chosen = 0;
  int counter = 0;
  int numberOfGuessesLeft = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    introLayout = (LinearLayout) findViewById(R.id.introLayout);
    gameLayout = (LinearLayout) findViewById(R.id.gameLayout);
    easy = (TextView) findViewById(R.id.easy);
    medium = (TextView) findViewById(R.id.medium);
    hard = (TextView) findViewById(R.id.hard);
    gameTypeInfo = (TextView) findViewById(R.id.gameTypeInfo);
    numGuess = (TextView) findViewById(R.id.numGuess);
    guessOutcome = (TextView) findViewById(R.id.guessOutcome);
    userInput = (EditText) findViewById(R.id.userInput);
    guessButton = (Button) findViewById(R.id.guessButton);
    playAgainButton = (Button) findViewById(R.id.playAgainButton);
    homeButton = (Button) findViewById(R.id.homeButton);

    easy.setOnClickListener(this);
    medium.setOnClickListener(this);
    hard.setOnClickListener(this);
    guessButton.setOnClickListener(this);
    playAgainButton.setOnClickListener(this);
    homeButton.setOnClickListener(this);

    gameLayout.setVisibility(View.INVISIBLE);

  }

  @Override
  public void onClick(View view) {
    Random rand = new Random();

    int option = view.getId();
    switch (option){
      case R.id.easy:
        numberOfGuessesLeft = 3;
        gameTypeInfo.setText(easy.getText().toString());
        numGuess.setText("# of Guesses left: " + String.valueOf(numberOfGuessesLeft));
        introLayout.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        chosen = rand.nextInt((max - min) + 1) + min;

        break;
      case R.id.medium:
        numberOfGuessesLeft = 10;
        gameTypeInfo.setText(medium.getText().toString());
        numGuess.setText("# of Guesses left: " + String.valueOf(numberOfGuessesLeft));
        introLayout.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        max = 100;
        chosen = rand.nextInt((max - min) + 1) + min;
        break;
      case R.id.hard:
        numberOfGuessesLeft = 20;
        gameTypeInfo.setText(hard.getText().toString());
        numGuess.setText("# of Guesses left: " + String.valueOf(numberOfGuessesLeft));
        introLayout.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        max = 1000;
        chosen = rand.nextInt((max - min) + 1) + min;
        break;
      case R.id.guessButton:
        runGame();
        break;
      case R.id.playAgainButton:
        reset();
        numGuess.setText("# of Guesses left: " + String.valueOf(numberOfGuessesLeft));
        break;
      case R.id.homeButton:
        numGuess.setText("# of Guesses Left: ");
        guessOutcome.setText("");
        userInput.setText("");
        counter = 0;
        gameLayout.setVisibility(View.INVISIBLE);
        introLayout.setVisibility(View.VISIBLE);
        break;
    }
  }


  public String guessTaken (int guesses){
    String guessComment = "";
    if (guesses == 1){
      guessComment = "You are a mind reader";
    } else if (guesses > 1 && guesses < 5){
      guessComment = "Most Impressive";
    } else if (guesses > 5 && guesses < 10){
      guessComment = "You can do better than that.";
    } else {
      guessComment = "Better luck next time.";
    }
    return guessComment;
  }

  public void reset(){
    Random rand = new Random();
    chosen = rand.nextInt((max - min) + 1) + min;
    counter = 0;
    gameEnd = false;
    guessOutcome.setText("");
    userInput.setText("");

  }

  public void runGame(){
    int chosenValue = chosen;
    int maxGuess = numberOfGuessesLeft;
    String outcome = "";

      if (userInput.getText().toString().equals("")){
        Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
      } else {
        counter++;
        if(chosenValue == Integer.parseInt(userInput.getText().toString())) {
          gameEnd = true;
          outcome = "You got the correct answer after " + String.valueOf(counter) + " guess(es)";
          guessOutcome.setText(outcome);
        }else if(counter == maxGuess) {
            numGuess.setText("# of Guesses Left: " + String.valueOf(maxGuess - counter));
            outcome = guessTaken(chosen) + " " + "The correct answer is " + String.valueOf(chosen);
            guessOutcome.setText(outcome);
            gameEnd = true;
        } else {
          numGuess.setText("# of Guesses Left: " + String.valueOf(maxGuess - counter));
          if (Integer.parseInt(userInput.getText().toString()) > chosenValue){
            outcome = "The number is too high!";
          } else {
            outcome = "The number is too low!";
          }
          guessOutcome.setText(outcome);

        }
      }
  }

}
