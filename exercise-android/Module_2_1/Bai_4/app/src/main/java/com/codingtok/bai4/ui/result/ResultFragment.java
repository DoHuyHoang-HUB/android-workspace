package com.codingtok.bai4.ui.result;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.bai4.R;
import com.codingtok.bai4.databinding.FragmentResultBinding;
import com.codingtok.bai4.ui.viewmodels.PersonViewModel;

public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    private PersonViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(PersonViewModel.class);

        binding.setResultFragment(this);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);
    }

    public void onInputAgainClick() {
        viewModel.reset();
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_resultFragment_to_inputFragment);
    }
}