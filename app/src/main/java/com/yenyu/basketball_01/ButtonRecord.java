package com.yenyu.basketball_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonRecord extends AppCompatActivity {
    Button bt2in, bt2out, bt3in, bt3out, btFTin, btFTout, btOR, btDR, btST, btAS, btBS, btTO, btFoul, btNextSection;
    ToggleButton tbNumber1, tbNumber2, tbNumber3, tbNumber4, tbNumber5, tbOP;
    TextView tvScore1, tvScore2, tvSectionFoul1, tvSectionFoul2, tvSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_record);

        tvScore1 = (TextView) findViewById(R.id.tvScore1);
        tvScore2 = (TextView) findViewById(R.id.tvScore2);
        tvSectionFoul1 = (TextView) findViewById(R.id.tvSectionFoul1);
        tvSectionFoul2 = (TextView) findViewById(R.id.tvSectionFoul2);
        tvSection = (TextView) findViewById(R.id.tvSection);

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

        tbNumber1 = (ToggleButton) findViewById(R.id.tbNumber1);
        tbNumber2 = (ToggleButton) findViewById(R.id.tbNumber2);
        tbNumber3 = (ToggleButton) findViewById(R.id.tbNumber3);
        tbNumber4 = (ToggleButton) findViewById(R.id.tbNumber4);
        tbNumber5 = (ToggleButton) findViewById(R.id.tbNumber5);
        tbOP = (ToggleButton) findViewById(R.id.tbOP);


        tbNumber1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        tbNumber2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "2", Toast.LENGTH_SHORT).show();
            }
        });
        tbNumber3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "3", Toast.LENGTH_SHORT).show();
            }
        });
        tbNumber4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "4", Toast.LENGTH_SHORT).show();
            }
        });
        tbNumber5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "5", Toast.LENGTH_SHORT).show();
            }
        });
        tbOP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ButtonRecord.this, "對手", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(ButtonRecord.this, "犯規", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }

    class OnChangeListener implements CompoundButton.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch(compoundButton.getId())
            {
                case R.id.tbNumber1:
                    if(compoundButton.isChecked())
                    {
                        View.OnClickListener onclick = new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                switch (view.getId()) {
                                    case R.id.bt2in:
                                        tvScore1.setText(String.valueOf(Integer.valueOf(tvScore1.getText().toString()) + 2));
                                        Toast.makeText(ButtonRecord.this, "兩分球進", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        } ;
                        Toast.makeText(ButtonRecord.this, "1", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }

}
