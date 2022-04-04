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
import java.text.DecimalFormatSymbols;

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
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0 đ", otherSymbols);
        binding.priceProduct.setText(df.format(product.getPrice()));
        binding.ratingBar.setRating(product.getRating());
        binding.reviewProduct.setText(getResources().getString(R.string.review, product.getReviews()));
        binding.soldProduct.setText(getResources().getString(R.string.sold, product.getSold()));
        binding.traderMarkProdct.setText(product.getTraderMark());
        binding.originProduct.setText(product.getOrigin());
        binding.descriptionProduct.setText(product.getDescription());
    }
}