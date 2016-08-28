package com.edimaudo.text2speech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

  private ImageView speechButton;
  private TextToSpeech tts;
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
    tts = new TextToSpeech(this, this);

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
    if (status == TextToSpeech.SUCCESS) {
      tts.setLanguage(Locale.CANADA);
    }
  }

  @Override
  public void onDestroy() {
    // Don't forget to shutdown tts!
    if (tts != null) {
      tts.stop();
      tts.shutdown();
    }
    super.onDestroy();
  }

  private void speech() {
    tts.setPitch((float) pitch);
    tts.setSpeechRate((float) speed);
    if (editText.getText().toString().isEmpty()){
      Toast.makeText(MainActivity.this, "Please enter some text", Toast.LENGTH_SHORT).show();
    } else {
      tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
    }

  }
}
