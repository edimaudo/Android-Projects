package com.edimaudo.presentvaluecalculator;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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
    basic_submit.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.basic_submit:

    }
  }

  private void submitForm() {
    if (!validateInput()) {
      return;
    }

    Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();
  }

  private boolean validInput(){
    if (inputName.getText().toString().trim().isEmpty()) {
      inputLayoutName.setError(getString(R.string.err_msg_name));
      requestFocus(inputName);
      return false;
    } else {
      inputLayoutName.setErrorEnabled(false);
    }
  }


}
