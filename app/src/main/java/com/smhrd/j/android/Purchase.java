package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class Purchase extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, btn_j, btn_g;
    private  ImageView shp1, back1, Pu_img1;
    private TextView Pu_name1, Pu_price1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        btn_j = findViewById(R.id.btn_j);
        btn_g = findViewById(R.id.btn_g);

        shp1=findViewById(R.id.shp1);
        back1 = findViewById(R.id.back1);

        Pu_img1 = findViewById(R.id.Pu_img1);
        Pu_name1 = findViewById(R.id.Pu_name1);
        Pu_price1 = findViewById(R.id.Pu_price1);

        // 이미지, 이름, 가격 가져오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("recom_name");
        String price = intent.getStringExtra("recom_price");
        byte[] byteArray = getIntent().getByteArrayExtra("recom_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        Pu_img1.setImageBitmap(bitmap);
        Pu_name1.setText(name);
        Pu_price1.setText(price);

        // 장바구니
        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) Pu_img1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(getApplicationContext(), Cart.class);
                intent.putExtra("purchase_img", byteArray);
                intent.putExtra("purchase_name", Pu_name1.getText().toString());
                intent.putExtra("purchase_price", Pu_price1.getText().toString());
                startActivity(intent);
            }
        });

        // 결제
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) Pu_img1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(getApplicationContext(), Payment.class);
                intent.putExtra("purchase_img", byteArray);
                intent.putExtra("purchase_name", Pu_name1.getText().toString());
                intent.putExtra("purchase_price", Pu_price1.getText().toString());
                startActivity(intent);
            }
        });

        // 뒤로가기
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


    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("Back", "확인");
        super.onBackPressed();
    }
}