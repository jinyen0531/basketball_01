package com.yenyu.basketball_01;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFragment extends Fragment {

    WebView wv4;
    String pid;
    String sour;
    ArrayList<Action> actions;

    public SectionFragment() {
        // Required empty public constructor
    }

    public static SectionFragment newInstance() {
        SectionFragment fragment = new SectionFragment();
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
        return inflater.inflate(R.layout.fragment_section, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wv4=getActivity().findViewById(R.id.webView4);
        pid=DataActivity.pid;
        sour=DataActivity.sour;
        int[][] scores=new int[2][5];
        int p=0;
        int s=0;
        if(sour.equals("Button"))
        {
            actions=DataActivity.actionDAO.getActions(pid);
            for(int i=0;i<actions.size();i++)
            {
                p=actions.get(i).getNumber().equals("G") ? 1 : 0;
                s=actions.get(i).getSection()-1;
                switch (actions.get(i).getMove())
                {
                    case 1: //二分
                        scores[p][s]+=2;
                        scores[p][4]+=2;
                        break;
                    case 3: //三分
                        scores[p][s]+=3;
                        scores[p][4]+=3;
                        break;
                    case 5: //罰球
                        scores[p][s]+=1;
                        scores[p][4]+=1;
                        break;
                }
            }
        }
        else if(sour.equals("Query"))
        {
            ArrayList<Game> games=new GameDAO(getContext()).getGames(pid,0,"");
            for(int i=0;i<games.size();i++)
            {
                p=games.get(i).getNumber().equals("G") ? 1 : 0;
                s=games.get(i).getSection()-1;
                scores[p][s]+=games.get(i).getScore();
                scores[p][4]+=games.get(i).getScore();
            }
        }

        //將分數資料轉為字串並顯示在webView中
        wv4.loadUrl("about:blank");
        wv4.loadData(DataActivity.parseHTML.getScoreString(scores),"text/html;charset=UTF-8",null);
    }
}
