package com.edimaudo.areaofrectroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText lengthInput, widthInput;
  private TextView output;
  private Switch switchInfo;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    lengthInput = (EditText) findViewById(R.id.lengthInput);
    widthInput = (EditText) findViewById(R.id.widthInput);
    output = (TextView) findViewById(R.id.userOutput);
    switchInfo = (Switch) findViewById(R.id.switchInfo);

    switchInfo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        getOutput(b);
      }
    });

  }

  public void getOutput(boolean info){
    String length = lengthInput.getText().toString();
    String width = widthInput.getText().toString();

    if (length.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter the length", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else if (width.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter the width", Toast.LENGTH_SHORT).show();
      output.setText("");
    } else {
      StringBuilder stringData = new StringBuilder();
      Double lengthInfo = Double.parseDouble(lengthInput.getText().toString());
      Double widthInfo = Double.parseDouble(widthInput.getText().toString());
      String inputData = String.valueOf(lengthInfo * widthInfo);
      if(info){
        String dimensionInfo = "metre";
        stringData.append("You entered dimensions of " + lengthInfo + " " + dimensionInfo + " by " +
                widthInfo + " " + dimensionInfo + "." + "\n");
        stringData.append("The area in metres is " + inputData);
        stringData.append("The area in feet is " + CalcRoom(inputData,dimensionInfo));
      } else {
        String dimensionInfo = "feet";
        stringData.append("You entered dimensions of " + lengthInfo + " " + dimensionInfo + " by " +
                widthInfo + " " + dimensionInfo + "." + "\n");
        stringData.append("The area in feet is " + inputData);
        stringData.append("The area in metres is " + CalcRoom(inputData,dimensionInfo));
      }

      output.setText(stringData.toString());

    }
  }

  public String CalcRoom(String inputValue, String roomType){
    final Double converter = 0.09290304;
    Double input = Double.parseDouble(inputValue);
    if (roomType == "feet"){
      return String.valueOf(Math.sqrt(input * converter));
    } else {
      return String.valueOf(Math.sqrt(input/converter));
    }
  }
}
