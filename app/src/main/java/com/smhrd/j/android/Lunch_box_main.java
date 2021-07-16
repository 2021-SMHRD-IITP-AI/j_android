package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Lunch_box_main extends AppCompatActivity {
    private Button  btn_g,btn_j, btn_nv1, btn_nv2, btn_nv3;

    private RadioButton tbtn_1,tbtn_2,tbtn_3,tbtn_4,tbtn_5,tbtn_6,tbtn_7
            ,tbtn_8,tbtn_9,tbtn_10,tbtn_11,tbtn_12,tbtn_13,tbtn_14,tbtn_15;

    private String result1,result2, result3, result4, result5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

        btn_j=findViewById(R.id.btn_j);
        btn_g=findViewById(R.id.cart_btn_g);
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);

        final RadioGroup group1=(RadioGroup)findViewById(R.id.RadioGroup_1);
        final RadioGroup group2=(RadioGroup)findViewById(R.id.RadioGroup_2);
        final RadioGroup group3=(RadioGroup)findViewById(R.id.RadioGroup_3);
        final RadioGroup group4=(RadioGroup)findViewById(R.id.RadioGroup_4);
        final RadioGroup group5=(RadioGroup)findViewById(R.id.RadioGroup_5);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

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

        //단백질 라디오
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.tbtn_1){
                    Toast.makeText(getApplicationContext(),"닭가슴살 선택",Toast.LENGTH_SHORT).show();
                    result1 ="닭가슴살 28g";
                }else if(checkedId ==R.id.tbtn_2){
                    Toast.makeText(getApplicationContext(),"흰살생선 선택",Toast.LENGTH_SHORT).show();
                    result1 ="흰살생선 25g";
                }else if(checkedId == R.id.tbtn_3){
                    Toast.makeText(getApplicationContext(),"두부 선택",Toast.LENGTH_SHORT).show();
                    result1 ="두부 9g";
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
                    result2 ="흰쌀밥 33g";
                }else if(checkedId ==R.id.tbtn_5){
                    Toast.makeText(getApplicationContext(),"잡곡밥 선택",Toast.LENGTH_SHORT).show();
                    result2="잡곡밥 58g";
                }else if(checkedId == R.id.tbtn_6){
                    Toast.makeText(getApplicationContext(),"곤약밥 선택",Toast.LENGTH_SHORT).show();
                    result2="곤약밥 13g";
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
                    result3="녹색채소 5g";
                }else if(checkedId ==R.id.tbtn_8){
                    Toast.makeText(getApplicationContext(),"씨앗류 선택",Toast.LENGTH_SHORT).show();
                    result3="씨앗류 28g";
                }else if(checkedId == R.id.tbtn_9){
                    Toast.makeText(getApplicationContext(),"견과류 선택",Toast.LENGTH_SHORT).show();
                    result3="견과류 13g";
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
                    result4="과일 99mg";
                }else if(checkedId ==R.id.tbtn_11){
                    Toast.makeText(getApplicationContext(),"버섯 선택",Toast.LENGTH_SHORT).show();
                    result4="버섯 5mg";
                }else if(checkedId == R.id.tbtn_12){
                    Toast.makeText(getApplicationContext(),"황색채소 선택",Toast.LENGTH_SHORT).show();
                    result4="황색채소 17mg";
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
                    result5="치즈 626mg";
                }else if(checkedId ==R.id.tbtn_14){
                    Toast.makeText(getApplicationContext(),"멸치 선택",Toast.LENGTH_SHORT).show();
                    result5="멸치 620mg";
                }else if(checkedId == R.id.tbtn_15){
                    Toast.makeText(getApplicationContext(),"해조류 선택",Toast.LENGTH_SHORT).show();
                    result5="해조류 18mg";
                }else{
                    Toast.makeText(getApplicationContext(),"칼슘 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result1 != null && result2 != null && result3 != null && result4 != null && result5 != null){
                    Log.v("야", "담기 성공");

                    // 맞춤도시락 주문정보 페이지 이동 기능

                    Intent intent = new Intent(getApplicationContext(),Lunch_box_main2.class);
                    intent.putExtra("result1",result1);
                    intent.putExtra("result2",result2);
                    intent.putExtra("result3",result3);
                    intent.putExtra("result4",result4);
                    intent.putExtra("result5",result5);

                    intent.putExtra("id", id);
                    intent.putExtra("name", user);
                    intent.putExtra("tel", tel);
                    intent.putExtra("address", address);
                    intent.putExtra("email", email);
                    intent.putExtra("status", status);

                    startActivity(intent);

                    //버튼 비활성화(else)/영양소 미선택시 팝업
                    //btn_g.setEnabled(true);
                    // return;

                } else{
                    Log.v("야", "담기 실패");
                    Toast.makeText(getApplicationContext(), "5대 영양소를 모두 선택했는지 확인해주세요.", Toast.LENGTH_SHORT);
                }
            }
        });

        //구매하기 버튼
//        btn_g.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //맞춤 도시락 구매페이지 인텐트 필요
//
//                //맞게 담았는지 확인하는 코드 작성하기
//                if(result1 != null && result2 != null && result3 != null && result4 != null && result5 != null){
//                    //Toast.makeText(Lunch_box_main.this, (CharSequence) btn_j,Toast.LENGTH_SHORT).show();
//                    Log.v("야", "구매 성공");
//                    Intent intent = new Intent(getApplicationContext(), Payment.class);
//                    intent.putExtra("result1", result1);
//                    intent.putExtra("result2", result2);
//                    intent.putExtra("result3", result3);
//                    intent.putExtra("result4", result4);
//                    intent.putExtra("result5", result5);
//
//                    intent.putExtra("id", id);
//                    intent.putExtra("name", user);
//                    intent.putExtra("tel", tel);
//                    intent.putExtra("address", address);
//                    intent.putExtra("email", email);
//                    intent.putExtra("status", status);
//                    startActivity(intent);
//                    //버튼 비활성화(else)/영양소 미선택시 팝업
////                    btn_g.setEnabled(true);
//
//                }else{
//                    // Toast.makeText(Lunch_box_main.this,"영양소를 선택 해주세요",Toast.LENGTH_SHORT).show();
//                    // 버튼 활성화
//                    //btn_g.setEnabled(false);
//                    Log.v("야","구매 실패"+ result1);
//                }
//            }
//        });
    }
}