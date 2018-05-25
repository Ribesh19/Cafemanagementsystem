package com.sarangcode.t_burger.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;

import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sarangcode.t_burger.Menu;
import com.sarangcode.t_burger.MenuAdapter;
import com.sarangcode.t_burger.R;


public class UpdateActivity extends AppCompatActivity {

    private static String URL1 = " ";

    public String UpdateActivity_getURL()
    {
        SharedPreferences settings = getSharedPreferences("pref", 0);
        String table_no=settings.getString("table_no",null);
        assert table_no != null;
        switch (table_no)
        {
            case "1":
                URL1="http://192.168.1.108/MyApi/table1.php";
                break;
            case "2":
                URL1="http://192.168.1.108/MyApi/table2.php";
                break;
            case "3":
                URL1="http://192.168.1.108/MyApi/table3.php";
                break;
            case "4":
                URL1="http://192.168.1.108/MyApi/table4.php";
                break;
            case "5":
                URL1="http://192.168.1.108/MyApi/table5.php";
                break;
        }

        return URL1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final RecyclerView MenuList=findViewById(R.id.MenuList);
        MenuList.setLayoutManager(new LinearLayoutManager(this));
        String URL=UpdateActivity_getURL();
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(UpdateActivity.this, "Response Received", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Menu[] menus = gson.fromJson(response, Menu[].class);
                MenuList.setAdapter(new MenuAdapter(UpdateActivity.this,menus));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateActivity.this, "error", Toast.LENGTH_SHORT);
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);




    }


}
