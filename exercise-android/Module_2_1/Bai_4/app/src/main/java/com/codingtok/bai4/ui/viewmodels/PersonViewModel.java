package com.codingtok.bai4.ui.viewmodels;

import android.view.View;
import android.widget.CheckBox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingtok.bai4.R;

import java.util.ArrayList;
import java.util.List;

public class PersonViewModel extends ViewModel {
    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<String> cmnd = new MutableLiveData<>();
    private final MutableLiveData<String> certificate = new MutableLiveData<>();
    private final MutableLiveData<List<String>> interests = new MutableLiveData<>();
    private final MutableLiveData<String> additionalInfo = new MutableLiveData<>();

    public PersonViewModel() {
        reset();
    }

    public LiveData<String> getName() {
        return name;
    }

    public LiveData<String> getCmnd() {
        return cmnd;
    }

    public LiveData<String> getCertificate() {
        return certificate;
    }

    public LiveData<List<String>> getInterests() {
        return interests;
    }

    public LiveData<String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setCmnd(String cmnd) {
        this.cmnd.setValue(cmnd);
    }

    public void setCertificate(String certificate) {
        this.certificate.setValue(certificate);
    }

    public void addInterest(String interest) {
        if (interests.getValue() == null) {
            interests.setValue(new ArrayList<>());
        }
        interests.getValue().add(interest);
    }

    public void removeInterest(String interest) {
        interests.getValue().remove(interest);
    }

    public void setAdditionalInfo(String info) {
        additionalInfo.setValue(info);
    }

    public void reset() {
        name.setValue(null);
        cmnd.setValue(null);
        certificate.setValue("Trung cấp");
        this.interests.setValue(null);
        additionalInfo.setValue(null);
    }
}
