package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

public class Lunch_box_main extends AppCompatActivity {

    private RadioButton radioButton1, radioButton2, radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box_main);

        radioButton1=findViewById(R.id.tbtn_1);
        radioButton2=findViewById(R.id.tbtn_2);
        radioButton3=findViewById(R.id.tbtn_3);


    }
}