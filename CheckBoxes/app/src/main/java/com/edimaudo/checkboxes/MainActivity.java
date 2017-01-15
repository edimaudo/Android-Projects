package com.edimaudo.checkboxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button checkButton;
    private CheckBox dogCheckBox;
    private CheckBox catCheckBox;
    private CheckBox parrotCheckBox;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = (Button) findViewById(R.id.checkBoxButton);
        dogCheckBox = (CheckBox) findViewById(R.id.dogCheckBox);
        catCheckBox = (CheckBox) findViewById(R.id.catCheckBox);
        parrotCheckBox = (CheckBox) findViewById(R.id.parrotCheckBox);
        outputText = (TextView) findViewById(R.id.outputText);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String outputMessage = "";
                if (dogCheckBox.isChecked() && catCheckBox.isChecked() && parrotCheckBox.isChecked()){
                    outputMessage = "You love animals";
                } else if (!dogCheckBox.isChecked() && !catCheckBox.isChecked() && !parrotCheckBox.isChecked()){
                    outputMessage = "You don't like any animal";
                } else if (dogCheckBox.isChecked() && catCheckBox.isChecked()){
                    outputMessage = "You like dogs and cats";
                } else if (catCheckBox.isChecked() && parrotCheckBox.isChecked()){
                    outputMessage = "You like cats and parrotsl";
                } else if (dogCheckBox.isChecked() && parrotCheckBox.isChecked()) {
                    outputMessage = "You like dogs and parrots";
                }else if (dogCheckBox.isChecked()){
                    outputMessage = "You like dogs";
                } else if (catCheckBox.isChecked()){
                    outputMessage = "You like cats";
                } else if (parrotCheckBox.isChecked()){
                    outputMessage = "You like parrots";
                }
                    outputText.setText(outputMessage);
                }

        });
    }
}
