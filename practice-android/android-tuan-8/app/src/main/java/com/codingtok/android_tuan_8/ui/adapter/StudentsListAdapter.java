package com.codingtok.android_tuan_8.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.codingtok.android_tuan_8.data.Student;
import com.codingtok.android_tuan_8.databinding.LayoutItemStudentBinding;

public class StudentsListAdapter extends ListAdapter<Student, StudentsListAdapter.StudentsViewHolder> {

    private static final DiffUtil.ItemCallback<Student> diffCallback = new DiffUtil.ItemCallback<Student>() {
        @Override
        public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.equals(newItem);
        }
    };

    public StudentsListAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentsViewHolder(LayoutItemStudentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class StudentsViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemStudentBinding binding;

        public StudentsViewHolder(LayoutItemStudentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Student student) {
            binding.textName.setText(student.getName());
        }
    }
}
