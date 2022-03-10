package com.codingtok.imageview.ui.start;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.imageview.R;
import com.codingtok.imageview.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        binding.buttonStartGame.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_startFragment_to_gameModeFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}