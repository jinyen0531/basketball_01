package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/29.
 */

public class GameDAO {
    Context context;
    public GameDAO(Context context)
    {
        this.context=context;
    }

    //新增
    public boolean insertGames(ArrayList<Game> games)
    {
        int count=0;
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        ContentValues values;
        for(int i=0;i<games.size();i++)
        {
            Log.d("games",games.get(i).toString());
            values=new ContentValues();
            values.put("pid",games.get(i).getPid());
            values.put("section",games.get(i).getSection());
            values.put("number",games.get(i).getNumber());
            values.put("score",games.get(i).getScore());
            values.put("point2in",games.get(i).getPoint2in());
            values.put("point2out",games.get(i).getPoint2out());
            values.put("point3in",games.get(i).getPoint3in());
            values.put("point3out",games.get(i).getPoint3out());
            values.put("ftin",games.get(i).getFtin());
            values.put("ftout",games.get(i).getFtout());
            values.put("oror",games.get(i).getOr());
            values.put("dr",games.get(i).getDr());
            values.put("st",games.get(i).getSt());
            values.put("asas",games.get(i).getAs());
            values.put("bs",games.get(i).getBs());
            values.put("toto",games.get(i).getTo());
            values.put("foul",games.get(i).getFoul());
            long c=database.insert("games",null,values);
            Log.d("_id",c+"");
            count++;
        }
        Log.d("insertGame","_id : "+count);
        return (count>0)? true : false;
    }

    //依 場次 節次 背號
    public ArrayList<Game> getGames(String pid,int sec,String num)
    {
        String strSql="";
        Cursor c=null;
        ArrayList<Game> mylist=new ArrayList<>();
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        if(sec==0 && num.equals("")) {
            strSql="select * from games where pid=?order by section,CAST(number as integer)";
            c=database.rawQuery(strSql,new String[]{pid});
        } else if(sec==0 && !num.equals(""))
        {
            strSql="select * from games where pid=? and number=? order by section,CAST(number as integer)";
            c=database.rawQuery(strSql,new String[]{pid,num});
        } else if(sec!=0 && num.equals(""))
        {
            strSql="select * from games where pid=? and section=? order by section,CAST(number as integer)";
            c=database.rawQuery(strSql,new String[]{pid,String.valueOf(sec)});
        } else
        {
            strSql="select * from games where pid=? and section=? and number=? order by section,CAST(number as integer)";
            c=database.rawQuery(strSql,new String[]{pid,String.valueOf(sec),num});
        }

        if(c.moveToFirst())
        {
            do
            {
                int id=c.getInt(c.getColumnIndex("_id"));
                int section=c.getInt(c.getColumnIndex("section"));
                String number=c.getString(c.getColumnIndex("number"));
                int score=c.getInt(c.getColumnIndex("score"));
                int point2in=c.getInt(c.getColumnIndex("point2in"));
                int point2out=c.getInt(c.getColumnIndex("point2out"));
                int point3in=c.getInt(c.getColumnIndex("point3in"));
                int point3out=c.getInt(c.getColumnIndex("point3out"));
                int ftin=c.getInt(c.getColumnIndex("ftin"));
                int ftout=c.getInt(c.getColumnIndex("ftout"));
                int or=c.getInt(c.getColumnIndex("oror"));
                int dr=c.getInt(c.getColumnIndex("dr"));
                int st=c.getInt(c.getColumnIndex("st"));
                int as=c.getInt(c.getColumnIndex("asas"));
                int bs=c.getInt(c.getColumnIndex("bs"));
                int to=c.getInt(c.getColumnIndex("toto"));
                int foul=c.getInt(c.getColumnIndex("foul"));
                mylist.add(new Game(id,pid,section,number,score,point2in,point2out,point3in,point3out,ftin,ftout,or,dr,st,as,bs,to,foul));
                Log.d("LoadGame","id : "+id+", section : "+section+", number : "+number);
            }while(c.moveToNext());
        }
        Log.d("Game_Count",mylist.size()+"");
        c.close();
        database.close();
        return mylist;
    }

    //依場次,刪除Games
    public int delGameByPid(String pid)
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        int count=database.delete("games","pid=?",new String[]{pid});
        database.close();
        Log.d("delGames",count+"");
        return count;
    }
}
