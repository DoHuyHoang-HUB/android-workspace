package com.codingtok.bai5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.codingtok.bai5.databinding.ActivityMainBinding;
import com.codingtok.bai5.model.Customer;
import com.codingtok.bai5.viewmodel.SellBookAndStatisticalViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SellBookAndStatisticalViewModel viewModel;
    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(SellBookAndStatisticalViewModel.class);

        binding.setMainActivity(this);
    }

    public void tinhThanhTien() {
        customer = new Customer(
                binding.inputTenKhachHang.getText().toString(),
                Integer.parseInt(binding.inputSoLuongSach.getText().toString()),
                binding.checkboxVip.isChecked()
        );

        binding.thanhTien.setText(String.valueOf(customer.getTotal()));
    }

    public void addCustomer() {
        if (customer != null) {
            viewModel.addCustomer(customer);
            binding.inputTenKhachHang.setText(null);
            binding.inputSoLuongSach.setText(null);
            binding.checkboxVip.setChecked(false);
            binding.thanhTien.setText(null);
            customer = null;
        } else {
            Toast.makeText(this, "Nhập dữ liệu khách hàng!", Toast.LENGTH_SHORT).show();
        }
    }

    public void thongKe() {
        binding.inputTongSoKh.setText(String.valueOf(viewModel.getCustomers().getValue().size()));
        binding.inputTongKhLaVip.setText(viewModel.totalCustomerVip());
        binding.inputTongDoanhThu.setText(viewModel.totalRevenue());
    }
}