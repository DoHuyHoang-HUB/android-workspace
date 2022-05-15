package com.codingtok.dohuyhoang_19496411.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.codingtok.dohuyhoang_19496411.R;
import com.codingtok.dohuyhoang_19496411.databinding.ActivitySignUpBinding;
import com.codingtok.dohuyhoang_19496411.model.User;
import com.codingtok.dohuyhoang_19496411.util.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.buttonSignUp.setOnClickListener(view -> {
            registerAccount();
        });

        binding.linkLogin.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private void registerAccount() {
        if (validate()) {
            FirebaseFirestore database = FirebaseFirestore.getInstance();

            User user = new User();
            Map<String, Object> users = new HashMap<>();
            users.put(Constants.KEY_NAME, binding.nameInput.getText().toString());
            users.put(Constants.KEY_EMAIL, binding.emailInput.getText().toString());
            users.put(Constants.KEY_PASSWORD, binding.passwordInput.getText().toString());

            mAuth.createUserWithEmailAndPassword(binding.emailInput.getText().toString(), binding.passwordInput.getText().toString())
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            database.collection(Constants.KEY_COLLECTION_USER).add(users);
                            showToast("Register user success!");
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            showToast("Authentication failed");
                        }
                    });
        }
    }

    private boolean validate() {
        if (binding.nameInput.getText().toString().trim().isEmpty()) {
            showToast("Enter your name");
            return false;
        } else if (binding.emailInput.getText().toString().trim().isEmpty()) {
            showToast("Enter email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailInput.getText().toString()).matches()) {
            showToast("Enter valid email");
            return false;
        } else if (binding.passwordInput.getText().toString().trim().isEmpty()) {
            showToast("Enter password");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

//    else if (binding.repasswordInput.getText().toString().trim().isEmpty()) {
//        showToast("Confirm your password");
//        return false;
//    }
//    else if (!binding.passwordInput.getText().toString().equals(binding.repasswordInput.getText().toString())) {
//        showToast("Password & confirm password must be sames");
//        return false;
//    }
}