package com.example.cyberardy;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

  // Unique tag for the intent reply
  public int TEXT_REQUEST = 1;
  // Unique tag required for the intent extra
  public static final String EXTRA_MESSAGE = "com.example.cyberardy.extra.MESSAGE";

  // Questions
  final String[] data = {"Q1","Q2","Q3","Q4","Q5","Q6"};
  String question = "";

  // Score
  private TextView ScoreText;

  //game Buttons
  private Button cyber200Button,cyber400Button,cyber600Button,cyber800Button,cyber1000Button;
  private Button crypto200Button,crypto400Button,crypto600Button,crypto800Button,crypto1000Button;
  private Button phishing200Button,phishing400Button,
          phishing600Button,phishing800Button,phishing1000Button;

  // Function to create question to be asked
  public String generateQuestion(){
    String question = "";
    Random rand = new Random();
    int num = rand.nextInt(data.length);
    question = data[num];
    return question;
  }

  // Function to update the Score

  // Function to end the game

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    cyber200Button = (Button) findViewById(R.id.cyber_section_200);
    cyber400Button = (Button) findViewById(R.id.cyber_section_400);
    cyber600Button = (Button) findViewById(R.id.cyber_section_600);
    cyber800Button = (Button) findViewById(R.id.cyber_section_800);
    cyber1000Button = (Button) findViewById(R.id.cyber_section_1000);
    crypto200Button = (Button) findViewById(R.id.crypto_section_200);
    crypto400Button = (Button) findViewById(R.id.crypto_section_400);
    crypto600Button = (Button) findViewById(R.id.crypto_section_600);
    crypto800Button = (Button) findViewById(R.id.crypto_section_800);
    crypto1000Button = (Button) findViewById(R.id.crypto_section_1000);
    phishing200Button = (Button) findViewById(R.id.phishing_section_200);
    phishing400Button = (Button) findViewById(R.id.phishing_section_400);
    phishing600Button = (Button) findViewById(R.id.phishing_section_600);
    phishing800Button = (Button) findViewById(R.id.phishing_section_800);
    phishing1000Button = (Button) findViewById(R.id.phishing_section_1000);

    cyber200Button.setOnClickListener(this);
    cyber400Button.setOnClickListener(this);
    cyber600Button.setOnClickListener(this);
    cyber800Button.setOnClickListener(this);
    cyber1000Button.setOnClickListener(this);
    crypto200Button.setOnClickListener(this);
    crypto400Button.setOnClickListener(this);
    crypto600Button.setOnClickListener(this);
    crypto800Button.setOnClickListener(this);
    crypto1000Button.setOnClickListener(this);
    phishing200Button.setOnClickListener(this);
    phishing400Button.setOnClickListener(this);
    phishing600Button.setOnClickListener(this);
    phishing800Button.setOnClickListener(this);
    phishing1000Button.setOnClickListener(this);


  }

  @Override
  public void onClick(View view) {
    Intent intent;
    switch (view.getId()){
      case R.id.cyber_section_200:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.cyber_section_400:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.cyber_section_600:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.cyber_section_800:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.cyber_section_1000:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.crypto_section_200:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.crypto_section_400:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.crypto_section_600:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.crypto_section_800:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.crypto_section_1000:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.phishing_section_200:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.phishing_section_400:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.phishing_section_600:
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        question = generateQuestion();
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.phishing_section_800:
        question = generateQuestion();
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;
      case R.id.phishing_section_1000:
        question = generateQuestion();
        intent = new Intent(getApplicationContext(), QuestionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, question);
        startActivityForResult(intent, TEXT_REQUEST);
        break;

    }
  }
}