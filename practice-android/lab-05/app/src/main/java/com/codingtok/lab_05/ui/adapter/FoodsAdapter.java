package com.codingtok.lab_05.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingtok.lab_05.R;
import com.codingtok.lab_05.data.Food;
import com.codingtok.lab_05.databinding.ItemFoodBinding;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodViewHolder> {

    private final List<Food> foodList;
    private final OnItemClickListener onItemClickListener;
    private final Context context;

    public FoodsAdapter(Context context, List<Food> foodList, OnItemClickListener onItemClickListener) {
        this.foodList = foodList;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodBinding binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.bind(food, context);
        holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onItemClick(food);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        private final ItemFoodBinding binding;

        public FoodViewHolder(ItemFoodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Food item, Context context) {
            binding.imageFood.setImageResource(item.getImageFood());
            binding.nameFood.setText(item.getNameFood());
            binding.descriptionFood.setText(item.getDescription());
            binding.priceFood.setText(context.getResources().getString(R.string.price_food, item.getPrice()));
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(Food food);
    }
}
