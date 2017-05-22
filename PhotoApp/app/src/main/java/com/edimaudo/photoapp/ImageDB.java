package com.edimaudo.photoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edima on 2017-05-19.
 */

public class ImageDB {
  private SQLiteDatabase sqLiteDatabase;
  private ImageDBHelper imageDBHelper;

  public ImageDB(Context context) {
    imageDBHelper = new ImageDBHelper(context);
    sqLiteDatabase = imageDBHelper.getWritableDatabase();
  }

  public void close(){
    imageDBHelper.close();
  }

  public long addImage(Image image){
    ContentValues cv = new ContentValues();
    cv.put(ImageDBHelper.COLUMN_PATH, image.getPath());
    cv.put(ImageDBHelper.COLUMN_TITLE, image.getTitle());
    cv.put(ImageDBHelper.COLUMN_DESCRIPTION, image.getDescription());
    cv.put(ImageDBHelper.COLUMN_DATETIME, System.currentTimeMillis());
    return sqLiteDatabase.insert(ImageDBHelper.TABLE_NAME, null, cv);
  }

  public void deleteImage(Image image) {
    String whereClause =
            ImageDBHelper.COLUMN_TITLE + "=? AND " + ImageDBHelper.COLUMN_DATETIME +
                    "=?";
    String[] whereArgs = new String[]{image.getTitle(),
            String.valueOf(image.getDatetimeLong())};
    sqLiteDatabase.delete(ImageDBHelper.TABLE_NAME, whereClause, whereArgs);
  }

  public List<Image> getImages() {
    List<Image> MyImages = new ArrayList<>();
    Cursor cursor =
            sqLiteDatabase.query(ImageDBHelper.TABLE_NAME, null, null, null, null,
                    null, ImageDBHelper.COLUMN_DATETIME + " DESC");
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Image MyImage = cursorToMyImage(cursor);
      MyImages.add(MyImage);
      cursor.moveToNext();
    }
    cursor.close();
    return MyImages;
  }

  private Image cursorToMyImage(Cursor cursor) {
    Image image = new Image();
    image.setPath(cursor.getString(cursor.getColumnIndex(ImageDBHelper.COLUMN_PATH)));
    image.setTitle(cursor.getString(cursor.getColumnIndex(ImageDBHelper.COLUMN_TITLE)));
    image.setDatetime(cursor.getLong(cursor.getColumnIndex(ImageDBHelper.COLUMN_DATETIME)));
    image.setDescription(cursor.getString(cursor.getColumnIndex(ImageDBHelper.COLUMN_DESCRIPTION)));
    return image;
  }

}
