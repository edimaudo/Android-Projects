package com.edimaudo.sushijiggler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
  private ImageView image1,image2, image3, image4, image5, image6;

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

    image1.setOnClickListener(this);
    image2.setOnClickListener(this);
    image3.setOnClickListener(this);
    image4.setOnClickListener(this);
    image5.setOnClickListener(this);
    image6.setOnClickListener(this);

  }

  @Override
  public void onClick(View view) {
    Random rand = new Random();
    int choice = rand.nextInt(3);
    switch (view.getId()){
      case R.id.image1:
        runAnimation(choice,view);
        break;
      case R.id.image2:
        runAnimation(choice,view);
        break;
      case R.id.image3:
        runAnimation(choice,view);
        break;
      case R.id.image4:
        runAnimation(choice,view);
        break;
      case R.id.image5:
        runAnimation(choice,view);
        break;
      case R.id.image6:
        runAnimation(choice,view);
        break;
    }
  }

  public void runAnimation(int choice, View view){
    Animation anim;
    switch (choice){
      case 0:
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anticlockwise);
        anim.setAnimationListener(this);
        view.startAnimation(anim);
        break;
      case 1:
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        anim.setAnimationListener(this);
        view.startAnimation(anim);
        break;
      case 2:
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        anim.setAnimationListener(this);
        view.startAnimation(anim);
        break;
      case 3:
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        anim.setAnimationListener(this);
        view.startAnimation(anim);
        break;
    }
    // set animation listener

  }

  @Override
  public void onAnimationStart(Animation animation) {

  }

  @Override
  public void onAnimationEnd(Animation animation) {

  }

  @Override
  public void onAnimationRepeat(Animation animation) {

  }
}
