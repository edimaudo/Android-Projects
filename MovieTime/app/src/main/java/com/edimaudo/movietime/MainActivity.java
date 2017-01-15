package com.edimaudo.movietime;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button recommend;
  private CoordinatorLayout coordinatorLayout;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recommend = (Button) findViewById(R.id.recommend);
    recommend.setOnClickListener(this);
    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.recommend:
        if (isNetworkAvailable()){
          Intent rec_intent = new Intent(MainActivity.this, recommend.class);
          startActivity(rec_intent);
          break;
        } else {
          Snackbar
                  .make(coordinatorLayout, "No network connection!",Snackbar.LENGTH_LONG)
                  .show();
        }

    }
  }

  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

}
