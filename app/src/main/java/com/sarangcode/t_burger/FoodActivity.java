package com.sarangcode.t_burger;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sarangcode.t_burger.FoodFragments.BurgerFragment;
import com.sarangcode.t_burger.FoodFragments.ChowmeinFragment;
import com.sarangcode.t_burger.FoodFragments.DrinksFragment;
import com.sarangcode.t_burger.FoodFragments.MomoFragment;
import com.sarangcode.t_burger.FoodFragments.PizzaFragment;

public class FoodActivity extends AppCompatActivity {
    MomoFragment momoFragment=new MomoFragment();
    PizzaFragment pizzaFragment=new PizzaFragment();
    BurgerFragment burgerFragment=new BurgerFragment();
    DrinksFragment drinksFragment=new DrinksFragment();
    ChowmeinFragment chowmeinFragment=new ChowmeinFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        int position=getIntent().getIntExtra("position",0);
       // android.support.v4.app.Fragment selectedFragment = null;
        FragmentManager fragmentManager=getSupportFragmentManager();


        switch (position)
        {
            case 0:
               // selectedFragment= MomoFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.frame_layout,momoFragment)
                        .commit();
                break;
            case 1:
               // selectedFragment= PizzaFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.frame_layout,pizzaFragment)
                        .commit();
                break;
            case 2:
               // selectedFragment= BurgerFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.frame_layout,burgerFragment)
                        .commit();
                break;
            case 3:
               // selectedFragment= ChowmeinFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.frame_layout,chowmeinFragment)
                        .commit();
                break;
            case 4:
               // selectedFragment= DrinksFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.frame_layout,drinksFragment)
                        .commit();
                break;
        }
    }

}
