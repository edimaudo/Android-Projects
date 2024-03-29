package com.example.lunchtray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

  public Button startOrderButton;
  public Intent orderIntent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startOrderButton = (Button) findViewById(R.id.start_order_btn);

    startOrderButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       launchEntree();
      }
    });
  }

  public void launchEntree(){
    orderIntent = new Intent(this,EntreeMenu.class);
    startActivity(orderIntent);
  }
}

