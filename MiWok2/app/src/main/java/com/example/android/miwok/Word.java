package com.example.android.miwok;


public class Word {


  private String mMiwokTranslation;
  private String mDefaultTranslation;
  private int mAudioResourceID;
  private static final int NO_IMAGE_PROVIDED = -1;
  private int mImageResourceID = NO_IMAGE_PROVIDED;



  public Word(String mMiwokTranslation, String mDefaultTranslation, int mAudioResourceID) {
    this.mMiwokTranslation = mMiwokTranslation;
    this.mDefaultTranslation = mDefaultTranslation;
    this.mAudioResourceID = mAudioResourceID;
  }

  public boolean hasImage(){
    return mImageResourceID != NO_IMAGE_PROVIDED;
  }

  public int getmAudioResourceID() {
    return mAudioResourceID;
  }

  public Word(String mMiwokTranslation, String mdefaultTranslation, int mImageResourceID, int mAudioResourceID){
    this.mMiwokTranslation = mMiwokTranslation;
    this.mDefaultTranslation = mdefaultTranslation;
    this.mImageResourceID = mImageResourceID;
    this.mAudioResourceID = mAudioResourceID;

  }

  public String getMdefaultTranslation() {
    return mDefaultTranslation;
  }

  public int getmImageResourceID() {
    return mImageResourceID;
  }

  public String getmMiwokTranslation() {
    return mMiwokTranslation;
  }


}
