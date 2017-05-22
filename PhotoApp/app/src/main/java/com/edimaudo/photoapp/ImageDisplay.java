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

/**
 * Created by edima on 2017-05-19.
 */

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

  /**
   * go back to main activity
   *
   * @param v
   */
  public void btnBackOnClick(View v) {
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }

  /**
   * delete the current item;
   *
   * @param v
   */
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
