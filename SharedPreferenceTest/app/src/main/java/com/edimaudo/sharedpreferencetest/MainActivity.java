package com.edimaudo.sharedpreferencetest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button sharedPreferenceButton;
    private TextView sharedPreferenceOutput;
    private static final String PREFS_NAME = "MyPrefsFile";//shared prferene holder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.userInput);
        sharedPreferenceButton = (Button) findViewById(R.id.getSharedPreferenceButton);
        sharedPreferenceOutput = (TextView) findViewById(R.id.sharedPreferenceOutput);

        sharedPreferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPrefs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPrefs.edit();//change shared preference data

                if (userInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please add a user input", Toast.LENGTH_SHORT).show();
                } else{
                    editor.putString("name",userInput.getText().toString());//add new info to shared preferences
                    editor.commit();
                }

            }
        });
        //retrieve data
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if (prefs.contains("name")){
            String userName = prefs.getString("name","not found");
            sharedPreferenceOutput.setText("You are " + userName);
        } else {
            sharedPreferenceOutput.setText("");
        }

    }
}
