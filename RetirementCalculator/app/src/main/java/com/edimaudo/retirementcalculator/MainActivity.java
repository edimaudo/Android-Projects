package com.edimaudo.retirementcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/*
Create a program that determines how many years you have left until retirement and the year you can retire.
It should prompt for your current age and the age you want to retire and display the output
 */

public class MainActivity extends AppCompatActivity {

  private EditText currentAge, futureAge;
  private Button calculateButton;
  private TextView output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    currentAge = (EditText) findViewById(R.id.currentAge);
    futureAge = (EditText) findViewById(R.id.futureAge);
    output = (TextView) findViewById(R.id.userOutput);
    calculateButton = (Button) findViewById(R.id.calculateButton);

    calculateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        calculateRetirement();
      }
    });
  }

  public void calculateRetirement(){
    String outputInfo = "";
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (currentAge.getText().toString().equals("") && futureAge.getText().toString().equals("")) {
      Toast.makeText(getApplicationContext(), "Please enter both ages", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else if(currentAge.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter your current age", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else if (futureAge.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter your future age", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else {
        int ageDelta = Integer.parseInt(futureAge.getText().toString()) - Integer.parseInt(currentAge.getText().toString());
        if(ageDelta > 0){
          outputInfo = "You have " + String.valueOf(ageDelta) + " years left until you can retire. " + "\n" + "It's " +
                  String.valueOf(currentYear) + ", so you can retire in " + String.valueOf(currentYear + ageDelta) + ".";
        } else {
          outputInfo = "You can retire now";
        }
      output.setText(outputInfo);
    }


  }
}
