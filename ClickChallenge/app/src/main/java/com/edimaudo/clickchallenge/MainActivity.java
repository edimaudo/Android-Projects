package com.edimaudo.clickchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
  private Button startButton;
  private int pStatus = 0;
  private TextView txtProgress;
  private ProgressBar progressBar;
  private LinearLayout intro;
  private RelativeLayout game;
  private Handler handler = new Handler();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startButton = (Button) findViewById(R.id.submitButton);
    intro = (LinearLayout) findViewById(R.id.intro);
    startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        startTimer();
      }
    });
  }

  public void startTimer(){

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (pStatus <= 100) {
          handler.post(new Runnable() {
            @Override
            public void run() {
              progressBar.setProgress(pStatus);
              txtProgress.setText(pStatus + " %");
            }
          });
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          pStatus++;
        }
      }
    }).start();

  }
}
