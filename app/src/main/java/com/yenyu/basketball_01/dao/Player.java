package com.yenyu.basketball_01.dao;

/**
 * Created by Student on 2018/1/16.
 */

public class Player {
    private int _id;
    private String pid;     //場次
    private int number;  //背號
    private String name;    //姓名

    public Player(String pid,int number,String name)
    {
        this.pid=pid;
        this.number=number;
        this.name=name;
    }
    public Player(int _id,String pid,int number,String name)
    {
        this._id=_id;
        this.pid=pid;
        this.number=number;
        this.name=name;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
