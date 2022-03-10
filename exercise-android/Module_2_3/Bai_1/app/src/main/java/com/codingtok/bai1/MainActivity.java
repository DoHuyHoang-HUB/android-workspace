package com.codingtok.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.codingtok.bai1.adapter.EmployeeAdapter;
import com.codingtok.bai1.databinding.ActivityMainBinding;
import com.codingtok.bai1.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Employee> employees;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        employees = new ArrayList<>();
        adapter = new EmployeeAdapter(this, R.layout.item_container, employees);

        binding.listView.setAdapter(adapter);

        binding.buttonNhapNv.setOnClickListener(view -> {
            xuLyNhap();
        });

        binding.buttonDelete.setOnClickListener(view -> {
            xuLyXoa();
        });
    }

    private void xuLyNhap() {
        boolean gender = false;
        if (binding.genderGroup.getCheckedRadioButtonId() == R.id.rad_nu) gender = true;

        Employee employee = new Employee();
        employee.setId(binding.inputMaNv.getText() + "");
        employee.setName(binding.inputTenNv.getText() + "");
        employee.setGender(gender);

        employees.add(employee);

        adapter.notifyDataSetChanged();
    }

    private void xuLyXoa() {
        for (int i = binding.listView.getChildCount() - 1; i >= 0; i--) {
            View view = binding.listView.getChildAt(i);
            CheckBox chk = (CheckBox) view.findViewById(R.id.checkbox_select);
            if (chk.isSelected())
                employees.remove(i);
        }

        adapter.notifyDataSetChanged();
    }
}