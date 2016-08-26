package com.edimaudo.partytime;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
  private TextView introText,output;
  private Button getDateTimeButton;
  private int day,month, year, hour, min;
  private View dialogView;
  private AlertDialog alertDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    introText = (TextView) findViewById(R.id.introText);
    output = (TextView) findViewById(R.id.output);

    getDateTimeButton = (Button) findViewById(R.id.getDateTimeButton);
    alertDialog = new AlertDialog.Builder(this).create();
    dialogView = View.inflate(this, R.layout.date_time_picker, null);

    getDateTimeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

            DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
            TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

            Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                    datePicker.getMonth(),
                    datePicker.getDayOfMonth(),
                    timePicker.getCurrentHour(),
                    timePicker.getCurrentMinute());

            year = datePicker.getYear();
            month = datePicker.getMonth();
            day = datePicker.getDayOfMonth();
            hour = timePicker.getCurrentHour();
            min = timePicker.getCurrentMinute();
            showOutput();
            alertDialog.dismiss();
          }});
        alertDialog.setView(dialogView);
        alertDialog.show();
      }
    });

  }

  public void showOutput(){

    Calendar cal = Calendar.getInstance();
    if(cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month
            && cal.get(Calendar.DAY_OF_MONTH) == day){
      introText.setText("It\'s party Time");
    } else {
      introText.setText("Boo! It\'s not party time");
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Your birthday is ");
    stringBuilder.append(getMonthName(month));
    stringBuilder.append(" ");
    stringBuilder.append(day);

    stringBuilder.append("\n");
    stringBuilder.append("\n");

    stringBuilder.append("You\'re ");
    stringBuilder.append(dateTimeDifference("years",year));
    stringBuilder.append(" years old");

    stringBuilder.append("\n");
    stringBuilder.append("\n");

    stringBuilder.append("You\'re ");
    stringBuilder.append(dateTimeDifference("days",day));
    stringBuilder.append(" days old");

    stringBuilder.append("\n");
    stringBuilder.append("\n");

    stringBuilder.append("You \'re ");
    stringBuilder.append("");
    stringBuilder.append(" minutes old");


    output.setText(stringBuilder.toString());
  }



  public String getMonthName(int Value){
    StringBuilder stringInfo = new StringBuilder();
    switch(Value){
      case 0:
        stringInfo.append("January");
        break;
      case 1:
        stringInfo.append("February");
        break;
      case 2:
        stringInfo.append("March");
        break;
      case 3:
        stringInfo.append("April");
        break;
      case 4:
        stringInfo.append("May");
        break;
      case 5:
        stringInfo.append("June");
        break;
      case 6:
        stringInfo.append("July");
        break;
      case 7:
        stringInfo.append("August");
        break;
      case 8:
        stringInfo.append("September");
        break;
      case 9:
        stringInfo.append("October");
        break;
      case 10:
        stringInfo.append("November");
        break;
      case 11:
        stringInfo.append("December");
        break;
    }
    return stringInfo.toString();
  }

  public String dateTimeDifference(String choice,int timeDate){
    StringBuilder stringBuilder = new StringBuilder();
    Calendar cal = Calendar.getInstance();
    int calc = 0;
    switch (choice){
      case "days":
        calc = cal.get(Calendar.DAY_OF_MONTH) - timeDate;
        stringBuilder.append(calc);
        break;
      case "years":
        calc = cal.get(Calendar.YEAR) - timeDate;
        stringBuilder.append(calc);
        break;
    }
    return stringBuilder.toString();
  }



}
