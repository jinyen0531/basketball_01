package com.yenyu.basketball_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

/**
 * Created by User on 2018/1/30.
 */

public class QueryAdapter extends BaseAdapter {

    Context context;
    ArrayList<Team> teams;
    public QueryAdapter(ArrayList<Team> teams,Context context)
    {
        this.teams=teams;
        this.context=context;
    }

    @Override
    public int getCount() {
        teams=new TeamDAO(context).getTeams();
        Log.d("QA Team size",teams.size()+"");
        return teams.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        QueryAdapter.ViewHolder viewHolder;
        if(view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.query,null);
            viewHolder=new QueryAdapter.ViewHolder();
            viewHolder.tv10=view.findViewById(R.id.textView10);
            viewHolder.tv14=view.findViewById(R.id.textView14);
            viewHolder.tv13=view.findViewById(R.id.textView13);
            viewHolder.tv17=view.findViewById(R.id.textView17);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder=(QueryAdapter.ViewHolder) view.getTag();
        }
        viewHolder.tv10.setText(teams.get(i).getTeam1());
        viewHolder.tv14.setText(teams.get(i).getTeam2());
        viewHolder.tv13.setText(String.valueOf(teams.get(i).getScore1()));
        viewHolder.tv17.setText(String.valueOf(teams.get(i).getScore2()));
        return view;
    }

    static class ViewHolder
    {
        TextView tv10;
        TextView tv14;
        TextView tv13;
        TextView tv17;
    }
}
