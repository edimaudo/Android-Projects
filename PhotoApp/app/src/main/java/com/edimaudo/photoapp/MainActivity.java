package com.edimaudo.photoapp;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private FloatingActionButton addPhotoFab;
  private ListView mainListView;
  private ArrayList<Image> images;
  private ImageAdapter imageAdapter;
  private Uri mCapturedImageURI;
  private static final int RESULT_LOAD_IMAGE = 1;
  private static final int REQUEST_IMAGE_CAPTURE = 2;
  private ImageDB imageDB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  addPhotoFab = (FloatingActionButton) findViewById(R.id.addPhotoFab);
    // Construct the data source
    images = new ArrayList();
    // Create the adapter to convert the array to views
    imageAdapter = new ImageAdapter(this, images);
    // Attach the adapter to a ListView
    mainListView = (ListView) findViewById(R.id.mainListView);
    mainListView.setAdapter(imageAdapter);
    addItemClickListener(mainListView);
    initDB();

    addPhotoFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final Dialog dialog = new Dialog(getBaseContext());
        dialog.setContentView(R.layout.custom_dialog_box);
        dialog.setTitle("Alert Dialog View");
        Button btnExit = (Button) dialog.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            dialog.dismiss();
          }
        });
        dialog.findViewById(R.id.btnChoosePath)
                .setOnClickListener(new View.OnClickListener() {
                  @Override public void onClick(View v) {
                    activeGallery();
                  }
                });
        dialog.findViewById(R.id.btnTakePhoto)
                .setOnClickListener(new View.OnClickListener() {
                  @Override public void onClick(View v) {
                    activeTakePhoto();
                  }
                });

        // show dialog on screen
        dialog.show();
      }
    });
  }

  /**
   * initialize database
   */
  private void initDB() {
    imageDB = new ImageDB(this);
    //        add images from database to images ArrayList
    for (Image mi : imageDB.getImages()) {
      images.add(mi);
    }
  }

  public void btnAddOnClick(View view) {
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.custom_dialog_box);
    dialog.setTitle("Alert Dialog View");
    Button btnExit = (Button) dialog.findViewById(R.id.btnExit);
    btnExit.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        dialog.dismiss();
      }
    });
    dialog.findViewById(R.id.btnChoosePath)
            .setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                activeGallery();
              }
            });
    dialog.findViewById(R.id.btnTakePhoto)
            .setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                activeTakePhoto();
              }
            });

    // show dialog on screen
    dialog.show();

  }


  /**
   * take a photo
   */
  private void activeTakePhoto() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      String fileName = "temp.jpg";
      ContentValues values = new ContentValues();
      values.put(MediaStore.Images.Media.TITLE, fileName);
      mCapturedImageURI = getContentResolver()
              .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                      values);
      takePictureIntent
              .putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
  }

  /**
   * to gallery
   */
  private void activeGallery() {
    Intent intent = new Intent(Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(intent, RESULT_LOAD_IMAGE);
  }



  private void addItemClickListener(final ListView listView) {
    listView.setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

        Image image = (Image) listView.getItemAtPosition(position);
        Intent intent =
                new Intent(getBaseContext(), ImageDisplay.class);
        intent.putExtra("IMAGE", (new Gson()).toJson(image));
        startActivity(intent);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode,
                                            Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
      case RESULT_LOAD_IMAGE:
        if (requestCode == RESULT_LOAD_IMAGE &&
                resultCode == RESULT_OK && null != data) {
          Uri selectedImage = data.getData();
          String[] filePathColumn = {MediaStore.Images.Media.DATA};
          Cursor cursor = getContentResolver()
                  .query(selectedImage, filePathColumn, null, null,
                          null);
          cursor.moveToFirst();
          int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
          String picturePath = cursor.getString(columnIndex);
          cursor.close();
          Image image = new Image();
          image.setTitle("Test");
          image.setDescription(
                  "test choose a photo from gallery and add it to " +
                          "list view");
          image.setDatetime(System.currentTimeMillis());
          image.setPath(picturePath);
          images.add(image);
          imageDB.addImage(image);
        }
      case REQUEST_IMAGE_CAPTURE:
        if (requestCode == REQUEST_IMAGE_CAPTURE &&
                resultCode == RESULT_OK) {
          String[] projection = {MediaStore.Images.Media.DATA};
          Cursor cursor =
                  managedQuery(mCapturedImageURI, projection, null,
                          null, null);
          int column_index_data = cursor.getColumnIndexOrThrow(
                  MediaStore.Images.Media.DATA);
          cursor.moveToFirst();
          String picturePath = cursor.getString(column_index_data);
          Image image = new Image();
          image.setTitle("Test");
          image.setDescription(
                  "test take a photo and add it to list view");
          image.setDatetime(System.currentTimeMillis());
          image.setPath(picturePath);
          images.add(image);
          imageDB.addImage(image);
        }
    }
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    // Save the user's current game state
    if (mCapturedImageURI != null) {
      outState.putString("mCapturedImageURI",
              mCapturedImageURI.toString());
    }
    // Always call the superclass so it can save the view hierarchy state
    super.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    // Always call the superclass so it can restore the view hierarchy
    super.onRestoreInstanceState(savedInstanceState);

    // Restore state members from saved instance
    if (savedInstanceState.containsKey("mCapturedImageURI")) {
      mCapturedImageURI = Uri.parse(
              savedInstanceState.getString("mCapturedImageURI"));
    }
  }
}
