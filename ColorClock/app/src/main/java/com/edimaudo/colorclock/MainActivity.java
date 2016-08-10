package com.edimaudo.colorclock;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
  private RelativeLayout relativeLayout;
  private TextView timeInfo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    timeInfo = (TextView) findViewById(R.id.timeInfo);
    Thread t = new Thread() {

      @Override
      public void run() {
        try {
          while (!isInterrupted()) {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                updateTime();
              }
            });
          }
        } catch (InterruptedException e) {
        }
      }
    };

    t.start();
  }

  public String addLeadZero(int number){
    StringBuilder stringInfo = new StringBuilder();
    if (number < 10){
      stringInfo.append("0" + String.valueOf(number));
    } else{
      stringInfo.append(String.valueOf(number));
    }

    return stringInfo.toString();
  }

  public void updateTime(){

    StringBuilder stringInfo = new StringBuilder();
    Date date = Calendar.getInstance().getTime();
    String colorString = "#" + stringInfo.append(addLeadZero(date.getHours()))
            .append(addLeadZero(date.getMinutes()))
            .append(addLeadZero(date.getSeconds())).toString();


    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss a");
    timeInfo.setText(ft.format(date));
    relativeLayout.setBackgroundColor(Color.parseColor(colorString));


  }
}
