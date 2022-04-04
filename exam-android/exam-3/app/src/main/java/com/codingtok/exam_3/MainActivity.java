package com.codingtok.exam_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MyCommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        FragmentManager manager = this.getSupportFragmentManager();

        if (getResources().getBoolean(R.bool.isPhone)) {
            manager.beginTransaction()
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.detailFragment)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.gridViewFragment)))
                    .commit();
        } else {
            manager.beginTransaction()
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.detailFragment)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.gridViewFragment)))
                    .commit();
        }
    }

    @Override
    public void displayDetail(Product product) {
        DetailFragment detailFragment = DetailFragment.newInstance(product);

        FragmentManager manager = this.getSupportFragmentManager();
        if (getResources().getBoolean(R.bool.isPhone)) {
            manager.beginTransaction()
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.gridViewFragment)))
                    .replace(R.id.detailFragment, detailFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            manager.beginTransaction()
                    .replace(R.id.detailFragment, detailFragment)
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.gridViewFragment)))
                    .commit();
        }
    }
}