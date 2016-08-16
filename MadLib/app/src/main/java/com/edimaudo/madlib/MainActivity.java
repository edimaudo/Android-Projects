package com.edimaudo.madlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText nounInput, verbInput, adjectiveInput, adverbInput;
  private TextView output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nounInput = (EditText) findViewById(R.id.nounInput);
    verbInput = (EditText) findViewById(R.id.verbInput);
    adjectiveInput = (EditText) findViewById(R.id.adjectiveInput);
    adverbInput = (EditText) findViewById(R.id.adverbInput);
    output = (TextView) findViewById(R.id.output);

    adverbInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
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
    String nounInfo = nounInput.getText().toString();
    String verbInfo = verbInput.getText().toString();
    String adjectiveInfo = adjectiveInput.getText().toString();
    String adverbInfo = adverbInput.getText().toString();

    if(nounInfo.equals("") || verbInfo.equals("") || adjectiveInfo.equals("") ||
            adverbInfo.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter all inputs", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else {
      String outputInfo = "Do you " + verbInfo + " your " + adjectiveInfo + " " + nounInfo  + " "
              + adverbInfo;
      output.setText(outputInfo);
    }
  }
}
