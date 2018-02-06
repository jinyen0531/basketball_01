package com.yenyu.basketball_01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.ActionDAO;
import com.yenyu.basketball_01.dao.Team;
import com.yenyu.basketball_01.dao.TeamDAO;


public class ButtonRecord extends AppCompatActivity {
    Button bt2in, bt2out, bt3in, bt3out, btFTin, btFTout, btOR, btDR, btST, btAS, btBS, btTO, btFoul, btNextSection;
    RadioButton rbNumber1, rbNumber2, rbNumber3, rbNumber4, rbNumber5, rbOP;
    TextView tvScore1, tvScore2, tvSectionFoul1, tvSectionFoul2, tvSection,tvOnlineN,tvOnlineA;
    RadioGroup rg1, rg2;
    public String Player="";
    public int Action;
    public int Section=RecordAction.Section1;
    boolean []chks;
    String[] numbers;
    int count;
    boolean flag=false;
    String pid="";
    String team1="",team2="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_record);


        tvScore1 = (TextView) findViewById(R.id.tvScore1); //自己的得分
        tvScore2 = (TextView) findViewById(R.id.tvScore2); //對方的得分
        tvSectionFoul1 = (TextView) findViewById(R.id.tvSectionFoul1); //自己的團犯
        tvSectionFoul2 = (TextView) findViewById(R.id.tvSectionFoul2);  //對方的團犯
        tvSection = (TextView) findViewById(R.id.tvSection);    //節次
        tvOnlineN = (TextView) findViewById(R.id.tvOnlineN); //跑馬燈
        tvOnlineA = (TextView) findViewById(R.id.tvOnlineA); //跑馬燈

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
        rbNumber1.setOnClickListener(listener2);
        rbNumber2.setOnClickListener(listener2);
        rbNumber3.setOnClickListener(listener2);
        rbNumber4.setOnClickListener(listener2);
        rbNumber5.setOnClickListener(listener2);
        rbOP.setOnClickListener(listener2);


        MyOnClickListener listener = new MyOnClickListener();
        bt2in.setOnClickListener(listener);
        bt2out.setOnClickListener(listener);
        bt3in.setOnClickListener(listener);
        bt3out.setOnClickListener(listener);
        btFTin.setOnClickListener(listener);
        btFTout.setOnClickListener(listener);
        btDR.setOnClickListener(listener);
        btOR.setOnClickListener(listener);
        btAS.setOnClickListener(listener);
        btBS.setOnClickListener(listener);
        btST.setOnClickListener(listener);
        btTO.setOnClickListener(listener);
        btFoul.setOnClickListener(listener);
        btNextSection.setOnClickListener(listener);

        //抓取前面輸入的球員號碼
        Intent it = getIntent();
        Bundle b=it.getExtras();
        pid=b.getString("pid");
        team1=b.getString("Team1");
        team2=b.getString("Team2");
        setTitle(team1+" v.s. "+team2);
        Log.d("button record pid",pid);
        numbers = b.getStringArray("numbers");
        chks = b.getBooleanArray("chks");

        Log.d("test",rbNumber1.getText().toString());

