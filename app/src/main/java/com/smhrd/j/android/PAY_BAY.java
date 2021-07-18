package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PAY_BAY extends AppCompatActivity {

    RadioGroup rg_rg;
    Button btn_pay;
    TextView bay_name1, tv_ga, bay_total;
    ImageView bay_img1;

    private LinearLayout layout_p3,layout_p,layout_p2,layout_g;

    private RequestQueue queue;
    private StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bay);

        //결제창 레이아웃
        layout_p3=findViewById(R.id.layout_p3);
        layout_p=findViewById(R.id.layout_p);
        layout_p2=findViewById(R.id.layout_p2);
        layout_g=findViewById(R.id.layout_g);


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

        bay_name1.setText("맞춤구성 영양소 도시락");
        tv_ga.setText("7500");
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

                if (checkedId == R.id.rd_3) {

//                    LinearLayout layout_g = findViewById(R.id.layout_g);
//                    layout_g.setVisibility(View.VISIBLE);
//                    LinearLayout layout_p2 =findViewById(R.id.layout_p2);
//                    layout_p2.setVisibility(View.VISIBLE);
                    layout_p2.setVisibility(View.VISIBLE);
                    layout_g.setVisibility(View.VISIBLE);

                } else if (checkedId == R.id.rd_2) {
                    layout_p3.setVisibility(View.GONE);
                    layout_p.setVisibility(View.GONE);

                } else if (checkedId == R.id.rd_1) {
                    layout_p3.setVisibility(View.GONE);
                    layout_p.setVisibility(View.GONE);

                }


            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
//                Intent intent = new Intent(getApplicationContext(),Main.class);
//                intent.putExtra("id", id);
//                intent.putExtra("name", user);
//                intent.putExtra("tel", tel);
//                intent.putExtra("address", address);
//                intent.putExtra("email", email);
//                intent.putExtra("status", status);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(),"결제성공",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendRequest() {

        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Order";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.v("order", response);
                    String value = jsonObject.getString("check");
                    if(value.equals("true")){
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                Intent intent = getIntent();
                String order_product = bay_name1.getText().toString();
                String order_name = intent.getStringExtra("name");
                String order_tel = intent.getStringExtra("tel");
                String order_address = intent.getStringExtra("address");
                String order_num = "1";
                String order_pay = "신용카드";
                String order_price = tv_ga.getText().toString();
                String order_transInfo = "문앞에 놓고 가주세요";
                String order_review = "좋아요";
                String id = intent.getStringExtra("id");

                params.put("order_product", order_product);
                params.put("order_name", order_name);
                params.put("order_tel", order_tel);
                params.put("order_address", order_address);
                params.put("order_num", order_num);
                params.put("order_pay", order_pay);
                params.put("order_price", order_price);
                params.put("order_transInfo", order_transInfo);
                params.put("order_review", order_review);
                params.put("id",id);

                return params;
            }
        };
        queue.add(stringRequest);
    }
}