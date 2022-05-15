package com.example.lab_04.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_04.data.model.Product;
import com.example.lab_04.databinding.LayoutItemProductBinding;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ShopViewHolder> {
    private final List<Product> products;

    public ListAdapter(List<Product> products) {
        this.products = products;
    }
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopViewHolder(LayoutItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ShopViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemProductBinding binding;
        public ShopViewHolder(@NonNull LayoutItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.setItem(product);
            binding.executePendingBindings();
        }
    }
}
