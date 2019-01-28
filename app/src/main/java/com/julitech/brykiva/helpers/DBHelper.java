package com.julitech.brykiva.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 03-Jan-2019.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "COURSES";
    private static final int DB_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE COURSES(_id INTEGER PRIMARY KEY AUTOINCREMENT, COURSE TEXT,COURSEID INTEGER,DATE INTEGER, PROGRESS INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
