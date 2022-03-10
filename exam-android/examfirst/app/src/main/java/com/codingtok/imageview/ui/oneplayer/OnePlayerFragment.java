package com.codingtok.imageview.ui.oneplayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtok.imageview.R;
import com.codingtok.imageview.data.DataSource;
import com.codingtok.imageview.databinding.FragmentOnePlayerBinding;

import java.util.List;

public class OnePlayerFragment extends Fragment {

    private FragmentOnePlayerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnePlayerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        List<Integer> data = DataSource.DATA;

        binding.button.setOnClickListener(view -> {
            int[] baSoNgauNhien = layBaSoNgauNhien(0, 51);
            binding.imageView1.setImageResource(data.get(baSoNgauNhien[0]));
            binding.imageView2.setImageResource(data.get(baSoNgauNhien[1]));
            binding.imageView3.setImageResource(data.get(baSoNgauNhien[2]));
            binding.result.setText(tongSoNut(baSoNgauNhien));
        });
    }

    private String tongSoNut(int[] arr) {
        String ketQua = "";
        if (tinhSoTay(arr) == 3) {
            ketQua = "Kết quả ba tây";
        }
        else {
            int tong = 0;
            for (int i: arr)
                if (i % 13 < 10)
                    tong += i % 13 + 1;
            if (tong % 10 == 0) {
                ketQua = "Kết quả bù, số tây là " + tinhSoTay(arr);
            } else {
                ketQua = "Kết quả là " + (tong % 10) + " nút, số tây là " + tinhSoTay(arr);
            }
        }
        return ketQua;
    }

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i: arr) {
            if (i % 13 >= 10)
                k++;
        }
        return k;
    }

    private int[] layBaSoNgauNhien(int min, int max) {
        int[] baso = new int[3];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (kiemTraTrung(k, baso))
                baso[i++] = k;
        } while (i < 3);
        return baso;
    }


    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return false;
        }
        return true;
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}