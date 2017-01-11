package com.edimaudo.capitoltalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button popWord;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    popWord = (Button) findViewById(R.id.popWord);
    popWord.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        
      }
    });
  }
}
