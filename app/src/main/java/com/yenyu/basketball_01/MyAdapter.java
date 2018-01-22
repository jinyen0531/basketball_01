package com.yenyu.basketball_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.yenyu.basketball_01.dao.Player;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/19.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Player> list;
    boolean[] chks;
    public MyAdapter(ArrayList<Player> list,Context context,boolean[] chks)
    {
        this.list=list;
        this.context=context;
        this.chks=chks;
    }

    @Override
    public int getCount() {
        Log.d("size",list.size()+"");
        return list.size();
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
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.pick5_item,null);
            viewHolder=new ViewHolder();
            viewHolder.tv5=view.findViewById(R.id.textView5);
            viewHolder.tv7=view.findViewById(R.id.textView7);
            viewHolder.chk2=view.findViewById(R.id.checkBox2);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.tv5.setText(String.valueOf(list.get(position).getNumber()));
        viewHolder.tv7.setText(list.get(position).getName());
        //測試用
//        for(int i=0;i<5;i++)
//        {
//            chks[i]=true;
//        }
        viewHolder.chk2.setOnCheckedChangeListener(null);
        viewHolder.chk2.setChecked(chks[position]);

        viewHolder.chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position]=b;         //測試,故標記
                Log.d("click","Position : "+position+" b : "+b);
            }
        });

        int count=0;
        for(int i=0;i<chks.length;i++)
        {
            if(chks[i]) count++;
        }
        Log.d("count",count+"");
        return view;
    }
    static class ViewHolder
    {
        CheckBox chk2;
        TextView tv5;
        TextView tv7;
    }
}
