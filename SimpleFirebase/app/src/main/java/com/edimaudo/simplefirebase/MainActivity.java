package com.edimaudo.simplefirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

  private Button button;
  private Firebase mRef;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    Firebase.setAndroidContext(this);
    mRef = new Firebase("https://simplefirebase-9ebd7.firebaseio.com/");
    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Firebase mRefChild = mRef.child("Name");
        mRefChild.setValue("Edima");
      }
    });
  }
}
