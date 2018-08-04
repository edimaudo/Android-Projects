package com.edimaudo.keyboardsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void showText(View view) {
    EditText editText = (EditText) findViewById(R.id.editText_main);
    if (editText != null) {
      String showString = editText.getText().toString();
      Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
    }
  }
}
