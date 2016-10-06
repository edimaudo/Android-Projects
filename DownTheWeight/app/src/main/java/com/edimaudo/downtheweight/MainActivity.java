package com.edimaudo.downtheweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText heightInput, weightInput, goalInput, dietInput;
  private Button submitButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    heightInput = (EditText) findViewById(R.id.heightInput);
    weightInput = (EditText) findViewById(R.id.weightInput);
    goalInput = (EditText) findViewById(R.id.goalInput);
    dietInput = (EditText) findViewById(R.id.dietInput);

    submitButton = (Button) findViewById(R.id.submitButton);

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(heightInput.getText().toString().isEmpty()
                || weightInput.getText().toString().isEmpty()
                || goalInput.getText().toString().isEmpty()
                || dietInput.getText().toString().isEmpty()){
          Toast.makeText(getApplicationContext(),
                  "Please fill in all options", Toast.LENGTH_LONG).show();
        } else if (heightInput.getText().toString().equals("0")
                || weightInput.getText().toString().equals(0)
                || goalInput.getText().toString().equals(0)
                || dietInput.getText().toString().equals(0)) {
          Toast.makeText(getApplicationContext(),
                  "All values must have a value greater than 0", Toast.LENGTH_LONG).show();
        } else if(Integer.parseInt(goalInput.getText().toString())
                >= Integer.parseInt(weightInput.getText().toString())) {
          Toast.makeText(getApplicationContext(),
                  "Target weight cannot be higher than or equal to current Weight",
                  Toast.LENGTH_LONG).show();
        }else {
          Intent in = new Intent(getApplicationContext(),goal.class);
          Bundle extras = new Bundle();
          extras.putString("CURRENT_WEIGHT",weightInput.getText().toString());
          extras.putString("GOAL_WEIGHT",goalInput.getText().toString());
          extras.putString("DIET_TIME",dietInput.getText().toString());
          in.putExtras(extras);
          startActivity(in);
        }
      }
    });
  }
}
