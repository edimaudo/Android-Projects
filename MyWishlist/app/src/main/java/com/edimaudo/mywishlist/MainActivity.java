package com.edimaudo.mywishlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.DatabaseHandler;
import model.MyWish;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText title;
    private EditText content;
    private DatabaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.saveButton);
        title = (EditText) findViewById(R.id.wishListTitle);
        content = (EditText) findViewById(R.id.wishListText);
        dba = new DatabaseHandler(MainActivity.this);
        
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDB();
            }


        });
    }

    private void saveToDB() {
        MyWish wish = new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim());
        dba.addWishes(wish);
        dba.close();
        title.setText("");
        content.setText("");

        Intent i = new Intent(MainActivity.this,DisplayWishesActivity.class);
        startActivity(i);
    }
}
