package com.codingtok.bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.codingtok.bai5.databinding.ActivityMainBinding;
import com.codingtok.bai5.model.Employee;
import com.codingtok.bai5.model.EmployeePFullTime;
import com.codingtok.bai5.model.EmployeePartTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayAdapter<Employee> adapter;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Employee> listLv = new ArrayList<>();

        adapter = new ArrayAdapter<Employee>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listLv);

        binding.listView.setAdapter(adapter);

        binding.buttonNhapNv.setOnClickListener(view -> {
            addNv();
        });
    }

    private void addNv() {
        if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_chinh_thuc) {
            employee = new EmployeePFullTime();
        } else {
            employee = new EmployeePartTime();
        }
        employee.setId(binding.inputMaNv.getText() + "");
        employee.setName(binding.inputTenNv.getText() + "");

        adapter.add(employee);

        adapter.notifyDataSetChanged();
    }
}