package com.edimaudo.toughlove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private TextView habitOutput;
  private Button submitButton;
  private EditText habitInput;
  private final String issue = "I see you didn't enter anything eh";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    habitOutput = (TextView) findViewById(R.id.habitOutput);
    submitButton = (Button) findViewById(R.id.submitButton);
    habitInput = (EditText) findViewById(R.id.habitInput);

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        habitOutput.setText("");
        if (habitInput.getText().toString().isEmpty()){
          habitOutput.setText(issue + "\n" + generateMessage());
        } else {
          StringBuilder output = new StringBuilder();
          output.append(habitInput.getText().toString());
          output.append("eh");
          output.append("\n");
          output.append(generateMessage());
          habitOutput.setText(output.toString());
        }
        habitInput.setText("");
      }
    });
  }


  public String generateMessage(){
    Random rand = new Random();
    String [] messageData  = {
            "That\'s terrible! You should knock that off!",
            "When do you plan on becoming an adult?",
            "Gross. You are gross.",
            "What? Who does that?!","NO! Bad!",
    "My disapproval is overwhelming.",
            "Aren\'t you a little old for that crap?",
            "You are bad and you should feel bad!",
    "A kitten dies everytime you do that.",
    "And when do you plan on becoming an adult?",
    "That is totally unacceptable."};
    return messageData[rand.nextInt(messageData.length)];
  }
}
