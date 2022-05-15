package com.codingtok.lab_07.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.lab_07.BasicSQLiteApplication;
import com.codingtok.lab_07.R;
import com.codingtok.lab_07.databinding.FragmentBasicSqliteBinding;
import com.codingtok.lab_07.ui.adapter.StudentsListAdapter;
import com.codingtok.lab_07.ui.viewmodel.StudentViewModel;
import com.codingtok.lab_07.ui.viewmodel.StudentViewModelFactory;

public class BasicSQLiteFragment extends Fragment {

    private FragmentBasicSqliteBinding binding;
    private StudentViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBasicSqliteBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this, new StudentViewModelFactory(((BasicSQLiteApplication) requireActivity().getApplication()).getDatabase().studentDao())).get(StudentViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {

        StudentsListAdapter adapter = new StudentsListAdapter();

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(view -> {
            addStudent();
        });

        viewModel.getStudents().observe(getViewLifecycleOwner(), students -> {
            if (students != null) {
                adapter.submitList(students);
            }
        });

    }

    private void addStudent() {
        viewModel.addNewStudent(binding.editTextName.getText().toString());
        binding.editTextName.setText(null);
    }
}