package com.yenyu.basketball_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Game;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    WebView wv;
    String pid="1";
    ArrayList<Game> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        wv=findViewById(R.id.webView);
        getArray();
        ParseHTML parseHTML=new ParseHTML();
        wv.loadData(parseHTML.getString(mylist),"text/html;charset=UTF-8",null);
    }

    public void getArray()
    {
        mylist=new ArrayList<>();
        ActionDAO dao=new ActionDAO(SummaryActivity.this);
        ArrayList<Action> actions=dao.getActions(pid);

        mylist.add(new Game("1",1,"23",10,3,5,2,6,0,3,2,4,2,6,2,3,4));
        mylist.add(new Game("1",1,"40",8,4,3,0,3,0,2,3,1,6,4,3,0,3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_back:
                finish();
            case R.id.menu_save:

        }
        return super.onOptionsItemSelected(item);
    }
}
