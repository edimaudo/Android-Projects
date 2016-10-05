package com.edimaudo.seeingspots;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private Button submitButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    submitButton = (Button) findViewById(R.id.submitButton);

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent in = new Intent(getApplicationContext(),game.class);
        startActivity(in);
      }
    });
  }
}
