package com.yenyu.basketball_01.dao;

/**
 * Created by Student on 2018/1/30.
 */

public class Team {
    private int _id;
    private String team1;
    private String team2;
    private int score1;
    private int score2;

    public Team(String team1,String team2)
    {
        this.team1=team1;
        this.team2=team2;
    }
    public Team(String team1,String team2,int socre1,int score2)
    {
        this.team1=team1;
        this.team2=team2;
        this.score1=socre1;
        this.score2=score2;
    }
    public Team(int _id,String team1,String team2,int score1,int score2)
    {
        this._id=_id;
        this.team1=team1;
        this.team2=team2;
        this.score1=score1;
        this.score2=score2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    @Override
    public String toString() {
        return "_id : "+_id+", team1 : "+team1+", team2 : "+team2+", score1 : "+score1+", score2 : "+score2;
    }
}
