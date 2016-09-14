package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

  ArrayList<Word> words = new ArrayList<Word>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_numbers);

    words.add(new Word("one","lutti"));
    words.add(new Word("two","otiiko"));
    words.add(new Word("three","tolookosu"));
    words.add(new Word("four","oyyisa"));
    words.add(new Word("five","massokka"));
    words.add(new Word("six","temmokka"));
    words.add(new Word("seven","kenekaku"));
    words.add(new Word("eight","kawinta"));
    words.add(new Word("nine","wo’e"));
    words.add(new Word("ten","na’aacha"));



    ArrayAdapter<Word> itemAdapter =
            new ArrayAdapter<Word>(this,R.layout.list_item,words);
    ListView list = (ListView) findViewById(R.id.listView);
    list.setAdapter(itemAdapter);

  }
}
