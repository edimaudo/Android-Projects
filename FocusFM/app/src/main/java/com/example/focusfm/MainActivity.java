package com.example.focusfm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  MediaPlayer player;
  private ImageButton playButton, nextButton, restartButton;
  private Integer playState = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    playButton= (ImageButton) findViewById(R.id.playImageButton);
    nextButton = (ImageButton) findViewById(R.id.nextImageButton);
    restartButton= (ImageButton) findViewById(R.id.restartImageButton);

    playImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    nextImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    restartImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });
  }

  public void play(View v){

  }

  public void pause(View v){

  }

  public void stop(View v){

  }

  public void next(View v){

  }
}