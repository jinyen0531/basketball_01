package com.yenyu.basketball_01.dao;

/**
 * Created by User on 2018/1/18.
 */

public class Action {
    private int _id;
    private String pid;     //場次
    private int section;     //節次
    private int number;     //背號
    private int move;     //動作

    public Action(String pid,int section,int number,int move)
    {
        this.pid=pid;
        this.section=section;
        this.number=number;
        this.move=move;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

}
