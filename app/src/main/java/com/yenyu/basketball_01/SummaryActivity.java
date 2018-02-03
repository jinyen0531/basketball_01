package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    WebView wv;
    Spinner sp1,sp2;
    ArrayList<Game> games=new ArrayList<>();
    static String pid="";  //場次
    String sour="";
    int sec=0;      //spinner1的節次,0(全部),1,2,3,4
    String num="";  //spinner2的背號,""為全部,其餘為背號
    ArrayList<Player> players;  //取得球員
    ParseHTML parseHTML;    //將ArrayList<Game>轉為字串
    ActionDAO actionDAO;
    ArrayList<Action> actions;//取得的動作

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent it=getIntent();
        pid=it.getStringExtra("pid");
        sour=it.getStringExtra("sour");
        Log.d("summary pid",pid);
        wv=findViewById(R.id.webView);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        parseHTML=new ParseHTML(SummaryActivity.this);
        actionDAO=new ActionDAO(SummaryActivity.this);

        //選擇節次
        String[] sections={getResources().getString(R.string.all),"1","2","3","4"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sections);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new MyListener());

        //選擇球員
        PlayerDAO dao=new PlayerDAO(this);
        players=dao.getPlayers(pid);
        String[] names=new String[players.size()+2];
        int c=0;
        names[c++]=getResources().getString(R.string.all);
        for(Player p:players)
        {
            names[c++]=p.getNumber()+" "+p.getName();
        }
        names[c++]="G "+getResources().getString(R.string.guest);
        final ArrayAdapter<String> adapterName=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,names);
        sp2.setAdapter(adapterName);
        sp2.setOnItemSelectedListener(new MyListener());

        insertData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summenu,menu);
        if(sour.equals("Query"))
        {
            menu.getItem(1).setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_back:
                finish();
                break;
            case R.id.menu_save:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.confirm));
                builder.setMessage(getResources().getString(R.string.saveConfrim));

                builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actions=actionDAO.getActions(pid,0,"");
                        if(actions.size()<1)
                        {
                            Toast.makeText(SummaryActivity.this,getResources().getString(R.string.noResult),Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            games=parseHTML.getSummary(actions);
                            int score1=0;
                            int score2=0;
                            for(int a=0;a<games.size();a++)
                            {
                                if(games.get(a).getNumber().equals("G"))
                                {
                                    score2+=games.get(a).getScore();
                                }
                                else
                                {
                                    score1+=games.get(a).getScore();
                                }
                            }
                            Log.d("score",score1+" "+score2);
                            new TeamDAO(SummaryActivity.this).updateTeams(score1,score2,pid);
                            GameDAO gameDAO=new GameDAO(SummaryActivity.this);
                            gameDAO.insertGames(games);
                            finish();
                        }
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyListener implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (adapterView.getId())
            {
                case R.id.spinner:
                    sec=i;
                    break;
                case R.id.spinner2:
                    Log.d("guest","i = "+i+" Player.size"+players.size());
                    if(i==0)
                    {
                        num="";
                    }
                    else
                    {
                        if(i==players.size()+1)
                        {
                            num="G";
                        }
                        else
                        {
                            num=players.get(i-1).getNumber();
                        }
                    }
                    break;
            }
            Log.d("spinner","sec : "+ sec+" num : "+num);

            insertData();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            return;
        }
    }

    public void insertData()
    {
        if(sour.equals("Button"))
        {
            actions=actionDAO.getActions(pid,sec,num);
            if(actions.size()!=0)
            {
                games=parseHTML.getSummary(actions);
                wv.loadUrl("about:blank");
                wv.loadData(parseHTML.getString(games),"text/html;charset=UTF-8",null);
            }
            else
            {
                games=new ArrayList<>();
                wv.loadUrl("about:blank");
                wv.loadData(parseHTML.getString(games),"text/html;charset=UTF-8",null);
            }
        }
        else if(sour.equals("Query"))
        {
            games=new GameDAO(SummaryActivity.this).getGames(pid,sec,num);
            String data=parseHTML.getString(games);
            wv.loadUrl("about:blank");
            wv.loadData(data,"text/html;charset=UTF-8",null);
        }
    }
}
