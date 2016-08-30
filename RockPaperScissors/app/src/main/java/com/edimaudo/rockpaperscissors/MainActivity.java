package com.edimaudo.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private ImageView playerImage, computerImage;
  private TextView gameBlurb;
  private Button rockButton, scissorsButton, paperButton;

  String userSelection = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    computerImage = (ImageView) findViewById(R.id.computerImage);
    playerImage = (ImageView) findViewById(R.id.playerImage);
    gameBlurb = (TextView) findViewById(R.id.gameBlurb);
    rockButton = (Button) findViewById(R.id.rockButton);
    scissorsButton = (Button) findViewById(R.id.scissorsButton);
    paperButton = (Button) findViewById(R.id.paperButton);

    rockButton.setOnClickListener(this);
    scissorsButton.setOnClickListener(this);
    paperButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.paperButton:
        userSelection = "paper";
        break;
      case R.id.scissorsButton:
        userSelection = "scissors";
        break;
      case R.id.rockButton:
        userSelection = "paper";
        break;
    }
  }
}
