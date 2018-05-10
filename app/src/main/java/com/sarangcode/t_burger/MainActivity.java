package com.sarangcode.t_burger;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sarangcode.t_burger.FoodFragments.BurgerFragment;
import com.sarangcode.t_burger.FoodFragments.ChowmeinFragment;
import com.sarangcode.t_burger.FoodFragments.DrinksFragment;
import com.sarangcode.t_burger.FoodFragments.MomoFragment;
import com.sarangcode.t_burger.FoodFragments.PizzaFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    // Track whether to display a two-pane or single-pane UI
    // A single-pane display refers to phone screens, and two-pane to larger tablet screens
    MomoFragment momoFragment = new MomoFragment();
    PizzaFragment pizzaFragment = new PizzaFragment();
    BurgerFragment burgerFragment = new BurgerFragment();
    DrinksFragment drinksFragment = new DrinksFragment();
    ChowmeinFragment chowmeinFragment = new ChowmeinFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public int PassTableNo()
    {
        int table_no=getIntent().getIntExtra("table_no",0);
        return table_no;
    }


    // Define the behavior for onImageSelected
    @Override
    public void onImageSelected(int position) {
        //Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();


        if (findViewById(R.id.linear_layout) != null) {
            switch (position) {
                case 0:

                    android.support.v4.app.FragmentManager fragmentManager0 = getSupportFragmentManager();
                    fragmentManager0.beginTransaction()
                            .replace(R.id.frame_layout_tab, momoFragment)
                            .commit();
                    break;
                case 1:

                    android.support.v4.app.FragmentManager fragmentManager1 = getSupportFragmentManager();
                    fragmentManager1.beginTransaction()
                            .replace(R.id.frame_layout_tab, pizzaFragment)
                            .commit();
                    break;
                case 2:

                    android.support.v4.app.FragmentManager fragmentManager2 = getSupportFragmentManager();
                    fragmentManager2.beginTransaction()
                            .replace(R.id.frame_layout_tab, burgerFragment)
                            .commit();
                    break;
                case 3:

                    android.support.v4.app.FragmentManager fragmentManager3 = getSupportFragmentManager();
                    fragmentManager3.beginTransaction()
                            .replace(R.id.frame_layout_tab, chowmeinFragment)
                            .commit();
                    break;
                case 4:

                    android.support.v4.app.FragmentManager fragmentManager4 = getSupportFragmentManager();
                    fragmentManager4.beginTransaction()
                            .replace(R.id.frame_layout_tab, drinksFragment)
                            .commit();
                    break;
            }
        }
        else

            {
                final Intent intent = new Intent(this, FoodActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }

    }
}