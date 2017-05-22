package com.edimaudo.foodtracker;

public class temp {
}

/*
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


 */


/*
package com.edimaudo.photoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;



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

 */


/* image adapter
 private static class ViewHolder {
    ImageView imgIcon;
    TextView description;
  }

  public ImageAdapter(Context context, ArrayList<Image> images) {
    super(context, 0, images);
  }

  @Override public View getView(int position, View convertView,
                                ViewGroup parent) {
    // view lookup cache stored in tag
    ViewHolder viewHolder;
    // Check if an existing view is being reused, otherwise inflate the
    // item view
    if (convertView == null) {
      viewHolder = new ViewHolder();
      convertView = LayoutInflater.from(getContext())
              .inflate(R.layout.item_image, parent, false);
      viewHolder.description =
              (TextView) convertView.findViewById(R.id.item_img_infor);
      viewHolder.imgIcon =
              (ImageView) convertView.findViewById(R.id.item_img_icon);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    // Get the data item for this position
    Image image = getItem(position);
    // set description text
    viewHolder.description.setText(image.toString());
    // set image icon
    viewHolder.imgIcon.setImageBitmap(ThumbnailUtils
            .extractThumbnail(BitmapFactory.decodeFile(image.getPath()),
                    THUMBSIZE, THUMBSIZE));

    // Return the completed view to render on screen
    return convertView;
  }

 */

/*
image db
package com.edimaudo.photoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class ImageDBHelper extends SQLiteOpenHelper {

  public static final String DB_NAME = "ImageDBHelper.db";
  public static final int DB_VERSION = 1;

  public static final String COMMA_SEP = ",";
  public static final String TEXT_TYPE = " TEXT";
  public static final String NUMERIC_TYPE = " NUMERIC";

  public static final String TABLE_NAME = "image";

  public static final String COLUMN_PATH = "path";
  public static final String COLUMN_TITLE = "title";
  public static final String COLUMN_DATETIME = "datetime";
  public static final String COLUMN_DESCRIPTION = "description";

  public static final String PRIMARY_KEY = "PRIMARY KEY (" + COLUMN_TITLE + "," + COLUMN_DATETIME + ")";


  private static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

  private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
          COLUMN_PATH + TEXT_TYPE + COMMA_SEP +
          COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
          COLUMN_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
          COLUMN_DATETIME + NUMERIC_TYPE + COMMA_SEP +
          PRIMARY_KEY +
          " )";


  public ImageDBHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
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

 */

/*
image display
package com.edimaudo.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;



public class ImageDisplay extends Activity {

  private Image image;
  private ImageView imageView;
  private TextView description;
  private String jstring;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.display_image);
    imageView = (ImageView) findViewById(R.id.display_image_view);
    description = (TextView) findViewById(R.id.text_view_description);
    Bundle extras = getIntent().getExtras();

    if (extras != null) {
      jstring = extras.getString("IMAGE");
    }
    image = getMyImage(jstring);
    description.setText(image.toString());
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;
    imageView.setImageBitmap(ImageResizer
            .decodeSampledBitmapFromFile(image.getPath(), width, height));
  }

  private Image getMyImage(String image) {
    try {
      JSONObject job = new JSONObject(image);
      return (new Image(job.getString("title"),
              job.getString("description"), job.getString("path"),
              job.getLong("datetimeLong")));
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return null;
  }


  public void btnBackOnClick(View v) {
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }


  public void btnDeleteOnClick(View v) {
    ImageDB db = new ImageDB(this);
    db.deleteImage(image);
    db.close();
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    // Save the user's current game state
    if (jstring != null) {
      outState.putString("jstring", jstring);
    }
    // Always call the superclass so it can save the view hierarchy state
    super.onSaveInstanceState(outState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    // Always call the superclass so it can restore the view hierarchy
    super.onRestoreInstanceState(savedInstanceState);

    // Restore state members from saved instance
    if (savedInstanceState.containsKey("jstring")) {
      jstring = savedInstanceState.getString("jstring");
    }
  }



}

 */

/*
package com.edimaudo.photoapp;



import java.io.Serializable;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class Image implements Serializable {
  private String title, description, path;
  private long datetimeLong;
  private SimpleDateFormat df = new SimpleDateFormat("MMMM d, yy  h:mm");

  public Image() {
  }

  public Image(String title, String description, String path, long datetimeLong) {
    this.title = title;
    this.description = description;
    this.path = path;
    this.datetimeLong = datetimeLong;
  }


  public String getTitle() { return title; }


  public Calendar getDatetime() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(datetimeLong);
    return cal;
  }


  public void setDatetime(long datetimeLong) {
    this.datetimeLong = datetimeLong;
  }


  public void setDatetime(Calendar datetime) {
    this.datetimeLong = datetime.getTimeInMillis();
  }


  public String getDescription() { return description; }


  public void setTitle(String title) { this.title = title; }


  public long getDatetimeLong() { return datetimeLong; }


  public void setDescription(String description) {
    this.description = description;
  }


  public void setPath(String path) { this.path = path; }


  public String getPath() { return path; }

  @Override public String toString() {
    return "Title:" + title + "   " + df.format(getDatetime().getTime()) +
            "\nDescription:" + description;
  }
}
*/
