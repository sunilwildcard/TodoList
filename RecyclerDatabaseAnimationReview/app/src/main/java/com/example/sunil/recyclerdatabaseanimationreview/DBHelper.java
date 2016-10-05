package com.example.sunil.recyclerdatabaseanimationreview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sunil on 10/1/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;

    private static final String DATABASE_NAME = "TODOLIST";
    private static final int DATABASE_VERSION = 1;

    public static DBHelper getInstance(Context context){
        if(sInstance==null)
            sInstance = new DBHelper(context.getApplicationContext());
        return  sInstance;
    }

    private DBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
