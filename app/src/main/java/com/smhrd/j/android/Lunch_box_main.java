package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Lunch_box_main extends AppCompatActivity {

    private RadioButton tbtn_1,tbtn_2,tbtn_3,tbtn_4,tbtn_5,tbtn_6,tbtn_7,tbtn_8,
                        tbtn_9, tbtn_10, tbtn_11, tbtn_12, tbtn_13,tbtn_14,tbtn_15;

    private Button btn_j, btn_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

        RadioGroup RadioGroup_1=findViewById(R.id.RadioGroup_1);
        RadioGroup RadioGroup_2=findViewById(R.id.RadioGroup_2);
        RadioGroup RadioGroup_3=findViewById(R.id.RadioGroup_3);
        RadioGroup RadioGroup_4=findViewById(R.id.RadioGroup_4);
        RadioGroup RadioGroup_5=findViewById(R.id.RadioGroup_5);

        btn_j=findViewById(R.id.btn_j);
        btn_g=findViewById(R.id.btn_g);

        RadioGroup_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(Lunch_box_main.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
            }
        });
        RadioGroup_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

            }
        });
        RadioGroup_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

            }
        });
        RadioGroup_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

            }
        });

        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cart.class);
                startActivity(i);

                // 선택값 저장해서 보내주는거 적기
            }
        });

        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Payment.class);
                startActivity(intent);

            }
        });
    }
}