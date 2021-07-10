package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ID_PW_FIND extends AppCompatActivity {

    private Button btn_find_id, btn_find_pw;
    private EditText edt_find_e, edt_find_h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        edt_find_e=findViewById(R.id.edt_find_e);
        edt_find_h=findViewById(R.id.edt_find_h);

        btn_find_id=findViewById(R.id.btn_find_id);
        btn_find_pw=findViewById(R.id.btn_find_pw);


        btn_find_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND3.class);
                startActivity(intent);

                // 입력값 db로 전달 만들기

            }
        });

        //아이디 찾기 버튼 클릭시 입력값 초기화

        btn_find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_find_e.setText(" ");
                edt_find_h.setText(" ");


            }
        });


    }
}