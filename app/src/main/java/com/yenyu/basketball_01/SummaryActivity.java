package com.yenyu.basketball_01;

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
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    WebView wv;
    String pid;
    ArrayList<Game> games=null;
    Game total=null;
    Spinner sp1,sp2;
    int sec=0;
    String num="";
    ArrayList<Player> players;
    ParseHTML parseHTML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        pid="1";
        wv=findViewById(R.id.webView);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        parseHTML=new ParseHTML();

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

        getSummary(pid,sec,num);

    }

    public void getSummary(String pid,int sec,String num)
    {
        ActionDAO dao=new ActionDAO(this);
        ArrayList<Action> actions=dao.getActions(pid,sec,num);
        if(actions.size() !=0)
        {
            total=new Game(pid,0,"");//總合
            games=new ArrayList<>();
            //先指定第一筆資料
            int section=actions.get(0).getSection();
            String number=actions.get(0).getNumber();
            int count=0;
            games.add(new Game(pid,section,number));

            for(int i=0;i<actions.size();i++)
            {
                //Log.d("action",mylist.get(i).toString());
                if(section!=actions.get(i).getSection() || !actions.get(i).getNumber().equals(number) ){
                    section=actions.get(i).getSection();
                    number=actions.get(i).getNumber();
                    games.add(new Game(pid,section,number));
                    count++;
                }
                switch(actions.get(i).getMove())
                {
                    case RecordAction.Action_2point_in:
                        games.get(count).setPoint2in(games.get(count).getPoint2in()+1);
                        games.get(count).setScore(games.get(count).getScore()+2);
                        total.setPoint2in(total.getPoint2in()+1);
                        total.setScore(total.getScore()+2);
                        break;
                    case RecordAction.Action_2point_out:
                        games.get(count).setPoint2out(games.get(count).getPoint2out()+1);
                        total.setPoint2out(total.getPoint2out()+1);
                        break;
                    case RecordAction.Action_3point_in:
                        games.get(count).setPoint3in(games.get(count).getPoint3in()+1);
                        games.get(count).setScore(games.get(count).getScore()+3);
                        total.setPoint3in(total.getPoint3in()+1);
                        total.setScore(total.getScore()+3);
                        break;
                    case RecordAction.Action_3point_out:
                        games.get(count).setPoint3out(games.get(count).getPoint3out()+1);
                        total.setPoint3out(total.getPoint3out()+1);
                        break;
                    case RecordAction.Action_FT_in:
                        games.get(count).setFtin(games.get(count).getFtin()+1);
                        games.get(count).setScore(games.get(count).getScore()+1);
                        total.setFtin(total.getFtin()+1);
                        total.setScore(total.getScore()+1);
                        break;
                    case RecordAction.Action_FT_out:
                        games.get(count).setFtout(games.get(count).getFtout()+1);
                        total.setFtout(total.getFtout()+1);
                        break;
                    case RecordAction.Action_OR:
                        games.get(count).setOr(games.get(count).getOr()+1);
                        total.setOr(total.getOr()+1);
                        break;
                    case RecordAction.Action_DR:
                        games.get(count).setDr(games.get(count).getDr()+1);
                        total.setDr(total.getDr()+1);
                        break;
                    case RecordAction.Action_ST:
                        games.get(count).setSt(games.get(count).getSt()+1);
                        total.setSt(total.getSt()+1);
                        break;
                    case RecordAction.Action_AS:
                        games.get(count).setAs(games.get(count).getAs()+1);
                        total.setAs(total.getAs()+1);
                        break;
                    case RecordAction.Action_BS:
                        games.get(count).setBs(games.get(count).getBs()+1);
                        total.setBs(total.getBs()+1);
                        break;
                    case RecordAction.Action_TO:
                        games.get(count).setTo(games.get(count).getTo()+1);
                        total.setTo(total.getTo()+1);
                        break;
                    case RecordAction.Action_Foul:
                        games.get(count).setFoul(games.get(count).getFoul()+1);
                        total.setFoul(total.getFoul()+1);
                        break;
                }
            }
            wv.loadData(parseHTML.getString(games),"text/html;charset=UTF-8",null);
        } else {
            wv.loadData("無資料","text/html;charset=UTF-8",null);
        }

        for(int i=0;i<games.size();i++)
        {
            Log.d("Game",games.get(i).toString());
        }
        Log.d("Total",total.toString());
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
            getSummary(pid,sec,num);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            return;
        }
    }
}
