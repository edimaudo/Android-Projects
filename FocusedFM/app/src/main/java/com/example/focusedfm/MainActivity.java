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
  Button modeButton;
  Boolean ischecked = Boolean.FALSE;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button modeButton = (Button) findViewById(R.id.modeButton);

    modeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (ischecked){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
          modeButton.setText(getResources().getString(R.string.night_mode));
          ischecked = Boolean.FALSE;
        } else {

          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
          modeButton.setText(getResources().getString(R.string.light_mode));
          ischecked = Boolean.TRUE;

        }
      }
    });



  }
}