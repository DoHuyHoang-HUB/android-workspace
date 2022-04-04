package com.codingtok.exam_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.exam_3.databinding.FragmentGridViewBinding;

public class GridViewFragment extends Fragment {

    private FragmentGridViewBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGridViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MyCommunicator myCommunicator = (MyCommunicator) requireContext();


        ProductAdapter adapter = new ProductAdapter(DataSource.DATA, requireContext(),
                (product, position) -> {
                    myCommunicator.displayDetail(product);
                });

        binding.gridView.setHasFixedSize(true);
        binding.gridView.setAdapter(adapter);

        if (!getResources().getBoolean(R.bool.isPhone)) {
            myCommunicator.displayDetail(DataSource.DATA.get(0));
        }
    }
}