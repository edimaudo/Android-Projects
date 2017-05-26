package com.edimaudo.foodtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
/**
 * Created by edima on 2017-05-22.
 */

public class FoodDB extends SQLiteOpenHelper {
  private static String dbName = "FoodDB";
  private static String tableName = "Food";
  private static String idColumn = "id";
  private static String foodNameColumn = "foodName";
  private static String foodRatingColumn = "foodRating";
  private static String foodImageNameColumn = "foodImageName";

  private Context context;

  public FoodDB(Context context) {
    super(context, dbName, null, 1);
  }


  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table " + tableName +
            " (" +
            idColumn + " integer primary key autoincrement, " +
            foodNameColumn + " text, " +
            foodRatingColumn + " integer, " +
            foodImageNameColumn + " text " +
            ")"
    );
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists " + tableName);
    onCreate(sqLiteDatabase);
  }

  public boolean create (Food food){
    try {
      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(foodNameColumn,food.getFoodName());
      contentValues.put(foodRatingColumn,food.getFoodRating());
      contentValues.put(foodImageNameColumn, food.getFoodImageName());
      long rows = sqLiteDatabase.insert(tableName,null,contentValues);
      sqLiteDatabase.close();
      return rows > 0;
    } catch (Exception e){
      return false;
    }
  }

  public boolean delete (int id){
   try {
     SQLiteDatabase sqLiteDatabase = getWritableDatabase();
     int rows = sqLiteDatabase.delete(tableName, idColumn + " = ?",
             new String[]{valueOf(id)});
     sqLiteDatabase.close();
     return rows > 0;
   } catch (Exception e ){
     return false;
   }
  }

  public Food find (int id){
    try {
      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
      Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName
              + " where " + idColumn + " = ?", new String[]{valueOf(id)});

      Food food = null;
      if (cursor.moveToFirst()){
        food = new Food();
        food.setId(cursor.getInt(0));
        food.setFoodName(cursor.getString(1));
        food.setFoodRating(cursor.getInt(2));
        food.setFoodImageName(cursor.getString(3));
      }
      sqLiteDatabase.close();
      return food;

    } catch (Exception e){
      return null;
    }
  }

  public boolean update (Food food){
    try {
      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(foodNameColumn,food.getFoodName());
      contentValues.put(foodRatingColumn, food.getFoodRating());
      contentValues.put(foodImageNameColumn, food.getFoodImageName());
      int rows = sqLiteDatabase.update(tableName, contentValues, idColumn +
              " = ?", new String[] {String.valueOf(food.getId())});
      sqLiteDatabase.close();
      return rows > 0;
    } catch (Exception e){
      return false;
    }
  }

  public List<Food> findAll(){
    try {
      List<Food> foods = new ArrayList<>();
      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
      Cursor cursor = sqLiteDatabase.rawQuery("select * from " + tableName,null);

      if (cursor.moveToFirst()){
        do {
          Food food = new Food();
          food.setId(cursor.getInt(0));
          food.setFoodName(cursor.getString(1));
          food.setFoodRating(cursor.getInt(2));
          food.setFoodImageName(cursor.getString(3));
          foods.add(food);
        } while (cursor.moveToNext());
      }
      sqLiteDatabase.close();
      return foods;
    } catch (Exception e){
      return null;
    }
  }


}

