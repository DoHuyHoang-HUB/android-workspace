package com.codingtok.lab_07.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codingtok.lab_07.data.StudentDao;

public class StudentViewModelFactory implements ViewModelProvider.Factory {
    private final StudentDao studentDao;

    public StudentViewModelFactory(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StudentViewModel.class)) {
            return (T) new StudentViewModel(studentDao);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
