package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_hw;
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("hhd","111");

        Log.v("tt","123");

        tv_hw = findViewById(R.id.tv_hw);
        btn_test = findViewById(R.id.btn_test);

        Log.v("ada","15151515");
        Log.v("ada","15151515");

    }
}