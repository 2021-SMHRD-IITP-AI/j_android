package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Proteen extends AppCompatActivity {
    private Button btn_nv1, btn_nv2, btn_nv3, top1, top2, top3, top4, top5;
    private ImageView P_img1, P_img2, P_img3,P_img4, P_img5, P_img6, P_img7, P_img8 , shp1, back1;
    private TextView P_name1, P_name2, P_name3, P_name4, P_name5, P_name6, P_name7, P_name8,
            P_price1, P_price2, P_price3, P_price4, P_price5, P_price6, P_price7, P_price8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteen);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top1 = findViewById(R.id.top1);
        top2 = findViewById(R.id.top2);
        top3 = findViewById(R.id.top3);
        top4 = findViewById(R.id.top4);
        top5 = findViewById(R.id.top5);

        P_img1 = findViewById(R.id.P_img1);
        P_img2 = findViewById(R.id.P_img2);
        P_img3 = findViewById(R.id.P_img3);
        P_img4 = findViewById(R.id.P_img4);
        P_img5 = findViewById(R.id.P_img5);
        P_img6 = findViewById(R.id.P_img6);
        P_img7 = findViewById(R.id.P_img7);
        P_img8 = findViewById(R.id.P_img8);
        shp1=findViewById(R.id.shp1);
        back1 = findViewById(R.id.back1);

        P_price1 = findViewById(R.id.P_price1);
        P_price2 = findViewById(R.id.P_price2);
        P_price3 = findViewById(R.id.P_price3);
        P_price4 = findViewById(R.id.P_price4);
        P_price5 = findViewById(R.id.P_price5);
        P_price6 = findViewById(R.id.P_price6);
        P_price7 = findViewById(R.id.P_price7);
        P_price8 = findViewById(R.id.P_price8);

        P_name1 = findViewById(R.id.P_name1);
        P_name2 = findViewById(R.id.P_name2);
        P_name3 = findViewById(R.id.P_name3);
        P_name4 = findViewById(R.id.P_name4);
        P_name5 = findViewById(R.id.P_name5);
        P_name6 = findViewById(R.id.P_name6);
        P_name7 = findViewById(R.id.P_name7);
        P_name8 = findViewById(R.id.P_name8);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");


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
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });


        //건강일지
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //도시락
        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://222.102.104.135:3000/imgs/9chan.png";
                String url2 = "http://222.102.104.135:3000/imgs/bibim.png";
                String url3 = "http://222.102.104.135:3000/imgs/bul.png";
                String url4 = "http://222.102.104.135:3000/imgs/galic.png";
                String url5 = "http://222.102.104.135:3000/imgs/kimchi.png";
                String url6 = "http://222.102.104.135:3000/imgs/pork.png";
                String url7 = "http://222.102.104.135:3000/imgs/hotnuddle.png";
                String url8 = "http://222.102.104.135:3000/imgs/nuddle.png";

                String[] value = {url, url2, url3, url4, url5, url6, url7, url8};

                String url_name = "9가지 반찬 도시락";
                String url2_name = "알찬 비빔밥";
                String url3_name = "간장 불고기 잡곡 도시락";
                String url4_name = "마늘 소세지 도시락";
                String url5_name = "김치볶음밥";
                String url6_name = "삼겹살 현미 도시락";
                String url7_name = "매콤 쌀국수";
                String url8_name = "우동 쌀국수";

                String[] name = {url_name, url2_name, url3_name, url4_name, url5_name, url6_name, url7_name, url8_name};

                String url_price = "6000";
                String url2_price = "4900";
                String url3_price = "5500";
                String url4_price = "5200";
                String url5_price = "5000";
                String url6_price = "5700";
                String url7_price = "4500";
                String url8_price = "4500";

                String[] price = {url_price, url2_price, url3_price, url4_price, url5_price, url6_price, url7_price, url8_price};

                Intent intent = new Intent(getApplicationContext(), Recommend_lunch_box.class);
                intent.putExtra("imageUrl", value);
                intent.putExtra("imgName", name);
                intent.putExtra("imgPrice", price);

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //맞춤도시락
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lunch_box_main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //셀러드
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Salad.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //간편식
        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Snack.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //건강간식
        top5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Bar.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
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