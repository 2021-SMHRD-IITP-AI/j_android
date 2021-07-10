package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ID_PW_FIND3 extends AppCompatActivity {

    private Button btn_find_id2, btn_find_pw2;
    private EditText edt_find_i, edt_find_e2, edt_find_h2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find3);

        btn_find_id2=findViewById(R.id.btn_find_id2);
        btn_find_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND.class);
                startActivity(intent);
            }
        });

//        btn_find_pw2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                edt_find_i.setText(" ");
//                edt_find_e2.setText(" ");
//                edt_find_h2.setText(" ");
//
//            }
//        });

        // 입력값 db로 전달 만들기


    }
}