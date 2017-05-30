package com.edimaudo.foodtracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by edima on 2017-05-25.
 */



public class FoodDetails extends AppCompatActivity {

  private TextView foodText;
  private ImageView display_image_view;
  private Button btnEdit, btnDelete;
  private RatingBar ratingBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_food_details);


    ratingBar = (RatingBar) findViewById(R.id.ratingBar);

    btnEdit = (Button) findViewById(R.id.btnEdit);
    btnDelete = (Button) findViewById(R.id.btnDelete);

    foodText = (TextView) findViewById(R.id.foodText);
    display_image_view = (ImageView) findViewById(R.id.display_image_view);

    Intent foodIntent = getIntent();
    final Food food = (Food) foodIntent.getSerializableExtra("food");

    foodText.setText(food.getFoodName());
    ratingBar.setNumStars(food.getFoodRating());
    display_image_view.setImageURI(Uri.parse(food.getFoodImageName()));

    btnEdit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent editIntent = new Intent(FoodDetails.this, FoodEdit.class);
        editIntent.putExtra("foodEdit",food);
        startActivity(editIntent);
      }
    });

    btnDelete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(view.getContext());
        builder.setCancelable(false);
        builder.setTitle(getResources().getString(R.string.delete_title));
        builder.setMessage(getResources().getString(R.string.delete_message));
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            FoodDB foodDB = new FoodDB(getBaseContext());

            if (foodDB.delete(food.getId())){
              Intent deleteIntent = new Intent(FoodDetails.this, MainActivity.class);
              startActivity(deleteIntent);
            } else {
              AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
              builder.setCancelable(false);
              builder.setMessage(getResources().getString(R.string.fail_message));
              builder.setPositiveButton(getResources().getString(R.string.okay_message), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  dialogInterface.cancel();
                }
              });
              builder.create().show();
            }
          }
        });

        builder.setNegativeButton(getResources().getString(R.string.negative_message), new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

          }
        });
        builder.create().show();
      }
    });
  }
}
