package com.edimaudo.getdatetime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
  private TextView currentDateTime;
  private Button refreshDateTime;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    currentDateTime = (TextView) findViewById(R.id.currentDateTime);
    refreshDateTime = (Button) findViewById(R.id.refreshDateTime);
    getDateTime();

    refreshDateTime.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if(view.getId() == R.id.refreshDateTime){
          getDateTime();
        }
      }
    });
  }

  public void getDateTime(){
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("MMMM d',' yyyy',' hh:mm:ss a");
    currentDateTime.setText(ft.format(dNow));
  }
}

