package com.example.doggler;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogCardViewHolder> {

  private List<Dog> dogList;

  public class DogCardViewHolder extends RecyclerView.ViewHolder {
    public DogCardViewHolder(@NonNull View itemView) {

      super(itemView);
    }
  }

  public DogAdapter(List<Dog> dogList) {
    this.dogList = dogList;
  }

  @NonNull
  @Override
  public DogCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.grid_list_item, parent, false);

    return new DogCardViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull DogCardViewHolder holder, int position) {

  }



  @Override
  public int getItemCount() {
    return 0;
  }



}
