package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.yenyu.basketball_01.dao.Player;
import com.yenyu.basketball_01.dao.PlayerDAO;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.yenyu.basketball_01.RecordAction.Action_player1;

public class ButtonRecord extends AppCompatActivity {
    Button bt2in, bt2out, bt3in, bt3out, btFTin, btFTout, btOR, btDR, btST, btAS, btBS, btTO, btFoul, btNextSection;
    RadioButton rbNumber1, rbNumber2, rbNumber3, rbNumber4, rbNumber5, rbOP;
    TextView tvScore1, tvScore2, tvSectionFoul1, tvSectionFoul2, tvSection,tvOnline;
    RadioGroup rg1, rg2;
    public int Player;
    public int Action;
    public int Section=RecordAction.Section1;
    ListView lv;
//    String pid="1";
    ArrayList<com.yenyu.basketball_01.dao.Player> mylist;
    boolean []chks;
    String[] numbers;
    ArrayList<String> Playerlist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_record);


        tvScore1 = (TextView) findViewById(R.id.tvScore1); //自己的得分
        tvScore2 = (TextView) findViewById(R.id.tvScore2); //對方的得分
        tvSectionFoul1 = (TextView) findViewById(R.id.tvSectionFoul1); //自己的團犯
        tvSectionFoul2 = (TextView) findViewById(R.id.tvSectionFoul2);  //對方的團犯
        tvSection = (TextView) findViewById(R.id.tvSection);    //節次
        tvOnline = (TextView) findViewById(R.id.tvOnline); //跑馬燈

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);

        bt2in = (Button) findViewById(R.id.bt2in); //兩分球進
        bt2out = (Button) findViewById(R.id.bt2out);    //兩分球不進
        bt3in = (Button) findViewById(R.id.bt3in);  //三分球進
        bt3out = (Button) findViewById(R.id.bt3out);    //三分球不進
        btFTin = (Button) findViewById(R.id.btFTin);    //罰球進
        btFTout = (Button) findViewById(R.id.btFTout);  //罰球不進
        btOR = (Button) findViewById(R.id.btOR);
        btDR = (Button) findViewById(R.id.btDR);
        btST = (Button) findViewById(R.id.btST);
        btAS = (Button) findViewById(R.id.btAS);
        btBS = (Button) findViewById(R.id.btBS);
        btTO = (Button) findViewById(R.id.btTO);
        btFoul = (Button) findViewById(R.id.btFoul);
        btNextSection = (Button) findViewById(R.id.btNextSection);


        rbNumber1 = (RadioButton) findViewById(R.id.rbNumber1);
        rbNumber2 = (RadioButton) findViewById(R.id.rbNumber2);
        rbNumber3 = (RadioButton) findViewById(R.id.rbNumber3);
        rbNumber4 = (RadioButton) findViewById(R.id.rbNumber4);
        rbNumber5 = (RadioButton) findViewById(R.id.rbNumber5);
        rbOP = (RadioButton) findViewById(R.id.rbOP); //對手


        MyPlayersListener listener2 = new MyPlayersListener();
        rbNumber1.setOnCheckedChangeListener(listener2);
        rbNumber2.setOnCheckedChangeListener(listener2);
        rbNumber3.setOnCheckedChangeListener(listener2);
        rbNumber4.setOnCheckedChangeListener(listener2);
        rbNumber5.setOnCheckedChangeListener(listener2);
        rbOP.setOnCheckedChangeListener(listener2);


        MyOnClickListener listener = new MyOnClickListener();
        bt2in.setOnClickListener(listener);
        bt2out.setOnClickListener(listener);
        bt3in.setOnClickListener(listener);
        bt3out.setOnClickListener(listener);
        btFTin.setOnClickListener(listener);
        btFTin.setOnClickListener(listener);
        btDR.setOnClickListener(listener);
        btOR.setOnClickListener(listener);
        btAS.setOnClickListener(listener);
        btBS.setOnClickListener(listener);
        btST.setOnClickListener(listener);
        btTO.setOnClickListener(listener);
        btFoul.setOnClickListener(listener);
        btNextSection.setOnClickListener(listener);

    }


    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt2in:
                    Action = RecordAction.Action_2point_in;
                    if (Player <= 105 && Player >= 101) {
                        //當按下按鈕時，將RecordAction的Action_2point_in指定給Action
                        tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 2));
                        clickCancel();
                    } else if (Player == 106) {
                        tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 2));
                        clickCancel();
                    }
                    else {Player=0;}
                    tvOnline.setText("兩分球進");
                    break;
                case R.id.bt2out:
                    if (Player <= 105 && Player >= 101) {
                        Action = RecordAction.Action_2point_out;
                        clickCancel();
                    }
                    else {clickCancel();}
                    tvOnline.setText("兩分球不進");
                    break;
                case R.id.bt3in:
                    Action = RecordAction.Action_3point_in;
                    if (Player <= 105 && Player >= 101) {
                        tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 3));
                        clickCancel();
                    } else if (Player == 106) {
                        tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 3));
                        clickCancel();
                    } else {clickCancel();}
                    tvOnline.setText("三分球進");
                    break;
                case R.id.bt3out:
                    Action = RecordAction.Action_3point_out;
                    if (Player <= 105 && Player >= 101) {
                        clickCancel();
                    }
                    else {clickCancel();}
                    tvOnline.setText("三分球不進");
                    break;
                case R.id.btFTin:
                    Action = RecordAction.Action_FT_in;
                    if (Player <= 105 && Player >= 101) {
                        tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 1));
                        clickCancel();
                    } else if (Player == 106) {
                        tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 1));
                        clickCancel();
                    }
                    else {clickCancel();}
                    tvOnline.setText("罰球進");
                    break;
                case R.id.btFTout:
                    Action = RecordAction.Action_FT_out;
                    Log.d("罰球",Action+"");
                    if (Player <= 105 && Player >= 101) {
                        clickCancel();
                    }
                    else{clickCancel();}
                    Log.d("罰球",Action+"");
                    tvOnline.setText("罰球不進");
                    break;
                case R.id.btOR:
                    Action = RecordAction.Action_OR;
                    if (Player <= 105 && Player >= 101) {
                    clickCancel();
                    }
                    else {clickCancel();}
                    tvOnline.setText("進攻籃板");
                    break;
                case R.id.btDR:
                    Action = RecordAction.Action_DR;
                    if(Player <= 105 && Player >= 101) {
                    clickCancel();}
                    else {clickCancel();}
                    tvOnline.setText("防守籃板");
                    break;
                case R.id.btST:
                    Action = RecordAction.Action_ST;
                    if (Player <= 105 && Player >= 101) {
                    clickCancel();}
                    else {clickCancel();}
                    tvOnline.setText("抄截");
                    break;
                case R.id.btAS:
                    Action = RecordAction.Action_AS;
                    if (Player <= 105 && Player >= 101) {
                        clickCancel();}
                    else {clickCancel();}
                    tvOnline.setText("助攻");
                    break;
                case R.id.btBS:
                    Action = RecordAction.Action_BS;
                    if (Player <= 105 && Player >= 101) {
                    clickCancel();}
                    else {clickCancel();}
                    tvOnline.setText("阻攻");
                    break;
                case R.id.btTO:
                    Action = RecordAction.Action_TO;
                    if (Player <= 105 && Player >= 101) {
                    clickCancel();}
                    else {clickCancel();}
                    tvOnline.setText("失誤");
                    break;
                case R.id.btFoul:
                    Action = RecordAction.Action_Foul;
                    if (Player <= 105 && Player >= 101) {
                        int sectionfoul1 = Integer.valueOf(tvSectionFoul1.getText().toString());
                        if(sectionfoul1<5)
                            tvSectionFoul1.setText(String.valueOf(sectionfoul1+1));
                        clickCancel();}
                    else if(Player ==106)
                    {
                        int sectionfoul2 = Integer.valueOf(tvSectionFoul2.getText().toString());
                        if(sectionfoul2<5)
                            tvSectionFoul2.setText(String.valueOf(sectionfoul2+1));
                        clickCancel();
                    }
                    else {clickCancel();}
                    tvOnline.setText("犯規");
                    break;
                case R.id.btNextSection:
                    if(Section == 1111)
                    { Section = RecordAction.Section2;
                    tvOnline.setText("第二節開始");}
                    else if (Section == 2222)
                {Section = RecordAction.Section3;
                    tvOnline.setText("第三節開始");}
                    else if (Section == 3333)
                {Section = RecordAction.Section4;
                    tvOnline.setText("第四節開始");}
                    Log.d("Section",Section+"");
                    tvSectionFoul1.setText("0");
                    tvSectionFoul2.setText("0");
                    int tvsection = Integer.valueOf(tvSection.getText().toString());
                    Log.d("section",tvsection+"");
                    if(tvsection<4) {
                        tvSection.setText(String.valueOf(tvsection + 1));
                    }
                    break;
            }
        }
    }


    class MyPlayersListener implements CompoundButton.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch(buttonView.getId())
            {
                case R.id.rbNumber1:
                     if(102<=Player && Player<=106 )
                         clickCancel();
                     rg2.clearCheck();
                     Player = RecordAction.Action_player1;
                     Log.d("player", Player + "");
                     tvOnline.setText("1號選手");
                     break;
                case R.id.rbNumber2:
                    if(101<=Player && Player<=106 && Player != 102)
                        clickCancel();
                    rg2.clearCheck();
                    Player = RecordAction.Action_player2;
                    Log.d("player",Player+"");
                    tvOnline.setText("2號選手");
                    break;
                case R.id.rbNumber3:
                    if(101<=Player && Player<=106 && Player != 103)
                        clickCancel();
                    rg2.clearCheck();
                    Player = RecordAction.Action_player3;
                    Log.d("player",Player+"");
                    tvOnline.setText("3號選手");
                    break;
                case R.id.rbNumber4:
                    if(101<=Player && Player<=106 && Player != 104)
                        clickCancel();
                    rg1.clearCheck();
                    Player = RecordAction.Action_player4;
                    Log.d("player",Player+"");
                    tvOnline.setText("4號選手");
                    break;
                case R.id.rbNumber5:
                    if(101<=Player && Player<=106 && Player != 105)
                        clickCancel();
                    rg1.clearCheck();
                    Player = RecordAction.Action_player5;
                    Log.d("player",Player+"");
                    tvOnline.setText("5號選手");
                    break;
                case R.id.rbOP:
                    if(101<=Player && Player<=105 )
                        clickCancel();
                    rg1.clearCheck();
                    Player = RecordAction.Action_playerOP;
                    Log.d("player",Player+"");
                    tvOnline.setText("對手");
                    break;



            }
        }

    }



    public void clickCancel()
    {
        Player = RecordAction.Action_playerEmpty;
        rg1.clearCheck();
        rg2.clearCheck();
    }


    public void clickChange(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ButtonRecord.this);
        builder.setTitle("請勾選上場球員名單(5)");
        Intent it = getIntent();
        Bundle b=it.getExtras();
        String pid=it.getStringExtra("pid");
        numbers = b.getStringArray("numbers");
        chks = b.getBooleanArray("chks");
        Log.d("numbers",numbers[1]);
        builder.setMultiChoiceItems(numbers, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                for(int i=0;i<chks.length;i++)
                {
                    Log.d("i",i+"");
                    while(chks[i])
                    {
                        if(chks[i] == false) continue;
//                        Playerlist.add((numbers.toString()));
//                        Log.d("Playerlist",Playerlist+"");
                    }
                }

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                rbNumber1.setText(Playerlist.get(0));
//                rbNumber2.setText(Playerlist.get(1));
//                rbNumber3.setText(Playerlist.get(2));
//                rbNumber4.setText(Playerlist.get(3));
//                rbNumber5.setText(Playerlist.get(4));
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();



    }

    public void clickUndo(View v)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(ButtonRecord.this);
        builder.setTitle("確定取消上一步嗎");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvOnline.setText("你已收回前一個步驟");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

}


