package com.edimaudo.charactercount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
Exercises for programmers Exercise 2
Create a program that prompts for an input string and dis- plays output that
shows the input string and the number of characters the string contains.

 */

public class MainActivity extends AppCompatActivity {

  private EditText userInput;
  private TextView output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    output = (TextView) findViewById(R.id.output);

    userInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          getOutput();
        }
        return false;
      }
    });


  }

  public void getOutput(){
    String outputData = "";
    String userInputInfo = userInput.getText().toString();
    if (userInputInfo == null || userInputInfo.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter an input", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else {
      StringBuilder stringInfo = new StringBuilder();
      stringInfo.append(userInputInfo);
      stringInfo.append(" has ");
      stringInfo.append((String.valueOf(userInputInfo.length())));
      stringInfo.append(" characters.");
      outputData = stringInfo.toString();
      output.setText(outputData);
    }
  }


}
