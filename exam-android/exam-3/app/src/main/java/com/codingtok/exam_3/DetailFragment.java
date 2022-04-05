package com.codingtok.exam_3;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

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
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {

        if (product != null) {
            bind(product);
        }

        binding.buttonBack.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            binding.appbarlayout.setOutlineSpotShadowColor(getResources().getColor(R.color.color_translucent));
        }
        binding.scroll.setSmoothScrollingEnabled(true);
        binding.scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 100) {
                    binding.toolbar.setBackgroundColor(getResources().getColor(R.color.white));
                    binding.buttonBack.setBackground(null);
                    binding.buttonCart.setBackground(null);
                    binding.buttonDot.setBackground(null);
                    binding.imageBack.setColorFilter(getResources().getColor(R.color.purple_200));
                    binding.imageCart.setColorFilter(getResources().getColor(R.color.purple_200));
                    binding.imageDot.setColorFilter(getResources().getColor(R.color.purple_200));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        binding.appbarlayout.setOutlineSpotShadowColor(getResources().getColor(R.color.black));
                    }
                } else {
                    binding.toolbar.setBackgroundColor(getResources().getColor(R.color.color_translucent));
                    binding.buttonBack.setBackground(getResources().getDrawable(R.drawable.background_oval));
                    binding.buttonCart.setBackground(getResources().getDrawable(R.drawable.background_oval));
                    binding.buttonDot.setBackground(getResources().getDrawable(R.drawable.background_oval));
                    binding.imageBack.setColorFilter(getResources().getColor(R.color.white));
                    binding.imageCart.setColorFilter(getResources().getColor(R.color.white));
                    binding.imageDot.setColorFilter(getResources().getColor(R.color.white));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        binding.appbarlayout.setOutlineSpotShadowColor(getResources().getColor(R.color.color_translucent));
                    }
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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