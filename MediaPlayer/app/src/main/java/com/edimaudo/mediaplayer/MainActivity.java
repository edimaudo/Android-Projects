package com.edimaudo.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private MediaPlayer mplayer;

    public void pauseMusic(){
        if (mplayer != null){
            mplayer.pause();
            playButton.setText("Play");
        }
    }

    public void startMusic(){
        if (mplayer != null){
            mplayer.start();
            playButton.setText("Pause");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mplayer = new MediaPlayer();//create media player
        mplayer = MediaPlayer.create(getApplicationContext(),R.raw.Steam_Engine_John_1826274710);
        playButton = (Button) findViewById(R.id.playButton);

        mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(getApplicationContext(), "Duration:  " + duration + "s", Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (mplayer.isPlaying()){
                     pauseMusic();
                 } else {
                     startMusic();
                 }
            }
        });

    }

    //ensures good memory management
    @Override
    protected void onDestroy() {

        if (mplayer != null && mplayer.isPlaying()){
            mplayer.stop();
            mplayer.release();
            mplayer = null;
        }
        super.onDestroy();
    }
}
