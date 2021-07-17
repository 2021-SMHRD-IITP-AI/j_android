package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class Lunch_box_main2 extends AppCompatActivity {


    private ImageView back1,img_box1,img_box2;
    private TextView tv_chois1,tv_chois2,tv_chois3,tv_chois4,tv_chois5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main2);

        back1=findViewById(R.id.back1);

        tv_chois1=findViewById(R.id.tv_chois1);
        tv_chois2=findViewById(R.id.tv_chois2);
        tv_chois3=findViewById(R.id.tv_chois3);
        tv_chois4=findViewById(R.id.tv_chois4);
        tv_chois5=findViewById(R.id.tv_chois5);

        img_box1=findViewById(R.id.img_box1);
        img_box2 = findViewById(R.id.img_box2);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");


        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //선택값 보내기
        Intent intent=getIntent();
        String tv1= intent.getStringExtra("result1");
        tv_chois1.setText(tv1);
        String tv2 = intent.getStringExtra("result2");
        tv_chois2.setText(tv2);
        String tv3 = intent.getStringExtra("result3");
        tv_chois3.setText(tv3);
        String tv4 = intent.getStringExtra("result4");
        tv_chois4.setText(tv4);
        String tv5 = intent.getStringExtra("result5");
        tv_chois5.setText(tv5);


        //사진누르면 결제창
        img_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                Intent intent = new Intent(getApplicationContext(), PAY_BAY.class);
                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lunchbax1);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("paybay_img",byteArray);

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);

                startActivity(intent);
            }
        });

        img_box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                Intent intent = new Intent(getApplicationContext(), PAY_BAY.class);
                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lunchbax2);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("paybay_img",byteArray);

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);

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