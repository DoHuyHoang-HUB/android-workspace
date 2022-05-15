package com.example.lab_06.data.model;

import com.example.lab_06.R;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static final List<Shoes> DATA = Arrays.asList(
            new Shoes(
                   "Nike shoes",
                    0.5f,
                    R.drawable.shoes_rm_preview_b
            ),
            new Shoes(
                    "Adidas shoes",
                    0.8f,
                    R.drawable.shoes_rm_preview_a
            ),
            new Shoes(
                    "Nike Bicycle",
                    0.3f,
                    R.drawable.shoes_rm_purple
            ),
            new Shoes(
                    "Yonex shoes",
                    0.5f,
                    R.drawable.shoes_rm_preview
            ),
            new Shoes(
                    "Victor shoes",
                    0.5f,
                    R.drawable.shoes_rm_yellow
            ),
            new Shoes(
                    "Lining shoes",
                    0.5f,
                    R.drawable.shoes_white_removebg_preview
            ),
            new Shoes(
                    "Binh Minh shoes",
                    0.9f,
                    R.drawable.color_removebg_preview
            )
    );
}
