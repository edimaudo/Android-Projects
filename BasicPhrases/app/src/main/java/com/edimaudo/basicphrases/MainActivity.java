package com.edimaudo.basicphrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view){

        int ID = view.getId();//gets internal ID of button tapped
        String ourID = "";

        ourID = view.getResources().getResourceEntryName(ID);

        int resourceID = getResources().getIdentifier(ourID,"raw","com.edimaudo.basicphrases");//maps ID to mp3
        MediaPlayer mplayer = MediaPlayer.create(this,resourceID);
        mplayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
