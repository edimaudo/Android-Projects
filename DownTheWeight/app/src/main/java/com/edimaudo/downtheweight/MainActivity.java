package com.edimaudo.downtheweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private EditText heightInput, weightInput, goalInput, dietInput;
  private RadioGroup genderOption;
  private Button submitButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    heightInput = (EditText) findViewById(R.id.heightInput);
    weightInput = (EditText) findViewById(R.id.weightInput);
    goalInput = (EditText) findViewById(R.id.goalInput);
    dietInput = (EditText) findViewById(R.id.dietInput);

    genderOption = (RadioGroup) findViewById(R.id.genderOption);

    submitButton = (Button) findViewById(R.id.submitButton);

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(heightInput.getText().toString().isEmpty() || weightInput.getText().toString().isEmpty() ||
                goalInput.getText().toString().isEmpty() || dietInput.getText().toString().isEmpty()){
          Toast.makeText(getApplicationContext(), "Please fill in all options", Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}
