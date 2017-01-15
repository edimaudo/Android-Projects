package com.edimaudo.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DatabaseHandler;
import model.Food;

public class MainActivity extends AppCompatActivity {

    private EditText foodName, foodCals;
    private Button submitButton;
    private DatabaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dba = new DatabaseHandler(MainActivity.this);
        foodName = (EditText) findViewById(R.id.foodEditText);
        foodCals = (EditText) findViewById(R.id.caloriesEditText);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToDB();
            }
        });

    }

    private void saveDataToDB() {
        Food food = new Food();
        String name = foodName.getText().toString().trim();
        String calString = foodCals.getText().toString().trim();
        int cals = Integer.parseInt(calString);
        if (name.equals("")|| calString.equals("")){
            Toast.makeText(getApplicationContext(), "No empty fields allowed", Toast.LENGTH_SHORT).show();
        } else {
            food.setFoodName(name);
            food.setCalories(cals);
            dba.addFood(food);
            dba.close();
            //clear edit text
            foodName.setText("");
            foodCals.setText("");
            //take users to next screen
            startActivity(new Intent(MainActivity.this,DisplayActivity.class));

        }
    }
}
