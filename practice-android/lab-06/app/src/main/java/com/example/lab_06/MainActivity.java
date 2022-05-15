package com.example.lab_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.lab_06.data.model.Shoes;
import com.example.lab_06.ui.PortraitBFragment;
import com.example.lab_06.ui.widget.MyCommunicator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MyCommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = this.getSupportFragmentManager();

        if (getResources().getBoolean(R.bool.isPhone)) {
            manager.beginTransaction()
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.portraitBFragment)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.portraitAFragment)))
                    .commit();
        } else {
            manager.beginTransaction()
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.portraitBFragment)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.portraitAFragment)))
                    .commit();
        }
    }

    @Override
    public void displayDetail(Shoes product) {
        PortraitBFragment detailFragment = PortraitBFragment.newInstance(product);

        FragmentManager manager = this.getSupportFragmentManager();
        if (getResources().getBoolean(R.bool.isPhone)) {
            manager.beginTransaction()
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.portraitAFragment)))
                    .replace(R.id.portraitBFragment, detailFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            manager.beginTransaction()
                    .replace(R.id.portraitBFragment, detailFragment)
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.portraitBFragment)))
                    .commit();
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}