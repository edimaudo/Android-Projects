package com.edimaudo.foodtracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import org.json.JSONException;
import org.json.JSONObject;

public class addFood extends AppCompatActivity {

  //Todo: create layout for item
  //Todo: Add screen for edit and delete

  private CoordinatorLayout coordinatorLayout;
  private EditText editText;
  private ImageView imageView;
  private RatingBar ratingBar;
  private Button button;
  private final String TAG = "info";
  private String jstring;
  private Image image;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_food);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    editText = (EditText) findViewById(R.id.editText);
    imageView = (ImageView) findViewById(R.id.imageView);
    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    button = (Button) findViewById(R.id.button);
    Bundle extras = getIntent().getExtras();

    imageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (isStoragePermissionGranted()){

        } else {
          Snackbar
                  .make(coordinatorLayout, "Permissions needed",Snackbar.LENGTH_SHORT)
                  .show();
        }
      }
    });

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (editText.getText().toString().isEmpty()){
          Snackbar
                  .make(coordinatorLayout, "Please enter food name.",Snackbar.LENGTH_SHORT)
                  .show();
        } else if (true){
          Snackbar
                  .make(coordinatorLayout, "Please select an image",Snackbar.LENGTH_SHORT)
                  .show();
        } else {

        }
      }
    });


    if (extras != null) {
      jstring = extras.getString("IMAGE");
    }

    image = getMyImage(jstring);
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;
    imageView.setImageBitmap(ImageResizer
            .decodeSampledBitmapFromFile(image.getImagePath(), width, height));
  }

  private Image getMyImage(String image) {
    try {
      JSONObject job = new JSONObject(image);
      return (new Image(job.getString("foodName"),
              job.getString("foodRating"), job.getString("imagePath")));
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return null;
  }

  public  boolean isStoragePermissionGranted() {
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_GRANTED) {
        Log.v(TAG,"Permission is granted");
        return true;
      } else {

        Log.v(TAG,"Permission is revoked");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        return false;
      }
    }
    else { //permission is automatically granted on sdk<23 upon installation
      Log.v(TAG,"Permission is granted");
      return true;
    }
  }
}
