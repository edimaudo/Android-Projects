package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * {@link ContentProvider} for Pets app.
 */
public class PetProvider extends ContentProvider {

  /** Tag for the log messages */
  public static final String LOG_TAG = PetProvider.class.getSimpleName();
  private PetDBHelper mPetDBHelper;
  public static final String CONTENT_AUTHORITY = "com.example.android.pets";

  public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

  public static final String PATH_PETS = "pets";

  public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

  /**
   * Initialize the provider and the database helper object.
   */
  @Override
  public boolean onCreate() {
    // TODO: Create and initialize a PetDbHelper object to gain access to the pets database.
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
    return null;
  }

  /**
   * Insert new data into the provider with the given ContentValues.
   */
  @Override
  public Uri insert(Uri uri, ContentValues contentValues) {
    return null;
  }

  /**
   * Updates the data at the given selection and selection arguments, with the new ContentValues.
   */
  @Override
  public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
    return 0;
  }

  /**
   * Delete the data at the given selection and selection arguments.
   */
  @Override
  public int delete(Uri uri, String selection, String[] selectionArgs) {
    return 0;
  }

  /**
   * Returns the MIME type of data for the content URI.
   */
  @Override
  public String getType(Uri uri) {
    return null;
  }
}