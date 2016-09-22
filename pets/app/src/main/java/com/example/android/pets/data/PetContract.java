package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
/**
 * Created by edima on 2016-09-13.
 */
public class PetContract {

  public static final String CONTENT_AUTHORITY = "com.example.android.pets";

  public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

  public static final String PATH_PETS = "pets";



  private PetContract(){}

  public static final class PetEntry implements BaseColumns{
    public static final String CONTENT_LIST_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

    /**
     * The MIME type of the {@link #CONTENT_URI} for a single pet.
     */
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;
    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);
    public final static String TABLE_NAME = "pets";
    public final static String _ID = BaseColumns._ID;
    public final static String COLUMN_PET_NAME = "name";
    public final static String COLUMN_PET_BREED = "breed";
    public final static String COLUMN_PET_GENDER = "gender";
    public final static String COLUMN_PET_WEIGHT = "weight";

    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;

    public static boolean isValidGender(int gender) {
      if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
        return true;
      }
      return false;
    }
  }




}
