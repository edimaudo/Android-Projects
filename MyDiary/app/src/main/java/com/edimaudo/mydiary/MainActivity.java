package com.edimaudo.mydiary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.userInput);
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userInput.getText().toString().equals("")){
                   String data = userInput.getText().toString();
                    writeToFile(data);
                    Toast.makeText(getApplicationContext(), "Entry saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter some text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (readFromFile() != null){
            userInput.setText(readFromFile());
        } else {

        }
    }

    private void writeToFile(String myData){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("diary.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(myData);
            outputStreamWriter.close();
        } catch (IOException e){
            Log.v("MyActivity", e.toString());
        }
    }

    private String readFromFile(){
        String result = "";
        try {
            InputStream inputStream = openFileInput("diary.txt");
            if (inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((tempString = bufferedReader.readLine()) != null){
                    stringBuilder.append(tempString);
                }
                inputStream.close();
                result = stringBuilder.toString();
            }
        } catch (IOException e) {
            Log.v("MyAcitivty", e.toString());
        }
        
        return result;
    }
}
