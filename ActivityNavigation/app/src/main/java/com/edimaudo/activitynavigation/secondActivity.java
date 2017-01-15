package com.edimaudo.activitynavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);
        Bundle extra = getIntent().getExtras();
        textView.setText("");
        if (extra != null){
            String myString = extra.getString("activityOne");
            textView.setText(myString);
        }

    }
}
