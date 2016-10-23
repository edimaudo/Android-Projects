package com.edimaudo.picofermibagel;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
  private TextView textOutput;
  private Button submitGuess;
  private EditText userInput;
  int number1, number2, number3;
  int guessNum = generateGameNumber();



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    Log.i("guess",String.valueOf(guessNum));
    textOutput = (TextView) findViewById(R.id.textOutput);

    submitGuess = (Button) findViewById(R.id.submitGuess);

    userInput = (EditText) findViewById(R.id.userInput);

    submitGuess.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          if (userInput.getText().toString().isEmpty()){
            Toast.makeText(game.this, "Please enter a number", Toast.LENGTH_SHORT).show();
          } else if (userInput.getText().toString().length() != 3) {
            Toast.makeText(game.this, "Please enter a 3 digit number", Toast.LENGTH_SHORT).show();
          }else {
            String userData = userInput.getText().toString();
            checkGameWin(userData);
          }
        userInput.setText("");
      }
    });

  }

  public void checkGameWin(String userData){
    if(Integer.parseInt(userData) == guessNum){
      AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
      winBuild.setTitle("Yay!");
      winBuild.setMessage("Congrats! you guess the correct number!");
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
      textOutput.setText(generateBagelOutcome(userData));
    }
  }

  public int generateGameNumber(){
    Random random = new Random();
    return random.nextInt(889) + 111;
  }

  public void resetGame(){
    guessNum = generateGameNumber();
    Log.i("guess",String.valueOf(guessNum));
  }

  public String generateBagelOutcome(String userData){

    StringBuilder stringInfo = new StringBuilder();
    String[] userDataArray = userData.split("");
    String[] guessDataArray = String.valueOf(guessNum).split("");
    for (int i = 0; i < userDataArray.length;i++){
      stringInfo.append(checkOutcome(userDataArray[i], guessDataArray));
      stringInfo.append("\n");
    }
    //Log.i("count", userData + String.valueOf(guessNum) + stringInfo.toString());
    return stringInfo.toString();
  }

  public String checkOutcome(String value, String[] arrayInfo){
    String outcome = "";

    if (value.equals(arrayInfo[0])){
      outcome = "Fermi";
    } else if (value.equals(arrayInfo[1]) || value.equals(arrayInfo[2])){
      outcome = "Pico";
    } else {
      outcome = "Bagel";
    }

    return outcome;
  }
}
