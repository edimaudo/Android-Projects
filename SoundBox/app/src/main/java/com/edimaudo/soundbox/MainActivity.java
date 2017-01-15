package com.edimaudo.soundbox;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button playButton;
    private Button nextButton;
    private Button prevButton;
    private MediaPlayer mplayer;
    private TextView text;

    public void playMusic(){
        if (mplayer != null){
            mplayer.start();
            text.setText("Music Playing now...");
            //playButton.setBackground(getResources().(android.R.drawable.ic_media_pause));
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic(){
        if(mplayer != null){
            mplayer.pause();
            text.setText("Paused");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));

        }
    }

    public void nextMusic(){
        if (mplayer != null){
            mplayer.start();
        }
    }

    public void prevMusic(){
        if (mplayer != null){
            mplayer.reset();
        }
    }

    @Override
    protected void onDestroy() {
        if (mplayer != null && mplayer.isPlaying()){
            mplayer.stop();
            mplayer.release();
            mplayer = null;
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplayer = new MediaPlayer();
        mplayer = MediaPlayer.create(getApplicationContext(),R.raw.Ambiance_SoundBible_com_1535680949);
        text = (TextView) findViewById(R.id.artistName);
        playButton = (Button) findViewById(R.id.playButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.playButton:
                //do something
                if(mplayer.isPlaying()){
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
            case R.id.prevButton:
                //do something
                nextMusic();
                break;
            case R.id.nextButton:
                //do something
                prevMusic();
                break;
        }
    }
}
