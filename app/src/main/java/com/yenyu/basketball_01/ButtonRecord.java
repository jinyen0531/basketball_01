package com.yenyu.basketball_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonRecord extends AppCompatActivity {
    Button bt2in, bt2out, bt3in, bt3out, btFTin, btFTout, btOR, btDR, btST, btAS, btBS, btTO, btFoul, btNextSection;
    RadioButton rbNumber1, rbNumber2, rbNumber3, rbNumber4, rbNumber5, rbOP;
    TextView tvScore1, tvScore2, tvSectionFoul1, tvSectionFoul2, tvSection;
    RadioGroup rg1,rg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_record);

        tvScore1 = (TextView) findViewById(R.id.tvScore1);
        tvScore2 = (TextView) findViewById(R.id.tvScore2);
        tvSectionFoul1 = (TextView) findViewById(R.id.tvSectionFoul1);
        tvSectionFoul2 = (TextView) findViewById(R.id.tvSectionFoul2);
        tvSection = (TextView) findViewById(R.id.tvSection);

        rg1=(RadioGroup) findViewById(R.id.rg1);
        rg2=(RadioGroup) findViewById(R.id.rg2);



        bt2in = (Button) findViewById(R.id.bt2in);
        bt2out = (Button) findViewById(R.id.bt2out);
        bt3in = (Button) findViewById(R.id.bt3in);
        bt3out = (Button) findViewById(R.id.bt3out);
        btFTin = (Button) findViewById(R.id.btFTin);
        btFTout = (Button) findViewById(R.id.btFTout);
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
        rbOP = (RadioButton) findViewById(R.id.rbOP);


        rbNumber1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg2.clearCheck();
            }
        });
        rbNumber2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg2.clearCheck();
            }
        });
        rbNumber3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg2.clearCheck();
            }
        });
        rbNumber4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg1.clearCheck();
            }
        });
        rbNumber5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg1.clearCheck();
            }
        });
        rbOP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rg1.clearCheck();
            }
        });

        MyOnClickListener listener = new MyOnClickListener();
        bt2in.setOnClickListener(listener);
        bt2out.setOnClickListener(listener);
        bt3in.setOnClickListener(listener);
        bt3out.setOnClickListener(listener);
        btFTin.setOnClickListener(listener);
        btFTout.setOnClickListener(listener);
        btDR.setOnClickListener(listener);
        btOR.setOnClickListener(listener);
        btST.setOnClickListener(listener);
        btAS.setOnClickListener(listener);
        btBS.setOnClickListener(listener);
        btTO.setOnClickListener(listener);
        btFoul.setOnClickListener(listener);
        btNextSection.setOnClickListener(listener);


    }


    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt2in:
                    tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 2));
                    Toast.makeText(ButtonRecord.this, "兩分球進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt2out:
                    Toast.makeText(ButtonRecord.this, "兩分球不進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt3in:
                    tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 3));
                    Toast.makeText(ButtonRecord.this, "三分球進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt3out:
                    Toast.makeText(ButtonRecord.this, "三分球不進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btFTin:
                    tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 1));
                    Toast.makeText(ButtonRecord.this, "罰球進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btFTout:
                    Toast.makeText(ButtonRecord.this, "罰球不進", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btOR:
                    Toast.makeText(ButtonRecord.this, "進攻籃板", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btDR:
                    Toast.makeText(ButtonRecord.this, "防守籃板", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btST:
                    Toast.makeText(ButtonRecord.this, "抄截", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btAS:
                    Toast.makeText(ButtonRecord.this, "助攻", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btBS:
                    Toast.makeText(ButtonRecord.this, "阻攻", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btTO:
                    Toast.makeText(ButtonRecord.this, "失誤", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btFoul:
                    int sectionfoul1 = Integer.valueOf(tvSectionFoul1.getText().toString());
                    if(sectionfoul1<5)
                        tvSectionFoul1.setText(String.valueOf(sectionfoul1+1));
                    Toast.makeText(ButtonRecord.this, "犯規", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btNextSection:
                    int tvsection = Integer.valueOf(tvSection.getText().toString());
                    if(tvsection<4) {
                        tvSection.setText(String.valueOf(tvsection + 1));
                    }
            }
        }
    }



}
