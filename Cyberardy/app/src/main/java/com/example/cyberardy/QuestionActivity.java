package com.example.cyberardy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;

public class QuestionActivity extends AppCompatActivity {

  final String[] cyber200 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] cyber400 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] cyber600 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] cyber800 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] cyber1000 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] crypto200 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] crypto400 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] crypto600 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] crypto800 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] crypto1000 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] phishing200 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] phishing400 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] phishing600 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] phishing800 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};
  final String[] phishing1000 = {"Q1","Q2","Q3","Q4","Q5","Q6","PA","PA","PA","PA","CA"};




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

  }
}