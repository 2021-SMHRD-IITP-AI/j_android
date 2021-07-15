package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class MyPage extends AppCompatActivity {

    private Button btn_nv1, btn_nv2, btn_nv3, top6;
    private ImageView back1, search1, shp1;
    private TextView my_tv_name, my_tv_tel, my_tv_addr, my_tv_email;

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);
        top6 = findViewById(R.id.top6);

        my_tv_name = findViewById(R.id.my_tv_name);
        my_tv_tel = findViewById(R.id.my_tv_tel);
        my_tv_addr = findViewById(R.id.my_tv_addr);
        my_tv_email = findViewById(R.id.my_tv_email);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String tel = intent.getStringExtra("tel");
        String addr = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");

        my_tv_name.setText(name);
        my_tv_tel.setText(tel);
        my_tv_addr.setText(addr);
        my_tv_email.setText(email);

        top6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

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


        //건강일지
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
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

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
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

    private void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Exit";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("test5", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("test3", value);
                    if(value.equals("true")){
                        Toast.makeText(getApplicationContext(), "탈퇴되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);
                        Log.v("mypage","탈퇴성공");
                    }else{
                        Log.v("mypage", "탈퇴실패");
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
                String id = intent.getStringExtra("id");
                Log.v("exit", id);
                params.put("id", id);

                return params;
            }
        };
        queue.add(stringRequest);
    }
}