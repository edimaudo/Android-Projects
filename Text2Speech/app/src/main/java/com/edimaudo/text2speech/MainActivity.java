package com.edimaudo.text2speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

  private ImageView speechButton;
  private TextToSpeech engine;
  private EditText editText;
  private SeekBar seekPitch, seekSpeed;
  private double pitch=1.0;
  private double speed=1.0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    speechButton = (ImageView) findViewById(R.id.speechImg);
    editText = (EditText) findViewById(R.id.sentence);
    engine = new TextToSpeech(this, this);

    speechButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        speech();
      }
    });
    seekPitch = (SeekBar) findViewById(R.id.seekPitch);
    seekPitch.setThumbOffset(5);
    seekPitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        pitch = (float) progress / (seekBar.getMax() / 2);
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    seekSpeed = (SeekBar) findViewById(R.id.seekSpeed);
    seekSpeed.setThumbOffset(5);
    seekSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        speed = (float) progress / (seekBar.getMax() / 2);
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

  }

  @Override
  public void onInit(int status) {
    Log.d("Speech", "OnInit - Status ["+status+"]");

    if (status == TextToSpeech.SUCCESS) {
      Log.d("Speech", "Success!");
      engine.setLanguage(Locale.UK);
    }
  }

  private void speech() {
    engine.setPitch((float) pitch);
    engine.setSpeechRate((float) speed);
    engine.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
  }
}
