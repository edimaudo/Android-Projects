package com.edimaudo.foodtracker;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class add_item extends AppCompatActivity {
  private TextInputLayout inputLayout;
  private EditText foodText;
  private TextView foodImage;
  private RatingBar rating;
  private Button addFood;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_item);

    inputLayout = (TextInputLayout) findViewById(R.id.inputLayout);
    foodText = (EditText) findViewById(R.id.foodText);
    foodImage = (TextView) findViewById(R.id.foodImage);
    rating = (RatingBar) findViewById(R.id.rating);
    addFood = (Button) findViewById(R.id.addFood);

    addFood.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //check if edit text is not
        if (foodText.getText().toString().isEmpty()){
          inputLayout.setError("First name is required"); // show error
          //inputLayout.setError(null);
        }


      }
    });
  }
}

//add variables, fix UI, design food class and database helper + delete, updated + information show