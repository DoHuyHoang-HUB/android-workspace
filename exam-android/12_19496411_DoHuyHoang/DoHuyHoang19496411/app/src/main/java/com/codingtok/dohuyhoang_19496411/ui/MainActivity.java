package com.codingtok.dohuyhoang_19496411.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.codingtok.dohuyhoang_19496411.R;
import com.codingtok.dohuyhoang_19496411.databinding.ActivityMainBinding;
import com.codingtok.dohuyhoang_19496411.model.User;
import com.codingtok.dohuyhoang_19496411.util.Constants;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonLogout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        binding.buttonAdd.setOnClickListener(view -> {
            addToDo();
        });
    }

    private void addToDo() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        Map<String, Object> todo = new HashMap<>();
        todo.put(Constants.KEY_TODO, binding.inputTodo.getText().toString());
        todo.put(Constants.KEY_STATUS, false);
        todo.put(Constants.KEY_ID_USER, "dohuyhoang.iuh.k15@gmail.com");

        database.collection(Constants.KEY_COLLECTION_TODO).add(todo).
                addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        showToast("Add Success!");
                    }
                });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}