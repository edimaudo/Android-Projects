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
public class ColorsFragment extends Fragment {
  ArrayList<Word> colors = new ArrayList<Word>();
  MediaPlayer mediaPlayer;
  AudioManager audioManager;
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

  public ColorsFragment() {
    // Required empty public constructor
  }


  @Override
  public void onStop() {
    super.onStop();
    releaseMediaPlayer();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.word_list, container, false);

    audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

    colors.add(new Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red));
    colors.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
    colors.add(new Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
    colors.add(new Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray));
    colors.add(new Word("kululli","black",R.drawable.color_black,R.raw.color_black));
    colors.add(new Word("kelelli","white",R.drawable.color_white,R.raw.color_white));
    colors.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
    colors.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

    WordAdapter itemAdapter = new WordAdapter(getActivity(),colors,R.color.category_colors);
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

          Word word = colors.get(i);
          mediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceID());
          mediaPlayer.start();
          mediaPlayer.setOnCompletionListener(mCompletionListener);
        }
      }


    });
    return rootView;
  }

}
