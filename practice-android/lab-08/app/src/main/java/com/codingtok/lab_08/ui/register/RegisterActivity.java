package com.codingtok.lab_08.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codingtok.lab_08.MainActivity;
import com.codingtok.lab_08.databinding.ActivityRegisterBinding;
import com.codingtok.lab_08.model.User;
import com.codingtok.lab_08.util.Constants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.buttonRegister.setOnClickListener(view -> {
            registerAccount();
        });
    }

    private void registerAccount() {
        if (validate()) {
            FirebaseFirestore database = FirebaseFirestore.getInstance();
            Map<String, Object> users = new HashMap<>();
            users.put(Constants.KEY_NAME, binding.nameInput.getText().toString());
            users.put(Constants.KEY_EMAIL, binding.emailInput.getText().toString());
            users.put(Constants.KEY_PASSWORD, binding.passwordInput.getText().toString());

            User user = new User();
            user.setName(binding.nameInput.getText().toString());
            user.setEmail(binding.emailInput.getText().toString());
            user.setPassword(binding.emailInput.getText().toString());


            FirebaseDatabase rtDatabase = FirebaseDatabase.getInstance();
            mAuth.createUserWithEmailAndPassword(binding.emailInput.getText().toString(), binding.passwordInput.getText().toString())
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            DatabaseReference myRef = rtDatabase.getReference("users");
                            myRef.setValue(user);
                            database.collection(Constants.KEY_COLLECTION_USER)
                                    .add(users);
                            showToast("Register user success!");
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
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
        } else if (binding.repasswordInput.getText().toString().trim().isEmpty()) {
            showToast("Confirm your password");
            return false;
        } else if (!binding.passwordInput.getText().toString().equals(binding.repasswordInput.getText().toString())) {
            showToast("Password & confirm password must be sames");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}