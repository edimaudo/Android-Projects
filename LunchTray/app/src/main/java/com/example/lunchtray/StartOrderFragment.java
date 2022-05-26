package com.example.lunchtray;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;


public class StartOrderFragment extends Fragment {

  private Button OrderButton;
  private Intent OrderIntent;


  public StartOrderFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }



  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_start_order, container, false);
    OrderButton = (Button)v.findViewById(R.id.start_order_btn);
    OrderButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        //fr.replace(R.id.,new NotificationFragment());
        //fr.commit();

//        Fragment fragment = new yourfragment();
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id., fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
      }
    });
    // Inflate the layout for this fragment
    //return inflater.inflate(R.layout.fragment_start_order, container, false);
  return v;
  }




}