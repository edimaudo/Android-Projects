package com.edimaudo.taptap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.myButton);//get button id
        textView = (TextView) findViewById(R.id.textView); //get textview id

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Hello There!");
                Toast.makeText(MainActivity.this, "Button has been tapped", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
