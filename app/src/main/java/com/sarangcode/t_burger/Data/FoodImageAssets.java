package com.sarangcode.t_burger.Data;

import com.sarangcode.t_burger.R;

import java.util.ArrayList;
import java.util.List;

// Class for storing all the image drawable resources in ArrayLists
public class FoodImageAssets {
    private static final List<Integer> food = new ArrayList<Integer>() {{
        add(R.drawable.momo_);
        add(R.drawable.pizza);
        add(R.drawable.burger);
        add(R.drawable.chowmein);
        add(R.drawable.drinks);
        add(R.drawable.pakauda);
        add(R.drawable.icecream);
        add(R.drawable.soup);

    }};
    private static final List<Integer> all = new ArrayList<Integer>() {{
        addAll(food);
    }};
    // Getter methods that return lists of all food images

    public static List<Integer> getFood() {
        return food;
    }

    public static List<Integer> getAll() {
        return all;
    }
}
