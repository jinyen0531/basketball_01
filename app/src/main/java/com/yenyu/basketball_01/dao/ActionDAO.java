package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Student on 2018/1/19.
 */

public class ActionDAO {

    Context context;
    public ActionDAO(Context context)
    {
        this.context=context;
    }

    //新增
    public boolean insertAction(Action action)
    {
        MyDBHelper helper=new MyDBHelper(context);
        SQLiteDatabase database=helper.getDatabase();
        ContentValues values=new ContentValues();
        values.put("pid",action.getPid());
        values.put("section",action.getSection());
        values.put("number",action.getNumber());
        values.put("move",action.getMove());
        long id=database.insert("actions",null,values);
        Log.d("ADD","id : "+id+" pid : "+action.getPid()+
                " section : "+action.getSection()+" number : "+action.getNumber()+
                " move : "+action.getMove());
        database.close();
        helper.close();
        if(id>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
