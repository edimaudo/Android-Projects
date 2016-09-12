package com.edimaudo.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private TextView teamAText, teamBText;
  private Button teamA3PointButton, teamA2PointButton, teamA1PointButton, teamB3PointButton,
          teamB2PointButton, teamB1PointButton, resetButton;
  private int teamAScore = 0;
  private int teamBScore = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    teamAText = (TextView) findViewById(R.id.teamAText);
    teamBText = (TextView) findViewById(R.id.teamBText);
    teamA3PointButton = (Button) findViewById(R.id.teamA3PointButton);
    teamA2PointButton = (Button) findViewById(R.id.teamA2PointButton);
    teamA1PointButton = (Button) findViewById(R.id.teamA1PointButton);
    teamB3PointButton = (Button) findViewById(R.id.teamB3PointButton);
    teamB2PointButton = (Button) findViewById(R.id.teamB2PointButton);
    teamB1PointButton = (Button) findViewById(R.id.teamB1PointButton);
    resetButton = (Button) findViewById(R.id.resetButton);

    resetButton.setOnClickListener(this);
    teamA1PointButton.setOnClickListener(this);
    teamA2PointButton.setOnClickListener(this);
    teamA3PointButton.setOnClickListener(this);
    teamB1PointButton.setOnClickListener(this);
    teamB2PointButton.setOnClickListener(this);
    teamB3PointButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.teamA1PointButton:
        teamAScore+=1;
        teamAText.setText(String.valueOf(teamAScore));
        break;
      case R.id.teamA2PointButton:
        teamAScore+=2;
        teamAText.setText(String.valueOf(teamAScore));
        break;
      case R.id.teamA3PointButton:
        teamAScore+=3;
        teamAText.setText(String.valueOf(teamAScore));
        break;
      case R.id.teamB1PointButton:
        teamBScore+=1;
        teamBText.setText(String.valueOf(teamBScore));
        break;
      case R.id.teamB2PointButton:
        teamBScore+=2;
        teamBText.setText(String.valueOf(teamBScore));
        break;
      case R.id.teamB3PointButton:
        teamBScore+=3;
        teamBText.setText(String.valueOf(teamBScore));
        break;
      case R.id.resetButton:
        teamAScore = 0;
        teamBScore = 0;
        teamAText.setText(String.valueOf(teamAScore));
        teamBText.setText(String.valueOf(teamBScore));
        break;
    }
  }
}
