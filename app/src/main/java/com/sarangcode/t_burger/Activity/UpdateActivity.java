package com.sarangcode.t_burger.Activity;

import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sarangcode.t_burger.Menu;
import com.sarangcode.t_burger.MenuAdapter;
import com.sarangcode.t_burger.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class UpdateActivity extends AppCompatActivity {

    private static final String URL="http://192.168.1.108/MyApi/Api.php";
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //btn_submit=findViewById(R.id.btn_update_submit);
        final RecyclerView MenuList=findViewById(R.id.MenuList);
        MenuList.setLayoutManager(new LinearLayoutManager(this));

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
       /* SharedPreferences settings = getSharedPreferences("pref", 0);
        String table_no=settings.getString("table_no",null);

        JSONObject jsonTable_no=new JSONObject();
        try {
                jsonTable_no.put("tableno",table_no);
                Toast.makeText(UpdateActivity.this,jsonTable_no.toString(),Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonTable_no = (JSONObject) new JSONTokener(jsonTable_no.toString()).nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, URL, jsonTable_no, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(UpdateActivity.this, "Response Received", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", response.toString());
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Menu[] menus = gson.fromJson(response.toString(), Menu[].class);
                MenuList.setAdapter(new MenuAdapter(UpdateActivity.this,menus));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });*/
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);


    }


}
