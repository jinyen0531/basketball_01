package com.yenyu.basketball_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("請輸入隊伍名稱");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1= inflater.inflate(R.layout.player5,null);
        final EditText ed1= v1.findViewById(R.id.editText);
        final EditText ed2= v1.findViewById(R.id.editText2);
        builder.setView(v1);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent it= new Intent(MainActivity.this, ActivityCheck.class);
                it.putExtra("Team1",ed1.toString());
                it.putExtra("Team2",ed2.toString());
                startActivity(it);
            }
        });
        builder.show();

    }
    public void clickTest(View v)
    {
        ActionDAO dao=new ActionDAO(MainActivity.this);
        Action action=new Action("1",1,23,6);
        dao.insertAction(action);
        action=new Action("1",1,40,8);
        dao.insertAction(action);
        ArrayList<Player> list=new ArrayList<>();
        list.add(new Player("1",1,"Name1"));
        list.add(new Player("1",2,"Name2"));
        list.add(new Player("1",3,"Name3"));
        list.add(new Player("1",4,"Name4"));
        list.add(new Player("1",5,"Name5"));
        list.add(new Player("1",6,"Name6"));
        list.add(new Player("1",7,"Name7"));
        list.add(new Player("1",8,"Name8"));
        PlayerDAO playerDAO=new PlayerDAO(MainActivity.this);
        playerDAO.insertPlayers(list);
    }
}
