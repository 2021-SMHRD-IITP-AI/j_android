package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Lunch_box_main extends AppCompatActivity {
    private Button  btn_g,btn_j, btn_nv1,btn_nv2,btn_nv3;

    private RadioButton tbtn_1,tbtn_2,tbtn_3,tbtn_4,tbtn_5,tbtn_6,tbtn_7
            ,tbtn_8,tbtn_9,tbtn_10,tbtn_11,tbtn_12,tbtn_13,tbtn_14,tbtn_15;

    private String result1,result2, result3, result4, result5;

    private ImageView back1, search1, shp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

        btn_j=findViewById(R.id.btn_j);
        btn_g=findViewById(R.id.btn_g);
        btn_nv1 =findViewById(R.id.btn_nv1);
        btn_nv2 =findViewById(R.id.btn_nv2);
        btn_nv3 =findViewById(R.id.btn_nv3);


        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);



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

        //담는 버튼
        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //라디오버튼 선택값 저장 코드 작성필요


                Toast.makeText(getApplicationContext(),"선택되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

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
                    result1 ="닭가슴살";
                }else if(checkedId ==R.id.tbtn_2){
                    Toast.makeText(getApplicationContext(),"흰살생선 선택",Toast.LENGTH_SHORT).show();
                    result1 ="흰살생선";
                }else if(checkedId == R.id.tbtn_3){
                    Toast.makeText(getApplicationContext(),"두부 선택",Toast.LENGTH_SHORT).show();
                    result1 ="두부";
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
                    result2 ="흰쌀밥";
                }else if(checkedId ==R.id.tbtn_5){
                    Toast.makeText(getApplicationContext(),"잡곡밥 선택",Toast.LENGTH_SHORT).show();
                   result2="잡곡밥";
                }else if(checkedId == R.id.tbtn_6){
                    Toast.makeText(getApplicationContext(),"곤약밥 선택",Toast.LENGTH_SHORT).show();
                    result2="곤약밥";
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
                    result3="녹색채소";
                }else if(checkedId ==R.id.tbtn_8){
                    Toast.makeText(getApplicationContext(),"씨앗류 선택",Toast.LENGTH_SHORT).show();
                    result3="씨앗류";
                }else if(checkedId == R.id.tbtn_9){
                    Toast.makeText(getApplicationContext(),"견과류 선택",Toast.LENGTH_SHORT).show();
                    result3="견과류";
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
                    result4="과일";
                }else if(checkedId ==R.id.tbtn_11){
                    Toast.makeText(getApplicationContext(),"버섯 선택",Toast.LENGTH_SHORT).show();
                    result4="버섯";
                }else if(checkedId == R.id.tbtn_12){
                    Toast.makeText(getApplicationContext(),"황색채소 선택",Toast.LENGTH_SHORT).show();
                    result4="황색채소";
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
                    result5="치즈";
                }else if(checkedId ==R.id.tbtn_14){
                    Toast.makeText(getApplicationContext(),"멸치 선택",Toast.LENGTH_SHORT).show();
                    result5="멸치";
                }else if(checkedId == R.id.tbtn_15){
                    Toast.makeText(getApplicationContext(),"해조류 선택",Toast.LENGTH_SHORT).show();
                    result5="해조류";
                }else{
                    Toast.makeText(getApplicationContext(),"칼슘 식품을 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //담기 버튼
        btn_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result1 != null && result2 != null && result3 != null && result4 != null && result5 != null){
                    Toast.makeText(Lunch_box_main.this, (CharSequence) btn_j,Toast.LENGTH_SHORT).show();
                    Log.v("야", "담기 성공");

//                    Intent intent = new Intent(getApplicationContext(),);
//                    intent.putExtra("result1",result1);
//                    intent.putExtra("result2",result2);
//                    intent.putExtra("result3",result3);
//                    intent.putExtra("result4",result4);
//                    intent.putExtra("result5",result5);
//                    startActivity(intent);

                }else{
                    Toast.makeText(Lunch_box_main.this,"영양소를 선택 해주세요",Toast.LENGTH_SHORT).show();
                    Log.v("야","안 담김");
                }

            }
        });

        //구매하기 버튼
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //맞춤 도시락 구매페이지 인텐트 필요

                //맞게 담았는지 확인하는 코드 작성하기
                if(result1 != null && result2 != null && result3 != null && result4 != null && result5 != null){
                Toast.makeText(Lunch_box_main.this, (CharSequence) btn_j,Toast.LENGTH_SHORT).show();
                    Log.v("야", "담기 성공");
//                    Intent intent = new Intent(getApplicationContext(),);
//                    intent.putExtra("result1",result1);
//                    intent.putExtra("result2",result2);
//                    intent.putExtra("result3",result3);
//                    intent.putExtra("result4",result4);
//                    intent.putExtra("result5",result5);
//                    startActivity(intent);


                }else{
                   Toast.makeText(Lunch_box_main.this,"영양소를 선택 해주세요",Toast.LENGTH_SHORT).show();
                    Log.v("야","안 담김"+ result1);


                }
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