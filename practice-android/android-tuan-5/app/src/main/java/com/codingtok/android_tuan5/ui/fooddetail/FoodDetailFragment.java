package com.codingtok.android_tuan5.ui.fooddetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingtok.android_tuan5.R;
import com.codingtok.android_tuan5.data.Food;
import com.codingtok.android_tuan5.databinding.FragmentFoodDetailBinding;


public class FoodDetailFragment extends Fragment {

    private FragmentFoodDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodDetailBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Food food = FoodDetailFragmentArgs.fromBundle(getArguments()).getFood();

        bind(food);

    }

    private void bind(Food food) {
        binding.nameFood.setText(food.getNameFood());
        binding.descriptionFood.setText(food.getDescription());
        binding.priceFood.setText(getString(R.string.price_food, food.getPrice()));
        binding.imageFood.setImageResource(food.getImageFood());
    }
}