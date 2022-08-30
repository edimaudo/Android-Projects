package com.example.focusedfm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.view.View;
import java.util.*;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

  Switch themeSwitch;
  Button channelButton, trackButton;
  String[] channels = {"electronic", "downtempo", "rain"}; //removed classical
  AlertDialog.Builder builder, track;
  String selectedChannel = "";
  String defaultChannel = "downtempo";
  String currentTrack = "";
  ImageView playPauseImageView, previousImageView, nextImageView;
  int playState = 0;
  MediaPlayer mp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
      setTheme(R.style.Theme_FocusedFM_Dark);
    } else {
      setTheme(R.style.Theme_FocusedFM_Light);
    }
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Set to portrait view only
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    Switch themeSwitch = (Switch) findViewById(R.id.themeSwitch);
    Button channelButton = (Button) findViewById(R.id.channelButton);
    Button trackButton = (Button) findViewById(R.id.trackButton);
    ImageView playPauseImageView = (ImageView) findViewById(R.id.playPauseImageView);
    ImageView nextImageView = (ImageView) findViewById(R.id.nextImageView);
    ImageView previousImageView = (ImageView) findViewById(R.id.previousImageView);
    builder = new AlertDialog.Builder(this);
    track = new AlertDialog.Builder(this);

    // set up music player
    getSong();
    mp = MediaPlayer.create(this, R.raw.downtempo_1);

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
        track.setMessage(getSong());
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

  // generate song information
  public String getSong(){
    Random ran = new Random();
    if (selectedChannel == "downtempo"){
      int number = ran.nextInt(7) +1;
      currentTrack = "downtempo_" + String.valueOf(number);
    } else if (selectedChannel == "electronic"){
      int number = ran.nextInt(4) +1;
      currentTrack =   "electronic_" + String.valueOf(number);
    } else {
      int number = ran.nextInt(4) +1;
      currentTrack =   "rain_" + String.valueOf(number);
    }
    return "track:" + currentTrack;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (mp != null) mp.release();
  }

}