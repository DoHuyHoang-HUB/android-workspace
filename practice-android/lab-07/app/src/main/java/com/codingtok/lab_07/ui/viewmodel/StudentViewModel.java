package com.codingtok.lab_07.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.codingtok.lab_07.data.Student;
import com.codingtok.lab_07.data.StudentDao;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class StudentViewModel extends ViewModel {
    private final StudentDao studentDao;

    public StudentViewModel(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public LiveData<List<Student>> getStudents() {
        return LiveDataReactiveStreams.fromPublisher(studentDao.getStudents().subscribeOn(Schedulers.io()));
    }

    private void insertStudent(Student student) {
        Completable.fromRunnable(() -> studentDao.insertStudent(student))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void addNewStudent(String name) {
        Student student = new Student(name);
        insertStudent(student);
    }
}
