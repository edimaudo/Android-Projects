package com.edimaudo.fliporroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Roll extends AppCompatActivity {

  private TextView rollText;
  private Button rollButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_roll);

    rollText = (TextView) findViewById(R.id.rollText);
    rollButton = (Button) findViewById(R.id.rollButton);

    rollButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        generate_roll();
      }
    });

  }

  public void generate_roll(){
    rollText.setText("");

    int output = 1;
    Random rand = new Random();
    boolean complete = false;
    output = rand.nextInt(6);
    while(!complete){
      if (output == 0){
        output = rand.nextInt(6);
      } else{
        complete = true;
      }
    }

    final String outputText;
    String tempText = "";
    switch(output){
      case 1:
        tempText = getResources().getString(R.string.one);
        break;
      case 2:
        tempText = getResources().getString(R.string.two);
        break;
      case 3:
        tempText = getResources().getString(R.string.three);
        break;
      case 4:
        tempText = getResources().getString(R.string.four);
        break;
      case 5:
        tempText = getResources().getString(R.string.five);
        break;
      case 6:
        tempText = getResources().getString(R.string.six);
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
              rollText.setText(outputText);
            }
          });

        } catch (InterruptedException e) {
        }
      }
    };

    t.start();
  }


}
