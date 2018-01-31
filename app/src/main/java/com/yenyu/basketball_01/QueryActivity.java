package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.PlayerDAO;
import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class QueryActivity extends AppCompatActivity {

    ListView queryView;
    ArrayList<Team> teams;
    TeamDAO teamDAO;
    QueryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        queryView=findViewById(R.id.queryView);
        teamDAO=new TeamDAO(this);
        teams=teamDAO.getTeams();
        adapter=new QueryAdapter(teams,QueryActivity.this);
        queryView.setAdapter(adapter);

        //長按,刪除
        queryView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(QueryActivity.this);
                builder.setTitle("刪除確認");
                builder.setMessage("請確認是否刪除？");
                builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String pid=String.valueOf(teams.get(position).get_id());
                        new TeamDAO(QueryActivity.this).delTeams(pid);
                        new PlayerDAO(QueryActivity.this).delPlayer(pid);
                        new ActionDAO(QueryActivity.this).delActionByPid(pid);
                        new GameDAO(QueryActivity.this).delGameByPid(pid);
                        refreshData();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
            }
        });


        //查詢各場數據
        queryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(QueryActivity.this,"onclick",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void refreshData()
    {
        teams.clear();
        teams=teamDAO.getTeams();
        adapter.notifyDataSetChanged();
    }
}
