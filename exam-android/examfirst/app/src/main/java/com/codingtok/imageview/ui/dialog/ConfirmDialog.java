package com.codingtok.imageview.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.codingtok.imageview.databinding.DialogConfirmBinding;

public class ConfirmDialog extends AlertDialog {

    private ConfirmListener confirmListener;
    private DialogConfirmBinding binding;

    public interface ConfirmListener {
        boolean confirm(String value);
        void cancel();
    }

    public ConfirmDialog(Context context, ConfirmListener confirmListener) {
        super(context);
        this.confirmListener = confirmListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogConfirmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        binding.inputTime.requestFocus();

        binding.buttonConfirm.setOnClickListener(view -> { if (confirmListener.confirm(binding.inputTime.getText().toString())) dismiss(); });
        binding.buttonHuy.setOnClickListener(view -> { dismiss(); confirmListener.cancel(); });
    }
}
