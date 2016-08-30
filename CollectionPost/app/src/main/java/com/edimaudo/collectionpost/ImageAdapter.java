package com.edimaudo.collectionpost;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
  private Context context;

  public Integer[] thumbIds= {
          R.drawable.image1,
          R.drawable.image2,
          R.drawable.image3,
          R.drawable.image4,
          R.drawable.image5,
          R.drawable.image6,
          R.drawable.image7,
          R.drawable.image8,
          R.drawable.image9,
          R.drawable.image10,
          R.drawable.image11,
          R.drawable.image12,
          R.drawable.image13,
          R.drawable.image14,
          R.drawable.image15
  };


  public ImageAdapter(Context c){
    context = c;
  }

  @Override
  public int getCount() {
    return thumbIds.length;
  }

  @Override
  public Object getItem(int i) {
    return thumbIds[i];
  }

  @Override
  public long getItemId(int i) {
    return 0;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    ImageView imageView = new ImageView(context);
    imageView.setImageResource(thumbIds[i]);
    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    imageView.setLayoutParams(new GridView.LayoutParams(500,500));
    return imageView;
  }
}
