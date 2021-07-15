package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Today_lunch_box extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView T_img1, T_img2, T_img3,T_img4, T_img5, T_img6, T_img7, T_img8 , shp1, back1;
    private TextView T_name1, T_name2, T_name3, T_name4, T_name5, T_name6, T_name7, T_name8,
            T_price1, T_price2, T_price3, T_price4, T_price5, T_price6, T_price7, T_price8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_lunch_box);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        T_img1 = findViewById(R.id.T_img1);
        T_img2 = findViewById(R.id.T_img2);
        T_img3 = findViewById(R.id.T_img3);
        T_img4 = findViewById(R.id.T_img4);
        T_img5 = findViewById(R.id.T_img5);
        T_img6 = findViewById(R.id.T_img6);
        T_img7 = findViewById(R.id.T_img7);
        T_img8 = findViewById(R.id.T_img8);
        shp1=findViewById(R.id.shp1);
        back1=findViewById(R.id.back1);

        T_price1 = findViewById(R.id.T_price1);
        T_price2 = findViewById(R.id.T_price2);
        T_price3 = findViewById(R.id.T_price3);
        T_price4 = findViewById(R.id.T_price4);
        T_price5 = findViewById(R.id.T_price5);
        T_price6 = findViewById(R.id.T_price6);
        T_price7 = findViewById(R.id.T_price7);
        T_price8 = findViewById(R.id.T_price8);

        T_name1 = findViewById(R.id.T_name1);
        T_name2 = findViewById(R.id.T_name2);
        T_name3 = findViewById(R.id.T_name3);
        T_name4 = findViewById(R.id.T_name4);
        T_name5 = findViewById(R.id.T_name5);
        T_name6 = findViewById(R.id.T_name6);
        T_name7 = findViewById(R.id.T_name7);
        T_name8 = findViewById(R.id.T_name8);

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //장바구니
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });


        //건강일지
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
                startActivity(intent);
            }
        });

        //메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
                startActivity(intent);
            }
        });

        //도시락
        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Recommend_lunch_box.class);
                startActivity(intent);
            }
        });

        //맞춤도시락
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lunch_box_main.class);
                startActivity(intent);
            }
        });

        //셀러드
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Salad.class);
                startActivity(intent);
            }
        });

        //간편식
        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Snack.class);
                startActivity(intent);
            }
        });

        //건강간식
        top5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Bar.class);
                startActivity(intent);
            }
        });
    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("그냥 알아들어","확인");
        super.onBackPressed();
    }
}