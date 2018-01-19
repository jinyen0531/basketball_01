package com.yenyu.basketball_01.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/16.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="baseball.db";
    private static final int DATABASE_VERSION=1;
    private SQLiteDatabase database;

    public MyDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //新增players資料表
        sqLiteDatabase.execSQL("create table main.players "+
        "(_id integer primary key not null," +
                "pid varchar," +
                "number integer," +
                "name varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE players");
        onCreate(sqLiteDatabase);
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }
}
