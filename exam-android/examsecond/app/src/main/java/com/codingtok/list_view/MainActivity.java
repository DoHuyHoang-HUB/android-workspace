package com.codingtok.list_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.codingtok.list_view.data.model.Employee;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModel;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    public MainActivity() {
        super(R.layout.activity_main);
    }

    private EmployeesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(getViewModelStore(), new EmployeesViewModelFactory(this)).get(EmployeesViewModel.class);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}