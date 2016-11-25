package com.edimaudo.mondrian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private RelativeLayout mainLayout;
  private Button nextButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
    nextButton = (Button) findViewById(R.id.nextButton);

    showMondrian();
    nextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Random random = new Random();
        int nextVal = random.nextInt(4);

        switch (nextVal){
          case 0:
            break;
          case 1:
            break;
          case 2:
            break;
          case 3:
        }
      }
    });
  }

  public void showMondrian(){
    getLayoutInflater().inflate(R.layout.composition2, mainLayout);
  }
}
