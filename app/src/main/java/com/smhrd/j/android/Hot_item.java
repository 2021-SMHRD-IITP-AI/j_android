package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hot_item extends AppCompatActivity {
    private ImageView back1, search1, shp1,hot_img1,hot_img2,hot_img3 ;
    private Button top1,top2,top3,top4,top5,btn_nv1,btn_nv2,btn_nv3;
    private TextView hot_name1, hot_name2, hot_name3,hot_pa1,hot_pa2,hot_pa3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_item2);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);
        hot_img1 =findViewById(R.id.hot_img1);
        hot_img2 =findViewById(R.id.hot_img2);
        hot_img3 =findViewById(R.id.hot_img3);

        top1 =findViewById(R.id.top1);
        top2 =findViewById(R.id.top2);
        top3 =findViewById(R.id.top3);
        top4 =findViewById(R.id.top4);
        top5 =findViewById(R.id.top5);
        btn_nv1 =findViewById(R.id.btn_nv1);
        btn_nv2 =findViewById(R.id.btn_nv2);
        btn_nv3 =findViewById(R.id.btn_nv3);

        hot_name1 =findViewById(R.id.hot_name1);
        hot_name2 =findViewById(R.id.hot_name2);
        hot_name3 =findViewById(R.id.hot_name3);
        hot_pa1 =findViewById(R.id.hot_pa1);
        hot_pa2 =findViewById(R.id.hot_pa2);
        hot_pa3 =findViewById(R.id.hot_pa3);


        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        shp1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),Cart.class);
//                startActivity(intent);
//            }
//        });


    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("Back","확인");
        super.onBackPressed();
    }
}