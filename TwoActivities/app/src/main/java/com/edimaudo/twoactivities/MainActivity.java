package com.edimaudo.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private static final String LOG_TAG =
          MainActivity.class.getSimpleName();
  public static final String EXTRA_MESSAGE =
          "com.twoactivities.extra.MESSAGE";
  private EditText mMessageEditText;
  public static final int TEXT_REQUEST = 1;
  private TextView mReplyHeadTextView;
  private TextView mReplyTextView;



  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
      outState.putBoolean("reply_visible", true);
      outState.putString("reply_text", mReplyTextView.getText().toString());
    }
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(LOG_TAG, "-------");
    Log.d(LOG_TAG, "onCreate");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mMessageEditText = (EditText) findViewById(R.id.editText_main);
    mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
    mReplyTextView = (TextView) findViewById(R.id.text_message_reply);

    // Restore the saved state. See onSaveInstanceState() for what gets saved.
    if (savedInstanceState != null) {
      boolean isVisible = savedInstanceState.getBoolean("reply_visible");
      // Show both the header and the message views. If isVisible is
      // false or missing from the bundle, use the default layout.
      if (isVisible) {
        mReplyHeadTextView.setVisibility(View.VISIBLE);

        mReplyTextView.setText(savedInstanceState.getString("reply_text"));
        mReplyTextView.setVisibility(View.VISIBLE);
      }
    }
  }

  @Override
  public void onStart(){
    super.onStart();
    Log.d(LOG_TAG, "onStart");
  }


  public void launchSecondActivity(View view) {
    Log.d(LOG_TAG, "Button clicked!");
    Intent intent = new Intent(this, SecondActivity.class);
    String message = mMessageEditText.getText().toString();

    intent.putExtra(EXTRA_MESSAGE, message);


    startActivityForResult(intent, TEXT_REQUEST);
  }

  public void onActivityResult(int requestCode, int resultCode,
                               Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == TEXT_REQUEST) {
      if (resultCode == RESULT_OK) {
        String reply =
                data.getStringExtra(SecondActivity.EXTRA_REPLY);

        mReplyHeadTextView.setVisibility(View.VISIBLE);
        mReplyTextView.setText(reply);
        mReplyTextView.setVisibility(View.VISIBLE);
      }
    }
  }
}
