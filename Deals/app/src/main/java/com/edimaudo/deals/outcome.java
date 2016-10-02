package com.edimaudo.deals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class outcome extends AppCompatActivity {
  private Button restartButton;
  private TextView outputText;
  public static final String RESTART_INFO = "restart";
  public final static String RESTART_MESSAGE = "com.edimaudo.deals.MESSAGE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_outcome);

    outputText = (TextView) findViewById(R.id.gameEndText);
    restartButton = (Button) findViewById(R.id.gameResetButton);

    Intent gameOverIntent = new Intent();
    String gameInfo = gameOverIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    outputText.setText(gameInfo);

    restartButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.putExtra(RESTART_INFO,RESTART_MESSAGE);
        startActivity(in);
      }
    });
  }
}
