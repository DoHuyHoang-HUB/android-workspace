package com.codingtok.list_view.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.codingtok.list_view.R;
import com.codingtok.list_view.data.model.Employee;
import com.codingtok.list_view.databinding.FragmentAddItemBinding;
import com.codingtok.list_view.ui.viewmodel.EmployeesViewModel;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddItemFragment extends Fragment {

    private FragmentAddItemBinding binding;
    private EmployeesViewModel viewModel;
    private String encodeImage;
    private String[] dvlist;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddItemBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(EmployeesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View viewParent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(viewParent, savedInstanceState);

        dvlist = getResources().getStringArray(R.array.department_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dvlist);

        binding.inputDepartment.setAdapter(adapter);

        int position = AddItemFragmentArgs.fromBundle(getArguments()).getPosition();
        binding.title.setText(AddItemFragmentArgs.fromBundle(getArguments()).getTitle());

        if (position >= 0) {
            Employee e = viewModel.getEmployee(position);
            bind(e);
            binding.buttonAdd.setText("Update");
            binding.buttonAdd.setOnClickListener(view -> {
                updateEmployee(e);
                Navigation.findNavController(viewParent).navigate(R.id.action_addItemFragment_to_itemListFragment);
            });
        } else {
            binding.buttonAdd.setOnClickListener(view -> {
                addEmployee();
            });
        }
        binding.buttonBack.setOnClickListener(view -> {
            Navigation.findNavController(viewParent).navigate(R.id.action_addItemFragment_to_itemListFragment);
        });

        binding.layoutImage.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            pickImage.launch(intent);
        });

    }

    private void bind(Employee e) {
        binding.imageProfile.setImageBitmap(getEmployeeImage(e.getImage()));
        encodeImage = e.getImage();
        binding.textAddImage.setVisibility(View.GONE);
        binding.inputId.setText(e.getId());
        binding.inputName.setText(e.getName());
        for (int i = 0; i < dvlist.length; i++) {
            if (dvlist[i].equals(e.getDepartment())) {
                binding.inputDepartment.setSelection(i);
            }
        }
        if (e.isGender()) {
            binding.radioBtnNu.setChecked(true);
        } else {
            binding.radioBtnNam.setChecked(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void addEmployee() {
        if (validData()) {
            String id = binding.inputId.getText().toString();
            String name = binding.inputName.getText().toString();
            String department = binding.inputDepartment.getSelectedItem().toString();
            int radioId = binding.raidoGroupGender.getCheckedRadioButtonId();
            boolean gender = false;
            if (radioId == R.id.radio_btn_nu)
                gender = true;

            Employee employee = new Employee(id, name, gender, department, encodeImage);
            viewModel.addEmployee(employee);

            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_addItemFragment_to_itemListFragment);
        }
    }

    private void updateEmployee(Employee e) {
        if (validData()) {
            String id = binding.inputId.getText().toString();
            String name = binding.inputName.getText().toString();
            String department = binding.inputDepartment.getSelectedItem().toString();
            int radioId = binding.raidoGroupGender.getCheckedRadioButtonId();
            boolean gender = false;
            if (radioId == R.id.radio_btn_nu)
                gender = true;
            e.setId(id);
            e.setName(name);
            e.setDepartment(department);
            e.setGender(gender);
        }
    }

    private boolean validData() {
        if (encodeImage == null) {
            showToast("Select profile image");
            return false;
        } else if (binding.inputId.getText().toString().trim().isEmpty()) {
            showToast("Enter id");
            return false;
        } else if (binding.inputName.getText().toString().trim().isEmpty()) {
            showToast("Enter name");
            return false;
        } else if (binding.inputDepartment.getSelectedItem() == null) {
            showToast("Select department");
            return false;
        }
        return true;
    }
    
    private void showToast(String ms) {
        Toast.makeText(requireContext(), ms, Toast.LENGTH_SHORT).show();
    }

    private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        if (result.getData() != null) {
                            try {
                                Uri imageUri = result.getData().getData();
                                InputStream inputStream = requireActivity().getContentResolver().openInputStream(imageUri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                binding.imageProfile.setImageBitmap(bitmap);
                                binding.textAddImage.setVisibility(View.GONE);
                                encodeImage = encodeImage(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

    private String encodeImage(Bitmap bitmap) {
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() * previewWidth / bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private Bitmap getEmployeeImage(String encodedImage) {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}