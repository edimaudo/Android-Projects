package com.edimaudo.changedatetime;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {
  private TextView textView;
  private Button changeDate, dateTimeSet;
  private LinearLayout pickerInfo;
  private DatePicker datePicker;
  private TimePicker timePicker;
  private int day,month, year, hour,min;
  private View dialogView;
  private AlertDialog alertDialog;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textView);
    changeDate = (Button) findViewById(R.id.changeDate);
    pickerInfo = (LinearLayout) findViewById(R.id.pickerInfo);
    datePicker = (DatePicker) findViewById(R.id.date_picker);
    timePicker = (TimePicker) findViewById(R.id.time_picker);
    dateTimeSet = (Button) findViewById(R.id.date_time_set);


    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("MMMM d',' yyyy 'at' hh:mm a");
    textView.setText(ft.format(dNow));

    alertDialog = new AlertDialog.Builder(this).create();
    dialogView = View.inflate(this, R.layout.date_time, null);

    changeDate.setOnClickListener(new View.OnClickListener() {
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
            alertDialog.dismiss();
          }});
        alertDialog.setView(dialogView);
        alertDialog.show();
      }
    });

    alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override
      public void onDismiss(DialogInterface dialogInterface) {
       showDateTime();
      }
    });
  }

  public void showDateTime(){
    textView.setText(new StringBuilder()
            .append(getMonth(month))
            .append(String.valueOf(" "))
            .append(String.valueOf(day))
            .append(String.valueOf(", "))
            .append(String.valueOf(year))
            .append(String.valueOf(" at "))
            .append(getHourMin(hour,min)));
  }
  private String getHourMin(int hourInfo, int minInfo){
    String minString = String.valueOf(minInfo);
    String hourString = String.valueOf(hourInfo);
    String format = "AM";
    StringBuilder stringInfo = new StringBuilder();

    if (hourInfo == 0) {
      hourInfo += 12;
      format = "AM";
    }
    else if (hourInfo == 12) {
      format = "PM";
    } else if (hourInfo > 12) {
      hourInfo -= 12;
      format = "PM";
    } else {
      format = "AM";
    }



    if (hourInfo < 10){
      hourString = "0" + String.valueOf(hourInfo);
    }

    if (minInfo < 10){
      minString = "0" + String.valueOf(minInfo);
    }

    stringInfo.append(String.valueOf(hourString));
    stringInfo.append(String.valueOf(":"));
    stringInfo.append(String.valueOf(minString));
    stringInfo.append(" " + format);

    return stringInfo.toString();
  }
  public String getMonth(int Value){
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



}
