package com.codingtok.imageview.ui.twoplayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.codingtok.imageview.R;
import com.codingtok.imageview.data.DataSource;
import com.codingtok.imageview.databinding.FragmentTwoPlayerBinding;

import java.util.ArrayList;
import java.util.List;

public class TwoPlayerFragment extends Fragment {

    private FragmentTwoPlayerBinding binding;
    private int currentPlay = 0;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTwoPlayerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        List<Integer> data = DataSource.DATA;
        binding.buttonStartGame.setOnClickListener(view -> {
            if (currentPlay < 3) {
                binding.result.setText("");
                int[] rut6LaNgauNhien = laySauSoNgauNhien(0, 51);
                int[] baLaNguoiChoi1 = new int[3];
                int[] baLaNguoiChoi2 = new int[3];
                for (int i = 0; i < 3; i++) {
                    baLaNguoiChoi1[i] = rut6LaNgauNhien[i];
                }
                for (int i = 3; i < 6; i++) {
                    baLaNguoiChoi2[i - 3] = rut6LaNgauNhien[i];
                }
                binding.card1Player1.setImageResource(data.get(baLaNguoiChoi1[0]));
                binding.card2Player1.setImageResource(data.get(baLaNguoiChoi1[1]));
                binding.card3Player1.setImageResource(data.get(baLaNguoiChoi1[2]));
                binding.card1Player2.setImageResource(data.get(baLaNguoiChoi2[0]));
                binding.card2Player2.setImageResource(data.get(baLaNguoiChoi2[1]));
                binding.card3Player2.setImageResource(data.get(baLaNguoiChoi2[2]));

                int soNutNguoiChoi1 = tongSoNut(baLaNguoiChoi1);
                int soNutNguoiChoi2 = tongSoNut(baLaNguoiChoi2);
                binding.resultPlayer1.setText(result(soNutNguoiChoi1, baLaNguoiChoi1));
                binding.resultPlayer2.setText(result(soNutNguoiChoi2, baLaNguoiChoi2));

                System.out.println(soNutNguoiChoi1);
                System.out.println(soNutNguoiChoi2);
                if (soNutNguoiChoi1 > soNutNguoiChoi2) {
                    scorePlayer1++;
                } else if (soNutNguoiChoi1 < soNutNguoiChoi2) {
                    scorePlayer2++;
                } else {
                    displayResult("Hòa");
                }
                binding.textTiSo.setText(scorePlayer1 + "-" + scorePlayer2);
                binding.textButtonStartGame.setText("Tiếp tục");
                currentPlay++;
            } else if (currentPlay == 3) {
                if (scorePlayer1 > scorePlayer2) {
                    displayResult("Người chơi 1 win");
                } else if (scorePlayer1 < scorePlayer2) {
                    displayResult("Người chơi 2 win");
                } else {
                    displayResult("Hòa");
                }
                binding.resultPlayer1.setText("");
                binding.resultPlayer2.setText("");
                binding.textButtonStartGame.setText("Chơi lại");
                currentPlay++;
            } else {
                reset();
            }
        });
    }

    private void displayResult(String message) {
        binding.result.setText(message);
        Animation anim = AnimationUtils.loadAnimation(requireContext(), R.anim.enter_scale_anim);
        anim.reset();
        binding.result.setVisibility(View.VISIBLE);
        binding.result.clearAnimation();
        binding.result.startAnimation(anim);
    }

    private void reset() {
        binding.textTiSo.setText("0-0");
        binding.result.setVisibility(View.GONE);
        currentPlay = 0;
        scorePlayer2 = 0;
        scorePlayer1 = 0;
        binding.textButtonStartGame.setText("Bắt đầu");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private String result(int soNut, int[] arr) {
        String ketQua = "";
        if (soNut == 30) {
            ketQua = "Kết quả 3 tây";
        } else if (soNut == 0) {
            ketQua = "Kết quả bù, số tây là " + tinhSoTay(arr);
        } else {
            ketQua = "Kết quả là " + soNut + " nút, số tây là " + tinhSoTay(arr);
        }
        return ketQua;
    }


    private int tongSoNut(int[] arr) {
        int ketQua = 0;
        if (tinhSoTay(arr) == 3) {
            ketQua = 30;
        }
        else {
            int tong = 0;
            for (int i: arr)
                if (i % 13 < 10)
                    tong += i % 13 + 1;
            if (tong % 10 != 0) {
                ketQua = tong % 10;
            }
        }
        return ketQua;
    }

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i : arr) {
            if (i % 13 >= 10)
                k++;
        }
        return k;
    }

    private int[] laySauSoNgauNhien(int min, int max) {
        int[] baso = new int[6];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (kiemTraTrung(k, baso))
                baso[i++] = k;
        } while (i < 6);
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
}