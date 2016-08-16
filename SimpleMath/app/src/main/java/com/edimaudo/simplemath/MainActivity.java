package com.edimaudo.simplemath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
Write a program that prompts for two numbers.
Print the sum, difference, product, and quotient of those numbers

 */
public class MainActivity extends AppCompatActivity {
  private EditText firstNumber;
  private EditText secondNumber;
  private Button calculateButton;
  private TextView output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    firstNumber = (EditText) findViewById(R.id.firstNumber);
    secondNumber = (EditText) findViewById(R.id.secondNumber);
    calculateButton = (Button) findViewById(R.id.calculate);
    output = (TextView) findViewById(R.id.userOutput);

    calculateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getCalculation();
      }
    });
  }

  public void getCalculation(){
    if(firstNumber.getText().toString().equals("") || secondNumber.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter all numbers", Toast.LENGTH_SHORT).show();
    } else {
      StringBuilder stringInfo = new StringBuilder();
      stringInfo.append(firstNumber.getText().toString() + " + " + secondNumber.getText().toString()
       + " = " + addNum(Double.parseDouble(firstNumber.getText().toString()), Double.parseDouble(secondNumber.getText().toString())) + "\n");
      stringInfo.append(firstNumber.getText().toString() + " - " + secondNumber.getText().toString()
              + " = " + subtractNum(Double.parseDouble(firstNumber.getText().toString()), Double.parseDouble(secondNumber.getText().toString())) + "\n");
      stringInfo.append(firstNumber.getText().toString() + " * " + secondNumber.getText().toString()
              + " = " + multiplyNum(Double.parseDouble(firstNumber.getText().toString()), Double.parseDouble(secondNumber.getText().toString())) + "\n");
      stringInfo.append(firstNumber.getText().toString() + " / " + secondNumber.getText().toString()
              + " = " + divideNum(Double.parseDouble(firstNumber.getText().toString()), Double.parseDouble(secondNumber.getText().toString())));
      String outputInfo = stringInfo.toString();
      output.setText(outputInfo);
    }
  }

  public String addNum(Double num1, Double num2){
    return String.valueOf(num1 + num2);
  }

  public String subtractNum(Double num1, Double num2){
    return String.valueOf(num1 - num2);
  }

  public String multiplyNum(Double num1, Double num2){
    return String.valueOf(num1 * num2);
  }

  public String divideNum(Double num1, Double num2){
    if (num2 == 0){
      return "Cannot divide by zero";
    } else {
      return String.valueOf(num1/num2);
    }
  }
}
