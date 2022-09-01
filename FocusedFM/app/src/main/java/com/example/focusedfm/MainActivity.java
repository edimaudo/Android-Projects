package com.example.focusedfm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.media.MediaPlayer;
import java.util.Random;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

  Switch themeSwitch;
  Button channelButton, trackButton;
  String[] channels = {"electronic", "downtempo", "rain"};
  AlertDialog.Builder builder, track;
  String selectedChannel = "downtempo";
  String currentTrack = "";
  int rawTrack,number;
  ImageView playPauseImageView, previousImageView, nextImageView;
  int playState = 0;
  MediaPlayer mp;
  int [] downtempo_tracks = {R.raw.downtempo_1,R.raw.downtempo_2,R.raw.downtempo_3,
          R.raw.downtempo_4,R.raw.downtempo_5,R.raw.downtempo_6,R.raw.downtempo_7};
  int [] rain_tracks = {R.raw.rain_1,R.raw.rain_2,R.raw.rain_3,R.raw.rain_4};
  int [] electronic_tracks = {R.raw.electronic_1,R.raw.electronic_2,R.raw.electronic_3,
          R.raw.electronic_4};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
      setTheme(R.style.Theme_FocusedFM_Dark);
    } else {
      setTheme(R.style.Theme_FocusedFM_Light);
    }
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// Set to portrait view only

    themeSwitch = (Switch) findViewById(R.id.themeSwitch);
    channelButton = (Button) findViewById(R.id.channelButton);
    trackButton = (Button) findViewById(R.id.trackButton);
    playPauseImageView = (ImageView) findViewById(R.id.playPauseImageView);
    nextImageView = (ImageView) findViewById(R.id.nextImageView);
    previousImageView = (ImageView) findViewById(R.id.previousImageView);
    builder = new AlertDialog.Builder(this);
    track = new AlertDialog.Builder(this);

    generateTrack(); // set up music player
    mp = MediaPlayer.create(this, rawTrack);

    themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
      }
    });

  // select channel
  channelButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      builder.setTitle(R.string.choose_channel);
      builder.setItems(channels, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          selectedChannel = channels[i];
        }
      });
      builder.show();
    }
  });

  // Track Information
    trackButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        track.setTitle(R.string.current_track);
        track.setMessage("track: " + currentTrack + ".mp3");
        track.show();
      }
    });

    // Play/Pause
    playPauseImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (playState == 0){
          // change image to pause
          playPauseImageView.setImageResource(R.mipmap.ic_pause_circle_filled);
          mp.start();// play music
          playState = 1;
        } else {
          // change image to play
          playPauseImageView.setImageResource(R.mipmap.ic_play_circle_filled);
          mp.pause();// pause music
          playState = 0;
        }
      }
    });
  }

  // generate track information
  public void generateTrack(){
    Random ran = new Random();
    if (selectedChannel.equals("downtempo")){
      number = ran.nextInt(7) +1;
      currentTrack = "downtempo_" + String.valueOf(number);
      rawTrack = downtempo_tracks[number];
    } else if (selectedChannel.equals("electronic")){
      int number = ran.nextInt(4) +1;
      currentTrack =   "electronic_" + String.valueOf(number);
      rawTrack = electronic_tracks[number];
    } else {
      int number = ran.nextInt(4) +1;
      currentTrack =   "rain_" + String.valueOf(number);
      rawTrack = rain_tracks[number];
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (mp != null) mp.release();
  }

}