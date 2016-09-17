package com.example.android.pets.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDBHelper extends SQLiteOpenHelper{
  private static final String TEXT_TYPE = " TEXT";
  private static final String TEXT_TYPE2 = " TEX NOT NULLT";
  private static final String INTEGER_TYPE = " INTEGER";
  private static final String INTEGER_TYPE2 = " INTEGER NOT NULL";
  private static final String COMMA_SEP = ",";
  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "Pet.db";

  private static final String SQL_CREATE_ENTRIES =
          "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                  PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                  PetEntry.COLUMN_PET_NAME + TEXT_TYPE2 + COMMA_SEP +
                  PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
                  PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE2 + COMMA_SEP +
                  PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0" + " )";

  private static final String SQL_DELETE_ENTRIES =
          "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;


  public PetDBHelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    onCreate(sqLiteDatabase);
  }

  /**
   * Created by edima on 2016-09-17.
   */
  public static class PetProvider {
  }
}


