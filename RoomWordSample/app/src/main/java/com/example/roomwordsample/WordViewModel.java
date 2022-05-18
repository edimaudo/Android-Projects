package com.example.roomwordsample;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
public class WordViewModel extends AndroidViewModel {

  private WordRepository mRepository;

  private final LiveData<List<Word>> mAllWords;

  public WordViewModel (Application application) {
    super(application);
    mRepository = new WordRepository(application);
    mAllWords = mRepository.getAllWords();
  }

  LiveData<List<Word>> getAllWords() { return mAllWords; }

  public void insert(Word word) { mRepository.insert(word); }
}
