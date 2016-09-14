package com.example.android.miwok;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by edima on 2016-09-13.
 */
public class WordAdapter extends ArrayAdapter<Word> {
  public WordAdapter(Context context, int resource, int textViewResourceId) {
    super(context, resource, textViewResourceId);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return super.getView(position, convertView, parent);
  }
}
