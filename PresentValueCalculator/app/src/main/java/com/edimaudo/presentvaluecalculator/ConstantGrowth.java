package com.edimaudo.presentvaluecalculator;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConstantGrowth extends Fragment implements View.OnClickListener {
  //constant growth
  private TextInputLayout input_constant_growth_rate,input_constant_growth_interest,
          input_constant_growth_num_years, input_constant_growth_revenue;
  private EditText constant_growth_revenue,constant_growth_interest,constant_growth_rate,
          constant_growth_num_years;
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
    View view =  inflater.inflate(R.layout.fragment_constant_growth, container, false);
    constant_growth_submit = (Button) view.findViewById(R.id.constant_growth_submit);

    constant_growth_interest = (EditText) view.findViewById(R.id.constant_growth_interest);
    constant_growth_num_years = (EditText) view.findViewById(R.id.constant_growth_num_years);
    constant_growth_revenue = (EditText) view.findViewById(R.id.constant_growth_revenue);
    constant_growth_rate = (EditText) view.findViewById(R.id.constant_growth_growth_rate);

    input_constant_growth_interest = (TextInputLayout) view.findViewById(R.id.input_constant_growth_interest);
    input_constant_growth_num_years = (TextInputLayout) view.findViewById(R.id.input_constant_growth_num_years);
    input_constant_growth_revenue = (TextInputLayout) view.findViewById(R.id.input_constant_growth_revenue);
    input_constant_growth_rate = (TextInputLayout) view.findViewById(R.id.input_constant_growth_growth_rate);

    constant_growth_interest.addTextChangedListener(new MyTextWatcher(constant_growth_interest));
    constant_growth_num_years.addTextChangedListener(new MyTextWatcher(constant_growth_num_years));
    constant_growth_revenue.addTextChangedListener(new MyTextWatcher(constant_growth_revenue));
    constant_growth_rate.addTextChangedListener(new MyTextWatcher(constant_growth_rate));

    constant_growth_submit.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.constant_growth_submit:
        submitData();
    }
  }

  private void submitData() {
    if (!validateInput()) {
      return;
    }

    Double interest = Double.parseDouble(constant_growth_interest.getText().toString());
    Double years = Double.parseDouble(constant_growth_num_years.getText().toString());
    Double revenue = Double.parseDouble(constant_growth_revenue.getText().toString());
    Double rate = Double.parseDouble(constant_growth_rate.getText().toString());
    Double output = 0.00;

    if (rate!=0 && interest!=0){
      output = (revenue - revenue*(Math.pow((1+rate)/(1+interest),years)))/(interest + rate);
    }
    Snackbar
            .make(getView(),String.format("%.2f",output),Snackbar.LENGTH_LONG)
            .show();
  }

  private boolean validateInput(){
    if (constant_growth_interest.getText().toString().trim().isEmpty()) {
      input_constant_growth_interest.setError(getString(R.string.err_msg_interest));
      constant_growth_interest.requestFocus();
      return false;
    } else {
      input_constant_growth_interest.setErrorEnabled(false);
    }

    if (constant_growth_num_years.getText().toString().trim().isEmpty()) {
      input_constant_growth_num_years.setError(getString(R.string.err_msg_num_years));
      constant_growth_num_years.requestFocus();
      return false;
    } else {
      input_constant_growth_num_years.setErrorEnabled(false);
    }

    if (constant_growth_revenue.getText().toString().trim().isEmpty()) {
      input_constant_growth_revenue.setError(getString(R.string.err_msg_revenue));
      constant_growth_revenue.requestFocus();
      return false;
    } else {
      input_constant_growth_revenue.setErrorEnabled(false);
    }

    if (constant_growth_rate.getText().toString().trim().isEmpty()) {
      input_constant_growth_rate.setError(getString(R.string.err_msg_growth_rate));
      constant_growth_rate.requestFocus();
      return false;
    } else {
      input_constant_growth_rate.setErrorEnabled(false);
    }


    constant_growth_interest.clearFocus();
    constant_growth_num_years.clearFocus();
    constant_growth_revenue.clearFocus();
    return true;
  }

  private class MyTextWatcher implements TextWatcher {

    private View view;

    private MyTextWatcher(View view) {
      this.view = view;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    public void afterTextChanged(Editable editable) {
      validateInput();
    }
  }
}
