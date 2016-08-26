package com.edimaudo.scrambled;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private Button gameBeginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gameBeginButton = (Button) findViewById(R.id.gameBeginButton);

    gameBeginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent gameStartIntent = new Intent(MainActivity.this,game.class);
        startActivity(gameStartIntent);

      }
    });
  }
}
