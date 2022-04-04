package com.codingtok.exam_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingtok.exam_3.databinding.ItemProductBinding;

import java.text.DecimalFormat;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> products;
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    public ProductAdapter(List<Product> products, Context context, OnItemClickListener onItemClickListener) {
        this.products = products;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(products.get(position));
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.setItemClick(products.get(position), position);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private ItemProductBinding binding;

        public ProductViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.imageProduct.setImageResource(product.getImage());
            binding.nameProduct.setText(product.getName());
            DecimalFormat df = new DecimalFormat("#,##0 đ");
            binding.priceProduct.setText(df.format(product.getPrice()));
        }
    }
}
