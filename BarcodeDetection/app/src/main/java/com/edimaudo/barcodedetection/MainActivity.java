package com.edimaudo.barcodedetection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button) findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      }
    });

    ImageView myImageView = (ImageView) findViewById(R.id.imgview);
    Bitmap myBitmap = BitmapFactory.decodeResource(
            getApplicationContext().getResources(),
            R.drawable.puppy);
    myImageView.setImageBitmap(myBitmap);
  }
}
