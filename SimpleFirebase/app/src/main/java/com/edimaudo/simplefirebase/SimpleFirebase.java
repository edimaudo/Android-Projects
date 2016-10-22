package com.edimaudo.simplefirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by edima on 2016-10-22.
 */

public class SimpleFirebase extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Firebase.setAndroidContext(this);
  }
}
