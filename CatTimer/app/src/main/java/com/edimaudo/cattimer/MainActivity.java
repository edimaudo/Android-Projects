package com.edimaudo.cattimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //create id variables
    SeekBar timerSeekBar;
    TextView timerTextView;
    Button controllerButton;
    boolean counterIsActive = false;
    CountDownTimer countDownTimer;


    public void resetTimer(){
        timerTextView.setText("00:30");
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controllerButton.setText("Go");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;
    }

    public void updateTimer (int secondsLeft){
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String MinuteString = Integer.toString(minutes);
        String SecondString = Integer.toString(seconds);

        if (minutes < 10){
            MinuteString = "0" + MinuteString;
        }

        if (seconds < 10){
            SecondString = "0" + SecondString;;
        }

        timerTextView.setText(MinuteString + ":" + SecondString);

    }
    //method for our Go Button
    public void controlTimer (View view){

        if (!counterIsActive){
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("Stop");
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    //timerTextView.setText("00:00");
                    resetTimer();
                    MediaPlayer mplayer =
                            MediaPlayer.create(getApplicationContext(), R.raw.catmeow);//using this wont work here
                    mplayer.start();

                }
            }.start();
        } else {
            resetTimer();
        }


    }

    //data is stored here because we want to keep a consistent state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);//get seekbar id
        timerTextView = (TextView) findViewById(R.id.timerTextView); //get textview id
        controllerButton = (Button) findViewById(R.id.controllerButton);
        timerSeekBar.setMax(600); //10 mins
        timerSeekBar.setProgress(30); //30secs
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
