package com.codingtok.list_view.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingtok.list_view.R;
import com.codingtok.list_view.data.model.Employee;
import com.codingtok.list_view.databinding.FragmentDetailBinding;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModel;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModelFactory;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private EmployeesViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getViewModelStore(), new EmployeesViewModelFactory(requireContext())).get(EmployeesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);
        int position = DetailFragmentArgs.fromBundle(getArguments()).getItem();

        bind(viewModel.getEmployee(position));

        binding.editItem.setOnClickListener(view -> {
            NavDirections action = DetailFragmentDirections.actionDetailFragmentToAddItemFragment(position, getString(R.string.update_employee));
            Navigation.findNavController(viewParent).navigate(action);
        });
    }

    private void bind(Employee e) {
        binding.id.setText(requireContext().getString(R.string.id, e.getId()));
        binding.name.setText(requireContext().getString(R.string.name, e.getName()));
        binding.gender.setText(requireContext().getString(R.string.gender, convertGenderText(e.isGender())));
        binding.department.setText(requireContext().getString(R.string.department, e.getDepartment()));
        binding.imageAvatar.setImageBitmap(getEmployeeImage(e.getImage()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Bitmap getEmployeeImage(String encodedImage) {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    private String convertGenderText(boolean gender) {
        return gender ? "Nữ":"Nam";
    }
}