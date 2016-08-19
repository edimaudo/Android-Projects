package com.edimaudo.clickchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button startButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startButton = (Button) findViewById(R.id.submitButton);
    startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), game.class);
        startActivityForResult(myIntent, 0);
      }
    });
  }


}
