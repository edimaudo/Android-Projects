package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

  ArrayList<Word> words = new ArrayList<Word>();
  MediaPlayer mediaPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);

    words.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
    words.add(new Word("otiiko","two",R.drawable.number_two,R.raw.number_two));
    words.add(new Word("tolookosu","three",R.drawable.number_three,R.raw.number_three));
    words.add(new Word("oyyisa","four",R.drawable.number_four,R.raw.number_four));
    words.add(new Word("massokka","five",R.drawable.number_five,R.raw.number_five));
    words.add(new Word("temmokka","six",R.drawable.number_six,R.raw.number_six));
    words.add(new Word("kenekaku","seven",R.drawable.number_seven,R.raw.number_seven));
    words.add(new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
    words.add(new Word("wo’e","nine",R.drawable.number_nine,R.raw.number_nine));
    words.add(new Word("na’aacha","ten",R.drawable.number_ten,R.raw.number_ten));

    WordAdapter itemAdapter = new WordAdapter(this,words, R.color.category_numbers);
    ListView list = (ListView) findViewById(R.id.listView);
    list.setAdapter(itemAdapter);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        releaseMediaPlayer();
        Word word = words.get(i);
        mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceID());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mCompletionListener);
      }
    });



  }

  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
     releaseMediaPlayer();
    }
  };

  private void releaseMediaPlayer(){
    if(mediaPlayer != null){
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onStop() {
    super.onStop();
    releaseMediaPlayer();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
  }
  
}
