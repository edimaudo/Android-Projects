package com.edimaudo.presentvaluecalculator;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstantGrowth extends Fragment {
  //constant growth
  private TextInputLayout input_constant_growth_growth_rate,input_constant_growth_interest,
          input_constant_growth_num_years;
  private EditText constant_growth_revenue,constant_growth_interest,constant_growth_growth_rate, constant_growth_num_years;
  private Button constant_growth_submit;

  public ConstantGrowth() {
    // Required empty public constructor
  }

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_constant_growth, container, false);
  }

}
