package com.example.focusedfm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {


  Switch themeSwitch;
  Button channelButton;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
      setTheme(R.style.Theme_FocusedFM_Dark);
    } else {
      setTheme(R.style.Theme_FocusedFM_Light);
    }
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Switch themeSwitch = (Switch) findViewById(R.id.themeSwitch);
    Button channelButton = (Button) findViewById(R.id.channelButton);

    themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }
      }
    });

  channelButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
  });

  //channelInfo


  }
}