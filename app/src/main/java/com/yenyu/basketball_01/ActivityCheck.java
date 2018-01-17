package com.yenyu.basketball_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

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

    }

    public void clickOK(View v)
    {
        ArrayList<Player> list=new ArrayList<>();
        DataProcess dp=new DataProcess(ActivityCheck.this);
        dp.insertPlayers(list);

        LinearLayout layout=(LinearLayout) findViewById(R.id.linearLayout);
        //Toast.makeText(ActivityCheck.this,String.valueOf(layout.getChildCount()),Toast.LENGTH_SHORT).show();
        ArrayList<EditText> textArrayList=new ArrayList<>();
        for(int i=0;i<layout.getChildCount();i++)
        {
            if(layout.getChildAt(i) instanceof LinearLayout)
            {
                LinearLayout layout1=(LinearLayout) layout.getChildAt(i);
                for(int j=0;j<layout1.getChildCount();j++)
                {
                    if(layout1.getChildAt(j) instanceof EditText)
                    {
                        textArrayList.add((EditText) layout1.getChildAt(j));
                    }
                }
            }
        }
        String str=textArrayList.get(1).getText().toString();
        Toast.makeText(ActivityCheck.this,str,Toast.LENGTH_SHORT).show();

        //Intent it = new Intent(ActivityCheck.this,ButtonRecord.class);
        //startActivity(it);
    }

}
