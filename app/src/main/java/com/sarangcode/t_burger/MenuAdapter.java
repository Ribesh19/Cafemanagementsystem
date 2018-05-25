package com.sarangcode.t_burger;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sarangcode.t_burger.Activity.UpdateActivity;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private Menu[] data;
    String category;
    String categoryitem;
    Integer quantity;





    //  UpdateActivity updateActivity = new UpdateActivity();
//    private Integer table_no;

    public MenuAdapter(Context context, Menu[] data) {

        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.menu_layout_card_view, parent, false);
        return new MenuViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull final MenuViewHolder holder, int position) {
        Menu menu = data[position];
        quantity = menu.getQuantity();
        final Integer[] addone = {quantity};
            category = menu.getCategory();
            categoryitem = menu.getCategoryitem();
            holder.item_text_view.setText(category + " " + categoryitem);
            holder.quantity_text_view.setText(quantity.toString());

      holder.btn_increase.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              addone[0]++;
              holder.quantity_text_view.setText(addone[0].toString());
          }
      });
      holder.btn_decrease.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              addone[0]--;
              holder.quantity_text_view.setText(addone[0].toString());
          }
      });

    }
    @Override
    public int getItemCount() {


        return data.length;
    }
    public class MenuViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_text_view, quantity_text_view;
        Button btn_increase,btn_decrease;

        public MenuViewHolder(View itemView) {
            super(itemView);
            item_text_view=itemView.findViewById(R.id.item_text_view);
            quantity_text_view=itemView.findViewById(R.id.quantity_text_view);
            btn_decrease=itemView.findViewById(R.id.btn_decrease);
            btn_increase=itemView.findViewById(R.id.btn_increase);
            }
    }
}
