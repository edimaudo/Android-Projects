package com.raywenderlich.rocketlaunch;

import android.content.Intent;

public class RocketAnimationItem {
  private final String mTitle;
  private final Intent mIntent;

  public RocketAnimationItem(String title, android.content.Intent intent) {
    mTitle = title;
    mIntent = intent;
  }

  public android.content.Intent getIntent() {
    return mIntent;
  }

  public String getTitle() {
    return mTitle;
  }
}
