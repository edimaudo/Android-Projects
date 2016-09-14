package com.example.android.miwok;


public class Word {

  private String mMiwokTranslation;
  private String mdefaultTranslation;

  public Word(String mMiwokTranslation, String mdefaultTranslation) {
    this.mMiwokTranslation = mMiwokTranslation;
    this.mdefaultTranslation = mdefaultTranslation;
  }

  public String getMdefaultTranslation() {
    return mdefaultTranslation;
  }

  public String getmMiwokTranslation() {
    return mMiwokTranslation;
  }



}
