package com.example.doggler;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogCardViewHolder> {

  @NonNull
  @Override
  public DogCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull DogCardViewHolder holder, int position) {

  }

  

  @Override
  public int getItemCount() {
    return 0;
  }


  public class DogCardViewHolder extends RecyclerView.ViewHolder {
    public DogCardViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }
}
