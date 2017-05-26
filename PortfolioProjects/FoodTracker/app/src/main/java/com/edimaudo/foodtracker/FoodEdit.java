package com.edimaudo.foodtracker;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

/**
 * Created by edima on 2017-05-26.
 */

public class FoodEdit extends AppCompatActivity {

  private TextInputLayout textInputLayout;
  private EditText foodTextEdit;
  private ImageView foodImageViewEdit;
  private RatingBar foodRatingBarEdit;
  private Button btnfoodUpdate;

  private final String TAG = "com.edimaudo";

  private static int RESULT_LOAD_IMAGE = 1;
  private String imagePath = "";
  private int rating = 0;

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
      Uri selectedImage = data.getData();
      String[] filePathColumn = { MediaStore.Images.Media.DATA };
      Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
      cursor.moveToFirst();
      int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
      String picturePath = cursor.getString(columnIndex);
      cursor.close();
      imagePath = picturePath;
      foodImageViewEdit.setImageBitmap(BitmapFactory.decodeFile(picturePath));
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
    foodTextEdit = (EditText) findViewById(R.id.foodTextEdit);
    foodImageViewEdit = (ImageView) findViewById(R.id.foodImageViewEdit);
    foodRatingBarEdit = (RatingBar) findViewById(R.id.foodRatingBarEdit);

    Intent foodIntent = getIntent();
    final Food food = (Food) foodIntent.getSerializableExtra("food");

    foodTextEdit.setText(food.getFoodName());
    foodImageViewEdit.setImageURI(Uri.parse(food.getFoodImageName()));
    imagePath = food.getFoodImageName();
    foodRatingBarEdit.setNumStars(food.getFoodRating());
    rating = food.getFoodRating();


    foodImageViewEdit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        isStoragePermissionGranted();
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        //intent.putExtra("outputX", 256);
        //intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
      }
    });


    foodRatingBarEdit.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
      @Override
      public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        rating = (int) v;
      }
    });

    btnfoodUpdate = (Button) findViewById(R.id.btnfoodUpdate);
    btnfoodUpdate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (foodTextEdit.getText().toString().isEmpty()){
          textInputLayout.setError(getResources().getResourceName(R.string.food_name_missing));
          textInputLayout.setError(null);
        } else {
          FoodDB foodDB = new FoodDB(getBaseContext());
          food.setFoodName(foodTextEdit.getText().toString());
          food.setFoodImageName(imagePath);
          food.setFoodRating(rating);
          if(foodDB.update(food)){
            Intent editIntent = new Intent(FoodEdit.this, MainActivity.class);
            startActivity(editIntent);
          } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage(getResources().getResourceName(R.string.fail_message));
            builder.setCancelable(false);
            builder.setPositiveButton(getResources().getResourceName(R.string.okay_message), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {

              }
            });
            builder.create().show();
          }
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
