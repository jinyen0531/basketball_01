package com.yenyu.basketball_01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //按Back鍵離開程式
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(getResources().getString(R.string.pleaseConfirm))
                    .setMessage(getResources().getString(R.string.exit))
                    .setIcon(R.drawable.basketball)
                    .setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.cancel),null)
                    .show();
        }
        return true;
    }

    public void click1(View v)
    {   //輸入主客場名稱
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getResources().getString(R.string.teamEnter));
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1= inflater.inflate(R.layout.player5,null);
        final EditText ed1= v1.findViewById(R.id.editText);
        final EditText ed2= v1.findViewById(R.id.editText2);
        builder.setView(v1);
        builder.setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent it= new Intent(MainActivity.this, ActivityCheck.class);
                String team1=ed1.getText().toString();
                String team2=ed2.getText().toString();
                if(team1.length()>0 && team2.length()>0)
                {
                    TeamDAO teamDAO=new TeamDAO(MainActivity.this);
                    int id=teamDAO.insertTeam(new Team(team1,team2));
                    it.putExtra("pid",String.valueOf(id));
                    it.putExtra("Team1",team1);
                    it.putExtra("Team2",team2);
                    Log.d("1TeamId",id+"");
                    startActivity(it);
                }

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
