package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
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
            values.put("or",games.get(i).getOr());
            values.put("dr",games.get(i).getDr());
            values.put("st",games.get(i).getSt());
            values.put("as",games.get(i).getAs());
            values.put("bs",games.get(i).getBs());
            values.put("to",games.get(i).getTo());
            values.put("foul",games.get(i).getFoul());
            long c=database.insert("games",null,values);
            Log.d("_id",c+"");
            count++;
        }
        Log.d("insertGame",count+"");
        return (count>0)? true : false;
    }

}
