package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Lunch_box_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

        final RadioGroup group1=(RadioGroup)findViewById(R.id.RadioGroup_1);
        final RadioGroup group2=(RadioGroup)findViewById(R.id.RadioGroup_2);
        final RadioGroup group3=(RadioGroup)findViewById(R.id.RadioGroup_3);
        final RadioGroup group4=(RadioGroup)findViewById(R.id.RadioGroup_4);
        final RadioGroup group5=(RadioGroup)findViewById(R.id.RadioGroup_5);

        Button tbtn_1=(Button)findViewById(R.id.tbtn_1);

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton)findViewById(checkedId);
            }
        });

        //라디오 버튼 클릭시 이벤트(db로 값 넘겨주기)



    }
}