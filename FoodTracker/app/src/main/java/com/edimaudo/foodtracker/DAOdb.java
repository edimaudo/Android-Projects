package com.edimaudo.foodtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edima on 2017-03-18.
 */

public class DAOdb {
  private SQLiteDatabase database;
  private DBHelper dbHelper;

  public DAOdb(Context context) {
    dbHelper = new DBHelper(context);
    database = dbHelper.getWritableDatabase();
  }

  /**
   * close any database object
   */
  public void close() {
    dbHelper.close();
  }

  /**
   * insert a text report item to the location database table
   *
   * @param image
   * @return the row ID of the newly inserted row, or -1 if an error occurred
   */
  public long addImage(Image image) {
    ContentValues cv = new ContentValues();
    cv.put(DBHelper.COLUMN_PATH, image.getImagePath());
    cv.put(DBHelper.COLUMN_FOOD_NAME, image.getFoodName());
    cv.put(DBHelper.COLUMN_RATING_BAR, image.getFoodRating());
    return database.insert(DBHelper.TABLE_NAME, null, cv);
  }

  /**
   * delete the given image from database
   *
   * @param image
   */
  public void deleteImage(Image image) {
    String whereClause =
            DBHelper.COLUMN_PATH + "=? AND " + DBHelper.COLUMN_FOOD_NAME +
                    "=?";
    String[] whereArgs = new String[]{image.getImagePath(),
            String.valueOf(image.getFoodName())};

    database.delete(DBHelper.TABLE_NAME, whereClause, whereArgs);
  }

  /**
   * @return all image as a List
   */
  public List<Image> getImages() {
    List<Image> MyImages = new ArrayList<>();
    Cursor cursor =
            database.query(DBHelper.TABLE_NAME, null, null, null, null,
                    null, DBHelper.COLUMN_PATH + " DESC");
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Image MyImage = cursorToMyImage(cursor);
      MyImages.add(MyImage);
      cursor.moveToNext();
    }
    cursor.close();
    return MyImages;
  }

  /**
   * read the cursor row and convert the row to a MyImage object
   *
   * @param cursor
   * @return MyImage object
   */
  private Image cursorToMyImage(Cursor cursor) {
    Image image = new Image();
    image.setImagePath(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PATH)));
    image.setFoodName(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FOOD_NAME)));
    image.setFoodRating(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RATING_BAR)));
    return image;
  }

}
