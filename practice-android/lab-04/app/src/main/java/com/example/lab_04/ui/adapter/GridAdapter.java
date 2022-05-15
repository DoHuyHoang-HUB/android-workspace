package com.example.lab_04.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_04.data.model.Product;
import com.example.lab_04.databinding.LayoutItemProductGridViewBinding;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private final List<Product> products;

    public GridAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutItemProductGridViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    static class GridViewHolder extends RecyclerView.ViewHolder {

        private final LayoutItemProductGridViewBinding binding;

        public GridViewHolder(@NonNull LayoutItemProductGridViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.setItem(product);
            binding.executePendingBindings();
        }
    }
}
