package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Recommend_lunch_box extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView img_recom1, img_recom2, img_recom3, img_recom4, img_recom5, img_recom6, img_recom7, img_recom8,back1, shp1;
    private TextView tv_recom_name1, tv_recom_name2, tv_recom_name3, tv_recom_name4, tv_recom_name5, tv_recom_name6, tv_recom_name7, tv_recom_name8,
            tv_recom_price1, tv_recom_price2, tv_recom_price3, tv_recom_price4, tv_recom_price5, tv_recom_price6, tv_recom_price7, tv_recom_price8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_lunch_box);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        img_recom1 = findViewById(R.id.img_recom1);
        img_recom2 = findViewById(R.id.img_recom2);
        img_recom3 = findViewById(R.id.img_recom3);
        img_recom4 = findViewById(R.id.img_recom4);
        img_recom5 = findViewById(R.id.img_recom5);
        img_recom6 = findViewById(R.id.img_recom6);
        img_recom7 = findViewById(R.id.img_recom7);
        img_recom8 = findViewById(R.id.img_recom8);
        back1=findViewById(R.id.back1);
        shp1 =findViewById(R.id.shp1);

        tv_recom_name1 = findViewById(R.id.tv_recom_name1);
        tv_recom_name2 = findViewById(R.id.tv_recom_name2);
        tv_recom_name3 = findViewById(R.id.tv_recom_name3);
        tv_recom_name4 = findViewById(R.id.tv_recom_name4);
        tv_recom_name5 = findViewById(R.id.tv_recom_name5);
        tv_recom_name6 = findViewById(R.id.tv_recom_name6);
        tv_recom_name7 = findViewById(R.id.tv_recom_name7);
        tv_recom_name8 = findViewById(R.id.tv_recom_name8);

        tv_recom_price1 = findViewById(R.id.tv_recom_price1);
        tv_recom_price2 = findViewById(R.id.tv_recom_price2);
        tv_recom_price3 = findViewById(R.id.tv_recom_price3);
        tv_recom_price4 = findViewById(R.id.tv_recom_price4);
        tv_recom_price5 = findViewById(R.id.tv_recom_price5);
        tv_recom_price6 = findViewById(R.id.tv_recom_price6);
        tv_recom_price7 = findViewById(R.id.tv_recom_price7);
        tv_recom_price8 = findViewById(R.id.tv_recom_price8);

        ImageView[] imgs = {img_recom1,img_recom2,img_recom3,img_recom4,img_recom5,img_recom6,img_recom7,img_recom8};
        TextView[] names = {tv_recom_name1, tv_recom_name2, tv_recom_name3, tv_recom_name4, tv_recom_name5, tv_recom_name6, tv_recom_name7, tv_recom_name8};
        TextView[] prices = {tv_recom_price1, tv_recom_price2, tv_recom_price3, tv_recom_price4, tv_recom_price5, tv_recom_price6, tv_recom_price7, tv_recom_price8};

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

        Intent intent = getIntent();
        String[] values = intent.getStringArrayExtra("imageUrl");
        String[] values2 = intent.getStringArrayExtra("imgName");
        String[] values3 = intent.getStringArrayExtra("imgPrice");
        for(int i = 0; i < values.length; i++) {
            ImageLoadTask task = new ImageLoadTask(values[i], imgs[i]);
            task.execute();

            names[i].setText(values2[i]);

            prices[i].setText(values3[i]);
        }

        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }
        });



        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        //도시락
        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Recommend_lunch_box.class);
                startActivity(intent);
            }
        });

        //맞춤도시락
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lunch_box_main.class);
                startActivity(intent);
            }
        });

        //셀러드
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Salad.class);
                startActivity(intent);
            }
        });

        //간편식
        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Snack.class);
                startActivity(intent);
            }
        });

        //건강간식
        top5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Bar.class);
                startActivity(intent);
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