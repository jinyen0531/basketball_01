package com.yenyu.basketball_01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;
import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {

//        Intent it=new Intent(MainActivity.this,SummaryActivity.class);
//        startActivity(it);
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
                String team1=ed1.getText().toString();
                String team2=ed2.getText().toString();
                TeamDAO teamDAO=new TeamDAO(MainActivity.this);
                int id=teamDAO.insertTeam(new Team(team1,team2));
                it.putExtra("pid",String.valueOf(id));
                it.putExtra("Team1",team1);
                it.putExtra("Team2",team2);
                Log.d("1TeamId",id+"");
                startActivity(it);
            }
        });
        builder.show();
    }

    public void clickQuery(View v)
    {
        Intent it=new Intent(MainActivity.this,QueryActivity.class);
        startActivity(it);
    }

}
