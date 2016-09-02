package com.edimaudo.hangman;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private ImageView imageView;
  private LinearLayout wordLayout;
  private GridView letters;
  private LetterAdapter ltrAdapt;
  String currWord;
  private TextView[] charViews;
  Integer[] bodyParts = {R.drawable.head,
          R.drawable.body,
          R.drawable.left_arm,
          R.drawable.right_arm,
          R.drawable.right_leg,
          R.drawable.left_leg
          };
  final int numParts = 5;
  int currPart;
  int numChars;
  int numCorrect;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) findViewById(R.id.imageView);
    wordLayout = (LinearLayout)findViewById(R.id.word);
    letters = (GridView)findViewById(R.id.letters);
    ltrAdapt = new LetterAdapter(this);
    letters.setAdapter(ltrAdapt);
    playGame();

  }

  private void playGame(){
    enableBtns();
    imageView.setImageDrawable(getResources().getDrawable(R.drawable.tower, getApplicationContext().getTheme()));

    currWord = generateWord();
    charViews = new TextView[currWord.length()];
    wordLayout.removeAllViews();
    for (int c = 0; c < currWord.length(); c++) {
      charViews[c] = new TextView(this);
      charViews[c].setText(""+currWord.charAt(c));
      charViews[c].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
      charViews[c].setGravity(Gravity.CENTER);
      charViews[c].setTextColor(Color.WHITE);
      charViews[c].setBackgroundResource(R.drawable.letter_bg);
      wordLayout.addView(charViews[c]);//add to layout
    }

    currPart=0;
    numChars=currWord.length();
    numCorrect=0;

  }


  private String generateWord(){
    Random rand = new Random();
    String[] word = { "abacus", "abalone", "wunderkind", "xenophobe",  "vantage", "vapid",
            "unwillingness", "unwind",  "colony", "colossal",  "commerce",
            "commercial", "composer","condenser", "feeble", "feebleminded","freshwater"};
    return word[rand.nextInt(word.length)].toUpperCase();
  }

  public void letterPressed(View view) {
    String ltr = ((TextView) view).getText().toString();
    char letterChar = ltr.charAt(0);
    view.setEnabled(false);
    view.setBackgroundResource(R.drawable.letter_down);
    boolean correct = false;
    for (int k = 0; k < currWord.length(); k++) {
      if (currWord.charAt(k) == letterChar) {
        correct = true;
        numCorrect++;
        charViews[k].setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
      }
    }

    if(correct){
      if (numCorrect == numChars) {
        disableBtns();
        AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
        winBuild.setTitle("Yay!");
        winBuild.setMessage("You win!\n\nThe answer was:\n\n" + currWord);
        winBuild.setPositiveButton("Play Again",
                new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
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
      }
    } else if (currPart < numParts){
      Log.i("part bf",String.valueOf(currPart));
      imageView.setImageDrawable(getResources().getDrawable(bodyParts[currPart], getApplicationContext().getTheme()));
      currPart++;

    } else {
      disableBtns();
      AlertDialog.Builder loseBuild = new AlertDialog.Builder(this);
      loseBuild.setTitle("Oops");
      loseBuild.setMessage("You lose!\n\nThe answer was:\n\n" + currWord);
      loseBuild.setPositiveButton("Play Again",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  enableBtns();
                  playGame();
                }
              });

      loseBuild.setNegativeButton("Exit",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  MainActivity.this.finish();
                }
              });

      loseBuild.show();
    }
  }

  public void disableBtns() {
    int numLetters = letters.getChildCount();
    for (int l = 0; l < numLetters; l++) {
      letters.getChildAt(l).setEnabled(false);
    }
  }

  public void enableBtns() {
    int numLetters = letters.getChildCount();
    for (int l = 0; l < numLetters; l++) {
      letters.getChildAt(l).setEnabled(true);
      letters.getChildAt(l).setBackgroundResource(R.drawable.letter_up);
    }
  }


}
