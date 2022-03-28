package com.example.android_tuan_7.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_tuan_7.R;
import com.example.android_tuan_7.databinding.FragmentTikiBinding;

public class TikiFragment extends Fragment {

    private FragmentTikiBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTikiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {

        binding.buttonDatHang.setOnClickListener(view -> {
            Navigation.findNavController(viewParent).navigate(R.id.action_tikiFragment_to_portraitAFragment);
        });
    }
}