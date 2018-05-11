package com.sarangcode.t_burger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sarangcode.t_burger.Menu.sarangcode.t_burger.Menu;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private Menu[] data;
    String category;
    String categoryitem;

    public MenuAdapter(Context context,Menu[] data) {

        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.menu_layout, parent, false);
        return new MenuViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu=data[position];
        category=menu.getCategory().toString();
        categoryitem=menu.getCategoryitem().toString();
        holder.item_text_view.setText(category+categoryitem);
        holder.quantity_text_view.setText(menu.getQuantity());

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_text_view, quantity_text_view;

        public MenuViewHolder(View itemView) {
            super(itemView);
            item_text_view=itemView.findViewById(R.id.item_text_view);
            quantity_text_view=item_text_view.findViewById(R.id.quantity_text_view);

        }
    }
}
