package com.yenyu.basketball_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.PlayerDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class ActivityCheck extends AppCompatActivity {

    String pid="";
    String team1="",team2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Intent it=getIntent();
        pid=it.getStringExtra("pid");
        team1=it.getStringExtra("Team1");
        team2=it.getStringExtra("Team2");
        setTitle(team1+" v.s. "+team2);
        Log.d("2TeamId",pid);
    }

    public void clickOK(View v)
    {
        ArrayList<Player> list=new ArrayList<>();
        PlayerDAO dp=new PlayerDAO(ActivityCheck.this);
        LinearLayout layout=(LinearLayout) findViewById(R.id.linearLayout);
        //Toast.makeText(ActivityCheck.this,String.valueOf(layout.getChildCount()),Toast.LENGTH_SHORT).show();
        ArrayList<EditText> textArrayList=new ArrayList<>();
        for(int i=0;i<layout.getChildCount();i++)
        {
            if(layout.getChildAt(i) instanceof LinearLayout)
            {
                LinearLayout layout1=(LinearLayout) layout.getChildAt(i);
                for(int j=0;j<layout1.getChildCount();j++)
                {
                    if(layout1.getChildAt(j) instanceof EditText)
                    {
                        textArrayList.add((EditText) layout1.getChildAt(j));
                    }
                }
            }
        }
        int count=0;
        String number,name;
        for(int i=0;i<textArrayList.size();i+=2)
        {
            number=textArrayList.get(i).getText().toString();
            name=textArrayList.get(i+1).getText().toString();
            Log.d("add","number : "+number+ "name : "+name);
            if(number.length()>0 && name.length()>0)
            {
                list.add(new Player(pid,number,name));
                count++;
            }
        }
        if(count>=5)
        {
            dp.insertPlayers(list);       //測試,故標記
            Intent it = new Intent(ActivityCheck.this,Pick5Activity.class);
            it.putExtra("pid",pid);
            Log.d("Check pid",pid);
            it.putExtra("Team1",team1);
            it.putExtra("Team2",team2);
            startActivity(it);
        }
        else
        {
            Toast.makeText(ActivityCheck.this,getResources().getString(R.string.lastFive),Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        Team team=new TeamDAO(ActivityCheck.this).getTeam(pid);
        if(team.getScore1() >0 || team.getScore2()>0)
        {
            finish();
        }
    }
}
