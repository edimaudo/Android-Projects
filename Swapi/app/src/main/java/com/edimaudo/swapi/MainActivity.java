package com.edimaudo.swapi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  private ConstraintLayout constraintLayout;
  private Spinner searchSpinner;
  private EditText searchText;
  private Button searchButton;
  private String spinnerItem = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
    searchText = (EditText) findViewById(R.id.searchText);
    searchButton = (Button) findViewById(R.id.searchButton);
    searchSpinner = (Spinner) findViewById(R.id.searchSpinner);
    searchSpinner.setOnItemSelectedListener(this);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.search_array,R.layout.spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
    // Apply the adapter to the spinner
    searchSpinner.setAdapter(adapter);


    searchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (searchText.getText().toString().isEmpty()){
          Toast.makeText(MainActivity.this,
                  getResources().getString(R.string.search_term_empty),
                  Toast.LENGTH_LONG).show();
        } else if (isNetworkAvailable() ){
          Snackbar
                  .make(constraintLayout,
                          getResources().getString(R.string.no_internet_connection)
                          ,Snackbar.LENGTH_SHORT)
                  .show();
        } else {
          Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
          searchIntent.putExtra("searchTerm",searchText.getText().toString());
          searchIntent.putExtra("spinnerTerm",spinnerItem);
          startActivity(searchIntent);
        }
      }
    });
  }


  //chose which of the two is better
  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

  private boolean haveNetworkConnection() {
    boolean haveConnectedWifi = false;
    boolean haveConnectedMobile = false;

    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo[] netInfo = cm.getAllNetworkInfo();
    for (NetworkInfo ni : netInfo) {
      if (ni.getTypeName().equalsIgnoreCase("WIFI"))
        if (ni.isConnected())
          haveConnectedWifi = true;
      if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
        if (ni.isConnected())
          haveConnectedMobile = true;
    }
    return haveConnectedWifi || haveConnectedMobile;
  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    spinnerItem = adapterView.getItemAtPosition(i).toString();
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {
    spinnerItem = adapterView.getItemAtPosition(1).toString();
  }
}
