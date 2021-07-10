package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HealthCare extends AppCompatActivity {

    private TextView tv_recom, tv_warn, tv_userInfo;
    private Button btn_nv1, btn_nv2, btn_nv3;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        // 텍스트뷰
        tv_recom = findViewById(R.id.tv_recom);
        tv_warn = findViewById(R.id.tv_warn);
        tv_userInfo = findViewById(R.id.tv_userInfo);

        // 버튼
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);

        Intent intent = getIntent();
        result = intent.getStringExtra("result");

        tv_recom.setText(result);

        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
    }
}