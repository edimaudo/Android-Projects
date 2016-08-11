package com.edimaudo.diceroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private Button rollButton;
  private ImageView firstDiceImage, secondDiceImage;
  private TextView headerText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rollButton = (Button) findViewById(R.id.rollButton);
    headerText = (TextView) findViewById(R.id.headerText);
    firstDiceImage = (ImageView) findViewById(R.id.firstDiceImage);
    secondDiceImage = (ImageView) findViewById(R.id.secondDiceImage);

    rollButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        generateDiceRoll();
      }
    });
  }

  public void generateDiceRoll(){
    headerText.setText("Shake! Shake! Shake!");
    Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
    headerText.startAnimation(shake);

    Thread t = new Thread() {
      @Override
      public void run() {
        try {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                int diceRoll1 = 0;
                int diceRoll2 = 0;
                String dice1 = "dice1",dice2 = "dice2";
                int diceTotal = 0;
                diceRoll1 = getRandomRoll();
                diceRoll2 = getRandomRoll();
                diceTotal = diceRoll1 + diceRoll2;
                headerText.setText(String.valueOf(diceTotal));
                getDiceImage(diceRoll1,dice1);
                getDiceImage(diceRoll2,dice2);
              }
            });

        } catch (InterruptedException e) {
        }
      }
    };

    t.start();

  }

  public int getRandomRoll(){
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
    return output;
  }

  public void getDiceImage(int option, String diceType){
    if (diceType == "dice1"){
      switch(option){
        case 1:
          firstDiceImage.setImageResource(R.drawable.one);
          break;
        case 2:
          firstDiceImage.setImageResource(R.drawable.two);
          break;
        case 3:
          firstDiceImage.setImageResource(R.drawable.three);
          break;
        case 4:
          firstDiceImage.setImageResource(R.drawable.four);
          break;
        case 5:
          firstDiceImage.setImageResource(R.drawable.five);
          break;
        case 6:
          firstDiceImage.setImageResource(R.drawable.six);
          break;
      }
    } else {
      switch(option){
        case 1:
          secondDiceImage.setImageResource(R.drawable.one);
          break;
        case 2:
          secondDiceImage.setImageResource(R.drawable.two);
          break;
        case 3:
          secondDiceImage.setImageResource(R.drawable.three);
          break;
        case 4:
          secondDiceImage.setImageResource(R.drawable.four);
          break;
        case 5:
          secondDiceImage.setImageResource(R.drawable.five);
          break;
        case 6:
          secondDiceImage.setImageResource(R.drawable.six);
          break;
      }
    }

  }
}


