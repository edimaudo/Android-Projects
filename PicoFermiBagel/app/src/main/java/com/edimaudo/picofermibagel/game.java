package com.edimaudo.picofermibagel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
  private TextView textOutput;
  private Button guessButton;
  private EditText userInput;
  int number1, number2, number3;
  int guessNum = 0;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    textOutput = (TextView) findViewById(R.id.textOutput);

    guessButton = (Button) findViewById(R.id.guessButton);

    userInput = (EditText) findViewById(R.id.userInput);

    guessButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          if (userInput.getText().toString().isEmpty()){
            Toast.makeText(game.this, "Please enter a number", Toast.LENGTH_SHORT).show();
          } else if (userInput.getText().toString().length() > 3) {
            Toast.makeText(game.this, "Please enter a 3 digit number", Toast.LENGTH_SHORT).show();
          }else {

          }
      }
    });

  }

  public void checkGameWin(){

  }

  public int generateGameNumber(){
    Random random = new Random();
    return random.nextInt(889) + 111;
  }

  public String generateBagelOutcome(){
    return "";
  }
}
