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

public class Payment extends AppCompatActivity {
    private ImageView back1, search1, shp1, pay_img1, pay_img2;
    private Button btn_nv1,btn_nv2,btn_nv3, pay_btn_minus1, pay_btn_minus2,pay_btn_plus1, pay_btn_plus2, btn_contract3;
    private TextView pay_tv_name1, pay_tv_price1, pay_tv_name2, pay_tv_price2,pay_tv_sum, pay_tv_dc, pay_tv_count1, pay_tv_count2, pay_tv_total, pay_tv_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);
        pay_img1 = findViewById(R.id.pay_img1);
        pay_img2 = findViewById(R.id.pay_img2);

        btn_nv1 =findViewById(R.id.btn_nv1);
        btn_nv2 =findViewById(R.id.btn_nv2);
        btn_nv3 =findViewById(R.id.btn_nv3);
        pay_btn_plus1 = findViewById(R.id.pay_btn_plus1);
        pay_btn_plus2 = findViewById(R.id.pay_btn_plus2);
        pay_btn_minus1 = findViewById(R.id.pay_btn_minus1);
        pay_btn_minus2 = findViewById(R.id.pay_btn_minus2);
        btn_contract3 = findViewById(R.id.btn_contract3);

        pay_tv_name1 = findViewById(R.id.pay_tv_name1);
        pay_tv_name2 = findViewById(R.id.pay_tv_name2);
        pay_tv_price1 = findViewById(R.id.pay_tv_price1);
        pay_tv_price2 = findViewById(R.id.pay_tv_price2);
        pay_tv_count1 = findViewById(R.id.pay_tv_count1);
        pay_tv_count2 = findViewById(R.id.pay_tv_count2);
        pay_tv_sum = findViewById(R.id.pay_tv_sum);
        pay_tv_dc = findViewById(R.id.pay_tv_dc);
        pay_tv_total = findViewById(R.id.pay_tv_total);
        pay_tv_trans = findViewById(R.id.pay_tv_trans);

        // 이미지, 이름, 가격 가져오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("purchase_name");
        String price = intent.getStringExtra("purchase_price");
        byte[] byteArray = getIntent().getByteArrayExtra("purchase_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        pay_img1.setImageBitmap(bitmap);
        pay_tv_name1.setText(name);
        pay_tv_price1.setText(price);

        pay_img2.setImageBitmap(null);
        pay_tv_name2.setText("");
        pay_tv_price2.setText("");
        pay_tv_dc.setText("");
        pay_tv_trans.setText("2500");
        pay_tv_sum.setText(pay_tv_price1.getText().toString() + pay_tv_price2.getText().toString());
        pay_tv_total.setText(pay_tv_price1.getText().toString() + pay_tv_price2.getText().toString() + pay_tv_trans.getText().toString());

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 결제
        btn_contract3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        Log.v("Back","확인");
        super.onBackPressed();
    }

}