package com.example.focusedfm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
public class MainActivity extends AppCompatActivity {

  Switch themeSwitch;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Switch themeSwitch = (Switch) findViewById(R.id.themeSwitch);

    themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.isChecked()){

        } else {

        }
      }
    });

  }
}