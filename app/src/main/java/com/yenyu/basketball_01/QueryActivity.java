package com.yenyu.basketball_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class QueryActivity extends AppCompatActivity {

    ListView queryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        queryView=findViewById(R.id.queryView);

        TeamDAO teamDAO=new TeamDAO(this);
        ArrayList<Team> teams=teamDAO.getTeams();
        QueryAdapter adapter=new QueryAdapter(teams,QueryActivity.this);
        queryView.setAdapter(adapter);

        queryView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(QueryActivity.this,"longclick",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        queryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(QueryActivity.this,"onclick",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
