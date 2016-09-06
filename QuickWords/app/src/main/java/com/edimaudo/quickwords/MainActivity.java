package com.edimaudo.quickwords;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.button1:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button1);
        wordBuilder.append(button1.getText());
        break;
      case R.id.button2:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button1);
        wordBuilder.append(button2.getText());
        break;
      case R.id.button3:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button3);
        wordBuilder.append(button3.getText());
        break;
      case R.id.button4:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button4);
        wordBuilder.append(button4.getText());
        break;
      case R.id.button5:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button5);
        wordBuilder.append(button5.getText());
        break;
      case R.id.button6:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button6);
        wordBuilder.append(button6.getText());
        break;
      case R.id.button7:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button7);
        wordBuilder.append(button7.getText());
        break;
      case R.id.button8:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button8);
        wordBuilder.append(button8.getText());
        break;
      case R.id.button9:
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        viewData.add(button9);
        wordBuilder.append(button9.getText());
        break;
      case R.id.cancelButton:
        clearSelectedLetters("cancel");
        break;
      case R.id.submitButton:
        checkWord();
        calculateWordScore();
        showUpdate();
        clearSelectedLetters("update");
        break;
    }
    showWord();

  }


  public void setButtonLetter(){
     for(int button = 0; button < buttonList.size() ;button++){
        Random rand = new Random();
        buttonList.get(button).setText(String.valueOf(alphabet[rand.nextInt(alphabet.length)]));
    }

  }
  public void showUpdate(){
    //winWord.append("Correct Points! ");
  }

  public void clearSelectedLetters(String update){
    wordSelected.setText("");
    wordBuilder = new StringBuilder();
    if (update.equals("cancel")){
        for(int button = 0; button < viewData.size();button++){
          viewData.get(button).setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
        }
    } else {
      for(int button = 0; button < viewData.size();button++){
        Random rand = new Random();
        viewData.get(button).setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
        viewData.get(button).setText(String.valueOf(alphabet[rand.nextInt(alphabet.length)]));
      }
    }
  }

  public void checkWord(){
}

  public void calculateWordScore(){

  }

  public void showWord(){
    wordSelected.setText(wordBuilder.toString());
  }


}
