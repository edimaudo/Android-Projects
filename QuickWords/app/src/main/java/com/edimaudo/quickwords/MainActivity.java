package com.edimaudo.quickwords;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private TextView scoreUpdate,wordSelected,scoreInfo;
  private Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
  private Button cancelButton, submitButton;
  final String incorrectWord = "Wrong!";
  StringBuilder winWord = new StringBuilder();
  StringBuilder wordBuilder = new StringBuilder();
  ArrayList<Button> viewData = new ArrayList<Button>();
  char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  ArrayList<Button> buttonList = new ArrayList<Button>();
  int score = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    scoreUpdate = (TextView) findViewById(R.id.scoreUpdate);
    wordSelected = (TextView) findViewById(R.id.wordSelected);
    scoreInfo = (TextView) findViewById(R.id.scoreInfo);
    button1 = (Button) findViewById(R.id.button1);
    button2 = (Button) findViewById(R.id.button2);
    button3 = (Button) findViewById(R.id.button3);
    button4 = (Button) findViewById(R.id.button4);
    button5 = (Button) findViewById(R.id.button5);
    button6 = (Button) findViewById(R.id.button6);
    button7 = (Button) findViewById(R.id.button7);
    button8 = (Button) findViewById(R.id.button8);
    button9 = (Button) findViewById(R.id.button9);
    cancelButton = (Button) findViewById(R.id.cancelButton);
    submitButton = (Button) findViewById(R.id.submitButton);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    button5.setOnClickListener(this);
    button6.setOnClickListener(this);
    button7.setOnClickListener(this);
    button8.setOnClickListener(this);
    button9.setOnClickListener(this);
    cancelButton.setOnClickListener(this);
    submitButton.setOnClickListener(this);

    buttonList.add(button1);
    buttonList.add(button2);
    buttonList.add(button3);
    buttonList.add(button4);
    buttonList.add(button5);
    buttonList.add(button6);
    buttonList.add(button7);
    buttonList.add(button8);
    buttonList.add(button9);

    setButtonLetter();

  }

  public void updateButtonViewInfo(View view){
    view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
    view.setEnabled(false);
    showWord();
  }
  
  @Override
  public void onClick(View view) {
    scoreUpdate.setText("");
    switch (view.getId()){
      case R.id.button1:
        wordBuilder.append(button1.getText());
        viewData.add(button1);
        updateButtonViewInfo(view);
        break;
      case R.id.button2:
        viewData.add(button2);
        wordBuilder.append(button2.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button3:
        viewData.add(button3);
        wordBuilder.append(button3.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button4:
        viewData.add(button4);
        wordBuilder.append(button4.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button5:
        viewData.add(button5);
        wordBuilder.append(button5.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button6:
        viewData.add(button6);
        wordBuilder.append(button6.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button7:
        viewData.add(button7);
        wordBuilder.append(button7.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button8:
        viewData.add(button8);
        wordBuilder.append(button8.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.button9:
        viewData.add(button9);
        wordBuilder.append(button9.getText());
        updateButtonViewInfo(view);
        break;
      case R.id.cancelButton:
        clearSelectedLetter("cancel");
        break;
      case R.id.submitButton:
        updateScore();
        clearSelectedLetter("not cancel");
        break;
    }

  }

  public void setButtonLetter(){
     for(int button = 0; button < buttonList.size() ;button++){
        Random rand = new Random();
        buttonList.get(button).setText(String.valueOf(alphabet[rand.nextInt(alphabet.length)]));
    }
  }

  public void updateScore(){
    int currentScore = 0;
    String output = "";
    if(checkWord(wordBuilder.toString())){
      currentScore = wordBuilder.toString().length() * wordBuilder.toString().length();
      winWord.append("Correct ");
      winWord.append(currentScore);
      winWord.append(" points");
      output = winWord.toString();
    } else {
      output = incorrectWord;
    }
    score+=currentScore;
    scoreUpdate.setText(output);
    scoreInfo.setText(String.valueOf("Score: " + score));

  }

  public void clearSelectedLetter(String update){
    for(int button = 0; button < viewData.size();button++){
      if (!update.equals("cancel")){
        Random rand = new Random();
        viewData.get(button).setText(String.valueOf(alphabet[rand.nextInt(alphabet.length)]));
      }
      viewData.get(button).setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
      viewData.get(button).setEnabled(true);
    }
    viewData = new ArrayList<Button>();
    wordSelected.setText("");
    wordBuilder.setLength(0);

  }

  public boolean checkWord(String word) {
    boolean output = false;
    try {
      InputStream is = getResources().openRawResource(R.raw.words);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line = br.readLine();
      while(line != null){
        if(line.equals(word.toLowerCase())){
          output = true;
          break;
        }
        line = br.readLine();
      }
      br.close();
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return output;
  }


  public void showWord(){
    wordSelected.setText(wordBuilder.toString());
  }
}