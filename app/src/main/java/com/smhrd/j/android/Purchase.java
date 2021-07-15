package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Purchase extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3,btn_j,btn_g;
    private  ImageView shp1, back1,Pu_img1;
    private TextView Pu_name1,Pu_price1;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);


        shp1=findViewById(R.id.shp1);
        back1 = findViewById(R.id.back1);

        Pu_name1=findViewById(R.id.Pu_name1);
        Pu_price1 = findViewById(R.id.Pu_price1);
        Pu_img1 = findViewById(R.id.Pu_img1);




        // 이미지, 이름, 가격 가져오기
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("main_name1");
        String price = extras.getString("main_pr1");
        byte[] byteArray = getIntent().getByteArrayExtra("img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Pu_img1.setImageBitmap(bitmap);
        Pu_name1.setText(name);
        Pu_price1.setText(price);

        //이미지 받아오기
//          Intent intent = getIntent();
//        String name = intent.getStringExtra("main_name1");
//        String price = intent.getStringExtra("main_pr1");
//        int main_img1 = intent.getIntExtra("main_img1",R.drawable.main_img4);
//
//        Pu_name1.setText(name);
//        Pu_price1.setText(price);
//        Pu_img1.setImageResource(main_img1);




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


    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("Back", "확인");
        super.onBackPressed();
    }
}