package com.yenyu.basketball_01;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;

import java.util.ArrayList;

public class DetailFragment extends Fragment {

    String pid,sour;
    Context context;
    Spinner sp3,sp4;
    WebView wv2;
    int sec=0;      //spinner1的節次,0(全部),1,2,3,4
    String num="";
    ArrayList<Player> players;  //取得球員
    ArrayList<Action> actions;//取得的動作
    ArrayList<Game> games=new ArrayList<>();

    public DetailFragment() {}

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp3=getActivity().findViewById(R.id.spinner3);
        sp4=getActivity().findViewById(R.id.spinner4);
        wv2=getActivity().findViewById(R.id.webView2);
        context=getContext();

        pid=DataActivity.pid;
        sour=DataActivity.sour;

        //選擇節次
        String[] sections={getResources().getString(R.string.all),"1","2","3","4"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,sections);
        sp3.setAdapter(adapter);
        sp3.setOnItemSelectedListener(new MyListener());

        Log.d("test","pid "+pid+" s "+sec+" n "+num);
        //選擇球員
        PlayerDAO dao=new PlayerDAO(context);
        players=dao.getPlayers(pid);
        String[] names=new String[players.size()+2];
        int c=0;
        names[c++]=getResources().getString(R.string.all);
        for(Player p:players)
        {
            names[c++]=p.getNumber()+" "+p.getName();
        }
        names[c++]="G "+getResources().getString(R.string.guest);
        final ArrayAdapter<String> adapterName=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,names);
        sp4.setAdapter(adapterName);
        sp4.setOnItemSelectedListener(new MyListener());

        insertData();

    }
    class MyListener implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("test m","pid "+pid+" s "+sec+" n "+num);
            switch (adapterView.getId())
            {
                case R.id.spinner3:
                    sec=i;
                    break;
                case R.id.spinner4:
                    Log.d("guest","i = "+i+" Player.size"+players.size());
                    if(i==0)
                    {
                        num="";
                    }
                    else
                    {
                        if(i==players.size()+1)
                        {
                            num="999";
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
        //Log.d("insertData","pid "+pid+" sec "+sec+" num "+num);
        if(sour.equals("Button"))
        {
            actions=DataActivity.actionDAO.getActions(pid,sec,num);
            if(actions.size()!=0)
            {
                games=DataActivity.parseHTML.getSummary(actions,"detail");
            }
            else
            {
                games=new ArrayList<>();
            }
        }
        else if(sour.equals("Query"))
        {
            games=new GameDAO(context).getGames(pid,sec,num);
        }
        //Log.d("insertData","size : "+games.size());
        wv2.loadDataWithBaseURL(null, DataActivity.parseHTML.getString(games),"text/html;charset=UTF-8",null,null);
//        wv2.loadUrl("about:blank");
//        wv2.loadData(DataActivity.parseHTML.getString(games),"text/html;charset=UTF-8",null);
    }
}
