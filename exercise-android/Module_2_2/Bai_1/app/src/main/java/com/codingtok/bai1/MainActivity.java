package com.codingtok.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton buttonShowToast = findViewById(R.id.button_show_toast);
        buttonShowToast.setOnClickListener(view -> {
            Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
        });
    }
}