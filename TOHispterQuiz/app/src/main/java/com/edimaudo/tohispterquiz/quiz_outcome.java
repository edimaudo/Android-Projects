package com.edimaudo.tohispterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz_outcome extends AppCompatActivity {

  private TextView outcome;
  private Button resetButton;
  public final static String  EXTRA_MESSAGE = "com.edimaudo.tohispterquiz.MESSAGE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_quiz_outcome);

    outcome = (TextView) findViewById(R.id.outcome);
    resetButton = (Button) findViewById(R.id.resetButton);

    resetButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String resetMessage = "reset";
        Intent reset = new Intent(getApplicationContext(),MainActivity.class);
        reset.putExtra(EXTRA_MESSAGE,resetMessage);
        startActivity(reset);
      }
    });

    Intent in = getIntent();
    String message = in.getStringExtra(MainActivity.EXTRA_MESSAGE);
    outcome.setText(message);
  }
}
