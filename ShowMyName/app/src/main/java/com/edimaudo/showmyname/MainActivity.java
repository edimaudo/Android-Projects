package com.edimaudo.showmyname;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private String textinfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                textinfo = editText.getText().toString();
                if (textinfo == "" || textinfo == null || textinfo.equals("")){
                    Toast.makeText(MainActivity.this, "No name was entereed", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(textinfo);
                }
            }
        });

    }
}
