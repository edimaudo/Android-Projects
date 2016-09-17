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
public class FamilyFragment extends Fragment {
  ArrayList<Word> family = new ArrayList<Word>();
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

  @Override
  public void onStop() {
    super.onStop();
    releaseMediaPlayer();
  }

  public FamilyFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.word_list, container, false);

    audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
    family.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
    family.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
    family.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
    family.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
    family.add(new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
    family.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
    family.add(new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
    family.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
    family.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
    family.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

    WordAdapter itemAdapter = new WordAdapter(getActivity(),family,R.color.category_family);
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

          Word word = family.get(i);
          mediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceID());
          mediaPlayer.start();
          mediaPlayer.setOnCompletionListener(mCompletionListener);
        }

      }


    });
    return rootView;
  }

}
