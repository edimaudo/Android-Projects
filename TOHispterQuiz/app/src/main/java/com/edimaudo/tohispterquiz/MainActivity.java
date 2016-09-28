package com.edimaudo.tohispterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

  private RadioGroup question1answer,question2answer,
          question3answer,question4answer,question5answer;
  private Button submitButton;
  public final static String  EXTRA_MESSAGE = "com.edimaudo.tohispterquiz.MESSAGE";
  public String message = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    question1answer = (RadioGroup) findViewById(R.id.question1answer);
    question2answer = (RadioGroup) findViewById(R.id.question2answer);
    question3answer = (RadioGroup) findViewById(R.id.question3answer);
    question4answer = (RadioGroup) findViewById(R.id.question4answer);
    question5answer = (RadioGroup) findViewById(R.id.question5answer);


    submitButton = (Button) findViewById(R.id.submitButton);
    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String result = generateScore();
        if (result.equals("issue")){
          Snackbar
                  .make(view, "Please fill the form.",Snackbar.LENGTH_SHORT)
                  .show();
        } else {
          Intent selectOption = new Intent(getApplicationContext(),quiz_outcome.class);
          selectOption.putExtra(EXTRA_MESSAGE,result);
          startActivity(selectOption);
        }
      }
    });

    Intent in = getIntent();
    if(in.getStringExtra(quiz_outcome.EXTRA_MESSAGE) == null){
    } else {
      message = in.getStringExtra(quiz_outcome.EXTRA_MESSAGE);
      if (message.equals("reset")){
        resetQuiz();
      }

    }

  }

  private String generateScore(){
    int total = 0;
    String outcome = "issue";;
    int [] questionResult = {question1answer.getCheckedRadioButtonId(),
            question2answer.getCheckedRadioButtonId(),
            question3answer.getCheckedRadioButtonId(),
            question4answer.getCheckedRadioButtonId(),
            question5answer.getCheckedRadioButtonId()};

    for (int i = 0; i < questionResult.length; i++){
      total+=questionResult[i];
    }
    Log.i("total",String.valueOf(total));
    if (total > 10 && total < 15){
      outcome = getResources().getString(R.string.outcome1);
    } else {
      outcome = getResources().getString(R.string.outcome2);
    }
    return outcome;
  }

  public void resetQuiz(){
    question1answer.clearCheck();
    question2answer.clearCheck();
    question3answer.clearCheck();
    question4answer.clearCheck();
    question5answer.clearCheck();
  }

}
