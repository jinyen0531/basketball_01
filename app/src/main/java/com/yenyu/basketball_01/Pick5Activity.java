package com.yenyu.basketball_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.PlayerDAO;
import com.yenyu.basketball_01.dao.Player;

import java.util.ArrayList;

public class Pick5Activity extends AppCompatActivity {

    ListView lv;
    String pid="1";
    ArrayList<Player> mylist;
    boolean[] chks;
    String[] numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick5);
        lv=findViewById(R.id.listView);
        PlayerDAO dp=new PlayerDAO(Pick5Activity.this);
        mylist=dp.getPlayers(pid);
        chks=new boolean[mylist.size()];
        numbers=new String[mylist.size()];
        for(int i=0;i<mylist.size();i++)
        {
            numbers[i]=mylist.get(i).getNumber();
        }
        Log.d("Pick5A",mylist.size()+"");
        MyAdapter adapter=new MyAdapter(mylist,Pick5Activity.this,chks);
        lv.setAdapter(adapter);

    }

    public void clickOk(View v)
    {
        int count=0;

        for(boolean b:chks)
        {
            if(b) count++;
        }
        if(count==5)
        {
            Intent it=new Intent(Pick5Activity.this,ButtonRecord.class);
            it.putExtra("pid",pid);
            it.putExtra("numbers",numbers);
            it.putExtra("chks",chks);
            startActivity(it);
        }
        else
        {
            Toast.makeText(Pick5Activity.this,"請選擇五人",Toast.LENGTH_SHORT).show();
        }

    }
}
