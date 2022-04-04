package com.codingtok.android_tuan_8.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertStudent(Student student);

    @Update
    public void updateStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("select * from students where id = :id")
    public Flowable<Student> getStudent(int id);

    @Query("select * from students")
    public Flowable<List<Student>> getStudents();
}
