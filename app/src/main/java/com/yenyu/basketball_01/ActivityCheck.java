package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.yenyu.basketball_01.DBConnection.DataProcess;
import com.yenyu.basketball_01.datatable.Player;

import java.util.ArrayList;

public class ActivityCheck extends AppCompatActivity {

    EditText edNum1,edNum2,edNum3,edNum4,edNum5,edNum6,edNum7,edNum8,edNum9,edNum10,edNum11,edNum12;
    int i;
    boolean check[] = new boolean[12];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        edNum1 =(EditText)findViewById(R.id.edNum1);
        edNum2 =(EditText)findViewById(R.id.edNum2);
        edNum3 =(EditText)findViewById(R.id.edNum3);
        edNum4 =(EditText)findViewById(R.id.edNum4);
        edNum5 =(EditText)findViewById(R.id.edNum5);
        edNum6 =(EditText)findViewById(R.id.edNum6);
        edNum7 =(EditText)findViewById(R.id.edNum7);
        edNum8 =(EditText)findViewById(R.id.edNum8);
        edNum9=(EditText)findViewById(R.id.edNum9);
        edNum10 =(EditText)findViewById(R.id.edNum10);
        edNum11 =(EditText)findViewById(R.id.edNum11);
        edNum12 =(EditText)findViewById(R.id.edNum12);

    }

    public void clickOK(View v)
    {
        ArrayList<Player> list=new ArrayList<>();
        list.add(new Player("1","23","Pong"));
        list.add(new Player("1","40","Chang"));
        for(int i=1;i<=12;i++)
        {

        }
        DataProcess dp=new DataProcess(ActivityCheck.this);
        dp.insertPlayers(list);


        //Intent it = new Intent(ActivityCheck.this,ButtonRecord.class);
        //startActivity(it);

//        it.putExtra("player1",edNum1.getText().toString());
//        it.putExtra("player2",edNum2.getText().toString());
//        it.putExtra("player3",edNum3.getText().toString());
//        it.putExtra("player4",edNum4.getText().toString());
//        it.putExtra("player5",edNum5.getText().toString());
//        it.putExtra("player6",edNum6.getText().toString());
//        it.putExtra("player7",edNum7.getText().toString());
//        it.putExtra("player8",edNum8.getText().toString());
//        it.putExtra("player9",edNum9.getText().toString());
//        it.putExtra("player10",edNum10.getText().toString());
//        it.putExtra("player11",edNum11.getText().toString());
//        it.putExtra("player12",edNum12.getText().toString());
//        startActivity(it);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityCheck.this);
//        final String [] players = {edNum1.getText().toString(),
//                edNum2.getText().toString(),
//                edNum3.getText().toString(),
//                edNum4.getText().toString(),
//                edNum5.getText().toString(),
//                edNum6.getText().toString(),
//                edNum7.getText().toString(),
//                edNum8.getText().toString(),
//                edNum9.getText().toString(),
//                edNum10.getText().toString(),
//                edNum11.getText().toString(),
//                edNum12.getText().toString(),};
//        builder.setTitle("請選擇先發五人");
//        builder.setMultiChoiceItems(players, check, new DialogInterface.OnMultiChoiceClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//            }
//        });



    }


}
