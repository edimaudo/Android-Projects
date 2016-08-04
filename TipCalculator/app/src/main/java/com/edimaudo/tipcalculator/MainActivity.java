package com.edimaudo.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
  private SeekBar seekBar;
  private EditText tipInput;
  private TextView tip,total;
  private int tipData = 15;
  private Double userAmount = 0.00;
  private Double tipAmount = 0.00;
  private Double totalAmount = 0.00;
  DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    seekBar = (SeekBar) findViewById(R.id.seekbar);
    tipInput = (EditText) findViewById(R.id.tipInput);
    tip = (TextView) findViewById(R.id.tipText);
    total = (TextView) findViewById(R.id.totalText);
    seekBar.setProgress(15);

    tip.setText(String.valueOf("Tip" + "(" + tipData  + "%" + "): " + "   " + df2.format(tipAmount)));
    total.setText(String.valueOf("        " + "          Total:" + "     " + df2.format(totalAmount)));

    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tipData = i;
        generateTip();
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    tipInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          generateTip();
        }
        return false;
      }
    });
  }

  public void generateTip(){
    if (tipInput.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter a price", Toast.LENGTH_SHORT).show();
    } else {
      userAmount = Double.parseDouble(tipInput.getText().toString());
      tipAmount = userAmount*tipData;
      totalAmount = tipAmount + userAmount;
      tip.setText(String.valueOf("Tip" + "(" + tipData  + "%" + "): " + "   " + df2.format(tipAmount)));
      total.setText(String.valueOf("        " + "          Total:    " + "" + df2.format(totalAmount)));
    }


  }





}
