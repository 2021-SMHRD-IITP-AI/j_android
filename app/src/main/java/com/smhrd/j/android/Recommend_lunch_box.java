package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Recommend_lunch_box extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3;
    private ImageView img_recom1, img_recom2, img_recom3, img_recom4, img_recom5, img_recom6, img_recom7, img_recom8;
    private TextView tv_recom_name, tv_recom_name2, tv_recom_name3, tv_recom_name4, tv_recom_name5, tv_recom_name6, tv_recom_name7, tv_recom_name8,
                    tv_recom_price, tv_recom_price2, tv_recom_price3, tv_recom_price4, tv_recom_price5, tv_recom_price6, tv_recom_price7, tv_recom_price8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_lunch_box);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);

        img_recom1 = findViewById(R.id.img_recom1);
        img_recom2 = findViewById(R.id.img_recom2);
        img_recom3 = findViewById(R.id.img_recom3);
        img_recom4 = findViewById(R.id.img_recom4);
        img_recom5 = findViewById(R.id.img_recom5);
        img_recom6 = findViewById(R.id.img_recom6);
        img_recom7 = findViewById(R.id.img_recom7);
        img_recom8 = findViewById(R.id.img_recom8);

        tv_recom_name = findViewById(R.id.tv_recom_name);
        tv_recom_name2 = findViewById(R.id.tv_recom_name2);
        tv_recom_name3 = findViewById(R.id.tv_recom_name3);
        tv_recom_name4 = findViewById(R.id.tv_recom_name4);
        tv_recom_name5 = findViewById(R.id.tv_recom_name5);
        tv_recom_name6 = findViewById(R.id.tv_recom_name6);
        tv_recom_name7 = findViewById(R.id.tv_recom_name7);
        tv_recom_name8 = findViewById(R.id.tv_recom_name8);

        tv_recom_price = findViewById(R.id.tv_recom_price);
        tv_recom_price2 = findViewById(R.id.tv_recom_price2);
        tv_recom_price3 = findViewById(R.id.tv_recom_price3);
        tv_recom_price4 = findViewById(R.id.tv_recom_price4);
        tv_recom_price5 = findViewById(R.id.tv_recom_price5);
        tv_recom_price6 = findViewById(R.id.tv_recom_price6);
        tv_recom_price7 = findViewById(R.id.tv_recom_price7);
        tv_recom_price8 = findViewById(R.id.tv_recom_price8);

        ImageView[] imgs = {img_recom1,img_recom2,img_recom3,img_recom4,img_recom5,img_recom6,img_recom7,img_recom8};
        TextView[] names = {tv_recom_name, tv_recom_name2, tv_recom_name3, tv_recom_name4, tv_recom_name5, tv_recom_name6, tv_recom_name7, tv_recom_name8};
        TextView[] prices = {tv_recom_price, tv_recom_price2, tv_recom_price3, tv_recom_price4, tv_recom_price5, tv_recom_price6, tv_recom_price7, tv_recom_price8};

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
    }
}