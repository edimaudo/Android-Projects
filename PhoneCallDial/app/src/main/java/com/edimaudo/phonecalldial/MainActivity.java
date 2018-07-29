package com.edimaudo.phonecalldial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getSimpleName();//log tag

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void dialNumber(View view) {
    TextView textView = (TextView) findViewById(R.id.number_to_call);
    String phoneNumber = String.format("tel: %s",
            textView.getText().toString());
    // Create the intent.
    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
    // Set the data for the intent as the phone number.
    dialIntent.setData(Uri.parse(phoneNumber));
    // If package resolves to an app, send intent.
    if (dialIntent.resolveActivity(getPackageManager()) != null) {
      startActivity(dialIntent);
    } else {
      Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
    }


  }
}