        for(int i=0;i<chks.length;i++)
        {
            if(chks[i])
            {
                if(rbNumber1.getText().toString().equals(""))
                {
                    rbNumber1.setText(numbers[i]);
                }
                else if(rbNumber2.getText().toString().equals(""))
                {
                    rbNumber2.setText(numbers[i]);
                }
                else if(rbNumber3.getText().toString().equals(""))
                {
                    rbNumber3.setText(numbers[i]);
                }else if(rbNumber4.getText().toString().equals(""))
                {
                    rbNumber4.setText(numbers[i]);
                }else if(rbNumber5.getText().toString().equals(""))
                {
                    rbNumber5.setText(numbers[i]);
                }
            }
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.recordmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.menu_record:
                Intent it=new Intent(ButtonRecord.this,DataActivity.class);
                //Intent it=new Intent(ButtonRecord.this,SummaryActivity.class);
                it.putExtra("pid",pid);
                it.putExtra("sour","Button");
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt2in:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_2point_in;
                        if (Player.equals("G")) {
                            tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 2));
                        } else {
                            tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 2));
                        }
                        tvOnlineA.setText("    "+getResources().getString(R.string.point2_inn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();} //五犯的球員不再存取進資料庫
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.bt2out:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_2point_out;
                        tvOnlineA.setText("    "+getResources().getString(R.string.point2_outn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.bt3in:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_3point_in;
                        if (Player.equals("G")) {
                            tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 3));
                        } else{
                            tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 3));
                        }
                        tvOnlineA.setText("    "+getResources().getString(R.string.point3_inn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.bt3out:
                    if(!Player.equals("")) {
                        Action = RecordAction.Action_3point_out;
                        tvOnlineA.setText("    "+getResources().getString(R.string.point3_outn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btFTin:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_FT_in;
                        if (Player.equals("G")) {
                            tvScore2.setText(String.valueOf(Integer.valueOf(tvScore2.getText().toString()) + 1));
                        } else{
                            tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 1));
                        }
                        tvOnlineA.setText("    "+getResources().getString(R.string.FT_inn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btFTout:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_FT_out;
                        tvOnlineA.setText("    "+getResources().getString(R.string.FT_outn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btOR:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_OR;
                        tvOnlineA.setText("    "+getResources().getString(R.string.ORn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btDR:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_DR;
                        tvOnlineA.setText("    "+getResources().getString(R.string.DRn));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btST:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_ST;
                        tvOnlineA.setText("    "+getResources().getString(R.string.ST));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btAS:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_AS;
                        tvOnlineA.setText("    "+getResources().getString(R.string.AS));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btBS:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_BS;
                        tvOnlineA.setText("    "+getResources().getString(R.string.BS));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btTO:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_TO;
                        tvOnlineA.setText("    "+getResources().getString(R.string.TO));
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul==5){}
                        else{
                            insertSQL();}
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1)+"");
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btFoul:
                    if (!Player.equals("")) {
                        Action = RecordAction.Action_Foul;
                        if (Player.equals("G")) {
                            int sectionfoul2 = Integer.valueOf(tvSectionFoul2.getText().toString());
                            if(sectionfoul2<5)
                                tvSectionFoul2.setText(String.valueOf(sectionfoul2+1));}
                        else {
                            int sectionfoul1 = Integer.valueOf(tvSectionFoul1.getText().toString());
                            if(sectionfoul1<5)
                                tvSectionFoul1.setText(String.valueOf(sectionfoul1+1));}
                        tvOnlineA.setText("    "+getResources().getString(R.string.foul));
                        int foul2=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(!Player.equals("G") && foul2==5){}  //五犯的球員不再記錄到資料庫
                        else{
                            insertSQL();}
                        Log.d("PLAYER",pid+","+Player);
                        int foul=new ActionDAO(ButtonRecord.this).getFoul(pid, Player);
                        if(foul>2) //如果三犯以上，跳出警告
                        {
                            if(!Player.equals("G"))
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ButtonRecord.this);
                                builder.setTitle(getResources().getString(R.string.Number)+"  "+Player+"  "+
                                        getResources().getString(R.string.already_foul)+"  "+foul);
                                if(foul==5)
                                {
                                    builder.setMessage("\n"+getResources().getString(R.string.foul_out)+
                                            "\n"+getResources().getString(R.string.change_other));
                                }
                                builder.setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                builder.setCancelable(false);
                                builder.show();
                            }

                        }
                        clickCancel();
                    }
                    else {
                        tvOnlineN.setText(getResources().getString(R.string.choosePlayer1));
                        tvOnlineA.setText(getResources().getString(R.string.choosePlayer2));}
                    break;
                case R.id.btNextSection:
                    if(Section == 1)
                    { Section = RecordAction.Section2;
                        tvOnlineN.setText(getResources().getString(R.string.section2));
                        tvOnlineA.setText("   "+getResources().getString(R.string.start));}
                    else if (Section == 2)
                    {Section = RecordAction.Section3;
                        tvOnlineN.setText(getResources().getString(R.string.section3));
                        tvOnlineA.setText("   "+getResources().getString(R.string.start));}
                    else if (Section == 3)
                    {Section = RecordAction.Section4;
                        tvOnlineN.setText(getResources().getString(R.string.section4));
                        tvOnlineA.setText("   "+getResources().getString(R.string.start));}
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
        public void insertSQL()
        {
            ActionDAO dao= new ActionDAO(ButtonRecord.this);
            dao.insertAction(new Action(pid,Section,Player,Action));
            flag=true;
            Log.d("FLAG",flag+"");
        }
    }

    class MyPlayersListener implements CompoundButton.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rbNumber1:
                    rg2.clearCheck();
                    Player = rbNumber1.getText().toString();
                    tvOnlineN.setText(getResources().getString(R.string.Number)+Player+"");
                    tvOnlineA.setText("");
                    break;
                case R.id.rbNumber2:
                    rg2.clearCheck();
                    Player = rbNumber2.getText().toString();
                    tvOnlineN.setText(getResources().getString(R.string.Number)+Player+"");
                    tvOnlineA.setText("");
                    break;
                case R.id.rbNumber3:
                    rg2.clearCheck();
                    Player = rbNumber3.getText().toString();
                    tvOnlineN.setText(getResources().getString(R.string.Number)+Player+"");
                    tvOnlineA.setText("");
                    break;
                case R.id.rbNumber4:
                    rg1.clearCheck();
                    Player = rbNumber4.getText().toString();
                    tvOnlineN.setText(getResources().getString(R.string.Number)+Player+"");
                    tvOnlineA.setText("");
                    break;
                case R.id.rbNumber5:
                    rg1.clearCheck();
                    Player = rbNumber5.getText().toString();
                    tvOnlineN.setText(getResources().getString(R.string.Number)+Player+"");
                    tvOnlineA.setText("");
                    break;
                case R.id.rbOP:
                    Player = "G";
                    rg1.clearCheck();
                    tvOnlineN.setText(getResources().getString(R.string.Opponent)+"");
                    tvOnlineA.setText("");
                    break;

            }
            Log.d("player", Player + "");
        }
    }

    public void clickCancel() {
        Player = "";
        rg1.clearCheck();
        rg2.clearCheck();
    }

    public void clickChange(View v) {
        count = 0;
        for(int i=0;i<chks.length;i++)
        {
            if(chks[i])
            {
                count++;
            }
        }
        Log.d("count",count+"");

        //換球員名單
        AlertDialog.Builder builder = new AlertDialog.Builder(ButtonRecord.this);
        builder.setTitle(getResources().getString(R.string.choose));

//        Log.d("numbers",numbers[1]);
        builder.setMultiChoiceItems(numbers, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                count = 0;
                for(int i=0;i<chks.length;i++)
                {
                    if(chks[i])
                    {
                        count++;
                    }
                }
                Log.d("count",count+"");
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (count != 5) {
                    Toast.makeText(ButtonRecord.this, getResources().getString(R.string.choose), Toast.LENGTH_SHORT).show();
                    tvOnlineN.setText(getResources().getString(R.string.choose1));
                    tvOnlineA.setText(getResources().getString(R.string.choose2));
                }
                else
                {
                    clickCancel();

                    tvOnlineN.setText(getResources().getString(R.string.change1));
                    tvOnlineA.setText(getResources().getString(R.string.change2));

                    rbNumber1.setText("");
                    rbNumber2.setText("");
                    rbNumber3.setText("");
                    rbNumber4.setText("");
                    rbNumber5.setText("");
                    for (int i = 0; i < chks.length; i++) {
                        if (chks[i]) {
                            if (rbNumber1.getText().toString().equals("")) {
                                rbNumber1.setText(numbers[i]);
                            } else if (rbNumber2.getText().toString().equals("")) {
                                rbNumber2.setText(numbers[i]);
                            } else if (rbNumber3.getText().toString().equals("")) {
                                rbNumber3.setText(numbers[i]);
                            } else if (rbNumber4.getText().toString().equals("")) {
                                rbNumber4.setText(numbers[i]);
                            } else if (rbNumber5.getText().toString().equals("")) {
                                rbNumber5.setText(numbers[i]);
                            }
                        }
                    }
                }
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();


    }

    public void clickUndo(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ButtonRecord.this);
        builder.setTitle(getResources().getString(R.string.cancel_question));
        builder.setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvOnlineN.setText(getResources().getString(R.string.alreadycancel1));
                tvOnlineA.setText(getResources().getString(R.string.alreadycancel2));
                ActionDAO dao = new ActionDAO(ButtonRecord.this);
                dao.delAction();
                flag=false;
                Log.d("FLAG",flag+"");
                int []Foul=dao.getFoulBySection(pid,Section);
                int []Scores=dao.getScores(pid);
                tvScore1.setText(String.valueOf(Scores[0]));
                tvScore2.setText(String.valueOf(Scores[1]));
                tvSectionFoul1.setText(String.valueOf(Foul[0]));
                tvSectionFoul2.setText(String.valueOf(Foul[1]));
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        if(flag)
            builder.show();
        else{tvOnlineN.setText(getResources().getString(R.string.one_step1));
            tvOnlineA.setText(getResources().getString(R.string.one_step2));}

    }

    @Override
    protected void onResume() {
        super.onResume();
        Team team=new TeamDAO(ButtonRecord.this).getTeam(pid);
        if(team.getScore1() >0 || team.getScore2()>0)
        {
            finish();
        }
    }
}
