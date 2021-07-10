package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class Main extends AppCompatActivity {
    private Button btn_mu1,btn_mu2,btn_mu3,btn_mu4,btn_mu5,btn_mu6,btn_mu7,btn_mu8, btn_more1, btn_nv1, btn_nv2,btn_nv3;
    private ImageView ctgr,search1, shp1,img1,img2,img3,cir1,cir2,cir3,cir4,cir5,cir6;
    private TextView menu1,menu2,menu3,menu4,tv_lu_name1,tv_lu_name2,tv_lu_name3,tv_pa1,tv_pa2,tv_pa3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        btn_mu1=findViewById(R.id.btn_mu1);
        btn_mu2=findViewById(R.id.btn_mu2);
        btn_mu3=findViewById(R.id.btn_mu3);
        btn_mu4=findViewById(R.id.btn_mu4);
        btn_mu5=findViewById(R.id.btn_mu5);
        btn_mu6=findViewById(R.id.btn_mu6);
        btn_mu7=findViewById(R.id.btn_mu7);
        btn_mu8=findViewById(R.id.btn_mu8);
        btn_more1=findViewById(R.id.btn_more1);
        btn_nv1=findViewById(R.id.btn_nv1);
        btn_nv2=findViewById(R.id.btn_nv2);
        btn_nv3=findViewById(R.id.btn_nv3);

        //img
        ctgr=findViewById(R.id.ctgr);
        search1=findViewById(R.id.search1);
        shp1=findViewById(R.id.shp1);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        cir1=findViewById(R.id.cir1);
        cir2=findViewById(R.id.cir2);
        cir3=findViewById(R.id.cir3);
        cir4=findViewById(R.id.cir4);
        cir5=findViewById(R.id.cir5);
        cir6=findViewById(R.id.cir6);

        //text
        menu1=findViewById(R.id.menu1);
        menu2=findViewById(R.id.menu2);
        menu3=findViewById(R.id.menu3);
        menu4=findViewById(R.id.menu4);
        tv_lu_name1=findViewById(R.id.tv_lu_name1);
        tv_lu_name2=findViewById(R.id.tv_lu_name2);
        tv_lu_name3=findViewById(R.id.tv_lu_name3);
        tv_pa1=findViewById(R.id.tv_pa1);
        tv_pa2=findViewById(R.id.tv_pa2);
        tv_pa3=findViewById(R.id.tv_pa3);



        //장바구니 페이지 이동
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });

        //인기상품
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hot_item.class);
                startActivity(intent);
            }
        });

        //맞춤도시락
        btn_mu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Lunch_box_main.class);
                startActivity(intent);
            }
        });

        //프로틴
        btn_mu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Proteen.class);
                startActivity(intent);
            }
        });

        //일일 추천 더보기
        btn_more1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Today_lunch_box.class);
                startActivity(intent);
            }
        });

        //간편식
        btn_mu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Snack.class);
                startActivity(intent);
            }
        });

        //샐러드
        btn_mu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Salad.class);
                startActivity(intent);
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Purchase.class);
                intent.putExtra("sp1",tv_lu_name1.getText().toString());
                intent.putExtra("sp_pa1",tv_pa1.getText().toString());

                //이미지 넘기기
                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.main_img4);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image",byteArray);
                startActivity(intent);
            }
        });



    }
}