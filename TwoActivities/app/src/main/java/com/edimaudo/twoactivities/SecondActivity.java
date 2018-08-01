package com.edimaudo.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

  public static final String EXTRA_REPLY =
          "com.twoactivities.extra.REPLY";

  private static final String LOG_TAG =
          SecondActivity.class.getSimpleName();

  private EditText mReply;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    mReply = (EditText) findViewById(R.id.editText_second);

    Intent intent = getIntent();
    String message =
            intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    TextView textView = (TextView) findViewById(R.id.text_message);
    textView.setText(message);
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "onDestroy");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "onPause");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "onResume");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(LOG_TAG, "onRestart");
  }

  public void returnReply(View view) {
    String reply = mReply.getText().toString();
    Intent replyIntent = new Intent();
    replyIntent.putExtra(EXTRA_REPLY, reply);
    setResult(RESULT_OK, replyIntent);
    Log.d(LOG_TAG, "End SecondActivity");
    finish();
  }
}
