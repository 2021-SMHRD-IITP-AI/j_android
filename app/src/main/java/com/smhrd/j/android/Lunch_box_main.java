package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Lunch_box_main extends AppCompatActivity {
    private Button  btn_g;

    private String btn_j;
    private RadioButton tbtn_1,tbtn_2,tbtn_3,tbtn_4,tbtn_5,tbtn_6,tbtn_7
            ,tbtn_8,tbtn_9,tbtn_10,tbtn_11,tbtn_12,tbtn_13,tbtn_14,tbtn_15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

//        btn_j=findViewById(R.id.btn_j);
        btn_g=findViewById(R.id.btn_g);

        //담는 버튼
//        btn_j.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //라디오버튼 선택값 저장 코드 작성필요
//
//
//                Toast.makeText(getApplicationContext(),"선택되었습니다.",Toast.LENGTH_SHORT).show();
//            }
//        });

        final RadioGroup group1=(RadioGroup)findViewById(R.id.RadioGroup_1);
        final RadioGroup group2=(RadioGroup)findViewById(R.id.RadioGroup_2);
        final RadioGroup group3=(RadioGroup)findViewById(R.id.RadioGroup_3);
        final RadioGroup group4=(RadioGroup)findViewById(R.id.RadioGroup_4);
        final RadioGroup group5=(RadioGroup)findViewById(R.id.RadioGroup_5);


        //단백질 라디오
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if(checkedId == R.id.tbtn_1){
                    Toast.makeText(getApplicationContext(),"닭가슴살 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_1.getText().toString();
                }else if(checkedId ==R.id.tbtn_2){
                    Toast.makeText(getApplicationContext(),"흰살생선 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_2.getText().toString();
                }else if(checkedId == R.id.tbtn_3){
                    Toast.makeText(getApplicationContext(),"두부 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_3.getText().toString();
                }else{
                    Toast.makeText(getApplicationContext(),"단백질 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //탄수화물 라디오
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tbtn_4){
                    Toast.makeText(getApplicationContext(),"흰쌀밥 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_4.getText().toString();
                }else if(checkedId ==R.id.tbtn_5){
                    Toast.makeText(getApplicationContext(),"잡곡밥 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_5.getText().toString();
                }else if(checkedId == R.id.tbtn_6){
                    Toast.makeText(getApplicationContext(),"곤약밥 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_6.getText().toString();
                }else{
                    Toast.makeText(getApplicationContext(),"탄수화물 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //지방 라디오
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tbtn_7){
                    Toast.makeText(getApplicationContext(),"녹색채소 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_7.getText().toString();
                }else if(checkedId ==R.id.tbtn_8){
                    Toast.makeText(getApplicationContext(),"씨앗류 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_8.getText().toString();
                }else if(checkedId == R.id.tbtn_9){
                    Toast.makeText(getApplicationContext(),"견과류 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_9.getText().toString();
                }else{
                    Toast.makeText(getApplicationContext(),"지방 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //비타민 라디오
        group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tbtn_10){
                    Toast.makeText(getApplicationContext(),"과일 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_10.getText().toString();
                }else if(checkedId ==R.id.tbtn_11){
                    Toast.makeText(getApplicationContext(),"버섯 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_11.getText().toString();
                }else if(checkedId == R.id.tbtn_12){
                    Toast.makeText(getApplicationContext(),"황색채소 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_12.getText().toString();
                }else{
                    Toast.makeText(getApplicationContext(),"비타민 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //칼슘 라디오
        group5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tbtn_13){
                    Toast.makeText(getApplicationContext(),"치즈 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_13.getText().toString();
                }else if(checkedId ==R.id.tbtn_14){
                    Toast.makeText(getApplicationContext(),"멸치 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_14.getText().toString();
                }else if(checkedId == R.id.tbtn_15){
                    Toast.makeText(getApplicationContext(),"해조류 선택",Toast.LENGTH_SHORT).show();
//                    btn_j=tbtn_15.getText().toString();
                }else{
                    Toast.makeText(getApplicationContext(),"칼슘 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //구매하기 버튼
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //맞춤 도시락 구매페이지 인텐트 필요

                //맞게 담았는지 확인하는 코드 작성하기


//                if(btn_j != null){
//                Toast.makeText(Lunch_box_main.this, (CharSequence) btn_j,Toast.LENGTH_SHORT).show();
//
//                    //버튼 비활성화(else)/영양소 미선택시 팝업
//                    btn_g.setEnabled(true);
//                    return;
//
//                }else{
//                    Toast.makeText(Lunch_box_main.this,"영양소를 선택 해주세요",Toast.LENGTH_SHORT).show();
//                    //버튼 활성화
//                    btn_g.setEnabled(false);
//
//
//                }
            }



        });



   }
}