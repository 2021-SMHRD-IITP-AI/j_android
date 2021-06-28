package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("hhd","111");

        Log.v("tt","123");

        tv_hello = findViewById(R.id.tv_hello);

        Log.v("ada","15151515");
        Log.v("ada","15151515");

    }
}