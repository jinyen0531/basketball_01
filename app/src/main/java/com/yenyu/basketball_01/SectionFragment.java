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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFragment extends Fragment {

    WebView wv4;
    String pid;
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
        actions=DataActivity.actionDAO.getActions(pid);
        int[][] scores=new int[2][5];
        int p=0;
        int s=0;
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
        //Log.d("score 1","s1 "+scores[0][0]+"s2 "+scores[0][1]+"s3 "+scores[0][2]+"s4 "+scores[0][3]+"ss "+scores[0][4]);
        //Log.d("score 2","s2 "+scores[1][0]+"s2 "+scores[1][1]+"s3 "+scores[1][2]+"s4 "+scores[1][3]+"ss "+scores[1][4]);
        wv4.loadUrl("about:blank");
        wv4.loadData(DataActivity.parseHTML.getScoreString(scores),"text/html;charset=UTF-8",null);
    }
}
