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

public class Cart extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, cart_btn_g;
    private ImageView back1, cart_img1, cart_img2;
    private TextView cart_tv_name1, cart_tv_price1, cart_tv_sum, cart_tv_total, cart_tv_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        cart_btn_g = findViewById(R.id.cart_btn_g);

        cart_tv_name1 = findViewById(R.id.cart_tv_name1);
        cart_tv_price1 = findViewById(R.id.cart_tv_price1);
        cart_tv_sum = findViewById(R.id.cart_tv_sum);
        cart_tv_total = findViewById(R.id.cart_tv_total);
        cart_tv_trans = findViewById(R.id.cart_tv_trans);

        back1 = findViewById(R.id.back1);
        cart_img1 = findViewById(R.id.cart_img1);
        cart_img2 = findViewById(R.id.cart_img2);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

        // 이미지, 이름, 가격 가져오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("purchase_name");
        String price = intent.getStringExtra("purchase_price");
        byte[] byteArray = getIntent().getByteArrayExtra("purchase_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        cart_img1.setImageBitmap(bitmap);
        cart_tv_name1.setText(name);
        cart_tv_price1.setText(price);

        cart_tv_trans.setText("2500");
        cart_tv_sum.setText(cart_tv_price1.getText().toString());
        int price1 = Integer.parseInt(cart_tv_price1.getText().toString());
        int trans = Integer.parseInt(cart_tv_trans.getText().toString());
        cart_tv_total.setText(String.valueOf(price1 + trans));

        // 뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 결제
        cart_btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) cart_img1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(getApplicationContext(), Payment.class);
                intent.putExtra("purchase_img", byteArray);
                intent.putExtra("purchase_name", cart_tv_name1.getText().toString());
                intent.putExtra("purchase_price", cart_tv_price1.getText().toString());
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //건강일지
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
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