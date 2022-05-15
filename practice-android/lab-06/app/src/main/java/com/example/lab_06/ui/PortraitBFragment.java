package com.example.lab_06.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_06.data.model.Shoes;
import com.example.lab_06.databinding.FragmentPortraitBBinding;

public class PortraitBFragment extends Fragment {

    public static final String SHOES_PARAM = "shoes param";
    private FragmentPortraitBBinding binding;
    private Shoes shoes;

    public static PortraitBFragment newInstance(Shoes shoes) {
        PortraitBFragment fragment = new PortraitBFragment();
        Bundle args = new Bundle();
        args.putSerializable(SHOES_PARAM, shoes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            shoes = (Shoes) getArguments().getSerializable(SHOES_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPortraitBBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (shoes != null) {
            bind(shoes);
        }
    }

    private void bind(Shoes shoes) {
        if (shoes != null) {
            binding.imageShoes.setImageResource(shoes.getImage());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}