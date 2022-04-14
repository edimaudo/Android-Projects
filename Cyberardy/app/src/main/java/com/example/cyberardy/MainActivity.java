package com.example.cyberardy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button aboutButton;
  private Button playButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    aboutButton = (Button) findViewById(R.id.aboutButton);
    playButton = (Button) findViewById(R.id.playButton);

    aboutButton.setOnClickListener(this);
    playButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.playButton:


        //break;
      case R.id.aboutButton:

        //break;
    }
  }
}