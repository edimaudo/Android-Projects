package com.edimaudo.counterhomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  EditText editText;
  Button mbutton;
  TextView textView;

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString("reply_text", textView.getText().toString());
  }

  Integer count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText = (EditText) findViewById(R.id.editText);
    mbutton = (Button) findViewById(R.id.button);
    textView = (TextView) findViewById(R.id.textView);

    // Restore the saved state. See onSaveInstanceState() for what gets saved.
    if (savedInstanceState != null) {
      textView.setText(savedInstanceState.getString("reply_text"));
    }
  }

  public void buttonClick(View view) {
    count++;
    textView.setText(Integer.toString(count));
  }
}
