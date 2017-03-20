package com.edimaudo.foodtracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class addFood extends AppCompatActivity {

  //Todo: create layout for item
  //Todo: fix toolbars
  //Todo: Create SQl database and insert,edit and delete functions
  //Todo: Write tests for the app
  //Todo: Add screen for edit and delete

  private CoordinatorLayout coordinatorLayout;
  private EditText editText;
  private ImageView imageView;
  private RatingBar ratingBar;
  private Button button;
  private final String TAG = "info";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_food);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    editText = (EditText) findViewById(R.id.editText);
    imageView = (ImageView) findViewById(R.id.imageView);
    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    button = (Button) findViewById(R.id.button);

    imageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

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
