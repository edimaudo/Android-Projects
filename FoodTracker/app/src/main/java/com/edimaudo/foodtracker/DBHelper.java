package com.edimaudo.foodtracker;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by edima on 2017-03-18.
 */

public class DBHelper extends SQLiteOpenHelper {

  public static final String DB_NAME = "food.db";
  public static final int DB_VERSION = 1;

  public static final String COMMA_SEP = ",";
  public static final String TEXT_TYPE = " TEXT";
  public static final String NUMERIC_TYPE = " NUMERIC";

  public static final String TABLE_NAME = "food";

  public static final String COLUMN_PATH = "path";
  public static final String COLUMN_FOOD_NAME = "name";
  public static final String COLUMN_RATING_BAR = "rating";
  public static final String PRIMARY_KEY = "PRIMARY KEY (" + COLUMN_PATH + "," + COLUMN_FOOD_NAME + ")";



  private static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
  private static final String CREATE_TABLE =
          COLUMN_PATH + TEXT_TYPE + COMMA_SEP + COLUMN_PATH + TEXT_TYPE + COMMA_SEP +
                  COLUMN_FOOD_NAME + TEXT_TYPE + COMMA_SEP +
                  COLUMN_RATING_BAR + NUMERIC_TYPE + COMMA_SEP +
                  PRIMARY_KEY +
                  " )";


  public DBHelper(Context context) {
    super(context, name, factory, version);
  }

  public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
    super(context, name, factory, version, errorHandler);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CREATE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL(DELETE_TABLE);
    onCreate(sqLiteDatabase);
  }
}
