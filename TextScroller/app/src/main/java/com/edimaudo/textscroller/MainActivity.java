package com.edimaudo.textscroller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private LinearLayout output;
  private EditText input;
  private Button button;
  final String[] colorArray = {"#CF000F","#3F51B5","#303F9F","#FF4081"};
  int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    output = (LinearLayout) findViewById(R.id.output);
    input = (EditText) findViewById(R.id.userInput);
    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(input.getText().toString().isEmpty()){
          Toast.makeText(MainActivity.this, "Please enter some text", Toast.LENGTH_SHORT).show();
        } else {
          Random rand = new Random();
          final TextView value = new TextView(getApplicationContext());
          value.setText(input.getText().toString());
          value.setId(count);
          value.setTextSize(15);
          value.setTextColor(Color.parseColor(colorArray[rand.nextInt(colorArray.length)]));
          value.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
          output.addView(value);
          input.setText("");


        }
      }
    });
  }
}
