package com.yenyu.basketball_01;

import android.content.DialogInterface;
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
import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    WebView wv;
    Spinner sp1,sp2;
    static String pid;     //場次
    ArrayList<Game> games=null;
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
        pid="1";
        wv=findViewById(R.id.webView);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        parseHTML=new ParseHTML();
        actionDAO=new ActionDAO(SummaryActivity.this);

        //選擇節次
        String[] sections={"全部","1","2","3","4"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sections);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new MyListener());

        //選擇球員
        PlayerDAO dao=new PlayerDAO(this);
        players=dao.getPlayers(pid);
        String[] names=new String[players.size()+1];
        int c=0;
        names[c++]="全部";
        for(Player p:players)
        {
            names[c++]=p.getNumber()+" "+p.getName();
        }
        final ArrayAdapter<String> adapterName=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,names);
        sp2.setAdapter(adapterName);
        sp2.setOnItemSelectedListener(new MyListener());

        actions=actionDAO.getActions(pid,sec,num);
        if(actions.size()!=0)
        {
            games=parseHTML.getSummary(actions);

            wv.loadData(parseHTML.getString(games),"text/html;charset=UTF-8",null);
        }
        else
        {
            wv.loadData("無資料","text/html;charset=UTF-8",null);
        }


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
                break;
            case R.id.menu_save:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("儲存資料");
                builder.setMessage("請確認是否儲存比賽？");

                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actions=actionDAO.getActions(pid,0,"");
                        games=parseHTML.getSummary(actions);
                        GameDAO gameDAO=new GameDAO(SummaryActivity.this);
                        gameDAO.insertGames(games);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
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
                    if(i==0)
                    {
                        num="";
                    }
                    else
                    {
                        num=players.get(i-1).getNumber();
                    }
                    break;
            }
            Log.d("spinner","sec : "+ sec+" num : "+num);

            actions=actionDAO.getActions(pid,sec,num);
            if(actions.size()!=0)
            {
                games=parseHTML.getSummary(actions);

                wv.loadData(parseHTML.getString(games),"text/html;charset=UTF-8",null);
            }
            else
            {
                wv.loadData("無資料","text/html;charset=UTF-8",null);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            return;
        }
    }
}
