package com.edimaudo.lightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private ImageView image1,image2,image3, image4,
  image5,image6,image7,image8,image9,image10,image11,
  image12,image13,image14,image15,image16;

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
    resetGame();
  }

  public void resetGame(){

  }

  public void assignLight(){

  }

  public void changeColor(View view){

  }

  @Override
  public void onClick(View view) {
    switch(view.getId()){
      case R.id.image1:
        break;
      case R.id.image2:
        break;
      case R.id.image3:
        break;
      case R.id.image4:
        break;
      case R.id.image5:
        break;
      case R.id.image6:
        break;
      case R.id.image7:
        break;
      case R.id.image8:
        break;
      case R.id.image9:
        break;
      case R.id.image10:
        break;
      case R.id.image11:
        break;
      case R.id.image12:
        break;
      case R.id.image13:
        break;
      case R.id.image14:
        break;
      case R.id.image15:
        break;
      case R.id.image16:
        break;
    }
  }
}
