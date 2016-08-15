package com.edimaudo.datefromnow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  private Spinner dateTimeInfo;
  private TextView userOutput;
  StringBuilder itemInfo = new StringBuilder();
  String item = "days";
  String output;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    dateTimeInfo = (Spinner) findViewById(R.id.dateTimeInfo);
    userOutput = (TextView) findViewById(R.id.timeOutput);

    String[] items = new String[]{"years","months","weeks","days","hours","minutes","seconds"};
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, items);
    dateTimeInfo.setAdapter(adapter);

    int spinnerPosition = adapter.getPosition("days");
    dateTimeInfo.setSelection(spinnerPosition);
    showOutput();

    userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE){
          showOutput();
        }
        return false;
      }
    });

    dateTimeInfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();
        showOutput();
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });
   }

  public void showOutput(){
    SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
    Calendar cal = Calendar.getInstance();
    if (userInput.getText().toString().isEmpty()){
      Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
      userOutput.setText(ft.format(cal.getTime()));
    } else {



      String choice = item;
      int timeValue = Integer.parseInt(userInput.getText().toString());

      switch (choice){
        case "days":
          cal.add(Calendar.DAY_OF_MONTH, timeValue);
        break;
        case "years":
          cal.add(Calendar.YEAR,timeValue);
          break;
        case "months":
          cal.add(Calendar.MONTH,timeValue);
          break;
        case "weeks":
          cal.add(Calendar.WEEK_OF_YEAR,timeValue);
          break;
        case "hours":
          ft = new SimpleDateFormat ("MM/dd/yyyy hh:mm:ss a");
          cal.add(Calendar.HOUR_OF_DAY,timeValue);
          break;
        case "minutes":
          ft = new SimpleDateFormat ("MM/dd/yyyy hh:mm:ss a");
          cal.add(Calendar.MINUTE,timeValue);
          break;
        case "seconds":
          ft = new SimpleDateFormat ("MM/dd/yyyy hh:mm:ss a");
          cal.add(Calendar.SECOND,timeValue);
          break;
      }
      output = ft.format(cal.getTime());
      userOutput.setText(output);
    }


  }
}
