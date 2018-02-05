package com.yenyu.basketball_01;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
                builder.setTitle(getResources().getString(R.string.pleaseConfirm));
                builder.setMessage(getResources().getString(R.string.delConfrim));
                builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String pid=String.valueOf(teams.get(position).get_id());
                        new TeamDAO(QueryActivity.this).delTeams(pid);
                        new PlayerDAO(QueryActivity.this).delPlayer(pid);
                        new ActionDAO(QueryActivity.this).delActionByPid(pid);
                        new GameDAO(QueryActivity.this).delGameByPid(pid);
                        Toast.makeText(QueryActivity.this,getResources().getString(R.string.dataDelete),Toast.LENGTH_SHORT).show();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshData();
                            }
                        });
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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
                Intent it=new Intent(QueryActivity.this, DataActivity.class);
                //Intent it=new Intent(QueryActivity.this,SummaryActivity.class);
                it.putExtra("pid",String.valueOf(teams.get(i).get_id()));
                it.putExtra("sour","Query");
                startActivity(it);
            }
        });


    }
    public void refreshData()
    {
        teams.clear();
        teams=teamDAO.getTeams();
        Log.d("Q teamsize",teams.size()+"");
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summenu,menu);
        menu.getItem(1).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_back:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
