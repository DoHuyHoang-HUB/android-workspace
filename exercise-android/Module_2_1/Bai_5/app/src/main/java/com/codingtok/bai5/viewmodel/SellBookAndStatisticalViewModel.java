package com.codingtok.bai5.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingtok.bai5.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class SellBookAndStatisticalViewModel extends ViewModel {
    private final MutableLiveData<List<Customer>> customers = new MutableLiveData<List<Customer>>();

    public SellBookAndStatisticalViewModel() {
        customers.setValue(new ArrayList<>());
    }

    public LiveData<List<Customer>> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers.setValue(customers);
    }

    public void addCustomer(Customer customer) {
        this.customers.getValue().add(customer);
    }

    public String totalCustomerVip() {
        int count = 0;
        for (Customer cus : customers.getValue()
        ) {
            if (cus.isVip()) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    public String totalRevenue() {
        double total = 0;
        for (Customer cus : customers.getValue()
        ) {
            total += cus.getTotal();
        }
        return String.valueOf(total);
    }
}
