package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Salad extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView Sa_img1, Sa_img2, Sa_img3,Sa_img4, Sa_img5, Sa_img6, Sa_img7, Sa_img8 , shp1, back1;
    private TextView Sa_name1, Sa_name2, Sa_name3, Sa_name4, Sa_name5, Sa_name6, Sa_name7, Sa_name8,
            Sa_price1, Sa_price2, Sa_price3, Sa_price4, Sa_price5, Sa_price6, Sa_price7, Sa_price8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);


        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        Sa_img1 = findViewById(R.id.Sa_img1);
        Sa_img2 = findViewById(R.id.Sa_img2);
        Sa_img3 = findViewById(R.id.Sa_img3);
        Sa_img4 = findViewById(R.id.Sa_img4);
        Sa_img5 = findViewById(R.id.Sa_img5);
        Sa_img6 = findViewById(R.id.Sa_img6);
        Sa_img7 = findViewById(R.id.Sa_img7);
        Sa_img8 = findViewById(R.id.Sa_img8);
        shp1=findViewById(R.id.shp1);
        back1=findViewById(R.id.back1);

        Sa_price1 = findViewById(R.id.Sa_price1);
        Sa_price2 = findViewById(R.id.Sa_price2);
        Sa_price3 = findViewById(R.id.Sa_price3);
        Sa_price4 = findViewById(R.id.Sa_price4);
        Sa_price5 = findViewById(R.id.Sa_price5);
        Sa_price6 = findViewById(R.id.Sa_price6);
        Sa_price7 = findViewById(R.id.Sa_price7);
        Sa_price8 = findViewById(R.id.Sa_price8);

        Sa_name1 = findViewById(R.id.Sa_name1);
        Sa_name2 = findViewById(R.id.Sa_name2);
        Sa_name3 = findViewById(R.id.Sa_name3);
        Sa_name4 = findViewById(R.id.Sa_name4);
        Sa_name5 = findViewById(R.id.Sa_name5);
        Sa_name6 = findViewById(R.id.Sa_name6);
        Sa_name7 = findViewById(R.id.Sa_name7);
        Sa_name8 = findViewById(R.id.Sa_name8);


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


        //헬스케어
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
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
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
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
        Log.v("Back","확인");
        super.onBackPressed();
    }
}