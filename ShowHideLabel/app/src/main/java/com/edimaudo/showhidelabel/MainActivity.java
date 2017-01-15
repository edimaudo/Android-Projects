package com.edimaudo.showhidelabel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView labelText;

    public void buttonTapped(View view){
        Button showButton = (Button) findViewById(R.id.showButton);
        Button hideButton = (Button) findViewById(R.id.hideButton);

        String IdAsString = view.getResources().getResourceName(view.getId());
        //Toast.makeText(MainActivity.this, IdAsString, Toast.LENGTH_SHORT).show();
        String info = "com.edimaudo.showhidelabel:id/";
        String hide = "hideButton";
        String show = "showButton";

        if (IdAsString.equals(info + hide)){
            labelText.setVisibility(View.INVISIBLE);
        } else {
            labelText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelText = (TextView) findViewById(R.id.showHideText);
    }
}
