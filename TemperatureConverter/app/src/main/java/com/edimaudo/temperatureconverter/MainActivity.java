package com.edimaudo.temperatureconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private Button celButton;
    private Button farButton;
    EditText editText;
    TextView outputText;
    String userInput = "";
    Double userData;
    Double outputInfo;
    int idInfo;
    DecimalFormat round = new DecimalFormat("0.0");

    public Double celsiusConvert(double userValue){
        Double farenehit = userValue *1.8 + 32;
        return farenehit;
    }

    public static Double farenheitConvert(double userValue){
        Double celsius = (userValue - 32)/1.8;
        return celsius;
    }

    public void onTapped (View view){
        outputText.setText("");
        userInput = editText.getText().toString();
        if (userInput.equals("")){
            Toast.makeText(MainActivity.this, "Please enter a numerical value", Toast.LENGTH_SHORT).show();
        } else {
            idInfo = Integer.parseInt(view.getTag().toString());
            userData = Double.parseDouble(userInput);
            if (idInfo == 0){
                outputInfo = celsiusConvert(userData);
                outputText.setText(String.valueOf(round.format(outputInfo)) + " C");
            } else {
                outputInfo = farenheitConvert(userData);
                outputText.setText(String.valueOf(round.format(outputInfo)) + " F");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celButton = (Button) findViewById(R.id.celsius);
        farButton = (Button) findViewById(R.id.farenheit);
        editText = (EditText) findViewById(R.id.userInput);
        outputText = (TextView) findViewById(R.id.output);
    }
}
