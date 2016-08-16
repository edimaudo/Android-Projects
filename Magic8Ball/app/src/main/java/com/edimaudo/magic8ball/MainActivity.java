package com.edimaudo.magic8ball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  private ImageView eightBall;
  private EditText userInput;
  private TextView userOutput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    eightBall = (ImageView) findViewById(R.id.imageInfo);
    userInput = (EditText) findViewById(R.id.userInput);
    userOutput = (TextView) findViewById(R.id.userOutput);

    userInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
          eightBall.startAnimation(shake);
          getResult();
        }
        return false;
      }
    });

  }

  public void getResult(){
    String outcome = "";
    Random rand = new Random();
    int choice = rand.nextInt(3);
    if (userInput.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter a question", Toast.LENGTH_SHORT).show();
      userOutput.setText("");
    } else {
      switch(choice){
        case 0:
          outcome = "Yes";
          break;
        case 1:
          outcome = "No";
          break;
        case 2:
          outcome = "Maybe";
          break;
        case 3:
          outcome = "Ask again later";
          break;
        default:
          outcome = "Maybe";
      }
      userOutput.setText(outcome);
    }


  }
}
