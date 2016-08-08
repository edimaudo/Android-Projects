package com.edimaudo.circularimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
  private ImageView imageView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) findViewById(R.id.imageView);
    Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.jonny_quest);
    imageView.setImageBitmap(icon);
  }
}
