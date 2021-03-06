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

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

        // ?????????, ??????, ?????? ????????????
        Intent intent = getIntent();
        String name = intent.getStringExtra("purchase_name");
        String price = intent.getStringExtra("purchase_price");
        byte[] byteArray = getIntent().getByteArrayExtra("purchase_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        pay_img1.setImageBitmap(bitmap);
        pay_tv_name1.setText(name);
        pay_tv_price1.setText(price);

        pay_tv_trans.setText("2500");
        pay_tv_dc.setText("0");
        pay_tv_sum.setText(pay_tv_price1.getText().toString());
        int price1 = Integer.parseInt(pay_tv_price1.getText().toString());
        int trans = Integer.parseInt(pay_tv_trans.getText().toString());
        pay_tv_total.setText(String.valueOf(price1 + trans));

        //????????????
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // ??????
        btn_contract3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ?????? ?????????, ??????, ?????? ?????????
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) pay_img1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(getApplicationContext(), PAY_BAY.class);
                intent.putExtra("paybay_img", byteArray);
                intent.putExtra("paybay_name", pay_tv_name1.getText().toString());
                intent.putExtra("paybay_price", pay_tv_price1.getText().toString());
                intent.putExtra("paybay_total", pay_tv_total.getText().toString());

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);

            }
        });

        //????????????
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });


        //????????????
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

        //??????
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

        //???????????????
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

    //????????????
    @Override
    public void onBackPressed() {
        Log.v("Back","??????");
        super.onBackPressed();
    }

}