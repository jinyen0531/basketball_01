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
        Intent it=new Intent(MainActivity.this,SummaryActivity.class);
        startActivity(it);
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("請輸入隊伍名稱");
//        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//        View v1= inflater.inflate(R.layout.player5,null);
//        final EditText ed1= v1.findViewById(R.id.editText);
//        final EditText ed2= v1.findViewById(R.id.editText2);
//        builder.setView(v1);
//        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Intent it= new Intent(MainActivity.this, ActivityCheck.class);
//                it.putExtra("Team1",ed1.toString());
//                it.putExtra("Team2",ed2.toString());
//                startActivity(it);
//            }
//        });
//        builder.show();

    }
    public void clickTest(View v)
    {
        ActionDAO dao=new ActionDAO(MainActivity.this);
        Action action=new Action("1",1,"7",9);
        dao.insertAction(action);
        action=new Action("1",2,"7",7);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",7);
        dao.insertAction(action);
        action=new Action("1",1,"14",4);
        dao.insertAction(action);
        action=new Action("1",2,"14",13);
        dao.insertAction(action);
        action=new Action("1",3,"8",13);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"14",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",8);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"8",7);
        dao.insertAction(action);
        action=new Action("1",4,"7",2);
        dao.insertAction(action);
        action=new Action("1",3,"7",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",9);
        dao.insertAction(action);
        action=new Action("1",1,"8",13);
        dao.insertAction(action);
        action=new Action("1",1,"7",7);
        dao.insertAction(action);
        action=new Action("1",2,"8",12);
        dao.insertAction(action);
        action=new Action("1",3,"14",4);
        dao.insertAction(action);
        action=new Action("1",4,"7",12);
        dao.insertAction(action);
        action=new Action("1",1,"14",12);
        dao.insertAction(action);
        action=new Action("1",2,"7",13);
        dao.insertAction(action);
        action=new Action("1",3,"6",11);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"7",2);
        dao.insertAction(action);
        action=new Action("1",2,"7",9);
        dao.insertAction(action);
        action=new Action("1",3,"7",7);
        dao.insertAction(action);
        action=new Action("1",4,"8",10);
        dao.insertAction(action);
        action=new Action("1",1,"8",2);
        dao.insertAction(action);
        action=new Action("1",2,"8",9);
        dao.insertAction(action);
        action=new Action("1",3,"7",13);
        dao.insertAction(action);
        action=new Action("1",4,"14",3);
        dao.insertAction(action);
        action=new Action("1",1,"8",12);
        dao.insertAction(action);
        action=new Action("1",2,"7",2);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"14",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",12);
        dao.insertAction(action);
        action=new Action("1",3,"8",9);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"7",1);
        dao.insertAction(action);
        action=new Action("1",2,"8",1);
        dao.insertAction(action);
        action=new Action("1",3,"8",13);
        dao.insertAction(action);
        action=new Action("1",4,"7",7);
        dao.insertAction(action);
        action=new Action("1",1,"8",4);
        dao.insertAction(action);
        action=new Action("1",2,"8",12);
        dao.insertAction(action);
        action=new Action("1",3,"8",9);
        dao.insertAction(action);
        action=new Action("1",4,"7",9);
        dao.insertAction(action);
        action=new Action("1",1,"7",13);
        dao.insertAction(action);
        action=new Action("1",2,"14",4);
        dao.insertAction(action);
        action=new Action("1",3,"7",7);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"8",13);
        dao.insertAction(action);
        action=new Action("1",2,"7",13);
        dao.insertAction(action);
        action=new Action("1",3,"8",2);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"8",2);
        dao.insertAction(action);
        action=new Action("1",2,"14",13);
        dao.insertAction(action);
        action=new Action("1",3,"3",12);
        dao.insertAction(action);
        action=new Action("1",4,"7",2);
        dao.insertAction(action);
        action=new Action("1",1,"8",10);
        dao.insertAction(action);
        action=new Action("1",2,"14",4);
        dao.insertAction(action);
        action=new Action("1",3,"16",10);
        dao.insertAction(action);
        action=new Action("1",4,"20",1);
        dao.insertAction(action);
        action=new Action("1",1,"20",2);
        dao.insertAction(action);
        action=new Action("1",2,"20",2);
        dao.insertAction(action);
        action=new Action("1",3,"20",4);
        dao.insertAction(action);
        action=new Action("1",4,"20",4);
        dao.insertAction(action);
        action=new Action("1",2,"20",10);
        dao.insertAction(action);
        action=new Action("1",3,"20",10);
        dao.insertAction(action);
        action=new Action("1",4,"20",9);
        dao.insertAction(action);
        action=new Action("1",1,"20",9);
        dao.insertAction(action);
        action=new Action("1",2,"20",7);
        dao.insertAction(action);
        action=new Action("1",3,"24",1);
        dao.insertAction(action);
        action=new Action("1",4,"24",1);
        dao.insertAction(action);
        action=new Action("1",1,"24",2);
        dao.insertAction(action);
        action=new Action("1",2,"24",2);
        dao.insertAction(action);
        action=new Action("1",3,"24",2);
        dao.insertAction(action);
        action=new Action("1",4,"24",2);
        dao.insertAction(action);
        action=new Action("1",1,"24",2);
        dao.insertAction(action);
        action=new Action("1",2,"24",2);
        dao.insertAction(action);
        action=new Action("1",3,"24",2);
        dao.insertAction(action);
        action=new Action("1",4,"24",2);
        dao.insertAction(action);
        action=new Action("1",1,"24",3);
        dao.insertAction(action);
        action=new Action("1",2,"24",3);
        dao.insertAction(action);
        action=new Action("1",3,"24",4);
        dao.insertAction(action);
        action=new Action("1",4,"24",4);
        dao.insertAction(action);
        action=new Action("1",1,"24",4);
        dao.insertAction(action);
        action=new Action("1",2,"24",5);
        dao.insertAction(action);
        action=new Action("1",3,"24",5);
        dao.insertAction(action);
        action=new Action("1",4,"24",6);
        dao.insertAction(action);
        action=new Action("1",1,"24",6);
        dao.insertAction(action);
        action=new Action("1",2,"24",10);
        dao.insertAction(action);
        action=new Action("1",3,"24",10);
        dao.insertAction(action);
        action=new Action("1",4,"24",9);
        dao.insertAction(action);
        action=new Action("1",1,"24",9);
        dao.insertAction(action);
        action=new Action("1",2,"24",9);
        dao.insertAction(action);
        action=new Action("1",1,"24",13);
        dao.insertAction(action);
        action=new Action("1",4,"24",7);
        dao.insertAction(action);
        action=new Action("1",1,"24",7);
        dao.insertAction(action);
        action=new Action("1",2,"24",8);
        dao.insertAction(action);
        action=new Action("1",3,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",1,"24",12);
        dao.insertAction(action);
        action=new Action("1",2,"24",12);
        dao.insertAction(action);
        action=new Action("1",3,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",3,"25",1);
        dao.insertAction(action);
        action=new Action("1",2,"25",1);
        dao.insertAction(action);
        action=new Action("1",1,"25",1);
        dao.insertAction(action);
        action=new Action("1",1,"25",2);
        dao.insertAction(action);
        action=new Action("1",2,"25",2);
        dao.insertAction(action);
        action=new Action("1",3,"25",4);
        dao.insertAction(action);
        action=new Action("1",4,"25",5);
        dao.insertAction(action);
        action=new Action("1",1,"25",5);
        dao.insertAction(action);
        action=new Action("1",2,"25",5);
        dao.insertAction(action);
        action=new Action("1",3,"25",6);
        dao.insertAction(action);
        action=new Action("1",4,"25",6);
        dao.insertAction(action);
        action=new Action("1",1,"25",9);
        dao.insertAction(action);
        action=new Action("1",2,"25",8);
        dao.insertAction(action);
        action=new Action("1",3,"25",8);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",1,"25",12);
        dao.insertAction(action);
        action=new Action("1",2,"25",12);
        dao.insertAction(action);
        action=new Action("1",3,"25",12);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",2,"25",13);
        dao.insertAction(action);
        action=new Action("1",1,"25",13);
        dao.insertAction(action);
        action=new Action("1",3,"25",13);
        dao.insertAction(action);
        action=new Action("1",4,"25",13);
        dao.insertAction(action);
        action=new Action("1",1,"17",12);
        dao.insertAction(action);

        ArrayList<Player> list=new ArrayList<>();
        list.add(new Player("1","1","Name1"));
        list.add(new Player("1","2","Name2"));
        list.add(new Player("1","3","Name3"));
        list.add(new Player("1","4","Name4"));
        list.add(new Player("1","5","Name5"));
        list.add(new Player("1","6","Name6"));
        list.add(new Player("1","7","Name7"));
        list.add(new Player("1","8","Name8"));
        PlayerDAO playerDAO=new PlayerDAO(MainActivity.this);
        playerDAO.insertPlayers(list);
    }
}
