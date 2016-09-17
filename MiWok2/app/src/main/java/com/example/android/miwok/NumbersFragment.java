package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

  ArrayList<Word> words = new ArrayList<Word>();
  MediaPlayer mediaPlayer;
  AudioManager audioManager;

  public NumbersFragment() {
    // Required empty public constructor
  }

  AudioManager.OnAudioFocusChangeListener afChangeListener =
          new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {
              if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                      || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Pause playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
              } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback
                mediaPlayer.start();
              } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Stop playback
                releaseMediaPlayer();
              }
            }
          };

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
      audioManager.abandonAudioFocus(afChangeListener);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.word_list, container, false);
    audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

    WordAdapter itemAdapter = new WordAdapter(getActivity(),words, R.color.category_numbers);
    ListView list = (ListView) rootView.findViewById(R.id.listView);
    list.setAdapter(itemAdapter);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        releaseMediaPlayer();
        int result = audioManager.requestAudioFocus(afChangeListener,
                AudioManager.STREAM_MUSIC,
                //using transient since our audio files are short
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
          //audioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);

          Word word = words.get(i);
          mediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceID());
          mediaPlayer.start();
          mediaPlayer.setOnCompletionListener(mCompletionListener);
        }
      }
    });

    return rootView;

  }

  @Override
  public void onStop() {
    super.onStop();
    releaseMediaPlayer();
  }
}
