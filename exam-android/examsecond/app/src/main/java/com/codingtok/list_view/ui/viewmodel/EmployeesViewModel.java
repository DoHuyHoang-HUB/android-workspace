package com.codingtok.list_view.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingtok.list_view.data.model.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeesViewModel extends ViewModel {
    private static final String TAG = "EmployeesViewModel";
    private final MutableLiveData<List<Employee>> employees = new MutableLiveData<>();

    public EmployeesViewModel() {
        employees.postValue(new ArrayList<>());
    }

    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.getValue() != null) {
            List<Employee> employees = this.employees.getValue();
            employees.add(employee);
            this.employees.setValue(employees);
            return;
        }
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        this.employees.setValue(employees);
    }

    public Employee getEmployee(int position) {
        return this.employees.getValue().get(position);
    }

    public void deleteEmployee(int position) {
        employees.getValue().remove(position);
    }

}
