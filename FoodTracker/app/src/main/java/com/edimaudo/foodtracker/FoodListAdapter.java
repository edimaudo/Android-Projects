package com.edimaudo.foodtracker;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by edima on 2017-05-25.
 */

public class FoodListAdapter extends ArrayAdapter<Food> {
  private Context context;
  private List<Food> foods;

  public FoodListAdapter(@NonNull Context context, List<Food> foods) {
    super(context, R.layout.item_image, foods);
    this.context = context;
    this.foods = foods;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.item_image,parent,false);

    ImageView item_img_icon =  (ImageView) view.findViewById(R.id.item_img_icon);
    TextView item_img_infor = (TextView) view.findViewById(R.id.item_img_infor);
    RatingBar item_img_rate = (RatingBar) view.findViewById(R.id.item_img_rate);

    item_img_icon.setImageURI(Uri.parse(foods.get(position).getFoodImageName()));
    item_img_infor.setText(foods.get(position).getFoodName());
    item_img_rate.setNumStars(foods.get(position).getFoodRating());

    return view;
    //return super.getView(position, convertView, parent);

  }
}
