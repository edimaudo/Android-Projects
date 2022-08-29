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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {


  Switch themeSwitch;
  Button channelButton, trackButton;
  String[] channels = {"electronic", "downtempo", "classic", "rain"};
  AlertDialog.Builder builder, track;
  String selectedChannel = "";
  String defaultChannel = "electronic";
  String currentTrack = "";
  ImageView playPauseImageView, previousImageView, nextImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
      setTheme(R.style.Theme_FocusedFM_Dark);
    } else {
      setTheme(R.style.Theme_FocusedFM_Light);
    }
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //set to portrait view only
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    Switch themeSwitch = (Switch) findViewById(R.id.themeSwitch);
    Button channelButton = (Button) findViewById(R.id.channelButton);
    Button trackButton = (Button) findViewById(R.id.trackButton);
    ImageView playPauseImageView = (ImageView) findViewById(R.id.playPauseImageView);
    ImageView nextImageView = (ImageView) findViewById(R.id.nextImageView);
    ImageView previousImageView = (ImageView) findViewById(R.id.previousImageView);

    builder = new AlertDialog.Builder(this);
    track = new AlertDialog.Builder(this);
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
          //Toast.makeText(MainActivity.this, selectedChannel,Toast.LENGTH_SHORT).show();
        }
      });
      builder.show();
    }
  });

  //track Info
    trackButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        track.setTitle(R.string.current_track);
        track.setMessage("test message");
        track.show();

      }
    });

    // Play/Pause
    
    // next

    // previous



  }
}