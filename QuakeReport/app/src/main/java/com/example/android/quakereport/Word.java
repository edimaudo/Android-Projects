package com.example.android.quakereport;


public class Word {

  private String mlocation;
  private String mMagnitude;
  private String mDate;

  public Word(String mMagnitude,String mlocation, String mDate) {
    this.mlocation = mlocation;
    this.mMagnitude = mMagnitude;
    this.mDate = mDate;
  }

  public String getMlocation() {
    return mlocation;
  }

  public String getmDate() {
    return mDate;
  }

  public String getmMagnitude() {
    return mMagnitude;
  }
}
