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
    private ImageView back1, search1, shp1,hot_img1,hot_img2,hot_img3;
    private Button top1,top2,top3,top4,top5,btn_nv1,btn_nv2,btn_nv3;
    private TextView hot_name1, hot_name2, hot_name3,hot_pa1,hot_pa2,hot_pa3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_item2);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);
        hot_img1 =findViewById(R.id.img_recom1);
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

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

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