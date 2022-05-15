package com.example.lab_04.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_04.R;
import com.example.lab_04.databinding.FragmentSelectBinding;

public class SelectFragment extends Fragment {

    private FragmentSelectBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);
        binding.buttonCustomListView.setOnClickListener(view -> {
            Navigation.findNavController(viewParent).navigate(R.id.action_selectFragment_to_customListViewFragment);
        });

        binding.buttonCustomGridView.setOnClickListener(view -> {
            Navigation.findNavController(viewParent).navigate(R.id.action_selectFragment_to_customGridViewFragment);
        });
    }
}