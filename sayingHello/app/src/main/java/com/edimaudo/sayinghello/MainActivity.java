package com.edimaudo.sayinghello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Exercises for programmers exercise 1
Goal
create a program that prompts for your name and prints a greeting using your name.
Write a new version of the program without using any variables. //skipped as it would make the program less flexible
Write a version of the program that displays different greetings for different people.
 */

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  private TextView userOutput;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    userOutput = (TextView) findViewById(R.id.userOutput);

    userInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          showOutput();
        }
        return false;
      }
    });
  }

  public void showOutput(){
    String outputName = userInput.getText().toString();
    String introduction = "Hello, ";
    String introduction2 = "Hi, ";
    String outputInfo = " nice to meet you";
    String finalOutput = "";
    StringBuilder stringData = new StringBuilder();
    if (outputName == null || outputName.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
      userOutput.setText("");
    } else {
      switch (outputName){
        case "Brian":
          stringData.append(introduction);
          break;
        default:
          stringData.append(introduction2);
      }
      stringData.append(outputName);
      stringData.append(outputInfo);
      finalOutput = stringData.toString();
      userOutput.setText(finalOutput);
    }

  }
}
