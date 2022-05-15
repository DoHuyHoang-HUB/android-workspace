package com.example.lab_06.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_06.R;
import com.example.lab_06.data.model.DataSource;
import com.example.lab_06.databinding.FragmentPortraitABinding;
import com.example.lab_06.ui.adapter.ShoesAdapter;
import com.example.lab_06.ui.widget.MyCommunicator;

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

        MyCommunicator myCommunicator = (MyCommunicator) requireContext();

        ShoesAdapter adapter = new ShoesAdapter(DataSource.DATA, (shoes, position) -> {
            myCommunicator.displayDetail(shoes);
        }, requireContext());

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setAdapter(adapter);

        if (!getResources().getBoolean(R.bool.isPhone)) {
            myCommunicator.displayDetail(DataSource.DATA.get(0));
        }
    }
}