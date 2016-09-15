package com.example.android.quakereport;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {


  public WordAdapter(Context context, ArrayList<Word> words) {
    super(context, 0, words);

  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if(listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    Word currentWord = getItem(position);

    TextView magnitudeText = (TextView) listItemView.findViewById(R.id.magnitudeText);
    magnitudeText.setText(currentWord.getmMagnitude());

    TextView locationView = (TextView) listItemView.findViewById(R.id.locationText);
    locationView.setText(currentWord.getMlocation());

    TextView dateView = (TextView) listItemView.findViewById(R.id.dateText);
    dateView.setText(currentWord.getmDate());

    return listItemView;
    //return super.getView(position, convertView, parent);
  }
}
