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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sarangcode.t_burger.Activity.UpdateActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private Menu[] data;
    String category;
    String categoryitem;
    Integer quantity;

    private static final String URL = "http://192.168.1.108/MyApi/update.php";
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
    public void onBindViewHolder(@NonNull final MenuViewHolder holder, final int position) {
        final Menu menu = data[position];
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
      holder.btn_update.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(context,"Update "+holder.item_text_view.getText(),Toast.LENGTH_SHORT).show();
              JSONObject jsonUpdate=new JSONObject();
              try {
                  jsonUpdate.put("tableno",menu.getTableno());
                  jsonUpdate.put("category",category);
                  jsonUpdate.put("categoryitem",categoryitem);
                  jsonUpdate.put("quantity",holder.quantity_text_view.getText());
                  Toast.makeText(context,jsonUpdate.toString(),Toast.LENGTH_SHORT).show();
              } catch (JSONException e) {
                  e.printStackTrace();
              }
              try {
                  jsonUpdate = (JSONObject) new JSONTokener(jsonUpdate.toString()).nextValue();
              } catch (JSONException e) {
                  e.printStackTrace();
              }
              JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, URL, jsonUpdate, new Response.Listener<JSONObject>() {
                  @Override
                  public void onResponse(JSONObject response) {
                      Toast.makeText(context,"response received",Toast.LENGTH_SHORT).show();
                  }
              }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                      Toast.makeText(context,"response error",Toast.LENGTH_SHORT).show();

                  }
              });
              RequestQueue queue= Volley.newRequestQueue(context.getApplicationContext());
              queue.add(request);


          }
      });
      holder.btn_delete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(context,"Delete "+holder.item_text_view.getText(),Toast.LENGTH_SHORT).show();


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
        Button btn_increase,btn_decrease,btn_update,btn_delete;

        public MenuViewHolder(View itemView) {
            super(itemView);
            item_text_view=itemView.findViewById(R.id.item_text_view);
            quantity_text_view=itemView.findViewById(R.id.quantity_text_view);
            btn_decrease=itemView.findViewById(R.id.btn_decrease);
            btn_increase=itemView.findViewById(R.id.btn_increase);
            btn_delete=itemView.findViewById(R.id.btn_delete);
            btn_update=itemView.findViewById(R.id.btn_update);
            }
    }
}
