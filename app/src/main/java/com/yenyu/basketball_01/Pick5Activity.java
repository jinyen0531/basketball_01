package com.yenyu.basketball_01;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yenyu.basketball_01.DBConnection.DataProcess;
import com.yenyu.basketball_01.datatable.Player;

import java.util.ArrayList;

public class Pick5Activity extends AppCompatActivity {

    ListView lv;
    String pid="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick5);
        lv=findViewById(R.id.listView);
        DataProcess dp=new DataProcess(Pick5Activity.this);
        ArrayList<Player> list=dp.getPlayers(pid);

    }

    public void clickOk(View v)
    {
        Intent it=new Intent(Pick5Activity.this,ButtonRecord.class);
        startActivity(it);
    }
}
