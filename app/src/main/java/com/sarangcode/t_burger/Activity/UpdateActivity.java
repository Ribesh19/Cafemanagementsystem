package com.sarangcode.t_burger.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sarangcode.t_burger.Menu.sarangcode.t_burger.Menu;
import com.sarangcode.t_burger.MenuAdapter;
import com.sarangcode.t_burger.R;

public class UpdateActivity extends AppCompatActivity {

    private static final String URL="http://192.168.1.108/MyApi/Api.php";
    TextView qunatity_text_view;
    Button btn_increase;
    Button btn_decrease;
    Integer qunatity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final RecyclerView MenuList = findViewById(R.id.MenuList);
        qunatity_text_view = findViewById(R.id.quantity_text_view);
        btn_increase = findViewById(R.id.increase);
        btn_decrease = findViewById(R.id.decrease);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        MenuList.setLayoutManager(new LinearLayoutManager(this));
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(UpdateActivity.this, "Response Received", Toast.LENGTH_SHORT);
                Log.d("MainActivity", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Menu[] menus = gson.fromJson(response, Menu[].class);
                MenuList.setAdapter(new MenuAdapter(UpdateActivity.this, menus));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateActivity.this, "error", Toast.LENGTH_SHORT);
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
        btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qunatity++;
                qunatity_text_view.setText(qunatity.toString());

            }
        });
        btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qunatity--;
                qunatity_text_view.setText(qunatity.toString());
            }
        });
    }

}
