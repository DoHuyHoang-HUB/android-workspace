package com.codingtok.lab_07;

import android.app.Application;

import com.codingtok.lab_07.data.StudentRoomDatabase;

public class BasicSQLiteApplication extends Application {

    private StudentRoomDatabase database;

    public synchronized StudentRoomDatabase getDatabase() {
        if (database == null) {
            database = StudentRoomDatabase.getInstance(this);
        }
        return database;
    }
}
