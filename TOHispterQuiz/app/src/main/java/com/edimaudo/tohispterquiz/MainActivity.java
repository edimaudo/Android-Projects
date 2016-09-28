package com.edimaudo.tohispterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

  private RadioGroup question1answer,question2answer,
          question3answer,question4answer,question5answer;
  private Button submitButton;
  public final static String  EXTRA_MESSAGE = "com.edimaudo.tohispterquiz.MESSAGE";

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

        } else {
          Intent selectOption = new Intent(getApplicationContext(),quiz_outcome.class);
          selectOption.putExtra(EXTRA_MESSAGE,result);
          startActivity(selectOption);
        }
      }
    });
  }

  private String generateScore(){
    int total = 0;
    String outcome = "";
    int [] questionResult = {};
    questionResult[0] = question1answer.getCheckedRadioButtonId();
    questionResult[1] = question2answer.getCheckedRadioButtonId();
    questionResult[2] = question3answer.getCheckedRadioButtonId();
    questionResult[3] = question4answer.getCheckedRadioButtonId();
    questionResult[4] = question5answer.getCheckedRadioButtonId();

    for (int i = 0; i < questionResult.length; i++){
      total+=questionResult[i];
    }

    if (total == -1){
      outcome = "issue";
    } else if (total <  4){
      outcome = getResources().getString(R.string.outcome1);
    } else {
      outcome = getResources().getString(R.string.outcome2);
    }
    return outcome;
  }


}
