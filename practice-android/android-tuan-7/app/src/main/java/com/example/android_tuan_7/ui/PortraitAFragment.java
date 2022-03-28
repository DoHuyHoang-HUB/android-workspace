package com.example.android_tuan_7.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_tuan_7.R;
import com.example.android_tuan_7.data.model.DataSource;
import com.example.android_tuan_7.data.model.Shoes;
import com.example.android_tuan_7.databinding.FragmentPortraitABinding;
import com.example.android_tuan_7.ui.adapter.OnItemClickListener;
import com.example.android_tuan_7.ui.adapter.ShoesAdapter;

public class PortraitAFragment extends Fragment {

    private FragmentPortraitABinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPortraitABinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShoesAdapter adapter = new ShoesAdapter(DataSource.DATA, (shoes, position) -> {
            NavDirections action = PortraitAFragmentDirections.actionPortraitAFragmentToPortraitBFragment(shoes);
            Navigation.findNavController(view).navigate(action);
        }, requireContext());

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setAdapter(adapter);
    }
}