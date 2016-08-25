package com.edimaudo.basicanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private Button shootButton;
  Animation anim;
  ImageView shootImage, alienImage;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    shootButton = (Button) findViewById(R.id.shootButton);
    alienImage = (ImageView) findViewById(R.id.alienImage);
    //Drawable shoot = ContextCompat.getDrawable(getApplicationContext(),R.drawable.test);
    //final ImageView shootImage = shoot.get;

    shootButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
        //alienImage.setImageResource(R.drawable.test);
        alienImage.startAnimation(anim);
      }
    });
  }
}
