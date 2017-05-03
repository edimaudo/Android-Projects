package com.edimaudo.androidfrag;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListFragment;

/**
 * Created by edima on 2017-05-02.
 */

public class FragmentOne extends ListFragment{

  int colors[] = new int[]{Color.RED, Color.DKGRAY, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.YELLOW};
  String color_name[] = new String[]{"RED", "DKGRAY", "BLUE", "GREEN", "CYAN", "MAGENTA", "YELLOW"};

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Creates and returns the view hierarchy associated with the fragment.
    View view = inflater.inflate(R.layout.fragment_one, container);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, color_name);
    setListAdapter(adapter);
    return view; //make sure to modify this line from super to inflated view
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    FragmentTwo fragment_two = (FragmentTwo)getFragmentManager().findFragmentById(R.id.fragment_two);
    fragment_two.setImageViewBackground(colors[position]);
    super.onListItemClick(l, v, position, id);
  }
}
