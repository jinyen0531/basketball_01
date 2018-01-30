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
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("pid",action.getPid());
        values.put("section",action.getSection());
        values.put("number",action.getNumber());
        values.put("move",action.getMove());
        long id=database.insert("actions",null,values);
        Log.d("AddAction","id : "+id+" pid : "+action.getPid()+
                " section : "+action.getSection()+" number : "+action.getNumber()+
                " move : "+action.getMove());
        database.close();
        return id>0 ? true:false;
    }

    //取得全部動作,依場次 節次 背號
    public ArrayList<Action> getActions(String pid,int sec,String num)
    {
        String strSql="";
        Cursor c=null;
        ArrayList<Action> mylist=new ArrayList<>();
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        if(sec==0 && num.equals("")) {
            strSql="select * from actions where pid=?order by section,CAST(number as integer),CAST(move as integer)";
            c=database.rawQuery(strSql,new String[]{pid});
        } else if(sec==0 && !num.equals(""))
        {
            strSql="select * from actions where pid=? and number=? order by section,CAST(number as integer),CAST(move as integer)";
            c=database.rawQuery(strSql,new String[]{pid,num});
        } else if(sec!=0 && num.equals(""))
        {
            strSql="select * from actions where pid=? and section=? order by section,CAST(number as integer),CAST(move as integer)";
            c=database.rawQuery(strSql,new String[]{pid,String.valueOf(sec)});
        } else
        {
            strSql="select * from actions where pid=? and section=? and number=? order by section,CAST(number as integer),CAST(move as integer)";
            c=database.rawQuery(strSql,new String[]{pid,String.valueOf(sec),num});
        }

        if(c.moveToFirst())
        {
            do
            {
                int _id=c.getInt(c.getColumnIndex("_id"));
                int section=c.getInt(c.getColumnIndex("section"));
                String number=c.getString(c.getColumnIndex("number"));
                int move=c.getInt(c.getColumnIndex("move"));
                mylist.add(new Action(_id,pid,section,number,move));
                Log.d("LoadAction","id : "+_id+", section : "+section+", pid : "+pid+", number : "+number+", move : "+move);
            }while(c.moveToNext());
        }

        Log.d("Action_Count",mylist.size()+"");
        database.close();
        return mylist;
    }

    //刪除最後一筆
    public boolean delAction()
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        String strSql="select * from actions order by _id desc limit 1";
        Cursor c=database.rawQuery(strSql,null);
        c.moveToFirst();
        int id=c.getInt(c.getColumnIndex("_id"));
        int i=database.delete("DelAction","_id=?",new String[]{String.valueOf(id)});
        database.close();
        return i>0 ? true : false;
    }
    //依場次,刪除actions
    public int delActionByPid(String pid)
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        int count=database.delete("actions","pid=?",new String[]{pid});
        database.close();
        Log.d("delActions",count+"");
        return count;
    }
}
