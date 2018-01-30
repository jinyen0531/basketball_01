package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/30.
 */

public class TeamDAO {
    Context context;
    public TeamDAO(Context context)
    {
        this.context=context;
    }

    public boolean insertTeam(Team team)
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        ContentValues values;
        values=new ContentValues();
        values.put("team1",team.getTeam1());
        values.put("team2",team.getTeam2());
        values.put("score1",team.getScore1());
        values.put("score2",team.getScore2());
        long id=database.insert("teams",null,values);
        Log.d("insertTeam","id : "+id+", team1 : "+team.getTeam1()+", team2 : "+team.getTeam2()+", score1 : "+team.getScore1()+", score2 : "+team.getScore2());
        database.close();
        return id>0 ? true : false;
    }
}
