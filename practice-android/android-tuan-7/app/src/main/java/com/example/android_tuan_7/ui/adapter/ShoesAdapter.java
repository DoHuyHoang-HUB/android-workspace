package com.example.android_tuan_7.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_tuan_7.R;
import com.example.android_tuan_7.data.model.Shoes;
import com.example.android_tuan_7.databinding.ItemShoesBinding;

import java.util.List;

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder> {

    private final List<Shoes> shoesList;
    private final OnItemClickListener onItemClickListener;
    private final Context context;

    public ShoesAdapter(List<Shoes> shoesList, OnItemClickListener onItemClickListener,@NonNull Context context) {
        this.shoesList = shoesList;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ShoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShoesViewHolder(ItemShoesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoesViewHolder holder, int position) {
        holder.bind(shoesList.get(position));
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(shoesList.get(position), position);
        });
    }

    @Override
    public int getItemCount() {
        return shoesList.size();
    }

    class ShoesViewHolder extends RecyclerView.ViewHolder {

        private ItemShoesBinding binding;
        public ShoesViewHolder(@NonNull ItemShoesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Shoes shoes) {
            binding.imageShoes.setImageResource(shoes.getImage());
            binding.nameShoes.setText(shoes.getName());
        }
    }
}
