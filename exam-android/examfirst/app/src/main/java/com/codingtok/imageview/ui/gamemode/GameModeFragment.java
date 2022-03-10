package com.codingtok.imageview.ui.gamemode;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.imageview.R;
import com.codingtok.imageview.databinding.FragmentGameModeBinding;

public class GameModeFragment extends Fragment {

    private FragmentGameModeBinding binding;
    private String valueTime;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameModeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        binding.buttonOnePlayer.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_gameModeFragment_to_onePlayerFragment);
        });

        binding.buttonTwoPlayer.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_gameModeFragment_to_twoPlayerFragment);
        });

        binding.buttonAutoGame.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_gameModeFragment_to_autoGameFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}