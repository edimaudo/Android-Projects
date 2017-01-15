package com.edimaudo.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();//provides the ability to delay events
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //code to run
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);



        }

    }

}
