package com.yenyu.basketball_01.dao;

/**
 * Created by User on 2018/1/22.
 */

public class Game {
    private int _id;
    private String pid;        //場次
    private int section;        //節次
    private String number;    //背號
    private int score;         //分數
    private int point2in;       //二分進
    private int point2out;      //二分不進
    private int point3in;       //三分進
    private int point3out;      //三分不進
    private int ftin;           //罰球進
    private int ftout;          //罰球不進
    private int or;            //進攻籃板
    private int dr;            //防守籃板
    private int st;            //抄截
    private int as;            //助攻
    private int bs;            //阻攻
    private int to;            //失誤
    private int foul;          //犯規

    public Game(String pid,int section,String number,int score,
                int point2in,int point2out,int point3in,int point3out,int ftin,int ftout,
                int or,int dr,int st,int as,int bs,int to,int foul)
    {
        this.pid=pid;
        this.section=section;
        this.number=number;
        this.score=score;
        this.point2in=point2in;
        this.point2out=point2out;
        this.point3in=point3in;
        this.point3out=point3out;
        this.ftin=ftin;
        this.ftout=ftout;
        this.or=or;
        this.dr=dr;
        this.st=st;
        this.as=as;
        this.bs=bs;
        this.to=to;
        this.foul=foul;
    }

    public Game(int _id,String pid,int section,String number,int score,
                int point2in,int point2out,int point3in,int point3out,int ftin,int ftout,
                int or,int dr,int st,int as,int bs,int to,int foul)
    {
        this._id=_id;
        this.pid=pid;
        this.section=section;
        this.number=number;
        this.score=score;
        this.point2in=point2in;
        this.point2out=point2out;
        this.point3in=point3in;
        this.point3out=point3out;
        this.ftin=ftin;
        this.ftout=ftout;
        this.or=or;
        this.dr=dr;
        this.st=st;
        this.as=as;
        this.bs=bs;
        this.to=to;
        this.foul=foul;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPoint2in() {
        return point2in;
    }

    public void setPoint2in(int point2in) {
        this.point2in = point2in;
    }

    public int getPoint2out() {
        return point2out;
    }

    public void setPoint2out(int point2out) {
        this.point2out = point2out;
    }

    public int getPoint3in() {
        return point3in;
    }

    public void setPoint3in(int point3in) {
        this.point3in = point3in;
    }

    public int getPoint3out() {
        return point3out;
    }

    public void setPoint3out(int point3out) {
        this.point3out = point3out;
    }

    public int getFtin() {
        return ftin;
    }

    public void setFtin(int ftin) {
        this.ftin = ftin;
    }

    public int getFtout() {
        return ftout;
    }

    public void setFtout(int ftout) {
        this.ftout = ftout;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getAs() {
        return as;
    }

    public void setAs(int as) {
        this.as = as;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFoul() {
        return foul;
    }

    public void setFoul(int foul) {
        this.foul = foul;
    }
}
