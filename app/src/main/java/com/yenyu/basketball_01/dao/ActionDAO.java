package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

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

    //取得全部動作
    public ArrayList<Action> getActions(String pid)
    {
        ArrayList<Action> mylist=new ArrayList<>();
        MyDBHelper helper=new MyDBHelper(context);
        SQLiteDatabase database=helper.getDatabase();
        String strSql="select * from actions where pid=?";
        Cursor c=database.rawQuery(strSql,new String[]{pid});
        c.moveToFirst();
        do
        {
            int _id=c.getInt(c.getColumnIndex("_id"));
            int section=c.getInt(c.getColumnIndex("section"));
            String number=c.getString(c.getColumnIndex("number"));
            int move=c.getInt(c.getColumnIndex("move"));
            mylist.add(new Action(_id,pid,section,number,move));
            Log.d("LoadAction","id : "+_id+", section : "+section+", number : "+number+", move : "+move);
        }while(c.moveToNext());
        Log.d("Action_Count",mylist.size()+"");
        return mylist;
    }

    //刪除
    public boolean delAction()
    {

        return true;
    }
}
