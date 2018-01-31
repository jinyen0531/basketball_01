package com.yenyu.basketball_01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //新增隊伍
    public int insertTeam(Team team)
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        ContentValues values;
        values=new ContentValues();
        values.put("team1",team.getTeam1());
        values.put("team2",team.getTeam2());
        values.put("score1",team.getScore1());
        values.put("score2",team.getScore2());
        int id=(int)database.insert("teams",null,values);
        Log.d("insertTeam","id : "+id+", team1 : "+team.getTeam1()+", team2 : "+team.getTeam2()+", score1 : "+team.getScore1()+", score2 : "+team.getScore2());
        database.close();
        return id;
    }

    //查詢全部隊伍
    public ArrayList<Team> getTeams()
    {
        ArrayList<Team> teams=new ArrayList<>();
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        Cursor c=database.rawQuery("select * from teams",null);
        if(c.moveToFirst())
        {
            do {
                int id=c.getInt(c.getColumnIndex("_id"));
                String team1=c.getString(c.getColumnIndex("team1"));
                String team2=c.getString(c.getColumnIndex("team2"));
                int score1=c.getInt(c.getColumnIndex("score1"));
                int score2=c.getInt(c.getColumnIndex("score2"));
                teams.add(new Team(id,team1,team2,score1,score2));
                Log.d("Team","_id : "+id+", team1 : "+team1+", team2 : "+team2+", score1 : "+score1+", score2 : "+score2);
            }while(c.moveToNext());
        }
        database.close();
        return teams;
    }

    //依埸次刪除隊伍
    public int delTeams(String pid)
    {
        SQLiteDatabase database=new MyDBHelper(context).getWritableDatabase();
        int count=database.delete("teams","_id=?",new String[]{pid});
        database.close();
        Log.d("delTeams",count+"");
        return count;
    }
}
