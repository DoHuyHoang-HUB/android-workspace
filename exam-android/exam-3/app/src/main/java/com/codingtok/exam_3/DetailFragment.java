package com.codingtok.exam_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.exam_3.databinding.FragmentDetailBinding;

import java.text.DecimalFormat;

public class DetailFragment extends Fragment {

    public static final String PRODUCT_PARAM = "product param";
    private FragmentDetailBinding binding;

    private Product product;

    public static DetailFragment newInstance(Product product) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRODUCT_PARAM, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            product = (Product) getArguments().getSerializable(PRODUCT_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (product != null) {
            bind(product);
        }
    }

    private void bind(Product product) {
        binding.imageProduct.setImageResource(product.getImage());
        binding.nameProduct.setText(product.getName());
        DecimalFormat df = new DecimalFormat("#,##0 đ");
        binding.priceProduct.setText(df.format(product.getPrice()));
    }
}