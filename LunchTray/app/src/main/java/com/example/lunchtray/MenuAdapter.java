package com.example.lunchtray;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.List;

class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuCardViewHolder> {

  private List<MenuItem> menuList;


  @NonNull
  @Override
  public MenuAdapter.MenuCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = null;
    itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
    return new MenuCardViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull MenuAdapter.MenuCardViewHolder holder, int position) {
    MenuItem  menuItem = menuList.get(position);
    holder.entreeOption.setText(menuItem.getName());
    holder.entreeDescription.setText(menuItem.getDescription());
    holder.entreePrice.setText(menuItem.getFormattedPrice(menuItem.getPrice()));
  }

  @Override
  public int getItemCount() {
    return menuList.size();
  }

  public class MenuCardViewHolder extends RecyclerView.ViewHolder {
    public TextView entreeOption;
    public TextView entreeDescription, entreePrice;

    public MenuCardViewHolder(@NonNull View itemView) {
      super(itemView);
      entreeOption = (TextView) itemView.findViewById(R.id.entree_option);
      entreeDescription = (TextView) itemView.findViewById(R.id.entree_description);
      entreePrice = (TextView) itemView.findViewById(R.id.entree_price);

    }
  }

  public MenuAdapter(List<MenuItem> menuList) {
    this.menuList = menuList;
  }
}
