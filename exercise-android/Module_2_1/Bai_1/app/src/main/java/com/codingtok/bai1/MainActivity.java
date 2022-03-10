package com.codingtok.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codingtok.bai1.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonTong.setOnClickListener(view -> {
            int a = Integer.parseInt(binding.editTextSoA.getText().toString());
            int b = Integer.parseInt(binding.editTextSoB.getText().toString());

            binding.textResult.setText(String.valueOf(Calculate.sum(a, b)));
        });

        binding.buttonHieu.setOnClickListener(view -> {
            int a = Integer.parseInt(binding.editTextSoA.getText().toString());
            int b = Integer.parseInt(binding.editTextSoB.getText().toString());

            binding.textResult.setText(String.valueOf(Calculate.diff(a, b)));
        });

        binding.buttonTich.setOnClickListener(view -> {
            int a = Integer.parseInt(binding.editTextSoA.getText().toString());
            int b = Integer.parseInt(binding.editTextSoB.getText().toString());

            binding.textResult.setText(String.valueOf(Calculate.prod(a, b)));
        });
        
        binding.buttonThuong.setOnClickListener(view -> {
            int a = Integer.parseInt(binding.editTextSoA.getText().toString());
            int b = Integer.parseInt(binding.editTextSoB.getText().toString());

            binding.textResult.setText(String.valueOf(Calculate.fac(a, b)));
        });
        
        binding.buttonUcln.setOnClickListener(view -> {
            int a = Integer.parseInt(binding.editTextSoA.getText().toString());
            int b = Integer.parseInt(binding.editTextSoB.getText().toString());

            binding.textResult.setText(String.valueOf(Calculate.ucln(a, b)));
        });

        binding.buttonExit.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}