package com.codingtok.list_view.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.codingtok.list_view.R;
import com.codingtok.list_view.data.model.Employee;
import com.codingtok.list_view.databinding.ItemListItemBinding;

public class EmployeesListAdapter extends ListAdapter<Employee, EmployeesListAdapter.EmployeesViewHolder> {

    private static final DiffUtil.ItemCallback<Employee> diffCallback = new DiffUtil.ItemCallback<Employee>() {
        @Override
        public boolean areItemsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.equals(newItem);
        }
    };

    private final Context context;
    private final EmployeesListener employeesListener;

    public EmployeesListAdapter(Context context, EmployeesListener employeesListener) {
        super(diffCallback);
        this.context = context;
        this.employeesListener = employeesListener;
    }

    @NonNull
    @Override
    public EmployeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeesViewHolder(ItemListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesViewHolder holder, int position) {
        Employee employee = getItem(position);
        holder.bind(employee, context);
        holder.itemView.setOnClickListener(view -> {
            employeesListener.onClick(position);
        });
    }

    public static class EmployeesViewHolder extends RecyclerView.ViewHolder {
        private final ItemListItemBinding binding;
        public EmployeesViewHolder(ItemListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Employee employee, Context context) {
            binding.id.setText(context.getResources().getString(R.string.id, employee.getId()));
            binding.name.setText(context.getResources().getString(R.string.name, employee.getName()));
            binding.department.setText(context.getResources().getString(R.string.department, employee.getDepartment()));
            binding.gender.setText(context.getResources().getString(R.string.gender, convertGenderText(employee.isGender())));
            binding.imageAvatar.setImageBitmap(getEmployeeImage(employee.getImage()));
        }

        private Bitmap getEmployeeImage(String encodedImage) {
            byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }

        private String convertGenderText(boolean gender) {
            return gender ? "Nữ":"Nam";
        }
    }

    public interface EmployeesListener {
        public void onClick(int position);
    }
}
