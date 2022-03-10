package com.example.list_view_demo.data.datasource;

import com.example.list_view_demo.R;
import com.example.list_view_demo.data.model.Product;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static final List<Product> products = Arrays.asList(
            new Product("Cá nấu lẩu, nấu mì mini", "Shop Devanc",R.drawable.ca_nau_lau),
            new Product("1KG KHÔ GÀ BƠ TỎI", "Shop LTD Food", R.drawable.ga_bo_toi),
            new Product("Xe cần cẩu đa năng", "Shop Thế giới đồ chơi")
    )
}
