package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class HealthCare extends AppCompatActivity {

    private TextView tv_recom, tv_warn, tv_userInfo, tv_dise;
    private Button btn_nv1, btn_nv2, btn_nv3;
    private ImageView back1, search1, shp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        // 텍스트뷰
        tv_recom = findViewById(R.id.tv_recom);
        tv_warn = findViewById(R.id.tv_warn);
        tv_userInfo = findViewById(R.id.tv_userInfo);
        tv_dise = findViewById(R.id.tv_dise);

        // 버튼
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);

        //이미지
        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

        // 추천 및 주의식품 정보 출력
        Intent intent = getIntent();
        String diseInfo = intent.getStringExtra("diseData");
        try {
            JSONObject jsonObject = new JSONObject(diseInfo);
            String recom = jsonObject.getString("recom");
            String warn = jsonObject.getString("warn");
            Log.v("result", recom);
            Log.v("result2", warn);

            tv_recom.setText(recom);
            tv_warn.setText(warn);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        tv_userInfo.setText(user + "님의 질환에 따른 정보");
        tv_dise.setText(status + "에 추천 식품");

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