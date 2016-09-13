package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by edima on 2016-09-13.
 */
public class PetContract {

  private PetContract(){}

  public static final class PetEntry implements BaseColumns{

    public final static String TABLE_NAME = "pets";
    public final static String _ID = BaseColumns._ID;
    public final static String COLUMN_PET_NAME = "name";
    public final static String COLUMN_PET_BREED = "breed";
    public final static String COLUMN_PET_GENDER = "gender";
    public final static String COLUMN_PET_WEIGHT = "weight";

    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;
  }


}
