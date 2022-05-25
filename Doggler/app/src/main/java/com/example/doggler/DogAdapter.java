package com.example.doggler;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogCardViewHolder> {

  // TODO: Initialize the data using the List found in data/DataSource
  private List<Dog> dogList;

  /**
   * Initialize view elements
   */
  public class DogCardViewHolder extends RecyclerView.ViewHolder {
    // TODO: Declare and initialize all of the list item UI components
    public TextView age, hobbies, name;
    public ImageView dogImage;
    public DogCardViewHolder(@NonNull View itemView) {
      super(itemView);
      dogImage = (ImageView) itemView.findViewById(R.id.imageView);
      name = (TextView) itemView.findViewById(R.id.TextViewName);
      age = (TextView) itemView.findViewById(R.id.TextViewAge);
      hobbies = (TextView) itemView.findViewById(R.id.TextViewHobbies);

    }
  }

  public DogAdapter(List<Dog> dogList) {
    this.dogList = dogList;
  }

  @NonNull
  @Override
  public DogCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // TODO: Use a conditional to determine the layout type and set it accordingly.
    //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
    //  the vertical/horizontal list item should be used.

    // TODO Inflate the layout
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.grid_list_item, parent, false);


    // TODO: Null should not be passed into the view holder. This should be updated to reflect
    //  the inflated layout.
    return new DogCardViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull DogCardViewHolder holder, int position) {
    // TODO: Get the data at the current position
    // TODO: Set the image resource for the current dog
    // TODO: Set the text for the current dog's name
    // TODO: Set the text for the current dog's age

    // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
    //  R.string.dog_hobbies string constant.
    //  Passing an argument to the string resource looks like:
    //  resources?.getString(R.string.dog_hobbies, dog.hobbies)

    Dog dog = dogList.get(position);
    holder.dogImage.setImageResource(dog.getImageResourceId());
    holder.name.setText(dog.getName());
    holder.age.setText(dog.getAge());
    holder.hobbies.setText(dog.getHobbies());

  }



  @Override
  public int getItemCount() {
    //TODO: return the size of the data
    return dogList.size();
  }



}
