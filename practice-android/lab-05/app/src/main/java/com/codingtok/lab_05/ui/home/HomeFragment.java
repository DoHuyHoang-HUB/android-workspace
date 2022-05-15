package com.codingtok.lab_05.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.lab_05.data.DataSource;
import com.codingtok.lab_05.data.Food;
import com.codingtok.lab_05.databinding.FragmentHomeBinding;
import com.codingtok.lab_05.ui.adapter.FoodsAdapter;

import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Food> foodList = DataSource.foodList;
        FoodsAdapter adapter = new FoodsAdapter(requireContext(), foodList, new FoodsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Food food) {
                NavDirections action = HomeFragmentDirections.actionHomeFragmentToFoodDetailFragment(food);
                Navigation.findNavController(view).navigate(action);
            }
        });

        binding.recyclerview.setAdapter(adapter);

        binding.recyclerview.setHasFixedSize(true);
    }
}