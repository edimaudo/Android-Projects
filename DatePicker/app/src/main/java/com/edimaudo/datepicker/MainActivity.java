package com.edimaudo.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

  private Button setDate;
  private int day, year, month;
  private Calendar calendar;
  private DatePicker datePicker;
  private final int DATE_DIALOG_ID = 0;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    calendar = Calendar.getInstance();
    year = calendar.get(Calendar.YEAR);
    month = calendar.get(Calendar.MONTH);
    day = calendar.get(Calendar.DAY_OF_MONTH);
    showDate(year,month,day);
    setDate = (Button) findViewById(R.id.setDate);
    setDate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showDialog(DATE_DIALOG_ID);
      }
    });
  }

  private void showDate(int year, int month, int day) {
    getSupportActionBar().setTitle(new StringBuilder().append(getMonth(month))
            .append(String.valueOf(" "))
            .append(String.valueOf(day)).append(String.valueOf(", "))
            .append(String.valueOf(year)));

  }

  public String getMonth(int Value){
    String output = "";
    switch(Value){
      case 0:
        output = "January";
        break;
      case 1:
        output = "February";
        break;
      case 2:
        output = "March";
        break;
      case 3:
        output = "April";
        break;
      case 4:
        output = "May";
        break;
      case 5:
        output = "June";
        break;
      case 6:
        output = "July";
        break;
      case 7:
        output = "August";
        break;
      case 8:
        output = "September";
        break;
      case 9:
        output = "October";
        break;
      case 10:
        output = "November";
        break;
      case 11:
        output = "December";
        break;
    }
    return output;
  }

  @Override
  @SuppressWarnings("deprecation")
  protected Dialog onCreateDialog(int id) {
    switch (id) {
      case DATE_DIALOG_ID:
        return new DatePickerDialog(this, pDateSetListener, year, month, day);
    }
    return null;
  }

  private DatePickerDialog.OnDateSetListener pDateSetListener =
          new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int yearInfo,
                                  int monthOfYear, int dayOfMonth) {
              year = yearInfo;
              month = monthOfYear;
              day = dayOfMonth;
              showDate(year,month,day);
            }
          };









}
