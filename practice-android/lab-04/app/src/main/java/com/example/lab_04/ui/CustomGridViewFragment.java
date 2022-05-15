package com.example.lab_04.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_04.data.datasource.DataSource;
import com.example.lab_04.databinding.FragmentCustomGridViewBinding;
import com.example.lab_04.ui.adapter.GridAdapter;

public class CustomGridViewFragment extends Fragment {

    private FragmentCustomGridViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomGridViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridAdapter adapter = new GridAdapter(DataSource.productGridView);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
    }
}