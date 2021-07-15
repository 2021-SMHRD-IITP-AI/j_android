package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, cart_btn_minus1, cart_btn_minus2, cart_btn_plus1, cart_btn_plus2, btn_j, btn_g;
    private ImageView back1, cart_img1, cart_img2;
    private TextView cart_tv_name1, cart_tv_name2, cart_tv_price1, cart_tv_price2, cart_tv_sum, cart_tv_total, cart_tv_count1, cart_tv_count2, cart_tv_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        cart_btn_minus1 = findViewById(R.id.cart_btn_minus1);
        cart_btn_minus2 = findViewById(R.id.cart_btn_minus2);
        cart_btn_plus1 = findViewById(R.id.cart_btn_plus1);
        cart_btn_plus2 = findViewById(R.id.cart_btn_plus2);
        btn_j = findViewById(R.id.btn_j);
        btn_g = findViewById(R.id.btn_g);

        cart_tv_count1 = findViewById(R.id.cart_tv_count1);
        cart_tv_count2 = findViewById(R.id.cart_tv_count2);
        cart_tv_name1 = findViewById(R.id.cart_tv_name1);
        cart_tv_name2 = findViewById(R.id.cart_tv_name2);
        cart_tv_price1 = findViewById(R.id.cart_tv_price1);
        cart_tv_price2 = findViewById(R.id.cart_tv_price2);
        cart_tv_sum = findViewById(R.id.cart_tv_sum);
        cart_tv_total = findViewById(R.id.cart_tv_total);
        cart_tv_trans = findViewById(R.id.cart_tv_trans);

        back1 = findViewById(R.id.back1);
        cart_img1 = findViewById(R.id.cart_img1);
        cart_img2 = findViewById(R.id.cart_img2);

        // 이미지, 이름, 가격 가져오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("purchase_name");
        String price = intent.getStringExtra("purchase_price");
        byte[] byteArray = getIntent().getByteArrayExtra("purchase_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        cart_img1.setImageBitmap(bitmap);
        cart_tv_name1.setText(name);
        cart_tv_price1.setText(price);

        cart_img2.setImageBitmap(null);
        cart_tv_name2.setText("");
        cart_tv_price2.setText("");
        cart_tv_trans.setText("2,500원");
        cart_tv_sum.setText(cart_tv_price1.getText().toString() + cart_tv_price2.getText().toString());
        cart_tv_total.setText(cart_tv_price1.getText().toString() + cart_tv_price2.getText().toString() + cart_tv_trans.getText().toString());

        // 뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 장바구니
        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
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
        Log.v("Back","확인");
        super.onBackPressed();
    }
}