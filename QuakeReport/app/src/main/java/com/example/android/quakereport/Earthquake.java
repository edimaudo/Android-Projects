package com.example.android.quakereport;


public class Earthquake {
  private String mUrl;
  private String mlocation;
  private Double mMagnitude;
  private long mTimeInMilliseconds;;

  public Earthquake(Double mMagnitude,String mlocation,long mTimeInMilliseconds, String mUrl) {
    this.mlocation = mlocation;
    this.mMagnitude = mMagnitude;
    this.mTimeInMilliseconds = mTimeInMilliseconds;
    this.mUrl = mUrl;
  }

  public String getMlocation() {
    return mlocation;
  }

  public long getmTimeInMilliseconds() {
    return mTimeInMilliseconds;
  }

  public String getmUrl() {
    return mUrl;
  }

  public Double getmMagnitude() {
    return mMagnitude;
  }
}
