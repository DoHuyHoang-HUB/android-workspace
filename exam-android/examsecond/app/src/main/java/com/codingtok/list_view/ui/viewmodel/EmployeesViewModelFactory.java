package com.codingtok.list_view.ui.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import kotlin.Suppress;

public class EmployeesViewModelFactory implements ViewModelProvider.Factory {

    private Context context;

    public EmployeesViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(EmployeesViewModel.class)) {
            return (T) new EmployeesViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
