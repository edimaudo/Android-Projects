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
public class PhrasesFragment extends Fragment {
  ArrayList<Word> phrases = new ArrayList<Word>();
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

  public PhrasesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.word_list, container, false);

    audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

    phrases.add(new Word("minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
    phrases.add(new Word("tinnә oyaase'nә","What is your name?",R.raw.phrase_what_is_your_name));
    phrases.add(new Word("oyaaset...","My name is...",R.raw.phrase_my_name_is));
    phrases.add(new Word("michәksәs?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
    phrases.add(new Word("kuchi achit","I’m feeling good.",R.raw.phrase_im_feeling_good));
    phrases.add(new Word("әәnәs'aa?","Are you coming?",R.raw.phrase_are_you_coming));
    phrases.add(new Word("hәә’ әәnәm","Yes, I’m coming.",R.raw.phrase_yes_im_coming));
    phrases.add(new Word("әәnәm","I’m coming.",R.raw.phrase_im_coming));
    phrases.add(new Word("yoowutis","Let’s go.",R.raw.phrase_lets_go));
    phrases.add(new Word("әnni'nem","Come here.",R.raw.phrase_come_here));

    WordAdapter itemAdapter = new WordAdapter(getActivity(),phrases,R.color.category_phrases);
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

          Word word = phrases.get(i);
          mediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceID());
          mediaPlayer.start();
          mediaPlayer.setOnCompletionListener(mCompletionListener);
        }
      }


    });
    return rootView;
  }

}
