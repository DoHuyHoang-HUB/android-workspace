package com.example.lab_04.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_04.data.datasource.DataSource;
import com.example.lab_04.databinding.FragmentCustomListViewBinding;
import com.example.lab_04.ui.adapter.ListAdapter;

public class CustomListViewFragment extends Fragment {

    private FragmentCustomListViewBinding binding;
    private ListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomListViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListAdapter adapter = new ListAdapter(DataSource.products);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
    }
}