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
public class Basic extends Fragment implements View.OnClickListener {
  private TextInputLayout input_basic_interest,input_basic_years,input_basic_revenue;
  private EditText basic_interest,basic_years,basic_revenue;
  private Button basic_submit;


  public Basic() {
    // Required empty public constructor
  }

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_basic, container, false);
    basic_submit = (Button) view.findViewById(R.id.basic_submit);
    basic_interest = (EditText) view.findViewById(R.id.basic_interest);
    basic_years = (EditText) view.findViewById(R.id.basic_years);
    basic_revenue = (EditText) view.findViewById(R.id.basic_revenue);

    input_basic_interest = (TextInputLayout) view.findViewById(R.id.input_basic_interest);
    input_basic_years = (TextInputLayout) view.findViewById(R.id.input_basic_years);
    input_basic_revenue = (TextInputLayout) view.findViewById(R.id.input_basic_revenue);

    basic_interest.addTextChangedListener(new MyTextWatcher(basic_interest));
    basic_years.addTextChangedListener(new MyTextWatcher(basic_years));
    basic_revenue.addTextChangedListener(new MyTextWatcher(basic_revenue));

    basic_submit.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.basic_submit:
        submitData();
    }
  }

  private void submitData() {
    if (!validateInput()) {
      return;
    }

    Double interest = Double.parseDouble(basic_interest.getText().toString());
    Double years = Double.parseDouble(basic_years.getText().toString());
    Double revenue = Double.parseDouble(basic_revenue.getText().toString());

    Snackbar
            .make(getView(),String.format("%.2f",revenue / Math.pow((1+interest),years)),Snackbar.LENGTH_LONG)
            .show();
  }

  private boolean validateInput(){
    if (basic_interest.getText().toString().trim().isEmpty()) {
      input_basic_interest.setError(getString(R.string.err_msg_interest));
      basic_interest.requestFocus();
      return false;
    } else {
      input_basic_interest.setErrorEnabled(false);
    }

    if (basic_years.getText().toString().trim().isEmpty()) {
      input_basic_years.setError(getString(R.string.err_msg_yearly_revenue));
      basic_years.requestFocus();
      return false;
    } else {
      input_basic_years.setErrorEnabled(false);
    }

    if (basic_revenue.getText().toString().trim().isEmpty()) {
      input_basic_revenue.setError(getString(R.string.err_msg_revenue));
      basic_revenue.requestFocus();
      return false;
    } else {
      input_basic_revenue.setErrorEnabled(false);
    }


    basic_interest.clearFocus();
    basic_years.clearFocus();
    basic_revenue.clearFocus();
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
