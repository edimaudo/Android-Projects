package com.edimaudo.textscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scroll);

    textView = (TextView) findViewById(R.id.textInfo);

    Intent intent = getIntent();
    String message =
            intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    textView.setText(message);

  }
}
