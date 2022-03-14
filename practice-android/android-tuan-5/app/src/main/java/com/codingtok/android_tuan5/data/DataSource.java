package com.codingtok.android_tuan5.data;

import com.codingtok.android_tuan5.R;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static final List<Food> foodList = Arrays.asList(
            new Food(
                    1, "Tasty Donut", R.drawable.donut_yellow_1, "Spicy tasty donut family", 10f
            ),
            new Food(
                    2, "Pink Donut", R.drawable.tasty_donut_1, "Spicy tasty donut family", 20f
            ),
            new Food(
                    3, "Floating Donut", R.drawable.green_donut_1, "Spicy tasty donut family", 30f
            ),
            new Food(
                    4, "Tasty Donut", R.drawable.donut_red_1, "Spicy tasty donut family", 40f
            )
    );
}
