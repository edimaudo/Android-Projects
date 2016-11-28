package com.edimaudo.mondrian;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private Button nextButton;
  private TextView textBox1, textBox2, textBox3, textBox4, textBox5;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nextButton = (Button) findViewById(R.id.nextButton);
    textBox1 = (TextView) findViewById(R.id.textBox1);
    textBox2 = (TextView) findViewById(R.id.textBox2);
    textBox3 = (TextView) findViewById(R.id.textBox3);
    textBox4 = (TextView) findViewById(R.id.textBox4);
    textBox5 = (TextView) findViewById(R.id.textBox5);



    nextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String[] color = {"#6C7A89","#3F51B5","#FF4081","#96281B","#3498DB","#446CB3","#F9BF3B",
                "#00B16A","#D35400","#26A65B","#663399","#9A12B3"};
        Random random = new Random();
        textBox1.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
        textBox2.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
        textBox3.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
        textBox4.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
        textBox5.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
        nextButton.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
      }
    });
  }


}
