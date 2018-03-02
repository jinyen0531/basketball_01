package com.yenyu.basketball_01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;

import java.util.ArrayList;

public class PlayersFragment extends Fragment {

    WebView wv3;
    String pid;
    String sour;
    ArrayList<Action> actions;
    ArrayList<Game> games;

    public PlayersFragment() {
        // Required empty public constructor
    }

    public static PlayersFragment newInstance() {
        PlayersFragment fragment = new PlayersFragment();
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
        return inflater.inflate(R.layout.fragment_players, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wv3=getActivity().findViewById(R.id.webView3);
        pid = DataActivity.pid;
        sour=DataActivity.sour;
        if(sour.equals("Button"))
        {
            actions = DataActivity.actionDAO.getActions(pid);
            if (actions.size() != 0) {
                games = DataActivity.parseHTML.getSummary(actions,"players");
            } else {
                games = new ArrayList<>();
            }
        }
        else if(sour.equals("Query"))
        {
            games=new GameDAO(getContext()).getGames(pid);
        }

        wv3.loadUrl("about:blank");
        wv3.loadData(DataActivity.parseHTML.getString(games), "text/html;charset=UTF-8", null);

    }
}
