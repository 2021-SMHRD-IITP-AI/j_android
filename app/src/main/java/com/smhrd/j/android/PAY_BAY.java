package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PAY_BAY extends AppCompatActivity {

    RadioGroup rg_rg;
    Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bay);

        rg_rg=findViewById(R.id.rg_rg);
        btn_pay=findViewById(R.id.btn_pay);

        //결제하면 창 띄우기
        rg_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rd_3){

                    LinearLayout layout_g = findViewById(R.id.layout_g);
                    layout_g.setVisibility(View.VISIBLE);
                }else{

                }
            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"결제성공",Toast.LENGTH_SHORT).show();
            }
        });

    }
}