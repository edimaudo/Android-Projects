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

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  private Spinner dateTimeInfo;
  private TextView userOutput;
  StringBuilder itemInfo = new StringBuilder();
  String item;

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
    if (userInput.getText().toString().isEmpty()){
      Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
    } else {
      switch (item){
        case "days":
        break;
        case "years":
          break;
        case "months":
          break;
        case "weeks":
          break;
        case "hours":
          break;
        case "minutes":
          break;
        case "seconds":
          break;

      }

    }
    //DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
    //Date dNow = new Date();
    //SimpleDateFormat ft = new SimpleDateFormat ("MMMM d',' yyyy',' hh:mm:ss a");
    //currentDateTime.setText(ft.format(dNow));

    userOutput.setText("");
  }
}
