package com.edimaudo.printingquotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Exercises for programmers Exercise 3
Create a program that prompts for a quote and an author.
Display the quotation and author as shown in the example output.

 */

public class MainActivity extends AppCompatActivity {
  private EditText quoteInfo,quoter;
  private TextView output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quoteInfo = (EditText) findViewById(R.id.userQuoteInput);
    quoter = (EditText) findViewById(R.id.userQuoterInput);
    output = (TextView) findViewById(R.id.userOutput);

    quoter.setOnEditorActionListener(new EditText.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          getOutput();
        }
        return false;
      }
    });

    quoteInfo.setOnEditorActionListener(new EditText.OnEditorActionListener() {
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
    String outputInfo = "";
    if (quoteInfo.getText().toString() == null || quoteInfo.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Enter a quote", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else if(quoter.getText().toString() == null || quoter.getText().toString().equals("")) {
      Toast.makeText(getApplicationContext(), "Enter a quote author", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else if(quoter.getText().toString().equals("") || quoteInfo.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Enter a quote and quote author", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else {
      StringBuilder stringInfo = new StringBuilder();
      stringInfo.append(quoter.getText().toString());
      stringInfo.append(" says, ");
      stringInfo.append( "\"");
      stringInfo.append(quoteInfo.getText().toString());
      stringInfo.append("\"");
      outputInfo  =   stringInfo.toString();
      output.setText(outputInfo);
    }
  }



}
