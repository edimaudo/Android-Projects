package com.edimaudo.fliporroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button flipButton, rollButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    flipButton = (Button) findViewById(R.id.flipButton);
    rollButton = (Button) findViewById(R.id.rollButton);

    flipButton.setOnClickListener(this);
    rollButton.setOnClickListener(this);


  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.flipButton:
        Intent flipIntent = new Intent(MainActivity.this,Flip.class);
        startActivity(flipIntent);
        break;
      case R.id.rollButton:
        Intent rollIntent = new Intent(MainActivity.this, Roll.class);
        startActivity(rollIntent);
    }
  }
}
