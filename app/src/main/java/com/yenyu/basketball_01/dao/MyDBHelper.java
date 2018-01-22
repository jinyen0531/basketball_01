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
        sqLiteDatabase.execSQL("CREATE TABLE `players` "+
                "( `_id` INTEGER, "+
                "`pid` TEXT, "+
                "`number` TEXT, "+
                "`name` TEXT, "+
                "PRIMARY KEY(`_id`) )");

        sqLiteDatabase.execSQL("CREATE TABLE `actions` "+
                "( `_id` INTEGER, "+
                "`pid` TEXT, "+
                "`section` INTEGER, "+
                "`number` TEXT, "+
                "`move` INTEGER, "+
                "PRIMARY KEY(`_id`) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE players");
        sqLiteDatabase.execSQL("DROP TABLE actions");
        onCreate(sqLiteDatabase);
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }
}
