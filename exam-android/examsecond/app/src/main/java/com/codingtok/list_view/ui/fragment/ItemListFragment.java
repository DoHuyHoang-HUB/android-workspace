package com.codingtok.list_view.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingtok.list_view.R;
import com.codingtok.list_view.data.model.Employee;
import com.codingtok.list_view.databinding.FragmentItemListBinding;
import com.codingtok.list_view.ui.adapter.EmployeesListAdapter;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModel;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModelFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ItemListFragment extends Fragment {
    private FragmentItemListBinding binding;
    private EmployeesViewModel viewModel;
    private EmployeesListAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        binding = FragmentItemListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getViewModelStore(), new EmployeesViewModelFactory(requireContext())).get(EmployeesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        adapter = new EmployeesListAdapter(requireContext(), new EmployeesListAdapter.EmployeesListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(requireContext(), position, Toast.LENGTH_SHORT).show();
                NavDirections action = ItemListFragmentDirections.actionItemListFragmentToDetailFragment(position);
                Navigation.findNavController(viewParent).navigate(action);
            }
        });

        binding.floatingActionButton.setOnClickListener(view -> {
            NavDirections action = ItemListFragmentDirections.actionItemListFragmentToAddItemFragment(getString(R.string.create_new_employee));
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));

        viewModel.getEmployees().observe(getViewLifecycleOwner(), employees -> {
            adapter.submitList(employees);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}