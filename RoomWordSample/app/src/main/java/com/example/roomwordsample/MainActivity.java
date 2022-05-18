package com.example.roomwordsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

  public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

  private WordViewModel mWordViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    // Get a new or existing ViewModel from the ViewModelProvider.
    mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

    // Add an observer on the LiveData returned by getAlphabetizedWords.
    // The onChanged() method fires when the observed data changes and the activity is
    // in the foreground.
    mWordViewModel.getAllWords().observe(this, words -> {
      // Update the cached copy of the words in the adapter.
      adapter.submitList(words);
    });

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> {
      Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
      startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    });
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
      Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
      mWordViewModel.insert(word);
    } else {
      Toast.makeText(
              getApplicationContext(),
              R.string.empty_not_saved,
              Toast.LENGTH_LONG).show();
    }
  }
}