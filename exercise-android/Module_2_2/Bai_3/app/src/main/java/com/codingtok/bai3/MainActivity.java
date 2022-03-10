package com.codingtok.bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.codingtok.bai3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<String> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myList);

        binding.listView.setAdapter(adapter);

        binding.buttonNhap.setOnClickListener(view -> {
            String value = binding.inputNhapTen.getText().toString();
            myList.add(value);
            adapter.notifyDataSetChanged();
        });

        binding.listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String value = binding.listView.getItemAtPosition(i).toString();
            binding.textSelected.setText("positioin: " + i + "; value = " + value);
        });
    }
}