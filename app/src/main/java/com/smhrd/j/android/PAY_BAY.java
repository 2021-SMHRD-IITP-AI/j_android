package com.smhrd.j.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PAY_BAY extends AppCompatActivity {

    private ImageView back1;

    private RadioGroup rg_rg;
    private Button btn_pay;
    TextView tv_ga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bay);

        back1=findViewById(R.id.back1);

        rg_rg=findViewById(R.id.rg_rg);
        btn_pay=findViewById(R.id.btn_pay);

        tv_ga=findViewById(R.id.tv_ga);

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //결제하면 창 띄우기
        rg_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rd_3){

                    LinearLayout layout_g = findViewById(R.id.layout_g);
                    layout_g.setVisibility(View.VISIBLE);
                    LinearLayout layout_p2 =findViewById(R.id.layout_p2);
                    layout_p2.setVisibility(View.VISIBLE);

                }else{

                }
            }
        });

        //결제버튼
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                startActivity(intent);

                AlertDialog.Builder myAlerBuilder = new AlertDialog.Builder(PAY_BAY.this);

                myAlerBuilder.setMessage("결제 성공");

                myAlerBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    }
                });
                myAlerBuilder.setPositiveButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "pressed cancle", Toast.LENGTH_SHORT).show();
                    }
                });

                myAlerBuilder.show();


            }
        });

    }
    //뒤로가기
        @Override
        public void onBackPressed() {
            Log.v("Back","확인");
            super.onBackPressed();
        }
}