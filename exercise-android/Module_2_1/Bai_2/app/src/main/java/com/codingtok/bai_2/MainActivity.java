package com.codingtok.bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codingtok.bai_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.convertToCelsius.setOnClickListener(view -> {
            double value = Double.parseDouble(binding.editTextFahrenheit.getText().toString());
            double rs = (value - 32) * 5 / 9;
            binding.editTextCelsius.setText(String.valueOf(rs));
        });

        binding.convertToFahrenheit.setOnClickListener(view -> {
            double value = Double.parseDouble(binding.editTextCelsius.getText().toString());
            double rs = value * 9 / 5 + 32;
            binding.editTextFahrenheit.setText(String.valueOf(rs));
        });

        binding.buttonClear.setOnClickListener(view -> {
            binding.editTextCelsius.setText("");
            binding.editTextFahrenheit.setText("");
        });
    }
}