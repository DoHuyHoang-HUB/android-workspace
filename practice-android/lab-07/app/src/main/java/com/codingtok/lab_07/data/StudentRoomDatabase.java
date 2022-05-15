package com.codingtok.lab_07.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();

    private static volatile StudentRoomDatabase INSTANCE = null;

    public synchronized static StudentRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (StudentRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        StudentRoomDatabase.class,
                        "student_database"
                )
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
