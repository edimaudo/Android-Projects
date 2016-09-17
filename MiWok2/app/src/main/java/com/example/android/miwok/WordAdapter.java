package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
  private int mColorResourceId;
  public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
    super(context, 0, words);
    mColorResourceId = colorResourceId;
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if(listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    Word currentWord = getItem(position);

    TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokWord);
    miwokTextView.setText(currentWord.getmMiwokTranslation());

    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultWord);
    defaultTextView.setText(currentWord.getMdefaultTranslation());

    ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
    if(currentWord.hasImage()){
      iconView.setImageResource(currentWord.getmImageResourceID());
      iconView.setVisibility(View.VISIBLE);
    } else {
      iconView.setVisibility(View.GONE);
    }

    LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.textContainer);
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    textContainer.setBackgroundColor(color);


    return listItemView;

  }
}
