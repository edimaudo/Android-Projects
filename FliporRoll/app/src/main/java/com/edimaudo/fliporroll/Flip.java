package com.edimaudo.fliporroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Flip extends AppCompatActivity {

  private TextView flipText;
  private Button flipButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flip);

    flipText = (TextView) findViewById(R.id.flipText);
    flipButton = (Button) findViewById(R.id.flipButton);

    flipButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        generate_flip();
      }
    });
  }

  public void generate_flip(){
    flipText.setText("");

    int output = 1;
    Random rand = new Random();
    output = rand.nextInt(2);

    final String outputText;
    String tempText = "";
    switch(output){
      case 0:
        tempText = getResources().getString(R.string.heads);
        break;
      case 1:
        tempText = getResources().getString(R.string.tails);
        break;

    }

    outputText = tempText;

    Thread t = new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(100);
          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              flipText.setText(outputText);
            }
          });

        } catch (InterruptedException e) {
        }
      }
    };

    t.start();
  }


}
