package com.codingtok.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codingtok.bai4.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private ActivityMainBinding binding;
    private List<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myList);
        setListAdapter(adapter);

        binding.buttonNhap.setOnClickListener(view -> {
            myList.add(binding.inputNhapTen.getText() + "");
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        binding.textSelected.setText("positioin: " + position + "; value = " + item);
    }
}