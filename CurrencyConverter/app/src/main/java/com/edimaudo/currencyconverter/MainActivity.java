package com.edimaudo.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  private Spinner fromCurrency, toCurrency;
  private TextView userOutput;
  private Button getConversion;
  private String API_KEY= "";
  private String API_STRING = "https://openexchangerates.org/api/latest.json?app_id=";
  private HashMap<String,Double> currencyData = new HashMap<String, Double>();
  private ArrayList<String> currencyName = new ArrayList<String>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    userOutput = (TextView) findViewById(R.id.userOutput);
    getConversion = (Button) findViewById(R.id.getConversion);
    fromCurrency = (Spinner) findViewById(R.id.fromCurrency);
    toCurrency = (Spinner) findViewById(R.id.toCurrency);

    getConversion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });


  }

  public String validateInput(){
    String output = "";
    return output;
  }

  public Double convertCurrency(){
   Double output = 0.00;
    return output;
  }

}
