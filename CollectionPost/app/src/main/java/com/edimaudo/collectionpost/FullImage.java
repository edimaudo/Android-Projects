package com.edimaudo.collectionpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class FullImage extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_full_image);

    Intent i = getIntent();
    int position = i.getExtras().getInt("id");
    ImageAdapter imageAdapter = new ImageAdapter(this);

    ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
    imageView.setImageResource(imageAdapter.thumbIds[position]);
  }
}
