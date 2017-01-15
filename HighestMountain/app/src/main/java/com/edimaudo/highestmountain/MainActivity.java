package com.edimaudo.highestmountain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView textView;
    String [] mountains = {"Kilimanjaro", "Everest", "K2","Karjiang"};//mountain info
    int randint;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.myButton);
        textView = (TextView) findViewById(R.id.textView);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                randint = random.nextInt(mountains.length);
                textView.setText(mountains[randint]);
            }
        });
    }
}
