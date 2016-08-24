package com.edimaudo.simplegridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
  private Context context;

  // Keep all Images in array
  public Integer[] imageInfo = {
          R.drawable.image1, R.drawable.image2,
          R.drawable.image3, R.drawable.image4,
          R.drawable.image5, R.drawable.image6,
          R.drawable.image7, R.drawable.image8,
          R.drawable.image9, R.drawable.image10,
  };

  // Constructor
  public ImageAdapter(Context c){
    context = c;
  }

  
  @Override
  public int getCount() {
    return imageInfo.length;
  }

  @Override
  public Object getItem(int i) {
    return imageInfo[i];
  }

  @Override
  public long getItemId(int i) {
    return 0;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    ImageView imageView = new ImageView(context);
    imageView.setImageResource(imageInfo[i]);
    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
    return imageView;
  }
}
