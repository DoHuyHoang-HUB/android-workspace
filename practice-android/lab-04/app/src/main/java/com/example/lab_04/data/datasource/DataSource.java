package com.example.lab_04.data.datasource;

import com.example.lab_04.R;
import com.example.lab_04.data.model.Product;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static final List<Product> products = Arrays.asList(
            new Product("Cá nấu lẩu, nấu mì mini", "Shop Devanc",R.drawable.ca_nau_lau),
            new Product("1KG KHÔ GÀ BƠ TỎI", "Shop LTD Food", R.drawable.ga_bo_toi),
            new Product("Xe cần cẩu đa năng", "Shop Thế giới đồ chơi", R.drawable.xa_can_cau),
            new Product("Đồ chơi dạng mô hình", "Shop Thế giới đồ chơi", R.drawable.do_choi_dang_mo_hinh),
            new Product("Lãnh đạo giản đơn", "Shop Minh Long Book", R.drawable.lanh_dao_gian_don),
            new Product("Hiếu lòng với con trẻ", "Shop Minh Long Book", R.drawable.hieu_long_con_tre),
            new Product("Donal Trump thiên tài lãnh đạo", "Shop Minh Long Book", R.drawable.trump_1)
    );

    public static  final List<Product> productGridView = Arrays.asList(
            new Product("Cáp chuyển từ cổng USB sang PS2...", R.drawable.gia_chuyen, 4f, 699000, .39f),
            new Product("Cáp chuyển từ cổng USB sang PS2", R.drawable.day_nguon, 4f, 699000, .39f),
            new Product("Cáp chuyển từ cổng USB sang PS2", R.drawable.day_chuyen_doi_ps2, 4f, 699000, .39f),
            new Product("Cáp chuyển từ cổng USB sang PS2", R.drawable.day_chuyen_doi, 4f, 699000, .39f),
            new Product("Cáp chuyển từ cổng USB sang PS2", R.drawable.day_chuyen_ps2_1, 4f, 699000, .39f),
            new Product("Cáp chuyển từ cổng USB sang PS2", R.drawable.dau_cam, 4f, 699000, .39f)
    );
}
