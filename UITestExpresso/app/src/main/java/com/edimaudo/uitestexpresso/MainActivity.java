package com.edimaudo.uitestexpresso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  Button mLoginButton;
  EditText mEmailET, mPasswordET;
  TextView mResultTV;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mLoginButton = (Button) findViewById(R.id.button);
    mEmailET = (EditText) findViewById(R.id.editTextEmail);
    mPasswordET = (EditText) findViewById(R.id.editTextPassword);
    mResultTV = (TextView) findViewById(R.id.textViewResult);
    mLoginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (mEmailET.getText().toString().equals("codevscolor@gmail.com") &&
                mPasswordET.getText().toString().equals("password"))
          mResultTV.setText("success");
        else
          mResultTV.setText("failed");
      }
    });
  }
  }

