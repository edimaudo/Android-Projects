package com.example.doggler;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.doggler.Layout;
public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogCardViewHolder> {

  // TODO: Initialize the data using the List found in data/DataSource
  private List<Dog> dogList;
  Layout layout = new Layout();


  /**
   * Initialize view elements
   */
  public class DogCardViewHolder extends RecyclerView.ViewHolder {
    // TODO: Declare and initialize all of the list item UI components
    public TextView age, hobbies, name;
    public ImageView dogImage;
    public DogCardViewHolder(@NonNull View itemView) {
      super(itemView);
      dogImage = (ImageView) itemView.findViewById(R.id.dog_image);
      name = (TextView) itemView.findViewById(R.id.dog_name);
      age = (TextView) itemView.findViewById(R.id.dog_age);
      hobbies = (TextView) itemView.findViewById(R.id.dog_hobbies);

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
    View itemView = null;
    if (viewType == layout.getGRID()){
      itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_item, parent, false);
    }  else {
      itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_horizontal_list_item, parent, false);
    }


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
