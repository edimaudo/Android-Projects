package com.edimaudo.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TextView textView1, textView2, textView3, textView4, textView5,
  textView6, textView7, textView8, textView9, textView10;


  private static final String LOG_TAG = MainActivity.class.getSimpleName();
  public static final int TEXT_REQUEST = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView1 = (TextView) findViewById(R.id.textView1);
    textView2 = (TextView) findViewById(R.id.textView2);
    textView3 = (TextView) findViewById(R.id.textView3);
    textView4 = (TextView) findViewById(R.id.textView4);
    textView5 = (TextView) findViewById(R.id.textView5);
    textView6 = (TextView) findViewById(R.id.textView6);
    textView7 = (TextView) findViewById(R.id.textView7);
    textView8 = (TextView) findViewById(R.id.textView8);
    textView9 = (TextView) findViewById(R.id.textView9);
    textView10 = (TextView) findViewById(R.id.textView10);






  }

  ////update textviews
  public void onActivityResult(int requestCode, int resultCode,
                               Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == TEXT_REQUEST) {
      if (resultCode == RESULT_OK) {
        String reply =
                data.getStringExtra(SecondActivity.EXTRA_REPLY);
        if (textView1.getText().toString().isEmpty()){
          textView1.setText(reply);
        } else if (textView2.getText().toString().isEmpty()){
          textView2.setText(reply);
        } else if (textView3.getText().toString().isEmpty()){
          textView3.setText(reply);
        } else if (textView4.getText().toString().isEmpty()){
          textView4.setText(reply);
        }


      }
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "onStart");
  }

  @Override
  public void onRestart() {
    super.onRestart();
    Log.d(LOG_TAG, "onRestart");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "onResume");
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "onPause");
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "onStop");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "onDestroy");
  }

  public void getItem(View view) {
    Log.d(LOG_TAG, "Button clicked!");
    Intent itemIntent = new Intent(this, SecondActivity.class);
    startActivity(itemIntent);

  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (textView1.getText().toString().is) {

      outState.putString("reply_text", textView1.getText().toString());
    }
  }
}
