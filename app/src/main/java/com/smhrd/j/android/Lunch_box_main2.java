package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
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


        img_box1.setImageResource(R.drawable.lunchbax1);

        //사진누르면 결제창
        img_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent1 = new Intent(getApplicationContext(),PAY_BAY.class);
//                startActivity(intent1);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_box1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();



                Intent intent = new Intent(getApplicationContext(), PAY_BAY.class);
                intent.putExtra("imgbox", byteArray);
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