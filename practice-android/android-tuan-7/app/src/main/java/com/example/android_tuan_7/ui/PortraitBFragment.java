package com.example.android_tuan_7.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_tuan_7.R;
import com.example.android_tuan_7.data.model.Shoes;
import com.example.android_tuan_7.databinding.FragmentPortraitBBinding;

public class PortraitBFragment extends Fragment {

    private PortraitBFragmentArgs navArgs;
    private FragmentPortraitBBinding binding;
    private Shoes shoes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPortraitBBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navArgs = PortraitBFragmentArgs.fromBundle(getArguments());

        shoes = navArgs.getShoes();

        bind(shoes);
    }

    private void bind(Shoes shoes) {
        if (shoes != null) {
            binding.imageShoes.setImageResource(shoes.getImage());
        }
    }
}