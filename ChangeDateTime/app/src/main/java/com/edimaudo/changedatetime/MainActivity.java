package com.edimaudo.changedatetime;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
  private TextView textView;
  private Button changeDate;
  private LinearLayout pickerInfo;
  private DatePicker datePicker;
  private TimePicker timePicker;
  private int day,month, year, hour,min;

  private final int DATE_DIALOG_ID = 0;
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

            //Calendar calendar = new GregorianCalendar(
                    //datePicker.getYear(),
                    //datePicker.getMonth(),
                    //datePicker.getDayOfMonth(),
                    //timePicker.getCurrentHour(),
                    //timePicker.getCurrentMinute());


            alertDialog.dismiss();
          }});
        alertDialog.setView(dialogView);
        alertDialog.show();
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
    StringBuilder stringInfo = new StringBuilder();

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
