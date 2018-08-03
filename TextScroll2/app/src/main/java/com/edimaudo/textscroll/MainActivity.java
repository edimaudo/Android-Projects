package com.edimaudo.textscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  Button button1, button2, button3;

  private static final String LOG_TAG = MainActivity.class.getSimpleName();

  public static final String EXTRA_MESSAGE = "MESSAGE";
  String buttonMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button1 = (Button) findViewById(R.id.button1);
    button2 = (Button) findViewById(R.id.button2);
    button3 = (Button) findViewById(R.id.button3);

  }

  public void button1action(View view) {
    Intent intent = new Intent(this, ScrollActivity.class);
    buttonMessage = "THis is button 1 message.  It is so kewl!";
    intent.putExtra(EXTRA_MESSAGE, buttonMessage);
    startActivity(intent);

  }

  public void button2action(View view) {
    Intent intent = new Intent(this, ScrollActivity.class);
    buttonMessage = "THis is button 2 message.  It is so kewl!";
    intent.putExtra(EXTRA_MESSAGE, buttonMessage);
    startActivity(intent);
  }

  public void button3action(View view) {
    Intent intent = new Intent(this, ScrollActivity.class);
    buttonMessage = "THis is button 3 message.  It is so kewl!";
    intent.putExtra(EXTRA_MESSAGE, buttonMessage);
    startActivity(intent);
  }
}
