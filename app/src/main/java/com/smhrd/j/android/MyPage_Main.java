package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyPage_Main extends AppCompatActivity {
    private ImageView back1, search1, shp1;
    private Button btn_nv1,btn_nv2,btn_nv3, MY_point,MY_coupon, MY_order;
    private TextView MY_member, MY_cart, MY_qna, MY_my;

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_main);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);


        btn_nv1 =findViewById(R.id.btn_nv1);
        btn_nv2 =findViewById(R.id.btn_nv2);
        btn_nv3 =findViewById(R.id.btn_nv3);
        MY_point =findViewById(R.id.MY_pint);
        MY_coupon=findViewById(R.id.MY_coupon);
        MY_order = findViewById(R.id.MY_order);

        MY_member = findViewById(R.id.MY_member);
        MY_cart = findViewById(R.id.MY_cart);
        MY_qna = findViewById(R.id.MY_qna);
        MY_my = findViewById(R.id.MY_my);


        //뒤로가기
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

        MY_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Coupon.class);
                startActivity(intent);
            }
        });

        MY_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = getIntent();
                String id = newIntent.getStringExtra("id");
                String name = newIntent.getStringExtra("name");
                String tel = newIntent.getStringExtra("tel");
                String address = newIntent.getStringExtra("address");
                String email = newIntent.getStringExtra("email");

                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}