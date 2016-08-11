package com.edimaudo.verticalviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
  private RelativeLayout relativeLayout;
  private TextView textView;
  private int count = 1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    textView = (TextView) findViewById(R.id.textView);

    class OnSwipeListener{

    }

  }
}
