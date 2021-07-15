package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bar extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView B_img1,B_img2, B_img3,B_img4, B_img5,B_img6, B_img7, B_img8, shp1,back1;
    private TextView B_name1, B_name2, B_name3, B_name4, B_name5, B_name6, B_name7, B_name8,
            B_price1, B_price2, B_price3, B_price4, B_price5, B_price6, B_price7, B_price8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        B_img1 = findViewById(R.id.B_img1);
        B_img2 = findViewById(R.id.B_img2);
        B_img3 = findViewById(R.id.B_img3);
        B_img4 = findViewById(R.id.B_img4);
        B_img5 = findViewById(R.id.B_img5);
        B_img6 = findViewById(R.id.B_img6);
        B_img7 = findViewById(R.id.B_img7);
        B_img8 = findViewById(R.id.B_img8);
        shp1=findViewById(R.id.shp1);
        back1=findViewById(R.id.back1);

        B_price1= findViewById(R.id.B_price1);
        B_price2= findViewById(R.id.B_price2);
        B_price3= findViewById(R.id.B_price3);
        B_price4= findViewById(R.id.B_price4);
        B_price5= findViewById(R.id.B_price5);
        B_price6= findViewById(R.id.B_price6);
        B_price7= findViewById(R.id.B_price7);
        B_price8= findViewById(R.id.B_price8);

        B_name1 = findViewById(R.id.B_name1);
        B_name2 = findViewById(R.id.B_name2);
        B_name3 = findViewById(R.id.B_name3);
        B_name4 = findViewById(R.id.B_name4);
        B_name5 = findViewById(R.id.B_name5);
        B_name6 = findViewById(R.id.B_name6);
        B_name7 = findViewById(R.id.B_name7);
        B_name8 = findViewById(R.id.B_name8);

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });


        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }
        });

        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Recommend_lunch_box.class);
                startActivity(intent);
            }
        });

        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lunch_box_main.class);
                startActivity(intent);
            }
        });

        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Salad.class);
                startActivity(intent);
            }
        });

        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Snack.class);
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