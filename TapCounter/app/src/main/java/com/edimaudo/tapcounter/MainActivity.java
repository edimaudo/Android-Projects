package com.edimaudo.tapcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private TextView counterText;
  private Button reset, tap;
  int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    counterText = (TextView) findViewById(R.id.counterText);
    reset = (Button) findViewById(R.id.reset);
    tap = (Button) findViewById(R.id.tap);

    reset.setOnClickListener(this);
    tap.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {

    int choice = view.getId();
    switch (choice){
      case R.id.reset:
        count = 0;
        break;
      case R.id.tap:
        count++;
        break;
    }
    counterText.setText(String.valueOf(count));
  }
}
