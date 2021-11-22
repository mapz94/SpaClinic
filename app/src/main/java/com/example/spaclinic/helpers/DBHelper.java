package com.example.spaclinic.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedHashMap;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SPACLINICD";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    public SQLiteDatabase getDatabase() {
        return getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Tablas son creadas desde las clases si son accedidas por primera vez.

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("");
        onCreate(sqLiteDatabase);
    }

}
