package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PAY_BAY extends AppCompatActivity {

    RadioGroup rg_rg;
    Button btn_pay;
    TextView bay_name1, tv_ga, bay_total;
    ImageView bay_img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bay);

        rg_rg=findViewById(R.id.rg_rg);
        btn_pay=findViewById(R.id.btn_pay);
        bay_name1 = findViewById(R.id.bay_name1);
        tv_ga = findViewById(R.id.tv_ga);
        bay_img1 = findViewById(R.id.bay_img1);
        bay_total = findViewById(R.id.bay_total);

        // 이미지, 이름, 가격 가져오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("paybay_name");
        String price = intent.getStringExtra("paybay_price");
        String total = intent.getStringExtra("paybay_total");
        byte[] byteArray = getIntent().getByteArrayExtra("paybay_img");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        bay_img1.setImageBitmap(bitmap);
        bay_name1.setText(name);
        tv_ga.setText(price);
        bay_total.setText(total);

        bay_name1.setText("도시락");
        tv_ga.setText("5000");
        bay_total.setText("7500");

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

        //결제하면 창 띄우기
        rg_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rd_3){

                    LinearLayout layout_g = findViewById(R.id.layout_g);
                    layout_g.setVisibility(View.VISIBLE);
                }else{

                }
            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"결제성공",Toast.LENGTH_SHORT).show();
            }
        });

    }
}