package com.edimaudo.clickchallenge;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class game extends AppCompatActivity {
  private TextView txtProgress;
  private ProgressBar progressBar;
  private RelativeLayout gameLayout;
  int pstatus = 0;
  int count = 0;
  int maxValue = 30;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    txtProgress = (TextView) findViewById(R.id.txtProgress);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);
    gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
    gameLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        count++;
        txtProgress.setText(String.valueOf(count));
      }
    });
    runGame();




  }
  public void runGame(){
    progressBar.setProgress(0);
    progressBar.setMax(maxValue);

    Thread t = new Thread() {

      @Override
      public void run() {
        try {
          while (pstatus < maxValue) {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                pstatus+=1;
                progressBar.setProgress(pstatus);

              }
            });
          }
          if(pstatus >= maxValue){
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                // Your dialog code.
                showLocationDialog();
              }
            });
          }
        } catch (InterruptedException e) {

        }
      }
    };

    t.start();

  }



  public void showLocationDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.alertDialogStyle);
    builder.setTitle("Click Challenge");
    builder.setMessage("You had " + String.valueOf(count) + " clicks.  " + "Do you want to play again?");

    String positiveText = getString(android.R.string.ok);
    builder.setPositiveButton(positiveText,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                pstatus = 0;
                count = 0;
                progressBar.setProgress(0);
                txtProgress.setText("0");
                runGame();

              }
            });

    String negativeText = getString(android.R.string.cancel);
    builder.setNegativeButton(negativeText,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                // negative button logic
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);

              }
            });

    AlertDialog dialog = builder.create();
    // display dialog
    dialog.show();
  }
}
