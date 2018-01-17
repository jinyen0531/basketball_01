package com.yenyu.basketball_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("請輸入隊伍名稱");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1= inflater.inflate(R.layout.player5,null);
        final EditText ed1= v1.findViewById(R.id.editText);
        final EditText ed2= v1.findViewById(R.id.editText2);
        builder.setView(v1);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent it= new Intent(MainActivity.this, ActivityCheck.class);
                it.putExtra("Team1",ed1.toString());
                it.putExtra("Team2",ed2.toString());
                startActivity(it);
            }
        });
        builder.show();

    }
}
