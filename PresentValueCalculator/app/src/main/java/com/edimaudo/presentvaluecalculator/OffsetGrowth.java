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
public class OffsetGrowth extends Fragment {
  //offset growth
  private TextInputLayout input_offset_growth_interest, input_offset_growth_growth_rate,
          input_offset_growth_revenue, input_offset_growth_tot_years,
          input_offset_growth_years_no_revenue;
  private EditText offset_growth_interest, offset_growth_growth_rate, offset_growth_revenue,
          offset_growth_tot_years, offset_growth_years_no_revenue;
  private Button offset_growth_submit;

  public OffsetGrowth() {
    // Required empty public constructor
  }

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_offset_growth, container, false);
  }

}
