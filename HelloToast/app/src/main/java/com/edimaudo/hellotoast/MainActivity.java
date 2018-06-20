package com.edimaudo.hellotoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  public Button countButton, toastButton;
  public TextView countText;
  public int textCount = 0;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    countButton = (Button) findViewById(R.id.count_button);
    countText = (TextView) findViewById(R.id.count_text);
    toastButton = (Button) findViewById(R.id.toast_button);

    countButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        textCount+=1;
        if (countText != null) countText.setText(Integer.toString(textCount));
        
      }
    });

    toastButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT).show();
      }
    });

  }
}
