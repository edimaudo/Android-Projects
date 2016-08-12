package com.edimaudo.wordclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

  private TextView timeText;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    timeText = (TextView) findViewById(R.id.timeText);
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

  public void updateTime(){
    StringBuilder stringInfo = new StringBuilder();
    StringBuilder timeFormat = new StringBuilder();
    Date date = Calendar.getInstance().getTime();
    int hour = date.getHours();
    if(hour < 12){
      timeFormat.append("AM");
    } else if (hour > 12) {
      hour-=12;
      timeFormat.append("PM");
    }

    stringInfo.append(convertLessThanOneThousand(hour))
            .append("\n")
            .append(convertLessThanOneThousand(date.getMinutes()))
            .append("\n")
            .append(timeFormat.toString());
    timeText.setText(stringInfo);
  }

  private static final String[] tensNames = {
          "",
          " ten",
          " twenty",
          " thirty",
          " forty",
          " fifty",
          " sixty",
          " seventy",
          " eighty",
          " ninety"
  };

  private static final String[] numNames = {
          "",
          " one",
          " two",
          " three",
          " four",
          " five",
          " six",
          " seven",
          " eight",
          " nine",
          " ten",
          " eleven",
          " twelve",
          " thirteen",
          " fourteen",
          " fifteen",
          " sixteen",
          " seventeen",
          " eighteen",
          " nineteen"
  };


  private static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    }
    if (number == 0) return soFar;
    return numNames[number] + " hundred" + soFar;
  }

}
