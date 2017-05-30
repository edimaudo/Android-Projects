package com.edimaudo.movienight.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edimaudo.movienight.R;

public class MainActivity extends AppCompatActivity {

  private Button recommendButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recommendButton = (Button) findViewById(R.id.moviebutton);

    recommendButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (! isNetworkAvailable()){
          Snackbar
                  .make(view,
                          getResources().getString(R.string.no_internet_connection)
                          ,Snackbar.LENGTH_SHORT)
                  .show();
        } else {
          Intent recommendIntent = new Intent(MainActivity.this,MovieActivity.class);
          startActivity(recommendIntent);
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
}
