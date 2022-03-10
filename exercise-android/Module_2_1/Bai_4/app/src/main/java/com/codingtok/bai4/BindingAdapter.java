package com.codingtok.bai4;

import android.widget.TextView;

import java.util.List;


public class BindingAdapter {
    @androidx.databinding.BindingAdapter("app:listData")
    public static void bindTextList(TextView textView, List<String> data) {
        String interests = "";
        for (String interest : data
        ) {
            if (data.get(data.size() - 1).equals(interest)) {
                interests += interest;
            } else {
                interests += interest + ", ";
            }

        }
        textView.setText(interests);
    }
}
