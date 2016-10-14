package com.edimaudo.lightsout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private ImageView image1,image2,image3, image4,
  image5,image6,image7,image8,image9,image10,image11,
  image12,image13,image14,image15,image16;

  int[] lightArray = new int[16];
  int[] imageViewArray = {
          R.id.image1, R.id.image2,R.id.image3,R.id.image4,
          R.id.image5,R.id.image6,R.id.image7,R.id.image8,
          R.id.image9,R.id.image10,R.id.image11,R.id.image12,
          R.id.image13,R.id.image14,R.id.image15,R.id.image16};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    image1 = (ImageView) findViewById(R.id.image1);
    image2 = (ImageView) findViewById(R.id.image2);
    image3 = (ImageView) findViewById(R.id.image3);
    image4 = (ImageView) findViewById(R.id.image4);
    image5 = (ImageView) findViewById(R.id.image5);
    image6 = (ImageView) findViewById(R.id.image6);
    image7 = (ImageView) findViewById(R.id.image7);
    image8 = (ImageView) findViewById(R.id.image8);
    image9 = (ImageView) findViewById(R.id.image9);
    image10 = (ImageView) findViewById(R.id.image10);
    image11 = (ImageView) findViewById(R.id.image11);
    image12 = (ImageView) findViewById(R.id.image12);
    image13 = (ImageView) findViewById(R.id.image13);
    image14 = (ImageView) findViewById(R.id.image14);
    image15 = (ImageView) findViewById(R.id.image15);
    image16 = (ImageView) findViewById(R.id.image16);

    image1.setOnClickListener(this);
    image2.setOnClickListener(this);
    image3.setOnClickListener(this);
    image4.setOnClickListener(this);
    image5.setOnClickListener(this);
    image6.setOnClickListener(this);
    image7.setOnClickListener(this);
    image8.setOnClickListener(this);
    image9.setOnClickListener(this);
    image10.setOnClickListener(this);
    image11.setOnClickListener(this);
    image12.setOnClickListener(this);
    image13.setOnClickListener(this);
    image14.setOnClickListener(this);
    image15.setOnClickListener(this);
    image16.setOnClickListener(this);

    assignLight();
    playGame();

  }

  public void playGame(){
    boolean gameEnd = false;
    while(!gameEnd){
      
    }

  }

  public void resetGame(){
    for (int i = 0; i < lightArray.length; i++) {
      lightArray[i] = 0;
    }
  }

  public void assignLight(){
    Random rand = new Random();
    for (int i = 0; i < lightArray.length; i++){
      lightArray[i] = rand.nextInt(2);
      if (lightArray[i] == 1){
        ImageView img = (ImageView) findViewById(imageViewArray[i]);
        img.setImageResource(R.drawable.circle_change);
      }
    }

  }

  public void changeColor(int view, int position, int score){
    ImageView imageView = (ImageView) findViewById(view);
    if(score == 0){
      lightArray[position] = 1;
      imageView.setImageResource(R.drawable.circle_change);
    } else {
      lightArray[position] = 0;
      imageView.setImageResource(R.drawable.circle);
    }
  }

  @Override
  public void onClick(View view) {
    int output = 0;
    switch(view.getId()){
      case R.id.image1:
        break;
      case R.id.image2:
        output = 1;
        break;
      case R.id.image3:
        output = 2;
        break;
      case R.id.image4:
        output = 3;
        break;
      case R.id.image5:
        output = 4;
        break;
      case R.id.image6:
        output = 5;
        break;
      case R.id.image7:
        output = 6;
        break;
      case R.id.image8:
        output = 7;
        break;
      case R.id.image9:
        output = 8;
        break;
      case R.id.image10:
        output = 9;
        break;
      case R.id.image11:
        output = 10;
        break;
      case R.id.image12:
        output = 11;
        break;
      case R.id.image13:
        output = 12;
        break;
      case R.id.image14:
        output = 13;
        break;
      case R.id.image15:
        output = 14;
        break;
      case R.id.image16:
        output = 15;
        break;
    }

    changeColor(view.getId(),output,lightArray[output]);
  }


}
