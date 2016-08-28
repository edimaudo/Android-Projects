package com.edimaudo.picassoimagedownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
  private ImageView imageView;
  private Button imageButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) findViewById(R.id.imageView);
    imageButton = (Button) findViewById(R.id.imageButton);
    imageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Picasso.with(getApplicationContext())
                .load("http://lorempixel.com/400/200")
                .error(android.R.drawable.ic_dialog_alert)
                .into(imageView);
      }
    });

  }
}
