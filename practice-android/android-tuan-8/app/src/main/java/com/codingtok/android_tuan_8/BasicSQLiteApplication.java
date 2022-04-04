package com.codingtok.android_tuan_8;

import android.app.Application;

import com.codingtok.android_tuan_8.data.StudentDao;
import com.codingtok.android_tuan_8.data.StudentRoomDatabase;

public class BasicSQLiteApplication extends Application {

    private StudentRoomDatabase database;

    public synchronized StudentRoomDatabase getDatabase() {
        if (database == null) {
            database = StudentRoomDatabase.getInstance(this);
        }
        return database;
    }
}
