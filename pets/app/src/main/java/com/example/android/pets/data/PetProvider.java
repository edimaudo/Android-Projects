package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * {@link ContentProvider} for Pets app.
 */
public class PetProvider extends ContentProvider {

  /**
   * Tag for the log messages
   */
  public static final String LOG_TAG = PetProvider.class.getSimpleName();
  private PetDBHelper mPetDBHelper;

  private static  final int PETS = 100;
  private static final int PET_ID = 101;

  private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
  static {
    sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS,PETS);
    sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS + "/#", PET_ID);
  }

  /**
   * Initialize the provider and the database helper object.
   */
  @Override
  public boolean onCreate() {
    // Make sure the variable is a global variable, so it can be referenced from other
    // ContentProvider methods.
    mPetDBHelper = new PetDBHelper(getContext());
    return true;
  }

  /**
   * Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
   */
  @Override
  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                      String sortOrder) {
    SQLiteDatabase database = mPetDBHelper.getReadableDatabase();
    int match = sUriMatcher.match(uri);
    Cursor cursor = null;
    switch (match){
      case PETS:
        cursor = database.query(PetEntry.TABLE_NAME,projection,selection,selectionArgs,
                null, null, sortOrder);
        break;
      case PET_ID:
        selection = PetEntry._ID + "#?";
        selectionArgs = new String [] {String.valueOf(ContentUris.parseId(uri))};
        cursor = database.query(PetEntry.TABLE_NAME,projection,selection,selectionArgs,
                null, null, sortOrder);
        break;
      default:
        //do nothing
    }
    return cursor;
  }

  /**
   * Insert new data into the provider with the given ContentValues.
   */
  @Override
  public Uri insert(Uri uri, ContentValues contentValues) {
    final int match = sUriMatcher.match(uri);
    switch(match){
      case PETS:
        return insertPet(uri,contentValues);
      default:
        throw new IllegalArgumentException("Insertion is not supported for " + uri);
    }
  }

  /**
   * Updates the data at the given selection and selection arguments, with the new ContentValues.
   */

  private Uri insertPet(Uri uri, ContentValues contentValues){

    SQLiteDatabase database = mPetDBHelper.getWritableDatabase();

    String name = contentValues.getAsString(PetEntry.COLUMN_PET_NAME);
    Integer weight = contentValues.getAsInteger(PetEntry.COLUMN_PET_WEIGHT);
    Integer gender = contentValues.getAsInteger(PetEntry.COLUMN_PET_GENDER);

    if (name == null) {
      throw new IllegalArgumentException("Pet requires a name");
    }

    if (weight != null && weight < 0) {
      throw new IllegalArgumentException("Pet requires a weight");
    }

    if (gender == null || !PetEntry.isValidGender(gender)) {
      throw new IllegalArgumentException("Pet requires a gender");
    }

    // Insert the new pet with the given values
    long id = database.insert(PetEntry.TABLE_NAME, null, contentValues);

    if (id == -1) {
      Log.e(LOG_TAG, "Failed to insert row for " + uri);
      return null;
    }
    return ContentUris.withAppendedId(uri,id);
  }


  @Override
  public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
    final int match = sUriMatcher.match(uri);
    switch (match) {
      case PETS:
        return updatePet(uri, contentValues, selection, selectionArgs);
      case PET_ID:
        // For the PET_ID code, extract out the ID from the URI,
        // so we know which row to update. Selection will be "_id=?" and selection
        // arguments will be a String array containing the actual ID.
        selection = PetEntry._ID + "=?";
        selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
        return updatePet(uri, contentValues, selection, selectionArgs);
      default:
        throw new IllegalArgumentException("Update is not supported for " + uri);
    }
  }

  private int updatePet(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
    SQLiteDatabase database = mPetDBHelper.getWritableDatabase();

    if (values.containsKey(PetEntry.COLUMN_PET_NAME)) {
      String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
      if (name == null) {
        throw new IllegalArgumentException("Pet requires a name");
      }
    }

    // If the {@link PetEntry#COLUMN_PET_GENDER} key is present,
    // check that the gender value is valid.
    if (values.containsKey(PetEntry.COLUMN_PET_GENDER)) {
      Integer gender = values.getAsInteger(PetEntry.COLUMN_PET_GENDER);
      if (gender == null || !PetEntry.isValidGender(gender)) {
        throw new IllegalArgumentException("Pet requires valid gender");
      }
    }

    // If the {@link PetEntry#COLUMN_PET_WEIGHT} key is present,
    // check that the weight value is valid.
    if (values.containsKey(PetEntry.COLUMN_PET_WEIGHT)) {
      // Check that the weight is greater than or equal to 0 kg
      Integer weight = values.getAsInteger(PetEntry.COLUMN_PET_WEIGHT);
      if (weight != null && weight < 0) {
        throw new IllegalArgumentException("Pet requires valid weight");
      }
    }

    // No need to check the breed, any value is valid (including null).

    // If there are no values to update, then don't try to update the database
    if (values.size() == 0) {
      return 0;
    }

    return database.update(PetEntry.TABLE_NAME, values, selection, selectionArgs);
  }

  /**
   * Delete the data at the given selection and selection arguments.
   */
  @Override
  public int delete(Uri uri, String selection, String[] selectionArgs) {
    SQLiteDatabase database = mPetDBHelper.getWritableDatabase();

    final int match = sUriMatcher.match(uri);
    switch (match) {
      case PETS:
        // Delete all rows that match the selection and selection args
        return database.delete(PetEntry.TABLE_NAME, selection, selectionArgs);
      case PET_ID:
        // Delete a single row given by the ID in the URI
        selection = PetEntry._ID + "=?";
        selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
        return database.delete(PetEntry.TABLE_NAME, selection, selectionArgs);
      default:
        throw new IllegalArgumentException("Deletion is not supported for " + uri);
    }

  }


  /**
   * Returns the MIME type of data for the content URI.
   */
  @Override
  public String getType(Uri uri) {
    final int match = sUriMatcher.match(uri);
    switch (match) {
      case PETS:
        return PetEntry.CONTENT_LIST_TYPE;
      case PET_ID:
        return PetEntry.CONTENT_ITEM_TYPE;
      default:
        throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
    }
  }
}