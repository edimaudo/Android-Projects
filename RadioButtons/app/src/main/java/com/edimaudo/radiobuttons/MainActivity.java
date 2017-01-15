package com.edimaudo.radiobuttons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button resultButton;
    private TextView outputText;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultButton = (Button) findViewById(R.id.resultButton);
        outputText = (TextView) findViewById(R.id.output);
        radioGroup = (RadioGroup) findViewById(R.id.radiGroupId);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();//get radiobutton id
                radioButton = (RadioButton) findViewById(selectedOption);

                outputText.setText(radioButton.getText());
            }
        });

    }
}
