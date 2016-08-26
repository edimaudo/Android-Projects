package com.edimaudo.scrambled;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class game extends AppCompatActivity {
  final String intro = "Here is your word to unscramble";
  final String correctAnswer = "Congrats! You got the right word";

  private TextView scoreInfo, game_blurb,wordToGuess;
  private EditText guessAnswer;
  private Button guessButton;
  int score = 0;
  int guessCount = 0;
  int gameMax = 3;
  String chosenWord = "";
  String scrambleWord = "";
  boolean isInterrupted = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    scoreInfo = (TextView) findViewById(R.id.scoreInfo);
    game_blurb = (TextView) findViewById(R.id.game_blurb);
    wordToGuess = (TextView) findViewById(R.id.wordToGuess);
    guessAnswer = (EditText) findViewById(R.id.guessAnswer);
    guessButton = (Button) findViewById(R.id.guessButton);

    setUpWord();

    guessButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(guessAnswer.getText().toString().isEmpty()){
          Toast.makeText(game.this, "Please enter a word", Toast.LENGTH_SHORT).show();
        } else {
          if(guessAnswer.getText().toString().toLowerCase().equals(chosenWord)){
            score+=1;
            scoreInfo.setText(String.valueOf("Score: " + score));
            guessAnswer.setText("");
            game_blurb.setText(correctAnswer);
            resetGame();

          } else {
            guessCount++;
            if(guessCount < gameMax){
              score--;
              scoreInfo.setText(String.valueOf("Score: " + score));
              game_blurb.setText(guessLeft(gameMax - guessCount));
              guessAnswer.setText("");

            } else {
              guessCount = 0;
              score--;
              scoreInfo.setText(String.valueOf("Score: " + score));
              game_blurb.setText("The correct word is " + chosenWord);
              resetGame();
            }

          }
        }
      }
    });

  }

  public void resetGame(){
    Thread t = new Thread() {
      @Override
      public void run() {
        try {
          while (!isInterrupted) {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                game_blurb.setText(intro);
                setUpWord();
              }
            });
            isInterrupted = true;
          }
        } catch (InterruptedException e) {
        }
      }
    };

    t.start();

  }


  public String wordScramble(String word){
    List<String> letters = Arrays.asList(word.split(""));
    Collections.shuffle(letters);
    String shuffled = "";
    for (String letter : letters) {
      shuffled += letter;
    }
    return shuffled;
  }

  public String selectWord(){
    Random rand = new Random();
    String[] wordData = {
            "autonomy", "autopilot", "autopsies", "autopsy", "autosuggestion", "autumn", "autumnal",
            "autumns", "auxiliaries", "auxiliary", "avail", "availabilities", "availability",
            "available", "availed", "availing", "avails", "avalanche","bake",
            "baked", "bakehouse", "baker", "bakeries", "stet", "stethoscope", "stevedore",
            "stew", "steward", "tinting", "tintings", "tints", "tinware",
            "tiny", "tip", "tipoff", "tipoffs", "tipped", "tipper", "tipping", "whists",
            "white", "whitebait", "whiteboards","year", "yearbook", "zonal", "zonation"
    };
    String chosenWord = wordData[rand.nextInt(wordData.length)];
    return chosenWord;
  }

  public void setUpWord(){
    chosenWord = selectWord();
    scrambleWord = wordScramble(chosenWord);
    wordToGuess.setText(scrambleWord);
    guessAnswer.setText("");
    isInterrupted = false;

  }

  public String guessLeft(int guess){
    String output = "";
    if (guess == 1){
      output = "you have " + guess + " guess left";
    } else {
      output = "you have " + guess + " guesses left";
    }
    return output;
  }
}
