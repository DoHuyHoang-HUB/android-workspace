package com.codingtok.bai4.ui.input;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingtok.bai4.R;
import com.codingtok.bai4.databinding.FragmentInputBinding;
import com.codingtok.bai4.ui.viewmodels.PersonViewModel;

public class InputFragment extends Fragment {

    private FragmentInputBinding binding;

    private PersonViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInputBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(PersonViewModel.class);

        binding.setInputFragment(this);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.buttonGuiThongTin.setOnClickListener(viewCh -> {
            sendInfo();
        });
    }

    private void sendInfo() {
        if (validate()) {
            viewModel.setName(binding.editTextHoTen.getText().toString());
            viewModel.setCmnd(binding.editTextCmnd.getText().toString());
            viewModel.setAdditionalInfo(binding.editTextThongTinBoSung.getText().toString());
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_inputFragment_to_resultFragment);
        }
    }

    private boolean validate() {
        if (binding.editTextHoTen.getText().toString().length() < 3) {
            binding.textLayoutHoTen.setError("Họ tên ít nhất 3 ký tự");
            if (binding.editTextCmnd.getText().toString().length() != 9) {
                binding.textLayoutCmnd.setError("Chứng minh nhân dân phải có đúng 9 chữ số");
            }
            return false;
        } else if (binding.editTextCmnd.getText().toString().length() != 9) {
            binding.textLayoutCmnd.setError("Chứng minh nhân dân phải có đúng 9 chữ số");
            binding.textLayoutHoTen.setError(null);
            return false;
        } else if (viewModel.getInterests().getValue().isEmpty()) {
            binding.textLayoutCmnd.setError(null);
            Toast.makeText(requireContext(), "Sở thích phải chọn ít nhất một lựa chọn", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void onCheckboxClicked(String interest, boolean isChecked) {
        if (isChecked) {
            viewModel.addInterest(interest);
        } else {
            viewModel.removeInterest(interest);
        }
    }
}