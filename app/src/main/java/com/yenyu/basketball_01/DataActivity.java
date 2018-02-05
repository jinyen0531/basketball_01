package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;

import android.widget.TextView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Game;
import com.yenyu.basketball_01.dao.GameDAO;
import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.TeamDAO;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    static String pid="";
    static String sour="";
    int sec=0;      //spinner1的節次,0(全部),1,2,3,4
    String num="";  //spinner2的背號,""為全部,其餘為背號
    ArrayList<Action> actions;//取得的動作
    ArrayList<Game> games=new ArrayList<>();
    static ParseHTML parseHTML;    //將ArrayList<Game>轉為字串
    static ActionDAO actionDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Intent it=getIntent();
        pid=it.getStringExtra("pid");
        sour=it.getStringExtra("sour");
        parseHTML=new ParseHTML(this);
        actionDAO=new ActionDAO(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        getResources().getString(R.string.data1),
                        getResources().getString(R.string.data2),
                        getResources().getString(R.string.data3),
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                switch (position)
                {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, PlayersFragment.newInstance())
                                .commit();
                        break;
                    case 1:
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, DetailFragment.newInstance())
                                .commit();
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.summenu,menu);
        if(sour.equals("Query"))
        {
            menu.getItem(1).setVisible(false);
        }
        return true;
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
                        Log.d("action size",actions.size()+"");
                        if(actions.size()<1)
                        {
                            Toast.makeText(DataActivity.this,getResources().getString(R.string.noResult),Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            games=parseHTML.getSummary(actions,"detail");
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
                            Log.d("score",score1+" "+score2+" team "+pid);
                            new TeamDAO(DataActivity.this).updateTeams(score1,score2,pid);
                            GameDAO gameDAO=new GameDAO(DataActivity.this);
                            Log.d("Game size",games.size()+"");
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


    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }

}
