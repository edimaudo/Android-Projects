package com.edimaudo.foodtracker.Data;

/**
 * Created by edima on 2016-10-24.
 */

public class DatabaseHandler {
}

/*
//pick an image
if (Build.VERSION.SDK_INT <= 19) {
                        Intent i = new Intent();
                        i.setType("image/*");
                        i.setAction(Intent.ACTION_GET_CONTENT);
                        i.addCategory(Intent.CATEGORY_OPENABLE);
                        startActivityForResult(i, 10);
                    } else if (Build.VERSION.SDK_INT > 19) {
                        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 10);
                    }
         @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == Activity.RESULT_OK) {

                if (requestCode == 10) {
                    Uri selectedImageUri = data.getData();
                    String selectedImagePath = getRealPathFromURI(selectedImageUri);
                } else if (requestCode == 20) {
                    Uri selectedVideoUri = data.getData();
                    String selectedVideoPath = getRealPathFromURI(selectedVideoUri);
                }
    }
}
         public String getRealPathFromURI(Uri uri) {
                if (uri == null) {
                    return null;
                }
                String[] projection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
                if (cursor != null) {
                    int column_index = cursor
                            .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    return cursor.getString(column_index);
                }
                return uri.getPath();
            }
 */

/*
protected void onActivityResult(int requestCode, int resultCode,
       Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

    switch(requestCode) {
    case REQ_CODE_PICK_IMAGE:
        if(resultCode == RESULT_OK){
            Uri selectedImage = imageReturnedIntent.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(
                               selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();


            Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
        }
    }
}

 */

/*
//image storeag
public void insertImg(int id , Bitmap img ) {


    byte[] data = getBitmapAsByteArray(img); // this is a function

    insertStatement_logo.bindLong(1, id);
    insertStatement_logo.bindBlob(2, data);

    insertStatement_logo.executeInsert();
    insertStatement_logo.clearBindings() ;

}

 public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    bitmap.compress(CompressFormat.PNG, 0, outputStream);
    return outputStream.toByteArray();
}

public Bitmap getImage(int i){

    String qu = "select img  from table where feedid=" + i ;
    Cursor cur = db.rawQuery(qu, null);

    if (cur.moveToFirst()){
        byte[] imgByte = cur.getBlob(0);
        cur.close();
        return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
    }
    if (cur != null && !cur.isClosed()) {
        cur.close();
    }

    return null ;
}
 */


/*
package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;

import model.Food;


public class DatabaseHandler extends SQLiteOpenHelper {

  private final ArrayList<Food> foodList = new ArrayList<>();

  public DatabaseHandler(Context context){
    super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    //create table
    String CREATE_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
            + Constants.KEY_ID + " INTEGER PRIMARY KEY, " + Constants.FOOD_NAME +
            " TEXT, " + Constants.FOOD_CALORIES_NAME + " INT, " + Constants.DATE_NAME + " LONG);";

    sqLiteDatabase.execSQL(CREATE_TABLE);
    Log.v("Check log ","Success");
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
    onCreate(sqLiteDatabase);//create new db
  }

  //Get total items saved
  public int getTotalItems(){
    int totalItems = 0;

    String query = "SELECT * FROM " + Constants.TABLE_NAME ;
    SQLiteDatabase dba = this.getReadableDatabase();
    Cursor cursor = dba.rawQuery(query,null);
    totalItems = cursor.getCount();
    cursor.close();
    return totalItems;
  }

  //get total calories
  public int getTotalCalories(){
    int totalCalories = 0;

    SQLiteDatabase dba = this.getReadableDatabase();
    String query = "SELECT SUM( " + Constants.FOOD_CALORIES_NAME + " ) " +
            "FROM " + Constants.TABLE_NAME;
    Cursor cursor = dba.rawQuery(query,null);
    if(cursor.moveToFirst()){
      totalCalories = cursor.getInt(0);
    }
    cursor.close();
    dba.close();

    return totalCalories;
  }

  //delete food item
  public void deleteFood(int id){
    SQLiteDatabase dba = this.getWritableDatabase();
    dba.delete(Constants.TABLE_NAME,Constants.KEY_ID + " = ?",
            new String[]{String.valueOf(id)});
    dba.close();
  }

  //add food
  public void addFood(Food food){
    SQLiteDatabase dba = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(Constants.FOOD_NAME,food.getFoodName());
    values.put(Constants.FOOD_CALORIES_NAME,food.getCalories());
    values.put(Constants.DATE_NAME,System.currentTimeMillis());

    dba.insert(Constants.TABLE_NAME, null, values);
    Log.v("Added food item", "Yes");
    dba.close();

  }

  //get all food
  public ArrayList<Food> getFoods(){
    foodList.clear();
    SQLiteDatabase dba = this.getReadableDatabase();
    Cursor cursor = dba.query(Constants.TABLE_NAME,
            new String[]{Constants.KEY_ID, Constants.FOOD_NAME,
                    Constants.FOOD_CALORIES_NAME, Constants.DATE_NAME},
            null, null, null, null,Constants.DATE_NAME + " DESC ");

    if (cursor.moveToFirst()){
      do {
        Food food = new Food();
        food.setFoodName(cursor.getString(cursor.getColumnIndex(Constants.FOOD_NAME)));
        food.setCalories(cursor.getInt(cursor.getColumnIndex(Constants.FOOD_CALORIES_NAME)));
        food.setFoodId(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID)));
        DateFormat dateFormat = DateFormat.getDateInstance();
        String date = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))).getTime());

        food.setRecordDate(date);
        foodList.add(food);
      } while (cursor.moveToNext());
    }

    cursor.close();
    dba.close();
    return foodList;
  }
}

 */