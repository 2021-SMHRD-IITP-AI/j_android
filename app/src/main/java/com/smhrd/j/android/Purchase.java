package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class Purchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        //이미지 받아오기
//        Intent intent = getIntent();
//        byte[] arr = getIntent().getByteArrayExtra("image");
//        image = BitmapFactory.decodeByteArray(arr, 0, arr.length);
//        ImageView BigImage = (ImageView)findViewById(R.id.BigImage);
//        BigImage.setImageBitmap(image);



    }
}