package com.sarangcode.t_burger.FoodFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sarangcode.t_burger.Activity.MainActivity;
import com.sarangcode.t_burger.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MomoFragment extends Fragment {

    CheckBox checkBox_buff_momo;
    CheckBox checkBox_veg_momo;
    CheckBox checkBox_chicken_momo;
    CheckBox checkBox_steam_momo;
    CheckBox checkBox_fried_momo;
    CheckBox checkBox_c_momo;
    Button btn_submit;
    Button btn_increase;
    Button btn_decrease;
    TextView quantity_text_view;
    String category;
    String categoryitem;
    Integer quantity=0;

    int table_no;

    private static final String URL = "http://192.168.1.108/MyApi/add.php";


    public MomoFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview= inflater.inflate(R.layout.fragment_momo,container,false);
        checkBox_buff_momo=rootview.findViewById(R.id.checkbox_buff_momo);
        checkBox_veg_momo=rootview.findViewById(R.id.checkbox_veg_momo);
        checkBox_chicken_momo=rootview.findViewById(R.id.checkbox_chicken_momo);
        checkBox_steam_momo=rootview.findViewById(R.id.checkbox_steam_momo);
        checkBox_fried_momo=rootview.findViewById(R.id.checkbox_fried_momo);
        checkBox_c_momo=rootview.findViewById(R.id.checkbox_c_momo);
        btn_submit=rootview.findViewById(R.id.btn_submit);
        btn_increase=rootview.findViewById(R.id.increase);
        btn_decrease=rootview.findViewById(R.id.decrease);
        quantity_text_view=rootview.findViewById(R.id.integer_number);

        table_no=((MainActivity)getActivity()).PassTableNo();
        btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;
                quantity_text_view.setText(quantity.toString());

            }
        });
        btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                quantity_text_view.setText(quantity.toString());
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(),table_no,Toast.LENGTH_SHORT).show();
                if (checkBox_buff_momo.isChecked()) {
                    Toast.makeText(getContext(), "buff momo", Toast.LENGTH_SHORT).show();
                    category="Buff Momo";
                } else if (checkBox_veg_momo.isChecked()) {
                    Toast.makeText(getContext(), "veg momo", Toast.LENGTH_SHORT).show();
                    category="Veg Momo";

                }
                else if (checkBox_chicken_momo.isChecked())
                {
                    Toast.makeText(getContext(), "Chicken momo", Toast.LENGTH_SHORT).show();
                    category="Chicken Momo ";

                }

                if (checkBox_steam_momo.isChecked())
                {
                    Toast.makeText(getContext(),"Steam momo",Toast.LENGTH_SHORT).show();
                    categoryitem="Steam";
                }
                else if (checkBox_fried_momo.isChecked())
                {
                    Toast.makeText(getContext(),"Fried momo",Toast.LENGTH_SHORT).show();
                    categoryitem="Fried";
                }
                else if (checkBox_c_momo.isChecked())
                {
                    Toast.makeText(getContext(),"C momo",Toast.LENGTH_SHORT).show();
                    categoryitem="C";
                }
                Toast.makeText(getContext(),"Loop finished",Toast.LENGTH_SHORT).show();
                JSONObject jsonMomo=new JSONObject();
                try {
                    jsonMomo.put("tableno", table_no);
                    jsonMomo.put("category",category);
                    jsonMomo.put("categoryitem",categoryitem);
                    jsonMomo.put("quantity",quantity
                    );
                    Toast.makeText(getContext(),jsonMomo.toString(),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonMomo = (JSONObject) new JSONTokener(jsonMomo.toString()).nextValue();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, URL, jsonMomo, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                RequestQueue queue= Volley.newRequestQueue(getActivity());
                queue.add(request);

            }

        });



        return rootview;
    }
}
