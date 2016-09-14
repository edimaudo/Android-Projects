package com.example.android.miwok;

/**
 * Created by edima on 2016-09-13.
 */
public class Word {

  public Word(String defaultTranslation, String miwokTranslation) {
    mDefaultTranslation = defaultTranslation;
    mMiwokTranslation = miwokTranslation;
  }

  public String getDefaultTranslation(){
    return mDefaultTranslation;
  }

  public String getMiwokTranslation(){
    return mMiwokTranslation;
  }

  private String mDefaultTranslation;
  private String mMiwokTranslation;
}
