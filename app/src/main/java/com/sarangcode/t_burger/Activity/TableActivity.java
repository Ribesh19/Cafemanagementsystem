package com.sarangcode.t_burger.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.sarangcode.t_burger.R;

public class TableActivity extends AppCompatActivity{
    Spinner spinner;
    Button btn_takeOrder;
    int table_no=89;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        spinner=findViewById(R.id.spinner);
       btn_takeOrder=findViewById(R.id.btn_take_order);

       Integer [] number={1,2,3,4,5,6,7,8,9,10};
       ArrayAdapter<Integer> adapter =new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,number);


       spinner.setAdapter(adapter);
       btn_takeOrder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              // String text =spinner.getSelectedItem().toString();
               table_no=(Integer)spinner.getSelectedItem();
               //Toast.makeText(TableActivity.this,table_no,Toast.LENGTH_SHORT).show();
               Intent intent_order= new Intent(TableActivity.this,MainActivity.class);
               intent_order.putExtra("table_no",table_no);
               startActivity(intent_order);

           }
       });



    }



}
