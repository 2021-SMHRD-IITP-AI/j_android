package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Lunch_test extends AppCompatActivity {
    private TextView test1, test2, test3, test4, test5, val1, val2, val3, val4, val5, day1, day2, day3, day4, day5,
    na, va, da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_test);

        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);
        test3 = findViewById(R.id.test3);
        test4 = findViewById(R.id.test4);
        test5 = findViewById(R.id.test5);
        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        val3 = findViewById(R.id.val3);
        val4 = findViewById(R.id.val4);
        val5 = findViewById(R.id.val5);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);
        day5 = findViewById(R.id.day5);
        na = findViewById(R.id.na);
        va = findViewById(R.id.va);
        da = findViewById(R.id.da);

        day1.setText("60g");
        day2.setText("328g");
        day3.setText("50g");
        day4.setText("100mg");
        day5.setText("700mg");
        na.setText("선택한 식재료");
        va.setText("100g 당 함유량");
        da.setText("하루 권장 섭취량");

        Intent intent = getIntent();

        String result1 = intent.getStringExtra("result1");
        String result2 = intent.getStringExtra("result2");
        String result3 = intent.getStringExtra("result3");
        String result4 = intent.getStringExtra("result4");
        String result5 = intent.getStringExtra("result5");

        test1.setText(result1);
        test2.setText(result2);
        test3.setText(result3);
        test4.setText(result4);
        test5.setText(result5);

        if(result1.equals("두부")){
            val1.setText("단백질 함유량 9g");
        } else if(result1.equals("닭가슴살")){
            val1.setText("단백질 함유량 28g");
        } else if(result1.equals("흰살생선")){
            val1.setText("단백질 함유량 25g");
        }

        if(result2.equals("흰 쌀밥")){
            val2.setText("탄수화물 함유량 33g");
        } else if(result2.equals("잡곡밥")){
            val2.setText("탄수화물 함유량 28g");
        } else if(result2.equals("곤약밥")){
            val2.setText("탄수화물 함유량 25g");
        }

        if(result3.equals("녹색채소")){
            val3.setText("지방 함유량 10g");
        } else if(result3.equals("씨앗류")){
            val3.setText("지방 함유량 15g");
        } else if(result3.equals("견과류")){
            val3.setText("지방 함유량 17g");
        }

        if(result4.equals("과일")){
            val4.setText("비티민 함유량 20g");
        } else if(result4.equals("버섯")){
            val4.setText("비티민 함유량 15g");
        } else if(result4.equals("황색채소")){
            val4.setText("비티민 함유량 18g");
        }

        if(result5.equals("치즈")){
            val5.setText("칼슘 함유량 23g");
        } else if(result5.equals("멸치")){
            val5.setText("칼슘 함유량 30g");
        } else if(result5.equals("해조류")){
            val5.setText("칼슘 함유량 20g");
        }
    }
}