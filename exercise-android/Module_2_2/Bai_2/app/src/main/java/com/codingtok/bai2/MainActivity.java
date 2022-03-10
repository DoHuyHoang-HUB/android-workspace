package com.codingtok.bai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.codingtok.bai2.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogin.setOnClickListener(view -> {
            if (binding.checkboxSave.isChecked()) {
                Toast.makeText(this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonExit.setOnClickListener(view -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(view.getContext());
            builder.setMessage(getResources().getString(R.string.message_dialog_exit));
            builder.setTitle(getResources().getString(R.string.message_dialog_exit_title));
            builder.setIcon(R.drawable.ic_alert);
            builder.setPositiveButton(getResources().getString(R.string.message_dialog_ok),
                    (dialogInterface, i) -> {
                        dialogInterface.dismiss();
                        finish();
                    }
            );
            builder.setNegativeButton(getResources().getString(R.string.message_dialog_cancel),
                    (dialogInterface, i) -> {
                        dialogInterface.cancel();
                    }
            );

            AlertDialog dialogs = builder.create();
            dialogs.show();
        });
    }
}