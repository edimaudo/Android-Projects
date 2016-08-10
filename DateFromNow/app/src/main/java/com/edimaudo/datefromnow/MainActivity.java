package com.edimaudo.datefromnow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  private Spinner dateTimeInfo;
  private TextView userOutput;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    dateTimeInfo = (Spinner) findViewById(R.id.dateTimeInfo);
    userOutput = (TextView) findViewById(R.id.timeOutput);

    String[] items = new String[]{"years","months","weeks","days","hours","minutes","seconds"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
    dateTimeInfo.setAdapter(adapter);

    userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE){

        }
        return false;
      }
    });
   }

  public void showOutput(){
    //DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("MMMM d',' yyyy',' hh:mm:ss a");
    //currentDateTime.setText(ft.format(dNow));
  }
}
