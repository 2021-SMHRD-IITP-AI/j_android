package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Recommend_lunch_box extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView img_recom1, img_recom2, img_recom3, img_recom4, img_recom5, img_recom6, img_recom7, img_recom8,back1, shp1;
    private TextView tv_recom_name1, tv_recom_name2, tv_recom_name3, tv_recom_name4, tv_recom_name5, tv_recom_name6, tv_recom_name7, tv_recom_name8,
            tv_recom_price1, tv_recom_price2, tv_recom_price3, tv_recom_price4, tv_recom_price5, tv_recom_price6, tv_recom_price7, tv_recom_price8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_lunch_box);

        // 버튼
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        // 이미지
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

        // 텍스트
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

        // Main에서 서버로부터 받은 이미지, 텍스트 정보 가져오기
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

        // 이미지 클릭시 구매페이지 이동
        img_recom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 이미지, 이름, 가격 보내기
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable)img_recom1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name1.getText().toString());
                intent.putExtra("recom_price", tv_recom_price1.getText().toString());
                Log.v("recom_test",tv_recom_name1.getText().toString()+":"+tv_recom_price1.getText().toString());
                startActivity(intent);
            }
        });

        img_recom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("test11","두번째그림 클릭");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom2.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name2.getText().toString());
                intent.putExtra("recom_price", tv_recom_price2.getText().toString());
                Log.v("recom_test",tv_recom_name2.getText().toString()+":"+tv_recom_price2.getText().toString());
                startActivity(intent);
            }
        });

        img_recom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom3.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name3.getText().toString());
                intent.putExtra("recom_price", tv_recom_price3.getText().toString());
                startActivity(intent);
            }
        });

        img_recom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom4.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name4.getText().toString());
                intent.putExtra("recom_price", tv_recom_price4.getText().toString());
                startActivity(intent);
            }
        });

        img_recom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom5.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name5.getText().toString());
                intent.putExtra("recom_price", tv_recom_price5.getText().toString());
                startActivity(intent);
            }
        });

        img_recom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom6.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name6.getText().toString());
                intent.putExtra("recom_price", tv_recom_price6.getText().toString());
                startActivity(intent);
            }
        });

        img_recom7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom7.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name7.getText().toString());
                intent.putExtra("recom_price", tv_recom_price7.getText().toString());
                startActivity(intent);
            }
        });

        img_recom8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img_recom8.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Log.v("test", String.valueOf(byteArray));
                Intent intent = new Intent(getApplicationContext(), Purchase.class);
                intent.putExtra("recom_img", byteArray);
                intent.putExtra("recom_name", tv_recom_name8.getText().toString());
                intent.putExtra("recom_price", tv_recom_price8.getText().toString());
                startActivity(intent);
            }
        });

        //
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }
        });

        // 메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        //
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