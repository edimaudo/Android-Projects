package com.edimaudo.quickcompliments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private TextView submitText, complimentText, blurb;
  private EditText editText;
  private Button button;
  public ArrayList<String> compliments = new ArrayList<String>() {{
    add("hey");
    add("you rock");
    add("You are amazing");
    add("nice");
    add("bad ass");
    add("Big ups");
    add("So real");
    add("Hacker");
    add("Bro");
    add("Totally");
    add("big ups");
    add("Stand up");
    add("So Yeah");
    add("Big ups");
    add("Wowzer!");
  }};


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    submitText = (TextView) findViewById(R.id.submit_text);
    complimentText = (TextView) findViewById(R.id.compliment_text);
    blurb = (TextView) findViewById(R.id.blurb);
    editText = (EditText) findViewById(R.id.editText);
    button = (Button) findViewById(R.id.button);

    complimentText.setText(getCompliment());
    submitText.setVisibility(View.INVISIBLE);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (editText.getText().toString().isEmpty()){
          submitText.setVisibility(View.INVISIBLE);
          complimentText.setText(getCompliment());

        } else {
          addText(editText.getText().toString());
          submitText.setVisibility(View.VISIBLE);
          complimentText.setText(getCompliment());
          editText.setText("");
        }
      }
    });

  }

  public void addText(String word){
    compliments.add(word);
  }

  public String getCompliment(){
    Random rand = new Random();
    return compliments.get(rand.nextInt(compliments.size()));
  }
}
