package com.codingtok.bai1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.codingtok.bai1.R;
import com.codingtok.bai1.model.Employee;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Activity context;
    private List<Employee> employees;
    private int layoutId;

    public EmployeeAdapter(@NonNull Activity context, int textViewResourceId, @NonNull List<Employee> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.employees = objects;
    }

    public View getView(int position, View contentView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        contentView = inflater.inflate(layoutId, null);

        if (employees.size() > 0 && position >= 0) {
            final TextView txtDisplay = (TextView) contentView.findViewById(R.id.id_name);
            final Employee emp = employees.get(position);
            txtDisplay.setText(emp.toString());
            final ImageView imgItem = (ImageView) contentView.findViewById(R.id.image_gender);
            imgItem.setImageResource(emp.isGender() ? R.drawable.ic_female: R.drawable.ic_male);
        }

        return contentView;
    }
}
